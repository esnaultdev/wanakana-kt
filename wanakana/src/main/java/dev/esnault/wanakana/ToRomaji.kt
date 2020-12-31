package dev.esnault.wanakana

import dev.esnault.wanakana.utils.ConversionToken
import dev.esnault.wanakana.utils.applyMapping
import dev.esnault.wanakana.utils.kanaToHepburnMap
import dev.esnault.wanakana.utils.katakanaToHiragana
import dev.esnault.wanakana.utils.safeUpperCase


/**
 * Converts kana to romaji.
 * @param input the kana text input.
 * @param upcaseKatakana if `true`, katakana will be converted to uppercase, defaults to `false`.
 * @return the converted text.
 *
 * For example:
 * - `toRomaji("ひらがな　カタカナ")` => `"hiragana katakana"`
 * - `toRomaji("げーむ　ゲーム")` => `"ge-mu geemu"`
 * - `toRomaji("ひらがな　カタカナ", upcaseKatakana = true)` => `"hiragana KATAKANA"`
 */
fun toRomaji(input: String, upcaseKatakana: Boolean = false): String {
    // throw away the substring index information and just concatenate all the kana
    return splitIntoRomaji(input)
        .joinToString(separator = "") { token ->
            val romaji = token.value
            if (romaji == null) {
                // haven't converted the end of the string, since we are in IME mode
                input.slice(token.range)
            } else {
                val makeUpperCase = upcaseKatakana && isKatakana(input.slice(token.range))
                if (makeUpperCase) romaji.safeUpperCase() else romaji
            }
        }
}

private fun splitIntoRomaji(input: String): List<ConversionToken> {
    val map = kanaToHepburnMap
    val hiragana = katakanaToHiragana(input, true)
    // TODO Add IME mode
    return applyMapping(hiragana, map, true)
}
