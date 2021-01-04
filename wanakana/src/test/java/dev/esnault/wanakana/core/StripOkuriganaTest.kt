package dev.esnault.wanakana.core

import dev.esnault.wanakana.DynamicTestsBuilder
import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.stripOkurigana
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory

@DisplayName("stripOkurigana()")
class StripOkuriganaTest {

    fun DynamicTestsBuilder.test(name: String, input: String, expected: String) =
        testEquals(name = name, expected = expected) { stripOkurigana(input = input) }

    @TestFactory
    @DisplayName("Sane defaults")
    fun saneDefaultsTest() = dynamicTests {
        test(name = "Empty", input = "", expected = "")
        test(name = "Kana", input = "ふふフフ", expected = "ふふフフ")
        test(name = "Romaji", input = "abc", expected = "abc")
        test(name = "Romaji + Kana", input = "ふaふbフcフ", expected = "ふaふbフcフ")
    }

    @TestFactory
    @DisplayName("Basic usage")
    fun basicUsageTest() = dynamicTests {
        test(name = "踏み込む -> 踏み込", input = "踏み込む", expected = "踏み込")
        test(name = "使い方 -> 使い方", input = "使い方", expected = "使い方")
        test(name = "申し申し -> 申し申", input = "申し申し", expected = "申し申")
        test(name = "お腹 -> お腹", input = "お腹", expected = "お腹")
        test(name = "お腹 -> お腹", input = "お祝い", expected = "お祝")
    }

    @TestFactory
    @DisplayName("Strip leading")
    fun stripLeadingTest() = dynamicTests {
        fun testLeading(name: String, input: String, expected: String) =
            testEquals(name = name, expected = expected) {
                stripOkurigana(input = input, leading = true)
            }

        testLeading(name = "踏み込む -> 踏み込む", input = "踏み込む", expected = "踏み込む")
        testLeading(name = "お腹 -> 腹", input = "お腹", expected = "腹")
        testLeading(name = "お祝い -> 祝い", input = "お祝い", expected = "祝い")
    }

    @TestFactory
    @DisplayName("Match kanji")
    fun matchKanjiTest() = dynamicTests {
        testEquals(name = "おはら -> おはら", expected = "おはら") {
            stripOkurigana("おはら", matchKanji = "お腹")
        }
        testEquals(name = "ふみこむ -> ふみこ", expected = "ふみこ") {
            stripOkurigana("ふみこむ", matchKanji = "踏み込む")
        }
        testEquals(name = "おみまい -> みまい", expected = "みまい") {
            stripOkurigana("おみまい", matchKanji = "お祝い", leading = true)
        }
        testEquals(name = "おはら -> はら", expected = "はら") {
            stripOkurigana("おはら", matchKanji = "お腹", leading = true)
        }
    }
}
