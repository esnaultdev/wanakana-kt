//[wanakana](../../index.md)/[dev.esnault.wanakana.utils](../index.md)/[MappingBuilder](index.md)/[merge](merge.md)



# merge  
[jvm]  
Content  
infix fun [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html).[merge](merge.md)(subTree: [MutableMappingTree](../-mutable-mapping-tree/index.md)): [MappingBuilder](index.md)  
More info  


Adds a mapping for this char to subTree. This will create subTrees as needed. If another mapping exists for the last tree level, it will be merged with it. The value of subTree will have precedence over any existing mapping. Use [to](to.md) instead if you want to replace any existing mapping at this level.

  


[jvm]  
Content  
infix fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[merge](merge.md)(subTree: [MutableMappingTree](../-mutable-mapping-tree/index.md)): [MappingBuilder](index.md)  
More info  


Adds a mapping for this char to subTree. This will create subTrees as needed. If another mapping exists for the last tree level, it will be merged with it. The value of subTree will have precedence over any existing mapping. Use [to](to.md) instead if you want to replace any existing mapping at this level.



#### Throws  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingBuilder/merge/kotlin.String#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html)| <a name="dev.esnault.wanakana.utils/MappingBuilder/merge/kotlin.String#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a><br><br>if this string is empty.<br><br>
  



