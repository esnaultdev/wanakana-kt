//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[toKanaIme](to-kana-ime.md)



# toKanaIme  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [toKanaIme](to-kana-ime.md)(input: [ImeText](../../dev.esnault.wanakana.utils/-ime-text/index.md), imeMode: [IMEMode](../-i-m-e-mode/index.md) = IMEMode.ENABLED, useObsoleteKana: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [ImeText](../../dev.esnault.wanakana.utils/-ime-text/index.md)  
More info  


Converts Romaji to Kana and preserves the cursor/selection. Lowercase text will result in Hiragana and uppercase text will result in Katakana.



#### Return  


the converted text, with cursor/selection.



See [toKana](to-kana.md) for more details and examples.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>the text to convert to Kana, with cursor/selection.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>imeMode| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if enabled, handles conversion while the text is being typed, defaults to [IMEMode.ENABLED](../-i-m-e-mode/-e-n-a-b-l-e-d/index.md).<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>useObsoleteKana| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if true obsolete kanas will be used (ゐゑヰヱ), defaults to false.<br><br>
  
  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [toKanaIme](to-kana-ime.md)(input: [ImeText](../../dev.esnault.wanakana.utils/-ime-text/index.md), config: [Config](../-config/index.md) = Config.DEFAULT_IME): [ImeText](../../dev.esnault.wanakana.utils/-ime-text/index.md)  
More info  


Converts Romaji to Kana and preserves the cursor/selection. Lowercase text will result in Hiragana and uppercase text will result in Katakana.



#### Return  


the converted text, with cursor/selection.



See [toKana](to-kana.md) for more details and examples.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>the text to convert to Kana, with cursor/selection.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>config| <a name="dev.esnault.wanakana/Wanakana/toKanaIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>optional configuration of the conversion. Defaults to [Config.DEFAULT_IME](../-config/-companion/-d-e-f-a-u-l-t_-i-m-e.md).<br><br>
  
  



