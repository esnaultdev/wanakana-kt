//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[toRomaji](to-romaji.md)



# toRomaji  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [toRomaji](to-romaji.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), imeMode: [IMEMode](../-i-m-e-mode/index.md) = IMEMode.DISABLED, upcaseKatakana: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  
More info  


Converts kana to romaji (Hepburn romanisation).



See [Romaji](https://en.wikipedia.org/wiki/Romaji). See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).



#### Return  


the converted text.



For example:

<ul><li>toRomaji("ひらがな　カタカナ") => "hiragana katakana"</li><li>toRomaji("げーむ　ゲーム") => "ge-mu geemu"</li><li>toRomaji("ひらがな　カタカナ", upcaseKatakana = true) => "hiragana KATAKANA"</li></ul>

## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>the kana text input.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>imeMode| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if enabled, handles conversion while the text is being typed, defaults to [IMEMode.DISABLED](../-i-m-e-mode/-d-i-s-a-b-l-e-d/index.md).<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>upcaseKatakana| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if true, katakana will be converted to uppercase, defaults to false.<br><br>
  
  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [toRomaji](to-romaji.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), config: [Config](../-config/index.md) = Config.DEFAULT): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  
More info  


Converts kana to romaji (Hepburn romanisation).



#### Return  


the converted text.



See [toRomaji](to-romaji.md) for more details.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>the kana text input.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>config| <a name="dev.esnault.wanakana/Wanakana/toRomaji/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>optional configuration of the conversion. Defaults to [Config.DEFAULT](../-config/-companion/-d-e-f-a-u-l-t.md).<br><br>
  
  



