package dev.esnault.wanakana.utils

import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.extension.isEnglishPunctuation
import dev.esnault.wanakana.extension.isHiragana
import dev.esnault.wanakana.extension.isJapanese
import dev.esnault.wanakana.extension.isJapanesePunctuation
import dev.esnault.wanakana.extension.isKana
import dev.esnault.wanakana.extension.isKanji
import dev.esnault.wanakana.extension.isKatakana
import dev.esnault.wanakana.extension.isRomaji
import dev.esnault.wanakana.helpers.EN_PUNC
import dev.esnault.wanakana.helpers.JA_PUNC
import org.junit.jupiter.api.TestFactory


class CharExtTest {

    @TestFactory
    fun isHiragana() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isHiragana)

        'な'.test(true)
        'ナ'.test(false)
        'n'.test(false)
        '!'.test(false)
        'ー'.test(true)
    }

    @TestFactory
    fun isKatakana() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isKatakana)

        'ナ'.test(true)
        'は'.test(false)
        'n'.test(false)
        '!'.test(false)
    }

    @TestFactory
    fun isKana()  = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isKana)

        'は'.test(true)
        'ナ'.test(true)
        'n'.test(false)
        '!'.test(false)
        '-'.test(false)
        'ー'.test(true)
    }

    @TestFactory
    fun isLongDash() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isLongDash)
        
        'ー'.test(true)
        '-'.test(false)
        'f'.test(false)
        'ふ'.test(false)
    }

    @TestFactory
    fun isSlashDot() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isSlashDot)
        
        '・'.test(true)
        '/'.test(false)
        'f'.test(false)
        'ふ'.test(false)
    }

    @TestFactory
    fun isUpperCase() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isEnglishUpperCase)
        
        'A'.test(true)
        'D'.test(true)
        '-'.test(false)
        'ー'.test(false)
        'a'.test(false)
        'd'.test(false)
    }

    @TestFactory
    fun isKanji() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isKanji)
        
        '腹'.test(true)
        '一'.test(true) // kanji for いち・1 - not a long hyphen
        'ー'.test(false) // long hyphen
        'は'.test(false)
        'ナ'.test(false)
        'n'.test(false)
        '!'.test(false)
    }

    @TestFactory
    fun isRomaji() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isRomaji)
        
        'n'.test(true)
        '!'.test(true)
        'ナ'.test(false)
        'は'.test(false)
        '缶'.test(false)
    }

    @TestFactory
    fun isEnglishPunctuation() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isEnglishPunctuation)

        EN_PUNC.forEach { char -> char.test(true) }
        JA_PUNC.forEach { char -> char.test(false) }
        ' '.test(true)
        'a'.test(false)
        'ふ'.test(false)
        '字'.test(false)
    }

    @TestFactory
    fun isJapanesePunctuation() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isJapanesePunctuation)

        JA_PUNC.forEach { char -> char.test(true) }
        EN_PUNC.forEach { char -> char.test(false) }
        '　'.test(true)
        '?'.test(false)
        'a'.test(false)
        'ふ'.test(false)
        '字'.test(false)
    }

    @TestFactory
    fun isJapanese() = dynamicTests {
        fun Char.test(expected: Boolean) =
            testBoolean("$this -> $expected", expected, this::isJapanese)

        '１'.test(true)
        'ナ'.test(true)
        'は'.test(true)
        '缶'.test(true)
        '〜'.test(true)
        'ｎ'.test(true)
        'Ｋ'.test(true)
        '1'.test(false)
        'n'.test(false)
        'K'.test(false)
        '!'.test(false)
    }
}
