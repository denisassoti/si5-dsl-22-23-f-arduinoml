package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.Sensor;

public class RemoteExpression implements Expression {

    private char value;


    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Expression getExpression() {
        return this;
    }

    @Override
    public String getCondition() {
        return "";
    }
}
