package io.github.mosser.arduinoml.embedded.java.dsl;


import io.github.mosser.arduinoml.kernel.behavioral.Expression;
import io.github.mosser.arduinoml.kernel.behavioral.TemporalExpression;
import io.github.mosser.arduinoml.kernel.behavioral.Transition;
import io.github.mosser.arduinoml.kernel.behavioral.UnaryExpression;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;

public class ExpressionBuilder {

    TransitionBuilder transitionBuilder ;

    Transition local;

    private UnaryExpression expression =new UnaryExpression();

    private TemporalExpression tmpExpr = new TemporalExpression();

    public ExpressionBuilder(TransitionBuilder transition){
        this.transitionBuilder = transition;
        local = new Transition();
        this.transitionBuilder.getParent().findState(this.transitionBuilder.getState().getName()).addTransition(local);
    }

    public ExpressionBuilder when(String sensor) {
        this.expression.setSensor(transitionBuilder.getParent().findSensor(sensor));
        return this;
    }

    public ExpressionBuilder isHigh(){
        this.expression.setValue(SIGNAL.HIGH);
        return this;
    }

    public ExpressionBuilder isLow(){
        this.expression.setValue(SIGNAL.HIGH);
        return this;
    }



    public ExpressionBuilder endExpr(){
        local.setExpression(this.expression);
        return this;
    }

    public TransitionTableBuilder goTo(String state) {
        local.setNext(this.transitionBuilder.getParent().findState(state));
        return this.transitionBuilder.getParent();
    }
}
