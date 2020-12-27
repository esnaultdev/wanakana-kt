package dev.esnault.wanakana.utils

import dev.esnault.wanakana.Constants


/**
 * Returns `true` if this is '・'.
 */
fun Char.isSlashDot() = this.toInt() == Constants.KANA_SLASH_DOT

/**
 * Returns `true` if this is 'ー'.
 */
fun Char.isLongDash() = this.toInt() == Constants.PROLONGED_SOUND_MARK

/**
 * Returns `true` if the character is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 */
fun Char.isHiragana() = this.toInt() in Constants.HIRAGANA_CHARS
