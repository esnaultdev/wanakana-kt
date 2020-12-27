package dev.esnault.wanakana.utils

import dev.esnault.wanakana.Constants

private fun Char.isInitialLongDash(index: Int): Boolean = isLongDash() && index < 1
private fun Char.isInnerLongDash(index: Int): Boolean = isLongDash() && index > 0
private fun Char.isKanaAsSymbol(): Boolean = this in listOf('ヶ', 'ヵ')
val LONG_VOWELS = mapOf<Char, Char>(
    'a' to 'あ',
    'i' to 'い',
    'u' to 'う',
    'e' to 'え',
    'o' to 'う',
)

fun katakanaToHiragana(input: String, isDestinationRomaji: Boolean): String {
    var previousKana: Char? = null
    return buildString {
        input.forEachIndexed { index, char ->
            // Short circuit to avoid incorrect codeshift for 'ー' and '・'
            if (char.isSlashDot() || char.isInitialLongDash(index) || char.isKanaAsSymbol()) {
                append(char)
            } else if (previousKana != null && char.isInnerLongDash(index)) {
                // Transform long vowels: 'オー' to 'おう'
                // Transform previousKana back to romaji, and slice off the vowel
                val romaji = toRomaji(previousKana.toString()).last()
                // However, ensure 'オー' => 'おお' => 'oo' if this is a transform on the way to
                // romaji
                if (input[index - 1].isKatakana() && romaji == 'o' && isDestinationRomaji) {
                    append('お')
                } else {
                    LONG_VOWELS[romaji]?.let { append(it) }
                }
            } else if (!char.isLongDash() && char.isKatakana()) {
                // Shift charcode.
                val code = char.toInt() + (Constants.HIRAGANA_START - Constants.KATAKANA_START)
                val hiraChar = code.toChar()
                previousKana = hiraChar
                append(hiraChar)
            } else {
                // Pass non katakana chars through
                previousKana = null
                append(char)
            }
        }
    }
}

// TODO Need to implement toRomaji (but need to create the mapping first)
fun toRomaji(input: String): String = input
