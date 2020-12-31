package dev.esnault.wanakana

import dev.esnault.wanakana.utils.katakanaToHiragana
import dev.esnault.wanakana.utils.safeLowerCase


/**
 * Converts input to [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 *
 * @param input the text to convert.
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
    passRomaji: Boolean = false,
    useObsoleteKana: Boolean = false
): String {
    // TODO introduce useObsoleteKana to other methods
    if (passRomaji) {
        return katakanaToHiragana(input)
    }

    if (isMixed(input, passKanji = true )) {
        val convertedKatakana = katakanaToHiragana(input)
        return toKana(convertedKatakana.safeLowerCase())
    }

    if (isRomaji(input) || isEnglishPunctuation(input)) {
        return toKana(input.safeLowerCase())
    }

    return katakanaToHiragana(input)
}