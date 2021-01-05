//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[Wanakana](index.md)/[stripOkurigana](strip-okurigana.md)



# stripOkurigana  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [stripOkurigana](strip-okurigana.md)(input: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), leading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, matchKanji: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  
More info  


Strips [Okurigana](https://en.wikipedia.org/wiki/Okurigana).



#### Return  


the text with okurigana removed.



For example:

<ul><li>stripOkurigana("踏み込む") => "踏み込"</li><li>stripOkurigana("お祝い") => "お祝"</li><li>stripOkurigana("お腹", leading = true) => "腹"</li><li>stripOkurigana("ふみこむ", matchKanji = "踏み込む") => "ふみこ"</li><li>stripOkurigana("おみまい", matchKanji = "お祝い", leading = true) => "みまい"</li></ul>

## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="dev.esnault.wanakana/Wanakana/stripOkurigana/#kotlin.String#kotlin.Boolean#kotlin.String?/PointingToDeclaration/"></a>input| <a name="dev.esnault.wanakana/Wanakana/stripOkurigana/#kotlin.String#kotlin.Boolean#kotlin.String?/PointingToDeclaration/"></a><br><br>the input text.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/stripOkurigana/#kotlin.String#kotlin.Boolean#kotlin.String?/PointingToDeclaration/"></a>leading| <a name="dev.esnault.wanakana/Wanakana/stripOkurigana/#kotlin.String#kotlin.Boolean#kotlin.String?/PointingToDeclaration/"></a><br><br>if true, strips leading okurigana instead of trailing okurigana, defaults to false.<br><br>
| <a name="dev.esnault.wanakana/Wanakana/stripOkurigana/#kotlin.String#kotlin.Boolean#kotlin.String?/PointingToDeclaration/"></a>matchKanji| <a name="dev.esnault.wanakana/Wanakana/stripOkurigana/#kotlin.String#kotlin.Boolean#kotlin.String?/PointingToDeclaration/"></a><br><br>optional kanji representation of the text, to help strip okurigana from a kana input.<br><br>
  
  



