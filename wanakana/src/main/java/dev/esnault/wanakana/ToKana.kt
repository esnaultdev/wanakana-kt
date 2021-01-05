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

internal fun toKana(
    input: String,
    imeMode: IMEMode = IMEMode.DISABLED,
    useObsoleteKana: Boolean = false
): String {
    val dummyImeText = ImeText(input, selection = -1..-1)
    return toKanaIme(dummyImeText, imeMode, useObsoleteKana).text
}

internal fun toKana(input: String, config: Config = Config.DEFAULT): String {
    return toKana(input, config.imeMode, config.useObsoleteKana)
}

internal fun toKanaIme(
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

internal fun toKanaIme(input: ImeText, config: Config = Config.DEFAULT_IME): ImeText {
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
