package dev.esnault.wanakana

import dev.esnault.wanakana.utils.Constants
import dev.esnault.wanakana.utils.isLongDash


internal fun isHiragana(input: String): Boolean = input.all(::isHiragana)

internal fun isHiragana(input: Char): Boolean {
    if (input.isLongDash()) return true
    return input.toInt() in Constants.HIRAGANA_RANGE
}
