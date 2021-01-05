package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.extension.isKana
import dev.esnault.wanakana.core.extension.isKanji
import dev.esnault.wanakana.core.extension.isRomaji


internal fun isMixed(input: String, passKanji: Boolean = true): Boolean {
    val hasKanji = if (!passKanji) input.any(Char::isKanji) else false
    return !hasKanji && input.any(Char::isKana) && input.any(Char::isRomaji)
}
