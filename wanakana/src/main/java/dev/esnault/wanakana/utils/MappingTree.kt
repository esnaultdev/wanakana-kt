package dev.esnault.wanakana.utils

import java.lang.IllegalArgumentException

/**
 * A mapping tree used to map a [String] to another [String].
 */
interface MappingTree {
    /**
     * A value that can be used for conversion at this level of the tree.
     */
    val value: String?

    /**
     * The subTrees that can be used to continue the conversion.
     */
    val subTrees: Map<Char, MappingTree>?

    /**
     * Returns the subTree referenced by [key], if any.
     */
    operator fun get(key: Char): MappingTree? = subTrees?.get(key)

    /**
     * Returns `true` if this has any subTree.
     */
    fun hasSubTree(): Boolean

    /**
     * Returns a mutable version of this tree.
     * The returned tree is not guaranteed to be a new tree, use [duplicate] if needed.
     */
    fun toMutableMappingTree(): MutableMappingTree

    /**
     * Returns a deep copy of this tree.
     */
    fun duplicate(): MappingTree

    /**
     * Returns a new [MappingTree] that contains both mappings from this and the [other] tree.
     * When two values conflict, the mapping of this tree is used over the other.
     */
    fun mergeWith(other: MappingTree): MappingTree {
        return other.duplicate().toMutableMappingTree().also { this.mergeInto(it) }
    }

    /**
     * Merge this tree into the [other].
     * The [other] tree will be updated to include the mapping of this tree.
     * When two values conflict, the mapping of this tree replaces the other.
     */
    fun mergeInto(other: MutableMappingTree) {
        other.value = value
        if (!hasSubTree()) return
        subTrees?.forEach { (char, subTree) ->
            val otherSubTree = other[char]
            if (otherSubTree == null) {
                other[char] = subTree.toMutableMappingTree()
            } else {
                subTree.mergeInto(otherSubTree)
            }
        }
    }
}

/**
 * A mutable [MappingTree], used to build a [MappingTree].
 */
interface MutableMappingTree : MappingTree {
    /**
     * A value that can be used for conversion at this level of the tree.
     */
    override var value: String?

    /**
     * The subTrees that can be used to continue the conversion.
     */
    override val subTrees: MutableMap<Char, MutableMappingTree>

    /**
     * Returns the subTree referenced by [key], if any.
     */
    override operator fun get(key: Char): MutableMappingTree? = subTrees[key]

    /**
     * Replaces the subTree referenced by [key] with [subTree].
     */
    operator fun set(key: Char, subTree: MutableMappingTree) {
        subTrees[key] = subTree
    }

    /**
     * Returns a deep copy of this tree.
     */
    override fun duplicate(): MutableMappingTree

    /**
     * Returns a subTree addressed by [str].
     * Builds the relevant subTrees along the way.
     */
    fun subTreeOf(str: String): MutableMappingTree

    /**
     * Replace a subTree addressed by [str] with [newSubTree].
     * Builds the relevant subTrees along the way.
     */
    fun replaceSubTreeOf(str: String, newSubTree: MutableMappingTree)

    /**
     * Updates the subTree addressed by [str] to set its value to [value].
     * Builds the relevant subTrees along the way.
     */
    fun setSubTreeValue(str: String, value: String)

    /**
     * Returns a read-only version of this tree.
     */
    fun toMappingTree(): MappingTree
}

/**
 * Returns a read-only [MappingTree] with the given [value] and [subTrees].
 */
fun mappingTreeOf(value: String? = null, subTrees: Map<Char, MappingTree>? = null): MappingTree =
    MappingTreeImpl(value = value, children = subTrees)

/**
 * Returns a [MutableMappingTree] with the given [value] and [subTrees].
 */
fun mutableMappingTreeOf(
    value: String? = null,
    subTrees: Map<Char, MutableMappingTree>? = null
): MutableMappingTree = MutableMappingTreeImpl(value = value).also { newTree ->
    subTrees?.forEach { (char, subTree) ->
        newTree[char] = subTree
    }
}

/**
 * A builder of [MutableMappingTree], used by the [mapping] DSL.
 */
class MappingTreeBuilder(internal val tree: MutableMappingTree = mutableMappingTreeOf()) {
    var value: String?
        get() = tree.value
        set(value) { tree.value = value }

    infix fun Char.to(value: String) {
        tree.setSubTreeValue(this.toString(), value)
    }

    infix fun String.to(value: String) {
        if (this.isEmpty()) emptyReference()
        tree.setSubTreeValue(this, value)
    }

    infix fun Char.to(value: Char) {
        tree[this] = mutableMappingTreeOf(value = value.toString())
    }

    infix fun String.to(value: Char) {
        if (this.isEmpty()) emptyReference()
        tree.setSubTreeValue(this, value.toString())
    }

    infix fun Char.to(subTree: MutableMappingTree) {
        tree[this] = subTree
    }

    infix fun String.to(subTree: MutableMappingTree) {
        if (this.isEmpty()) emptyReference()
        tree.replaceSubTreeOf(this, subTree)
    }

    infix fun Char.merge(subTree: MutableMappingTree) {
        subTree.mergeInto(tree.subTreeOf(this.toString()))
    }

    infix fun String.merge(subTree: MutableMappingTree) {
        if (this.isEmpty()) emptyReference()
        subTree.mergeInto(tree.subTreeOf(this))
    }

    inline infix fun <reified A, reified B> A.to(value: B) {
        // Invalid types, we can't add them to the mapping.
        // Since there is an infix `to` as part of the stdlib, it will still compile. Let's throw
        // an exception as otherwise it would be hard to detect why the mapping is incomplete.
        throw IllegalArgumentException(
            "Invalid mapping types: ${A::class.simpleName} to ${B::class.simpleName}"
        )
    }
}

/**
 * Returns a [MappingTree], built using a DSL.
 * The syntax is similar to `mapOf()` using an infix `to` to add to the tree.
 * Keys can be [Char] or [String], and values can be [Char] or [String] or a [mapping].
 *
 * For example:
 * ```
 *  mapping {
 *      'n' to 'ん'; "n'" to 'ん'
 *  }
 * ```
 * is equivalent to
 * ```
 *  mapping {
 *      'n' to "ん"; "n'" to "ん"
 *  }
 * ```
 * and equivalent to
 * ```
 *  mapping {
 *      'n' to mapping {
 *          value = "ん"
 *          "'" to "ん"
 *      }
 *  }
 * ```
 */
fun mapping(init: MappingTreeBuilder.() -> Unit): MutableMappingTree {
    val builder = MappingTreeBuilder()
    builder.init()
    return builder.tree
}
