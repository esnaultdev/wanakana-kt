package dev.esnault.wanakana.utils

import java.util.*

/**
 * Returns this string in English uppercase.
 * Without using the English locale, `toUpperCase` can have surprising results, even for English
 * text depending on the user locale. For example the Turkish locale will transform 'i' to 'İ'.
 */
fun String.safeUpperCase(): String = this.toUpperCase(Locale.ENGLISH)

/**
 * Returns this string in English lowercase.
 * Without using the English locale, `toUpperCase` can have surprising results, even for English
 * text depending on the user locale. For example the Turkish locale will transform 'I' to 'ı'.
 */
fun String.safeLowerCase(): String = this.toLowerCase(Locale.ENGLISH)
