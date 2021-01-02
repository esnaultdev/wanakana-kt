package dev.esnault.wanakana

import dev.esnault.wanakana.utils.katakanaToHiragana
import dev.esnault.wanakana.utils.safeLowerCase


/**
 * Converts input to [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 *
 * @param input the text to convert.
 * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
 * [IMEMode.DISABLED].
 * @param passRomaji if `true` romaji will be kept as-is, defaults to `false`.
 * @param useObsoleteKana if `true` obsolete kanas will be used (ゐ and ゑ), defaults to `false`.
 * @return the converted text.
 *
 * For example:
 * - `toHiragana("toukyou, オオサカ") // => `"とうきょう、　おおさか"`
 * - `toHiragana("only カナ", passRomaji = true)` => `"only かな"`
 * - `toHiragana("wi")` => `"うぃ"`
 * - `toHiragana("wi", useObsoleteKana = true)` => `"ゐ"`
 */
fun toHiragana(
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

    if (isRomaji(input) || isEnglishPunctuation(input)) {
        return toKana(
            input = input.safeLowerCase(),
            imeMode = imeMode,
            useObsoleteKana = useObsoleteKana
        )
    }

    return katakanaToHiragana(input)
}

/**
 * Converts input to [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 *
 * See [toHiragana] for more details.
 */
fun toHiragana(input: String, config: Config = Config.DEFAULT): String {
    return toHiragana(input, config.imeMode, config.passRomaji, config.useObsoleteKana)
}
