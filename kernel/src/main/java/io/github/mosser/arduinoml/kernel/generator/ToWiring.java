package io.github.mosser.arduinoml.kernel.generator;

import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.structural.*;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<StringBuffer> {
	enum PASS {ONE, TWO}


	public ToWiring() {
		this.result = new StringBuffer();
	}

	private void w(String s) {
		result.append(String.format("%s",s));
	}

	@Override
	public void visit(App app) {
		//first pass, create global vars
		context.put("pass", PASS.ONE);
		w("// Wiring code generated from an ArduinoML model\n");
		w(String.format("// Application name: %s\n", app.getName())+"\n");

		w("long debounce = 200;\n");
		w("\nenum STATE {");
		String sep ="";
		for(State state: app.getStates()){
			w(sep);
			state.accept(this);
			sep=", ";
		}
		w("};\n");
		if (app.getInitial() != null) {
			w("STATE currentState = " + app.getInitial().getName()+";\n");
		}

		for(Brick brick: app.getBricks()){
			brick.accept(this);
		}

		//second pass, setup and loop
		context.put("pass",PASS.TWO);
		w("\nvoid setup(){\n");
		for(Brick brick: app.getBricks()){
			brick.accept(this);
		}
		w("}\n");

		w("\nvoid loop() {\n" +
			"\tswitch(currentState){\n");
		for(State state: app.getStates()){
			state.accept(this);
		}
		w("\t}\n" +
			"}");
	}

	@Override
	public void visit(Actuator actuator) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format("  pinMode(%d, OUTPUT); // %s [Actuator]\n", actuator.getPin(), actuator.getName()));
			return;
		}
	}


	@Override
	public void visit(Sensor sensor) {
		if(context.get("pass") == PASS.ONE) {
			w(String.format("\nboolean %sBounceGuard = false;\n", sensor.getName()));
			w(String.format("long %sLastDebounceTime = 0;\n", sensor.getName()));
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format("  pinMode(%d, INPUT);  // %s [Sensor]\n", sensor.getPin(), sensor.getName()));
			return;
		}
	}

	@Override
	public void visit(BinaryExpression expression) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w("(");
			expression.getExpressions().get(0).accept(this);
			w(" ");
			if (expression.getOperator() == OPERATOR.AND) {
				w("&&");
			}
			if (expression.getOperator() == OPERATOR.OR) {
				w("||");
			}
			w(" ");
			expression.getExpressions().get(1).accept(this);
			w(")");
			return;
		}

	}

	@Override
	public void visit(UnaryExpression expression) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			String sensorName = expression.getSensor().getName();
			w(String.format("digitalRead(%d) == %s", expression.getSensor().getPin(), expression.getValue()));
			return;
		}
	}

	@Override
	public void visit(State state) {
		if(context.get("pass") == PASS.ONE){
			w(state.getName());
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w("\t\tcase " + state.getName() + ":\n");
			for (Action action : state.getActions()) {
				action.accept(this);
			}
			for (Transition transition : state.getTransitions()) {
				transition.accept(this);
			}
			w("\t\tbreak;\n");
			return;
		}

	}

	@Override
	public void visit(Transition transition) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			Expression firstExpression = transition.getExpressions().get(0);
			//get the first sensor name for the debounce guard
			String firstSensorName = "";
			if (firstExpression instanceof UnaryExpression) {
				firstSensorName = ((UnaryExpression) firstExpression).getSensor().getName();
			}
			if (firstExpression instanceof BinaryExpression) {
				firstSensorName = ((BinaryExpression) firstExpression).getExpressions().get(0).getSensor().getName();
			}

			w(String.format("\t\t\t%sBounceGuard = millis() - %sLastDebounceTime > debounce;\n",
					firstSensorName, firstSensorName));
			w(String.format("\t\t\tif (%sBounceGuard && (", firstSensorName));
			for (int i = 0; i < transition.getExpressions().size(); i++) {
				transition.getExpressions().get(i).accept(this);
			}
			w(String.format(")) {\n" +
					"\t\t\t\t%sLastDebounceTime = millis();\n" +
					"\t\t\t\tcurrentState = %s;\n" +
					"\t\t\t}\n", firstSensorName, transition.getNext().getName()));
			return;
		}
	}

	@Override
	public void visit(Action action) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format("\t\t\tdigitalWrite(%d,%s);\n",action.getActuator().getPin(),action.getValue()));
			return;
		}
	}

}
