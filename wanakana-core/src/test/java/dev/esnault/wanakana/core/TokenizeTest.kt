package dev.esnault.wanakana.core

import dev.esnault.wanakana.DynamicTestsBuilder
import dev.esnault.wanakana.dynamicTests
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals

@DisplayName("tokenize()")
class TokenizeTest {

    fun DynamicTestsBuilder.test(name: String, input: String, expected: List<String>) =
        testEquals(name = name, expected = expected) { tokenize(input = input) }

    @TestFactory
    @DisplayName("Basic usage")
    fun basicUsageTest() = dynamicTests {
        test(name = "Empty", input = "", expected = emptyList())
        test(name = "ふふ", input = "ふふ", expected = listOf("ふふ"))
        test(name = "フフ", input = "フフ", expected = listOf("フフ"))
        test(name = "ふふフフ", input = "ふふフフ", expected = listOf("ふふ", "フフ"))
        test(name = "阮咸", input = "阮咸", expected = listOf("阮咸"))
        test(name = "感じ", input = "感じ", expected = listOf("感", "じ"))
        test(name = "私は悲しい", input = "私は悲しい", expected = listOf("私", "は", "悲", "しい"))
        test(name = "ok لنذهب!", input = "ok لنذهب!", expected = listOf("ok", " ", "لنذهب", "!"))
    }
    
    @Test
    @DisplayName("Handles mixed input")
    fun mixedInputTest() {
        val input = "5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！"
        val tokenized = tokenize(input)
        val expected = listOf(
            "5",
            "romaji",
            " ",
            "here",
            "...!?",
            "漢字",
            "ひらがな",
            "カタ",
            "　",
            "カナ",
            "４",
            "「",
            "ＳＨＩＯ",
            "」。！"
        )
        assertEquals(expected = expected, actual = tokenized)
    }

    @Test
    @DisplayName("compact = true")
    fun compactTest() {
        val input = "5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！ لنذهب"
        val tokenized = tokenize(input, compact = true)
        val expected = listOf(
            "5",
            "romaji here",
            "...!?",
            "漢字ひらがなカタ　カナ",
            "４「",
            "ＳＨＩＯ",
            "」。！",
            " ",
            "لنذهب"
        )
        assertEquals(expected = expected, actual = tokenized)
    }

    @Test
    @DisplayName("tokenizeWithType()")
    fun withTypeTest() {
        val input = "5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！ لنذهب"
        val tokenized = tokenizeWithType(input)
        val expected = listOf(
            TypedToken(type = TokenType.EN_NUM, value = "5"),
            TypedToken(type = TokenType.EN, value = "romaji"),
            TypedToken(type = TokenType.SPACE, value = " "),
            TypedToken(type = TokenType.EN, value = "here"),
            TypedToken(type = TokenType.EN_PUNC, value = "...!?"),
            TypedToken(type = TokenType.KANJI, value = "漢字"),
            TypedToken(type = TokenType.HIRAGANA, value = "ひらがな"),
            TypedToken(type = TokenType.KATAKANA, value = "カタ"),
            TypedToken(type = TokenType.SPACE, value = "　"),
            TypedToken(type = TokenType.KATAKANA, value = "カナ"),
            TypedToken(type = TokenType.JA_NUM, value = "４"),
            TypedToken(type = TokenType.JA_PUNC, value = "「"),
            TypedToken(type = TokenType.JA, value = "ＳＨＩＯ"),
            TypedToken(type = TokenType.JA_PUNC, value = "」。！"),
            TypedToken(type = TokenType.SPACE, value = " "),
            TypedToken(type = TokenType.OTHER, value = "لنذهب")
        )
        assertEquals(expected = expected, actual = tokenized)
    }

    @Test
    @DisplayName("tokenizeWithType(compact = true)")
    fun withTypeAndCompactTest() {
        val input = "5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！ لنذهب"
        val tokenized = tokenizeWithType(input, compact = true)
        val expected = listOf(
            TypedToken(type = TokenType.OTHER, value = "5"),
            TypedToken(type = TokenType.EN, value = "romaji here"),
            TypedToken(type = TokenType.OTHER, value = "...!?"),
            TypedToken(type = TokenType.JA, value = "漢字ひらがなカタ　カナ"),
            TypedToken(type = TokenType.OTHER, value = "４「"),
            TypedToken(type = TokenType.JA, value = "ＳＨＩＯ"),
            TypedToken(type = TokenType.OTHER, value = "」。！"),
            TypedToken(type = TokenType.EN, value = " "),
            TypedToken(type = TokenType.OTHER, value = "لنذهب")
        )
        assertEquals(expected = expected, actual = tokenized)
    }
}
