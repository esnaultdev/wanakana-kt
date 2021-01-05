//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[tokenize](tokenize.md)



# tokenize  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [tokenize](tokenize.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), compact: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>  
More info  


Splits input into a list of strings separated by opinionated [TokenType](../-token-type/index.md)s.



#### Return  


the text split into [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) tokens.



For example:

<ul><li>tokenize("ふふフフ") => ["ふふ", "フフ"]</li><li>tokenize("感じ") => ["感", "じ"]</li><li>tokenize("truly 私は悲しい") => "truly", " ", "私", "は", "悲", "しい"`</li><li>tokenize("truly 私は悲しい", compact = true) => "truly ", "私は悲しい"`</li><li>tokenize("5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！") => [ "5", "romaji", " ", "here", "...!?", "漢字", "ひらがな", "カタ", "　", "カナ", "４", "「", "ＳＨＩＯ", "」。！"]</li><li>tokenize("5romaji here...!?漢字ひらがなカタ　カナ４「ＳＨＩＯ」。！", compact = true) => [ "5", "romaji here", "...!?", "漢字ひらがなカタ　カナ", "４「", "ＳＨＩＯ", "」。！"]</li></ul>

## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/tokenize/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/tokenize/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a><br><br>the text to tokenize.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/tokenize/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a>compact| <a name="dev.esnault.wanakana/Wanakana/tokenize/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if true, then many same-language tokens are combined (spaces + text, kanji + kana, numeral + punctuation). Defaults to false.<br><br>
  
  



