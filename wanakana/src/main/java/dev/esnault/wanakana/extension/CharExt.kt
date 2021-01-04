package dev.esnault.wanakana.extension

import dev.esnault.wanakana.utils.Constants

/**
 * Returns `true` if this is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 *
 * See [dev.esnault.wanakana.isHiragana] for more details.
 */
fun Char.isHiragana(): Boolean =
    dev.esnault.wanakana.isHiragana(this)

/**
 * Returns `true` if this is [Katakana](https://en.wikipedia.org/wiki/Katakana).
 *
 * See [dev.esnault.wanakana.isKatakana] for more details.
 */
fun Char.isKatakana(): Boolean =
    dev.esnault.wanakana.isKatakana(this)

/**
 * Returns `true` if this is [Kana](https://en.wikipedia.org/wiki/Kana).
 *
 * See [dev.esnault.wanakana.isKana] for more details.
 */
fun Char.isKana(): Boolean =
    dev.esnault.wanakana.isKana(this)

/**
 * Returns `true` if this is a CJK ideograph (kanji).
 *
 * See [dev.esnault.wanakana.isKanji] for more details.
 */
fun Char.isKanji(): Boolean =
    dev.esnault.wanakana.isKanji(this)

/**
 * Returns `true` if this is Romaji (allowing Hepburn romanisation).
 *
 * See [dev.esnault.wanakana.isRomaji] for more details.
 */
fun Char.isRomaji(): Boolean =
    dev.esnault.wanakana.isRomaji(this)

/**
 * Returns `true` if this is Japanese.
 *
 * See [dev.esnault.wanakana.isJapanese] for more details.
 */
fun Char.isJapanese(): Boolean =
    dev.esnault.wanakana.isJapanese(this)
