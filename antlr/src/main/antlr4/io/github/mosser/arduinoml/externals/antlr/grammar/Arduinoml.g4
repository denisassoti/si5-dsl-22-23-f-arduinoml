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
    transition  :   expression=abstractExpression '=>' next=IDENTIFIER ;
    initial     :   '->';

abstractExpression  :  unaryExpression | binaryExpression | temporalExpression;
unaryExpression   :   trigger=IDENTIFIER 'is' value=SIGNAL;
binaryExpression  :   left=unaryExpression operator=OPERATOR right=unaryExpression;
temporalExpression :   'after' duration=INTEGER 'ms';

/*****************
 ** Lexer rules **
 *****************/

PORT_NUMBER     :   [1-9] | '10' | '11' | '12';
INTEGER         :   [0-9]+;
IDENTIFIER      :   LOWERCASE (LOWERCASE|UPPERCASE|DIGITS)+;
SIGNAL          :   'HIGH' | 'LOW';
OPERATOR         :   'AND' | 'OR';


/*************
 ** Helpers **
 *************/

fragment LOWERCASE  : [a-z];                                 // abstract rule, does not really exists
fragment UPPERCASE  : [A-Z];
fragment DIGITS: [0-9];
NEWLINE             : ('\r'? '\n' | '\r')+      -> skip;
WS                  : ((' ' | '\t')+)           -> skip;     // who cares about whitespaces?
COMMENT             : '#' ~( '\r' | '\n' )*     -> skip;     // Single line comments, starting with a #
