package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isJapanese
import dev.esnault.wanakana.utils.Constants


internal fun isJapanese(input: String, allowed: Regex? = null): Boolean {
    return input.all { char ->
        char.isJapanese() || (allowed?.matches(char.toString()) ?: false)
    }
}

internal fun isJapanese(input: Char): Boolean = input.toInt().let { charCode ->
    Constants.JAPANESE_RANGES.any { range -> charCode in range }
}
