// Wiring code generated from an ArduinoML model
// Application name: Dual-check alarm!

long debounce = 200;

enum STATE {on, off};
STATE currentState = off;

boolean button1BounceGuard = false;
long button1LastDebounceTime = 0;

boolean button2BounceGuard = false;
long button2LastDebounceTime = 0;

void setup(){
  pinMode(9, INPUT);  // button1 [Sensor]
  pinMode(10, INPUT);  // button2 [Sensor]
  pinMode(11, OUTPUT); // BUZZER [Actuator]
}

void loop() {
	switch(currentState){
		case on:
			digitalWrite(11,HIGH);
			BounceGuard = millis() - LastDebounceTime > debounce;
			if (BounceGuard && (digitalRead(9) == LOW || digitalRead(10) == LOW) digitalRead(10) == LOW)) {
				LastDebounceTime = millis();
				currentState = off;
			}
		break;
		case off:
			digitalWrite(11,LOW);
			BounceGuard = millis() - LastDebounceTime > debounce;
			if (BounceGuard && (digitalRead(9) == HIGH && digitalRead(10) == HIGH) digitalRead(10) == HIGH)) {
				LastDebounceTime = millis();
				currentState = on;
			}
		break;
	}
}