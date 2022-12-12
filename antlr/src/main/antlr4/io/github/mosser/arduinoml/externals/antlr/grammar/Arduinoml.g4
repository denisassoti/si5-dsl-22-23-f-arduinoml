grammar Arduinoml;


/******************
 ** Parser rules **
 ******************/

root            :   declaration bricks states EOF;

declaration     :   'application' name=IDENTIFIER;

bricks          :   (sensor|actuator)+;
    sensor      :   'sensor'   location ;
    actuator    :   'actuator' location ;
    location    :   id=IDENTIFIER ':' port=PORT_NUMBER;

states          :   state+;
    state       :   initial? name=IDENTIFIER '{'  action+ (transition+)? '}';
    action      :   receiver=IDENTIFIER '<=' value=SIGNAL;
    transition  :   exp=expression '=>' next=IDENTIFIER ;
    initial     :   '->';

expression  :  unaryExpression | '('left=expression operator=OPERATOR right=expression')' |temporalExpression | remoteExpression;
unaryExpression   :   trigger=IDENTIFIER 'is' value=SIGNAL;
temporalExpression :   'after' duration=INTEGER 'ms';
remoteExpression: 'key' key=ALPHANUMERIC;

/*****************
 ** Lexer rules **
 *****************/

PORT_NUMBER     :   [1-9] | '10' | '11' | '12';
INTEGER         :   [0-9]+;
IDENTIFIER      :   LOWERCASE (LOWERCASE|UPPERCASE|DIGITS)+;
SIGNAL          :   'HIGH' | 'LOW';
OPERATOR        :   'AND' | 'OR';
// authorize ' in the name of the key
ALPHANUMERIC    :   [a-zA-Z0-9_']+;

/*************
 ** Helpers **
 *************/

fragment LOWERCASE  : [a-z];                                 // abstract rule, does not really exists
fragment UPPERCASE  : [A-Z];
fragment DIGITS: [0-9];
NEWLINE             : ('\r'? '\n' | '\r')+      -> skip;
WS                  : ((' ' | '\t')+)           -> skip;     // who cares about whitespaces?
COMMENT             : '#' ~( '\r' | '\n' )*     -> skip;     // Single line comments, starting with a #
