package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.OPERATOR;

import java.util.ArrayList;
import java.util.List;

public class BinaryExpression extends Expression {

    private List<UnaryExpression> expressions = new ArrayList<>(); //array with 2 unary expressions

    private OPERATOR operator;

    public List<UnaryExpression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<UnaryExpression> expressions) {
        if (expressions.size() != 2) {
            throw new IllegalArgumentException("BinaryExpression must have 2 unary expressions");
        }
        this.expressions = expressions;
    }
    public OPERATOR getOperator() {
        return operator;
    }

    public void setOperator(OPERATOR operator) {
        this.operator = operator;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
