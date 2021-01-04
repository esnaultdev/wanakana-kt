package example

import dev.esnault.wanakana.Config
import dev.esnault.wanakana.IMEMode
import dev.esnault.wanakana.dynamicTests
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


class KotlinInterfaceTest {

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
}
