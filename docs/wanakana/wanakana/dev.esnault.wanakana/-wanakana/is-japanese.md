//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[isJapanese](is-japanese.md)



# isJapanese  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [isJapanese](is-japanese.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), allowed: [Regex](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/index.html)? = null): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input only includes Kanji, Kana, zenkaku numbers, and JA punctuation/symbols.



See [Kanji](https://en.wikipedia.org/wiki/Kanji). See [Kana](https://en.wikipedia.org/wiki/Kana).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/isJapanese/#kotlin.String#kotlin.text.Regex?/PointingToDeclaration/"></a>allowed| <a name="dev.esnault.wanakana/Wanakana/isJapanese/#kotlin.String#kotlin.text.Regex?/PointingToDeclaration/"></a><br><br>additional test allowed to pass for each char.<br><br><br><br>For example:<br><br><ul><li>isJapanese("泣き虫") => true</li><li>isJapanese("あア") => true</li><li>isJapanese("２月") => true // Zenkaku numbers allowed</li><li>isJapanese("泣き虫。！〜＄") => true // Zenkaku/JA punctuation</li><li>isJapanese("泣き虫.!~$") => false // Latin punctuation fails</li><li>isJapanese("A泣き虫") => false</li><li>isJapanese("≪偽括弧≫", Regex("""[≪≫]""")) => true</li></ul>
  
  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isJapanese](is-japanese.md)(input: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input only includes Kanji, Kana, zenkaku numbers, and JA punctuation/symbols.



See [Kanji](https://en.wikipedia.org/wiki/Kanji). See [Kana](https://en.wikipedia.org/wiki/Kana).



For example:

<ul><li>isJapanese('泣') => true</li><li>isJapanese('あ') => true</li><li>isJapanese('ア') => true</li><li>isJapanese('２') => true // Zenkaku numbers allowed</li><li>isJapanese('。') => true // JA punctuation</li><li>isJapanese('!') => false // Latin punctuation fails</li><li>isJapanese('A') => false</li></ul>  



