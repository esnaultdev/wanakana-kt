package dev.esnault.wanakana


object Wanakana {

    // Writing system checks (String + Char)

    /**
     * Returns `true` if [input] is Romaji (allowing Hepburn romanisation).
     *
     * See [dev.esnault.wanakana.isRomaji] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun isRomaji(input: String, allowed: Regex? = null): Boolean =
        dev.esnault.wanakana.isRomaji(input, allowed)

    /**
     * Returns `true` if [input] is Romaji (allowing Hepburn romanisation).
     *
     * See [dev.esnault.wanakana.isRomaji] for more details.
     */
    @JvmStatic
    fun isRomaji(input: Char): Boolean =
        dev.esnault.wanakana.isRomaji(input)

    /**
     * Returns `true` if [input] only includes Kanji, Kana, zenkaku numbers, and JA punctuation
     * or symbols.
     *
     * See [dev.esnault.wanakana.isJapanese] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun isJapanese(input: String, allowed: Regex? = null): Boolean =
        dev.esnault.wanakana.isJapanese(input, allowed)

    /**
     * Returns `true` if [input] is Kanji, Kana, zenkaku numbers, or JA punctuation
     * and symbols.
     *
     * See [dev.esnault.wanakana.isJapanese] for more details.
     */
    @JvmStatic
    fun isJapanese(input: Char): Boolean =
        dev.esnault.wanakana.isJapanese(input)

    /**
     * Returns `true` if [input] is [Kana](https://en.wikipedia.org/wiki/Kana).
     *
     * See [dev.esnault.wanakana.isKana] for more details.
     */
    @JvmStatic
    fun isKana(input: String): Boolean =
        dev.esnault.wanakana.isKana(input)

    /**
     * Returns `true` if [input] is [Kana](https://en.wikipedia.org/wiki/Kana).
     *
     * See [dev.esnault.wanakana.isKana] for more details.
     */
    @JvmStatic
    fun isKana(input: Char): Boolean =
        dev.esnault.wanakana.isKana(input)

    /**
     * Returns `true` if [input] is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
     *
     * See [dev.esnault.wanakana.isHiragana] for more details.
     */
    @JvmStatic
    fun isHiragana(input: String): Boolean =
        dev.esnault.wanakana.isHiragana(input)

    /**
     * Returns `true` if [input] is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
     *
     * See [dev.esnault.wanakana.isHiragana] for more details.
     */
    @JvmStatic
    fun isHiragana(input: Char): Boolean =
        dev.esnault.wanakana.isHiragana(input)

    /**
     * Returns `true` if [input] is [Katakana](https://en.wikipedia.org/wiki/Katakana).
     *
     * See [dev.esnault.wanakana.isKatakana] for more details.
     */
    @JvmStatic
    fun isKatakana(input: String): Boolean =
        dev.esnault.wanakana.isKatakana(input)

    /**
     * Returns `true` if [input] is [Katakana](https://en.wikipedia.org/wiki/Katakana).
     *
     * See [dev.esnault.wanakana.isKatakana] for more details.
     */
    @JvmStatic
    fun isKatakana(input: Char): Boolean =
        dev.esnault.wanakana.isKatakana(input)

    /**
     * Returns `true` if [input] contains a mix of Romaji and Kana.
     *
     * See [dev.esnault.wanakana.isMixed] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun isMixed(input: String, passKanji: Boolean = true): Boolean =
        dev.esnault.wanakana.isMixed(input, passKanji)

    /**
     * Returns `true` if [input] is [Kanji](https://en.wikipedia.org/wiki/Kanji).
     *
     * See [dev.esnault.wanakana.isKanji] for more details.
     */
    @JvmStatic
    fun isKanji(input: String): Boolean =
        dev.esnault.wanakana.isKanji(input)

    /**
     * Returns `true` if [input] is [Kanji](https://en.wikipedia.org/wiki/Kanji).
     *
     * See [dev.esnault.wanakana.isKanji] for more details.
     */
    @JvmStatic
    fun isKanji(input: Char): Boolean =
        dev.esnault.wanakana.isKanji(input)

    // Conversion

    /**
     * Converts kana to romaji (Hepburn romanisation).
     *
     * See [dev.esnault.wanakana.toRomaji] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun toRomaji(
        input: String,
        imeMode: IMEMode = IMEMode.DISABLED,
        upcaseKatakana: Boolean = false
    ): String = dev.esnault.wanakana.toRomaji(input, imeMode, upcaseKatakana)

    /**
     * Converts kana to romaji (Hepburn romanisation).
     *
     * See [dev.esnault.wanakana.toRomaji] for more details.
     */
    @JvmStatic
    fun toRomaji(input: String, config: Config = Config.DEFAULT): String =
        dev.esnault.wanakana.toRomaji(input, config)

    /**
     * Converts Romaji to Kana.
     *
     * See [dev.esnault.wanakana.toKana] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun toKana(
        input: String,
        imeMode: IMEMode = IMEMode.DISABLED,
        useObsoleteKana: Boolean = false
    ): String = dev.esnault.wanakana.toKana(input, imeMode, useObsoleteKana)

    /**
     * Converts Romaji to Kana.
     *
     * See [dev.esnault.wanakana.toKana] for more details.
     */
    @JvmStatic
    fun toKana(input: String, config: Config = Config.DEFAULT): String =
        dev.esnault.wanakana.toKana(input, config)

    /**
     * Converts input to [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
     *
     * See [dev.esnault.wanakana.toHiragana] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun toHiragana(
        input: String,
        imeMode: IMEMode = IMEMode.DISABLED,
        passRomaji: Boolean = false,
        useObsoleteKana: Boolean = false
    ): String = dev.esnault.wanakana.toHiragana(input, imeMode, passRomaji, useObsoleteKana)

    /**
     * Converts input to [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
     *
     * See [dev.esnault.wanakana.toHiragana] for more details.
     */
    @JvmStatic
    fun toHiragana(input: String, config: Config = Config.DEFAULT): String =
        dev.esnault.wanakana.toHiragana(input, config)

    /**
     * Converts input to [Katakana](https://en.wikipedia.org/wiki/Katakana).
     *
     * See [dev.esnault.wanakana.toKatakana] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun toKatakana(
        input: String,
        imeMode: IMEMode = IMEMode.DISABLED,
        passRomaji: Boolean = false,
        useObsoleteKana: Boolean = false
    ): String = dev.esnault.wanakana.toKatakana(input, imeMode, passRomaji, useObsoleteKana)

    /**
     * Converts input to [Katakana](https://en.wikipedia.org/wiki/Katakana).
     *
     * See [dev.esnault.wanakana.toKatakana] for more details.
     */
    @JvmStatic
    fun toKatakana(input: String, config: Config = Config.DEFAULT): String =
        dev.esnault.wanakana.toKatakana(input, config)

    // Other utils

    /**
     * Strips [Okurigana](https://en.wikipedia.org/wiki/Okurigana).
     *
     * See [dev.esnault.wanakana.stripOkurigana] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun stripOkurigana(
        input: String,
        leading: Boolean = false,
        matchKanji: String? = null
    ): String = dev.esnault.wanakana.stripOkurigana(input, leading, matchKanji)

    /**
     * Splits input into a list of strings separated by opinionated [TokenType]s.
     *
     * See [dev.esnault.wanakana.tokenize] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun tokenize(input: String, compact: Boolean = false): List<String> =
        dev.esnault.wanakana.tokenize(input, compact)

    /**
     * Splits input into a list of tokens separated by opinionated [TokenType]s.
     *
     * See [dev.esnault.wanakana.tokenizeWithType] for more details.
     */
    @JvmStatic
    @JvmOverloads
    fun tokenizeWithType(input: String, compact: Boolean = false): List<TypedToken> =
        dev.esnault.wanakana.tokenizeWithType(input, compact)
}
