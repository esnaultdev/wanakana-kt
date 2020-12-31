package dev.esnault.wanakana.utils

import java.lang.IllegalArgumentException

/**
 * A mapping tree used to map a [String] to another [String].
 * @property value a value that can be used for conversion.
 */
class MappingTree(
    private val children: Map<Char, MappingTree>? = null,
    val value: String? = null
) {
    operator fun get(key: Char): MappingTree? = children?.get(key)

    fun hasChildren(): Boolean = children?.isNotEmpty() == true
}

/**
 * A mutable [MappingTree], used to build a [MappingTree].
 */
class MutableMappingTree(var value: String? = null) {
    private val childrenDelegate = lazy { mutableMapOf<Char, MutableMappingTree>() }
    val children: MutableMap<Char, MutableMappingTree> by childrenDelegate

    operator fun get(key: Char): MutableMappingTree? = children[key]
    operator fun set(key: Char, child: MutableMappingTree) {
        children[key] = child
    }

    fun hasChildren(): Boolean = childrenDelegate.isInitialized() && children.isNotEmpty()

    /**
     * Returns a subTree addressed by [str].
     * Builds the relevant subTrees along the way.
     */
    fun subTreeOf(str: String): MutableMappingTree {
        if (str.isEmpty()) return this
        if (str.length == 1) {
            val char = str.first()
            return children[char] ?: MutableMappingTree().also { children[char] = it }
        }
        return str.toCharArray().fold(initial = this) { result, char ->
            result[char] ?: MutableMappingTree().also { result[char] = it }
        }
    }

    /**
     * Replace a subTree addressed by [str] with [newSubTree].
     * Builds the relevant subTrees along the way.
     */
    fun replaceSubTreeOf(str: String, newSubTree: MutableMappingTree) {
        if (str.isEmpty()) emptyReference()
        val lastChar = str.last()
        val toUpdate = subTreeOf(str.dropLast(1))
        toUpdate[lastChar] = newSubTree
    }

    /**
     * Updates the subTree addressed by [str] to set its value to [value].
     * Builds the relevant subTrees along the way.
     * @return the updated subTree.
     */
    fun setSubTreeValue(str: String, value: String): MutableMappingTree {
        val toUpdate = subTreeOf(str)
        toUpdate.value = value
        return toUpdate
    }

    /**
     * Returns a deep copy of this tree.
     */
    fun duplicate(): MutableMappingTree =
        MutableMappingTree().also { newTree ->
            newTree.value = value
            children.forEach { (char, subTree) ->
                newTree[char] = subTree.duplicate()
            }
        }

    /**
     * Returns a read-only version of this tree.
     */
    fun toMappingTree(): MappingTree =
        MappingTree(
            children = children.mapValues { (_, value) -> value.toMappingTree() },
            value = value
        )

    fun mergeInto(other: MutableMappingTree) {
        other.value = value
        children.forEach { (char, subTree) ->
            val otherSubTree = other[char]
            if (otherSubTree == null) {
                other[char] = subTree
            } else {
                subTree.mergeInto(otherSubTree)
            }
        }
    }
}

class MappingTreeBuilder(internal val tree: MutableMappingTree = MutableMappingTree()) {
    var value: String? = null

    infix fun Char.to(value: String) {
        tree.setSubTreeValue(this.toString(), value)
    }

    infix fun String.to(value: String) {
        if (this.isEmpty()) emptyReference()
        tree.setSubTreeValue(this, value)
    }

    infix fun Char.to(value: Char) {
        tree[this] = MutableMappingTree(value = value.toString())
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

fun mapping(init: MappingTreeBuilder.() -> Unit): MutableMappingTree {
    val builder = MappingTreeBuilder()
    builder.init()
    return builder.tree
}

@Suppress("NOTHING_TO_INLINE")
private inline fun emptyReference(): Nothing =
    throw IllegalArgumentException("An empty string is not a valid subTree reference.")
