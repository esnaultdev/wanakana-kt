//[wanakana](../../index.md)/[dev.esnault.wanakana.utils](../index.md)/[MappingBuilder](index.md)



# MappingBuilder  
 [jvm] class [MappingBuilder](index.md)(**tree**: [MutableMappingTree](../-mutable-mapping-tree/index.md))

A builder of [MutableMappingTree](../-mutable-mapping-tree/index.md). For Kotlin users, this class should be transparent if used from the [mapping](../mapping.md) DSL. For Java users, you can use this class directly to build a [MutableMappingTree](../-mutable-mapping-tree/index.md).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingBuilder/MappingBuilder/#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[MappingBuilder](-mapping-builder.md)| <a name="dev.esnault.wanakana.utils/MappingBuilder/MappingBuilder/#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a> [jvm] fun [MappingBuilder](-mapping-builder.md)(tree: [MutableMappingTree](../-mutable-mapping-tree/index.md) = mutableMappingTreeOf())   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingBuilder/build/#/PointingToDeclaration/"></a>[build](build.md)| <a name="dev.esnault.wanakana.utils/MappingBuilder/build/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [build](build.md)(): [MutableMappingTree](../-mutable-mapping-tree/index.md)  <br>More info  <br>Builds the [MutableMappingTree](../-mutable-mapping-tree/index.md) from this builder.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingBuilder/merge/kotlin.Char#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[merge](merge.md)| <a name="dev.esnault.wanakana.utils/MappingBuilder/merge/kotlin.Char#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>infix fun [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html).[merge](merge.md)(subTree: [MutableMappingTree](../-mutable-mapping-tree/index.md)): [MappingBuilder](index.md)  <br>infix fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[merge](merge.md)(subTree: [MutableMappingTree](../-mutable-mapping-tree/index.md)): [MappingBuilder](index.md)  <br>More info  <br>Adds a mapping for this char to subTree.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingBuilder/to/TypeParam(bounds=[kotlin.Any?])#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[to](to.md)| <a name="dev.esnault.wanakana.utils/MappingBuilder/to/TypeParam(bounds=[kotlin.Any?])#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>infix inline fun <[A](to.md), [B](to.md)> [A](to.md).[to](to.md)(value: [B](to.md))  <br><br><br>[jvm]  <br>Content  <br>infix fun [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html).[to](to.md)(subTree: [MutableMappingTree](../-mutable-mapping-tree/index.md)): [MappingBuilder](index.md)  <br>More info  <br>Adds a mapping for this char to subTree.  <br><br><br>[jvm]  <br>Content  <br>infix fun [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html).[to](to.md)(value: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [MappingBuilder](index.md)  <br>infix fun [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html).[to](to.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MappingBuilder](index.md)  <br>More info  <br>Adds a mapping for this char to [value](value.md).  <br><br><br>[jvm]  <br>Content  <br>infix fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[to](to.md)(subTree: [MutableMappingTree](../-mutable-mapping-tree/index.md)): [MappingBuilder](index.md)  <br>More info  <br>Adds a mapping for this string to subTree.  <br><br><br>[jvm]  <br>Content  <br>infix fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[to](to.md)(value: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [MappingBuilder](index.md)  <br>infix fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[to](to.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MappingBuilder](index.md)  <br>More info  <br>Adds a mapping for this string to [value](value.md).  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingBuilder/value/#kotlin.String?/PointingToDeclaration/"></a>[value](value.md)| <a name="dev.esnault.wanakana.utils/MappingBuilder/value/#kotlin.String?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [value](value.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [MappingBuilder](index.md)  <br>More info  <br>Sets the value that can be used for conversion at this level of the tree.  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingBuilder/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="dev.esnault.wanakana.utils/MappingBuilder/value/#/PointingToDeclaration/"></a> [jvm] var [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?The value that can be used for conversion at this level of the tree.   <br>

