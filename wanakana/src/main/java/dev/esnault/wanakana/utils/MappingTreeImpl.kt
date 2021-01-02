package dev.esnault.wanakana.utils

import java.lang.IllegalArgumentException


/**
 * Default implementation of a [MappingTree].
 */
internal data class MappingTreeImpl(
    val children: Map<Char, MappingTree>? = null,
    override val value: String? = null
) : MappingTree {
    override operator fun get(key: Char): MappingTree? = children?.get(key)

    override fun hasSubTree(): Boolean = children?.isNotEmpty() == true

    override val subTrees = children

    override fun toMutableMappingTree(): MutableMappingTree =
        mutableMappingTreeOf(value = value).also { newTree ->
            children?.forEach { (key, value) ->
                newTree[key] = value.toMutableMappingTree()
            }
        }

    override fun duplicate(): MappingTree =
        mappingTreeOf(
            subTrees = children?.mapValues { (_, value) -> value.duplicate() },
            value = value
        )
}

/**
 * Default implementation of a [MutableMappingTree].
 */
internal class MutableMappingTreeImpl(override var value: String? = null) : MutableMappingTree {
    private val childrenDelegate = lazy { mutableMapOf<Char, MutableMappingTree>() }
    private val children: MutableMap<Char, MutableMappingTree> by childrenDelegate

    override fun hasSubTree(): Boolean = childrenDelegate.isInitialized() && children.isNotEmpty()

    override val subTrees: MutableMap<Char, MutableMappingTree>
        get() = children

    override fun subTreeOf(str: String): MutableMappingTree {
        if (str.isEmpty()) return this
        if (str.length == 1) {
            val char = str.first()
            return children[char] ?: mutableMappingTreeOf().also { children[char] = it }
        }
        return str.toCharArray().fold<MutableMappingTree>(initial = this) { result, char ->
            result[char] ?: mutableMappingTreeOf().also { result[char] = it }
        }
    }

    override fun replaceSubTreeOf(str: String, newSubTree: MutableMappingTree) {
        if (str.isEmpty()) emptyReference()
        val lastChar = str.last()
        val toUpdate = subTreeOf(str.dropLast(1))
        toUpdate[lastChar] = newSubTree
    }

    override fun setSubTreeValue(str: String, value: String) {
        val toUpdate = subTreeOf(str)
        toUpdate.value = value
    }

    override fun duplicate(): MutableMappingTree =
        mutableMappingTreeOf(value = value).also { newTree ->
            children.forEach { (char, subTree) ->
                newTree[char] = subTree.duplicate()
            }
        }

    override fun toMappingTree(): MappingTree =
        mappingTreeOf(
            subTrees = children.mapValues { (_, value) -> value.toMappingTree() },
            value = value
        )

    override fun toMutableMappingTree(): MutableMappingTree = this
}

@Suppress("NOTHING_TO_INLINE")
internal inline fun emptyReference(): Nothing =
    throw IllegalArgumentException("An empty string is not a valid subTree reference.")
