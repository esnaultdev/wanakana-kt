package dev.esnault.wanakana.core

import dev.esnault.wanakana.core.Wanakana.toKana
import dev.esnault.wanakana.core.utils.ImeText

/**
 * Core Wanakana functions.
 */
public object Wanakana {
    // region Writing system checks (String + Char)

    /**
     * Returns `true` if [input] is Romaji (allowing Hepburn romanisation).
     *
     * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
     * See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).
     *
     * @param allowed additional test allowed to pass for each char.
     *
     * For example:
     * - `isRomaji("Tōkyō and Ōsaka")` => `true`
     * - `isRomaji("12a*b&c-d")` => `true`
     * - `isRomaji("あアA")` => `false`
     * - `isRomaji("お願い")` => `false`
     * - `isRomaji("a！b&cーd")` => `false` // Zenkaku punctuation fails
     * - `isRomaji("a！b&cーd", Regex("""[！ー]"""))` => `true`
     */
    @JvmStatic
    @JvmOverloads
    public fun isRomaji(input: String, allowed: Regex? = null): Boolean =
        dev.esnault.wanakana.core.isRomaji(input, allowed)

    /**
     * Returns `true` if [input] is Romaji (allowing Hepburn romanisation).
     *
     * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
     * See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).
     *
     * For example:
     * - `isRomaji('A')` => `true`
     * - `isRomaji('ō')` => `true`
     * - `isRomaji('あ')` => `false`
     * - `isRomaji('ア')` => `false`
     * - `isRomaji('願')` => `false`
     */
    @JvmStatic
    public fun isRomaji(input: Char): Boolean =
        dev.esnault.wanakana.core.isRomaji(input)

    /**
     * Returns `true` if [input] only includes Kanji, Kana, zenkaku numbers, and JA
     * punctuation/symbols.
     *
     * See [Kanji](https://en.wikipedia.org/wiki/Kanji).
     * See [Kana](https://en.wikipedia.org/wiki/Kana).
     *
     * @param allowed additional test allowed to pass for each char.
     *
     * For example:
     * - `isJapanese("泣き虫")` => `true`
     * - `isJapanese("あア")` => `true`
     * - `isJapanese("２月")` => `true` // Zenkaku numbers allowed
     * - `isJapanese("泣き虫。！〜＄")` => `true` // Zenkaku/JA punctuation
     * - `isJapanese("泣き虫.!~$")` => `false` // Latin punctuation fails
     * - `isJapanese("A泣き虫")` => `false`
     * - `isJapanese("≪偽括弧≫", Regex("""[≪≫]"""))` => `true`
     */
    @JvmStatic
    @JvmOverloads
    public fun isJapanese(input: String, allowed: Regex? = null): Boolean =
        dev.esnault.wanakana.core.isJapanese(input, allowed)

    /**
     * Returns `true` if [input] only includes Kanji, Kana, zenkaku numbers, and JA
     * punctuation/symbols.
     *
     * See [Kanji](https://en.wikipedia.org/wiki/Kanji).
     * See [Kana](https://en.wikipedia.org/wiki/Kana).
     *
     * For example:
     * - `isJapanese('泣')` => `true`
     * - `isJapanese('あ')` => `true`
     * - `isJapanese('ア')` => `true`
     * - `isJapanese('２')` => `true` // Zenkaku numbers allowed
     * - `isJapanese('。')` => `true` // JA punctuation
     * - `isJapanese('!')` => `false` // Latin punctuation fails
     * - `isJapanese('A')` => `false`
     */
    @JvmStatic
    public fun isJapanese(input: Char): Boolean =
        dev.esnault.wanakana.core.isJapanese(input)

    /**
     * Returns `true` if [input] is [Kana](https://en.wikipedia.org/wiki/Kana).
     *
     * For example:
     * - `isKana("あ")` => `true`
     * - `isKana("ア")` => `true`
     * - `isKana("あーア")` => `true`
     * - `isKana("A")` => `false`
     * - `isKana("あAア")` => `false`
     */
    @JvmStatic
    public fun isKana(input: String): Boolean =
        dev.esnault.wanakana.core.isKana(input)

    /**
     * Returns `true` if [input] is [Kana](https://en.wikipedia.org/wiki/Kana).
     *
     * For example:
     * - `isKana('あ')` => `true`
     * - `isKana('ア')` => `true`
     * - `isKana('A')` => `false`
     */
    @JvmStatic
    public fun isKana(input: Char): Boolean =
        dev.esnault.wanakana.core.isKana(input)

    /**
     * Returns `true` if [input] is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
     *
     * For example:
     * - `isHiragana("げーむ")` => `true`
     * - `isHiragana("A")` => `false`
     * - `isHiragana("あア")` => `false`
     */
    @JvmStatic
    public fun isHiragana(input: String): Boolean =
        dev.esnault.wanakana.core.isHiragana(input)

    /**
     * Returns `true` if [input] is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
     *
     * For example:
     * - `isHiragana('げ')` => `true`
     * - `isHiragana('A')` => `false`
     * - `isHiragana('ア')` => `false`
     */
    @JvmStatic
    public fun isHiragana(input: Char): Boolean =
        dev.esnault.wanakana.core.isHiragana(input)

    /**
     * Returns `true` if [input] is [Katakana](https://en.wikipedia.org/wiki/Katakana).
     *
     * For example:
     * - `isKatakana("ゲーム")` => `true`
     * - `isKatakana("あ")` => `false`
     * - `isKatakana("A")` => `false`
     * - `isKatakana("あア")` => `false`
     */
    @JvmStatic
    public fun isKatakana(input: String): Boolean =
        dev.esnault.wanakana.core.isKatakana(input)

    /**
     * Returns `true` if [input] is [Katakana](https://en.wikipedia.org/wiki/Katakana).
     *
     * For example:
     * - `isKatakana('ア')` => `true`
     * - `isKatakana('あ')` => `false`
     * - `isKatakana('A')` => `false`
     */
    @JvmStatic
    public fun isKatakana(input: Char): Boolean =
        dev.esnault.wanakana.core.isKatakana(input)

    /**
     * Returns `true` if [input] contains a mix of Romaji and Kana.
     *
     * @param passKanji if `true`, ignore kanji, defaults to `true`. Otherwise this check will fail
     * if any character is a Kanji.
     *
     * See [Romaji](https://en.wikipedia.org/wiki/Romaji)
     * See [Kana](https://en.wikipedia.org/wiki/Kana)
     * See [Kanji](https://en.wikipedia.org/wiki/Kanji)
     *
     * For example:
     * - `isMixed("Abあア"))` => `true`
     * - `isMixed("お腹A"))` => `true` // ignores kanji by default
     * - `isMixed("お腹A", passKanji = false)` => `false`
     * - `isMixed("ab"))` => `false`
     * - `isMixed("あア"))` => `false`
     */
    @JvmStatic
    @JvmOverloads
    public fun isMixed(input: String, passKanji: Boolean = true): Boolean =
        dev.esnault.wanakana.core.isMixed(input, passKanji)

    /**
     * Returns `true` if [input] is [Kanji](https://en.wikipedia.org/wiki/Kanji).
     * See [Japanese CJK ideographs](https://en.wikipedia.org/wiki/CJK_Unified_Ideographs).
     *
     * For example:
     * - `isKanji("刀")` => `true`
     * - `isKanji("切腹")` => `true`
     * - `isKanji("勢い")` => `false`
     * - `isKanji("あAア")` => `false`
     * - `isKanji("")` => `true`
     */
    @JvmStatic
    public fun isKanji(input: String): Boolean =
        dev.esnault.wanakana.core.isKanji(input)

    /**
     * Returns `true` if [input] is [Kanji](https://en.wikipedia.org/wiki/Kanji).
     * See [Japanese CJK ideographs](https://en.wikipedia.org/wiki/CJK_Unified_Ideographs).
     *
     * For example:
     * - `isKanji('刀')` => `true`
     * - `isKanji('あ')` => `false`
     * - `isKanji('ア')` => `false`
     * - `isKanji('A')` => `false`
     */
    @JvmStatic
    public fun isKanji(input: Char): Boolean =
        dev.esnault.wanakana.core.isKanji(input)

    // endregion

    // region Conversion

    /**
     * Converts kana to romaji (Hepburn romanisation).
     *
     * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
     * See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).
     *
     * @param input the kana text input.
     * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
     * [IMEMode.DISABLED].
     * @param upcaseKatakana if `true`, katakana will be converted to uppercase, defaults to
     * `false`.
     * @return the converted text.
     *
     * For example:
     * - `toRomaji("ひらがな　カタカナ")` => `"hiragana katakana"`
     * - `toRomaji("げーむ　ゲーム")` => `"ge-mu geemu"`
     * - `toRomaji("ひらがな　カタカナ", upcaseKatakana = true)` => `"hiragana KATAKANA"`
     */
    @JvmStatic
    @JvmOverloads
    public fun toRomaji(
        input: String,
        imeMode: IMEMode = IMEMode.DISABLED,
        upcaseKatakana: Boolean = false
    ): String = dev.esnault.wanakana.core.toRomaji(input, imeMode, upcaseKatakana)

    /**
     * Converts kana to romaji (Hepburn romanisation).
     *
     * @param input the kana text input.
     * @param config optional configuration of the conversion. Defaults to [Config.DEFAULT].
     * @return the converted text.
     *
     * See [toRomaji] for more details.
     */
    @JvmStatic
    public fun toRomaji(input: String, config: Config = Config.DEFAULT): String =
        dev.esnault.wanakana.core.toRomaji(input, config)

    /**
     * Converts kana to romaji (Hepburn romanisation), and preserves the cursor/selection.
     *
     * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
     * See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).
     *
     * @param input the kana text input.
     * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
     * [IMEMode.ENABLED].
     * @param upcaseKatakana if `true`, katakana will be converted to uppercase, defaults to
     * `false`.
     * @return the converted text.
     *
     * See [toRomaji] for more details.
     */
    @JvmStatic
    @JvmOverloads
    public fun toRomajiIme(
        input: ImeText,
        imeMode: IMEMode = IMEMode.ENABLED,
        upcaseKatakana: Boolean = false
    ): ImeText = dev.esnault.wanakana.core.toRomajiIme(input, imeMode, upcaseKatakana)

    /**
     * Converts kana to romaji (Hepburn romanisation), and preserves the cursor/selection.
     *
     * @param input the kana text input.
     * @param config optional configuration of the conversion. Defaults to [Config.DEFAULT_IME].
     * @return the converted text.
     *
     * See [toRomaji] for more details.
     */
    @JvmStatic
    public fun toRomajiIme(input: ImeText, config: Config = Config.DEFAULT_IME): ImeText =
        dev.esnault.wanakana.core.toRomajiIme(input, config)

    /**
     * Converts Romaji to Kana.
     * Lowercase text will result in Hiragana and uppercase text will result in Katakana.
     *
     * @param input the text to convert to Kana.
     * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
     * [IMEMode.DISABLED].
     * @param useObsoleteKana if `true` obsolete kanas will be used (ゐゑヰヱ), defaults to `false`.
     * @return the converted text.
     *
     * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
     * See [Kana](https://en.wikipedia.org/wiki/Kana).
     * See [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
     * See [Katakana](https://en.wikipedia.org/wiki/Katakana).
     *
     * For example:
     * - `toKana("onaji BUTTSUUJI")` => `"おなじ ブッツウジ"`
     * - `toKana("ONAJI buttsuuji")` => `"オナジ ぶっつうじ"`
     * - `toKana("座禅‘zazen’スタイル")` => `"座禅「ざぜん」スタイル"`
     * - `toKana("batsuge-mu")` => `"ばつげーむ"`
     * - `toKana("!?.:/,~-‘’“”[](){}")` => `"！？。：・、〜ー「」『』［］（）｛｝"`
     */
    @JvmStatic
    @JvmOverloads
    public fun toKana(
        input: String,
        imeMode: IMEMode = IMEMode.DISABLED,
        useObsoleteKana: Boolean = false
    ): String = dev.esnault.wanakana.core.toKana(input, imeMode, useObsoleteKana)

    /**
     * Converts Romaji to Kana.
     * Lowercase text will result in Hiragana and uppercase text will result in Katakana.
     *
     * @param input the text to convert to Kana.
     * @param config optional configuration of the conversion. Defaults to [Config.DEFAULT].
     * @return the converted text.
     *
     * See [toKana] for more details and examples.
     */
    @JvmStatic
    public fun toKana(input: String, config: Config = Config.DEFAULT): String =
        dev.esnault.wanakana.core.toKana(input, config)

    /**
     * Converts Romaji to Kana and preserves the cursor/selection.
     * Lowercase text will result in Hiragana and uppercase text will result in Katakana.
     *
     * @param input the text to convert to Kana, with cursor/selection.
     * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
     * [IMEMode.ENABLED].
     * @param useObsoleteKana if `true` obsolete kanas will be used (ゐゑヰヱ), defaults to `false`.
     * @return the converted text, with cursor/selection.
     *
     * See [toKana] for more details and examples.
     */
    @JvmStatic
    @JvmOverloads
    public fun toKanaIme(
        input: ImeText,
        imeMode: IMEMode = IMEMode.ENABLED,
        useObsoleteKana: Boolean = false
    ): ImeText = dev.esnault.wanakana.core.toKanaIme(input, imeMode, useObsoleteKana)

    /**
     * Converts Romaji to Kana and preserves the cursor/selection.
     * Lowercase text will result in Hiragana and uppercase text will result in Katakana.
     *
     * @param input the text to convert to Kana, with cursor/selection.
     * @param config optional configuration of the conversion. Defaults to [Config.DEFAULT_IME].
     * @return the converted text, with cursor/selection.
     *
     * See [toKana] for more details and examples.
     */
    @JvmStatic
    public fun toKanaIme(input: ImeText, config: Config = Config.DEFAULT_IME): ImeText =
        dev.esnault.wanakana.core.toKanaIme(input, config)

    /**
     * Converts input to [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
     *
     * @param input the text to convert.
     * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
     * [IMEMode.DISABLED].
     * @param passRomaji if `true` romaji will be kept as-is, defaults to `false`.
     * @param useObsoleteKana if `true` obsolete kanas will be used (ゐ and ゑ), defaults to `false`.
     * @return the converted text.
     *
     * For example:
     * - `toHiragana("toukyou, オオサカ") // => `"とうきょう、　おおさか"`
     * - `toHiragana("only カナ", passRomaji = true)` => `"only かな"`
     * - `toHiragana("wi")` => `"うぃ"`
     * - `toHiragana("wi", useObsoleteKana = true)` => `"ゐ"`
     */
    @JvmStatic
    @JvmOverloads
    public fun toHiragana(
        input: String,
        imeMode: IMEMode = IMEMode.DISABLED,
        passRomaji: Boolean = false,
        useObsoleteKana: Boolean = false
    ): String = dev.esnault.wanakana.core.toHiragana(input, imeMode, passRomaji, useObsoleteKana)

    /**
     * Converts input to [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
     *
     * @param input the text input.
     * @param config optional configuration of the conversion. Defaults to [Config.DEFAULT].
     * @return the converted text.
     *
     * See [toHiragana] for more details.
     */
    @JvmStatic
    public fun toHiragana(input: String, config: Config = Config.DEFAULT): String =
        dev.esnault.wanakana.core.toHiragana(input, config)

    /**
     * Converts input to [Katakana](https://en.wikipedia.org/wiki/Katakana).
     *
     * @param input the text to convert.
     * @param imeMode if enabled, handles conversion while the text is being typed, defaults to
     * [IMEMode.DISABLED].
     * @param passRomaji if `true` romaji will be kept as-is, defaults to `false`.
     * @param useObsoleteKana if `true` obsolete kanas will be used (ヰ and ヱ), defaults to `false`.
     * @return the converted text.
     *
     * For example:
     * - `toKatakana('toukyou, おおさか')` => `'トウキョウ、　オオサカ'`
     * - `toKatakana('only かな', passRomaji = true)` => `'only カナ'`
     * - `toKatakana('wi')` => `'ウィ'`
     * - `toKatakana('wi', useObsoleteKana = true)` => `'ヰ'`
     */
    @JvmStatic
    @JvmOverloads
    public fun toKatakana(
        input: String,
        imeMode: IMEMode = IMEMode.DISABLED,
        passRomaji: Boolean = false,
        useObsoleteKana: Boolean = false
    ): String = dev.esnault.wanakana.core.toKatakana(input, imeMode, passRomaji, useObsoleteKana)

    /**
     * Converts input to [Katakana](https://en.wikipedia.org/wiki/Katakana).
     *
     * @param input the text input.
     * @param config optional configuration of the conversion. Defaults to [Config.DEFAULT].
     * @return the converted text.
     *
     * See [toKatakana] for more details.
     */
    @JvmStatic
    public fun toKatakana(input: String, config: Config = Config.DEFAULT): String =
        dev.esnault.wanakana.core.toKatakana(input, config)

    // endregion

    // region Other utils

    /**
     * Strips [Okurigana](https://en.wikipedia.org/wiki/Okurigana).
     *
     * @param [input] the input text.
     * @param [leading] if `true`, strips leading okurigana instead of trailing okurigana, defaults
     * to `false`.
     * @param [matchKanji] optional kanji representation of the text, to help strip okurigana from a
     * kana input.
     * @return the text with okurigana removed.
     *
     * For example:
     * - `stripOkurigana("踏み込む")` => `"踏み込"`
     * - `stripOkurigana("お祝い")` => `"お祝"`
     * - `stripOkurigana("お腹", leading = true)` => `"腹"`
     * - `stripOkurigana("ふみこむ", matchKanji = "踏み込む")` => `"ふみこ"`
     * - `stripOkurigana("おみまい", matchKanji = "お祝い", leading = true)` => `"みまい"`
     */
    @JvmStatic
    @JvmOverloads
    public fun stripOkurigana(
        input: String,
        leading: Boolean = false,
        matchKanji: String? = null
    ): String = dev.esnault.wanakana.core.stripOkurigana(input, leading, matchKanji)

    /**
     * Splits input into a list of strings separated by opinionated [TokenType]s.
     * @param input the text to tokenize.
     * @param compact if `true`, then many same-language tokens are combined (spaces + text, kanji +
     * kana, numeral + punctuation). Defaults to `false`.
     * @return the text split into [String] tokens.
     *
     * For example:
     * - `tokenize("ふふフフ")` => `["ふふ", "フフ"]`
     * - `tokenize("感じ")` => `["感", "じ"]`
     * - `tokenize("truly 私は悲しい")` => ["truly", " ", "私", "は", "悲", "しい"]`
     * - `tokenize("truly 私は悲しい", compact = true)` => ["truly ", "私は悲しい"]`
     * - `tokenize("5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！")`
     *   => `[ "5", "romaji", " ", "here", "...!?", "漢字", "ひらがな", "カタ", "　", "カナ", "４", "「", "ＳＨＩＯ", "」。！"]`
     * - `tokenize("5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！", compact = true)`
     *   => `[ "5", "romaji here", "...!?", "漢字ひらがなカタ　カナ", "４「", "ＳＨＩＯ", "」。！"]`
     */
    @JvmStatic
    @JvmOverloads
    public fun tokenize(input: String, compact: Boolean = false): List<String> =
        dev.esnault.wanakana.core.tokenize(input, compact)

    /**
     * Splits input into a list of tokens separated by opinionated [TokenType]s.
     * @param input the text to tokenize.
     * @param compact if `true`, then many same-language tokens are combined (spaces + text, kanji +
     * kana, numeral + punctuation). Defaults to `false`.
     * @return the text split into [TypedToken]s.
     *
     * For example:
     * - `tokenize('5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！ لنذهب')` =>
     * ```
     * [
     *  { type: 'englishNumeral', value: '5' },
     *  { type: 'en', value: 'romaji' },
     *  { type: 'space', value: ' ' },
     *  { type: 'en', value: 'here' },
     *  { type: 'englishPunctuation', value: '...!?' },
     *  { type: 'kanji', value: '漢字' },
     *  { type: 'hiragana', value: 'ひらがな' },
     *  { type: 'katakana', value: 'カタ' },
     *  { type: 'space', value: '　' },
     *  { type: 'katakana', value: 'カナ' },
     *  { type: 'japaneseNumeral', value: '４' },
     *  { type: 'japanesePunctuation', value: '「' },
     *  { type: 'ja', value: 'ＳＨＩＯ' },
     *  { type: 'japanesePunctuation', value: '」。！' },
     *  { type: 'space', value: ' ' },
     *  { type: 'other', value: 'لنذهب' }
     * ]
     * ```
     *
     * - `tokenize('5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！ لنذهب', compact = true)` =>
     * ```
     * [
     *  { type: 'other', value: '5' },
     *  { type: 'en', value: 'romaji here' },
     *  { type: 'other', value: '...!?' },
     *  { type: 'ja', value: '漢字ひらがなカタ　カナ' },
     *  { type: 'other', value: '４「' },
     *  { type: 'ja', value: 'ＳＨＩＯ' },
     *  { type: 'other', value: '」。！' },
     *  { type: 'en', value: ' ' },
     *  { type: 'other', value: 'لنذهب' }
     * ]
     * ```
     */
    @JvmStatic
    @JvmOverloads
    public fun tokenizeWithType(input: String, compact: Boolean = false): List<TypedToken> =
        dev.esnault.wanakana.core.tokenizeWithType(input, compact)

    // endregion
}
