//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[isHiragana](is-hiragana.md)



# isHiragana  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isHiragana](is-hiragana.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).



For example:

<ul><li>isHiragana("げーむ") => true</li><li>isHiragana("A") => false</li><li>isHiragana("あア") => false</li></ul>  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isHiragana](is-hiragana.md)(input: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is [Hiragana](https://en.wikipedia.org/wiki/Hiragana).



For example:

<ul><li>isHiragana('げ') => true</li><li>isHiragana('A') => false</li><li>isHiragana('ア') => false</li></ul>  



