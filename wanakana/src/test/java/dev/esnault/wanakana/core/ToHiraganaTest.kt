package dev.esnault.wanakana.core

import dev.esnault.wanakana.DynamicTestsBuilder
import dev.esnault.wanakana.IMEMode
import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.toHiragana
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestFactory


@DisplayName("toHiragana()")
class ToHiraganaTest {

    private fun DynamicTestsBuilder.testHira(name: String, input: String, expected: String) =
        testEquals(name = name, expected = expected) { toHiragana(input) }

    @TestFactory
    @DisplayName("Basic usage")
    fun basicUsage() = dynamicTests {
        testHira(name = "Sane default", input = "", expected = "")
        testHira(
            name = "Lowercase characters",
            input = "onaji",
            expected = "おなじ"
        )
        testHira(
            name = "Double consonants and double vowels",
            input = "buttsuuji",
            expected = "ぶっつうじ"
        )
        testHira(
            name = "Uppercase characters",
            input = "ONAJI",
            expected = "おなじ"
        )
        testHira(
            name = "Mixed case",
            input = "WaniKani",
            expected = "わにかに"
        )
        testHira(
            name = "Katakana choōnpu",
            input = "スーパー",
            expected = "すうぱあ"
        )
        testHira(
            name = "Katakana choōnpu",
            input = "バンゴー",
            expected = "ばんごう"
        )
        testHira(
            name = "Mixed input",
            input = "#22 ２２漢字、toukyou, オオサカ",
            expected = "#22 ２２漢字、とうきょう、 おおさか"
        )
    }

    @TestFactory
    @DisplayName("Iroha (Romaji to Hiragana)")
    fun iroha() = dynamicTests {
        fun test(input: String, expected: String) =
            testEquals(name = expected, expected = expected) {
                toHiragana(input, useObsoleteKana = true)
            }
        
        // https://en.wikipedia.org/wiki/Iroha
        // Even the colorful fragrant flowers'
        test(input = "IROHANIHOHETO", expected = "いろはにほへと")
        // die sooner or later.'
        test(input = "CHIRINURUWO", expected = "ちりぬるを")
        // Us who live in this world'
        test(input = "WAKAYOTARESO", expected = "わかよたれそ")
        // cannot live forever, either.'
        test(input = "TSUNENARAMU", expected = "つねならむ")
        // This transient mountain with shifts and changes,'
        test(input = "UWINOOKUYAMA", expected = "うゐのおくやま")
        // today we are going to overcome, and reach the world of enlightenment.'
        test(input = "KEFUKOETE", expected = "けふこえて")
        // We are not going to have meaningless dreams'
        test(input = "ASAKIYUMEMISHI", expected = "あさきゆめみし")
        // nor become intoxicated with the fake world anymore.'
        test(input = "WEHIMOSESU", expected = "ゑひもせす")
        // *not in iroha*
        test(input = "NLTU", expected ="んっ")
    }

    @Nested
    @DisplayName("IMEMode")
    inner class IMEModeTest {
        @TestFactory
        @DisplayName("Without IME Mode")
        fun withoutIMEMode() = dynamicTests {
            testHira(
                name = "solo n is transliterated regardless of following chars",
                input = "n",
                expected = "ん"
            )
            testHira(
                name = "last n is transliterated regardless of following chars",
                input = "shin",
                expected = "しん"
            )
            testHira(
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
                    toHiragana(input, imeMode = IMEMode.ENABLED)
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
            testHira(name = "wi -> うぃ", input = "wi", expected = "うぃ")
            testHira(name = "we -> うぇ", input = "we", expected = "うぇ")
        }

        @TestFactory
        @DisplayName("With obsolete kanas")
        fun withObsoleteKanas() = dynamicTests {
            fun testWithObsolete(name: String, input: String, expected: String) =
                testEquals(name = name, expected = expected) {
                    toHiragana(input, useObsoleteKana = true)
                }

            testWithObsolete(name = "wi -> ゐ", input = "wi", expected = "ゐ")
            testWithObsolete(name = "we -> ゑ", input = "we", expected = "ゑ")
        }
    }

    @TestFactory
    @DisplayName("Pass romaji")
    fun passRomajiTest() = dynamicTests {
        testHira(name = "False by default", expected = "おんly かな", input = "only カナ")
        testEquals(name = "Ignores romaji", expected = "only かな") {
            toHiragana("only カナ", passRomaji = true)
        }
    }
}
