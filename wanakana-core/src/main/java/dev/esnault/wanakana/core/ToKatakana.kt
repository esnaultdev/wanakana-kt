package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.utils.hiraganaToKatakana
import dev.esnault.wanakana.core.utils.isEnglishPunctuation
import dev.esnault.wanakana.core.utils.safeLowerCase


internal fun toKatakana(
    input: String,
    imeMode: IMEMode = IMEMode.DISABLED,
    passRomaji: Boolean = false,
    useObsoleteKana: Boolean = false
): String {
    if (input.isEmpty()) return input

    if (passRomaji) {
        return hiraganaToKatakana(input)
    }

    if (isMixed(input) || isRomaji(input) || input.isEnglishPunctuation()) {
        val hiragana = toKana(
            input = input.safeLowerCase(),
            imeMode = imeMode,
            useObsoleteKana = useObsoleteKana
        )
        return hiraganaToKatakana(hiragana)
    }

    return hiraganaToKatakana(input)
}


internal fun toKatakana(input: String, config: Config = Config.DEFAULT): String {
    return toKatakana(input, config.imeMode, config.passRomaji, config.useObsoleteKana)
}
