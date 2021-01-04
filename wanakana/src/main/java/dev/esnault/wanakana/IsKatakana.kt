package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isKatakana

/**
 * Returns `true` if [input] is [Katakana](https://en.wikipedia.org/wiki/Katakana).
 * 
 * For example:
 * - `isKatakana("ゲーム")` => `true`
 * - `isKatakana("あ")` => `false`
 * - `isKatakana("A")` => `false`
 * - `isKatakana("あア")` => `false`
 */
fun isKatakana(input: String): Boolean = input.all(Char::isKatakana)
