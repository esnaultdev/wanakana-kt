package dev.esnault.wanakana.core.extension

/**
 * Returns `true` if this is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 *
 * See [dev.esnault.wanakana.core.Wanakana.isHiragana] for more details.
 */
public fun Char.isHiragana(): Boolean =
    dev.esnault.wanakana.core.isHiragana(this)

/**
 * Returns `true` if this is [Katakana](https://en.wikipedia.org/wiki/Katakana).
 *
 * See [dev.esnault.wanakana.core.Wanakana.isKatakana] for more details.
 */
public fun Char.isKatakana(): Boolean =
    dev.esnault.wanakana.core.isKatakana(this)

/**
 * Returns `true` if this is [Kana](https://en.wikipedia.org/wiki/Kana).
 *
 * See [dev.esnault.wanakana.core.Wanakana.isKana] for more details.
 */
public fun Char.isKana(): Boolean =
    dev.esnault.wanakana.core.isKana(this)

/**
 * Returns `true` if this is a CJK ideograph (kanji).
 *
 * See [dev.esnault.wanakana.core.Wanakana.isKanji] for more details.
 */
public fun Char.isKanji(): Boolean =
    dev.esnault.wanakana.core.isKanji(this)

/**
 * Returns `true` if this is Romaji (allowing Hepburn romanisation).
 *
 * See [dev.esnault.wanakana.core.Wanakana.isRomaji] for more details.
 */
public fun Char.isRomaji(): Boolean =
    dev.esnault.wanakana.core.isRomaji(this)

/**
 * Returns `true` if this is Japanese.
 *
 * See [dev.esnault.wanakana.core.Wanakana.isJapanese] for more details.
 */
public fun Char.isJapanese(): Boolean =
    dev.esnault.wanakana.core.isJapanese(this)
