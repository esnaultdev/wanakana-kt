package dev.esnault.wanakana

import dev.esnault.wanakana.utils.KanaToken
import dev.esnault.wanakana.utils.applyMapping
import dev.esnault.wanakana.utils.kanaToHepburnMap
import dev.esnault.wanakana.utils.katakanaToHiragana


/**
 * Converts kana to romaji.
 * @param input the kana text input
 * @return the converted text
 *
 * For example:
 * - `toRomaji("ひらがな　カタカナ")` => `"hiragana katakana"`
 * - `toRomaji("げーむ　ゲーム")` => `"ge-mu geemu"`
 */
fun toRomaji(input: String): String {
    // throw away the substring index information and just concatenate all the kana
    return splitIntoRomaji(input)
        .joinToString(separator = "") { token ->
            val romaji = token.kana
            if (romaji == null) {
                // haven't converted the end of the string, since we are in IME mode
                return@joinToString input.drop(token.start)
            }
            romaji
        }
}

private fun splitIntoRomaji(input: String): List<KanaToken> {
    val map = kanaToHepburnMap
    val hiragana = katakanaToHiragana(input, true)
    // TODO Add IME mode
    return applyMapping(hiragana, map, true)
}
