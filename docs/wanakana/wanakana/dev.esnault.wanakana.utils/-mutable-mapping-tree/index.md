//[wanakana](../../index.md)/[dev.esnault.wanakana.utils](../index.md)/[MutableMappingTree](index.md)



# MutableMappingTree  
 [jvm] abstract class [MutableMappingTree](index.md) : [MappingTree](../-mapping-tree/index.md)

A mutable [MappingTree](../-mapping-tree/index.md), used to build a [MappingTree](../-mapping-tree/index.md).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/MutableMappingTree/#/PointingToDeclaration/"></a>[MutableMappingTree](-mutable-mapping-tree.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/MutableMappingTree/#/PointingToDeclaration/"></a> [jvm] fun [MutableMappingTree](-mutable-mapping-tree.md)()   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MutableMappingTree.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree.Companion///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/duplicate/#/PointingToDeclaration/"></a>[duplicate](duplicate.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/duplicate/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [duplicate](duplicate.md)(): [MutableMappingTree](index.md)  <br>More info  <br>Returns a deep copy of this tree.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-mapping-builder/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../-mapping-builder/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/get/#kotlin.Char/PointingToDeclaration/"></a>[get](get.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/get/#kotlin.Char/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [get](get.md)(key: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)): [MutableMappingTree](index.md)?  <br>More info  <br>Returns the subTree referenced by key, if any.  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree/hasSubTree/#/PointingToDeclaration/"></a>[hasSubTree](../-mapping-tree/has-sub-tree.md)| <a name="dev.esnault.wanakana.utils/MappingTree/hasSubTree/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [hasSubTree](../-mapping-tree/has-sub-tree.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if this has any subTree.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree/mergeInto/#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[mergeInto](../-mapping-tree/merge-into.md)| <a name="dev.esnault.wanakana.utils/MappingTree/mergeInto/#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [mergeInto](../-mapping-tree/merge-into.md)(other: [MutableMappingTree](index.md))  <br>More info  <br>Merge this tree into the other.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree/mergeWith/#dev.esnault.wanakana.utils.MappingTree/PointingToDeclaration/"></a>[mergeWith](../-mapping-tree/merge-with.md)| <a name="dev.esnault.wanakana.utils/MappingTree/mergeWith/#dev.esnault.wanakana.utils.MappingTree/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [mergeWith](../-mapping-tree/merge-with.md)(other: [MappingTree](../-mapping-tree/index.md)): [MappingTree](../-mapping-tree/index.md)  <br>More info  <br>Returns a new [MappingTree](../-mapping-tree/index.md) that contains both mappings from this and the other tree.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/replaceSubTreeOf/#kotlin.String#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[replaceSubTreeOf](replace-sub-tree-of.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/replaceSubTreeOf/#kotlin.String#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [replaceSubTreeOf](replace-sub-tree-of.md)(str: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), newSubTree: [MutableMappingTree](index.md))  <br>More info  <br>Replace a subTree addressed by str with newSubTree.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/set/#kotlin.Char#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[set](set.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/set/#kotlin.Char#dev.esnault.wanakana.utils.MutableMappingTree/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [set](set.md)(key: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html), subTree: [MutableMappingTree](index.md))  <br>More info  <br>Replaces the subTree referenced by key with subTree.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/setSubTreeValue/#kotlin.String#kotlin.String/PointingToDeclaration/"></a>[setSubTreeValue](set-sub-tree-value.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/setSubTreeValue/#kotlin.String#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [setSubTreeValue](set-sub-tree-value.md)(str: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))  <br>More info  <br>Updates the subTree addressed by str to set its value to [value](value.md).  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/subTreeOf/#kotlin.String/PointingToDeclaration/"></a>[subTreeOf](sub-tree-of.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/subTreeOf/#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [subTreeOf](sub-tree-of.md)(str: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MutableMappingTree](index.md)  <br>More info  <br>Returns a subTree addressed by str.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/toMappingTree/#/PointingToDeclaration/"></a>[toMappingTree](to-mapping-tree.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/toMappingTree/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [toMappingTree](to-mapping-tree.md)(): [MappingTree](../-mapping-tree/index.md)  <br>More info  <br>Returns a read-only version of this tree.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree/toMutableMappingTree/#/PointingToDeclaration/"></a>[toMutableMappingTree](../-mapping-tree/to-mutable-mapping-tree.md)| <a name="dev.esnault.wanakana.utils/MappingTree/toMutableMappingTree/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [toMutableMappingTree](../-mapping-tree/to-mutable-mapping-tree.md)(): [MutableMappingTree](index.md)  <br>More info  <br>Returns a mutable version of this tree.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../-mapping-builder/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F382485239)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/update/#kotlin.Function1[dev.esnault.wanakana.utils.MappingBuilder,kotlin.Unit]/PointingToDeclaration/"></a>[update](update.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/update/#kotlin.Function1[dev.esnault.wanakana.utils.MappingBuilder,kotlin.Unit]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [update](update.md)(block: [MappingBuilder](../-mapping-builder/index.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))  <br>More info  <br>Updates the tree using a DSL.  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/subTrees/#/PointingToDeclaration/"></a>[subTrees](sub-trees.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/subTrees/#/PointingToDeclaration/"></a> [jvm] abstract override val [subTrees](sub-trees.md): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html), [MutableMappingTree](index.md)>The subTrees that can be used to continue the conversion.   <br>
| <a name="dev.esnault.wanakana.utils/MutableMappingTree/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree/value/#/PointingToDeclaration/"></a> [jvm] abstract override var [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?A value that can be used for conversion at this level of the tree.   <br>

