package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.utils.ConversionToken
import dev.esnault.wanakana.core.utils.ImeText
import dev.esnault.wanakana.core.utils.applyMapping
import dev.esnault.wanakana.core.utils.kanaToHepburnMap
import dev.esnault.wanakana.core.utils.katakanaToHiragana
import dev.esnault.wanakana.core.utils.matchSelection
import dev.esnault.wanakana.core.utils.safeUpperCase


internal fun toRomaji(
    input: String,
    imeMode: IMEMode = IMEMode.DISABLED,
    upcaseKatakana: Boolean = false
): String {
    val dummyImeText = ImeText(input, selection = -1..-1)
    return toRomajiIme(dummyImeText, imeMode, upcaseKatakana).text
}

internal fun toRomaji(input: String, config: Config = Config.DEFAULT): String {
    return toRomaji(input, config.imeMode, config.upcaseKatakana)
}

internal fun toRomajiIme(
    input: ImeText,
    imeMode: IMEMode = IMEMode.ENABLED,
    upcaseKatakana: Boolean = false
): ImeText {
    if (input.text.isEmpty()) return input

    val tokens: List<ConversionToken> = splitIntoRomaji(input.text, imeMode)
    val newSelection = matchSelection(input.selection, tokens)

    // throw away the substring index information and just concatenate all the values
    val newText = tokens.joinToString(separator = "") { token ->
        val romaji = token.value
        if (romaji == null) {
            // haven't converted the end of the string, since we are in IME mode
            input.text.slice(token.range)
        } else {
            val makeUpperCase = upcaseKatakana && isKatakana(input.text.slice(token.range))
            if (makeUpperCase) romaji.safeUpperCase() else romaji
        }
    }

    return ImeText(newText, newSelection)
}

internal fun toRomajiIme(input: ImeText, config: Config = Config.DEFAULT_IME): ImeText {
    return toRomajiIme(input, config.imeMode, config.upcaseKatakana)
}

private fun splitIntoRomaji(input: String, imeMode: IMEMode): List<ConversionToken> {
    val map = kanaToHepburnMap
    val hiragana = katakanaToHiragana(input, true)
    return applyMapping(hiragana, map, imeMode == IMEMode.DISABLED)
}
