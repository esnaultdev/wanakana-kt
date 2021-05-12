package dev.esnault.wanakana.core


/**
 * A mode to handle conversion while the text is being typed.
 * This means that the last characters of the input might not be converted if ambiguous to allow
 * later conversion.
 * For the mapping from romaji to kana, this also updates the mapping for "n".
 */
public enum class IMEMode {
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
public data class Config(
    val useObsoleteKana: Boolean = false,
    val passRomaji: Boolean = false,
    val upcaseKatakana: Boolean = false,
    val imeMode: IMEMode = IMEMode.DISABLED
) {
    public companion object {
        /**
         * Default configuration.
         * See the [Config] documentation for the default values.
         */
        @JvmField
        public val DEFAULT: Config = Config()

        /**
         * Default configuration for IME mode, using [IMEMode.ENABLED].
         * See the [Config] documentation for other default values.
         */
        @JvmField
        public val DEFAULT_IME: Config = Config(imeMode = IMEMode.ENABLED)
    }

    /**
     * Returns a [ConfigBuilder] from this [Config] to update it.
     * This is meant to be used from Java, as Kotlin can use [copy] and named parameters.
     */
    public fun update(): ConfigBuilder = ConfigBuilder(
        useObsoleteKana = useObsoleteKana,
        passRomaji = passRomaji,
        upcaseKatakana = upcaseKatakana,
        imeMode = imeMode
    )
}

/**
 * A builder to construct and update a [Config].
 * This is meant to be used from Java, as Kotlin can use [Config.copy] and named parameters to build
 * a [Config] object.
 */
public class ConfigBuilder(
    useObsoleteKana: Boolean = false,
    passRomaji: Boolean = false,
    upcaseKatakana: Boolean = false,
    imeMode: IMEMode = IMEMode.DISABLED
) {

    public var useObsoleteKana: Boolean = useObsoleteKana
        private set
    public var passRomaji: Boolean = passRomaji
        private set
    public var upcaseKatakana: Boolean = upcaseKatakana
        private set
    public var imeMode: IMEMode = imeMode
        private set

    /**
     * Builds a [Config] from this builder.
     */
    public fun build(): Config = Config(
        useObsoleteKana = useObsoleteKana,
        passRomaji = passRomaji,
        upcaseKatakana = upcaseKatakana,
        imeMode = imeMode
    )

    /**
     * Sets [useObsoleteKana].
     * If `true`, obsolete kanas (ゐ, ゑ, ヰ and ヱ) will be used when converting romaji to kana.
     * Applies to [toKana], [toHiragana] and [toKatakana].
     * Defaults to `false`.
     */
    public fun useObsoleteKana(useObsoleteKana: Boolean): ConfigBuilder =
        apply { this.useObsoleteKana = useObsoleteKana }

    /**
     * Sets [passRomaji].
     * If `true`, romaji will be kept as is during conversion. This means that only kanas (and
     * Japanese punctuation) will be converted.
     * Applies to [toHiragana] and [toKatakana].
     * Defaults to `false`.
     */
    public fun passRomaji(passRomaji: Boolean): ConfigBuilder =
        apply { this.passRomaji = passRomaji }

    /**
     * Sets [upcaseKatakana].
     * If `true`, katakana will be converted as uppercase romaji.
     * Applies to [toRomaji].
     * Defaults to `false`.
     */
    public fun upcaseKatakana(upcaseKatakana: Boolean): ConfigBuilder =
        apply { this.upcaseKatakana = upcaseKatakana }

    /**
     * Sets the [imeMode].
     * If not [IMEMode.DISABLED], allows the conversion to be performed while typed. This means that
     * the last characters of the input might not be converted if ambiguous to allow later
     * conversion.
     * Applies to [toRomaji], [toKana], [toHiragana] and [toKatakana].
     * Defaults to [IMEMode.DISABLED].
     */
    public fun imeMode(imeMode: IMEMode): ConfigBuilder =
        apply { this.imeMode = imeMode }
}
