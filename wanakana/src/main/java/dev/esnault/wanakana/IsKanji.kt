package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isKanji
import dev.esnault.wanakana.utils.Constants


internal fun isKanji(input: String): Boolean = input.all(Char::isKanji)

internal fun isKanji(input: Char): Boolean = input.toInt() in Constants.KANJI_RANGE
