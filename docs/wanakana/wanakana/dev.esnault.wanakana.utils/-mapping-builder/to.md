//[wanakana](../../index.md)/[dev.esnault.wanakana.utils](../index.md)/[MappingBuilder](index.md)/[to](to.md)



# to  
[jvm]  
Content  
infix fun [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html).[to](to.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MappingBuilder](index.md)  
infix fun [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html).[to](to.md)(value: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [MappingBuilder](index.md)  
More info  


Adds a mapping for this char to [value](value.md).

  


[jvm]  
Content  
infix fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[to](to.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MappingBuilder](index.md)  
More info  


Adds a mapping for this string to [value](value.md). This will create subTrees as needed.



#### Throws  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingBuilder/to/kotlin.String#kotlin.String/PointingToDeclaration/"></a>[kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html)| <a name="dev.esnault.wanakana.utils/MappingBuilder/to/kotlin.String#kotlin.String/PointingToDeclaration/"></a><br><br>if this string is empty.<br><br>
  


[jvm]  
Content  
infix fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[to](to.md)(value: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [MappingBuilder](index.md)  
More info  


Adds a mapping for this string to [value](value.md). This will create subTrees as needed.



#### Throws  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingBuilder/to/kotlin.String#kotlin.Char/PointingToDeclaration/"></a>[kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html)| <a name="dev.esnault.wanakana.utils/MappingBuilder/to/kotlin.String#kotlin.Char/PointingToDeclaration/"></a><br><br>if this string is empty.<br><br>
  


[jvm]  
Content  
infix fun [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html).[to](to.md)(subTree: [MutableMappingTree](../-mutable-mapping-tree/index.md)): [MappingBuilder](index.md)  
More info  


Adds a mapping for this char to subTree. This will create subTrees as needed. Any existing tree at the last tree level will be replaced. Use [merge](merge.md) instead if you want to preserve any existing mapping at this level.

  


[jvm]  
Content  
infix fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[to](to.md)(subTree: [MutableMappingTree](../-mutable-mapping-tree/index.md)): [MappingBuilder](index.md)  
More info  


Adds a mapping for this string to subTree. This will create subTrees as needed. Any existing tree at the last tree level will be replaced. Use [merge](merge.md) instead if you want to preserve any existing mapping at this level.



#### Throws  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingBuilder/to/kotlin.String#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html)| <a name="dev.esnault.wanakana.utils/MappingBuilder/to/kotlin.String#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a><br><br>if this string is empty.<br><br>
  


[jvm]  
Content  
infix inline fun <[A](to.md), [B](to.md)> [A](to.md).[to](to.md)(value: [B](to.md))  



