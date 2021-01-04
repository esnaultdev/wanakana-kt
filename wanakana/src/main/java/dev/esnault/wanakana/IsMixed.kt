package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isKana
import dev.esnault.wanakana.extension.isKanji
import dev.esnault.wanakana.extension.isRomaji


/**
 * Returns `true` if [input] contains a mix of Romaji and Kana.
 *
 * @param passKanji if `true`, ignore kanji, otherwise this check will fail if any character is a
 * Kanji. Defaults to `true`.
 *
 * See [Romaji](https://en.wikipedia.org/wiki/Romaji)
 * See [Kana](https://en.wikipedia.org/wiki/Kana)
 * See [Kanji](https://en.wikipedia.org/wiki/Kanji)
 *
 * For example:
 * - `isMixed("Abあア"))` => `true`
 * - `isMixed("お腹A"))` => `true` // ignores kanji by default
 * - `isMixed("お腹A", passKanji = false)` => `false`
 * - `isMixed("ab"))` => `false`
 * - `isMixed("あア"))` => `false`
 */
fun isMixed(input: String, passKanji: Boolean = true): Boolean {
    val hasKanji = if (!passKanji) input.any(Char::isKanji) else false
    return !hasKanji && input.any(Char::isKana) && input.any(Char::isRomaji)
}
