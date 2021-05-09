package dev.esnault.wanakana.core

import dev.esnault.wanakana.DynamicTestsBuilder
import dev.esnault.wanakana.core.utils.ImeText
import dev.esnault.wanakana.dynamicTests
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory


/**
 * Test cases for [toKanaIme].
 *
 * The default tests cases are already covered by [ToKanaTest].
 */
@DisplayName("toKanaIme()")
class ToKanaImeTest {

    private fun DynamicTestsBuilder.testKana(name: String, input: ImeText, expected: ImeText) =
        testEquals(name = name, expected = expected) { toKanaIme(input) }

    @TestFactory
    @DisplayName("n edge cases")
    fun basicUsage() = dynamicTests {
        testKana(
            name = "solo n's are not transliterated unless chars follow - solo n",
            input = ImeText(text = "n", selection = 1..1),
            expected = ImeText(text = "n", selection = 1..1)
        )
        testKana(
            name = "solo n's are not transliterated unless chars follow - last n",
            input = ImeText(text = "shin", selection = 4..4),
            expected = ImeText(text = "しn", selection = 2..2)
        )
        testKana(
            name = "solo n's are not transliterated unless chars follow - n becomes に",
            input = ImeText(text = "shinyou", selection = 6..6),
            expected = ImeText(text = "しにょう", selection = 3..3)
        )
        testKana(
            name = "solo n's are not transliterated unless chars follow - solo n + '",
            input = ImeText(text = "shin'you", selection = 5..5),
            expected = ImeText(text = "しんよう", selection = 2..2)
        )
        testKana(
            name = "solo n's are not transliterated unless chars follow - solo n + [space]",
            input = ImeText(text = "shin you", selection = 5..5),
            expected = ImeText(text = "しんよう", selection = 2..2)
        )
        testKana(
            name = "double n's are transliterated to single ん",
            input = ImeText(text = "nn", selection = 2..2),
            expected = ImeText(text = "ん", selection = 1..1)
        )
        testKana(
            name = "solo n's are not transliterated unless chars follow - nj|",
            input = ImeText(text = "nj", selection = 2..2),
            expected = ImeText(text = "んj", selection = 2..2)
        )
        testKana(
            name = "solo n's are not transliterated unless chars follow - n|j",
            input = ImeText(text = "nj", selection = 1..1),
            expected = ImeText(text = "nj", selection = 1..1)
        )
        testKana(
            name = "solo n's are not transliterated unless chars follow - nj",
            input = ImeText(text = "nj", selection = -1..-1),
            expected = ImeText(text = "んj", selection = -1..-1)
        )
    }
}
