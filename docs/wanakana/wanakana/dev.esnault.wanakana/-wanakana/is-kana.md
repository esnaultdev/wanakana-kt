//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[isKana](is-kana.md)



# isKana  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isKana](is-kana.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is [Kana](https://en.wikipedia.org/wiki/Kana).



For example:

<ul><li>isKana("あ") => true</li><li>isKana("ア") => true</li><li>isKana("あーア") => true</li><li>isKana("A") => false</li><li>isKana("あAア") => false</li></ul>  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isKana](is-kana.md)(input: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is [Kana](https://en.wikipedia.org/wiki/Kana).



For example:

<ul><li>isKana('あ') => true</li><li>isKana('ア') => true</li><li>isKana('A') => false</li></ul>  



