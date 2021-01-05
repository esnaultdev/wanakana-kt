package dev.esnault.wanakana.core

import dev.esnault.wanakana.DynamicTestsBuilder
import dev.esnault.wanakana.dynamicTests
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestFactory


@DisplayName("toKatakana()")
class ToKatakanaTest {

    private fun DynamicTestsBuilder.testKata(name: String, input: String, expected: String) =
        testEquals(name = name, expected = expected) { toKatakana(input) }

    @TestFactory
    @DisplayName("Basic usage")
    fun basicUsage() = dynamicTests {
        testKata(name = "Sane default", input = "", expected = "")
        testKata(
            name = "Lowercase characters",
            input = "onaji",
            expected = "オナジ"
        )
        testKata(
            name = "Double consonants and double vowels",
            input = "buttsuuji",
            expected = "ブッツウジ"
        )
        testKata(
            name = "Uppercase characters",
            input = "ONAJI",
            expected = "オナジ"
        )
        testKata(
            name = "Mixed case",
            input = "WaniKani",
            expected = "ワニカニ"
        )
        testKata(
            name = "Katakana choōnpu",
            input = "すうぱあ",
            expected = "スウパア"
        )
        testKata(
            name = "Katakana choōnpu",
            input = "ばんごう",
            expected = "バンゴウ"
        )
        testKata(
            name = "Mixed input",
            input = "#22 ２２漢字、toukyou, おおさか",
            expected = "#22 ２２漢字、トウキョウ、 オオサカ"
        )
    }

    @TestFactory
    @DisplayName("Iroha (Romaji to Katakana)")
    fun iroha() = dynamicTests {
        fun test(input: String, expected: String) =
            testEquals(name = expected, expected = expected) {
                toKatakana(input, useObsoleteKana = true)
            }

        // https://en.wikipedia.org/wiki/Iroha
        // Even the colorful fragrant flowers'
        test(input = "IROHANIHOHETO", expected = "イロハニホヘト")
        // die sooner or later.'
        test(input = "CHIRINURUWO", expected = "チリヌルヲ")
        // Us who live in this world'
        test(input = "WAKAYOTARESO", expected = "ワカヨタレソ")
        // cannot live forever, either.'
        test(input = "TSUNENARAMU", expected = "ツネナラム")
        // This transient mountain with shifts and changes,'
        test(input = "UWINOOKUYAMA", expected = "ウヰノオクヤマ")
        // today we are going to overcome, and reach the world of enlightenment.'
        test(input = "KEFUKOETE", expected = "ケフコエテ")
        // We are not going to have meaningless dreams'
        test(input = "ASAKIYUMEMISHI", expected = "アサキユメミシ")
        // nor become intoxicated with the fake world anymore.'
        test(input = "WEHIMOSESU", expected = "ヱヒモセス")
        // *not in iroha*
        test(input = "NLTU", expected ="ンッ")
    }

    @Nested
    @DisplayName("IMEMode")
    inner class IMEModeTest {
        @TestFactory
        @DisplayName("Without IME mode")
        fun withoutIMEMode() = dynamicTests {
            testKata(
                name = "solo n is transliterated regardless of following chars",
                input = "n",
                expected = "ン"
            )
            testKata(
                name = "last n is transliterated regardless of following chars",
                input = "shin",
                expected = "シン"
            )
            testKata(
                name = "double n's are transliterated to double ン",
                input = "nn",
                expected = "ンン"
            )
        }

        @TestFactory
        @DisplayName("With IME mode")
        fun withIMEMode() = dynamicTests {
            fun testWithIME(name: String, input: String, expected: String) =
                testEquals(name = name, expected = expected) {
                    toKatakana(input, imeMode = IMEMode.ENABLED)
                }

            testWithIME(
                name = "solo n's are not transliterated unless chars follow - solo n",
                input = "n",
                expected = "n"
            )
            testWithIME(
                name = "solo n's are not transliterated unless chars follow - last n",
                input = "shin",
                expected = "シn"
            )
            testWithIME(
                name = "solo n's are not transliterated unless chars follow - solo n becomes ニ",
                input = "shinyou",
                expected = "シニョウ")
            testWithIME(
                name = "solo n's are not transliterated unless chars follow - solo n + '",
                input = "shin'you",
                expected = "シンヨウ"
            )
            testWithIME(
                name = "solo n's are not transliterated unless chars follow - solo n + [space]",
                input = "shin you",
                expected = "シンヨウ"
            )
            testWithIME(
                name = "double n's are transliterated to single ン",
                input = "nn",
                expected = "ン"
            )
        }
    }

    @Nested
    @DisplayName("Obsolete kanas")
    inner class ObsoleteKanasTest {
        @TestFactory
        @DisplayName("Without obsolete kanas")
        fun withoutObsoleteKanas() = dynamicTests {
            testKata(name = "wi -> ウィ", input = "wi", expected = "ウィ")
            testKata(name = "we -> ウェ", input = "we", expected = "ウェ")
        }

        @TestFactory
        @DisplayName("With obsolete kanas")
        fun withObsoleteKanas() = dynamicTests {
            fun testWithObsolete(name: String, input: String, expected: String) =
                testEquals(name = name, expected = expected) {
                    toKatakana(input, useObsoleteKana = true)
                }

            testWithObsolete(name = "wi -> ヰ", input = "wi", expected = "ヰ")
            testWithObsolete(name = "we -> ヱ", input = "we", expected = "ヱ")
        }
    }

    @TestFactory
    @DisplayName("Pass romaji")
    fun passRomajiTest() = dynamicTests {
        testKata(name = "False by default", expected = "オンly カナ", input = "only かな")
        testEquals(name = "Ignores romaji", expected = "only カナ") {
            toKatakana("only かな", passRomaji = true)
        }
    }
}
