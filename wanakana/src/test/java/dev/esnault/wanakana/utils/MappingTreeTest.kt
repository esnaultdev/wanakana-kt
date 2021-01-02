package dev.esnault.wanakana.utils

import dev.esnault.wanakana.dynamicTests
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


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

    @Nested
    @DisplayName("MappingTree implementation")
    inner class MappingTreeImplTest {
        @Test
        fun hasSubTreeNull() {
            val mapping = mappingTreeOf(value = "test", subTrees = null)
            assertFalse(actual = mapping.hasSubTree())
        }

        @Test
        fun hasSubTreeEmpty() {
            val mapping = mappingTreeOf(value = "test", subTrees = emptyMap())
            assertFalse(actual = mapping.hasSubTree())
        }

        @Test
        fun hasSubTreeAtLeastOne() {
            val mapping = mappingTreeOf(
                value = "test",
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "other")
                )
            )
            assertTrue(actual = mapping.hasSubTree())
        }

        @Test
        fun toMutableMappingTreeIsSame() {
            val mapping = mappingTreeOf(
                value = "test",
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "other")
                )
            )
            val mutableMappingTree: MutableMappingTree = mapping.toMutableMappingTree()
            assertEquals(expected = mapping, actual = mutableMappingTree)
        }

        @Test
        fun duplicateIsSame() {
            val mapping = mappingTreeOf(
                value = "test",
                subTrees = mapOf(
                    'a' to mappingTreeOf(value = "other")
                )
            )
            assertEquals(expected = mapping, actual = mapping.duplicate())
        }

        @TestFactory
        @DisplayName("mergeWith()")
        fun mergeWithTest() = dynamicTests {
            val first = mapping {
                value = "testFirst"
                "ab" to "otherFirst"
            }
            val firstDuplicate = first.duplicate()
            val second = mapping {
                value = "testSecond"
                "ac" to "otherSecond"
            }
            val secondDuplicate = second.duplicate()
            val expected = mapping {
                value = "testFirst"
                'a' to mapping {
                    'b' to "otherFirst"
                    'c' to "otherSecond"
                }
            }
            val merged = first.mergeWith(second)
            testEquals(name = "Merged mapping is correct", expected = expected, actual = merged)
            testEquals(
                name = "First mapping was not modified",
                expected = firstDuplicate,
                actual = first
            )
            testEquals(
                name = "Second mapping was not modified",
                expected = secondDuplicate,
                actual = second
            )
        }

        @TestFactory
        @DisplayName("mergeInto()")
        fun mergeIntoTest() = dynamicTests {
            val first = mapping {
                value = "testFirst"
                "ab" to "otherFirst"
            }
            val firstDuplicate = first.duplicate()
            val second = mapping {
                value = "testSecond"
                "ac" to "otherSecond"
            }
            val expected = mapping {
                value = "testFirst"
                'a' to mapping {
                    'b' to "otherFirst"
                    'c' to "otherSecond"
                }
            }
            first.mergeInto(second)
            testEquals(name = "Merged mapping is correct", expected = expected, actual = second)
            testEquals(
                name = "First mapping was not modified",
                expected = firstDuplicate,
                actual = first
            )
        }
    }

    @Nested
    @DisplayName("MutableMappingTree implementation")
    inner class MutableMappingTreeImplTest {
        @Test
        fun hasSubTreeEmptyNotInitialized() {
            // Splitting this test into two tests is not very good since it's not black box,
            // but it's still interesting to test both cases.
            val mapping = mutableMappingTreeOf(value = "test", subTrees = null)
            assertFalse(actual = mapping.hasSubTree())
        }

        @Test
        fun hasSubTreeEmptyInitialized() {
            // Splitting this test into two tests is not very good since it's not black box,
            // but it's still interesting to test both cases.
            val mapping = mutableMappingTreeOf(value = "test", subTrees = null)
            mapping['a'] // Calling this will initialize the underlying map
            assertFalse(actual = mapping.hasSubTree())
        }

        @Test
        fun hasSubTreeAtLeastOne() {
            val mapping = mutableMappingTreeOf(
                value = "test",
                subTrees = mutableMapOf(
                    'a' to mutableMappingTreeOf(value = "other")
                )
            )
            assertTrue(actual = mapping.hasSubTree())
        }

        @Test
        fun toMutableMappingTreeIsSame() {
            val mapping = mapping {
                value = "test"
                "abc" to "other"
            }
            val mutableMappingTree: MutableMappingTree = mapping.toMutableMappingTree()
            assertEquals(expected = mapping, actual = mutableMappingTree)
        }

        @Test
        fun toMappingTreeIsSame() {
            val mapping = mapping {
                value = "test"
                "abc" to "other"
            }
            val readOnlyMappingTree: MappingTree = mapping.toMappingTree()
            assertEquals(expected = mapping, actual = readOnlyMappingTree)
        }

        @Nested
        @DisplayName("duplicate()")
        inner class DuplicateTest {
            @Test
            fun duplicateIsTheSame() {
                val mapping = mapping {
                    value = "test"
                    "abc" to "other"
                }
                val newMapping = mapping.duplicate()
                assertEquals(expected = mapping, actual = newMapping)
            }

            @Test
            fun duplicateIsNotSameInstance() {
                val mapping = mapping {
                    value = "test"
                    "abc" to "other"
                }
                val newMapping = mapping.duplicate()
                newMapping['a']?.get('b')?.get('c')?.value = null
                assertEquals(expected = "other", actual = mapping['a']?.get('b')?.get('c')?.value)
            }
        }

        @Nested
        @DisplayName("subTreeOf()")
        inner class SubTreeOfTest {
            @Test
            fun deepReference() {
                val mapping = mapping {
                    "abc" to "test"
                }
                val subTree = mapping.subTreeOf("abc")
                val expected = mapping['a']?.get('b')?.get('c')
                assertEquals(expected = expected, actual = subTree)
            }

            @Test
            fun createsTreesAlongTheWay() {
                val mapping = mapping {
                    "ab" to "test"
                }
                mapping.subTreeOf("abc").value = "other"
                val expected = mapping {
                    "ab" to "test"
                    "abc" to "other"
                }
                assertEquals(expected = expected, actual = mapping)
            }

            @Test
            fun emptyStringIsSelf() {
                val mapping = mapping {
                    "ab" to "test"
                }
                val subTree = mapping.subTreeOf("")
                assertEquals(expected = mapping, actual = subTree)
            }
        }

        @Nested
        @DisplayName("replaceSubTreeOf()")
        inner class ReplaceSubTreeOfTest {
            @Test
            fun replaceExistingSubTree() {
                val mapping = mapping {
                    "ab" to "test"
                    "abc" to mapping {
                        value = "other"
                        "e" to "foo"
                    }
                }
                mapping.replaceSubTreeOf("abc", mapping { "d" to "another" })
                val expected = mapping {
                    "ab" to "test"
                    "abcd" to "another"
                }
                assertEquals(expected = expected, actual = mapping)
            }

            @Test
            fun createsTreesAlongTheWay() {
                val mapping = mapping {
                    "ab" to "test"
                }
                mapping.replaceSubTreeOf("abcd", mapping { value = "other" })
                val expected = mapping {
                    "ab" to "test"
                    "abcd" to "other"
                }
                assertEquals(expected = expected, actual = mapping)
            }

            @Test
            fun emptyStringReferenceIsInvalid() {
                val mapping = mapping {
                    "ab" to "test"
                }
                assertThrows<IllegalArgumentException> {
                    mapping.replaceSubTreeOf("", mapping { value = "other" })
                }
            }
        }

        @Nested
        @DisplayName("setSubTreeValue()")
        inner class SetSubTreeValueTest {
            @Test
            fun replaceExistingValue() {
                val mapping = mapping {
                    "ab" to "test"
                }
                mapping.setSubTreeValue("ab", "other")
                val expected = mapping {
                    "ab" to "other"
                }
                assertEquals(expected = expected, actual = mapping)
            }

            @Test
            fun createsTreesAlongTheWay() {
                val mapping = mapping {
                    "ab" to "test"
                }
                mapping.setSubTreeValue("abcd", "other")
                val expected = mapping {
                    "ab" to "test"
                    "abcd" to "other"
                }
                assertEquals(expected = expected, actual = mapping)
            }

            @Test
            fun emptyStringReplacesCurrentValue() {
                val mapping = mapping {
                    "ab" to "test"
                }
                mapping.setSubTreeValue("", "other")
                val expected = mapping {
                    value = "other"
                    "ab" to "test"
                }
                assertEquals(expected = mapping, actual = mapping)
            }
        }
    }
}
