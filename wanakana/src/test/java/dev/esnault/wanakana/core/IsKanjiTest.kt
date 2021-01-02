package dev.esnault.wanakana.core

import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.isKanji
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory


@DisplayName("isKanji()")
class IsKanjiTest {

    @TestFactory
    @DisplayName("Basic usage")
    fun isHiraganaTest() = dynamicTests {
        fun test(name: String, input: String, expected: Boolean) =
            testBoolean(name = name, expected = expected) { isKanji(input) }

        test(name = "Empty", input = "", expected = true)
        test(name = "切腹 is kanji", input = "切腹", expected = true)
        test(name = "刀 is kanji", input = "刀", expected = true)
        test(name = "emoji are not kanji", input = "\uD83D\uDC4B", expected = false)
        test(name = "あ is not kanji", input = "あ", expected = false)
        test(name = "ア is not kanji", input = "ア", expected = false)
        test(name = "あア is not kanji", input = "あア", expected = false)
        test(name = "A is not kanji", input = "A", expected = false)
        test(name = "あAア is not kanji", input = "あAア", expected = false)
        test(name = "１２隻 is not kanji", input = "１２隻", expected = false)
        test(name = "12隻 is not kanji", input = "12隻", expected = false)
        test(name = "隻。 is not kanji", input = "隻。", expected = false)
    }
}
