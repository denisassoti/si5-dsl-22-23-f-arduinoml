package io.github.mosser.arduinoml.kernel.samples;

import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.generator.ToWiring;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Switch {

	public static void main(String[] args) throws IOException {

		// Declaring elementary bricks
		Sensor button = new Sensor();
		button.setName("button");
		button.setPin(9);

		Actuator led = new Actuator();
		led.setName("LED");
		led.setPin(12);

		// Declaring states
		State on = new State();
		on.setName("on");

		State off = new State();
		off.setName("off");

		// Creating actions
		Action switchTheLightOn = new Action();
		switchTheLightOn.setActuator(led);
		switchTheLightOn.setValue(SIGNAL.HIGH);

		Action switchTheLightOff = new Action();
		switchTheLightOff.setActuator(led);
		switchTheLightOff.setValue(SIGNAL.LOW);

		// Binding actions to states
		on.setActions(Arrays.asList(switchTheLightOn));
		off.setActions(Arrays.asList(switchTheLightOff));

		// Creating transitions
		Transition on2off = new Transition();
		on2off.setNext(off);
			UnaryExpression expression = new UnaryExpression();
			expression.setSensor(button);
			expression.setValue(SIGNAL.HIGH);
		on2off.setExpressions(Arrays.asList(expression));

		Transition off2on = new Transition();
		off2on.setNext(on);
			UnaryExpression expression2 = new UnaryExpression();
			expression2.setSensor(button);
			expression2.setValue(SIGNAL.HIGH);
		off2on.setExpressions(Arrays.asList(expression2));

		// Binding transitions to states
		on.setTransitions(Arrays.asList(on2off));
		off.setTransitions(Arrays.asList(off2on));

		// Building the App
		App theSwitch = new App();
		theSwitch.setName("Switch!");
		theSwitch.setBricks(Arrays.asList(button, led ));
		theSwitch.setStates(Arrays.asList(on, off));
		theSwitch.setInitial(off);

		// Generating Code
		Visitor codeGenerator = new ToWiring();
		theSwitch.accept(codeGenerator);

		// generate the target code and write it into a file
		codeGenerator.generateInoFile();
	}

}
