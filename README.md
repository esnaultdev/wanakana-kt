<div align="center">
<h1>ワナカナ &lt;--&gt; WanaKana &lt;--&gt; わなかな</h1>
<h4>Kotlin utility library for detecting and transliterating Hiragana, Katakana, and Romaji</h4>
</div>

Ported from [WaniKani/WanaKana][wanakana-repo] v4.0.2.

This library is written in Kotlin, but it can be used from Java.

## Demo

Visit the [website][wanakana-website] to see WanaKana in action (JS version).

## Usage

```
// Android bindings
implementation 'dev.esnault.wanakana:wanakana-android:1.1.1'

// Conversion and detection
// You don't need to include this if you use wanakana-android.
implementation 'dev.esnault.wanakana:wanakana-core:1.1.1'
```

The artifacts are available on mavenCentral, make sure that your buildscript repositories include mavenCentral.

## Documentation

- [Index][docs-index]
  - [Wanakana (core functions)][docs-wanakana]
  - [WanakanaAndroid (Android bindings)][docs-wanakana-android]

## Quick Reference

```kotlin
/*** ANDROID BINDINGS ***/
// Automatically converts text using a TextWatcher.
// Uses `toKanaIme()` as converter by default
val binding = WanakanaAndroid.bind(editText)

// Removes the TextWatcher.
binding.clear()

/*** TEXT CHECKING UTILITIES ***/
// Available for both Char and String.
// Extensions functions are also available.

Wanakana.isJapanese("泣き虫。！〜２￥ｚｅｎｋａｋｕ")
// => true

Wanakana.isKana("あーア")
// => true

Wanakana.isHiragana("すげー")
// => true

Wanakana.isKatakana("ゲーム")
// => true

Wanakana.isKanji("切腹")
// => true
Wanakana.isKanji("勢い")
// => false

Wanakana.isRomaji("Tōkyō and Ōsaka")
// => true

/*** TEXT CONVERSION ***/
Wanakana.toKana("ONAJI buttsuuji")
// => "オナジ ぶっつうじ"
Wanakana.toKana("座禅‘zazen’スタイル")
// => "座禅「ざぜん」スタイル"
Wanakana.toKana("batsuge-mu")
// => "ばつげーむ"

Wanakana.toHiragana("toukyou, オオサカ")
// => "とうきょう、　おおさか"
Wanakana.toHiragana("only カナ", passRomaji = true)
// => "only かな"
Wanakana.toHiragana("wi", useObsoleteKana = true)
// => "ゐ"

Wanakana.toKatakana("toukyou, おおさか")
// => "トウキョウ、　オオサカ"
Wanakana.toKatakana("only かな", passRomaji = true)
// => "only カナ"
Wanakana.toKatakana("wi", useObsoleteKana = true)
// => "ヰ"

Wanakana.toRomaji("ひらがな　カタカナ")
// => "hiragana katakana"
Wanakana.toRomaji("ひらがな　カタカナ", upcaseKatakana = true)
// => "hiragana KATAKANA"

/*** EXTRA UTILITIES ***/
Wanakana.stripOkurigana("お祝い")
// => "お祝"
Wanakana.stripOkurigana("踏み込む")
// => "踏み込"
Wanakana.stripOkurigana("お腹", leading = true)
// => "腹"
Wanakana.stripOkurigana("ふみこむ", matchKanji = "踏み込む")
// => "ふみこ"
Wanakana.stripOkurigana("おみまい", matchKanji = "お祝い", leading = true)
// => "みまい"

Wanakana.tokenize("ふふフフ")
// => ["ふふ", "フフ"]
Wanakana.tokenize("hello 田中さん")
// => ["hello", " ", "田中", "さん"]
Wanakana.tokenize("I said 私はすごく悲しい", compact = true)
// => [ "I said ", "私はすごく悲しい"]
```

## Differences with Wanakana JS

|               | Wakakana JS  | Wanakana KT |
| ------------- | ------------- | ------------- |
| String detection | `false` if the input is empty | `true` if the input is empty<br/>(matches the behavior of `String::all`) |
| Detailed tokenize | tokenize(input, { detailed: true }) | tokenizeWithType(input) |

Custom mappings are not implemented yet.

## Credits

Original JavaScript library sponsored by [Tofugu][tofugu] & [WaniKani][wanikani].

[wanakana-repo]: https://github.com/WaniKani/WanaKana
[wanakana-website]: http://www.wanakana.com
[wanikani]: http://www.wanikani.com
[tofugu]: http://www.tofugu.com
[docs-index]: https://esnaultdev.github.io/wanakana-kt/wanakana-core/index.html
[docs-wanakana]: https://esnaultdev.github.io/wanakana-kt/wanakana-core/wanakana-core/dev.esnault.wanakana.core/-wanakana/index.html
[docs-wanakana-android]: https://esnaultdev.github.io/wanakana-kt/wanakana-android/wanakana-android/dev.esnault.wanakana.android/-wanakana-android/index.html
