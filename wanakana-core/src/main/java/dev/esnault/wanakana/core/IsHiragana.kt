package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.utils.Constants
import dev.esnault.wanakana.core.utils.isLongDash


internal fun isHiragana(input: String): Boolean = input.all(::isHiragana)

internal fun isHiragana(input: Char): Boolean {
    if (input.isLongDash()) return true
    return input.toInt() in Constants.HIRAGANA_RANGE
}
