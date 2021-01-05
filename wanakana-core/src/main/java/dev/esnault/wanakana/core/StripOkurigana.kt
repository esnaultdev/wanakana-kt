package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.extension.isKana
import dev.esnault.wanakana.core.extension.isKanji

internal fun stripOkurigana(
    input: String,
    leading: Boolean = false,
    matchKanji: String? = null
): String {
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
