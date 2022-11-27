package io.github.mosser.arduinoml.kernel.samples;

import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.Action;
import io.github.mosser.arduinoml.kernel.behavioral.State;
import io.github.mosser.arduinoml.kernel.behavioral.Transition;
import io.github.mosser.arduinoml.kernel.behavioral.UnaryExpression;
import io.github.mosser.arduinoml.kernel.generator.ToWiring;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.Actuator;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;
import io.github.mosser.arduinoml.kernel.structural.Sensor;

import java.io.IOException;
import java.util.Arrays;

public class Scenario1 {

	public static void main(String[] args) throws IOException {

		// Declaring elementary bricks
		Sensor button = new Sensor();
		button.setName("button");
		button.setPin(9);

		Actuator led = new Actuator();
		led.setName("LED");
		led.setPin(12);

		Actuator buzzer = new Actuator();
		buzzer.setName("BUZZER");
		buzzer.setPin(6);

		// Declaring states
		State on = new State();
		on.setName("on");

		State off = new State();
		off.setName("off");

		// Creating actions
		Action switchLightOn = new Action();
		switchLightOn.setActuator(led);
		switchLightOn.setValue(SIGNAL.HIGH);

		Action switchBuzzerOn = new Action();
		switchBuzzerOn.setActuator(buzzer);
		switchBuzzerOn.setValue(SIGNAL.HIGH);

		Action switchLightOff = new Action();
		switchLightOff.setActuator(led);
		switchLightOff.setValue(SIGNAL.LOW);

		Action switchBuzzerOff = new Action();
		switchBuzzerOff.setActuator(buzzer);
		switchBuzzerOff.setValue(SIGNAL.LOW);

		// Binding actions to states
		on.setActions(Arrays.asList(switchLightOn, switchBuzzerOn));
		off.setActions(Arrays.asList(switchLightOff, switchBuzzerOff));

		// Creating transitions
		Transition t1 = new Transition();
		t1.setNext(on);
			UnaryExpression exp1 = new UnaryExpression();
			exp1.setSensor(button);
			exp1.setValue(SIGNAL.HIGH);
		t1.setExpressions(Arrays.asList(exp1));

		Transition  t2 = new Transition();
		t2.setNext(off);
			UnaryExpression exp2 = new UnaryExpression();
			exp2.setSensor(button);
			exp2.setValue(SIGNAL.LOW);
		t2.setExpressions(Arrays.asList(exp2));

		// Binding transitions to states
		off.setTransitions(Arrays.asList(t1));
		on.setTransitions(Arrays.asList(t2));

		// Building the App
		App theSimpleAlarm = new App();
		theSimpleAlarm.setName("Very simple alarm!");
		theSimpleAlarm.setBricks(Arrays.asList(button, led, buzzer));
		theSimpleAlarm.setStates(Arrays.asList(on, off));
		theSimpleAlarm.setInitial(off);

		// Generating Code
		Visitor codeGenerator = new ToWiring();
		theSimpleAlarm.accept(codeGenerator);

		// generate the target code and write it into a file
		codeGenerator.generateInoFile();
	}

}
