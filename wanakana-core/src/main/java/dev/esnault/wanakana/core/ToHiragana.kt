package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.utils.isEnglishPunctuation
import dev.esnault.wanakana.core.utils.katakanaToHiragana
import dev.esnault.wanakana.core.utils.safeLowerCase


internal fun toHiragana(
    input: String,
    imeMode: IMEMode = IMEMode.DISABLED,
    passRomaji: Boolean = false,
    useObsoleteKana: Boolean = false
): String {
    if (input.isEmpty()) return input

    if (passRomaji) {
        return katakanaToHiragana(input)
    }

    if (isMixed(input, passKanji = true )) {
        val convertedKatakana = katakanaToHiragana(input)
        return toKana(
            input = convertedKatakana.safeLowerCase(),
            imeMode = imeMode,
            useObsoleteKana = useObsoleteKana
        )
    }

    if (isRomaji(input) || input.isEnglishPunctuation()) {
        return toKana(
            input = input.safeLowerCase(),
            imeMode = imeMode,
            useObsoleteKana = useObsoleteKana
        )
    }

    return katakanaToHiragana(input)
}

internal fun toHiragana(input: String, config: Config = Config.DEFAULT): String {
    return toHiragana(input, config.imeMode, config.passRomaji, config.useObsoleteKana)
}
