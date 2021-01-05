<div align="center">
<h1>ワナカナ &lt;--&gt; WanaKana &lt;--&gt; わなかな</h1>
<h4>Kotlin utility library for detecting and transliterating Hiragana, Katakana, and Romaji</h4>
</div>

Ported from [WaniKani/WanaKana](https://github.com/WaniKani/WanaKana) v4.0.2.

This library is written in Kotlin, but it can be used from Java.

## Demo

Visit the [website](http://www.wanakana.com) to see WanaKana in action (JS version).

## Usage

TODO Deploy the libraries to JCenter.

## Documentation

- [Wanakana](https://github.com/esnaultdev/wanakana-kt/blob/master/wanakana/src/main/java/dev/esnault/wanakana/Wanakana.kt)
- [WanakanaAndroid](https://github.com/esnaultdev/wanakana-kt/blob/master/wanakana-android/src/main/java/dev/esnault/wanakana/android/WanakanaAndroid.kt)

<!--
  TODO Generate the documentation using Dokka once Dokka is more stable.
  Right now it's not stable when using `./gradlew dokkaHtmlMultiModule`:
  - lack of `index.html`
  - broken links for the root `-modules.html` file
  See https://github.com/Kotlin/dokka/issues/1302
-->

## Quick Reference

```kotlin
/*** DOM HELPERS ***/
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

## Credits

Original JavaScript library sponsored by [Tofugu](http://www.tofugu.com) &
[WaniKani](http://www.wanikani.com).
