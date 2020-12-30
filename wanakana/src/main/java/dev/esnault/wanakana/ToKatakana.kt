package dev.esnault.wanakana

import dev.esnault.wanakana.utils.hiraganaToKatakana
import dev.esnault.wanakana.utils.safeLowerCase


/**
 * Converts input to [Katakana](https://en.wikipedia.org/wiki/Katakana).
 *
 * @param input the text to convert.
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
    passRomaji: Boolean = false,
    useObsoleteKana: Boolean = false
): String {
    // TODO introduce useObsoleteKana to other methods
    if (passRomaji) {
        return hiraganaToKatakana(input)
    }

    if (isMixed(input) || isRomaji(input) || isEnglishPunctuation(input)) {
        val hiragana = toKana(input.safeLowerCase())
        return hiraganaToKatakana(hiragana)
    }

    return hiraganaToKatakana(input)
}
