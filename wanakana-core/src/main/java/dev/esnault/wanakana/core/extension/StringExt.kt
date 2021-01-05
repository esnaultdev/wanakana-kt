@file:Suppress("NOTHING_TO_INLINE")

package dev.esnault.wanakana.core.extension


/**
 * Returns `true` if this is [Kana](https://en.wikipedia.org/wiki/Kana).
 *
 * See [dev.esnault.wanakana.Wanakana.isKana].
 */
fun String.isKana(): Boolean =
    dev.esnault.wanakana.core.isKana(this)

/**
 * Returns `true` if this is [Hiragana](https://en.wikipedia.org/wiki/Hiragana)
 *
 * See [dev.esnault.wanakana.Wanakana.isHiragana].
 */
fun String.isHiragana(): Boolean =
    dev.esnault.wanakana.core.isHiragana(this)

/**
 * Returns `true` if this is [Katakana](https://en.wikipedia.org/wiki/Katakana).
 *
 * See [dev.esnault.wanakana.Wanakana.isKatakana] for more details.
 */
fun String.isKatakana(): Boolean =
    dev.esnault.wanakana.core.isKatakana(this)


/**
 * Returns `true` if this is [Kanji](https://en.wikipedia.org/wiki/Kanji).
 *
 * See [dev.esnault.wanakana.Wanakana.isKana] for more details.
 */
fun String.isKanji(): Boolean =
    dev.esnault.wanakana.core.isKanji(this)

/**
 * Returns `true` if this only includes Kanji, Kana, zenkaku numbers, and JA punctuation/symbols.
 *
 * See [dev.esnault.wanakana.Wanakana.isJapanese] for more details.
 */
fun String.isJapanese(allowed: Regex? = null): Boolean =
    dev.esnault.wanakana.core.isJapanese(this, allowed)

/**
 * Returns `true` if this contains a mix of Romaji and Kana.
 *
 * See [dev.esnault.wanakana.Wanakana.isMixed] for more details.
 */
fun String.isMixed(passKanji: Boolean = true): Boolean =
    dev.esnault.wanakana.core.isMixed(this, passKanji)

/**
 * Returns `true` if this is Romaji (allowing Hepburn romanisation).
 *
 * See [dev.esnault.wanakana.Wanakana.isRomaji] for more details.
 */
fun String.isRomaji(allowed: Regex? = null): Boolean =
    dev.esnault.wanakana.core.isRomaji(this, allowed)
