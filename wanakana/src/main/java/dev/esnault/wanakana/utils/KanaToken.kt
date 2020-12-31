package dev.esnault.wanakana.utils

// TODO Rename KanaToken + kana
data class KanaToken(
    val start: Int,
    val end: Int,
    val kana: String?
) {
    val range: IntRange = start until end
}
