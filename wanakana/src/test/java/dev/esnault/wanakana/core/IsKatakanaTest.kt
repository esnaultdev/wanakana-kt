package dev.esnault.wanakana.core

import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.isKatakana
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory


@DisplayName("isKatakana()")
class IsKatakanaTest {

    @TestFactory
    @DisplayName("Basic usage")
    fun isKatakanaTest() = dynamicTests {
        fun test(name: String, input: String, expected: Boolean) =
            testBoolean(name = name, expected = expected) { isKatakana(input) }

        test(name = "Empty", input = "", expected = true)
        test(name = "ア is katakana", input = "ア", expected = true)
        test(name = "アア is katakana", input = "アア", expected = true)
        test(name = "あ is not katakana", input = "あ", expected = false)
        test(name = "A is not katakana", input = "A", expected = false)
        test(name = "あア is not katakana", input = "あア", expected = false)
        test(name = "ignores long dash in katakana", input = "ゲーム", expected = true)
    }
}
