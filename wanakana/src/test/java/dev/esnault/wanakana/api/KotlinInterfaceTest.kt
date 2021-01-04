package dev.esnault.wanakana.api

import dev.esnault.wanakana.Config
import dev.esnault.wanakana.IMEMode
import dev.esnault.wanakana.TokenType
import dev.esnault.wanakana.TypedToken
import dev.esnault.wanakana.Wanakana
import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.extension.isHiragana
import dev.esnault.wanakana.extension.isJapanese
import dev.esnault.wanakana.extension.isKana
import dev.esnault.wanakana.extension.isKanji
import dev.esnault.wanakana.extension.isKatakana
import dev.esnault.wanakana.extension.isMixed
import dev.esnault.wanakana.extension.isRomaji
import dev.esnault.wanakana.isHiragana
import dev.esnault.wanakana.isJapanese
import dev.esnault.wanakana.isKana
import dev.esnault.wanakana.isKanji
import dev.esnault.wanakana.isKatakana
import dev.esnault.wanakana.isMixed
import dev.esnault.wanakana.isRomaji
import dev.esnault.wanakana.stripOkurigana
import dev.esnault.wanakana.toHiragana
import dev.esnault.wanakana.toKana
import dev.esnault.wanakana.toKatakana
import dev.esnault.wanakana.toRomaji
import dev.esnault.wanakana.tokenize
import dev.esnault.wanakana.tokenizeWithType
import dev.esnault.wanakana.utils.mapping
import dev.esnault.wanakana.utils.mappingTreeOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals


/**
 * Interface tests to ensure that refactorings don't impact existing users.
 *
 * // TODO Add tests for named parameters.
 */
class KotlinInterfaceTest {

    @Nested
    @DisplayName("Standalone import")
    inner class StandaloneTest {

        @TestFactory
        @DisplayName("toHiragana()")
        fun toHiraganaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "おなじ") {
                toHiragana("onaji")
            }
            testEquals(name = "all parameters", expected = "おなゐ") {
                toHiragana("onawi", IMEMode.DISABLED, false, true)
            }
            testEquals(name = "config", expected = "おなじ") {
                toHiragana("onaji", Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toKatakana()")
        fun toKatakanaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "オナジ") {
                toKatakana("onaji")
            }
            testEquals(name = "all parameters", expected = "オナヰ") {
                toKatakana("onawi", IMEMode.DISABLED, false, true)
            }
            testEquals(name = "config", expected = "オナジ") {
                toKatakana("onaji", Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toKana()")
        fun toKanaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "おなじ") {
                toKana("onaji")
            }
            testEquals(name = "all parameters", expected = "おなゐ") {
                toKana("onawi", IMEMode.DISABLED, true)
            }
            testEquals(name = "config", expected = "おなじ") {
                toKana("onaji", Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toRomaji()")
        fun toRomajiTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "onaji") {
                toRomaji("おなじ")
            }
            testEquals(name = "all parameters", expected = "ONAJI") {
                toRomaji("オナジ", IMEMode.DISABLED, true)
            }
            testEquals(name = "config", expected = "onaji") {
                toRomaji(input = "おなじ", config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("stripOkurigana()")
        fun stripOkuriganaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "お祝") {
                stripOkurigana("お祝い")
            }
            testEquals(name = "all parameters", expected = "みまい") {
                stripOkurigana("おみまい", true, matchKanji = "お祝い")
            }
        }

        @TestFactory
        @DisplayName("tokenize()")
        fun tokenizeTest() = dynamicTests {
            testEquals(name = "minimal input", expected = listOf("ア", "お")) {
                tokenize("アお")
            }
            testEquals(name = "all parameters", expected = listOf("アお")) {
                tokenize("アお", true)
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
                val result = tokenizeWithType("アお")
                assertEquals(expected = expected, actual = result)
            }
            test(name = "all parameters") {
                val expected = listOf(
                    TypedToken("アお", TokenType.JA)
                )
                val result = tokenizeWithType("アお", true)
                assertEquals(expected = expected, actual = result)
            }
        }
        
        @TestFactory
        @DisplayName("Detection methods")
        fun detectionMethodsTest() = dynamicTests {
            // String
            testTrue(name = "isKana()") { isKana("あ") }
            testTrue(name = "isHiragana()") { isHiragana("あ") }
            testTrue(name = "isKatakana()") { isKatakana("ア") }
            testTrue(name = "isMixed()") { isMixed("Abあア") }
            testFalse(name = "isMixed(passKanji)") { isMixed("お腹A", false) }
            testTrue(name = "isKanji()") { isKanji("腹") }
            testTrue(name = "isJapanese()") { isJapanese("泣き虫") }
            testTrue(name = "isJapanese(regex)") {
                isJapanese("≪偽括弧≫", Regex("""[≪≫]"""))
            }
            testTrue(name = "isRomaji()") { isRomaji("Tōkyō and Ōsaka") }
            testTrue(name = "isRomaji(regex)") {
                isRomaji("a！b&cーd", Regex("""[！ー]"""))
            }

            // Char
            testTrue(name = "isKana()") { isKana('あ') }
            testTrue(name = "isHiragana()") { isHiragana('あ') }
            testTrue(name = "isKatakana()") { isKatakana('ア') }
            testTrue(name = "isKanji()") { isKanji('腹') }
            testTrue(name = "isJapanese()") { isJapanese('泣') }
            testTrue(name = "isRomaji()") { isRomaji('Ō') }
        }
    }

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
            testEquals(name = "config", expected = "おなじ") {
                Wanakana.toHiragana("onaji", Config.DEFAULT)
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
            testEquals(name = "config", expected = "オナジ") {
                Wanakana.toKatakana("onaji", Config.DEFAULT)
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
            testEquals(name = "config", expected = "おなじ") {
                Wanakana.toKana("onaji", Config.DEFAULT)
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
            testEquals(name = "config", expected = "onaji") {
                Wanakana.toRomaji(input = "おなじ", config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("stripOkurigana()")
        fun stripOkuriganaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "お祝") {
                Wanakana.stripOkurigana("お祝い")
            }
            testEquals(name = "all parameters", expected = "みまい") {
                Wanakana.stripOkurigana("おみまい", true, matchKanji = "お祝い")
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
        }

        @TestFactory
        @DisplayName("Detection methods")
        fun detectionMethodsTest() = dynamicTests {
            // String
            testTrue(name = "isKana()") { Wanakana.isKana("あ") }
            testTrue(name = "isHiragana()") { Wanakana.isHiragana("あ") }
            testTrue(name = "isKatakana()") { Wanakana.isKatakana("ア") }
            testTrue(name = "isMixed()") { Wanakana.isMixed("Abあア") }
            testFalse(name = "isMixed(passKanji)") { Wanakana.isMixed("お腹A", false) }
            testTrue(name = "isKanji()") { Wanakana.isKanji("腹") }
            testTrue(name = "isJapanese()") { Wanakana.isJapanese("泣き虫") }
            testTrue(name = "isJapanese(regex)") {
                Wanakana.isJapanese("≪偽括弧≫", Regex("""[≪≫]"""))
            }
            testTrue(name = "isRomaji()") { Wanakana.isRomaji("Tōkyō and Ōsaka") }
            testTrue(name = "isRomaji(regex)") {
                Wanakana.isRomaji("a！b&cーd", Regex("""[！ー]"""))
            }

            // Char
            testTrue(name = "isKana()") { Wanakana.isKana('あ') }
            testTrue(name = "isHiragana()") { Wanakana.isHiragana('あ') }
            testTrue(name = "isKatakana()") { Wanakana.isKatakana('ア') }
            testTrue(name = "isKanji()") { Wanakana.isKanji('腹') }
            testTrue(name = "isJapanese()") { Wanakana.isJapanese('泣') }
            testTrue(name = "isRomaji()") { Wanakana.isRomaji('Ō') }
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
        testTrue(name = "isKanji()") { "腹".isKanji() }
        testTrue(name = "isJapanese()") { "泣き虫".isJapanese() }
        testTrue(name = "isJapanese(regex)") {
            "≪偽括弧≫".isJapanese(Regex("""[≪≫]"""))
        }
        testTrue(name = "isRomaji()") { "Tōkyō and Ōsaka".isRomaji() }
        testTrue(name = "isRomaji(regex)") {
            "a！b&cーd".isRomaji(Regex("""[！ー]"""))
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
