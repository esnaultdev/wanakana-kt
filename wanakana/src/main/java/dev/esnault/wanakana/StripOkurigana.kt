package dev.esnault.wanakana

import dev.esnault.wanakana.utils.isKana
import dev.esnault.wanakana.utils.isKanji

/**
 * Strips [Okurigana](https://en.wikipedia.org/wiki/Okurigana).
 *
 * @param [input] the input text.
 * @param [leading] if `true`, strips leading okurigana instead of trailing okurigana, defaults to
 * `false`.
 * @param [matchKanji] optional kanji representation of the text, to help strip okurigana from a
 * kana input.
 * @return the text with okurigana removed.
 * 
 * For example:
 * - `stripOkurigana("踏み込む")` => `"踏み込"`
 * - `stripOkurigana("お祝い")` => `"お祝"`
 * - `stripOkurigana("お腹", leading = true)` => `"腹"`
 * - `stripOkurigana("ふみこむ", matchKanji = "踏み込む")` => `"ふみこ"`
 * - `stripOkurigana("おみまい", matchKanji = "お祝い", leading = true)` => `"みまい"`
 */
fun stripOkurigana(input: String, leading: Boolean = false, matchKanji: String? = null): String {
    if (
        input.isEmpty() ||
        !isJapanese(input) ||
        isLeadingWithoutInitialKana(input, leading) ||
        isTrailingWithoutFinalKana(input, leading) ||
        isInvalidMatcher(input, matchKanji)
    ) {
        return input
    }

    val chars = matchKanji?.takeUnless(String::isEmpty) ?: input
    val pattern = if (leading) {
        "^${tokenize(chars).first()}"
    } else {
        "${tokenize(chars).last()}$"
    }
    val okuriganaRegex = Regex(pattern)
    return okuriganaRegex.replace(input, replacement = "")
}

private fun isLeadingWithoutInitialKana(input: String, leading: Boolean): Boolean =
    leading && !input.first().isKana()

private fun isTrailingWithoutFinalKana(input: String, leading: Boolean): Boolean =
    !leading && !input.last().isKana()

private fun isInvalidMatcher(input: String, matchKanji: String? = null): Boolean =
    matchKanji?.any(Char::isKanji) == false || (matchKanji == null && isKana(input))
