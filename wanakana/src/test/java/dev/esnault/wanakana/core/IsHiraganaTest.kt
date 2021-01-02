package dev.esnault.wanakana.core

import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.isHiragana
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory


@DisplayName("isHiragana()")
class IsHiraganaTest {

    @TestFactory
    @DisplayName("Basic usage")
    fun isHiraganaTest() = dynamicTests {
        fun test(name: String, input: String, expected: Boolean) =
            testBoolean(name = name, expected = expected) { isHiragana(input) }

        test(name = "Empty", input = "", expected = true)
        test(name = "あ is hiragana", input = "あ", expected = true)
        test(name = "ああ is hiragana", input = "ああ", expected = true)
        test(name = "ア is not hiragana", input = "ア", expected = false)
        test(name = "A is not hiragana", input = "A", expected = false)
        test(name = "あア is not hiragana", input = "あア", expected = false)
        test(name = "ignores long dash in hiragana", input = "げーむ", expected = true)
    }
}
