package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.extension.isKatakana
import dev.esnault.wanakana.core.utils.Constants

internal fun isKatakana(input: String): Boolean = input.all(Char::isKatakana)

internal fun isKatakana(input: Char): Boolean =
    input.toInt() in Constants.KATAKANA_RANGE
