package io.github.mosser.arduinoml.kernel.generator;

import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.structural.*;
import io.github.mosser.arduinoml.kernel.App;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

	public abstract void visit(App app);

	public abstract void visit(State state);
	public abstract void visit(Transition transition);
	public abstract void visit(Action action);

	public abstract void visit(Actuator actuator);
	public abstract void visit(Sensor sensor);

	public abstract void visit(BinaryExpression expression);
	public abstract void visit(UnaryExpression expression);
	public abstract void visit(TemporalExpression expression);
	public abstract void visit(RemoteExpression	 expression);


	/***********************
	 ** Helper mechanisms **
	 ***********************/

	protected Map<String,Object> context = new HashMap<>();

	protected T result;

	public T getResult() {
		return result;
	}

	public void generateInoFile() throws IOException {
		String filename = "generated_" + System.currentTimeMillis() + ".ino";
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/generated/"+filename));
		writer.write(result.toString());
		writer.flush();
		writer.close();
	}

}

