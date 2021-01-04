package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isEnglishPunctuation
import dev.esnault.wanakana.extension.isHiragana
import dev.esnault.wanakana.extension.isJapanese
import dev.esnault.wanakana.extension.isJapanesePunctuation
import dev.esnault.wanakana.extension.isKanji
import dev.esnault.wanakana.extension.isKatakana
import dev.esnault.wanakana.extension.isRomaji

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

/**
 * Splits input into a list of strings separated by opinionated [TokenType]s.
 * @param input the text to tokenize.
 * @param compact if `true`, then many same-language tokens are combined (spaces + text, kanji +
 * kana, numeral + punctuation). Defaults to `false`.
 * @return the text split into [String] tokens.
 *
 * For example:
 * - `tokenize("ふふフフ")` => `["ふふ", "フフ"]`
 * - `tokenize("感じ")` => `["感", "じ"]`
 * - `tokenize("truly 私は悲しい")` => ["truly", " ", "私", "は", "悲", "しい"]`
 * - `tokenize("truly 私は悲しい", compact = true)` => ["truly ", "私は悲しい"]`
 * - `tokenize("5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！")`
 *   => `[ "5", "romaji", " ", "here", "...!?", "漢字", "ひらがな", "カタ", "　", "カナ", "４", "「", "ＳＨＩＯ", "」。！"]`
 * - `tokenize("5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！", compact = true)`
 *   => `[ "5", "romaji here", "...!?", "漢字ひらがなカタ　カナ", "４「", "ＳＨＩＯ", "」。！"]`
 */
fun tokenize(input: String, compact: Boolean = false): List<String> =
    tokenizeWithType(input, compact).map(TypedToken::value)

/**
 * Splits input into a list of tokens separated by opinionated [TokenType]s.
 * @param input the text to tokenize.
 * @param compact if `true`, then many same-language tokens are combined (spaces + text, kanji +
 * kana, numeral + punctuation). Defaults to `false`.
 * @return the text split into [TypedToken]s.
 *
 * For example:
 * - `tokenize('5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！ لنذهب')` =>
 * ```
 * [
 *  { type: 'englishNumeral', value: '5' },
 *  { type: 'en', value: 'romaji' },
 *  { type: 'space', value: ' ' },
 *  { type: 'en', value: 'here' },
 *  { type: 'englishPunctuation', value: '...!?' },
 *  { type: 'kanji', value: '漢字' },
 *  { type: 'hiragana', value: 'ひらがな' },
 *  { type: 'katakana', value: 'カタ' },
 *  { type: 'space', value: '　' },
 *  { type: 'katakana', value: 'カナ' },
 *  { type: 'japaneseNumeral', value: '４' },
 *  { type: 'japanesePunctuation', value: '「' },
 *  { type: 'ja', value: 'ＳＨＩＯ' },
 *  { type: 'japanesePunctuation', value: '」。！' },
 *  { type: 'space', value: ' ' },
 *  { type: 'other', value: 'لنذهب' }
 * ]
 * ```
 *
 * - `tokenize('5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！ لنذهب', compact = true)` =>
 * ```
 * [
 *  { type: 'other', value: '5' },
 *  { type: 'en', value: 'romaji here' },
 *  { type: 'other', value: '...!?' },
 *  { type: 'ja', value: '漢字ひらがなカタ　カナ' },
 *  { type: 'other', value: '４「' },
 *  { type: 'ja', value: 'ＳＨＩＯ' },
 *  { type: 'other', value: '」。！' },
 *  { type: 'en', value: ' ' },
 *  { type: 'other', value: 'لنذهب' }
 * ]
 * ```
 */
fun tokenizeWithType(input: String, compact: Boolean = false): List<TypedToken> {
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
