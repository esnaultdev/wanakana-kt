package dev.esnault.wanakana

import dev.esnault.wanakana.utils.ConversionToken
import dev.esnault.wanakana.utils.ImeText
import dev.esnault.wanakana.utils.MappingTree
import dev.esnault.wanakana.utils.applyMapping
import dev.esnault.wanakana.utils.hiraganaToKatakana
import dev.esnault.wanakana.utils.isEnglishUpperCase
import dev.esnault.wanakana.utils.kanaImeMode
import dev.esnault.wanakana.utils.matchSelection
import dev.esnault.wanakana.utils.romajiToKanaMap
import dev.esnault.wanakana.utils.safeLowerCase
import dev.esnault.wanakana.utils.useObsoleteKana

/**
 * Converts Romaji to Kana.
 * Lowercase text will result in Hiragana and uppercase text will result in Katakana.
 *
 * @param input the text to convert to Kana.
 * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
 * [IMEMode.DISABLED].
 * @param useObsoleteKana if `true` obsolete kanas will be used (ゐゑヰヱ), defaults to `false`.
 * @return the converted text.
 *
 * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
 * See [Kana](https://en.wikipedia.org/wiki/Kana).
 * See [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 * See [Katakana](https://en.wikipedia.org/wiki/Katakana).
 *
 * For example:
 * - `toKana("onaji BUTTSUUJI")` => `"おなじ ブッツウジ"`
 * - `toKana("ONAJI buttsuuji")` => `"オナジ ぶっつうじ"`
 * - `toKana("座禅‘zazen’スタイル")` => `"座禅「ざぜん」スタイル"`
 * - `toKana("batsuge-mu")` => `"ばつげーむ"`
 * - `toKana("!?.:/,~-‘’“”[](){}")` => `"！？。：・、〜ー「」『』［］（）｛｝"`
 */
fun toKana(
    input: String,
    imeMode: IMEMode = IMEMode.DISABLED,
    useObsoleteKana: Boolean = false
): String {
    val dummyImeText = ImeText(input, selection = -1..-1)
    return toKanaIme(dummyImeText, imeMode, useObsoleteKana).text
}

/**
 * Converts Romaji to Kana.
 * Lowercase text will result in Hiragana and uppercase text will result in Katakana.
 *
 * @param input the text to convert to Kana.
 * @param config optional configuration of the conversion. Defaults to [Config.DEFAULT].
 * @return the converted text.
 *
 * See [toKana] for more details and examples.
 */
fun toKana(input: String, config: Config = Config.DEFAULT): String {
    return toKana(input, config.imeMode, config.useObsoleteKana)
}

/**
 * Converts Romaji to Kana and preserves the cursor/selection.
 * Lowercase text will result in Hiragana and uppercase text will result in Katakana.
 *
 * @param input the text to convert to Kana, with cursor/selection.
 * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
 * [IMEMode.ENABLED].
 * @param useObsoleteKana if `true` obsolete kanas will be used (ゐゑヰヱ), defaults to `false`.
 * @return the converted text, with cursor/selection.
 *
 * See [toKana] for more details and examples.
 */
fun toKanaIme(
    input: ImeText,
    imeMode: IMEMode = IMEMode.ENABLED,
    useObsoleteKana: Boolean = false
): ImeText {
    val inputText = input.text
    if (inputText.isEmpty()) return input

    val map = createRomajiToKanaMap(imeMode, useObsoleteKana)

    val enforceHiragana = imeMode == IMEMode.TO_HIRAGANA
    val enforceKatakanaMode = imeMode == IMEMode.TO_KATAKANA

    val tokens: List<ConversionToken> = splitIntoConvertedKana(inputText, map, imeMode)
    val newSelection = matchSelection(input.selection, tokens)

    // throw away the substring index information and just concatenate all the kana
    val newText: String = tokens.joinToString(separator = "") { token ->
        val kana = token.value
        if (kana == null) {
            // haven't converted the end of the string, since we are in IME mode
            return@joinToString inputText.slice(token.range)
        }

        val enforceKatakana = enforceKatakanaMode
                || inputText.slice(token.range).all { it.isEnglishUpperCase() }
        if (enforceHiragana || !enforceKatakana) kana else hiraganaToKatakana(kana)
    }
    return ImeText(text = newText, selection = newSelection)
}

/**
 * Converts Romaji to Kana and preserves the cursor/selection.
 * Lowercase text will result in Hiragana and uppercase text will result in Katakana.
 *
 * @param input the text to convert to Kana, with cursor/selection.
 * @param config optional configuration of the conversion. Defaults to [Config.DEFAULT_IME].
 * @return the converted text, with cursor/selection.
 *
 * See [toKana] for more details and examples.
 */
fun toKanaIme(input: ImeText, config: Config = Config.DEFAULT_IME): ImeText {
    return toKanaIme(input, config.imeMode, config.useObsoleteKana)
}

private fun splitIntoConvertedKana(
    input: String,
    map: MappingTree,
    imeMode: IMEMode
): List<ConversionToken> {
    return applyMapping(input.safeLowerCase(), map, imeMode == IMEMode.DISABLED)
}

private fun createRomajiToKanaMap(imeMode: IMEMode, useObsoleteKana: Boolean): MappingTree {
    var map = romajiToKanaMap
    if (imeMode != IMEMode.DISABLED) {
        map = kanaImeMode(map)
    }
    if (useObsoleteKana) {
        map = useObsoleteKana(map)
    }
    // TODO Introduce custom mappings
    return map
}
