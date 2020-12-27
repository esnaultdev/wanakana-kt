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
}
