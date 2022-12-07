package io.github.mosser.arduinoml.kernel.generator;

import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.structural.*;

import java.rmi.RemoteException;

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

		app.getStates().forEach(s -> {
			s.getTransitions().forEach(t -> {
				if (t.getExpression() instanceof TemporalExpression) {
					t.getExpression().accept(this);
				}
			});
		});

		//second pass, setup and loop
		context.put("pass",PASS.TWO);
		w("\nvoid setup(){\n");
		for (State state: app.getStates()) {
			//if we have at least one remote expression, we need to setup the remote
			for (Transition transition: state.getTransitions()) {
				if (transition.getExpression() instanceof RemoteExpression) {
					w("\tSerial.begin(9600);" + "\n");
					break;
				}
			}
		}
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
			w(expression.getCondition());
			return;
		}

	}

	@Override
	public void visit(UnaryExpression expression) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(expression.getCondition());
			return;
		}
	}

	@Override
	public void visit(TemporalExpression expression) {
		if(context.get("pass") == PASS.ONE) {
			w(String.format("long temporal_transition_%d = 0;\n", expression.getValue()));
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format("\t\t\tif(temporal_transition_%d = 0) \n\t\t\t\t temporal_transition_%d = millis();\n", expression.getValue(), expression.getValue()));
			w(String.format("\t\t\telse if((millis() - temporal_transition_%d) >= %d) {\n", expression.getValue(), expression.getValue()));
			w(String.format("\t\t\t\ttemporal_transition_%d = 0;\n", expression.getValue()));
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

	UnaryExpression getBinaryDeepestUnaryExpression(BinaryExpression expression){
		Expression ex = expression.getExpressions().get(0);
		if(ex instanceof UnaryExpression){
			return (UnaryExpression) ex;
		}
		return getBinaryDeepestUnaryExpression((BinaryExpression) ex);
	}

	@Override
	public void visit(RemoteExpression expression) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			w(String.format("\t\t\tif(Serial.available() > 0){\n" +
					"\t\t\t\tchar c = Serial.read();\n" +
					"\t\t\t\tif(c == '%c')\n", expression.getValue()));
			return;
		}
	}

	@Override
	public void visit(Transition transition) {
		if(context.get("pass") == PASS.ONE) {
			return;
		}
		if(context.get("pass") == PASS.TWO) {
			if (transition.getExpression() != null){
				if (transition.getExpression() instanceof UnaryExpression){
					String sensorName = ((UnaryExpression) transition.getExpression()).getSensor().getName();
					w(String.format("\t\t\t%sBounceGuard = millis() - %sLastDebounceTime > debounce;\n",
							sensorName, sensorName));

					w(String.format("\t\t\tif (%sBounceGuard && ", sensorName));
					transition.getExpression().accept(this);
					w(String.format(") {\n" +
							"\t\t\t\t%sLastDebounceTime = millis();\n" +
							"\t\t\t\tcurrentState = %s;\n" +
							"\t\t\t}\n", sensorName, transition.getNext().getName()));

				}
				else if(transition.getExpression() instanceof TemporalExpression) {
					transition.getExpression().accept(this);
					w(String.format("\t\t\t\tcurrentState = %s;\n", transition.getNext().getName()));
					w("\t\t\t}\n");
				}
				else if(transition.getExpression() instanceof RemoteExpression) {
					transition.getExpression().accept(this);
					w(String.format("\t\t\t\t\tcurrentState = %s;\n", transition.getNext().getName()));
					w("\t\t\t}\n");
				}
				else if (transition.getExpression() instanceof BinaryExpression) {
					//if each expression is a unary expression
					BinaryExpression binaryExpression = (BinaryExpression) transition.getExpression();
					for (Expression expression : binaryExpression.getExpressions()) {
						if(expression instanceof UnaryExpression || expression instanceof BinaryExpression){
							continue;
						}	else {
							return;
						}
					}

					String sensorName = getBinaryDeepestUnaryExpression((BinaryExpression) transition.getExpression()).getSensor().getName();

					w(String.format("\t\t\t%sBounceGuard = millis() - %sLastDebounceTime > debounce;\n",
								sensorName, sensorName));

					w(String.format("\t\t\tif (%sBounceGuard && ", sensorName));
						transition.getExpression().accept(this);
						w(String.format(") {\n" +
								"\t\t\t\t%sLastDebounceTime = millis();\n" +
								"\t\t\t\tcurrentState = %s;\n" +
								"\t\t\t}\n", sensorName, transition.getNext().getName()));
				}
			}
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
