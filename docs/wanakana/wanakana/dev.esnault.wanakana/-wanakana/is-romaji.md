//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[isRomaji](is-romaji.md)



# isRomaji  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [isRomaji](is-romaji.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), allowed: [Regex](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/index.html)? = null): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is Romaji (allowing Hepburn romanisation).



See [Romaji](https://en.wikipedia.org/wiki/Romaji). See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/isRomaji/#kotlin.String#kotlin.text.Regex?/PointingToDeclaration/"></a>allowed| <a name="dev.esnault.wanakana/Wanakana/isRomaji/#kotlin.String#kotlin.text.Regex?/PointingToDeclaration/"></a><br><br>additional test allowed to pass for each char.<br><br><br><br>For example:<br><br><ul><li>isRomaji("Tōkyō and Ōsaka") => true</li><li>isRomaji("12a*b&c-d") => true</li><li>isRomaji("あアA") => false</li><li>isRomaji("お願い") => false</li><li>isRomaji("a！b&cーd") => false // Zenkaku punctuation fails</li><li>isRomaji("a！b&cーd", Regex("""[！ー]""")) => true</li></ul>
  
  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [isRomaji](is-romaji.md)(input: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input is Romaji (allowing Hepburn romanisation).



See [Romaji](https://en.wikipedia.org/wiki/Romaji). See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).



For example:

<ul><li>isRomaji('A') => true</li><li>isRomaji('ō') => true</li><li>isRomaji('あ') => false</li><li>isRomaji('ア') => false</li><li>isRomaji('願') => false</li></ul>  



