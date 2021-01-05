package dev.esnault.wanakana.core.utils

/**
 * A typed text, with cursor information.
 * This is used to preserve the cursor information when converting in IME mode.
 *
 * @property text the typed text.
 * @property selection the cursor/selection of the text. It's a cursor if both start and end values
 * are the same. If there is no cursor/selection, both start and end values are -1.
 */
data class ImeText(
    val text: String,
    val selection: IntRange
) {

    /**
     * Secondary constructor (meant for Java).
     *
     * @param text the typed text.
     * @param start the cursor/selection start, or -1 if there is no cursor/selection.
     * @param end the cursor/selection end (inclusive), or -1 if there is no cursor/selection. If
     * the [end] is equals to the [start], it's a cursor, otherwise it's a selection.
     */
    constructor(text: String, start: Int, end: Int) : this(text, start..end)
}
