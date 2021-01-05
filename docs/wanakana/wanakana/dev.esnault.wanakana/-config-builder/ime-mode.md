//[wanakana](../../index.md)/[dev.esnault.wanakana](../index.md)/[ConfigBuilder](index.md)/[imeMode](ime-mode.md)



# imeMode  
[jvm]  
Content  
fun [imeMode](ime-mode.md)(imeMode: [IMEMode](../-i-m-e-mode/index.md)): [ConfigBuilder](index.md)  
More info  


Sets the [imeMode](ime-mode.md). If not [IMEMode.DISABLED](../-i-m-e-mode/-d-i-s-a-b-l-e-d/index.md), allows the conversion to be performed while typed. This means that the last characters of the input might not be converted if ambiguous to allow later conversion. Applies to toRomaji, toKana, toHiragana and toKatakana. Defaults to [IMEMode.DISABLED](../-i-m-e-mode/-d-i-s-a-b-l-e-d/index.md).

  


[jvm]  
Content  
var [imeMode](ime-mode.md): [IMEMode](../-i-m-e-mode/index.md)  



