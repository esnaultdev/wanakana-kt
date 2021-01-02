package dev.esnault.wanakana

import dev.esnault.wanakana.utils.isEnglishPunctuation


/**
 * Returns `true` if this string only contains english punctation.
 */
internal fun isEnglishPunctuation(input: String): Boolean {
    return input.all(Char::isEnglishPunctuation)
}
