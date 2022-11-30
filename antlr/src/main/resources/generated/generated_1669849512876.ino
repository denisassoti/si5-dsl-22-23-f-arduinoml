// Wiring code generated from an ArduinoML model
// Application name: redButton

long debounce = 200;

enum STATE {on, on, off, off};
STATE currentState = off;

boolean buttonBounceGuard = false;
long buttonLastDebounceTime = 0;

void setup(){
  pinMode(9, INPUT);  // button [Sensor]
  pinMode(12, OUTPUT); // led [Actuator]
}

void loop() {
	switch(currentState){
		case on:
			digitalWrite(12,HIGH);
		break;
		case on:
			digitalWrite(12,HIGH);
		break;
		case off:
			digitalWrite(12,LOW);
		break;
		case off:
			digitalWrite(12,LOW);
		break;
	}
}