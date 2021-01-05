package dev.esnault.wanakana.utils


/**
 * Returns a text selection of the [tokens] based on the original text's [selection].
 */
internal fun matchSelection(selection: IntRange, tokens: List<ConversionToken>): IntRange {
    if (selection.first < 0 || selection.last < 0) return -1..-1
    if (selection == 0..0 || tokens.isEmpty()) return 0..0 // 0w0

    var currentSize = 0 // Size of the new text, at the current token
    var newFirst = -1

    tokens.forEach { token ->
        val tokenStart = token.range.first
        val tokenEnd = token.end // end exclusive

        if (newFirst == -1 && selection.first < tokenEnd) {
            newFirst = currentSize
        }
        if (selection.last == tokenStart) {
            return newFirst..currentSize
        }

        currentSize += token.value?.length ?: (tokenEnd - tokenStart)

        if (selection.last < tokenEnd) {
            return newFirst..currentSize
        }
    }

    // The end of the selection is at the end of the new text.
    return if (newFirst != -1) {
        newFirst..currentSize
    } else {
        currentSize..currentSize
    }
}
