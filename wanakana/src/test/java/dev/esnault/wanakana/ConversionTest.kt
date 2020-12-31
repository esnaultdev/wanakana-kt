package dev.esnault.wanakana

import dev.esnault.wanakana.helpers.*
import dev.esnault.wanakana.utils.safeUpperCase
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestFactory

@DisplayName("Character conversions")
class ConversionTest {

    @Nested
    @DisplayName("Test every conversion table char")
    inner class ConversionTable {
        @TestFactory
        fun toKana() = dynamicTests {
            ROMA_TO_HIRA_KATA.forEach { (romaji, hiragana, katakana) ->
                testEquals(name = "$romaji -> $hiragana", expected = hiragana) {
                    toKana(romaji)
                }
                val upperRomaji = romaji.safeUpperCase()
                testEquals(name = "$upperRomaji -> $katakana", expected = katakana) {
                    toKana(upperRomaji)
                }
            }
        }

        @TestFactory
        fun toHiragana() = dynamicTests {
            ROMA_TO_HIRA_KATA.forEach { (romaji, hiragana) ->
                testEquals(name = "$romaji -> $hiragana", expected = hiragana) {
                    toHiragana(romaji)
                }
                val upperRomaji = romaji.safeUpperCase()
                testEquals(name = "$upperRomaji -> $hiragana", expected = hiragana) {
                    toHiragana(upperRomaji)
                }
            }
        }

        @TestFactory
        fun toKatakana() = dynamicTests {
            ROMA_TO_HIRA_KATA.forEach { (romaji, _, katakana) ->
                testEquals(name = "$romaji -> $katakana", expected = katakana) {
                    toKatakana(romaji)
                }
                val upperRomaji = romaji.safeUpperCase()
                testEquals(name = "$upperRomaji -> $katakana", expected = katakana) {
                    toKatakana(upperRomaji)
                }
            }
        }

        @TestFactory
        fun toRomaji() = dynamicTests {
            HIRA_KATA_TO_ROMA.forEach { (hiragana, katakana, romaji) ->
                if (hiragana.isNotEmpty()) {
                    testEquals(name = "$hiragana -> $romaji", expected = romaji) {
                        toRomaji(hiragana)
                    }
                }
                if (katakana.isNotEmpty()) {
                    testEquals(name = "$katakana -> $romaji", expected = romaji) {
                        toRomaji(katakana)
                    }
                }
            }
        }
    }

    @Nested
    @DisplayName("Converting kana to kana")
    inner class KanaToKanaConversion {

        @TestFactory
        @DisplayName("Basic conversion")
        fun basicConversion() = dynamicTests {            
            testEquals(name = "k -> h", expected = "ばける", actual = toHiragana("バケル"))
            testEquals(name = "h -> k", expected = "バケル", actual = toKatakana("ばける"))

            testEquals(
                name = "It survives only katakana toKatakana",
                expected = "スタイル",
                actual = toKatakana("スタイル")
            )
            testEquals(
                name = "It survives only hiragana toHiragana",
                expected = "すたーいる",
                actual = toHiragana("すたーいる")
            )
            testEquals(
                name = "Mixed kana converts every char k -> h",
                expected = "アメリカジン",
                actual = toKatakana("アメリカじん")
            )
            testEquals(
                name = "Mixed kana converts every char h -> k",
                expected = "あめりかじん",
                actual = toHiragana("アメリカじん")
            )
        }

        @TestFactory
        @DisplayName("Long vowels")
        fun longVowels() = dynamicTests {
            testEquals(
                name = "Converts long vowels correctly from k -> h",
                expected = "ばつごう",
                actual = toHiragana("バツゴー")
            )
            testEquals(
                name = "Preserves long dash from h -> k",
                expected = "バツゲーム",
                actual = toKatakana("ばつゲーム")
            )
            testEquals(
                name = "Preserves long dash from h -> h",
                expected = "ばつげーむ",
                actual = toHiragana("ばつげーむ")
            )
            testEquals(
                name = "Preserves long dash from k -> k",
                expected = "バツゲーム",
                actual = toKatakana("バツゲーム")
            )

            testEquals(
                name = "Preserves long dash from mixed -> k",
                expected = "バツゲーム",
                actual = toKatakana("バツゲーム")
            )
            testEquals(
                name = "Preserves long dash from mixed -> k",
                expected = "テスート",
                actual = toKatakana("テスーと")
            )
            testEquals(
                name = "Preserves long dash from mixed -> h",
                expected = "てすーと",
                actual = toHiragana("てすート")
            )
            testEquals(
                name = "Preserves long dash from mixed -> h",
                expected = "てすー戸",
                actual = toHiragana("てすー戸")
            )
            testEquals(
                name = "Preserves long dash from mixed -> h",
                expected = "手巣ーと",
                actual = toHiragana("手巣ート")
            )
            testEquals(
                name = "Preserves long dash from mixed -> h",
                expected = "てsーと",
                actual = toHiragana("tesート")
            )
            testEquals(
                name = "Preserves long dash from mixed -> h",
                expected = "ーとてす",
                actual = toHiragana("ートtesu")
            )
        }

        @TestFactory
        @DisplayName("Mixed syllabaries")
        fun mixedSyllabaries() = dynamicTests {
            testEquals(
                name = "It passes non-katakana through when passRomaji is true k -> h",
                expected = "座禅‘zazen’すたいる",
                actual = toHiragana("座禅‘zazen’スタイル", passRomaji = true)
            )
            testEquals(
                name = "It passes non-hiragana through when passRomaji is true h -> k",
                expected = "座禅‘zazen’スタイル",
                actual = toKatakana("座禅‘zazen’すたいる", passRomaji = true)
            )
            testEquals(
                name = "It converts non-katakana when passRomaji is false k -> h",
                expected = "座禅「ざぜん」すたいる",
                actual = toHiragana("座禅‘zazen’スタイル")
            )
            testEquals(
                name = "It converts non-hiragana when passRomaji is false h -> k",
                expected = "座禅「ザゼン」スタイル",
                actual = toKatakana("座禅‘zazen’すたいる")
            )
        }
    }

    @TestFactory
    @DisplayName("Case sensitivity")
    fun caseSensitivity() = dynamicTests {
        testEquals(
            name = "cAse DoEsn'T MatTER for toHiragana()",
            expected = toHiragana("aiueo"),
            actual = toHiragana("AIUEO")
        )
        testEquals(
            name = "cAse DoEsn'T MatTER for toKatakana()",
            expected = toKatakana("aiueo"),
            actual = toKatakana("AIUEO")
        )
        testNotEquals(
            name = "cAse DOES MatTER for toKana()",
            expected = toKana("aiueo"),
            actual = toKana("AIUEO")
        )
    }

    @DisplayName("N edge cases")
    @TestFactory
    fun nEdgeCase() = dynamicTests {
        fun test(name: String, input: String, expected: String) =
            testEquals(name, expected) { toKana(input) }

        test("Solo N", "n", "ん")
        test("Solo N", "n", "ん")
        test("double N", "onn", "おんん")
        test("N followed by N* syllable", "onna", "おんな")
        test("Triple N", "nnn", "んんん")
        test("Triple N followed by N* syllable", "onnna", "おんんな")
        test("Quadruple N", "nnnn", "んんんん")
        test("nya -> にゃ", "nyan", "にゃん")
        test("nnya -> んにゃ", "nnyann", "んにゃんん")
        test("nnnya -> んにゃ", "nnnyannn", "んんにゃんんん")
        test("n'ya -> んや", "n'ya", "んや")
        test("kin'ya -> きんや", "kin'ya", "きんや")
        test("shin'ya -> しんや", "shin'ya", "しんや")
        test("kinyou -> きにょう", "kinyou", "きにょう")
        test("kin'you -> きんよう", "kin'you", "きんよう")
        test("kin'yu -> きんゆ", "kin'yu", "きんゆ")
        test("Properly add space after \"n[space]\"", "ichiban warui", "いちばん わるい")
    }

    @DisplayName("Bogus 4 character sequences")
    @TestFactory
    fun bogusFourChar() = dynamicTests {
        fun test(name: String, input: String, expected: String) =
            testEquals(name, expected) { toKana(input) }

        test("Non bogus sequences work", "chya", "ちゃ")
        test("Bogus sequences do not work", "chyx", "chyx")
        test("Bogus sequences do not work", "shyp", "shyp")
        test("Bogus sequences do not work", "ltsb", "ltsb")
    }
}
