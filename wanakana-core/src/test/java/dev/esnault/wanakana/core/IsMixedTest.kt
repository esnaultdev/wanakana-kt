package dev.esnault.wanakana.core

import dev.esnault.wanakana.dynamicTests
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory


@DisplayName("isMixed()")
class IsMixedTest {

    @TestFactory
    @DisplayName("Basic usage")
    fun isMixedTest() = dynamicTests {
        fun test(name: String, input: String, expected: Boolean) =
            testBoolean(name = name, expected = expected) { isMixed(input) }

        test(name = "Empty", input = "", expected = false)
        test(name = "Aア is mixed", input = "Aア", expected = true)
        test(name = "Aあ is mixed", input = "Aあ", expected = true)
        test(name = "Aあア is mixed", input = "Aあア", expected = true)
        test(name = "２あア is not mixed", input = "２あア", expected = false)
        test(name = "お腹A is mixed", input = "お腹A", expected = true)
        testFalse(name = "お腹A is not mixed when passKanji = false") {
            isMixed("お腹A", passKanji = false)
        }
        test(name = "お腹 is not mixed", input = "お腹", expected = false)
        test(name = "腹 is not mixed", input = "腹", expected = false)
        test(name = "A is not mixed", input = "A", expected = false)
        test(name = "あ is not mixed", input = "あ", expected = false)
        test(name = "ア is not mixed", input = "ア", expected = false)
    }
}
