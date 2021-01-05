//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[isMixed](is-mixed.md)



# isMixed  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [isMixed](is-mixed.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), passKanji: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if input contains a mix of Romaji and Kana.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/isMixed/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a>passKanji| <a name="dev.esnault.wanakana/Wanakana/isMixed/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if true, ignore kanji, defaults to true. Otherwise this check will fail if any character is a Kanji.<br><br><br><br>See [Romaji](https://en.wikipedia.org/wiki/Romaji) See [Kana](https://en.wikipedia.org/wiki/Kana) See [Kanji](https://en.wikipedia.org/wiki/Kanji)<br><br><br><br>For example:<br><br><ul><li>isMixed("Abあア")) => true</li><li>isMixed("お腹A")) => true // ignores kanji by default</li><li>isMixed("お腹A", passKanji = false) => false</li><li>isMixed("ab")) => false</li><li>isMixed("あア")) => false</li></ul>
  
  



