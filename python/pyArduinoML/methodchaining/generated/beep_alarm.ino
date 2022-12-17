// generated by ArduinoML

int BUTTON = 9;
int LED = 12;
int BUZZER = 11;
int first = 1;

void setup() {
	pinMode(BUTTON, INPUT);
	pinMode(LED, OUTPUT);
	pinMode(BUZZER, OUTPUT);
}

int state = LOW; int prev = HIGH;
long time = 0; long debounce = 200;

void state_off() {
	digitalWrite(LED, LOW);
	boolean guard =  millis() - time > debounce;
	if (first){
		for (int i = 0; i < 3; i++) { tone(BUZZER, 1000, 300); delay(300); noTone(BUZZER); delay(100); }
		first = 0;
	}
	if (digitalRead(BUTTON) == HIGH && guard) {
		first = 1; time = millis(); state_on();
	} else {
		state_off();
	}
}

void state_on() {
	digitalWrite(LED, HIGH);
	boolean guard =  millis() - time > debounce;
	if (first){
		for (int i = 0; i < 1; i++) { tone(BUZZER, 1000, 1000); delay(1000); noTone(BUZZER); delay(100); }
		first = 0;
	}
	exit(0);
}

void loop() { state_off(); }
