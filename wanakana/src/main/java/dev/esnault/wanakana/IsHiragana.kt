package dev.esnault.wanakana

import dev.esnault.wanakana.utils.Constants
import dev.esnault.wanakana.utils.isLongDash


/**
 * Returns `true` if [input] is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 *
 * For example:
 * - `isHiragana("げーむ")` => `true`
 * - `isHiragana("A")` => `false`
 * - `isHiragana("あア")` => `false`
 */
fun isHiragana(input: String): Boolean = input.all(::isHiragana)

/**
 * Returns `true` if [input] is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 *
 * For example:
 * - `isHiragana('げ')` => `true`
 * - `isHiragana('A')` => `false`
 * - `isHiragana('ア')` => `false`
 */
fun isHiragana(input: Char): Boolean {
    if (input.isLongDash()) return true
    return input.toInt() in Constants.HIRAGANA_RANGE
}
