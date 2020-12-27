package dev.esnault.wanakana

import dev.esnault.wanakana.helpers.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestFactory
import java.util.*
import kotlin.test.assertEquals

fun MutableList<DynamicTest>.test(name: String, block: () -> Unit) =
    add(DynamicTest.dynamicTest(name, block))

data class Test(val name: String, val input: String, val expected: String)

@DisplayName("Character conversions")
class ConversionTest {

    @Nested
    @DisplayName("Test every conversion table char")
    inner class ConversionTable {
        @DisplayName("toKana()")
        @TestFactory
        fun toKanaTest(): Collection<DynamicTest> {
            val tests = mutableListOf<DynamicTest>()
            ROMA_TO_HIRA_KATA.forEach { (romaji, hiragana, katakana) ->
                tests.test(name = "$romaji -> $hiragana") {
                    assertEquals(expected = hiragana, actual = toKana(romaji))
                }
                val upperRomaji = romaji.toUpperCase(Locale.ENGLISH)
                tests.test(name = "$upperRomaji -> $katakana") {
                    assertEquals(expected = katakana, actual = toKana(katakana))
                }
            }
            return tests
        }

        @DisplayName("toRomaji()")
        @TestFactory
        fun toRomajiTest(): Collection<DynamicTest> {
            val tests = mutableListOf<DynamicTest>()
            HIRA_KATA_TO_ROMA.forEach { (hiragana, katakana, romaji) ->
                if (hiragana.isNotEmpty()) {
                    tests.test(name = "$hiragana -> $romaji") {
                        assertEquals(expected = romaji, actual = toRomaji(hiragana))
                    }
                }
                if (katakana.isNotEmpty()) {
                    tests.test(name = "$katakana -> $romaji") {
                        assertEquals(expected = romaji, actual = toRomaji(katakana))
                    }
                }
            }
            return tests
        }
    }

    @DisplayName("N edge cases")
    @TestFactory
    fun nEdgeCaseTests(): Collection<DynamicTest> {
        return listOf(
            Test("Solo N", "n", "ん"),
            Test("Solo N", "n", "ん"),
            Test("double N", "onn", "おんん"),
            Test("N followed by N* syllable", "onna", "おんな"),
            Test("Triple N", "nnn", "んんん"),
            Test("Triple N followed by N* syllable", "onnna", "おんんな"),
            Test("Quadruple N", "nnnn", "んんんん"),
            Test("nya -> にゃ", "nyan", "にゃん"),
            Test("nnya -> んにゃ", "nnyann", "んにゃんん"),
            Test("nnnya -> んにゃ", "nnnyannn", "んんにゃんんん"),
            Test("n'ya -> んや", "n'ya", "んや"),
            Test("kin'ya -> きんや", "kin'ya", "きんや"),
            Test("shin'ya -> しんや", "shin'ya", "しんや"),
            Test("kinyou -> きにょう", "kinyou", "きにょう"),
            Test("kin'you -> きんよう", "kin'you", "きんよう"),
            Test("kin'yu -> きんゆ", "kin'yu", "きんゆ"),
            Test("Properly add space after \"n[space]\"", "ichiban warui", "いちばん わるい")
        )
            .map { test ->
                DynamicTest.dynamicTest(test.name) {
                    assertEquals(expected = test.expected, actual = toKana(test.input))
                }
            }
    }

    @DisplayName("Bogus 4 character sequences")
    @TestFactory
    fun bogusFourCharTests(): Collection<DynamicTest> {
        return listOf(
            Test("Non bogus sequences work", "chya", "ちゃ"),
            Test("Bogus sequences do not work", "chyx", "chyx"),
            Test("Bogus sequences do not work", "shyp", "shyp"),
            Test("Bogus sequences do not work", "ltsb", "ltsb"),
        )
            .map { test ->
                DynamicTest.dynamicTest(test.name) {
                    assertEquals(expected = test.expected, actual = toKana(test.input))
                }
            }
    }
}

/*
TODO: JS to convert

describe('character conversions', () => {
  describe('test every conversion table char', () => {
    describe('toHiragana()', () => {
      ROMA_TO_HIRA_KATA.forEach((item) => {
        const [romaji, hiragana] = item;
        const lower = toHiragana(romaji);
        const upper = toHiragana(romaji.toUpperCase());
        it(`${romaji}`, () => expect(lower).toBe(hiragana));
        it(`${romaji.toUpperCase()}`, () => expect(upper).toBe(hiragana));
      });
    });

    describe('toKatakana()', () => {
      ROMA_TO_HIRA_KATA.forEach((item) => {
        const [romaji, , katakana] = item;
        const lower = toKatakana(romaji);
        const upper = toKatakana(romaji.toUpperCase());

        it(`${romaji}`, () => expect(lower).toBe(katakana));
        it(`${romaji.toUpperCase()}`, () => expect(upper).toBe(katakana));
      });
    });
  });

  describe('Converting kana to kana', () => {
    it('k -> h', () => expect(toHiragana('バケル')).toBe('ばける'));
    it('h -> k', () => expect(toKatakana('ばける')).toBe('バケル'));

    it('It survives only katakana toKatakana', () =>
      expect(toKatakana('スタイル')).toBe('スタイル'));
    it('It survives only hiragana toHiragana', () =>
      expect(toHiragana('すたーいる')).toBe('すたーいる'));
    it('Mixed kana converts every char k -> h', () =>
      expect(toKatakana('アメリカじん')).toBe('アメリカジン'));
    it('Mixed kana converts every char h -> k', () =>
      expect(toHiragana('アメリカじん')).toBe('あめりかじん'));

    describe('long vowels', () => {
      it('Converts long vowels correctly from k -> h', () =>
        expect(toHiragana('バツゴー')).toBe('ばつごう'));
      it('Preserves long dash from h -> k', () =>
        expect(toKatakana('ばつゲーム')).toBe('バツゲーム'));
      it('Preserves long dash from h -> h', () =>
        expect(toHiragana('ばつげーむ')).toBe('ばつげーむ'));
      it('Preserves long dash from k -> k', () =>
        expect(toKatakana('バツゲーム')).toBe('バツゲーム'));
      it('Preserves long dash from mixed -> k', () =>
        expect(toKatakana('バツゲーム')).toBe('バツゲーム'));
      it('Preserves long dash from mixed -> k', () =>
        expect(toKatakana('テスーと')).toBe('テスート'));
      it('Preserves long dash from mixed -> h', () =>
        expect(toHiragana('てすート')).toBe('てすーと'));
      it('Preserves long dash from mixed -> h', () =>
        expect(toHiragana('てすー戸')).toBe('てすー戸'));
      it('Preserves long dash from mixed -> h', () =>
        expect(toHiragana('手巣ート')).toBe('手巣ーと'));
      it('Preserves long dash from mixed -> h', () =>
        expect(toHiragana('tesート')).toBe('てsーと'));
      it('Preserves long dash from mixed -> h', () =>
        expect(toHiragana('ートtesu')).toBe('ーとてす'));
    });

    describe('Mixed syllabaries', () => {
      it('It passes non-katakana through when passRomaji is true k -> h', () =>
        expect(toHiragana('座禅‘zazen’スタイル', { passRomaji: true })).toBe(
          '座禅‘zazen’すたいる'
        ));

      it('It passes non-hiragana through when passRomaji is true h -> k', () =>
        expect(toKatakana('座禅‘zazen’すたいる', { passRomaji: true })).toBe(
          '座禅‘zazen’スタイル'
        ));

      it('It converts non-katakana when passRomaji is false k -> h', () =>
        expect(toHiragana('座禅‘zazen’スタイル')).toBe('座禅「ざぜん」すたいる'));

      it('It converts non-hiragana when passRomaji is false h -> k', () =>
        expect(toKatakana('座禅‘zazen’すたいる')).toBe('座禅「ザゼン」スタイル'));
    });
  });

  describe('Case sensitivity', () => {
    it("cAse DoEsn'T MatTER for toHiragana()", () =>
      expect(toHiragana('aiueo')).toBe(toHiragana('AIUEO')));
    it("cAse DoEsn'T MatTER for toKatakana()", () =>
      expect(toKatakana('aiueo')).toBe(toKatakana('AIUEO')));
    it('Case DOES matter for toKana()', () => expect(toKana('aiueo')).not.toBe(toKana('AIUEO')));
  });
});
 */
