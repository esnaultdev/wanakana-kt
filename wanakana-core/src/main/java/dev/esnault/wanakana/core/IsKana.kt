package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.extension.isKana


internal fun isKana(input: String): Boolean = input.all(Char::isKana)

internal fun isKana(input: Char): Boolean = isHiragana(input) || isKatakana(input)
