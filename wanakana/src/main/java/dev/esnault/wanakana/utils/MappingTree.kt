package dev.esnault.wanakana.utils

/**
 * A mapping tree used to map a [String] to another [String].
 */
sealed class MappingTree {
    /**
     * An intermediary node of the tree.
     * @property children the sub trees.
     * @property value a value that can be used for conversion.
     */
    data class Branch(
        private val children: Map<Char, MappingTree>,
        val value: String? = null
    ) : MappingTree() {
        operator fun get(key: Char): MappingTree? = children[key]
    }

    data class Leaf(val value: String) : MappingTree()
}

/**
 * A mutable [MappingTree], used to build a [MappingTree].
 */
sealed class MutableMappingTree {
    data class Branch(
        val children: MutableMap<Char, MutableMappingTree>,
        var value: String? = null
    ) : MutableMappingTree() {
        operator fun get(key: Char): MutableMappingTree? = children[key]
        operator fun set(key: Char, child: MutableMappingTree) {
            children[key] = child
        }

        /**
         * Returns a [Branch] addressed by [str].
         * Builds the relevant [Branch]es along the way.
         */
        fun subTreeOf(str: String): Branch {
            return str.toCharArray().fold(initial = this) { result, char ->
                when (val subTree = result[char]) {
                    null -> Branch(mutableMapOf()).also { result[char] = it }
                    is Branch -> subTree
                    is Leaf -> subTree.toBranch().also { result[char] = it }
                }
            }
        }

        /**
         * Updates a sub tree addressed by [str], with the [newSubTree].
         */
        fun updateSubTreeOf(str: String, newSubTree: MutableMappingTree): MutableMappingTree {
            val lastChar = str.last()
            val toUpdate: Branch = subTreeOf(str.dropLast(1))
            toUpdate[lastChar] = newSubTree
            return newSubTree
        }

        /**
         * Updates the node addressed by [str] to set its value to [value].
         */
        fun setSubTreeValue(str: String, value: String): MutableMappingTree {
            val lastChar = str.last()
            val toUpdate: Branch = subTreeOf(str.dropLast(1))
            return when (val currentNode = toUpdate[lastChar]) {
                null -> Leaf(value).also { toUpdate[lastChar] = it }
                is Leaf -> {
                    currentNode.value = value
                    currentNode
                }
                is Branch -> {
                    currentNode.value = value
                    currentNode
                }
            }
        }
    }

    data class Leaf(var value: String) : MutableMappingTree() {
        fun toBranch(): Branch = Branch(mutableMapOf(), value)
    }

    fun duplicate(): MutableMappingTree = when (this) {
        is Branch -> {
            val children = children.mapValuesTo(mutableMapOf()) { (_, value) -> value.duplicate() }
            copy(children = children)
        }
        is Leaf -> copy()
    }

    fun toMappingTree(): MappingTree = when (this) {
        is Branch -> MappingTree.Branch(
            children = children.mapValues { (_, value) -> value.toMappingTree() },
            value = value
        )
        is Leaf -> MappingTree.Leaf(value)
    }
}
