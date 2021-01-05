//[wanakana](../index.md)/[dev.esnault.wanakana](index.md)



# Package dev.esnault.wanakana  


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Config///PointingToDeclaration/"></a>[Config](-config/index.md)| <a name="dev.esnault.wanakana/Config///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [Config](-config/index.md)(**useObsoleteKana**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **passRomaji**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **upcaseKatakana**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **imeMode**: [IMEMode](-i-m-e-mode/index.md))  <br>More info  <br>Configuration for Wanakana.  <br><br><br>
| <a name="dev.esnault.wanakana/ConfigBuilder///PointingToDeclaration/"></a>[ConfigBuilder](-config-builder/index.md)| <a name="dev.esnault.wanakana/ConfigBuilder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [ConfigBuilder](-config-builder/index.md)(**useObsoleteKana**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **passRomaji**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **upcaseKatakana**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), **imeMode**: [IMEMode](-i-m-e-mode/index.md))  <br>More info  <br>A builder to construct and update a [Config](-config/index.md).  <br><br><br>
| <a name="dev.esnault.wanakana/IMEMode///PointingToDeclaration/"></a>[IMEMode](-i-m-e-mode/index.md)| <a name="dev.esnault.wanakana/IMEMode///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>enum [IMEMode](-i-m-e-mode/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[IMEMode](-i-m-e-mode/index.md)>   <br>More info  <br>A mode to handle conversion while the text is being typed.  <br><br><br>
| <a name="dev.esnault.wanakana/TokenType///PointingToDeclaration/"></a>[TokenType](-token-type/index.md)| <a name="dev.esnault.wanakana/TokenType///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>enum [TokenType](-token-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[TokenType](-token-type/index.md)>   <br>More info  <br>Type of text token.  <br><br><br>
| <a name="dev.esnault.wanakana/TypedToken///PointingToDeclaration/"></a>[TypedToken](-typed-token/index.md)| <a name="dev.esnault.wanakana/TypedToken///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [TypedToken](-typed-token/index.md)(**value**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **type**: [TokenType](-token-type/index.md))  <br>More info  <br>A text token [value](-typed-token/value.md) with its associated [type](-typed-token/type.md).  <br><br><br>
| <a name="dev.esnault.wanakana/Wanakana///PointingToDeclaration/"></a>[Wanakana](-wanakana/index.md)| <a name="dev.esnault.wanakana/Wanakana///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Wanakana](-wanakana/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana//isKanji/#kotlin.Char/PointingToDeclaration/"></a>[isKanji](is-kanji.md)| <a name="dev.esnault.wanakana//isKanji/#kotlin.Char/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [isKanji](is-kanji.md)(input: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>

