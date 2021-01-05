package dev.esnault.wanakana.api

import dev.esnault.wanakana.core.Config
import dev.esnault.wanakana.core.IMEMode
import dev.esnault.wanakana.core.TokenType
import dev.esnault.wanakana.core.TypedToken
import dev.esnault.wanakana.core.Wanakana
import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.core.extension.isHiragana
import dev.esnault.wanakana.core.extension.isJapanese
import dev.esnault.wanakana.core.extension.isKana
import dev.esnault.wanakana.core.extension.isKanji
import dev.esnault.wanakana.core.extension.isKatakana
import dev.esnault.wanakana.core.extension.isMixed
import dev.esnault.wanakana.core.extension.isRomaji
import dev.esnault.wanakana.core.utils.ImeText
import dev.esnault.wanakana.core.utils.mapping
import dev.esnault.wanakana.core.utils.mappingTreeOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals


/**
 * Interface tests to ensure that refactorings don't impact existing users.
 */
class KotlinInterfaceTest {

    @Nested
    @DisplayName("Wanakana methods")
    inner class WanakanaTest {

        @TestFactory
        @DisplayName("toHiragana()")
        fun toHiraganaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "おなじ") {
                Wanakana.toHiragana("onaji")
            }
            testEquals(name = "all parameters", expected = "おなゐ") {
                Wanakana.toHiragana("onawi", IMEMode.DISABLED, false, true)
            }
            testEquals(name = "all parameters - named", expected = "おなゐ") {
                Wanakana.toHiragana(
                    input = "onawi",
                    imeMode = IMEMode.DISABLED,
                    passRomaji = false,
                    useObsoleteKana = true
                )
            }
            testEquals(name = "config", expected = "おなじ") {
                Wanakana.toHiragana("onaji", Config.DEFAULT)
            }
            testEquals(name = "config - named", expected = "おなじ") {
                Wanakana.toHiragana(input = "onaji", config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toKatakana()")
        fun toKatakanaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "オナジ") {
                Wanakana.toKatakana("onaji")
            }
            testEquals(name = "all parameters", expected = "オナヰ") {
                Wanakana.toKatakana("onawi", IMEMode.DISABLED, false, true)
            }
            testEquals(name = "all parameters - named", expected = "オナヰ") {
                Wanakana.toKatakana(
                    input = "onawi",
                    imeMode = IMEMode.DISABLED,
                    passRomaji = false,
                    useObsoleteKana = true
                )
            }
            testEquals(name = "config", expected = "オナジ") {
                Wanakana.toKatakana("onaji", Config.DEFAULT)
            }
            testEquals(name = "config - named", expected = "オナジ") {
                Wanakana.toKatakana(input = "onaji", config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toKana()")
        fun toKanaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "おなじ") {
                Wanakana.toKana("onaji")
            }
            testEquals(name = "all parameters", expected = "おなゐ") {
                Wanakana.toKana("onawi", IMEMode.DISABLED, true)
            }
            testEquals(name = "all parameters - named", expected = "おなゐ") {
                Wanakana.toKana(input = "onawi", imeMode = IMEMode.DISABLED, useObsoleteKana = true)
            }
            testEquals(name = "config", expected = "おなじ") {
                Wanakana.toKana("onaji", Config.DEFAULT)
            }
            testEquals(name = "config - named", expected = "おなじ") {
                Wanakana.toKana(input = "onaji", config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toKanaIme()")
        fun toKanaImeTest() = dynamicTests {
            testEquals(name = "minimal input", expected = simpleIme("おなじ")) {
                Wanakana.toKanaIme(simpleIme("onaji"))
            }
            testEquals(name = "all parameters", expected = simpleIme("おなゐ")) {
                Wanakana.toKanaIme(simpleIme("onawi"), IMEMode.DISABLED, true)
            }
            testEquals(name = "all parameters - named", expected = simpleIme("おなゐ")) {
                Wanakana.toKanaIme(
                    input = simpleIme("onawi"),
                    imeMode = IMEMode.DISABLED,
                    useObsoleteKana = true
                )
            }
            testEquals(name = "config", expected = simpleIme("おなじ")) {
                Wanakana.toKanaIme(simpleIme("onaji"), Config.DEFAULT)
            }
            testEquals(name = "config - named", expected = simpleIme("おなじ")) {
                Wanakana.toKanaIme(input = simpleIme("onaji"), config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toRomaji()")
        fun toRomajiTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "onaji") {
                Wanakana.toRomaji("おなじ")
            }
            testEquals(name = "all parameters", expected = "ONAJI") {
                Wanakana.toRomaji("オナジ", IMEMode.DISABLED, true)
            }
            testEquals(name = "all parameters - named", expected = "ONAJI") {
                Wanakana.toRomaji(
                    input = "オナジ",
                    imeMode = IMEMode.DISABLED,
                    upcaseKatakana = true
                )
            }
            testEquals(name = "config", expected = "onaji") {
                Wanakana.toRomaji("おなじ", Config.DEFAULT)
            }
            testEquals(name = "config - named", expected = "onaji") {
                Wanakana.toRomaji(input = "おなじ", config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toRomajiIme()")
        fun toRomajiImeTest() = dynamicTests {
            testEquals(name = "minimal input", expected = simpleIme("onaじ")) {
                Wanakana.toRomajiIme(simpleIme("おなじ"))
            }
            testEquals(name = "all parameters", expected = simpleIme("ONAJI")) {
                Wanakana.toRomajiIme(simpleIme("オナジ"), IMEMode.DISABLED, true)
            }
            testEquals(name = "all parameters - named", expected = simpleIme("ONAJI")) {
                Wanakana.toRomajiIme(
                    input = simpleIme("オナジ"),
                    imeMode = IMEMode.DISABLED,
                    upcaseKatakana = true
                )
            }
            testEquals(name = "config", expected = simpleIme("onaji")) {
                Wanakana.toRomajiIme(simpleIme("おなじ"), Config.DEFAULT)
            }
            testEquals(name = "config - named", expected = simpleIme("onaji")) {
                Wanakana.toRomajiIme(input = simpleIme("おなじ"), config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("stripOkurigana()")
        fun stripOkuriganaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "お祝") {
                Wanakana.stripOkurigana("お祝い")
            }
            testEquals(name = "all parameters", expected = "みまい") {
                Wanakana.stripOkurigana("おみまい", true, "お祝い")
            }
            testEquals(name = "all parameters - named", expected = "みまい") {
                Wanakana.stripOkurigana(input = "おみまい", leading = true, matchKanji = "お祝い")
            }
        }

        @TestFactory
        @DisplayName("tokenize()")
        fun tokenizeTest() = dynamicTests {
            testEquals(name = "minimal input", expected = listOf("ア", "お")) {
                Wanakana.tokenize("アお")
            }
            testEquals(name = "all parameters", expected = listOf("アお")) {
                Wanakana.tokenize("アお", true)
            }
            testEquals(name = "all parameters - named", expected = listOf("アお")) {
                Wanakana.tokenize(input = "アお", compact = true)
            }
        }

        @TestFactory
        @DisplayName("tokenizeWithType()")
        fun tokenizeWithTypeTest() = dynamicTests {
            test(name = "minimal input") {
                val expected = listOf(
                    TypedToken("ア", TokenType.KATAKANA),
                    TypedToken("お", TokenType.HIRAGANA)
                )
                val result = Wanakana.tokenizeWithType("アお")
                assertEquals(expected = expected, actual = result)
            }
            test(name = "all parameters") {
                val expected = listOf(
                    TypedToken("アお", TokenType.JA)
                )
                val result = Wanakana.tokenizeWithType("アお", true)
                assertEquals(expected = expected, actual = result)
            }
            test(name = "all parameters - named") {
                val expected = listOf(
                    TypedToken("アお", TokenType.JA)
                )
                val result = Wanakana.tokenizeWithType(input = "アお", compact = true)
                assertEquals(expected = expected, actual = result)
            }
        }

        @Nested
        @DisplayName("Detection methods")
        inner class DetectionMethods {
            @TestFactory
            @DisplayName("String")
            fun stringTest() = dynamicTests {
                testTrue(name = "isKana()") { Wanakana.isKana("あ") }
                testTrue(name = "isHiragana()") { Wanakana.isHiragana("あ") }
                testTrue(name = "isKatakana()") { Wanakana.isKatakana("ア") }
                testTrue(name = "isMixed()") { Wanakana.isMixed("Abあア") }
                testFalse(name = "isMixed(passKanji)") {
                    Wanakana.isMixed("お腹A", false)
                }
                testTrue(name = "isKanji()") { Wanakana.isKanji("腹") }
                testTrue(name = "isJapanese()") { Wanakana.isJapanese("泣き虫") }
                testTrue(name = "isJapanese(regex)") {
                    Wanakana.isJapanese("≪偽括弧≫", Regex("""[≪≫]"""))
                }
                testTrue(name = "isRomaji()") { Wanakana.isRomaji("Tōkyō and Ōsaka") }
                testTrue(name = "isRomaji(regex)") {
                    Wanakana.isRomaji("a！b&cーd", Regex("""[！ー]"""))
                }
            }

            @TestFactory
            @DisplayName("String - named")
            fun stringNamedTest() = dynamicTests {
                testTrue(name = "isKana()") { Wanakana.isKana(input = "あ") }
                testTrue(name = "isHiragana()") { Wanakana.isHiragana(input = "あ") }
                testTrue(name = "isKatakana()") { Wanakana.isKatakana(input = "ア") }
                testTrue(name = "isMixed()") { Wanakana.isMixed(input = "Abあア") }
                testFalse(name = "isMixed(passKanji)") {
                    Wanakana.isMixed(input = "お腹A", passKanji = false)
                }
                testTrue(name = "isKanji()") { Wanakana.isKanji(input = "腹") }
                testTrue(name = "isJapanese()") { Wanakana.isJapanese(input = "泣き虫") }
                testTrue(name = "isJapanese(regex)") {
                    Wanakana.isJapanese(input = "≪偽括弧≫", allowed = Regex("""[≪≫]"""))
                }
                testTrue(name = "isRomaji()") { Wanakana.isRomaji(input = "Tōkyō and Ōsaka") }
                testTrue(name = "isRomaji(regex)") {
                    Wanakana.isRomaji(input = "a！b&cーd", allowed = Regex("""[！ー]"""))
                }
            }

            @TestFactory
            @DisplayName("Char")
            fun charTest() = dynamicTests {
                testTrue(name = "isKana()") { Wanakana.isKana('あ') }
                testTrue(name = "isHiragana()") { Wanakana.isHiragana('あ') }
                testTrue(name = "isKatakana()") { Wanakana.isKatakana('ア') }
                testTrue(name = "isKanji()") { Wanakana.isKanji('腹') }
                testTrue(name = "isJapanese()") { Wanakana.isJapanese('泣') }
                testTrue(name = "isRomaji()") { Wanakana.isRomaji('Ō') }
            }

            @TestFactory
            @DisplayName("Char - named")
            fun detectionMethodsTest() = dynamicTests {
                testTrue(name = "isKana()") { Wanakana.isKana(input = 'あ') }
                testTrue(name = "isHiragana()") { Wanakana.isHiragana(input = 'あ') }
                testTrue(name = "isKatakana()") { Wanakana.isKatakana(input = 'ア') }
                testTrue(name = "isKanji()") { Wanakana.isKanji(input = '腹') }
                testTrue(name = "isJapanese()") { Wanakana.isJapanese(input = '泣') }
                testTrue(name = "isRomaji()") { Wanakana.isRomaji(input = 'Ō') }
            }
        }
    }

    @TestFactory
    @DisplayName("Extensions")
    fun detectionMethodsExtTest() = dynamicTests {
        // String
        testTrue(name = "isKana()") { "あ".isKana() }
        testTrue(name = "isHiragana()") { "あ".isHiragana() }
        testTrue(name = "isKatakana()") { "ア".isKatakana() }
        testTrue(name = "isMixed()") { "Abあア".isMixed() }
        testFalse(name = "isMixed(passKanji)") { "お腹A".isMixed(false) }
        testFalse(name = "isMixed(passKanji) - named") { "お腹A".isMixed(passKanji = false) }
        testTrue(name = "isKanji()") { "腹".isKanji() }
        testTrue(name = "isJapanese()") { "泣き虫".isJapanese() }
        testTrue(name = "isJapanese(regex)") {
            "≪偽括弧≫".isJapanese(Regex("""[≪≫]"""))
        }
        testTrue(name = "isJapanese(regex) - named") {
            "≪偽括弧≫".isJapanese(allowed = Regex("""[≪≫]"""))
        }
        testTrue(name = "isRomaji()") { "Tōkyō and Ōsaka".isRomaji() }
        testTrue(name = "isRomaji(regex)") {
            "a！b&cーd".isRomaji(Regex("""[！ー]"""))
        }
        testTrue(name = "isRomaji(regex) - named") {
            "a！b&cーd".isRomaji(allowed = Regex("""[！ー]"""))
        }

        // Char
        testTrue(name = "isKana()") { 'あ'.isKana() }
        testTrue(name = "isHiragana()") { 'あ'.isHiragana() }
        testTrue(name = "isKatakana()") { 'ア'.isKatakana() }
        testTrue(name = "isKanji()") { '腹'.isKanji() }
        testTrue(name = "isJapanese()") { '泣'.isJapanese() }
        testTrue(name = "isRomaji()") { 'Ō'.isRomaji() }
    }

    @Nested
    @DisplayName("Config")
    inner class ConfigTest {
        @Test
        fun defaultConfig() {
            val config = Config.DEFAULT
            val expected = Config(false, false, false, IMEMode.DISABLED)
            assertEquals(expected = expected, actual = config)
        }

        @Test
        fun createConfigWithUpcaseKatakana() {
            val config = Config(upcaseKatakana = true)
            val expected = Config(false, false, true, IMEMode.DISABLED)
            assertEquals(expected = expected, actual = config)
        }

        @Test
        fun updateConfigWithUpcaseKatakana() {
            val config = Config.DEFAULT
            val newConfig = config.copy(upcaseKatakana = true)
            val expected = Config(false, false, true, IMEMode.DISABLED)
            assertEquals(expected = expected, actual = newConfig)
        }
    }

    @Test
    @DisplayName("Custom mapping")
    fun customMappingTest() {
        val mapping = mapping {
            value = "test"
            "ab" to "other"
            "c" to mapping { value = "another" }
        }
        val expected = mappingTreeOf(
            value = "test",
            subTrees = mapOf(
                'a' to mappingTreeOf(
                    subTrees = mapOf(
                        'b' to mappingTreeOf(
                            value = "other"
                        )
                    )
                ),
                'c' to mappingTreeOf(
                    value = "another"
                )
            )
        )
        assertEquals(expected = expected, actual = mapping)
    }
}

private fun simpleIme(text: String): ImeText = ImeText(text, -1..-1)
