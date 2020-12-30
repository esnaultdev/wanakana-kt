package dev.esnault.wanakana.utils

import dev.esnault.wanakana.Constants


/**
 * Returns `true` if this is '・'.
 */
fun Char.isSlashDot() = this.toInt() == Constants.KANA_SLASH_DOT

/**
 * Returns `true` if this is 'ー'.
 */
fun Char.isLongDash() = this.toInt() == Constants.PROLONGED_SOUND_MARK

/**
 * Returns `true` if this is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 */
fun Char.isHiragana() = this.toInt() in Constants.HIRAGANA_RANGE

/**
 * Returns `true` if this is [Katakana](https://en.wikipedia.org/wiki/Katakana).
 */
fun Char.isKatakana() = this.toInt() in Constants.KATAKANA_RANGE

/**
 * Returns `true` if this is [Kana](https://en.wikipedia.org/wiki/Kana).
 */
fun Char.isKana() = this.isHiragana() || this.isKatakana()

/**
 * Returns `true` if this is a CJK ideograph (kanji).
 */
fun Char.isKanji() = this.toInt() in Constants.KANJI_RANGE

/**
 * Returns `true` is this is an English uppercase letter.
 */
fun Char.isEnglishUpperCase() = this.toInt() in Constants.LATIN_UPPERCASE_RANGE

/**
 * Returns `true` if this is Romaji (allowing Hepburn romanisation).
 *
 * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
 * See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).
 */
fun Char.isRomaji() = this.toInt().let { charCode ->
    Constants.ROMAJI_RANGES.any { range -> charCode in range }
}

/**
 * Returns `true` if this is considered English punctuation.
 */
fun Char.isEnglishPunctuation() = this.toInt().let { charCode ->
    Constants.EN_PUNCTUATION_RANGES.any { range -> charCode in range }
}

/**
 * Returns `true` if this is considered Japanese punctuation.
 */
fun Char.isJapanesePunctuation() = this.toInt().let { charCode ->
    Constants.JA_PUNCTUATION_RANGES.any { range -> charCode in range }
}

/**
 * Returns `true` if this is Japanese.
 */
fun Char.isJapanese() = this.toInt().let { charCode ->
    Constants.JAPANESE_RANGES.any { range -> charCode in range }
}
