package dev.esnault.wanakana.extension

import dev.esnault.wanakana.utils.Constants
import dev.esnault.wanakana.utils.isLongDash

/**
 * Returns `true` if this is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 */
fun Char.isHiragana(): Boolean {
    if (isLongDash()) return true
    return this.toInt() in Constants.HIRAGANA_RANGE
}

/**
 * Returns `true` if this is [Katakana](https://en.wikipedia.org/wiki/Katakana).
 */
fun Char.isKatakana(): Boolean = this.toInt() in Constants.KATAKANA_RANGE

/**
 * Returns `true` if this is [Kana](https://en.wikipedia.org/wiki/Kana).
 */
fun Char.isKana(): Boolean = this.isHiragana() || this.isKatakana()

/**
 * Returns `true` if this is a CJK ideograph (kanji).
 */
fun Char.isKanji(): Boolean = this.toInt() in Constants.KANJI_RANGE

/**
 * Returns `true` if this is Romaji (allowing Hepburn romanisation).
 *
 * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
 * See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).
 */
fun Char.isRomaji(): Boolean = this.toInt().let { charCode ->
    Constants.ROMAJI_RANGES.any { range -> charCode in range }
}

/**
 * Returns `true` if this is considered English punctuation.
 */
fun Char.isEnglishPunctuation(): Boolean = this.toInt().let { charCode ->
    Constants.EN_PUNCTUATION_RANGES.any { range -> charCode in range }
}

/**
 * Returns `true` if this is considered Japanese punctuation.
 */
fun Char.isJapanesePunctuation(): Boolean = this.toInt().let { charCode ->
    Constants.JA_PUNCTUATION_RANGES.any { range -> charCode in range }
}

/**
 * Returns `true` if this is Japanese.
 */
fun Char.isJapanese(): Boolean = this.toInt().let { charCode ->
    Constants.JAPANESE_RANGES.any { range -> charCode in range }
}
