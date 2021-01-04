package dev.esnault.wanakana.utils

import dev.esnault.wanakana.Constants


/**
 * Returns `true` if this is '・'.
 */
internal fun Char.isSlashDot(): Boolean = this.toInt() == Constants.KANA_SLASH_DOT

/**
 * Returns `true` if this is 'ー'.
 */
internal fun Char.isLongDash(): Boolean = this.toInt() == Constants.PROLONGED_SOUND_MARK


/**
 * Returns `true` is this is an English uppercase letter.
 */
internal fun Char.isEnglishUpperCase(): Boolean = this.toInt() in Constants.LATIN_UPPERCASE_RANGE
