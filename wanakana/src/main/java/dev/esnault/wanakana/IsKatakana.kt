package dev.esnault.wanakana

import dev.esnault.wanakana.utils.isKatakana

/**
 * Returns `true` if [input] is [Katakana](https://en.wikipedia.org/wiki/Katakana).
 * 
 * For example:
 * - `isKatakana("ゲーム")` => `true`
 * - `isKatakana("あ")` => `false`
 * - `isKatakana("A")` => `false`
 * - `isKatakana("あア")` => `false`
 */
fun isKatakana(input: String): Boolean {
    if (input.isEmpty()) return false
    return input.all(Char::isKatakana)
}
