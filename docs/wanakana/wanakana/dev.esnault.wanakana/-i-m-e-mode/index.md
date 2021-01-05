//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[IMEMode](index.md)



# IMEMode  
 [jvm] enum [IMEMode](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[IMEMode](index.md)> 

A mode to handle conversion while the text is being typed. This means that the last characters of the input might not be converted if ambiguous to allow later conversion. For the mapping from romaji to kana, this also updates the mapping for "n".

   


## Entries  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/IMEMode.DISABLED///PointingToDeclaration/"></a>[DISABLED](-d-i-s-a-b-l-e-d/index.md)| <a name="dev.esnault.wanakana/IMEMode.DISABLED///PointingToDeclaration/"></a> [jvm] [DISABLED](-d-i-s-a-b-l-e-d/index.md)()  <br>Disabled, all the text will be converted if possible.   <br>
| <a name="dev.esnault.wanakana/IMEMode.ENABLED///PointingToDeclaration/"></a>[ENABLED](-e-n-a-b-l-e-d/index.md)| <a name="dev.esnault.wanakana/IMEMode.ENABLED///PointingToDeclaration/"></a> [jvm] [ENABLED](-e-n-a-b-l-e-d/index.md)()  <br>Enabled, the end of the text will not be converted if ambiguous, allowing it to be disambiguated later by new characters.   <br>
| <a name="dev.esnault.wanakana/IMEMode.TO_HIRAGANA///PointingToDeclaration/"></a>[TO_HIRAGANA](-t-o_-h-i-r-a-g-a-n-a/index.md)| <a name="dev.esnault.wanakana/IMEMode.TO_HIRAGANA///PointingToDeclaration/"></a> [jvm] [TO_HIRAGANA](-t-o_-h-i-r-a-g-a-n-a/index.md)()  <br>[ENABLED](-e-n-a-b-l-e-d/index.md), with the kana conversion always using hiragana.   <br>
| <a name="dev.esnault.wanakana/IMEMode.TO_KATAKANA///PointingToDeclaration/"></a>[TO_KATAKANA](-t-o_-k-a-t-a-k-a-n-a/index.md)| <a name="dev.esnault.wanakana/IMEMode.TO_KATAKANA///PointingToDeclaration/"></a> [jvm] [TO_KATAKANA](-t-o_-k-a-t-a-k-a-n-a/index.md)()  <br>[ENABLED](-e-n-a-b-l-e-d/index.md), with the kana conversion always using katakana.   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Enum/compareTo/#dev.esnault.wanakana.IMEMode/PointingToDeclaration/"></a>[compareTo](-t-o_-k-a-t-a-k-a-n-a/index.md#%5Bkotlin%2FEnum%2FcompareTo%2F%23dev.esnault.wanakana.IMEMode%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Enum/compareTo/#dev.esnault.wanakana.IMEMode/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator override fun [compareTo](-t-o_-k-a-t-a-k-a-n-a/index.md#%5Bkotlin%2FEnum%2FcompareTo%2F%23dev.esnault.wanakana.IMEMode%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(other: [IMEMode](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Enum/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Enum/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator override fun [equals](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Enum/finalize/#/PointingToDeclaration/"></a>[finalize](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2Ffinalize%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Enum/finalize/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [finalize](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2Ffinalize%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)()  <br><br><br>
| <a name="kotlin/Enum/getDeclaringClass/#/PointingToDeclaration/"></a>[getDeclaringClass](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2FgetDeclaringClass%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Enum/getDeclaringClass/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [getDeclaringClass](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2FgetDeclaringClass%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[IMEMode](index.md)>  <br><br><br>
| <a name="kotlin/Enum/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Enum/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>override fun [hashCode](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Enum/toString/#/PointingToDeclaration/"></a>[toString](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Enum/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../-token-type/-o-t-h-e-r/index.md#%5Bkotlin%2FEnum%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/IMEMode/name/#/PointingToDeclaration/"></a>[name](index.md#%5Bdev.esnault.wanakana%2FIMEMode%2Fname%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F382485239)| <a name="dev.esnault.wanakana/IMEMode/name/#/PointingToDeclaration/"></a> [jvm] val [name](index.md#%5Bdev.esnault.wanakana%2FIMEMode%2Fname%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F382485239): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>
| <a name="dev.esnault.wanakana/IMEMode/ordinal/#/PointingToDeclaration/"></a>[ordinal](index.md#%5Bdev.esnault.wanakana%2FIMEMode%2Fordinal%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F382485239)| <a name="dev.esnault.wanakana/IMEMode/ordinal/#/PointingToDeclaration/"></a> [jvm] val [ordinal](index.md#%5Bdev.esnault.wanakana%2FIMEMode%2Fordinal%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F382485239): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>

