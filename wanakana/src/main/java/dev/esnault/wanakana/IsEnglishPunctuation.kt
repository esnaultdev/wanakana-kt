package dev.esnault.wanakana

import dev.esnault.wanakana.utils.isEnglishPunctuation


/**
 * Returns `true` if this string only contains english punctation, and isn't empty.
 */
internal fun isEnglishPunctuation(input: String): Boolean {
    if (input.isEmpty()) return false
    return input.all(Char::isEnglishPunctuation)
}
