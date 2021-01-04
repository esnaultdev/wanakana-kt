package dev.esnault.wanakana

import dev.esnault.wanakana.utils.ConversionToken
import dev.esnault.wanakana.utils.applyMapping
import dev.esnault.wanakana.utils.kanaToHepburnMap
import dev.esnault.wanakana.utils.katakanaToHiragana
import dev.esnault.wanakana.utils.safeUpperCase


/**
 * Converts kana to romaji (Hepburn romanisation).
 *
 * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
 * See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).
 *
 * @param input the kana text input.
 * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
 * [IMEMode.DISABLED].
 * @param upcaseKatakana if `true`, katakana will be converted to uppercase, defaults to `false`.
 * @return the converted text.
 *
 * For example:
 * - `toRomaji("ひらがな　カタカナ")` => `"hiragana katakana"`
 * - `toRomaji("げーむ　ゲーム")` => `"ge-mu geemu"`
 * - `toRomaji("ひらがな　カタカナ", upcaseKatakana = true)` => `"hiragana KATAKANA"`
 */
fun toRomaji(
    input: String,
    imeMode: IMEMode = IMEMode.DISABLED,
    upcaseKatakana: Boolean = false
): String {
    if (input.isEmpty()) return input

    // throw away the substring index information and just concatenate all the kana
    return splitIntoRomaji(input, imeMode)
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

/**
 * Converts kana to romaji (Hepburn romanisation).
 *
 * See [toRomaji] for more details.
 */
fun toRomaji(input: String, config: Config = Config.DEFAULT): String {
    return toRomaji(input, config.imeMode, config.upcaseKatakana)
}

private fun splitIntoRomaji(input: String, imeMode: IMEMode): List<ConversionToken> {
    val map = kanaToHepburnMap
    val hiragana = katakanaToHiragana(input, true)
    return applyMapping(hiragana, map, imeMode == IMEMode.DISABLED)
}
