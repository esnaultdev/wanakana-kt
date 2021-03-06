package dev.esnault.wanakana.helpers

val JA_PUNC = listOf(
    '！',
    '？',
    '。',
    '：',
    '・',
    '、',
    '〜',
    'ー',
    '「',
    '」',
    '『',
    '』',
    '［',
    '］',
    '（',
    '）',
    '｛',
    '｝',
)

val EN_PUNC = listOf(
    '!',
    '?',
    '.',
    ':',
    '/',
    ',',
    '~',
    '-',
    '‘',
    '’',
    '“',
    '”',
    '[',
    ']',
    '(',
    ')',
    '{',
    '}',
)

val ROMA_TO_HIRA_KATA = listOf(
    /* symbols that should all be the same after conversion */
    listOf("ヶ", "ヶ", "ヶ"),
    listOf("ヵ", "ヵ", "ヵ"),
    listOf("1", "1", "1"),
    listOf("@", "@", "@"),
    listOf("#", "#", "#"),
    listOf("$", "$", "$"),
    listOf("%", "%", "%"),
    /* should all convert */
    listOf("!", "！", "！"),
    listOf("?", "？", "？"),
    listOf(".", "。", "。"),
    listOf(":", "：", "："),
    listOf("/", "・", "・"),
    listOf(",", "、", "、"),
    listOf("~", "〜", "〜"),
    listOf("-", "ー", "ー"),
    listOf("‘", "「", "「"),
    listOf("’", "」", "」"),
    listOf("“", "『", "『"),
    listOf("”", "』", "』"),
    listOf("[", "［", "［"),
    listOf("]", "］", "］"),
    listOf("(", "（", "（"),
    listOf(")", "）", "）"),
    listOf("{", "｛", "｛"),
    listOf("}", "｝", "｝"),
    listOf("a", "あ", "ア"),
    listOf("i", "い", "イ"),
    listOf("u", "う", "ウ"),
    listOf("e", "え", "エ"),
    listOf("o", "お", "オ"),
    listOf("la", "ぁ", "ァ"),
    listOf("xa", "ぁ", "ァ"),
    listOf("li", "ぃ", "ィ"),
    listOf("xi", "ぃ", "ィ"),
    listOf("lu", "ぅ", "ゥ"),
    listOf("xu", "ぅ", "ゥ"),
    listOf("le", "ぇ", "ェ"),
    listOf("xe", "ぇ", "ェ"),
    listOf("lo", "ぉ", "ォ"),
    listOf("xo", "ぉ", "ォ"),
    listOf("yi", "い", "イ"),
    listOf("wu", "う", "ウ"),
    listOf("whu", "う", "ウ"),
    listOf("xa", "ぁ", "ァ"),
    listOf("xi", "ぃ", "ィ"),
    listOf("xu", "ぅ", "ゥ"),
    listOf("xe", "ぇ", "ェ"),
    listOf("xo", "ぉ", "ォ"),
    listOf("xyi", "ぃ", "ィ"),
    listOf("xye", "ぇ", "ェ"),
    listOf("ye", "いぇ", "イェ"),
    listOf("wha", "うぁ", "ウァ"),
    listOf("whi", "うぃ", "ウィ"),
    listOf("whe", "うぇ", "ウェ"),
    listOf("who", "うぉ", "ウォ"),
    listOf("wi", "うぃ", "ウィ"),
    listOf("we", "うぇ", "ウェ"),
    listOf("va", "ゔぁ", "ヴァ"),
    listOf("vi", "ゔぃ", "ヴィ"),
    listOf("vu", "ゔ", "ヴ"),
    listOf("ve", "ゔぇ", "ヴェ"),
    listOf("vo", "ゔぉ", "ヴォ"),
    listOf("vyi", "ゔぃ", "ヴィ"),
    listOf("vye", "ゔぇ", "ヴェ"),
    listOf("vya", "ゔゃ", "ヴャ"),
    listOf("vyu", "ゔゅ", "ヴュ"),
    listOf("vyo", "ゔょ", "ヴョ"),
    listOf("ka", "か", "カ"),
    listOf("ki", "き", "キ"),
    listOf("ku", "く", "ク"),
    listOf("ke", "け", "ケ"),
    listOf("ko", "こ", "コ"),
    listOf("lka", "ヵ", "ヵ"),
    listOf("lke", "ヶ", "ヶ"),
    listOf("xka", "ヵ", "ヵ"),
    listOf("xke", "ヶ", "ヶ"),
    listOf("kya", "きゃ", "キャ"),
    listOf("kyi", "きぃ", "キィ"),
    listOf("kyu", "きゅ", "キュ"),
    listOf("kye", "きぇ", "キェ"),
    listOf("kyo", "きょ", "キョ"),
    listOf("ca", "か", "カ"),
    listOf("ci", "き", "キ"),
    listOf("cu", "く", "ク"),
    listOf("ce", "け", "ケ"),
    listOf("co", "こ", "コ"),
    listOf("lca", "ヵ", "ヵ"),
    listOf("lce", "ヶ", "ヶ"),
    listOf("xca", "ヵ", "ヵ"),
    listOf("xce", "ヶ", "ヶ"),
    listOf("qya", "くゃ", "クャ"),
    listOf("qyu", "くゅ", "クュ"),
    listOf("qyo", "くょ", "クョ"),
    listOf("qwa", "くぁ", "クァ"),
    listOf("qwi", "くぃ", "クィ"),
    listOf("qwu", "くぅ", "クゥ"),
    listOf("qwe", "くぇ", "クェ"),
    listOf("qwo", "くぉ", "クォ"),
    listOf("qa", "くぁ", "クァ"),
    listOf("qi", "くぃ", "クィ"),
    listOf("qe", "くぇ", "クェ"),
    listOf("qo", "くぉ", "クォ"),
    listOf("kwa", "くぁ", "クァ"),
    listOf("qyi", "くぃ", "クィ"),
    listOf("qye", "くぇ", "クェ"),
    listOf("ga", "が", "ガ"),
    listOf("gi", "ぎ", "ギ"),
    listOf("gu", "ぐ", "グ"),
    listOf("ge", "げ", "ゲ"),
    listOf("go", "ご", "ゴ"),
    listOf("gya", "ぎゃ", "ギャ"),
    listOf("gyi", "ぎぃ", "ギィ"),
    listOf("gyu", "ぎゅ", "ギュ"),
    listOf("gye", "ぎぇ", "ギェ"),
    listOf("gyo", "ぎょ", "ギョ"),
    listOf("gwa", "ぐぁ", "グァ"),
    listOf("gwi", "ぐぃ", "グィ"),
    listOf("gwu", "ぐぅ", "グゥ"),
    listOf("gwe", "ぐぇ", "グェ"),
    listOf("gwo", "ぐぉ", "グォ"),
    listOf("sa", "さ", "サ"),
    listOf("si", "し", "シ"),
    listOf("su", "す", "ス"),
    listOf("se", "せ", "セ"),
    listOf("so", "そ", "ソ"),
    listOf("shi", "し", "シ"),
    listOf("za", "ざ", "ザ"),
    listOf("zi", "じ", "ジ"),
    listOf("zu", "ず", "ズ"),
    listOf("ze", "ぜ", "ゼ"),
    listOf("zo", "ぞ", "ゾ"),
    listOf("ji", "じ", "ジ"),
    listOf("sya", "しゃ", "シャ"),
    listOf("syi", "しぃ", "シィ"),
    listOf("syu", "しゅ", "シュ"),
    listOf("sye", "しぇ", "シェ"),
    listOf("syo", "しょ", "ショ"),
    listOf("sha", "しゃ", "シャ"),
    listOf("shu", "しゅ", "シュ"),
    listOf("she", "しぇ", "シェ"),
    listOf("sho", "しょ", "ショ"),
    listOf("shya", "しゃ", "シャ"),
    listOf("shyu", "しゅ", "シュ"),
    listOf("shye", "しぇ", "シェ"),
    listOf("shyo", "しょ", "ショ"),
    listOf("swa", "すぁ", "スァ"),
    listOf("swi", "すぃ", "スィ"),
    listOf("swu", "すぅ", "スゥ"),
    listOf("swe", "すぇ", "スェ"),
    listOf("swo", "すぉ", "スォ"),
    listOf("zya", "じゃ", "ジャ"),
    listOf("zyi", "じぃ", "ジィ"),
    listOf("zyu", "じゅ", "ジュ"),
    listOf("zye", "じぇ", "ジェ"),
    listOf("zyo", "じょ", "ジョ"),
    listOf("ja", "じゃ", "ジャ"),
    listOf("ju", "じゅ", "ジュ"),
    listOf("je", "じぇ", "ジェ"),
    listOf("jo", "じょ", "ジョ"),
    listOf("jya", "じゃ", "ジャ"),
    listOf("jyi", "じぃ", "ジィ"),
    listOf("jyu", "じゅ", "ジュ"),
    listOf("jye", "じぇ", "ジェ"),
    listOf("jyo", "じょ", "ジョ"),
    listOf("ta", "た", "タ"),
    listOf("ti", "ち", "チ"),
    listOf("tu", "つ", "ツ"),
    listOf("te", "て", "テ"),
    listOf("to", "と", "ト"),
    listOf("chi", "ち", "チ"),
    listOf("tsu", "つ", "ツ"),
    listOf("ltu", "っ", "ッ"),
    listOf("xtu", "っ", "ッ"),
    listOf("ltsu", "っ", "ッ"),
    listOf("tya", "ちゃ", "チャ"),
    listOf("tyi", "ちぃ", "チィ"),
    listOf("tyu", "ちゅ", "チュ"),
    listOf("tye", "ちぇ", "チェ"),
    listOf("tyo", "ちょ", "チョ"),
    listOf("cha", "ちゃ", "チャ"),
    listOf("chu", "ちゅ", "チュ"),
    listOf("che", "ちぇ", "チェ"),
    listOf("cho", "ちょ", "チョ"),
    listOf("cya", "ちゃ", "チャ"),
    listOf("cyi", "ちぃ", "チィ"),
    listOf("cyu", "ちゅ", "チュ"),
    listOf("cye", "ちぇ", "チェ"),
    listOf("cyo", "ちょ", "チョ"),
    listOf("chya", "ちゃ", "チャ"),
    listOf("chyu", "ちゅ", "チュ"),
    listOf("chye", "ちぇ", "チェ"),
    listOf("chyo", "ちょ", "チョ"),
    listOf("tsa", "つぁ", "ツァ"),
    listOf("tsi", "つぃ", "ツィ"),
    listOf("tse", "つぇ", "ツェ"),
    listOf("tso", "つぉ", "ツォ"),
    listOf("tha", "てゃ", "テャ"),
    listOf("thi", "てぃ", "ティ"),
    listOf("thu", "てゅ", "テュ"),
    listOf("the", "てぇ", "テェ"),
    listOf("tho", "てょ", "テョ"),
    listOf("twa", "とぁ", "トァ"),
    listOf("twi", "とぃ", "トィ"),
    listOf("twu", "とぅ", "トゥ"),
    listOf("twe", "とぇ", "トェ"),
    listOf("two", "とぉ", "トォ"),
    listOf("da", "だ", "ダ"),
    listOf("di", "ぢ", "ヂ"),
    listOf("du", "づ", "ヅ"),
    listOf("de", "で", "デ"),
    listOf("do", "ど", "ド"),
    listOf("dya", "ぢゃ", "ヂャ"),
    listOf("dyi", "ぢぃ", "ヂィ"),
    listOf("dyu", "ぢゅ", "ヂュ"),
    listOf("dye", "ぢぇ", "ヂェ"),
    listOf("dyo", "ぢょ", "ヂョ"),
    listOf("dha", "でゃ", "デャ"),
    listOf("dhi", "でぃ", "ディ"),
    listOf("dhu", "でゅ", "デュ"),
    listOf("dhe", "でぇ", "デェ"),
    listOf("dho", "でょ", "デョ"),
    listOf("dwa", "どぁ", "ドァ"),
    listOf("dwi", "どぃ", "ドィ"),
    listOf("dwu", "どぅ", "ドゥ"),
    listOf("dwe", "どぇ", "ドェ"),
    listOf("dwo", "どぉ", "ドォ"),
    listOf("na", "な", "ナ"),
    listOf("ni", "に", "ニ"),
    listOf("nu", "ぬ", "ヌ"),
    listOf("ne", "ね", "ネ"),
    listOf("no", "の", "ノ"),
    listOf("nya", "にゃ", "ニャ"),
    listOf("nyi", "にぃ", "ニィ"),
    listOf("nyu", "にゅ", "ニュ"),
    listOf("nye", "にぇ", "ニェ"),
    listOf("nyo", "にょ", "ニョ"),
    listOf("ha", "は", "ハ"),
    listOf("hi", "ひ", "ヒ"),
    listOf("hu", "ふ", "フ"),
    listOf("he", "へ", "ヘ"),
    listOf("ho", "ほ", "ホ"),
    listOf("fu", "ふ", "フ"),
    listOf("hya", "ひゃ", "ヒャ"),
    listOf("hyi", "ひぃ", "ヒィ"),
    listOf("hyu", "ひゅ", "ヒュ"),
    listOf("hye", "ひぇ", "ヒェ"),
    listOf("hyo", "ひょ", "ヒョ"),
    listOf("fya", "ふゃ", "フャ"),
    listOf("fyu", "ふゅ", "フュ"),
    listOf("fyo", "ふょ", "フョ"),
    listOf("fwa", "ふぁ", "ファ"),
    listOf("fwi", "ふぃ", "フィ"),
    listOf("fwu", "ふぅ", "フゥ"),
    listOf("fwe", "ふぇ", "フェ"),
    listOf("fwo", "ふぉ", "フォ"),
    listOf("fa", "ふぁ", "ファ"),
    listOf("fi", "ふぃ", "フィ"),
    listOf("fe", "ふぇ", "フェ"),
    listOf("fo", "ふぉ", "フォ"),
    listOf("fyi", "ふぃ", "フィ"),
    listOf("fye", "ふぇ", "フェ"),
    listOf("ba", "ば", "バ"),
    listOf("bi", "び", "ビ"),
    listOf("bu", "ぶ", "ブ"),
    listOf("be", "べ", "ベ"),
    listOf("bo", "ぼ", "ボ"),
    listOf("bya", "びゃ", "ビャ"),
    listOf("byi", "びぃ", "ビィ"),
    listOf("byu", "びゅ", "ビュ"),
    listOf("bye", "びぇ", "ビェ"),
    listOf("byo", "びょ", "ビョ"),
    listOf("pa", "ぱ", "パ"),
    listOf("pi", "ぴ", "ピ"),
    listOf("pu", "ぷ", "プ"),
    listOf("pe", "ぺ", "ペ"),
    listOf("po", "ぽ", "ポ"),
    listOf("pya", "ぴゃ", "ピャ"),
    listOf("pyi", "ぴぃ", "ピィ"),
    listOf("pyu", "ぴゅ", "ピュ"),
    listOf("pye", "ぴぇ", "ピェ"),
    listOf("pyo", "ぴょ", "ピョ"),
    listOf("ma", "ま", "マ"),
    listOf("mi", "み", "ミ"),
    listOf("mu", "む", "ム"),
    listOf("me", "め", "メ"),
    listOf("mo", "も", "モ"),
    listOf("mya", "みゃ", "ミャ"),
    listOf("myi", "みぃ", "ミィ"),
    listOf("myu", "みゅ", "ミュ"),
    listOf("mye", "みぇ", "ミェ"),
    listOf("myo", "みょ", "ミョ"),
    listOf("ya", "や", "ヤ"),
    listOf("yu", "ゆ", "ユ"),
    listOf("yo", "よ", "ヨ"),
    listOf("xya", "ゃ", "ャ"),
    listOf("xyu", "ゅ", "ュ"),
    listOf("xyo", "ょ", "ョ"),
    listOf("ra", "ら", "ラ"),
    listOf("ri", "り", "リ"),
    listOf("ru", "る", "ル"),
    listOf("re", "れ", "レ"),
    listOf("ro", "ろ", "ロ"),
    listOf("rya", "りゃ", "リャ"),
    listOf("ryi", "りぃ", "リィ"),
    listOf("ryu", "りゅ", "リュ"),
    listOf("rye", "りぇ", "リェ"),
    listOf("ryo", "りょ", "リョ"),
    listOf("wa", "わ", "ワ"),
    listOf("wo", "を", "ヲ"),
    listOf("lwa", "ゎ", "ヮ"),
    listOf("xwa", "ゎ", "ヮ"),
    listOf("n", "ん", "ン"),
    listOf("nn", "んん", "ンン"),
    listOf("xn", "ん", "ン"),
    // double consonants
    listOf("atta", "あった", "アッタ"),
    listOf("gakkounakatta", "がっこうなかった", "ガッコウナカッタ"),
    listOf("babba", "ばっば", "バッバ"),
    listOf("cacca", "かっか", "カッカ"),
    listOf("chaccha", "ちゃっちゃ", "チャッチャ"),
    listOf("dadda", "だっだ", "ダッダ"),
    listOf("fuffu", "ふっふ", "フッフ"),
    listOf("gagga", "がっが", "ガッガ"),
    listOf("hahha", "はっは", "ハッハ"),
    listOf("jajja", "じゃっじゃ", "ジャッジャ"),
    listOf("kakka", "かっか", "カッカ"),
    listOf("mamma", "まっま", "マッマ"),
    listOf("nanna", "なんな", "ナンナ"),
    listOf("pappa", "ぱっぱ", "パッパ"),
    listOf("qaqqa", "くぁっくぁ", "クァックァ"),
    listOf("rarra", "らっら", "ラッラ"),
    listOf("sassa", "さっさ", "サッサ"),
    listOf("shassha", "しゃっしゃ", "シャッシャ"),
    listOf("tatta", "たった", "タッタ"),
    listOf("tsuttsu", "つっつ", "ツッツ"),
    listOf("vavva", "ゔぁっゔぁ", "ヴァッヴァ"),
    listOf("wawwa", "わっわ", "ワッワ"),
    listOf("yayya", "やっや", "ヤッヤ"),
    listOf("zazza", "ざっざ", "ザッザ"),
)

val HIRA_KATA_TO_ROMA = listOf(
    // symbols that should all be the same after conversion
    listOf("ヶ", "ヶ", "ヶ"),
    listOf("ヵ", "ヵ", "ヵ"),
    listOf("1", "1", "1"),
    listOf("@", "@", "@"),
    listOf("#", "#", "#"),
    listOf("$", "$", "$"),
    listOf("%", "%", "%"),
    // quick brown fox / iroha
    listOf("いろはにほへと", "イロハニホヘト", "irohanihoheto"),
    listOf("ちりぬるを", "チリヌルヲ", "chirinuruwo"),
    listOf("わかよたれそ", "ワカヨタレソ", "wakayotareso"),
    listOf("つねならむ", "ツネナラム", "tsunenaramu"),
    listOf("うゐのおくやま", "ウヰノオクヤマ", "uwinookuyama"),
    listOf("けふこえて", "ケフコエテ", "kefukoete"),
    listOf("あさきゆめみし", "アサキユメミシ", "asakiyumemishi"),
    listOf("ゑひもせすん", "ヱヒモセスン", "wehimosesun"),
    /* should all convert */
    listOf("！", "！", "!"),
    listOf("？", "？", "?"),
    listOf("。", "。", "."),
    listOf("：", "：", ":"),
    listOf("・", "・", "/"),
    listOf("、", "、", ","),
    listOf("〜", "〜", "~"),
    listOf("ー", "ー", "-"),
    listOf("「", "「", "‘"),
    listOf("」", "」", "’"),
    listOf("『", "『", "“"),
    listOf("』", "』", "”"),
    listOf("［", "［", "["),
    listOf("］", "］", "]"),
    listOf("（", "（", "("),
    listOf("）", "）", ")"),
    listOf("｛", "｛", "{"),
    listOf("｝", "｝", "}"),
    // hepburn
    listOf("か", "カ", "ka"),
    listOf("き", "キ", "ki"),
    listOf("く", "ク", "ku"),
    listOf("け", "ケ", "ke"),
    listOf("こ", "コ", "ko"),
    listOf("きゃ", "キャ", "kya"),
    listOf("きゅ", "キュ", "kyu"),
    listOf("きょ", "キョ", "kyo"),
    listOf("さ", "サ", "sa"),
    listOf("し", "シ", "shi"),
    listOf("す", "ス", "su"),
    listOf("せ", "セ", "se"),
    listOf("そ", "ソ", "so"),
    listOf("しゃ", "シャ", "sha"),
    listOf("しゅ", "シュ", "shu"),
    listOf("しょ", "ショ", "sho"),
    listOf("た", "タ", "ta"),
    listOf("ち", "チ", "chi"),
    listOf("つ", "ツ", "tsu"),
    listOf("て", "テ", "te"),
    listOf("と", "ト", "to"),
    listOf("ちゃ", "チャ", "cha"),
    listOf("ちゅ", "チュ", "chu"),
    listOf("ちょ", "チョ", "cho"),
    listOf("な", "ナ", "na"),
    listOf("に", "ニ", "ni"),
    listOf("ぬ", "ヌ", "nu"),
    listOf("ね", "ネ", "ne"),
    listOf("の", "ノ", "no"),
    listOf("にゃ", "ニャ", "nya"),
    listOf("にゅ", "ニュ", "nyu"),
    listOf("にょ", "ニョ", "nyo"),
    listOf("は", "ハ", "ha"),
    listOf("ひ", "ヒ", "hi"),
    listOf("ふ", "フ", "fu"),
    listOf("へ", "ヘ", "he"),
    listOf("ほ", "ホ", "ho"),
    listOf("ひゃ", "ヒャ", "hya"),
    listOf("ひゅ", "ヒュ", "hyu"),
    listOf("ひょ", "ヒョ", "hyo"),
    listOf("ま", "マ", "ma"),
    listOf("み", "ミ", "mi"),
    listOf("む", "ム", "mu"),
    listOf("め", "メ", "me"),
    listOf("も", "モ", "mo"),
    listOf("みゃ", "ミャ", "mya"),
    listOf("みゅ", "ミュ", "myu"),
    listOf("みょ", "ミョ", "myo"),
    listOf("ら", "ラ", "ra"),
    listOf("り", "リ", "ri"),
    listOf("る", "ル", "ru"),
    listOf("れ", "レ", "re"),
    listOf("ろ", "ロ", "ro"),
    listOf("りゃ", "リャ", "rya"),
    listOf("りゅ", "リュ", "ryu"),
    listOf("りょ", "リョ", "ryo"),
    listOf("や", "ヤ", "ya"),
    listOf("ゆ", "ユ", "yu"),
    listOf("よ", "ヨ", "yo"),
    listOf("わ", "ワ", "wa"),
    listOf("ゐ", "ヰ", "wi"),
    listOf("ゑ", "ヱ", "we"),
    listOf("を", "ヲ", "wo"),
    // dakuten
    listOf("が", "ガ", "ga"),
    listOf("ぎ", "ギ", "gi"),
    listOf("ぐ", "グ", "gu"),
    listOf("げ", "ゲ", "ge"),
    listOf("ご", "ゴ", "go"),
    listOf("ぎゃ", "ギャ", "gya"),
    listOf("ぎゅ", "ギュ", "gyu"),
    listOf("ぎょ", "ギョ", "gyo"),
    listOf("ざ", "ザ", "za"),
    listOf("じ", "ジ", "ji"),
    listOf("ず", "ズ", "zu"),
    listOf("ぜ", "ゼ", "ze"),
    listOf("ぞ", "ゾ", "zo"),
    listOf("じゃ", "ジャ", "ja"),
    listOf("じゅ", "ジュ", "ju"),
    listOf("じょ", "ジョ", "jo"),
    listOf("だ", "ダ", "da"),
    listOf("ぢ", "ヂ", "ji"),
    listOf("づ", "ヅ", "zu"),
    listOf("で", "デ", "de"),
    listOf("ど", "ド", "do"),
    listOf("ぢゃ", "ヂャ", "ja"),
    listOf("ぢゅ", "ヂュ", "ju"),
    listOf("ぢょ", "ヂョ", "jo"),
    listOf("ば", "バ", "ba"),
    listOf("び", "ビ", "bi"),
    listOf("ぶ", "ブ", "bu"),
    listOf("べ", "ベ", "be"),
    listOf("ぼ", "ボ", "bo"),
    listOf("びゃ", "ビャ", "bya"),
    listOf("びゅ", "ビュ", "byu"),
    listOf("びょ", "ビョ", "byo"),
    listOf("ぱ", "パ", "pa"),
    listOf("ぴ", "ピ", "pi"),
    listOf("ぷ", "プ", "pu"),
    listOf("ぺ", "ペ", "pe"),
    listOf("ぽ", "ポ", "po"),
    listOf("ぴゃ", "ピャ", "pya"),
    listOf("ぴゅ", "ピュ", "pyu"),
    listOf("ぴょ", "ピョ", "pyo"),
    // little kana
    listOf("ぁ", "ァ", "a"),
    listOf("ぃ", "ィ", "i"),
    listOf("ぅ", "ゥ", "u"),
    listOf("ぇ", "ェ", "e"),
    listOf("ぉ", "ォ", "o"),
    listOf("っ", "ッ", ""),
    listOf("ゃ", "ャ", "ya"),
    listOf("ゅ", "ュ", "yu"),
    listOf("ょ", "ョ", "yo"),
    // n
    listOf("ん", "ン", "n"),
    listOf("んん", "ンン", "nn"),
    listOf("あんない", "アンナイ", "annai"),
    listOf("ぐんま", "グンマ", "gunma"),
    // double consonants
    listOf("あった", "アッタ", "atta"),
    listOf("がっこうなかった", "ガッコウナカッタ", "gakkounakatta"),
    listOf("けっか", "ケッカ", "kekka"),
    listOf("さっさと", "サッサト", "sassato"),
    listOf("ずっと", "ズット", "zutto"),
    listOf("きっぷ", "キップ", "kippu"),
    listOf("ざっし", "ザッシ", "zasshi"),
    listOf("いっしょ", "イッショ", "issho"),
    listOf("こっち", "コッチ", "kotchi"),
    listOf("まっちゃ", "マッチャ", "matcha"),
    listOf("みっつ", "ミッツ", "mittsu"),
    listOf("ばっば", "バッバ", "babba"),
    listOf("かっか", "カッカ", "kakka"),
    listOf("ちゃっちゃ", "チャッチャ", "chatcha"),
    listOf("だっだ", "ダッダ", "dadda"),
    listOf("ふっふ", "フッフ", "fuffu"),
    listOf("がっが", "ガッガ", "gagga"),
    listOf("はっは", "ハッハ", "hahha"),
    listOf("じゃっじゃ", "ジャッジャ", "jajja"),
    listOf("かっか", "カッカ", "kakka"),
    listOf("まっま", "マッマ", "mamma"),
    listOf("なんな", "ナンナ", "nanna"),
    listOf("ぱっぱ", "パッパ", "pappa"),
    listOf("らっら", "ラッラ", "rarra"),
    listOf("さっさ", "サッサ", "sassa"),
    listOf("しゃっしゃ", "シャッシャ", "shassha"),
    listOf("たった", "タッタ", "tatta"),
    listOf("つっつ", "ツッツ", "tsuttsu"),
    listOf("わっわ", "ワッワ", "wawwa"),
    listOf("ざっざ", "ザッザ", "zazza"),
    // hira long vowels
    listOf("がっこう", "", "gakkou"),
    listOf("とうきょう", "", "toukyou"),
    listOf("べんきょう", "", "benkyou"),
    listOf("でんぽう", "", "denpou"),
    listOf("きんようび", "", "kin'youbi"),
    listOf ("こうし", "", "koushi"),
    // kata long vowels
    listOf("", "セーラー", "seeraa"),
    listOf("", "パーティー", "paateii"),
    listOf("", "ヒーター", "hiitaa"),
    listOf("", "タクシー", "takushii"),
    listOf("", "スーパーマン", "suupaaman"),
    listOf("", "バレーボール", "bareebooru"),
    listOf("", "ソール", "sooru"),
)
