package dev.esnault.wanakana.core

import dev.esnault.wanakana.DynamicTestsBuilder
import dev.esnault.wanakana.IMEMode
import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.helpers.EN_PUNC
import dev.esnault.wanakana.helpers.JA_PUNC
import dev.esnault.wanakana.toKana
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestFactory


@DisplayName("toKana()")
class ToKanaTest {

    private fun DynamicTestsBuilder.testKana(name: String, input: String, expected: String) =
        testEquals(name = name, expected = expected) { toKana(input) }

    @TestFactory
    @DisplayName("Basic usage")
    fun basicUsage() = dynamicTests {
        testKana(name = "Sane default", input = "", expected = "")
        testKana(
            name = "Lowercase characters are transliterated to hiragana",
            input = "onaji",
            expected = "おなじ"
        )
        testKana(
            name = "Lowercase with double consonants and double vowels are transliterated to hiragana",
            input = "buttsuuji",
            expected = "ぶっつうじ"
        )
        testKana(
            name = "Uppercase characters are transliterated to katakana",
            input = "ONAJI",
            expected = "オナジ"
        )
        testKana(
            name = "Uppercase with double consonants and double vowels are transliterated to katakana",
            input = "BUTTSUUJI",
            expected = "ブッツウジ"
        )
        testKana(
            name = "WaniKani -> わにかに - Mixed case returns hiragana (katakana only if all letters of mora are uppercased)",
            input = "WaniKani",
            expected = "わにかに"
        )
        testKana(
            name = "Non-romaji will be passed through",
            input = "ワニカニ AiUeO 鰐蟹 12345 @#\$%",
            expected = "ワニカニ アいウえオ 鰐蟹 12345 @#\$%"
        )
        testKana(
            name = "It handles mixed syllabaries",
            input = "座禅‘zazen’スタイル",
            expected = "座禅「ざぜん」スタイル"
        )
        testKana(
            name = "Will convert short to long dashes",
            input = "batsuge-mu",
            expected = "ばつげーむ"
        )
        testKana(
            name = "Will convert punctuation but pass through spaces",
            input = EN_PUNC.joinToString(separator = " "),
            expected = JA_PUNC.joinToString(separator = " ")
        )
    }

    @Nested
    @DisplayName("IMEMode")
    inner class IMEModeTest {
        @TestFactory
        @DisplayName("Without IME Mode")
        fun withoutIMEMode() = dynamicTests {
            testKana(
                name = "solo n is transliterated regardless of following chars",
                input = "n",
                expected = "ん"
            )
            testKana(
                name = "last n is transliterated regardless of following chars",
                input = "shin",
                expected = "しん"
            )
            testKana(
                name = "double n's are transliterated to double ん",
                input = "nn",
                expected = "んん"
            )
        }

        @TestFactory
        @DisplayName("With IME Mode")
        fun withIMEMode() = dynamicTests {
            fun testWithIME(name: String, input: String, expected: String) =
                testEquals(name = name, expected = expected) {
                    toKana(input, imeMode = IMEMode.ENABLED)
                }

            testWithIME(
                name = "solo n's are not transliterated unless chars follow - solo n",
                input = "n",
                expected = "n"
            )
            testWithIME(
                name = "solo n's are not transliterated unless chars follow - last n",
                input = "shin",
                expected = "しn"
            )
            testWithIME(
                name = "solo n's are not transliterated unless chars follow - solo n becomes に",
                input = "shinyou",
                expected = "しにょう"
            )
            testWithIME(
                name = "solo n's are not transliterated unless chars follow - solo n + '",
                input = "shin'you",
                expected = "しんよう"
            )
            testWithIME(
                name = "solo n's are not transliterated unless chars follow - solo n + [space]",
                input = "shin you",
                expected = "しんよう"
            )
            testWithIME(
                name = "double n's are transliterated to single ん",
                input = "nn",
                expected = "ん"
            )
        }
    }

    @Nested
    @DisplayName("Obsolete kanas")
    inner class ObsoleteKanasTest {
        @TestFactory
        @DisplayName("Without obsolete kanas")
        fun withoutObsoleteKanas() = dynamicTests {
            testKana(name = "wi -> うぃ", input = "wi", expected = "うぃ")
            testKana(name = "WI -> ウィ", input = "WI", expected = "ウィ")
        }

        @TestFactory
        @DisplayName("With obsolete kanas")
        fun withObsoleteKanas() = dynamicTests {
            fun testWithObsolete(name: String, input: String, expected: String) =
                testEquals(name = name, expected = expected) {
                    toKana(input, useObsoleteKana = true)
                }

            testWithObsolete(name = "wi -> ゐ", input = "wi", expected = "ゐ")
            testWithObsolete(name = "we -> ゑ", input = "we", expected = "ゑ")
            testWithObsolete(name = "WI -> ヰ", input = "WI", expected = "ヰ")
            testWithObsolete(name = "WE -> ヱ", input = "WE", expected = "ヱ")
        }
    }
}
