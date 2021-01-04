package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isJapanese
import dev.esnault.wanakana.utils.Constants


/**
 * Returns `true` if [input] only includes Kanji, Kana, zenkaku numbers, and JA punctuation/symbols.
 *
 * See [Kanji](https://en.wikipedia.org/wiki/Kanji).
 * See [Kana](https://en.wikipedia.org/wiki/Kana).
 *
 * @param allowed additional test allowed to pass for each char.
 *
 * For example:
 * - `isJapanese("泣き虫")` => `true`
 * - `isJapanese("あア")` => `true`
 * - `isJapanese("２月")` => `true` // Zenkaku numbers allowed
 * - `isJapanese("泣き虫。！〜＄")` => `true` // Zenkaku/JA punctuation
 * - `isJapanese("泣き虫.!~$")` => `false` // Latin punctuation fails
 * - `isJapanese("A泣き虫")` => `false`
 * - `isJapanese("≪偽括弧≫", Regex("""[≪≫]"""))` => `true`
 */
fun isJapanese(input: String, allowed: Regex? = null): Boolean {
    return input.all { char ->
        char.isJapanese() || (allowed?.matches(char.toString()) ?: false)
    }
}

/**
 * Returns `true` if [input] only includes Kanji, Kana, zenkaku numbers, and JA punctuation/symbols.
 *
 * See [Kanji](https://en.wikipedia.org/wiki/Kanji).
 * See [Kana](https://en.wikipedia.org/wiki/Kana).
 *
 * For example:
 * - `isJapanese('泣')` => `true`
 * - `isJapanese('あ')` => `true`
 * - `isJapanese('ア')` => `true`
 * - `isJapanese('２')` => `true` // Zenkaku numbers allowed
 * - `isJapanese('。')` => `true` // JA punctuation
 * - `isJapanese('!')` => `false` // Latin punctuation fails
 * - `isJapanese('A')` => `false`
 */
fun isJapanese(input: Char): Boolean = input.toInt().let { charCode ->
    Constants.JAPANESE_RANGES.any { range -> charCode in range }
}
