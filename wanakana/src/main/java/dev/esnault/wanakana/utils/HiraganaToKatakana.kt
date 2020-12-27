package dev.esnault.wanakana.utils

import dev.esnault.wanakana.Constants

/**
 * Converts Hiragana to Katakana.
 * Passes through any non-hiragana chars.
 * @param input the text to convert.
 * @returns the converted text.
 *
 * For example:
 * - hiraganaToKatakana("ひらがな") => "ヒラガナ"
 * - hiraganaToKatakana("ひらがな is a type of kana") => "ヒラガナ is a type of kana"
 *
 * See [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 * See [Katakana](https://en.wikipedia.org/wiki/Katakana).
 */
fun hiraganaToKatakana(input: String): String = buildString {
    input.forEach { char ->
        // Short circuit to avoid incorrect codeshift for 'ー' and '・'
        if (char.isLongDash() || char.isSlashDot()) {
            append(char)
        } else if (char.isHiragana()) {
            // Shift charcode.
            val code = char.toInt() + (Constants.KATAKANA_START - Constants.HIRAGANA_START)
            val kataChar = code.toChar()
            append(kataChar)
        } else {
            // Pass non-hiragana chars through
            append(char)
        }
    }
}
