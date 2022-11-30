// Generated from java-escape by ANTLR 4.11.1
package io.github.mosser.arduinoml.externals.antlr.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ArduinomlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, PORT_NUMBER=11, IDENTIFIER=12, SIGNAL=13, OPERATOR=14, NEWLINE=15, 
		WS=16, COMMENT=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "PORT_NUMBER", "IDENTIFIER", "SIGNAL", "OPERATOR", "LOWERCASE", 
			"UPPERCASE", "NEWLINE", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'application'", "'sensor'", "'actuator'", "':'", "'{'", "'}'", 
			"'<='", "'=>'", "'->'", "'is'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "PORT_NUMBER", 
			"IDENTIFIER", "SIGNAL", "OPERATOR", "NEWLINE", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ArduinomlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Arduinoml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0011\u0092\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n[\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0004"+
		"\u000b`\b\u000b\u000b\u000b\f\u000ba\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\fk\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\rr\b\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0003\u0010y\b\u0010\u0001\u0010\u0001\u0010\u0004\u0010}\b\u0010"+
		"\u000b\u0010\f\u0010~\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011"+
		"\u0084\b\u0011\u000b\u0011\f\u0011\u0085\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u008c\b\u0012\n\u0012\f\u0012\u008f\t\u0012"+
		"\u0001\u0012\u0001\u0012\u0000\u0000\u0013\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u0000\u001f\u0000!\u000f"+
		"#\u0010%\u0011\u0001\u0000\u0005\u0001\u000019\u0001\u0000az\u0001\u0000"+
		"AZ\u0002\u0000\t\t  \u0002\u0000\n\n\r\r\u009a\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0001\'\u0001"+
		"\u0000\u0000\u0000\u00033\u0001\u0000\u0000\u0000\u0005:\u0001\u0000\u0000"+
		"\u0000\u0007C\u0001\u0000\u0000\u0000\tE\u0001\u0000\u0000\u0000\u000b"+
		"G\u0001\u0000\u0000\u0000\rI\u0001\u0000\u0000\u0000\u000fL\u0001\u0000"+
		"\u0000\u0000\u0011O\u0001\u0000\u0000\u0000\u0013R\u0001\u0000\u0000\u0000"+
		"\u0015Z\u0001\u0000\u0000\u0000\u0017\\\u0001\u0000\u0000\u0000\u0019"+
		"j\u0001\u0000\u0000\u0000\u001bq\u0001\u0000\u0000\u0000\u001ds\u0001"+
		"\u0000\u0000\u0000\u001fu\u0001\u0000\u0000\u0000!|\u0001\u0000\u0000"+
		"\u0000#\u0083\u0001\u0000\u0000\u0000%\u0089\u0001\u0000\u0000\u0000\'"+
		"(\u0005a\u0000\u0000()\u0005p\u0000\u0000)*\u0005p\u0000\u0000*+\u0005"+
		"l\u0000\u0000+,\u0005i\u0000\u0000,-\u0005c\u0000\u0000-.\u0005a\u0000"+
		"\u0000./\u0005t\u0000\u0000/0\u0005i\u0000\u000001\u0005o\u0000\u0000"+
		"12\u0005n\u0000\u00002\u0002\u0001\u0000\u0000\u000034\u0005s\u0000\u0000"+
		"45\u0005e\u0000\u000056\u0005n\u0000\u000067\u0005s\u0000\u000078\u0005"+
		"o\u0000\u000089\u0005r\u0000\u00009\u0004\u0001\u0000\u0000\u0000:;\u0005"+
		"a\u0000\u0000;<\u0005c\u0000\u0000<=\u0005t\u0000\u0000=>\u0005u\u0000"+
		"\u0000>?\u0005a\u0000\u0000?@\u0005t\u0000\u0000@A\u0005o\u0000\u0000"+
		"AB\u0005r\u0000\u0000B\u0006\u0001\u0000\u0000\u0000CD\u0005:\u0000\u0000"+
		"D\b\u0001\u0000\u0000\u0000EF\u0005{\u0000\u0000F\n\u0001\u0000\u0000"+
		"\u0000GH\u0005}\u0000\u0000H\f\u0001\u0000\u0000\u0000IJ\u0005<\u0000"+
		"\u0000JK\u0005=\u0000\u0000K\u000e\u0001\u0000\u0000\u0000LM\u0005=\u0000"+
		"\u0000MN\u0005>\u0000\u0000N\u0010\u0001\u0000\u0000\u0000OP\u0005-\u0000"+
		"\u0000PQ\u0005>\u0000\u0000Q\u0012\u0001\u0000\u0000\u0000RS\u0005i\u0000"+
		"\u0000ST\u0005s\u0000\u0000T\u0014\u0001\u0000\u0000\u0000U[\u0007\u0000"+
		"\u0000\u0000VW\u00051\u0000\u0000W[\u00051\u0000\u0000XY\u00051\u0000"+
		"\u0000Y[\u00052\u0000\u0000ZU\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000[\u0016\u0001\u0000\u0000\u0000\\_\u0003"+
		"\u001d\u000e\u0000]`\u0003\u001d\u000e\u0000^`\u0003\u001f\u000f\u0000"+
		"_]\u0001\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b\u0018\u0001"+
		"\u0000\u0000\u0000cd\u0005H\u0000\u0000de\u0005I\u0000\u0000ef\u0005G"+
		"\u0000\u0000fk\u0005H\u0000\u0000gh\u0005L\u0000\u0000hi\u0005O\u0000"+
		"\u0000ik\u0005W\u0000\u0000jc\u0001\u0000\u0000\u0000jg\u0001\u0000\u0000"+
		"\u0000k\u001a\u0001\u0000\u0000\u0000lm\u0005A\u0000\u0000mn\u0005N\u0000"+
		"\u0000nr\u0005D\u0000\u0000op\u0005O\u0000\u0000pr\u0005R\u0000\u0000"+
		"ql\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000r\u001c\u0001\u0000"+
		"\u0000\u0000st\u0007\u0001\u0000\u0000t\u001e\u0001\u0000\u0000\u0000"+
		"uv\u0007\u0002\u0000\u0000v \u0001\u0000\u0000\u0000wy\u0005\r\u0000\u0000"+
		"xw\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000z}\u0005\n\u0000\u0000{}\u0005\r\u0000\u0000|x\u0001\u0000\u0000"+
		"\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000"+
		"\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0006\u0010\u0000\u0000\u0081\"\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\u0007\u0003\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0006\u0011\u0000\u0000\u0088$\u0001\u0000\u0000\u0000\u0089"+
		"\u008d\u0005#\u0000\u0000\u008a\u008c\b\u0004\u0000\u0000\u008b\u008a"+
		"\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090"+
		"\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0006\u0012\u0000\u0000\u0091&\u0001\u0000\u0000\u0000\u000b\u0000Z_"+
		"ajqx|~\u0085\u008d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}