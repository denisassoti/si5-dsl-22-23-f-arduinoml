package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.OPERATOR;

import java.util.ArrayList;
import java.util.List;

public class BinaryExpression implements Expression {

    private List<Expression> expressions = new ArrayList<>(); //array with 2 unary expressions

    private OPERATOR operator;

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        if (expressions.size() != 2) {
            System.out.println("length = " + expressions.size());
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

    @Override
    public Expression getExpression() {
        return this;
    }

    @Override
    public String getCondition() {
        switch (operator) {
            case AND:
                return String.format("(%s && %s)", expressions.get(0).getCondition(), expressions.get(1).getCondition());
            case OR:
                return String.format("(%s || %s)", expressions.get(0).getCondition(), expressions.get(1).getCondition());
            default:
                throw new IllegalArgumentException("Operator not supported");
        }
    }
}
