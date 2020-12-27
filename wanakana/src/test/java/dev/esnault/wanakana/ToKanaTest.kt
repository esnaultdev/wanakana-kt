package dev.esnault.wanakana

import org.junit.Test
import kotlin.test.assertEquals


class ToKanaTest {

    @Test
    fun `ki to き`() {
        assertEquals(expected = "き", actual = toKana("ki"))
    }

    @Test
    fun `kya to きゃ`() {
        assertEquals(expected = "きゃ", actual = toKana("kya"))
    }

    @Test
    fun `nan to なん`() {
        assertEquals(expected = "なん", actual = toKana("nan"))
    }
}
