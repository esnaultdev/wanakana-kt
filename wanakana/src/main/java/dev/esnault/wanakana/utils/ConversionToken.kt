package dev.esnault.wanakana.utils

/**
 * The result of the conversion of a chunk of text.
 * @property start the inclusive start of the converted text in the original string.
 * @property end the exclusive end of the converted text in the original string.
 * @property value the converted text, can be `null` in IMEMode for the end of the original text.
 */
data class ConversionToken(
    val start: Int,
    val end: Int,
    val value: String?
) {
    val range: IntRange = start until end
}
