package dev.esnault.wanakana

import dev.esnault.wanakana.utils.isKana
import dev.esnault.wanakana.utils.isKanji
import dev.esnault.wanakana.utils.isRomaji


/**
 * Returns `true` if [input] contains a mix of Romaji and Kana.
 *
 * // TODO Investigate the reasoning behind this parameter, it doesn't make much sense.
 * @param passKanji if `true`, pass through kanji (defaults to `true`)
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
