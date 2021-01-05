package dev.esnault.wanakana.utils

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class CursorConversionTest {

    // Result of toKana("nonono") -> "ののの"
    private val nononoTokens = listOf(
        ConversionToken(0, 2, "の"),
        ConversionToken(2, 4, "の"),
        ConversionToken(4, 6, "の")
    )

    // Result of toKana("nononon") -> "のののn"
    private val nonononTokens = listOf(
        ConversionToken(0, 2, "の"),
        ConversionToken(2, 4, "の"),
        ConversionToken(4, 6, "の"),
        ConversionToken(6, 7, null)
    )

    @Test
    fun emptyInput() {
        // "|" -> "|"
        // Given
        val tokens = emptyList<ConversionToken>()
        val selection = 0..0
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 0..0, actual = newSelection)
    }

    @Test
    fun noCursor() {
        // "nonono" -> "ののの"
        // Given
        val tokens = nononoTokens
        val selection = -1..-1
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = -1..-1, actual = newSelection)
    }


    @Test
    fun cursorAtStartOfInput() {
        // "|nonono" -> "|ののの"
        // Given
        val tokens = nononoTokens
        val selection = 0..0
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 0..0, actual = newSelection)
    }

    @Test
    fun cursorAtEndOfInput() {
        // "nonono|" -> "ののの|"
        // Given
        val tokens = nononoTokens
        val selection = 6..6
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 3..3, actual = newSelection)
    }

    @Test
    fun cursorAtMiddleOfInput() {
        // "nono|no" -> "のの|の"
        // Given
        val tokens = nononoTokens
        val selection = 4..4
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 2..2, actual = newSelection)
    }

    @Test
    fun selectionAllInput() {
        // "[nonono]" -> "[ののの]"
        // Given
        val tokens = nononoTokens
        val selection = 0..6
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 0..3, actual = newSelection)
    }

    @Test
    fun selectionTwoCharacters() {
        // "no[nono]" -> "の[のの]"
        // Given
        val tokens = nononoTokens
        val selection = 2..6
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 1..3, actual = newSelection)
    }

    @Test
    fun selectionPartialFirstCharacter() {
        // "[n]onono" -> "[の]のの"
        // Given
        val tokens = nononoTokens
        val selection = 0..1
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 0..1, actual = newSelection)
    }

    @Test
    fun selectionPartialLastCharacter() {
        // "nonon[o]" -> "のの[の]"
        // Given
        val tokens = nononoTokens
        val selection = 5..6
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 2..3, actual = newSelection)
    }

    @Test
    fun selectionPartialTwoCharacters() {
        // "n[on]ono" -> "[のの]の"
        // Given
        val tokens = nononoTokens
        val selection = 1..3
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 0..2, actual = newSelection)
    }

    @Test
    fun cursorAtStartOfEndNonConvertedText() {
        // "nonono|n" -> "ののの|n"
        // Given
        val tokens = nonononTokens
        val selection = 6..6
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 3..3, actual = newSelection)
    }

    @Test
    fun cursorAtEndOfEndNonConvertedText() {
        // "nononon|" -> "のののn|"
        // Given
        val tokens = nonononTokens
        val selection = 7..7
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 4..4, actual = newSelection)
    }

    @Test
    fun selectionIncludesEndNonConvertedText() {
        // "no[nonon]" -> "の[ののn]"
        // Given
        val tokens = nonononTokens
        val selection = 2..7
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 1..4, actual = newSelection)
    }

    @Test
    fun middleConversionInMiddleOfInput() {
        // "のn|nの" -> "のん|の"
        // Given
        val tokens = listOf(
            ConversionToken(0, 1, "の"),
            ConversionToken(1, 3, "ん"),
            ConversionToken(3, 4, "の"),
        )
        val selection = 2..2
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 2..2, actual = newSelection)
    }

    @Test
    fun middleConversionAtEndOfInput() {
        // "n|n" -> "ん|"
        // Given
        val tokens = listOf(ConversionToken(0, 2, "ん"))
        val selection = 1..1
        // When
        val newSelection = matchSelection(selection, tokens)
        // Then
        assertEquals(expected = 1..1, actual = newSelection)
    }
}
