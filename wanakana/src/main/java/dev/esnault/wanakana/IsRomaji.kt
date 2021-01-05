package dev.esnault.wanakana

import dev.esnault.wanakana.extension.isRomaji
import dev.esnault.wanakana.utils.Constants


internal fun isRomaji(input: String, allowed: Regex? = null): Boolean {
    return input.all { char ->
        char.isRomaji() || (allowed?.matches(char.toString()) ?: false)
    }
}

internal fun isRomaji(input: Char): Boolean = input.toInt().let { charCode ->
    Constants.ROMAJI_RANGES.any { range -> charCode in range }
}
