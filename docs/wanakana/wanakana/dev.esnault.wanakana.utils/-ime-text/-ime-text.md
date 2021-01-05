//[wanakana](../../index.md)/[dev.esnault.wanakana.utils](../index.md)/[ImeText](index.md)/[ImeText](-ime-text.md)



# ImeText  
[jvm]  
Content  
fun [ImeText](-ime-text.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  
More info  


Secondary constructor (meant for Java).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>text| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a><br><br>the typed text.<br><br>
| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>start| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a><br><br>the cursor/selection start, or -1 if there is no cursor/selection.<br><br>
| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>end| <a name="dev.esnault.wanakana.utils/ImeText/ImeText/#kotlin.String#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a><br><br>the cursor/selection end (inclusive), or -1 if there is no cursor/selection. If the end is equals to the start, it's a cursor, otherwise it's a selection.<br><br>
  
  


[jvm]  
Content  
fun [ImeText](-ime-text.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), selection: [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html))  



