//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[isKanji](is-kanji.md)



# isKanji  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isKanji](is-kanji.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is [Kanji](https://en.wikipedia.org/wiki/Kanji). See [Japanese CJK ideographs](https://en.wikipedia.org/wiki/CJK_Unified_Ideographs).



For example:

<ul><li>isKanji("刀") => true</li><li>isKanji("切腹") => true</li><li>isKanji("勢い") => false</li><li>isKanji("あAア") => false</li><li>isKanji("") => true</li></ul>  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isKanji](is-kanji.md)(input: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is [Kanji](https://en.wikipedia.org/wiki/Kanji). See [Japanese CJK ideographs](https://en.wikipedia.org/wiki/CJK_Unified_Ideographs).



For example:

<ul><li>isKanji('刀') => true</li><li>isKanji('あ') => false</li><li>isKanji('ア') => false</li><li>isKanji('A') => false</li></ul>  



