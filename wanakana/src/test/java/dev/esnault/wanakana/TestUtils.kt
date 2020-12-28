package dev.esnault.wanakana

import org.junit.jupiter.api.DynamicTest
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class DynamicTestsBuilder {
    val tests = mutableListOf<DynamicTest>()

    fun test(name: String, block: () -> Unit) {
        val safeName = if (name.isBlank()) "\"$name\"" else name
        tests.add(DynamicTest.dynamicTest(safeName, block))
    }

    fun testTrue(name: String, block: () -> Boolean) = test(name) { assertTrue(block()) }

    fun testFalse(name: String, block: () -> Boolean) = test(name) { assertFalse(block()) }

    fun testBoolean(name: String, expected: Boolean, block: () -> Boolean) =
        test(name) { block().let { if (expected) assertTrue(it) else assertFalse(it) } }

    fun <T> testEquals(name: String, expected: T, block: () -> T) =
        test(name) { assertEquals(expected, block()) }
}
fun dynamicTests(init: DynamicTestsBuilder.() -> Unit) : List<DynamicTest> {
    val builder = DynamicTestsBuilder()
    builder.init()
    return builder.tests
}
