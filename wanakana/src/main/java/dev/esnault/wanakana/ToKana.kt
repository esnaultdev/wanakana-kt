package dev.esnault.wanakana

import dev.esnault.wanakana.utils.ConversionToken
import dev.esnault.wanakana.utils.MappingTree
import dev.esnault.wanakana.utils.applyMapping
import dev.esnault.wanakana.utils.hiraganaToKatakana
import dev.esnault.wanakana.utils.isEnglishUpperCase
import dev.esnault.wanakana.utils.romajiToKanaMap
import dev.esnault.wanakana.utils.safeLowerCase

/**
 * Converts Romaji to Kana.
 * Lowercase text will result in Hiragana and uppercase text will result in Katakana.
 *
 * @param input the text to convert to Kana.
 * @return the converted text.
 *
 * See [Romaji](https://en.wikipedia.org/wiki/Romaji).
 * See [Kana](https://en.wikipedia.org/wiki/Kana).
 * See [Hiragana](https://en.wikipedia.org/wiki/Hiragana).
 * See [Katakana](https://en.wikipedia.org/wiki/Katakana).
 *
 * For example:
 * - `toKana("onaji BUTTSUUJI")` => `"おなじ ブッツウジ"`
 * - `toKana("ONAJI buttsuuji")` => `"オナジ ぶっつうじ"`
 * - `toKana("座禅‘zazen’スタイル")` => `"座禅「ざぜん」スタイル"`
 * - `toKana("batsuge-mu")` => `"ばつげーむ"`
 * - `toKana("!?.:/,~-‘’“”[](){}")` => `"！？。：・、〜ー「」『』［］（）｛｝"`
 */
fun toKana(
    input: String,
    imeMode: IMEMode = IMEMode.DISABLED,
    useObsoleteKana: Boolean = false
): String {
    // TODO introduce useObsoleteKana to other methods
    // TODO introduce imeMode to other methods
    val map = romajiToKanaMap

    val enforceHiragana = imeMode == IMEMode.TO_HIRAGANA
    val enforceKatakanaMode = imeMode == IMEMode.TO_KATAKANA

    // throw away the substring index information and just concatenate all the kana
    return splitIntoConvertedKana(input, map)
        .joinToString(separator = "") { token ->
            val kana = token.value
            if (kana == null) {
                // haven't converted the end of the string, since we are in IME mode
                return@joinToString input.slice(token.range)
            }

            val enforceKatakana = enforceKatakanaMode
                    || input.slice(token.range).all { it.isEnglishUpperCase() }
            if (enforceHiragana || !enforceKatakana) kana else hiraganaToKatakana(kana)
        }
}

/*
TODO: JS to convert

/**
 *
 * @private
 * @param {String} [input=''] input text
 * @param {Object} [options={}] toKana options
 * @returns {Array[]} [[start, end, token]]
 * @example
 * splitIntoConvertedKana('buttsuuji')
 * // => [[0, 2, 'ぶ'], [2, 6, 'っつ'], [6, 7, 'う'], [7, 9, 'じ']]
 */
export function splitIntoConvertedKana(input = '', options = {}, map) {
  if (!map) {
    map = createRomajiToKanaMap(options);
  }
  return applyMapping(input.toLowerCase(), map, !options.IMEMode);
}
*/

private fun splitIntoConvertedKana(input: String, map: MappingTree): List<ConversionToken> {
    // TODO add an IMEMode
    return applyMapping(input.safeLowerCase(), map, true)
}

/*
TODO: JS to convert

let customMapping = null;
export function createRomajiToKanaMap(options = {}) {
  let map = getRomajiToKanaTree();

  map = options.IMEMode ? IME_MODE_MAP(map) : map;
  map = options.useObsoleteKana ? USE_OBSOLETE_KANA_MAP(map) : map;

  if (options.customKanaMapping) {
    if (customMapping == null) {
      customMapping = mergeCustomMapping(map, options.customKanaMapping);
    }
    map = customMapping;
  }

  return map;
}
*/
