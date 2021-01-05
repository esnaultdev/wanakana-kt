//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[toRomajiIme](to-romaji-ime.md)



# toRomajiIme  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [toRomajiIme](to-romaji-ime.md)(input: [ImeText](../../dev.esnault.wanakana.utils/-ime-text/index.md), imeMode: [IMEMode](../-i-m-e-mode/index.md) = IMEMode.ENABLED, upcaseKatakana: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [ImeText](../../dev.esnault.wanakana.utils/-ime-text/index.md)  
More info  


Converts kana to romaji (Hepburn romanisation), and preserves the cursor/selection.



See [Romaji](https://en.wikipedia.org/wiki/Romaji). See [Hepburn romanisation](https://en.wikipedia.org/wiki/Hepburn_romanization).



#### Return  


the converted text.



See [toRomaji](to-romaji.md) for more details.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>the kana text input.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>imeMode| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if enabled, handles conversion while the text is being typed, defaults to [IMEMode.ENABLED](../-i-m-e-mode/-e-n-a-b-l-e-d/index.md).<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a>upcaseKatakana| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.IMEMode#kotlin.Boolean/PointingToDeclaration/"></a><br><br>if true, katakana will be converted to uppercase, defaults to false.<br><br>
  
  


[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [toRomajiIme](to-romaji-ime.md)(input: [ImeText](../../dev.esnault.wanakana.utils/-ime-text/index.md), config: [Config](../-config/index.md) = Config.DEFAULT_IME): [ImeText](../../dev.esnault.wanakana.utils/-ime-text/index.md)  
More info  


Converts kana to romaji (Hepburn romanisation), and preserves the cursor/selection.



#### Return  


the converted text.



See [toRomaji](to-romaji.md) for more details.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>the kana text input.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.Config/PointingToDeclaration/"></a>config| <a name="dev.esnault.wanakana/Wanakana/toRomajiIme/#dev.esnault.wanakana.utils.ImeText#dev.esnault.wanakana.Config/PointingToDeclaration/"></a><br><br>optional configuration of the conversion. Defaults to [Config.DEFAULT_IME](../-config/-companion/-d-e-f-a-u-l-t_-i-m-e.md).<br><br>
  
  



