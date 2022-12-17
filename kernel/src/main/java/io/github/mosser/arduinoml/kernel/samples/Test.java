package io.github.mosser.arduinoml.kernel.samples;

import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.generator.ToWiring;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.Actuator;
import io.github.mosser.arduinoml.kernel.structural.OPERATOR;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;
import io.github.mosser.arduinoml.kernel.structural.Sensor;

import java.io.IOException;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws IOException {

		// Declaring elementary bricks
		Sensor button1 = new Sensor();
		button1.setName("button1");
		button1.setPin(9);

		Sensor button2 = new Sensor();
		button2.setName("button2");
		button2.setPin(10);

		Actuator buzzer = new Actuator();
		buzzer.setName("BUZZER");
		buzzer.setPin(11);

		// Declaring states
		State on = new State();
		on.setName("on");

		State off = new State();
		off.setName("off");

		// Creating actions
		Action triggerBuzzer = new Action();
		triggerBuzzer.setActuator(buzzer);
		triggerBuzzer.setValue(SIGNAL.HIGH);

		Action stopSound = new Action();
		stopSound.setActuator(buzzer);
		stopSound.setValue(SIGNAL.LOW);

		// Binding actions to states
		on.setActions(Arrays.asList(triggerBuzzer));
		off.setActions(Arrays.asList(stopSound));

		// Creating transitions
		Transition off2On = new Transition();
		off2On.setNext(on);
			UnaryExpression exp1 = new UnaryExpression();
			exp1.setSensor(button1);
			exp1.setValue(SIGNAL.HIGH);

			UnaryExpression exp2 = new UnaryExpression();
			exp1.setSensor(button2);
			exp1.setValue(SIGNAL.HIGH);


			BinaryExpression exp3 = new BinaryExpression();
			exp3.setExpressions(Arrays.asList(exp1, exp2));
			exp3.setOperator(OPERATOR.AND);

		off2On.setExpression(exp3);



		// Binding transitions to states
		off.setTransitions(Arrays.asList(off2On));

		// Building the App
		App theDualCheckAlarm = new App();
		theDualCheckAlarm.setName("Dual-check alarm!");
		theDualCheckAlarm.setBricks(Arrays.asList(button1, button2, buzzer));
		theDualCheckAlarm.setStates(Arrays.asList(on, off));
		theDualCheckAlarm.setInitial(off);

		// Generating Code
		Visitor codeGenerator = new ToWiring();
		theDualCheckAlarm.accept(codeGenerator);

		System.out.println(codeGenerator.getResult());
	}

}
