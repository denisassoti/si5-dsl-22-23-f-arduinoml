grammar ArduinoMl

terminal PORT_NUMBER     :   /[1-9]/+;
terminal SIGNAL          :   'HIGH' | 'LOW';


hidden terminal WS: /\s+/;
terminal ID: /[_a-zA-Z][\w_]*/;

hidden terminal ML_COMMENT: /\/\*[\s\S]*?\*\//;
hidden terminal SL_COMMENT: /\/\/[^\n\r]*/;


entry Model: Declaration (bricks+=Brick | states+=State)*;

Declaration: 'application' name=ID;

Brick          :   Sensor|Actuator;
    Sensor      :   'sensor'   Location ;
    Actuator    :   'actuator' Location ;
    Location    :   id=ID ':' port=PORT_NUMBER;

State          :   '->'? name=ID '{'  (actions+=Action)+ Transition '}';
    Action      :   receiver=ID '<=' value=SIGNAL;
    Transition  :   trigger=ID 'is' value=SIGNAL '=>' next=ID ;

