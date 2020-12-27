package dev.esnault.wanakana.utils


fun applyMapping(input: String, map: MappingTree, convertEnding: Boolean): List<KanaToken> {
    val state = State(map, convertEnding)
    return newChunk(state, input, 0)
}

/**
 * State of the mapping.
 * @property tree The original [MappingTree].
 * @property convertEnding `true` if the ending should be converted.
 */
// TODO move remaining and cursors to this state?
private data class State(
    val tree: MappingTree,
    val convertEnding: Boolean
) {
    /**
     * The subTree of the current state.
     */
    var subTree: MappingTree? = tree
        private set

    /**
     * The portion of the original [String] that should be used as a default if there is no mapping.
     */
    var default: String = ""
        private set

    fun nextSubTree(nextChar: Char) {
        default += nextChar

        val subTree = this.subTree
        if (subTree is MappingTree.Branch) {
            this.subTree = subTree[nextChar]
        }
    }

    fun isAtTreeEnd(): Boolean = subTree == null || subTree is MappingTree.Leaf

    fun getTreeEndValue(): String = when (val subTree = subTree) {
        null -> default
        is MappingTree.Leaf -> subTree.value
        is MappingTree.Branch -> subTree.value ?: default
    }

    fun reset() {
        subTree = tree
        default = ""
    }
}

/**
 * Parses a new chunk of [remaining] and returns the corresponding list of [KanaToken]s.
 * @see applyMapping
 */
private fun newChunk(state: State, remaining: String, currentCursor: Int): List<KanaToken> {
    if (remaining.isEmpty()) return emptyList()

    // start parsing a new chunk
    val firstChar = remaining[0]
    state.reset()
    state.nextSubTree(firstChar)

    return parse(
        state,
        remaining.drop(1),
        currentCursor,
        currentCursor + 1
    )
}

/**
 * Parses a chunk of [remaining] and returns the corresponding list of [KanaToken].
 * @see applyMapping
 * @see newChunk
 */
private fun parse(
    state: State,
    remaining: String,
    lastCursor: Int,
    currentCursor: Int
): List<KanaToken> {
    if (remaining.isEmpty()) {
        if (state.convertEnding || state.isAtTreeEnd()) {
            // nothing more to consume, just commit the last chunk and return it
            // so as to not have an empty element at the end of the result
            val kana: String = state.getTreeEndValue()
            return listOf(KanaToken(lastCursor, currentCursor, kana))
        }

        // if we don't want to convert the ending, because there are still possible continuations
        // return null as the final node value
        return listOf(KanaToken(lastCursor, currentCursor, null))
    }

    if (state.isAtTreeEnd()) {
        val kana = state.getTreeEndValue()
        val kanaToken = KanaToken(lastCursor, currentCursor, kana)
        return listOf(kanaToken) + newChunk(state, remaining, currentCursor)
    }

    state.nextSubTree(remaining[0])
    val nextSubTree = state.subTree
    if (nextSubTree == null) {
        val kanaToken = KanaToken(lastCursor, currentCursor, state.default)
        return listOf(kanaToken) + newChunk(state, remaining, currentCursor)
    }
    // continue current branch
    return parse(state, remaining.drop(1), lastCursor, currentCursor + 1)
}

/**
 * Transforms a [map] containing a pseudo tree into a [MappingTree.Branch].
 * The [map] should contain [String]s for leaves and [Map]s as branches.
 *
 * This is used to easily build a [MappingTree].
 */
internal fun transform(map: Map<Char, Any>): MutableMappingTree.Branch {
    val values: MutableMap<Char, MutableMappingTree> = map.entries.fold(mutableMapOf()) { acc, entry ->
        val (char, subTree) = entry
        if (subTree is String) {
            acc[char] = MutableMappingTree.Leaf(subTree)
        } else {
            @Suppress("UNCHECKED_CAST")
            // We expect the input to be clean, since this is only used internally.
            acc[char] = transform(subTree as Map<Char, Any>)
        }
        acc
    }
    return MutableMappingTree.Branch(values)
}

/*
TODO: JS to convert

/**
 * Creates a custom mapping tree, returns a function that accepts a defaultMap which the newly created customMapping will be merged with and returned
 * (customMap) => (defaultMap) => mergedMap
 * @param  {Object} customMap { 'ka' : 'な' }
 * @return {Function} (defaultMap) => defaultMergedWithCustomMap
 * @example
 * const sillyMap = createCustomMapping({ 'ちゃ': 'time', '茎': 'cookie'　});
 * // sillyMap is passed defaultMapping to merge with when called in toRomaji()
 * toRomaji("It's 茎 ちゃ よ", { customRomajiMapping: sillyMap });
 * // => 'It's cookie time yo';
 */
export function createCustomMapping(customMap = {}) {
    const customTree = {};

    if (typeOf(customMap) === 'object') {
        Object.entries(customMap).forEach(([roma, kana]) => {
            let subTree = customTree;
            roma.split('').forEach((char) => {
                if (subTree[char] === undefined) {
                    subTree[char] = {};
                }
                subTree = subTree[char];
            });
            subTree[''] = kana;
        });
    }

    return function makeMap(map) {
        const mapCopy = JSON.parse(JSON.stringify(map));

        function transformMap(mapSubtree, customSubtree) {
        if (mapSubtree === undefined || typeOf(mapSubtree) === 'string') {
            return customSubtree;
        }
        return Object.entries(customSubtree).reduce((newSubtree, [char, subtree]) => {
        newSubtree[char] = transformMap(mapSubtree[char], subtree);
        return newSubtree;
    }, mapSubtree);
    }

        return transformMap(mapCopy, customTree);
    };
}

// allow consumer to pass either function or object as customMapping
export function mergeCustomMapping(map, customMapping) {
    if (!customMapping) {
        return map;
    }
    return typeOf(customMapping) === 'function'
    ? customMapping(map)
    : createCustomMapping(customMapping)(map);
}
*/
