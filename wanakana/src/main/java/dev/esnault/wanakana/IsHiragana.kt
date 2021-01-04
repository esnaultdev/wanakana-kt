package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isHiragana


/**
 * Returns `true` if [input] is [Hiragana](https://en.wikipedia.org/wiki/Hiragana)
 *
 * For example:
 * - `isHiragana("げーむ")` => `true`
 * - `isHiragana("A")` => `false`
 * - `isHiragana("あア")` => `false`
 */
fun isHiragana(input: String): Boolean = input.all(Char::isHiragana)
