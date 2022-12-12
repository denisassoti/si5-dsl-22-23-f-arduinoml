// Generated from java-escape by ANTLR 4.11.1
package io.github.mosser.arduinoml.externals.antlr.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ArduinomlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, PORT_NUMBER=16, 
		INTEGER=17, IDENTIFIER=18, SIGNAL=19, OPERATOR=20, ALPHANUMERIC=21, NEWLINE=22, 
		WS=23, COMMENT=24;
	public static final int
		RULE_root = 0, RULE_declaration = 1, RULE_bricks = 2, RULE_sensor = 3, 
		RULE_actuator = 4, RULE_location = 5, RULE_states = 6, RULE_state = 7, 
		RULE_action = 8, RULE_transition = 9, RULE_initial = 10, RULE_expression = 11, 
		RULE_unaryExpression = 12, RULE_temporalExpression = 13, RULE_remoteExpression = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "declaration", "bricks", "sensor", "actuator", "location", "states", 
			"state", "action", "transition", "initial", "expression", "unaryExpression", 
			"temporalExpression", "remoteExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'application'", "'sensor'", "'actuator'", "':'", "'{'", "'}'", 
			"'<='", "'=>'", "'->'", "'('", "')'", "'is'", "'after'", "'ms'", "'key'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "PORT_NUMBER", "INTEGER", "IDENTIFIER", "SIGNAL", 
			"OPERATOR", "ALPHANUMERIC", "NEWLINE", "WS", "COMMENT"
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

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArduinomlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BricksContext bricks() {
			return getRuleContext(BricksContext.class,0);
		}
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ArduinomlParser.EOF, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			declaration();
			setState(31);
			bricks();
			setState(32);
			states();
			setState(33);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__0);
			setState(36);
			((DeclarationContext)_localctx).name = match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BricksContext extends ParserRuleContext {
		public List<SensorContext> sensor() {
			return getRuleContexts(SensorContext.class);
		}
		public SensorContext sensor(int i) {
			return getRuleContext(SensorContext.class,i);
		}
		public List<ActuatorContext> actuator() {
			return getRuleContexts(ActuatorContext.class);
		}
		public ActuatorContext actuator(int i) {
			return getRuleContext(ActuatorContext.class,i);
		}
		public BricksContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bricks; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterBricks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitBricks(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitBricks(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BricksContext bricks() throws RecognitionException {
		BricksContext _localctx = new BricksContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bricks);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(40);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(38);
					sensor();
					}
					break;
				case T__2:
					{
					setState(39);
					actuator();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 || _la==T__2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SensorContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public SensorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterSensor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitSensor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitSensor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SensorContext sensor() throws RecognitionException {
		SensorContext _localctx = new SensorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sensor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__1);
			setState(45);
			location();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActuatorContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ActuatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actuator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterActuator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitActuator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitActuator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActuatorContext actuator() throws RecognitionException {
		ActuatorContext _localctx = new ActuatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_actuator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__2);
			setState(48);
			location();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocationContext extends ParserRuleContext {
		public Token id;
		public Token port;
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public TerminalNode PORT_NUMBER() { return getToken(ArduinomlParser.PORT_NUMBER, 0); }
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((LocationContext)_localctx).id = match(IDENTIFIER);
			setState(51);
			match(T__3);
			setState(52);
			((LocationContext)_localctx).port = match(PORT_NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatesContext extends ParserRuleContext {
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterStates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitStates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitStates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				state();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__8 || _la==IDENTIFIER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateContext extends ParserRuleContext {
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public InitialContext initial() {
			return getRuleContext(InitialContext.class,0);
		}
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_state);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(59);
				initial();
				}
			}

			setState(62);
			((StateContext)_localctx).name = match(IDENTIFIER);
			setState(63);
			match(T__4);
			setState(65); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(64);
					action();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(67); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 304128L) != 0) {
				{
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(69);
					transition();
					}
					}
					setState(72); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 304128L) != 0 );
				}
			}

			setState(76);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActionContext extends ParserRuleContext {
		public Token receiver;
		public Token value;
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public TerminalNode SIGNAL() { return getToken(ArduinomlParser.SIGNAL, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			((ActionContext)_localctx).receiver = match(IDENTIFIER);
			setState(79);
			match(T__6);
			setState(80);
			((ActionContext)_localctx).value = match(SIGNAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TransitionContext extends ParserRuleContext {
		public ExpressionContext exp;
		public Token next;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitTransition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitTransition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			((TransitionContext)_localctx).exp = expression();
			setState(83);
			match(T__7);
			setState(84);
			((TransitionContext)_localctx).next = match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitialContext extends ParserRuleContext {
		public InitialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterInitial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitInitial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitInitial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialContext initial() throws RecognitionException {
		InitialContext _localctx = new InitialContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_initial);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OPERATOR() { return getToken(ArduinomlParser.OPERATOR, 0); }
		public TemporalExpressionContext temporalExpression() {
			return getRuleContext(TemporalExpressionContext.class,0);
		}
		public RemoteExpressionContext remoteExpression() {
			return getRuleContext(RemoteExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				unaryExpression();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(T__9);
				setState(90);
				((ExpressionContext)_localctx).left = expression();
				setState(91);
				((ExpressionContext)_localctx).operator = match(OPERATOR);
				setState(92);
				((ExpressionContext)_localctx).right = expression();
				setState(93);
				match(T__10);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				temporalExpression();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				remoteExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ParserRuleContext {
		public Token trigger;
		public Token value;
		public TerminalNode IDENTIFIER() { return getToken(ArduinomlParser.IDENTIFIER, 0); }
		public TerminalNode SIGNAL() { return getToken(ArduinomlParser.SIGNAL, 0); }
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_unaryExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			((UnaryExpressionContext)_localctx).trigger = match(IDENTIFIER);
			setState(100);
			match(T__11);
			setState(101);
			((UnaryExpressionContext)_localctx).value = match(SIGNAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemporalExpressionContext extends ParserRuleContext {
		public Token duration;
		public TerminalNode INTEGER() { return getToken(ArduinomlParser.INTEGER, 0); }
		public TemporalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterTemporalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitTemporalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitTemporalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalExpressionContext temporalExpression() throws RecognitionException {
		TemporalExpressionContext _localctx = new TemporalExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_temporalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__12);
			setState(104);
			((TemporalExpressionContext)_localctx).duration = match(INTEGER);
			setState(105);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RemoteExpressionContext extends ParserRuleContext {
		public Token key;
		public TerminalNode ALPHANUMERIC() { return getToken(ArduinomlParser.ALPHANUMERIC, 0); }
		public RemoteExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remoteExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).enterRemoteExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduinomlListener ) ((ArduinomlListener)listener).exitRemoteExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduinomlVisitor ) return ((ArduinomlVisitor<? extends T>)visitor).visitRemoteExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RemoteExpressionContext remoteExpression() throws RecognitionException {
		RemoteExpressionContext _localctx = new RemoteExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_remoteExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__14);
			setState(108);
			((RemoteExpressionContext)_localctx).key = match(ALPHANUMERIC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018o\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0004\u0002)\b\u0002\u000b\u0002\f\u0002*\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u00068\b"+
		"\u0006\u000b\u0006\f\u00069\u0001\u0007\u0003\u0007=\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0004\u0007B\b\u0007\u000b\u0007\f\u0007C\u0001"+
		"\u0007\u0004\u0007G\b\u0007\u000b\u0007\f\u0007H\u0003\u0007K\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000bb\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0000"+
		"\u0000\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u0000\u0000i\u0000\u001e\u0001\u0000\u0000\u0000\u0002"+
		"#\u0001\u0000\u0000\u0000\u0004(\u0001\u0000\u0000\u0000\u0006,\u0001"+
		"\u0000\u0000\u0000\b/\u0001\u0000\u0000\u0000\n2\u0001\u0000\u0000\u0000"+
		"\f7\u0001\u0000\u0000\u0000\u000e<\u0001\u0000\u0000\u0000\u0010N\u0001"+
		"\u0000\u0000\u0000\u0012R\u0001\u0000\u0000\u0000\u0014V\u0001\u0000\u0000"+
		"\u0000\u0016a\u0001\u0000\u0000\u0000\u0018c\u0001\u0000\u0000\u0000\u001a"+
		"g\u0001\u0000\u0000\u0000\u001ck\u0001\u0000\u0000\u0000\u001e\u001f\u0003"+
		"\u0002\u0001\u0000\u001f \u0003\u0004\u0002\u0000 !\u0003\f\u0006\u0000"+
		"!\"\u0005\u0000\u0000\u0001\"\u0001\u0001\u0000\u0000\u0000#$\u0005\u0001"+
		"\u0000\u0000$%\u0005\u0012\u0000\u0000%\u0003\u0001\u0000\u0000\u0000"+
		"&)\u0003\u0006\u0003\u0000\')\u0003\b\u0004\u0000(&\u0001\u0000\u0000"+
		"\u0000(\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*(\u0001\u0000"+
		"\u0000\u0000*+\u0001\u0000\u0000\u0000+\u0005\u0001\u0000\u0000\u0000"+
		",-\u0005\u0002\u0000\u0000-.\u0003\n\u0005\u0000.\u0007\u0001\u0000\u0000"+
		"\u0000/0\u0005\u0003\u0000\u000001\u0003\n\u0005\u00001\t\u0001\u0000"+
		"\u0000\u000023\u0005\u0012\u0000\u000034\u0005\u0004\u0000\u000045\u0005"+
		"\u0010\u0000\u00005\u000b\u0001\u0000\u0000\u000068\u0003\u000e\u0007"+
		"\u000076\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u000097\u0001\u0000"+
		"\u0000\u00009:\u0001\u0000\u0000\u0000:\r\u0001\u0000\u0000\u0000;=\u0003"+
		"\u0014\n\u0000<;\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>?\u0005\u0012\u0000\u0000?A\u0005\u0005\u0000\u0000"+
		"@B\u0003\u0010\b\u0000A@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DJ\u0001\u0000\u0000"+
		"\u0000EG\u0003\u0012\t\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0001\u0000"+
		"\u0000\u0000JF\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000LM\u0005\u0006\u0000\u0000M\u000f\u0001\u0000\u0000"+
		"\u0000NO\u0005\u0012\u0000\u0000OP\u0005\u0007\u0000\u0000PQ\u0005\u0013"+
		"\u0000\u0000Q\u0011\u0001\u0000\u0000\u0000RS\u0003\u0016\u000b\u0000"+
		"ST\u0005\b\u0000\u0000TU\u0005\u0012\u0000\u0000U\u0013\u0001\u0000\u0000"+
		"\u0000VW\u0005\t\u0000\u0000W\u0015\u0001\u0000\u0000\u0000Xb\u0003\u0018"+
		"\f\u0000YZ\u0005\n\u0000\u0000Z[\u0003\u0016\u000b\u0000[\\\u0005\u0014"+
		"\u0000\u0000\\]\u0003\u0016\u000b\u0000]^\u0005\u000b\u0000\u0000^b\u0001"+
		"\u0000\u0000\u0000_b\u0003\u001a\r\u0000`b\u0003\u001c\u000e\u0000aX\u0001"+
		"\u0000\u0000\u0000aY\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"a`\u0001\u0000\u0000\u0000b\u0017\u0001\u0000\u0000\u0000cd\u0005\u0012"+
		"\u0000\u0000de\u0005\f\u0000\u0000ef\u0005\u0013\u0000\u0000f\u0019\u0001"+
		"\u0000\u0000\u0000gh\u0005\r\u0000\u0000hi\u0005\u0011\u0000\u0000ij\u0005"+
		"\u000e\u0000\u0000j\u001b\u0001\u0000\u0000\u0000kl\u0005\u000f\u0000"+
		"\u0000lm\u0005\u0015\u0000\u0000m\u001d\u0001\u0000\u0000\u0000\b(*9<"+
		"CHJa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}