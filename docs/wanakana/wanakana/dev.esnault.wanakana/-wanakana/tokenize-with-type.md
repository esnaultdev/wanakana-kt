//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[tokenizeWithType](tokenize-with-type.md)



# tokenizeWithType  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [tokenizeWithType](tokenize-with-type.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), compact: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypedToken](../-typed-token/index.md)>  
More info  


Splits input into a list of tokens separated by opinionated [TokenType](../-token-type/index.md)s.



#### Return  


the text split into [TypedToken](../-typed-token/index.md)s.



For example:

<ul><li>tokenize('5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！ لنذهب') =></li></ul>[  
 { type: 'englishNumeral', value: '5' },  
 { type: 'en', value: 'romaji' },  
 { type: 'space', value: ' ' },  
 { type: 'en', value: 'here' },  
 { type: 'englishPunctuation', value: '...!?' },  
 { type: 'kanji', value: '漢字' },  
 { type: 'hiragana', value: 'ひらがな' },  
 { type: 'katakana', value: 'カタ' },  
 { type: 'space', value: '　' },  
 { type: 'katakana', value: 'カナ' },  
 { type: 'japaneseNumeral', value: '４' },  
 { type: 'japanesePunctuation', value: '「' },  
 { type: 'ja', value: 'ＳＨＩＯ' },  
 { type: 'japanesePunctuation', value: '」。！' },  
 { type: 'space', value: ' ' },  
 { type: 'other', value: 'لنذهب' }  
]<ul><li>tokenize('5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！ لنذهب', compact = true) =></li></ul>[  
 { type: 'other', value: '5' },  
 { type: 'en', value: 'romaji here' },  
 { type: 'other', value: '...!?' },  
 { type: 'ja', value: '漢字ひらがなカタ　カナ' },  
 { type: 'other', value: '４「' },  
 { type: 'ja', value: 'ＳＨＩＯ' },  
 { type: 'other', value: '」。！' },  
 { type: 'en', value: ' ' },  
 { type: 'other', value: 'لنذهب' }  
]

## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/tokenizeWithType/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/tokenizeWithType/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a><br><br>the text to tokenize.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/tokenizeWithType/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a>compact| <a name="dev.esnault.wanakana/Wanakana/tokenizeWithType/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if true, then many same-language tokens are combined (spaces + text, kanji + kana, numeral + punctuation). Defaults to false.<br><br>
  
  



