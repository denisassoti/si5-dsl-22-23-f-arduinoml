// Wiring code generated from an ArduinoML model
// Application name: Switch!

long debounce = 200;

enum STATE {on, off};
STATE currentState = off;

boolean buttonBounceGuard = false;
long buttonLastDebounceTime = 0;

void setup(){
  pinMode(9, INPUT);  // button [Sensor]
  pinMode(12, OUTPUT); // LED [Actuator]
  pinMode(6, OUTPUT); // BUZZER [Actuator]
}

void loop() {
	switch(currentState){
		case on:
			digitalWrite(12,HIGH);
			digitalWrite(6,HIGH);
			buttonBounceGuard = millis() - buttonLastDebounceTime > debounce;
			if (buttonBounceGuard && (digitalRead(9) == LOW)) {
				buttonLastDebounceTime = millis();
				currentState = off;
			}
		break;
		case off:
			digitalWrite(12,LOW);
			digitalWrite(6,LOW);
			buttonBounceGuard = millis() - buttonLastDebounceTime > debounce;
			if (buttonBounceGuard && (digitalRead(9) == HIGH)) {
				buttonLastDebounceTime = millis();
				currentState = on;
			}
		break;
	}
}