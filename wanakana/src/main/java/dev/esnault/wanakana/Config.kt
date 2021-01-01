package dev.esnault.wanakana


/**
 * A mode to handle conversion while the text is being typed.
 * This means that the last characters of the input might not be converted if ambiguous to allow
 * later conversion.
 * For the mapping from romaji to kana, this also updates the mapping for "n".
 */
enum class IMEMode {
    /** Disabled, all the text will be converted if possible. */
    DISABLED,
    /**
     * Enabled, the end of the text will not be converted if ambiguous, allowing it to be
     * disambiguated later by new characters.
     */
    ENABLED,
    /** [ENABLED], with the kana conversion always using hiragana. */
    TO_HIRAGANA,
    /** [ENABLED], with the kana conversion always using katakana. */
    TO_KATAKANA
}

/**
 * Configuration for Wanakana.
 * Can be used instead of parameters for each method.
 *
 * @property useObsoleteKana if `true`, obsolete kanas (ゐ, ゑ, ヰ and ヱ) will be used when
 * converting romaji to kana.
 * Applies to [toKana], [toHiragana] and [toKatakana].
 * Defaults to `false`.
 * @property passRomaji if `true`, romaji will be kept as is during conversion. This means that only
 * kanas (and Japanese punctuation) will be converted.
 * Applies to [toHiragana] and [toKatakana].
 * Defaults to `false`.
 * @property upcaseKatakana if `true`, katakana will be converted as uppercase romaji.
 * Applies to [toRomaji].
 * Defaults to `false`.
 * @property imeMode if not [IMEMode.DISABLED], allows the conversion to be performed while typed.
 * This means that the last characters of the input might not be converted if ambiguous to allow
 * later conversion.
 * Applies to [toRomaji], [toKana], [toHiragana] and [toKatakana].
 * Defaults to [IMEMode.DISABLED].
 */
data class Config(
    val useObsoleteKana: Boolean = false,
    val passRomaji: Boolean = false,
    val upcaseKatakana: Boolean = false,
    val imeMode: IMEMode = IMEMode.DISABLED
) {
    companion object {
        /**
         * Default configuration.
         * See the [Config] documentation for the default values.
         */
        val DEFAULT = Config()
    }
}
