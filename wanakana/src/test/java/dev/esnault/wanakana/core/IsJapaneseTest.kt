package dev.esnault.wanakana.core

import dev.esnault.wanakana.dynamicTests
import dev.esnault.wanakana.isJapanese
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory


@DisplayName("isJapanese()")
class IsJapaneseTest {

    @TestFactory
    @DisplayName("Basic usage")
    fun isHiraganaTest() = dynamicTests {
        fun test(name: String, input: String, expected: Boolean) =
            testBoolean(name = name, expected = expected) { isJapanese(input) }

        test(name = "Empty", input = "", expected = true)
        test(name = "泣き虫 is japanese", input = "泣き虫", expected = true)
        test(name = "あア is japanese", input = "あア", expected = true)
        test(name = "A泣き虫 is not japanese", input = "A泣き虫", expected = false)
        test(name = "A is not japanese", input = "A", expected = false)
        test(name = "ja space is japanese", input = "　", expected = true)
        test(name = "en space is not japanese", input = " ", expected = false)
        test(
            name = "泣き虫。！〜 (w. zenkaku punctuation) is japanese",
            input = "泣き虫。＃！〜〈〉《》〔〕［］【】（）｛｝〝〟",
            expected = true
        )
        test(
            name = "泣き虫.!~ (w. romaji punctuation) is not japanese",
            input = "泣き虫.!~",
            expected = false
        )
        test(
            name = "zenkaku numbers are considered neutral",
            input = "０１２３４５６７８９",
            expected = true
        )
        test(name = "latin numbers are not japanese", input = "0123456789", expected = false)
        test(
            name = "zenkaku latin letters are considered neutral",
            input = "ＭｅＴｏｏ",
            expected = true
        )
        test(name = "mixed with numbers is japanese", input = "２０１１年", expected = true)
        test(name = "hankaku katakana is allowed", input = "ﾊﾝｶｸｶﾀｶﾅ", expected = true)
        test(
            name = "randomly sliced nhk news text is japanese",
            input = "＃ＭｅＴｏｏ、これを前に「ＫＵＲＯＳＨＩＯ」は、都内で報道陣を前に水中探査ロボットの最終点検の様子を公開しました。イルカのような形をした探査ロボットは、全長３メートル、重さは３５０キロあります。《はじめに》冒頭、安倍総理大臣は、ことしが明治元年から１５０年にあたることに触れ「明治という新しい時代が育てたあまたの人材が、技術優位の欧米諸国が迫る『国難』とも呼ぶべき危機の中で、わが国が急速に近代化を遂げる原動力となった。今また、日本は少子高齢化という『国難』とも呼ぶべき危機に直面している。もう１度、あらゆる日本人にチャンスを創ることで、少子高齢化も克服できる」と呼びかけました。《働き方改革》続いて安倍総理大臣は、具体的な政策課題の最初に「働き方改革」を取り上げ、「戦後の労働基準法制定以来、７０年ぶりの大改革だ。誰もが生きがいを感じて、その能力を思う存分発揮すれば少子高齢化も克服できる」と述べました。そして、同一労働同一賃金の実現や、時間外労働の上限規制の導入、それに労働時間でなく成果で評価するとして労働時間の規制から外す「高度プロフェッショナル制度」の創設などに取り組む考えを強調しました。",
            expected = true
        )
        testTrue(name = "accepts optional allowed chars") {
            isJapanese("≪偽括弧≫", allowed = Regex("[≪≫]"))
        }
    }
}
