//[wanakana](../index.md)/[dev.esnault.wanakana.utils](index.md)



# Package dev.esnault.wanakana.utils  


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils/ImeText///PointingToDeclaration/"></a>[ImeText](-ime-text/index.md)| <a name="dev.esnault.wanakana.utils/ImeText///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [ImeText](-ime-text/index.md)(**text**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **selection**: [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html))  <br>More info  <br>A typed text, with cursor information.  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingBuilder///PointingToDeclaration/"></a>[MappingBuilder](-mapping-builder/index.md)| <a name="dev.esnault.wanakana.utils/MappingBuilder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [MappingBuilder](-mapping-builder/index.md)(**tree**: [MutableMappingTree](-mutable-mapping-tree/index.md))  <br>More info  <br>A builder of [MutableMappingTree](-mutable-mapping-tree/index.md).  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MappingTree///PointingToDeclaration/"></a>[MappingTree](-mapping-tree/index.md)| <a name="dev.esnault.wanakana.utils/MappingTree///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract class [MappingTree](-mapping-tree/index.md)  <br>More info  <br>A mapping tree used to map a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) to another [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).  <br><br><br>
| <a name="dev.esnault.wanakana.utils/MutableMappingTree///PointingToDeclaration/"></a>[MutableMappingTree](-mutable-mapping-tree/index.md)| <a name="dev.esnault.wanakana.utils/MutableMappingTree///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract class [MutableMappingTree](-mutable-mapping-tree/index.md) : [MappingTree](-mapping-tree/index.md)  <br>More info  <br>A mutable [MappingTree](-mapping-tree/index.md), used to build a [MappingTree](-mapping-tree/index.md).  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana.utils//mapping/#kotlin.Function1[dev.esnault.wanakana.utils.MappingBuilder,kotlin.Unit]/PointingToDeclaration/"></a>[mapping](mapping.md)| <a name="dev.esnault.wanakana.utils//mapping/#kotlin.Function1[dev.esnault.wanakana.utils.MappingBuilder,kotlin.Unit]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [mapping](mapping.md)(init: [MappingBuilder](-mapping-builder/index.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [MutableMappingTree](-mutable-mapping-tree/index.md)  <br>More info  <br>Returns a [MappingTree](-mapping-tree/index.md), built using a DSL.  <br><br><br>
| <a name="dev.esnault.wanakana.utils//mappingTreeOf/#kotlin.String?#kotlin.collections.Map[kotlin.Char,dev.esnault.wanakana.utils.MappingTree]?/PointingToDeclaration/"></a>[mappingTreeOf](mapping-tree-of.md)| <a name="dev.esnault.wanakana.utils//mappingTreeOf/#kotlin.String?#kotlin.collections.Map[kotlin.Char,dev.esnault.wanakana.utils.MappingTree]?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [mappingTreeOf](mapping-tree-of.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, subTrees: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html), [MappingTree](-mapping-tree/index.md)>? = null): [MappingTree](-mapping-tree/index.md)  <br>More info  <br>Returns a read-only [MappingTree](-mapping-tree/index.md) with the given value and subTrees.  <br><br><br>
| <a name="dev.esnault.wanakana.utils//mutableMappingTreeOf/#kotlin.String?#kotlin.collections.Map[kotlin.Char,dev.esnault.wanakana.utils.MutableMappingTree]?/PointingToDeclaration/"></a>[mutableMappingTreeOf](mutable-mapping-tree-of.md)| <a name="dev.esnault.wanakana.utils//mutableMappingTreeOf/#kotlin.String?#kotlin.collections.Map[kotlin.Char,dev.esnault.wanakana.utils.MutableMappingTree]?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [mutableMappingTreeOf](mutable-mapping-tree-of.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, subTrees: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html), [MutableMappingTree](-mutable-mapping-tree/index.md)>? = null): [MutableMappingTree](-mutable-mapping-tree/index.md)  <br>More info  <br>Returns a [MutableMappingTree](-mutable-mapping-tree/index.md) with the given value and subTrees.  <br><br><br>

