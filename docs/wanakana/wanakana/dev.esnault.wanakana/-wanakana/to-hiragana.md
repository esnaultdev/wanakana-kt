//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[toHiragana](to-hiragana.md)



# toHiragana  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [toHiragana](to-hiragana.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), imeMode: [IMEMode](../-i-m-e-mode/index.md) = IMEMode.DISABLED, passRomaji: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, useObsoleteKana: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  
More info  


Converts input to [Hiragana](https://en.wikipedia.org/wiki/Hiragana).



#### Return  


the converted text.



For example:

<ul><li>toHiragana("toukyou, オオサカ") // => "とうきょう、　おおさか"`</li><li>toHiragana("only カナ", passRomaji = true) => "only かな"</li><li>toHiragana("wi") => "うぃ"</li><li>toHiragana("wi", useObsoleteKana = true) => "ゐ"</li></ul>

## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a><br><br>the text to convert.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a>imeMode| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if enabled, handles conversion while the text is being typed, defaults to [IMEMode.DISABLED](../-i-m-e-mode/-d-i-s-a-b-l-e-d/index.md).<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a>passRomaji| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if true romaji will be kept as-is, defaults to false.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a>useObsoleteKana| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if true obsolete kanas will be used (ゐ and ゑ), defaults to false.<br><br>
  
  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [toHiragana](to-hiragana.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), config: [Config](../-config/index.md) = Config.DEFAULT): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  
More info  


Converts input to [Hiragana](https://en.wikipedia.org/wiki/Hiragana).



#### Return  


the converted text.



See [toHiragana](to-hiragana.md) for more details.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>the text input.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>config| <a name="dev.esnault.wanakana/Wanakana/toHiragana/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>optional configuration of the conversion. Defaults to [Config.DEFAULT](../-config/-companion/-d-e-f-a-u-l-t.md).<br><br>
  
  



