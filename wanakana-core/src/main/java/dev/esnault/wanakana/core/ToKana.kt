package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.utils.ConversionToken
import dev.esnault.wanakana.core.utils.ImeText
import dev.esnault.wanakana.core.utils.MappingTree
import dev.esnault.wanakana.core.utils.applyMapping
import dev.esnault.wanakana.core.utils.hiraganaToKatakana
import dev.esnault.wanakana.core.utils.isEnglishUpperCase
import dev.esnault.wanakana.core.utils.kanaImeMode
import dev.esnault.wanakana.core.utils.matchSelection
import dev.esnault.wanakana.core.utils.romajiToKanaMap
import dev.esnault.wanakana.core.utils.safeLowerCase
import dev.esnault.wanakana.core.utils.useObsoleteKana

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
    if (input.text.isEmpty()) return input

    val map = createRomajiToKanaMap(imeMode, useObsoleteKana)

    val enforceHiragana = imeMode == IMEMode.TO_HIRAGANA
    val enforceKatakanaMode = imeMode == IMEMode.TO_KATAKANA

    // If we have a cursor that is not at the edge of the text, we need to split the input to avoid
    // converting a single n too early.
    val needToSplit = input.selection.first == input.selection.last &&
        input.selection.first > 0 && input.selection.first != input.text.length

    val tokens: List<ConversionToken> = if (!needToSplit) {
        splitIntoConvertedKana(input.text, map, imeMode)
    } else {
        val cursor = input.selection.first
        val inputStart = input.text.take(cursor)
        val inputEnd = input.text.drop(cursor)
        val startTokens = splitIntoConvertedKana(inputStart, map, imeMode)
        val endTokens = splitIntoConvertedKana(inputEnd, map, imeMode)
            .map { token -> token.shift(cursor) }
        startTokens + endTokens
    }
    val newSelection = matchSelection(input.selection, tokens)

    // throw away the substring index information and just concatenate all the kana
    val newText: String = tokens.joinToString(separator = "") { token ->
        val kana = token.value
        if (kana == null) {
            // haven't converted the end of the string, since we are in IME mode
            return@joinToString input.text.slice(token.range)
        }

        val enforceKatakana = enforceKatakanaMode
                || input.text.slice(token.range).all { it.isEnglishUpperCase() }
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
