package dev.esnault.wanakana.api

import dev.esnault.wanakana.Config
import dev.esnault.wanakana.IMEMode
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
import dev.esnault.wanakana.toHiragana
import dev.esnault.wanakana.toKana
import dev.esnault.wanakana.toKatakana
import dev.esnault.wanakana.toRomaji
import dev.esnault.wanakana.utils.mapping
import dev.esnault.wanakana.utils.mappingTreeOf
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals


/**
 * Interface test to ensure that all of the API is available to other modules.
 * TODO Move this to the app module.
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
            testEquals(name = "named minimal input", expected = "おなじ") {
                toHiragana(input = "onaji")
            }
            testEquals(name = "all parameters", expected = "おなじ") {
                toHiragana(
                    input = "onaji",
                    imeMode = IMEMode.DISABLED,
                    passRomaji = false,
                    useObsoleteKana = false
                )
            }
            testEquals(name = "config", expected = "おなじ") {
                toHiragana(
                    input = "onaji",
                    config = Config.DEFAULT
                )
            }
        }

        @TestFactory
        @DisplayName("toKatakana()")
        fun toKatakanaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "オナジ") {
                toKatakana("onaji")
            }
            testEquals(name = "named minimal input", expected = "オナジ") {
                toKatakana(input = "onaji")
            }
            testEquals(name = "all parameters", expected = "オナジ") {
                toKatakana(
                    input = "onaji",
                    imeMode = IMEMode.DISABLED,
                    passRomaji = false,
                    useObsoleteKana = false
                )
            }
            testEquals(name = "config", expected = "オナジ") {
                toKatakana(input = "onaji", config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toKana()")
        fun toKanaTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "おなじ") {
                toKana("onaji")
            }
            testEquals(name = "named minimal input", expected = "おなじ") {
                toKana(input = "onaji")
            }
            testEquals(name = "all parameters", expected = "おなじ") {
                toKana(
                    input = "onaji",
                    imeMode = IMEMode.DISABLED,
                    useObsoleteKana = false
                )
            }
            testEquals(name = "config", expected = "おなじ") {
                toKana(input = "onaji", config = Config.DEFAULT)
            }
        }

        @TestFactory
        @DisplayName("toRomaji()")
        fun toRomajiTest() = dynamicTests {
            testEquals(name = "minimal input", expected = "onaji") {
                toRomaji("おなじ")
            }
            testEquals(name = "named minimal input", expected = "onaji") {
                toRomaji(input = "おなじ")
            }
            testEquals(name = "all parameters", expected = "onaji") {
                toRomaji(
                    input = "おなじ",
                    imeMode = IMEMode.DISABLED,
                    upcaseKatakana = false
                )
            }
            testEquals(name = "config", expected = "onaji") {
                toRomaji(input = "おなじ", config = Config.DEFAULT)
            }
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
        
        @TestFactory
        @DisplayName("Detection methods")
        fun detectionMethodsTest() = dynamicTests {
            testTrue(name = "isKana()") { isKana("あ") }
            testTrue(name = "isHiragana()") { isHiragana("あ") }
            testTrue(name = "isKatakana()") { isKatakana("ア") }
            testTrue(name = "isMixed()") { isMixed("Abあア") }
            testFalse(name = "isMixed()") { isMixed("お腹A", passKanji = false) }
            testTrue(name = "isKanji()") { isKanji("腹") }
            testTrue(name = "isJapanese()") { isJapanese("泣き虫") }
            testTrue(name = "isJapanese()") {
                isJapanese("≪偽括弧≫", allowed = Regex("""[≪≫]"""))
            }
            testTrue(name = "isRomaji()") { isRomaji("Tōkyō and Ōsaka") }
            testTrue(name = "isRomaji()") {
                isRomaji("a！b&cーd", allowed = Regex("""[！ー]"""))
            }
        }
    }

    @TestFactory
    @DisplayName("Extensions")
    fun detectionMethodsExtTest() = dynamicTests {
        testTrue(name = "isKana()") { "あ".isKana() }
        testTrue(name = "isHiragana()") { "あ".isHiragana() }
        testTrue(name = "isKatakana()") { "ア".isKatakana() }
        testTrue(name = "isMixed()") { "Abあア".isMixed() }
        testFalse(name = "isMixed()") { "お腹A".isMixed(passKanji = false) }
        testTrue(name = "isKanji()") { "腹".isKanji() }
        testTrue(name = "isJapanese()") { "泣き虫".isJapanese() }
        testTrue(name = "isJapanese()") {
            "≪偽括弧≫".isJapanese(allowed = Regex("""[≪≫]"""))
        }
        testTrue(name = "isRomaji()") { "Tōkyō and Ōsaka".isRomaji() }
        testTrue(name = "isRomaji()") {
            "a！b&cーd".isRomaji(allowed = Regex("""[！ー]"""))
        }
    }
}
