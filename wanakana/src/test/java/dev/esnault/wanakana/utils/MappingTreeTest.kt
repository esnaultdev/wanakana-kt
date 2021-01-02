package dev.esnault.wanakana.utils

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals


class MappingTreeTest {

    @Nested
    @DisplayName("DSL")
    inner class DslTest {
        @Test
        @DisplayName("Empty String key is invalid for String value")
        fun emptyStringKeyIsInvalidForString() {
            assertThrows<IllegalArgumentException> {
                mapping { "" to "test" }
            }
        }

        @Test
        @DisplayName("Empty String key is invalid for Char value")
        fun emptyStringKeyIsInvalidForChar() {
            assertThrows<IllegalArgumentException> {
                mapping { "" to 't' }
            }
        }

        @Test
        @DisplayName("Empty String key is invalid for Mapping value")
        fun emptyStringKeyIsInvalidForMapping() {
            assertThrows<IllegalArgumentException> {
                mapping { "" to mapping { value = "test" } }
            }
        }

        @Test
        @DisplayName("Char key is valid for Char value")
        fun charKeyIsValidForChar() {
            val mapping = mapping { 'a' to 't' }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "t")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("Char key is valid for String value")
        fun charKeyIsValidForString() {
            val mapping = mapping { 'a' to "test" }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "test")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("Char key is valid for Mapping value with subTree")
        fun charKeyIsValidForMappingAppend() {
            val mapping = mapping { 'a' to mapping { 'b' to "test" } }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(
                        subTrees = mapOf(
                            'b' to mappingTreeOf(value = "test")
                        )
                    )
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("Char key is valid for Mapping value with value")
        fun charKeyIsValidForMappingWithValue() {
            val mapping = mapping { 'a' to mapping { value = "test" } }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "test")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("String key is valid for Char value")
        fun stringKeyIsValidForChar() {
            val mapping = mapping { "a" to 't' }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "t")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("String key is valid for String value")
        fun stringKeyIsValidForString() {
            val mapping = mapping { "a" to "test" }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "test")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("String key is valid for Mapping value")
        fun stringKeyIsValidForMapping() {
            val mapping = mapping { "a" to mapping { value = "test" } }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "test")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("A string key can be used to build multiple layers")
        fun stringKeyToReferenceDeepValue() {
            val mapping = mapping { "abc" to "test" }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(
                        subTrees = mapOf(
                            'b' to mappingTreeOf(
                                subTrees = mapOf(
                                    'c' to mappingTreeOf(value = "test")
                                )
                            )
                        )
                    )
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("Int key is invalid")
        fun intKeyIsInvalid() {
            assertThrows<IllegalArgumentException> {
                mapping { 5 to "test" }
            }
        }

        @Test
        @DisplayName("Int value is invalid")
        fun intValueIsInvalid() {
            assertThrows<IllegalArgumentException> {
                mapping { "test" to 5 }
            }
        }

        @Test
        @DisplayName("to replaces the previous value")
        fun toReplaceValue() {
            val mapping = mapping { 'a' to "test"; 'a' to "other" }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "other")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("to replaces the previous mapping")
        fun toReplaceMapping() {
            val mapping = mapping { "ab" to "test"; 'a' to mapping { "c" to "other" } }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(
                        subTrees = mapOf(
                            'c' to mappingTreeOf(value = "other")
                        )
                    )
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("to only replaces the last subTree")
        fun toReplaceOnlyLastSubtree() {
            val mapping = mapping { "ab" to "test"; "ac" to "other" }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(
                        subTrees = mapOf(
                            'b' to mappingTreeOf(value = "test"),
                            'c' to mappingTreeOf(value = "other")
                        )
                    )
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("Char key is valid for merge")
        fun mergeCharKeyIsValid() {
            val mapping = mapping { 'a' merge mapping { value = "test" } }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "test")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("String key is valid for merge")
        fun mergeStringKeyIsValid() {
            val mapping = mapping { "a" merge mapping { value = "test" } }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "test")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("merge can replace the value")
        fun mergeOnlyValue() {
            val mapping = mapping { "ab" to "test"; 'a' merge mapping { value = "other" } }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(
                        value = "other",
                        subTrees = mapOf(
                            'b' to mappingTreeOf(value = "test"),
                        )
                    )
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("merge prefers the new value")
        fun mergeReplaceValueOnConflict() {
            val mapping = mapping { 'a' to "test"; 'a' to mapping { value = "other" } }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "other")
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }

        @Test
        @DisplayName("merge can merge subTrees")
        fun mergeSubTrees() {
            val mapping = mapping { "ab" to "test"; 'a' merge mapping { 'c' to "other" } }
            val expected = mappingTreeOf(
                subTrees = mapOf(
                    'a' to mappingTreeOf(
                        subTrees = mapOf(
                            'b' to mappingTreeOf(value = "test"),
                            'c' to mappingTreeOf(value = "other")
                        )
                    )
                )
            )
            assertEquals(expected = expected, actual = mapping)
        }
    }
}
