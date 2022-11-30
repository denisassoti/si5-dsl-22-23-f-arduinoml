package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.generator.Visitor;

public class TemporalExpression implements Expression{

    Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public Expression getExpression() {
        return this;
    }

    @Override
    public String getCondition() {
        return ""; // TODO : implement this
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
