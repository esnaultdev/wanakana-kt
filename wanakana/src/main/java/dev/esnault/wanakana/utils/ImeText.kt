package dev.esnault.wanakana.utils

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
)
