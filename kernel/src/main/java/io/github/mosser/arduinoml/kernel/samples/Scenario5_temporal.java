package io.github.mosser.arduinoml.kernel.samples;

import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.generator.ToWiring;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.Actuator;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;
import io.github.mosser.arduinoml.kernel.structural.Sensor;

import java.io.IOException;
import java.util.Arrays;

public class Scenario5_temporal {

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
		Action switchLightOn = new Action();
		switchLightOn.setActuator(led);
		switchLightOn.setValue(SIGNAL.HIGH);


		Action switchLightOff = new Action();
		switchLightOff.setActuator(led);
		switchLightOff.setValue(SIGNAL.LOW);

		off.setActions(Arrays.asList(switchLightOff));
		on.setActions(Arrays.asList(switchLightOn));


		// Creating transitions
		Transition t1 = new Transition();
		t1.setNext(on);
			UnaryExpression exp1 = new UnaryExpression();
			exp1.setSensor(button);
			exp1.setValue(SIGNAL.HIGH);
		t1.setExpression(exp1);

		Transition  t2 = new Transition();
		t2.setNext(off);
			TemporalExpression exp2 = new TemporalExpression();
			exp2.setValue(10000);
		t2.setExpression(exp2);

		// Binding transitions to states
		off.setTransitions(Arrays.asList(t1));
		on.setTransitions(Arrays.asList(t2));

		// Building the App
		App theSimpleAlarm = new App();
		theSimpleAlarm.setName("Temporal");
		theSimpleAlarm.setBricks(Arrays.asList(button, led));
		theSimpleAlarm.setStates(Arrays.asList(on, off));
		theSimpleAlarm.setInitial(off);

		// Generating Code
		Visitor codeGenerator = new ToWiring();
		theSimpleAlarm.accept(codeGenerator);

		// generate the target code and write it into a file

		System.out.println(codeGenerator.getResult());
		//codeGenerator.generateInoFile();
	}

}
