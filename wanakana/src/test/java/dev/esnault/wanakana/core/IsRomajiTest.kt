package dev.esnault.wanakana.core

import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.isRomaji
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory


@DisplayName("isRomaji()")
class IsRomajiTest {

    @TestFactory
    @DisplayName("Basic usage")
    fun isHiraganaTest() = dynamicTests {
        fun test(name: String, input: String, expected: Boolean) =
            testBoolean(name = name, expected = expected) { isRomaji(input) }

        test(name = "Empty", input = "", expected = true)
        test(name = "A is romaji", input = "A", expected = true)
        test(name = "xYz is romaji", input = "xYz", expected = true)
        test(name = "Tōkyō and Ōsaka is romaji", input = "Tōkyō and Ōsaka", expected = true)
        test(name = "あアA is not romaji", input = "あアA", expected = false)
        test(name = "お願い is not romaji", input = "お願い", expected = false)
        test(name = "熟成 is not romaji", input = "熟成", expected = false)
        test(name = "passes latin punctuation", input = "a*b&c-d", expected = true)
        test(name = "passes latin numbers", input = "0123456789", expected = true)
        test(name = "fails zenkaku punctuation", input = "a！b&cーd", expected = false)
        test(name = "fails zenkaku latin", input = "ｈｅｌｌｏ", expected = false)
        testTrue(name = "accepts optional allowed chars") {
            isRomaji("a！b&cーd", allowed = Regex("[！ー]"))
        }
    }
}
