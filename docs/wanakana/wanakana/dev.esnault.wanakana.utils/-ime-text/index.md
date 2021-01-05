//[wanakana](../../index.md)/[dev.esnault.wanakana.utils](../index.md)/[ImeText](index.md)



# ImeText  
 [jvm] data class [ImeText](index.md)(**text**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **selection**: [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html))

A typed text, with cursor information. This is used to preserve the cursor information when converting in IME mode.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>[ImeText](-ime-text.md)| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a> [jvm] fun [ImeText](-ime-text.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))Secondary constructor (meant for Java).   <br>
| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.ranges.IntRange/PointingToDeclaration/"></a>[ImeText](-ime-text.md)| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.ranges.IntRange/PointingToDeclaration/"></a> [jvm] fun [ImeText](-ime-text.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), selection: [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/ImeText/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="dev.esnault.wanakana.utils/ImeText/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana.utils/ImeText/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="dev.esnault.wanakana.utils/ImeText/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana.utils/ImeText/copy/#kotlin.String#kotlin.ranges.IntRange/PointingToDeclaration/"></a>[copy](copy.md)| <a name="dev.esnault.wanakana.utils/ImeText/copy/#kotlin.String#kotlin.ranges.IntRange/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), selection: [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)): [ImeText](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-mapping-builder/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../-mapping-builder/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/ImeText/selection/#/PointingToDeclaration/"></a>[selection](selection.md)| <a name="dev.esnault.wanakana.utils/ImeText/selection/#/PointingToDeclaration/"></a> [jvm] val [selection](selection.md): [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)the cursor/selection of the text.   <br>
| <a name="dev.esnault.wanakana.utils/ImeText/text/#/PointingToDeclaration/"></a>[text](text.md)| <a name="dev.esnault.wanakana.utils/ImeText/text/#/PointingToDeclaration/"></a> [jvm] val [text](text.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)the typed text.   <br>

