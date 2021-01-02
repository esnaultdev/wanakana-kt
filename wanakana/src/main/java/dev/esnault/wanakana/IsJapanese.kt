package dev.esnault.wanakana

import dev.esnault.wanakana.utils.isJapanese


/**
 * Returns `true` if [input] only includes Kanji, Kana, zenkaku numbers, and JA punctuation/symbols.
 *
 * See [Kanji](https://en.wikipedia.org/wiki/Kanji).
 * See [Kana](https://en.wikipedia.org/wiki/Kana).
 *
 * @param allowed additional test allowed to pass for each char.
 *
 * For example:
 * - isJapanese("泣き虫") => true
 * - isJapanese("あア") => true
 * - isJapanese("２月") => true // Zenkaku numbers allowed
 * - isJapanese("泣き虫。！〜＄") => true // Zenkaku/JA punctuation
 * - isJapanese("泣き虫.!~$") => false // Latin punctuation fails
 * - isJapanese("A泣き虫") => false
 * - isJapanese("≪偽括弧≫", Regex("""[≪≫]""")) // => true
 */
fun isJapanese(input: String, allowed: Regex? = null): Boolean {
    return input.all { char ->
        char.isJapanese() || (allowed?.matches(char.toString()) ?: false)
    }
}
