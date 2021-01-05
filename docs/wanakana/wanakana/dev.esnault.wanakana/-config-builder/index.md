//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[ConfigBuilder](index.md)



# ConfigBuilder  
 [jvm] class [ConfigBuilder](index.md)(**useObsoleteKana**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **passRomaji**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **upcaseKatakana**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **imeMode**: [IMEMode](../-i-m-e-mode/index.md))

A builder to construct and update a [Config](../-config/index.md). This is meant to be used from Java, as Kotlin can use [Config.copy](../-config/copy.md) and named parameters to build a [Config](../-config/index.md) object.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/ConfigBuilder/ConfigBuilder/#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean#dev.esnault.wanakana.IMEMode/PointingToDeclaration/"></a>[ConfigBuilder](-config-builder.md)| <a name="dev.esnault.wanakana/ConfigBuilder/ConfigBuilder/#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean#dev.esnault.wanakana.IMEMode/PointingToDeclaration/"></a> [jvm] fun [ConfigBuilder](-config-builder.md)(useObsoleteKana: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, passRomaji: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, upcaseKatakana: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, imeMode: [IMEMode](../-i-m-e-mode/index.md) = IMEMode.DISABLED)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/ConfigBuilder/build/#/PointingToDeclaration/"></a>[build](build.md)| <a name="dev.esnault.wanakana/ConfigBuilder/build/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [build](build.md)(): [Config](../-config/index.md)  <br>More info  <br>Builds a [Config](../-config/index.md) from this builder.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../dev.esnault.wanakana.utils/-mapping-builder/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../dev.esnault.wanakana.utils/-mapping-builder/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../dev.esnault.wanakana.utils/-mapping-builder/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../dev.esnault.wanakana.utils/-mapping-builder/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana/ConfigBuilder/imeMode/#dev.esnault.wanakana.IMEMode/PointingToDeclaration/"></a>[imeMode](ime-mode.md)| <a name="dev.esnault.wanakana/ConfigBuilder/imeMode/#dev.esnault.wanakana.IMEMode/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [imeMode](ime-mode.md)(imeMode: [IMEMode](../-i-m-e-mode/index.md)): [ConfigBuilder](index.md)  <br>More info  <br>Sets the [imeMode](ime-mode.md).  <br><br><br>
| <a name="dev.esnault.wanakana/ConfigBuilder/passRomaji/#kotlin.Boolean/PointingToDeclaration/"></a>[passRomaji](pass-romaji.md)| <a name="dev.esnault.wanakana/ConfigBuilder/passRomaji/#kotlin.Boolean/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [passRomaji](pass-romaji.md)(passRomaji: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [ConfigBuilder](index.md)  <br>More info  <br>Sets [passRomaji](pass-romaji.md).  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../dev.esnault.wanakana.utils/-mapping-builder/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../dev.esnault.wanakana.utils/-mapping-builder/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana/ConfigBuilder/upcaseKatakana/#kotlin.Boolean/PointingToDeclaration/"></a>[upcaseKatakana](upcase-katakana.md)| <a name="dev.esnault.wanakana/ConfigBuilder/upcaseKatakana/#kotlin.Boolean/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [upcaseKatakana](upcase-katakana.md)(upcaseKatakana: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [ConfigBuilder](index.md)  <br>More info  <br>Sets [upcaseKatakana](upcase-katakana.md).  <br><br><br>
| <a name="dev.esnault.wanakana/ConfigBuilder/useObsoleteKana/#kotlin.Boolean/PointingToDeclaration/"></a>[useObsoleteKana](use-obsolete-kana.md)| <a name="dev.esnault.wanakana/ConfigBuilder/useObsoleteKana/#kotlin.Boolean/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [useObsoleteKana](use-obsolete-kana.md)(useObsoleteKana: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [ConfigBuilder](index.md)  <br>More info  <br>Sets [useObsoleteKana](use-obsolete-kana.md).  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/ConfigBuilder/imeMode/#/PointingToDeclaration/"></a>[imeMode](ime-mode.md)| <a name="dev.esnault.wanakana/ConfigBuilder/imeMode/#/PointingToDeclaration/"></a> [jvm] var [imeMode](ime-mode.md): [IMEMode](../-i-m-e-mode/index.md)   <br>
| <a name="dev.esnault.wanakana/ConfigBuilder/passRomaji/#/PointingToDeclaration/"></a>[passRomaji](pass-romaji.md)| <a name="dev.esnault.wanakana/ConfigBuilder/passRomaji/#/PointingToDeclaration/"></a> [jvm] var [passRomaji](pass-romaji.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| <a name="dev.esnault.wanakana/ConfigBuilder/upcaseKatakana/#/PointingToDeclaration/"></a>[upcaseKatakana](upcase-katakana.md)| <a name="dev.esnault.wanakana/ConfigBuilder/upcaseKatakana/#/PointingToDeclaration/"></a> [jvm] var [upcaseKatakana](upcase-katakana.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| <a name="dev.esnault.wanakana/ConfigBuilder/useObsoleteKana/#/PointingToDeclaration/"></a>[useObsoleteKana](use-obsolete-kana.md)| <a name="dev.esnault.wanakana/ConfigBuilder/useObsoleteKana/#/PointingToDeclaration/"></a> [jvm] var [useObsoleteKana](use-obsolete-kana.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>

