//[wanakana](../../index.md)/[dev.esnault.wanakana.utils](../index.md)/[MappingTree](index.md)



# MappingTree  
 [jvm] abstract class [MappingTree](index.md)

A mapping tree used to map a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) to another [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingTree/MappingTree/#/PointingToDeclaration/"></a>[MappingTree](-mapping-tree.md)| <a name="dev.esnault.wanakana.utils/MappingTree/MappingTree/#/PointingToDeclaration/"></a> [jvm] fun [MappingTree](-mapping-tree.md)()   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingTree.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="dev.esnault.wanakana.utils/MappingTree.Companion///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingTree/duplicate/#/PointingToDeclaration/"></a>[duplicate](duplicate.md)| <a name="dev.esnault.wanakana.utils/MappingTree/duplicate/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [duplicate](duplicate.md)(): [MappingTree](index.md)  <br>More info  <br>Returns a deep copy of this tree.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-mapping-builder/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../-mapping-builder/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree/get/#kotlin.Char/PointingToDeclaration/"></a>[get](get.md)| <a name="dev.esnault.wanakana.utils/MappingTree/get/#kotlin.Char/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [get](get.md)(key: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [MappingTree](index.md)?  <br>More info  <br>Returns the subTree referenced by key, if any.  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree/hasSubTree/#/PointingToDeclaration/"></a>[hasSubTree](has-sub-tree.md)| <a name="dev.esnault.wanakana.utils/MappingTree/hasSubTree/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [hasSubTree](has-sub-tree.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if this has any subTree.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree/mergeInto/#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[mergeInto](merge-into.md)| <a name="dev.esnault.wanakana.utils/MappingTree/mergeInto/#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [mergeInto](merge-into.md)(other: [MutableMappingTree](../-mutable-mapping-tree/index.md))  <br>More info  <br>Merge this tree into the other.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree/mergeWith/#dev.esnault.wanakana.utils.MappingTree/PointingToDeclaration/"></a>[mergeWith](merge-with.md)| <a name="dev.esnault.wanakana.utils/MappingTree/mergeWith/#dev.esnault.wanakana.utils.MappingTree/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [mergeWith](merge-with.md)(other: [MappingTree](index.md)): [MappingTree](index.md)  <br>More info  <br>Returns a new [MappingTree](index.md) that contains both mappings from this and the other tree.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree/toMutableMappingTree/#/PointingToDeclaration/"></a>[toMutableMappingTree](to-mutable-mapping-tree.md)| <a name="dev.esnault.wanakana.utils/MappingTree/toMutableMappingTree/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [toMutableMappingTree](to-mutable-mapping-tree.md)(): [MutableMappingTree](../-mutable-mapping-tree/index.md)  <br>More info  <br>Returns a mutable version of this tree.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MappingTree/subTrees/#/PointingToDeclaration/"></a>[subTrees](sub-trees.md)| <a name="dev.esnault.wanakana.utils/MappingTree/subTrees/#/PointingToDeclaration/"></a> [jvm] abstract val [subTrees](sub-trees.md): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html), [MappingTree](index.md)>?The subTrees that can be used to continue the conversion.   <br>
| <a name="dev.esnault.wanakana.utils/MappingTree/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="dev.esnault.wanakana.utils/MappingTree/value/#/PointingToDeclaration/"></a> [jvm] abstract val [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?A value that can be used for conversion at this level of the tree.   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="dev.esnault.wanakana.utils/MutableMappingTree///PointingToDeclaration/"></a>[MutableMappingTree](../-mutable-mapping-tree/index.md)

