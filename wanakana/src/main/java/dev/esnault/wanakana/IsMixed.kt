package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isKana
import dev.esnault.wanakana.extension.isKanji
import dev.esnault.wanakana.extension.isRomaji


internal fun isMixed(input: String, passKanji: Boolean = true): Boolean {
    val hasKanji = if (!passKanji) input.any(Char::isKanji) else false
    return !hasKanji && input.any(Char::isKana) && input.any(Char::isRomaji)
}
