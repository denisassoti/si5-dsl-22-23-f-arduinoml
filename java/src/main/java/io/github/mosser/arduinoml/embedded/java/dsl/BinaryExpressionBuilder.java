package io.github.mosser.arduinoml.embedded.java.dsl;


import io.github.mosser.arduinoml.kernel.behavioral.BinaryExpression;
import io.github.mosser.arduinoml.kernel.behavioral.Expression;
import io.github.mosser.arduinoml.kernel.behavioral.Transition;
import io.github.mosser.arduinoml.kernel.behavioral.UnaryExpression;
import io.github.mosser.arduinoml.kernel.structural.OPERATOR;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;
import io.github.mosser.arduinoml.kernel.structural.Sensor;

import java.util.ArrayList;
import java.util.List;

public class BinaryExpressionBuilder {

    TransitionBuilder transitionBuilder ;

    Transition local;

    OPERATOR operator ;

    private List<Expression> expressions = new ArrayList<>();

    BinaryExpression expr = new BinaryExpression();


    private UnaryExpression localExpr = new UnaryExpression();

    public BinaryExpressionBuilder(TransitionBuilder transition){
        this.transitionBuilder = transition;
        local = new Transition();
        this.transitionBuilder.getParent().findState(this.transitionBuilder.getState().getName()).addTransition(local);
    }

    public BinaryExpressionBuilder when(String sensor) {
        this.localExpr.setSensor(transitionBuilder.getParent().findSensor(sensor));
        return this;
    }


    public BinaryExpressionBuilder isHigh(){
        if (this.localExpr.getSensor() == null)
            throw new IllegalArgumentException("The sensor is null");
        this.localExpr.setValue(SIGNAL.HIGH);
        expressions.add(this.localExpr);
        localExpr = new UnaryExpression();
        return this;
    }

    public BinaryExpressionBuilder isLow(){
        if (this.localExpr.getSensor() == null)
            throw new IllegalArgumentException("The sensor is null");
        this.localExpr.setValue(SIGNAL.LOW);
        expressions.add(this.localExpr);
        localExpr = new UnaryExpression();
        return this;
    }

    public BinaryExpressionBuilder or(){
        if (expressions.size() == 0)
            throw new IllegalArgumentException("Add an expression before the operator");
        operator = OPERATOR.OR;
        return this;
    }

    public BinaryExpressionBuilder and(){
        operator = OPERATOR.AND;
        return this;
    }

    public BinaryExpressionBuilder imb(){
        expr.setExpressions(expressions);
        expr.setOperator(operator);
        expressions = new ArrayList<>();
        operator = null;
        localExpr = new UnaryExpression();
        expressions.add(expr);
        return this;
    }

    public TransitionBuilder endExpr(){
        expr = new BinaryExpression();
        expr.setExpressions(expressions);
        expr.setOperator(operator);
        this.transitionBuilder.setExpression(expr);
        return transitionBuilder;
    }

}
