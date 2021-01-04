package dev.esnault.wanakana

import dev.esnault.wanakana.utils.hiraganaToKatakana
import dev.esnault.wanakana.utils.isEnglishPunctuation
import dev.esnault.wanakana.utils.safeLowerCase


/**
 * Converts input to [Katakana](https://en.wikipedia.org/wiki/Katakana).
 *
 * @param input the text to convert.
 * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
 * [IMEMode.DISABLED].
 * @param passRomaji if `true` romaji will be kept as-is, defaults to `false`.
 * @param useObsoleteKana if `true` obsolete kanas will be used (ヰ and ヱ), defaults to `false`.
 * @return the converted text.
 *
 * For example:
 * - `toKatakana('toukyou, おおさか')` => `'トウキョウ、　オオサカ'`
 * - `toKatakana('only かな', passRomaji = true)` => `'only カナ'`
 * - `toKatakana('wi')` => `'ウィ'`
 * - `toKatakana('wi', useObsoleteKana = true)` => `'ヰ'`
 */
fun toKatakana(
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


/**
 * Converts input to [Katakana](https://en.wikipedia.org/wiki/Katakana).
 *
 * See [toKatakana] for more details.
 */
fun toKatakana(input: String, config: Config = Config.DEFAULT): String {
    return toKatakana(input, config.imeMode, config.passRomaji, config.useObsoleteKana)
}
