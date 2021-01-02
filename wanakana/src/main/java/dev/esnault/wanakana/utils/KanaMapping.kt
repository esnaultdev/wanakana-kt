package dev.esnault.wanakana.utils


fun applyMapping(input: String, map: MappingTree, convertEnding: Boolean): List<ConversionToken> {
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
     * The original [String] of the current descent.
     */
    private var original: String = ""

    /**
     * The `value` of the previous node, if any.
     */
    private var previousValue: String? = null

    fun nextSubTree(nextChar: Char) {
        original += nextChar
        when (val subTree = this.subTree) {
            null -> previousValue = null
            else -> {
                this.subTree = subTree[nextChar]
                previousValue = subTree.value
            }
        }
    }

    fun isAtTreeEnd(): Boolean = subTree?.hasSubTree() != true

    fun getCurrentValue(rollbackOne: Boolean = false): String {
        val currentOrPrevious = subTree?.value ?: previousValue
        return when {
            currentOrPrevious != null -> currentOrPrevious
            rollbackOne -> original.dropLast(1)
            else -> original
        }
    }

    fun reset() {
        subTree = tree
        original = ""
        previousValue = null
    }
}

/**
 * Parses a new chunk of [remaining] and returns the corresponding list of [ConversionToken]s.
 * @see applyMapping
 */
private fun newChunk(state: State, remaining: String, currentCursor: Int): List<ConversionToken> {
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
 * Parses a chunk of [remaining] and returns the corresponding list of [ConversionToken].
 * @see applyMapping
 * @see newChunk
 */
private fun parse(
    state: State,
    remaining: String,
    lastCursor: Int,
    currentCursor: Int
): List<ConversionToken> {
    if (remaining.isEmpty()) {
        if (state.convertEnding || state.isAtTreeEnd()) {
            // nothing more to consume, just commit the last chunk and return it
            // so as to not have an empty element at the end of the result
            val kana: String = state.getCurrentValue()
            return listOf(ConversionToken(lastCursor, currentCursor, kana))
        }

        // if we don't want to convert the ending, because there are still possible continuations
        // return null as the final node value
        return listOf(ConversionToken(lastCursor, currentCursor, null))
    }

    if (state.isAtTreeEnd()) {
        val value = state.getCurrentValue()
        val token = ConversionToken(lastCursor, currentCursor, value)
        return listOf(token) + newChunk(state, remaining, currentCursor)
    }

    state.nextSubTree(remaining[0])
    val nextSubTree = state.subTree
    if (nextSubTree == null) {
        val token = ConversionToken(lastCursor, currentCursor, state.getCurrentValue(true))
        return listOf(token) + newChunk(state, remaining, currentCursor)
    }
    // continue current branch
    return parse(state, remaining.drop(1), lastCursor, currentCursor + 1)
}
