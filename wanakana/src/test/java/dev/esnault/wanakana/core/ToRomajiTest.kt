package dev.esnault.wanakana.core

import dev.esnault.wanakana.DynamicTestsBuilder
import dev.esnault.wanakana.IMEMode
import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.helpers.EN_PUNC
import dev.esnault.wanakana.helpers.JA_PUNC
import dev.esnault.wanakana.toRomaji
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestFactory

@DisplayName("toRomaji()")
class ToRomajiTest {

    private fun DynamicTestsBuilder.testRoma(name: String, input: String, expected: String) =
        testEquals(name = name, expected = expected) { toRomaji(input) }

    @TestFactory
    @DisplayName("Basic usage")
    fun basicUsage() = dynamicTests {
        testRoma(name = "Sane default", input = "", expected = "")
        testRoma(
            name = "Convert katakana to romaji",
            input = "ワニカニ　ガ　スゴイ　ダ",
            expected = "wanikani ga sugoi da"
        )
        testRoma(
            name = "Convert hiragana to romaji",
            input = "わにかに　が　すごい　だ",
            expected = "wanikani ga sugoi da"
        )
        testRoma(
            name = "Convert mixed kana to romaji",
            input = "ワニカニ　ガ　スゴイ　ダ",
            expected = "wanikani ga sugoi da"
        )
        testRoma(
            name = "Convert katakana to romaji",
            input = "ワニカニ　が　すごい　だ",
            expected = "wanikani ga sugoi da"
        )
        testRoma(
            name = "Will convert punctuation and full-width spaces",
            input = JA_PUNC.joinToString(separator = ""),
            expected = EN_PUNC.joinToString(separator = "")
        )
        testEquals(
            name = "Use the upcaseKatakana flag to preserve casing. Works for katakana.",
            expected = "WANIKANI"
        ) { toRomaji("ワニカニ", upcaseKatakana = true) }
        testEquals(
            name = "Use the upcaseKatakana flag to preserve casing. Works for mixed kana.",
            expected = "WANIKANI ga sugoi da"
        ) { toRomaji("ワニカニ　が　すごい　だ", upcaseKatakana = true) }
        testRoma(
            name = "Converts long dash 'ー' in hiragana to hyphen",
            input = "ばつげーむ",
            expected = "batsuge-mu"
        )
        testRoma(
            name = "Doesn't confuse '一' (one kanji) for long dash 'ー'",
            input = "一抹げーむ",
            expected = "一抹ge-mu"
        )
        testRoma(
            name = "Converts long dash 'ー' (chōonpu) in katakana to long vowel",
            input = "スーパー",
            expected = "suupaa"
        )
        testRoma(
            name = "Doesn't convert オー to 'ou' which occurs with hiragana",
            input = "缶コーヒー",
            expected = "缶koohii"
        )
        testNotEquals(
            name = "Spaces must be manually entered",
            expected = "wanikani ga sugoi da"
        ) { toRomaji("わにかにがすごいだ") }
    }

    @TestFactory
    @DisplayName("Double n's and double consonants")
    fun doubleConsonants() = dynamicTests {
        testRoma("Double and single n", input = "きんにくまん", expected = "kinnikuman")
        testRoma("N extravaganza", input = "んんにんにんにゃんやん", expected = "nnninninnyan'yan")
        testRoma(
            name = "Double consonants",
            input = "かっぱ　たった　しゅっしゅ ちゃっちゃ　やっつ",
            expected = "kappa tatta shusshu chatcha yattsu"
        )
    }

    @TestFactory
    @DisplayName("Small kana")
    fun smallKana() = dynamicTests {
        testRoma("Small tsu doesn't transliterate", input = "っ", expected = "")
        testRoma("Small kata ke doesn't transliterate", input = "ヶ", expected = "ヶ")
        testRoma("Small kata ka doesn't transliterate", input = "ヵ", expected = "ヵ")
        testRoma("Small ya", input = "ゃ", expected = "ya")
        testRoma("Small yu", input = "ゅ", expected = "yu")
        testRoma("Small yo", input = "ょ", expected = "yo")
        testRoma("Small a", input = "ぁ", expected = "a")
        testRoma("Small i", input = "ぃ", expected = "i")
        testRoma("Small u", input = "ぅ", expected = "u")
        testRoma("Small e", input = "ぇ", expected = "e")
        testRoma("Small o", input = "ぉ", expected = "o")
    }

    @TestFactory
    @DisplayName("Apostrophes in ambiguous consonant vowel combos")
    fun apostrophes() = dynamicTests {
        testRoma("おんよみ", input = "おんよみ", expected = "on'yomi")
        testRoma("んよ んあ んゆ", input = "んよ んあ んゆ", expected = "n'yo n'a n'yu")
        testRoma("シンヨ", input = "シンヨ", expected = "shin'yo")
    }

    @Nested
    @DisplayName("IMEMode")
    inner class IMEModeTest {
        @TestFactory
        @DisplayName("Without IME Mode")
        fun withoutIMEMode() = dynamicTests {
            testRoma(
                name = "Solo ん is transliterated regardless of following chars",
                input = "ん",
                expected = "n"
            )
            testRoma(
                name = "Last ん is transliterated regardless of following chars",
                input = "うん",
                expected = "un"
            )
        }

        @TestFactory
        @DisplayName("With IME Mode")
        fun withIMEMode() = dynamicTests {
            fun testWithIME(name: String, input: String, expected: String) =
                testEquals(name = name, expected = expected) {
                    toRomaji(input, imeMode = IMEMode.ENABLED)
                }
            testWithIME(
                name = "solo ん's are not transliterated unless chars follow - solo ん",
                input = "ん",
                expected = "ん"
            )
            testWithIME(
                name = "solo ん's are not transliterated unless chars follow - last ん",
                input = "しん",
                expected = "shiん"
            )
            testWithIME(
                name = "solo n's are not transliterated unless chars follow - ん becomes n'a",
                input = "しんあ",
                expected = "shin'a"
            )
        }
    }
}
