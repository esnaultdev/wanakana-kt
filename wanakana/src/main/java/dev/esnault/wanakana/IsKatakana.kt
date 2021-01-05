package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isKatakana
import dev.esnault.wanakana.utils.Constants

internal fun isKatakana(input: String): Boolean = input.all(Char::isKatakana)

internal fun isKatakana(input: Char): Boolean =
    input.toInt() in Constants.KATAKANA_RANGE
