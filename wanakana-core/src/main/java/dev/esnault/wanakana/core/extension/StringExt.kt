@file:Suppress("NOTHING_TO_INLINE")

package dev.esnault.wanakana.core.extension


/**
 * Returns `true` if this is [Kana](https://en.wikipedia.org/wiki/Kana).
 *
 * See [dev.esnault.wanakana.core.Wanakana.isKana].
 */
public fun String.isKana(): Boolean =
    dev.esnault.wanakana.core.isKana(this)

/**
 * Returns `true` if this is [Hiragana](https://en.wikipedia.org/wiki/Hiragana)
 *
 * See [dev.esnault.wanakana.core.Wanakana.isHiragana].
 */
public fun String.isHiragana(): Boolean =
    dev.esnault.wanakana.core.isHiragana(this)

/**
 * Returns `true` if this is [Katakana](https://en.wikipedia.org/wiki/Katakana).
 *
 * See [dev.esnault.wanakana.core.Wanakana.isKatakana] for more details.
 */
public fun String.isKatakana(): Boolean =
    dev.esnault.wanakana.core.isKatakana(this)


/**
 * Returns `true` if this is [Kanji](https://en.wikipedia.org/wiki/Kanji).
 *
 * See [dev.esnault.wanakana.core.Wanakana.isKana] for more details.
 */
public fun String.isKanji(): Boolean =
    dev.esnault.wanakana.core.isKanji(this)

/**
 * Returns `true` if this only includes Kanji, Kana, zenkaku numbers, and JA punctuation/symbols.
 *
 * See [dev.esnault.wanakana.core.Wanakana.isJapanese] for more details.
 */
public fun String.isJapanese(allowed: Regex? = null): Boolean =
    dev.esnault.wanakana.core.isJapanese(this, allowed)

/**
 * Returns `true` if this contains a mix of Romaji and Kana.
 *
 * See [dev.esnault.wanakana.core.Wanakana.isMixed] for more details.
 */
public fun String.isMixed(passKanji: Boolean = true): Boolean =
    dev.esnault.wanakana.core.isMixed(this, passKanji)

/**
 * Returns `true` if this is Romaji (allowing Hepburn romanisation).
 *
 * See [dev.esnault.wanakana.core.Wanakana.isRomaji] for more details.
 */
public fun String.isRomaji(allowed: Regex? = null): Boolean =
    dev.esnault.wanakana.core.isRomaji(this, allowed)
