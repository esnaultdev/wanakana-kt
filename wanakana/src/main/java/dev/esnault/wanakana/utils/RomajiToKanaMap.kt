package dev.esnault.wanakana.utils

/**
 * Lookup table from romaji to hiragana using the Kunrei-shiki romanization.
 *
 * See [Kunrei-shiki romanization](https://en.wikipedia.org/wiki/Kunrei-shiki_romanization).
 * NOTE: not exactly kunrei shiki, for example ぢゃ -> dya instead of zya, to avoid name clashing.
 */
private val BASIC_KUNREI_TREE = mapping {
    'a' to "あ"; 'i' to "い"; 'u' to "う"; 'e' to "え"; 'o' to "お"
    'k' to mapping { 'a' to "か"; 'i' to "き"; 'u' to "く"; 'e' to "け"; 'o' to "こ" }
    's' to mapping { 'a' to "さ"; 'i' to "し"; 'u' to "す"; 'e' to "せ"; 'o' to "そ" }
    't' to mapping { 'a' to "た"; 'i' to "ち"; 'u' to "つ"; 'e' to "て"; 'o' to "と" }
    'n' to mapping { 'a' to "な"; 'i' to "に"; 'u' to "ぬ"; 'e' to "ね"; 'o' to "の" }
    'h' to mapping { 'a' to "は"; 'i' to "ひ"; 'u' to "ふ"; 'e' to "へ"; 'o' to "ほ" }
    'm' to mapping { 'a' to "ま"; 'i' to "み"; 'u' to "む"; 'e' to "め"; 'o' to "も" }
    'y' to mapping { 'a' to "や"; 'u' to "ゆ"; 'o' to "よ" }
    'r' to mapping { 'a' to "ら"; 'i' to "り"; 'u' to "る"; 'e' to "れ"; 'o' to "ろ" }
    'w' to mapping { 'a' to "わ"; 'i' to "ゐ"; 'e' to "ゑ"; 'o' to "を" }
    'g' to mapping { 'a' to "が"; 'i' to "ぎ"; 'u' to "ぐ"; 'e' to "げ"; 'o' to "ご" }
    'z' to mapping { 'a' to "ざ"; 'i' to "じ"; 'u' to "ず"; 'e' to "ぜ"; 'o' to "ぞ" }
    'd' to mapping { 'a' to "だ"; 'i' to "ぢ"; 'u' to "づ"; 'e' to "で"; 'o' to "ど" }
    'b' to mapping { 'a' to "ば"; 'i' to "び"; 'u' to "ぶ"; 'e' to "べ"; 'o' to "ぼ" }
    'p' to mapping { 'a' to "ぱ"; 'i' to "ぴ"; 'u' to "ぷ"; 'e' to "ぺ"; 'o' to "ぽ" }
    'v' to mapping { 'a' to "ゔぁ"; 'i' to "ゔぃ"; 'u' to "ゔ"; 'e' to "ゔぇ"; 'o' to "ゔぉ" }
}


private val SPECIAL_SYMBOLS: Map<Char, Char> = mapOf(
    '.' to '。',
    ',' to '、',
    ':' to '：',
    '/' to '・',
    '!' to '！',
    '?' to '？',
    '~' to '〜',
    '-' to 'ー',
    '‘' to '「',
    '’' to '」',
    '“' to '『',
    '”' to '』',
    '[' to '［',
    ']' to '］',
    '(' to '（',
    ')' to '）',
    '{' to '｛',
    '}' to '｝'
)

private val CONSONANTS: Map<Char, Char> = mapOf(
    'k' to 'き',
    's' to 'し',
    't' to 'ち',
    'n' to 'に',
    'h' to 'ひ',
    'm' to 'み',
    'r' to 'り',
    'g' to 'ぎ',
    'z' to 'じ',
    'd' to 'ぢ',
    'b' to 'び',
    'p' to 'ぴ',
    'v' to 'ゔ',
    'q' to 'く',
    'f' to 'ふ'
)
private val SMALL_Y: Map<String, Char> =
    mapOf("ya" to 'ゃ', "yi" to 'ぃ', "yu" to 'ゅ', "ye" to 'ぇ', "yo" to 'ょ')
private val SMALL_VOWELS: Map<String, Char> =
    mapOf("a" to 'ぁ', "i" to 'ぃ', "u" to 'ぅ', "e" to 'ぇ', "o" to 'ぉ')

/**
 * Typing one should be the same as having typed the other instead
 */
private val ALIASES: Map<String, String> = mapOf(
    "sh" to "sy", // sha -> sya
    "ch" to "ty", // cho -> tyo
    "cy" to "ty", // cyo -> tyo
    "chy" to "ty", // chyu -> tyu
    "shy" to "sy", // shya -> sya
    "j" to "zy", // ja -> zya
    "jy" to "zy", // jye -> zye

    // exceptions to above rules
    "shi" to "si",
    "chi" to "ti",
    "tsu" to "tu",
    "ji" to "zi",
    "fu" to "hu"
)

/**
 * xtu -> っ
 */
private val SMALL_LETTERS: Map<String, Char> = listOf(
    mapOf(
        "tu" to 'っ',
        "wa" to 'ゎ',
        "ka" to 'ヵ',
        "ke" to 'ヶ',
    ),
    SMALL_VOWELS,
    SMALL_Y
).let { maps ->
    val result = mutableMapOf<String, Char>()
    maps.forEach { map -> result.putAll(map) }
    result
}

/**
 * Don't follow any notable patterns
 */
private val SPECIAL_CASES: Map<String, String> = mapOf(
    "yi" to "い",
    "wu" to "う",
    "ye" to "いぇ",
    "wi" to "うぃ",
    "we" to "うぇ",
    "kwa" to "くぁ",
    "whu" to "う",
    // because it"s not thya for てゃ but tha
    // and tha is not てぁ, but てゃ
    "tha" to "てゃ",
    "thu" to "てゅ",
    "tho" to "てょ",
    "dha" to "でゃ",
    "dhu" to "でゅ",
    "dho" to "でょ",
)

private val AIUEO_CONSTRUCTIONS: Map<String, Char> = mapOf(
    "wh" to 'う',
    "qw" to 'く',
    "q" to 'く',
    "gw" to 'ぐ',
    "sw" to 'す',
    "ts" to 'つ',
    "th" to 'て',
    "tw" to 'と',
    "dh" to 'で',
    "dw" to 'ど',
    "fw" to 'ふ',
    "f" to 'ふ'
)

private fun createRomajiToKanaMap(): MappingTree {
    val kanaTree = BASIC_KUNREI_TREE

    // Add tya, sya, etc.
    CONSONANTS.forEach { (consonant, yKana) ->
        SMALL_Y.forEach { (roma, kana) ->
            // for example kyo -> き + ょ
            kanaTree.setSubTreeValue(consonant + roma, "$yKana$kana")
        }
    }

    SPECIAL_SYMBOLS.forEach { (symbol, jSymbol) ->
        kanaTree.setSubTreeValue(symbol.toString(), jSymbol.toString())
    }

    // things like うぃ, くぃ, etc.
    AIUEO_CONSTRUCTIONS.forEach { (consonant, aiueoKana) ->
        SMALL_VOWELS.forEach { (vowel, kana) ->
            kanaTree.setSubTreeValue(consonant + vowel, "$aiueoKana$kana")
        }
    }

    // different ways to write ん
    listOf("n", "n'", "xn").forEach { nChar ->
        kanaTree.setSubTreeValue(nChar, "ん")
    }

    // c is equivalent to k, but not for chi, cha, etc. that's why we have to make a copy of k
    kanaTree['c'] = kanaTree['k']!!.duplicate()

    ALIASES.forEach { (str, alternative) ->
        // copy to avoid recursive containment
        val altTree = kanaTree.subTreeOf(alternative).duplicate()
        kanaTree.replaceSubTreeOf(str, altTree)
    }

    fun getAlternatives(str: String): List<String> {
        return (ALIASES.entries + mapOf("c" to "k").entries)
            .fold(mutableListOf()) { list, (alt, roma) ->
                if (str.startsWith(roma)) {
                    list.add(str.replace(roma, alt))
                }
                list
            }
    }

    SMALL_LETTERS.forEach { (kunreiRoma, kana) ->
        val xRoma = "x$kunreiRoma"
        val xSubTree = kanaTree.subTreeOf(xRoma).also { it.value = kana.toString() }

        // ltu -> xtu -> っ
        kanaTree.replaceSubTreeOf("l$kunreiRoma", xSubTree)

        // ltsu -> ltu -> っ
        getAlternatives(kunreiRoma).forEach { altRoma ->
            listOf('l', 'x').forEach { prefix ->
                val kunreiRomaTree = kanaTree.subTreeOf(prefix + kunreiRoma)
                kanaTree.replaceSubTreeOf(prefix + altRoma, kunreiRomaTree)
            }
        }
    }

    SPECIAL_CASES.forEach { (str, kana) ->
        kanaTree.setSubTreeValue(str, kana)
    }

    // add kka, tta, etc.
    fun addTsu(tree: MutableMappingTree) {
        if (!tree.hasSubTree()) { // // we have reached the bottom of this branch
            tree.value = "っ${tree.value}"
        } else {
            tree.subTrees.values.forEach { subTree -> addTsu(subTree) }
        }
    }
    // have to explicitly name c here, because we made it a copy of k, not a reference
    (CONSONANTS.keys + setOf('c', 'y', 'w', 'j')).forEach { consonant ->
        // This cast should be safe, since we already should have all consonants subtrees.
        val subTree = kanaTree[consonant]!!
        subTree[consonant] = subTree.duplicate().also { addTsu(it) }
    }
    // nn should not be っん
    kanaTree['n']!!.subTrees.remove('n')

    return kanaTree.toMappingTree()
}

val romajiToKanaMap: MappingTree by lazy { createRomajiToKanaMap() }

fun useObsoleteKana(map: MappingTree): MappingTree {
    val obsoleteKanaMapping = mapping { "wi" to 'ゐ'; "we" to 'ゑ' }
    return map.toMutableMappingTree().also { obsoleteKanaMapping.mergeInto(it) }.toMappingTree()
}

fun kanaImeMode(map: MappingTree): MappingTree {
    val customNMapping = mapping { "nn" to 'ん'; "n " to 'ん' }
    return map.toMutableMappingTree().also { customNMapping.mergeInto(it) }.toMappingTree()
}
