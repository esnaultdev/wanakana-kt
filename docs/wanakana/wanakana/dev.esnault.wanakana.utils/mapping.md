//[wanakana](../index.md)/[dev.esnault.wanakana.utils](index.md)/[mapping](mapping.md)



# mapping  
[jvm]  
Content  
fun [mapping](mapping.md)(init: [MappingBuilder](-mapping-builder/index.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [MutableMappingTree](-mutable-mapping-tree/index.md)  
More info  


Returns a [MappingTree](-mapping-tree/index.md), built using a DSL. The syntax is similar to mapOf() using an infix to to add to the tree. Keys can be [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html) or [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), and values can be [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html) or [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) or a [mapping](mapping.md).



For example:

mapping {  
    'n' to 'ん'; "n'" to 'ん'  
}

is equivalent to

mapping {  
    'n' to "ん"; "n'" to "ん"  
}

and equivalent to

mapping {  
    'n' to mapping {  
        value = "ん"  
        "'" to "ん"  
    }  
}  



