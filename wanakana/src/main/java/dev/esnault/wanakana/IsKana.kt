package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isKana


internal fun isKana(input: String): Boolean = input.all(Char::isKana)

internal fun isKana(input: Char): Boolean = isHiragana(input) || isKatakana(input)
