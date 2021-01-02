package dev.esnault.wanakana

import dev.esnault.wanakana.utils.isRomaji


/**
 * Returns `true` if [input] is Romaji (allowing Hepburn romanisation).
 *
 * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
 * See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).
 *
 * @param allowed additional test allowed to pass for each char.
 *
 * For example
 * - `isRomaji("Tōkyō and Ōsaka")` => `true`
 * - `isRomaji("12a*b&c-d")` => `true`
 * - `isRomaji("あアA")` => `false`
 * - `isRomaji("お願い")` => `false`
 * - `isRomaji("a！b&cーd")` => `false` // Zenkaku punctuation fails
 * - `isRomaji("a！b&cーd", Regex("""[！ー]"""))` => `true`
 */
fun isRomaji(input: String, allowed: Regex? = null): Boolean {
    return input.all { char ->
        char.isRomaji() || (allowed?.matches(char.toString()) ?: false)
    }
}
