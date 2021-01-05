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
            return correctRange(newFirst, currentSize, selection)
        }

        currentSize += token.value?.length ?: (tokenEnd - tokenStart)

        if (selection.last < tokenEnd) {
            return correctRange(newFirst, currentSize, selection)
        }
    }

    // The end of the selection is at the end of the new text.
    return if (newFirst != -1) {
        correctRange(newFirst, currentSize, selection)
    } else {
        currentSize..currentSize
    }
}


@Suppress("NOTHING_TO_INLINE")
private inline fun correctRange(newFirst: Int, newLast: Int, selection: IntRange): IntRange {
    return if (selection.first == selection.last) {
        // If the original selection was a cursor, we need to output a cursor too.
        // Depending on the original placement of the cursor, newFirst could create a selection.
        // Let's just return a cursor to the right.
        newLast..newLast
    } else {
        newFirst..newLast
    }
}
