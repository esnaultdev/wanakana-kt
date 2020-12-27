package dev.esnault.wanakana.utils

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class CharExtTest {

    @Test
    fun isHiragana() {
        assertTrue('な'.isHiragana())
        assertFalse('ナ'.isHiragana())
        assertFalse('n'.isHiragana())
        assertFalse('!'.isHiragana())
    }

    @Test
    fun isKatakana() {
        assertTrue('ナ'.isKatakana())
        assertFalse('は'.isKatakana())
        assertFalse('n'.isKatakana())
        assertFalse('!'.isKatakana())
    }

    @Test
    fun isLongDash() {
        assertTrue('ー'.isLongDash())
        assertFalse('-'.isLongDash())
        assertFalse('f'.isLongDash())
        assertFalse('ふ'.isLongDash())
    }

    @Test
    fun isSlashDot() {
        assertTrue('・'.isSlashDot())
        assertFalse('/'.isSlashDot())
    }

    @Test
    fun isUpperCase() {
        assertTrue('A'.isEnglishUpperCase())
        assertTrue('D'.isEnglishUpperCase())
        assertFalse('-'.isEnglishUpperCase())
        assertFalse('ー'.isEnglishUpperCase())
        assertFalse('a'.isEnglishUpperCase())
        assertFalse('d'.isEnglishUpperCase())
    }
}
