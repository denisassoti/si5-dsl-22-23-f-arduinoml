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

public class Scenario2 {

	public static void main(String[] args) throws IOException {

		// Declaring elementary bricks
		Sensor button1 = new Sensor();
		button1.setName("button1");
		button1.setPin(9);

		Sensor button3 = new Sensor();
		button1.setName("button3");
		button1.setPin(11);

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
		exp2.setSensor(button2);
		exp2.setValue(SIGNAL.HIGH);

		BinaryExpression exp3 = new BinaryExpression();
		exp3.setExpressions(Arrays.asList(exp1, exp2));
		exp3.setOperator(OPERATOR.AND);

		UnaryExpression expr4 = new UnaryExpression();
		expr4.setSensor(button3);
		expr4.setValue(SIGNAL.HIGH);

		BinaryExpression expr5 = new BinaryExpression();
		expr5.setExpressions(Arrays.asList(exp3, expr4));
		expr5.setOperator(OPERATOR.OR);

		off2On.setExpression(expr5);

		Transition on2Off = new Transition();
		on2Off.setNext(off);
		UnaryExpression exp4 = new UnaryExpression();
		exp4.setSensor(button1);
		exp4.setValue(SIGNAL.LOW);

		UnaryExpression exp5 = new UnaryExpression();
		exp5.setSensor(button2);
		exp5.setValue(SIGNAL.LOW);

		BinaryExpression exp6 = new BinaryExpression();
		exp6.setExpressions(Arrays.asList(exp4, exp5));
		exp6.setOperator(OPERATOR.OR);

		on2Off.setExpression(exp6);

		// Binding transitions to states
		off.setTransitions(Arrays.asList(off2On));
		on.setTransitions(Arrays.asList(on2Off));

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
