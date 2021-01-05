package dev.esnault.wanakana.core

import dev.esnault.wanakana.dynamicTests
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory


@DisplayName("isKana()")
class IsKanaTest {

    @TestFactory
    @DisplayName("Basic usage")
    fun isKanaTest() = dynamicTests {
        fun test(name: String, input: String, expected: Boolean) =
            testBoolean(name = name, expected = expected) { isKana(input) }

        test(name = "Empty", input = "", expected = true)
        test(name = "あ is kana", input = "ア", expected = true)
        test(name = "ア is kana", input = "アア", expected = true)
        test(name = "あア is kana", input = "あア", expected = true)
        test(name = "A is not kana", input = "A", expected = false)
        test(name = "Aあア is not kana", input = "Aあア", expected = false)
        test(name = "ignores long dash in mixed kana", input = "アーあ", expected = true)
    }
}
