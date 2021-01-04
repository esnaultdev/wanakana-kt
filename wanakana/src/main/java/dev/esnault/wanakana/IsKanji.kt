package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isKanji
import dev.esnault.wanakana.utils.Constants


/**
 * Returns `true` if [input] is [Kanji](https://en.wikipedia.org/wiki/Kanji).
 * See [Japanese CJK ideographs](https://en.wikipedia.org/wiki/CJK_Unified_Ideographs).
 *
 * For example:
 * - `isKanji("刀")` => `true`
 * - `isKanji("切腹")` => `true`
 * - `isKanji("勢い")` => `false`
 * - `isKanji("あAア")` => `false`
 * - `isKanji("")` => `true`
 */
fun isKanji(input: String): Boolean = input.all(Char::isKanji)

/**
 * Returns `true` if [input] is [Kanji](https://en.wikipedia.org/wiki/Kanji).
 * See [Japanese CJK ideographs](https://en.wikipedia.org/wiki/CJK_Unified_Ideographs).
 *
 * For example:
 * - `isKanji('刀')` => `true`
 * - `isKanji('あ')` => `false`
 * - `isKanji('ア')` => `false`
 * - `isKanji('A')` => `false`
 */
fun isKanji(input: Char): Boolean = input.toInt() in Constants.KANJI_RANGE
