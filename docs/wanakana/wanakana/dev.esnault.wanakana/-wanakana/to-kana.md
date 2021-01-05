//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[toKana](to-kana.md)



# toKana  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [toKana](to-kana.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), imeMode: [IMEMode](../-i-m-e-mode/index.md) = IMEMode.DISABLED, useObsoleteKana: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  
More info  


Converts Romaji to Kana. Lowercase text will result in Hiragana and uppercase text will result in Katakana.



#### Return  


the converted text.



See [Romaji](https://en.wikipedia.org/wiki/Romaji). See [Kana](https://en.wikipedia.org/wiki/Kana). See [Hiragana](https://en.wikipedia.org/wiki/Hiragana). See [Katakana](https://en.wikipedia.org/wiki/Katakana).



For example:

<ul><li>toKana("onaji BUTTSUUJI") => "おなじ ブッツウジ"</li><li>toKana("ONAJI buttsuuji") => "オナジ ぶっつうじ"</li><li>toKana("座禅‘zazen’スタイル") => "座禅「ざぜん」スタイル"</li><li>toKana("batsuge-mu") => "ばつげーむ"</li><li>toKana("!?.:/,~-‘’“”[](){}") => "！？。：・、〜ー「」『』［］（）｛｝"</li></ul>

## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>the text to convert to Kana.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>imeMode| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if enabled, handles conversion while the text is being typed, defaults to [IMEMode.DISABLED](../-i-m-e-mode/-d-i-s-a-b-l-e-d/index.md).<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>useObsoleteKana| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if true obsolete kanas will be used (ゐゑヰヱ), defaults to false.<br><br>
  
  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [toKana](to-kana.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), config: [Config](../-config/index.md) = Config.DEFAULT): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  
More info  


Converts Romaji to Kana. Lowercase text will result in Hiragana and uppercase text will result in Katakana.



#### Return  


the converted text.



See [toKana](to-kana.md) for more details and examples.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>the text to convert to Kana.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>config| <a name="dev.esnault.wanakana/Wanakana/toKana/#kotlin.String#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>optional configuration of the conversion. Defaults to [Config.DEFAULT](../-config/-companion/-d-e-f-a-u-l-t.md).<br><br>
  
  



