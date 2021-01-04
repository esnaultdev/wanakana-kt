package dev.esnault.wanakana.api;


import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.esnault.wanakana.Config;
import dev.esnault.wanakana.ConfigBuilder;
import dev.esnault.wanakana.IMEMode;
import dev.esnault.wanakana.TokenType;
import dev.esnault.wanakana.TypedToken;
import dev.esnault.wanakana.Wanakana;
import dev.esnault.wanakana.utils.MappingBuilder;
import dev.esnault.wanakana.utils.MappingTree;
import kotlin.text.Regex;

/**
 * Interface tests to ensure that refactorings don't impact existing users.
 * While this library is made with Kotlin in mind, let's also ensure that Wanakana can be used by
 * Java users.
 */
class JavaInterfaceTest {
    @DisplayName("toHiragana()")
    class ToHiraganaTest {
        @Test
        void minimalInput() {
            String result = Wanakana.toHiragana("onaji");
            Assert.assertEquals("おなじ", result);
        }

        @Test
        void allParameters() {
            String result = Wanakana.toHiragana("onawi", IMEMode.DISABLED, false, true);
            Assert.assertEquals("おなゐ", result);
        }

        @Test
        void config() {
            String result = Wanakana.toHiragana("onaji", Config.DEFAULT);
            Assert.assertEquals("おなじ", result);
        }
    }

    @DisplayName("toKatakana()")
    class ToKatakanaTest {
        @Test
        void minimalInput() {
            String result = Wanakana.toKatakana("onaji");
            Assert.assertEquals("オナジ", result);
        }

        @Test
        void allParameters() {
            String result = Wanakana.toKatakana("onawi", IMEMode.DISABLED, false, true);
            Assert.assertEquals("オナヰ", result);
        }

        @Test
        void config() {
            String result = Wanakana.toKatakana("onaji", Config.DEFAULT);
            Assert.assertEquals("オナジ", result);
        }
    }

    @DisplayName("toKana()")
    class ToKanaTest {
        @Test
        void minimalInput() {
            String result = Wanakana.toKana("onaji");
            Assert.assertEquals("おなじ", result);
        }

        @Test
        void allParameters() {
            String result = Wanakana.toKana("onawi", IMEMode.DISABLED, true);
            Assert.assertEquals("おなゐ", result);
        }

        @Test
        void config() {
            String result = Wanakana.toKana("onaji", Config.DEFAULT);
            Assert.assertEquals("おなじ", result);
        }
    }

    @DisplayName("toRomaji()")
    class ToRomajiTest {
        @Test
        void minimalInput() {
            String result = Wanakana.toRomaji("おなじ");
            Assert.assertEquals("onaji", result);
        }

        @Test
        void allParameters() {
            String result = Wanakana.toRomaji("ONAJI", IMEMode.DISABLED, true);
            Assert.assertEquals("オナジ", result);
        }

        @Test
        void config() {
            String result = Wanakana.toRomaji("おなじ", Config.DEFAULT);
            Assert.assertEquals("onaji", result);
        }
    }

    @DisplayName("stripOkurigana()")
    class StripOkuriganaTest {
        @Test
        void minimalInput() {
            String result = Wanakana.stripOkurigana("お祝い");
            Assert.assertEquals("お祝", result);
        }

        @Test
        void allParameters() {
            String result = Wanakana.stripOkurigana("おみまい", true, "お祝い");
            Assert.assertEquals("みまい", result);
        }
    }

    @DisplayName("tokenize()")
    class TokenizeTest {
        @Test
        void minimalInput() {
            List<String> result = Wanakana.tokenize("アお");
            List<String> expected = new ArrayList<>();
            expected.add("ア");
            expected.add("お");
            Assert.assertEquals(expected, result);
        }

        @Test
        void allParameters() {
            List<String> result = Wanakana.tokenize("アお", true);
            List<String> expected = new ArrayList<>();
            expected.add("アお");
            Assert.assertEquals(expected, result);
        }
    }

    @DisplayName("tokenizeWithType()")
    class TokenizeWithTypeTest {
        @Test
        void minimalInput() {
            List<TypedToken> result = Wanakana.tokenizeWithType("アお");
            List<TypedToken> expected = new ArrayList<>();
            expected.add(new TypedToken("ア", TokenType.KATAKANA));
            expected.add(new TypedToken("お", TokenType.HIRAGANA));
            Assert.assertEquals(expected, result);
        }

        @Test
        void allParameters() {
            List<TypedToken> result = Wanakana.tokenizeWithType("アお", true);
            List<TypedToken> expected = new ArrayList<>();
            expected.add(new TypedToken("アお", TokenType.JA));
            Assert.assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Detection methods")
    class DetectionMethods {
        @Nested
        @DisplayName("String")
        class StringTest {
            @Test
            void isKana() {
                Assert.assertTrue(Wanakana.isKana("あ"));
            }

            @Test
            void isHiragana() {
                Assert.assertTrue(Wanakana.isHiragana("あ"));
            }

            @Test
            void isKatakana() {
                Assert.assertTrue(Wanakana.isKatakana("ア"));
            }

            @Test
            void isMixed() {
                Assert.assertTrue(Wanakana.isMixed("Abあア"));
            }

            @Test
            void isMixedPassKanji() {
                Assert.assertFalse(Wanakana.isMixed("お腹A", false));
            }

            @Test
            void isKanji() {
                Assert.assertTrue(Wanakana.isKanji("腹"));
            }

            @Test
            void isJapanese() {
                Assert.assertTrue(Wanakana.isJapanese("泣き虫"));
            }

            @Test
            void isJapaneseWithRegex() {
                Assert.assertTrue(Wanakana.isJapanese("≪偽括弧≫", new Regex("[≪≫]")));
            }

            @Test
            void isRomaji() {
                Assert.assertTrue(Wanakana.isRomaji("Tōkyō and Ōsaka"));
            }

            @Test
            void isRomajiWithRegex() {
                Assert.assertTrue(Wanakana.isRomaji("a！b&cーd", new Regex("[！ー]")));
            }
        }

        @Nested
        @DisplayName("Char")
        class CharTest {
            @Test
            void isKana() {
                Assert.assertTrue(Wanakana.isKana('あ'));
            }

            @Test
            void isHiragana() {
                Assert.assertTrue(Wanakana.isHiragana('あ'));
            }

            @Test
            void isKatakana() {
                Assert.assertTrue(Wanakana.isKatakana('ア'));
            }

            @Test
            void isKanji() {
                Assert.assertTrue(Wanakana.isKanji('腹'));
            }

            @Test
            void isJapanese() {
                Assert.assertTrue(Wanakana.isJapanese('泣'));
            }

            @Test
            void isRomaji() {
                Assert.assertTrue(Wanakana.isRomaji('Ō'));
            }
        }
    }

    @Nested
    @DisplayName("Config")
    class ConfigTest {
        @Test
        void defaultConfig() {
            Config config = Config.DEFAULT;
            Config expected = new Config(false, false, false, IMEMode.DISABLED);
            Assert.assertEquals(expected, config);
        }

        @Test
        void createConfigWithUpcaseKatakana() {
            Config config = new ConfigBuilder()
                    .upcaseKatakana(true)
                    .build();
            Config expected = new Config(false, false, true, IMEMode.DISABLED);
            Assert.assertEquals(expected, config);
        }

        @Test
        void updateConfigWithUpcaseKatakana() {
            Config config = Config.DEFAULT;
            Config newConfig = config.update()
                    .upcaseKatakana(true)
                    .build();
            Config expected = new Config(false, false, true, IMEMode.DISABLED);
            Assert.assertEquals(expected, newConfig);
        }
    }

    @Test
    @DisplayName("Custom mapping")
    void customMappingTest() {
        MappingTree mapping = new MappingBuilder()
                .value("test")
                .to("ab", "other")
                .to("c", new MappingBuilder()
                        .value("another")
                        .build()
                )
                .build();
        MappingTree expected = MappingTree.of(
                "test",
                Map.of(
                        'a', MappingTree.of(
                                null,
                                Map.of(
                                        'b',
                                        MappingTree.of("other")
                                )
                        ),
                        'c', MappingTree.of("another")
                )
        );
        Assert.assertEquals(expected, mapping);
    }
}
