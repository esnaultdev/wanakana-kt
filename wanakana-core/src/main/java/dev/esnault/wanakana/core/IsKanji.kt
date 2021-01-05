package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.extension.isKanji
import dev.esnault.wanakana.core.utils.Constants


internal fun isKanji(input: String): Boolean = input.all(Char::isKanji)

internal fun isKanji(input: Char): Boolean = input.toInt() in Constants.KANJI_RANGE
