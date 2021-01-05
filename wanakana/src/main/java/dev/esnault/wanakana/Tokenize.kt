package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isHiragana
import dev.esnault.wanakana.extension.isJapanese
import dev.esnault.wanakana.extension.isKanji
import dev.esnault.wanakana.extension.isKatakana
import dev.esnault.wanakana.extension.isRomaji
import dev.esnault.wanakana.utils.isEnglishPunctuation
import dev.esnault.wanakana.utils.isJapanesePunctuation

/**
 * Type of text token.
 */
enum class TokenType(val value: String) {
    EN("en"),
    JA("ja"),
    EN_NUM("englishNumeral"),
    JA_NUM("japaneseNumeral"),
    EN_PUNC("englishPunctuation"),
    JA_PUNC("japanesePunctuation"),
    KANJI("kanji"),
    HIRAGANA("hiragana"),
    KATAKANA("katakana"),
    SPACE("space"),
    OTHER("other")
}

/**
 * A text token [value] with its associated [type].
 */
data class TypedToken(
    val value: String,
    val type: TokenType
)

internal fun tokenize(input: String, compact: Boolean = false): List<String> =
    tokenizeWithType(input, compact).map(TypedToken::value)

internal fun tokenizeWithType(input: String, compact: Boolean = false): List<TypedToken> {
    if (input.isEmpty()) return emptyList()

    var currentValue: String
    var currentType: TokenType

    // Initialize the current state using the first char
    input.first().let { firstChar ->
        currentValue = firstChar.toString()
        currentType = getType(firstChar, compact)
    }

    val result = mutableListOf<TypedToken>()
    // Iterate through the chars, concatenating same types
    input.drop(1).forEach { char ->
        val type = getType(char, compact)
        if (type == currentType) {
            currentValue += char
        } else {
            result.add(TypedToken(currentValue, currentType))
            currentValue = char.toString()
            currentType = type
        }
    }
    // Don't forget to add the current token.
    result.add(TypedToken(currentValue, currentType))
    return result
}

private fun getType(input: Char, compact: Boolean = false): TokenType {
    return if (compact) {
        when {
            input.isJaNum() -> TokenType.OTHER
            input.isEnNum() -> TokenType.OTHER
            input.isEnSpace() -> TokenType.EN
            input.isEnglishPunctuation() -> TokenType.OTHER
            input.isJaSpace() -> TokenType.JA
            input.isJapanesePunctuation() -> TokenType.OTHER
            input.isJapanese() -> TokenType.JA
            input.isRomaji() -> TokenType.EN
            else -> TokenType.OTHER
        }
    } else {
        when {
            input.isJaSpace() -> TokenType.SPACE
            input.isEnSpace() -> TokenType.SPACE
            input.isJaNum() -> TokenType.JA_NUM
            input.isEnNum() -> TokenType.EN_NUM
            input.isJapanesePunctuation() -> TokenType.JA_PUNC
            input.isEnglishPunctuation() -> TokenType.EN_PUNC
            input.isKanji() -> TokenType.KANJI
            input.isHiragana() -> TokenType.HIRAGANA
            input.isKatakana() -> TokenType.KATAKANA
            input.isJapanese() -> TokenType.JA
            input.isRomaji() -> TokenType.EN
            else -> TokenType.OTHER
        }
    }
}

private fun Char.isEnSpace(): Boolean = this == ' '
private fun Char.isJaSpace(): Boolean = this == '　'
private fun Char.isJaNum(): Boolean = jaNumRegex.matches(this.toString())
private fun Char.isEnNum(): Boolean = enNumRegex.matches(this.toString())

private val jaNumRegex: Regex by lazy(LazyThreadSafetyMode.NONE) { Regex("[０-９]") }
private val enNumRegex: Regex by lazy(LazyThreadSafetyMode.NONE) { Regex("[0-9]") }
