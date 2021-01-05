//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[isKatakana](is-katakana.md)



# isKatakana  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isKatakana](is-katakana.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is [Katakana](https://en.wikipedia.org/wiki/Katakana).



For example:

<ul><li>isKatakana("ゲーム") => true</li><li>isKatakana("あ") => false</li><li>isKatakana("A") => false</li><li>isKatakana("あア") => false</li></ul>  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isKatakana](is-katakana.md)(input: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is [Katakana](https://en.wikipedia.org/wiki/Katakana).



For example:

<ul><li>isKatakana('ア') => true</li><li>isKatakana('あ') => false</li><li>isKatakana('A') => false</li></ul>  



