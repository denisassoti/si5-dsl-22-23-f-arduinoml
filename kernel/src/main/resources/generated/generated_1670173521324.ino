// Wiring code generated from an ArduinoML model
// Application name: Temporal

long debounce = 200;

enum STATE {on, off};
STATE currentState = off;

boolean buttonBounceGuard = false;
long buttonLastDebounceTime = 0;
long temporal_transition_10000 = 0;

void setup(){
  pinMode(9, INPUT);  // button [Sensor]
  pinMode(12, OUTPUT); // LED [Actuator]
}

void loop() {
	switch(currentState){
		case on:
			digitalWrite(12,HIGH);
			if(temporal_transition_10000 = 0) 
				 temporal_transition_10000 = millis();
			else if((10000 + temporal_transition_10000) <= millis()) {
				temporal_transition_10000 = 0;
				currentState = off;
			}
		break;
		case off:
			digitalWrite(12,LOW);
			buttonBounceGuard = millis() - buttonLastDebounceTime > debounce;
			if (buttonBounceGuard && digitalRead(9) == HIGH) {
				buttonLastDebounceTime = millis();
				currentState = on;
			}
		break;
	}
}