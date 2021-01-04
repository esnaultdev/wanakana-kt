package dev.esnault.wanakana.utils

import kotlin.IllegalArgumentException

/**
 * A mapping tree used to map a [String] to another [String].
 */
abstract class MappingTree {
    /**
     * A value that can be used for conversion at this level of the tree.
     */
    abstract val value: String?

    /**
     * The subTrees that can be used to continue the conversion.
     */
    abstract val subTrees: Map<Char, MappingTree>?

    /**
     * Returns the subTree referenced by [key], if any.
     */
    open operator fun get(key: Char): MappingTree? = subTrees?.get(key)

    /**
     * Returns `true` if this has any subTree.
     */
    abstract fun hasSubTree(): Boolean

    /**
     * Returns a mutable version of this tree.
     * The returned tree is not guaranteed to be a new tree, use [duplicate] if needed.
     */
    abstract fun toMutableMappingTree(): MutableMappingTree

    /**
     * Returns a deep copy of this tree.
     * This returns the same tree for read only trees.
     */
    abstract fun duplicate(): MappingTree

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

    companion object {
        /**
         * Returns a read-only [MappingTree] with the given [value] and [subTrees].
         * This is intended for Java users, Kotlin users can use [mappingTreeOf] directly.
         */
        @JvmStatic
        @JvmOverloads
        fun of(value: String? = null, subTrees: Map<Char, MappingTree>? = null): MappingTree =
            mappingTreeOf(value, subTrees)
    }
}

/**
 * A mutable [MappingTree], used to build a [MappingTree].
 */
abstract class MutableMappingTree : MappingTree() {
    /**
     * A value that can be used for conversion at this level of the tree.
     */
    abstract override var value: String?

    /**
     * The subTrees that can be used to continue the conversion.
     */
    abstract override val subTrees: MutableMap<Char, MutableMappingTree>

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
     * Returns a read-only version of this tree.
     */
    abstract fun toMappingTree(): MappingTree

    /**
     * Returns a deep copy of this tree.
     */
    abstract override fun duplicate(): MutableMappingTree

    /**
     * Returns a subTree addressed by [str].
     * Builds the relevant subTrees along the way.
     */
    abstract fun subTreeOf(str: String): MutableMappingTree

    /**
     * Replace a subTree addressed by [str] with [newSubTree].
     * Builds the relevant subTrees along the way.
     */
    abstract fun replaceSubTreeOf(str: String, newSubTree: MutableMappingTree)

    /**
     * Updates the subTree addressed by [str] to set its value to [value].
     * Builds the relevant subTrees along the way.
     */
    abstract fun setSubTreeValue(str: String, value: String)

    /**
     * Updates the tree using a DSL.
     * See [mapping] for more information.
     */
    fun update(block: MappingBuilder.() -> Unit) {
        MappingBuilder(this).block()
    }

    companion object {
        /**
         * Returns a [MutableMappingTree] with the given [value] and [subTrees].
         * This is intended for Java users, Kotlin users can use [mutableMappingTreeOf] directly.
         */
        @JvmStatic
        @JvmOverloads
        fun of(
            value: String? = null,
            subTrees: Map<Char, MutableMappingTree>? = null
        ): MutableMappingTree = mutableMappingTreeOf(value, subTrees)
    }
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
 * A builder of [MutableMappingTree].
 * For Kotlin users, this class should be transparent if used from the [mapping] DSL.
 * For Java users, you can use this class directly to build a [MutableMappingTree].
 */
class MappingBuilder(internal val tree: MutableMappingTree = mutableMappingTreeOf()) {
    /**
     * The value that can be used for conversion at this level of the tree.
     */
    var value: String?
        get() = tree.value
        set(value) { tree.value = value }

    /**
     * Adds a mapping for this char to [value].
     */
    infix fun Char.to(value: String): MappingBuilder {
        tree.setSubTreeValue(this.toString(), value)
        return this@MappingBuilder
    }

    /**
     * Adds a mapping for this string to [value].
     * This will create subTrees as needed.
     *
     * @throws IllegalArgumentException if this string is empty.
     */
    @Throws(IllegalArgumentException::class)
    infix fun String.to(value: String): MappingBuilder {
        if (this.isEmpty()) emptyReference()
        tree.setSubTreeValue(this, value)
        return this@MappingBuilder
    }

    /**
     * Adds a mapping for this char to [value].
     */
    infix fun Char.to(value: Char): MappingBuilder {
        tree[this] = mutableMappingTreeOf(value = value.toString())
        return this@MappingBuilder
    }

    /**
     * Adds a mapping for this string to [value].
     * This will create subTrees as needed.
     *
     * @throws IllegalArgumentException if this string is empty.
     */
    @Throws(IllegalArgumentException::class)
    infix fun String.to(value: Char): MappingBuilder {
        if (this.isEmpty()) emptyReference()
        tree.setSubTreeValue(this, value.toString())
        return this@MappingBuilder
    }

    /**
     * Adds a mapping for this char to [subTree].
     * This will create subTrees as needed.
     * Any existing tree at the last tree level will be replaced. Use [merge] instead if you want
     * to preserve any existing mapping at this level.
     */
    infix fun Char.to(subTree: MutableMappingTree): MappingBuilder {
        tree[this] = subTree
        return this@MappingBuilder
    }

    /**
     * Adds a mapping for this string to [subTree].
     * This will create subTrees as needed.
     * Any existing tree at the last tree level will be replaced. Use [merge] instead if you want
     * to preserve any existing mapping at this level.
     *
     * @throws IllegalArgumentException if this string is empty.
     */
    @Throws(IllegalArgumentException::class)
    infix fun String.to(subTree: MutableMappingTree): MappingBuilder {
        if (this.isEmpty()) emptyReference()
        tree.replaceSubTreeOf(this, subTree)
        return this@MappingBuilder
    }

    /**
     * Adds a mapping for this char to [subTree].
     * This will create subTrees as needed.
     * If another mapping exists for the last tree level, it will be merged with it. The value of
     * [subTree] will have precedence over any existing mapping.
     * Use [to] instead if you want to replace any existing mapping at this level.
     */
    infix fun Char.merge(subTree: MutableMappingTree): MappingBuilder {
        subTree.mergeInto(tree.subTreeOf(this.toString()))
        return this@MappingBuilder
    }

    /**
     * Adds a mapping for this char to [subTree].
     * This will create subTrees as needed.
     * If another mapping exists for the last tree level, it will be merged with it. The value of
     * [subTree] will have precedence over any existing mapping.
     * Use [to] instead if you want to replace any existing mapping at this level.
     *
     * @throws IllegalArgumentException if this string is empty.
     */
    @Throws(IllegalArgumentException::class)
    infix fun String.merge(subTree: MutableMappingTree): MappingBuilder {
        if (this.isEmpty()) emptyReference()
        subTree.mergeInto(tree.subTreeOf(this))
        return this@MappingBuilder
    }

    inline infix fun <reified A, reified B> A.to(value: B) {
        // Invalid types, we can't add them to the mapping.
        // Since there is an infix `to` as part of the stdlib, it will still compile. Let's throw
        // an exception as otherwise it would be hard to detect why the mapping is incomplete.
        throw IllegalArgumentException(
            "Invalid mapping types: ${A::class.simpleName} to ${B::class.simpleName}"
        )
    }

    // Java interface

    /**
     * Sets the value that can be used for conversion at this level of the tree.
     */
    fun value(value: String?): MappingBuilder {
        tree.value = value
        return this
    }

    /**
     * Builds the [MutableMappingTree] from this builder.
     */
    fun build(): MutableMappingTree = tree
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
fun mapping(init: MappingBuilder.() -> Unit): MutableMappingTree {
    val builder = MappingBuilder()
    builder.init()
    return builder.tree
}
