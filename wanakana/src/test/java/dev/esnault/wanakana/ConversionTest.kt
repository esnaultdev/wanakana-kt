package dev.esnault.wanakana

import dev.esnault.wanakana.helpers.*
import dev.esnault.wanakana.utils.safeUpperCase
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestFactory

@DisplayName("Character conversions")
class ConversionTest {

    @Nested
    @DisplayName("Test every conversion table char")
    inner class ConversionTable {
        @TestFactory
        fun toKana() = dynamicTests {
            ROMA_TO_HIRA_KATA.forEach { (romaji, hiragana, katakana) ->
                testEquals(name = "$romaji -> $hiragana", expected = hiragana) {
                    toKana(romaji)
                }
                val upperRomaji = romaji.safeUpperCase()
                testEquals(name = "$upperRomaji -> $katakana", expected = katakana) {
                    toKana(upperRomaji)
                }
            }
        }

        @TestFactory
        fun toHiragana() = dynamicTests {
            ROMA_TO_HIRA_KATA.forEach { (romaji, hiragana) ->
                testEquals(name = "$romaji -> $hiragana", expected = hiragana) {
                    toHiragana(romaji)
                }
                val upperRomaji = romaji.safeUpperCase()
                testEquals(name = "$upperRomaji -> $hiragana", expected = hiragana) {
                    toHiragana(upperRomaji)
                }
            }
        }

        @TestFactory
        fun toKatakana() = dynamicTests {
            ROMA_TO_HIRA_KATA.forEach { (romaji, _, katakana) ->
                testEquals(name = "$romaji -> $katakana", expected = katakana) {
                    toKatakana(romaji)
                }
                val upperRomaji = romaji.safeUpperCase()
                testEquals(name = "$upperRomaji -> $katakana", expected = katakana) {
                    toKatakana(upperRomaji)
                }
            }
        }

        @TestFactory
        fun toRomaji() = dynamicTests {
            HIRA_KATA_TO_ROMA.forEach { (hiragana, katakana, romaji) ->
                if (hiragana.isNotEmpty()) {
                    testEquals(name = "$hiragana -> $romaji", expected = romaji) {
                        toRomaji(hiragana)
                    }
                }
                if (katakana.isNotEmpty()) {
                    testEquals(name = "$katakana -> $romaji", expected = romaji) {
                        toRomaji(katakana)
                    }
                }
            }
        }
    }

    @DisplayName("N edge cases")
    @TestFactory
    fun nEdgeCaseTests() = dynamicTests {
        fun test(name: String, input: String, expected: String) =
            testEquals(name, expected) { toKana(input) }

        test("Solo N", "n", "ん")
        test("Solo N", "n", "ん")
        test("double N", "onn", "おんん")
        test("N followed by N* syllable", "onna", "おんな")
        test("Triple N", "nnn", "んんん")
        test("Triple N followed by N* syllable", "onnna", "おんんな")
        test("Quadruple N", "nnnn", "んんんん")
        test("nya -> にゃ", "nyan", "にゃん")
        test("nnya -> んにゃ", "nnyann", "んにゃんん")
        test("nnnya -> んにゃ", "nnnyannn", "んんにゃんんん")
        test("n'ya -> んや", "n'ya", "んや")
        test("kin'ya -> きんや", "kin'ya", "きんや")
        test("shin'ya -> しんや", "shin'ya", "しんや")
        test("kinyou -> きにょう", "kinyou", "きにょう")
        test("kin'you -> きんよう", "kin'you", "きんよう")
        test("kin'yu -> きんゆ", "kin'yu", "きんゆ")
        test("Properly add space after \"n[space]\"", "ichiban warui", "いちばん わるい")
    }

    @DisplayName("Bogus 4 character sequences")
    @TestFactory
    fun bogusFourCharTests() = dynamicTests {
        fun test(name: String, input: String, expected: String) =
            testEquals(name, expected) { toKana(input) }

        test("Non bogus sequences work", "chya", "ちゃ")
        test("Bogus sequences do not work", "chyx", "chyx")
        test("Bogus sequences do not work", "shyp", "shyp")
        test("Bogus sequences do not work", "ltsb", "ltsb")
    }
}

/*
TODO: JS to convert

describe('character conversions', () => {
  describe('test every conversion table char', () => {


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
