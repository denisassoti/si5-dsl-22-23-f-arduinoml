package io.github.mosser.arduinoml.embedded.java.dsl;


import io.github.mosser.arduinoml.kernel.behavioral.Expression;
import io.github.mosser.arduinoml.kernel.behavioral.Transition;
import io.github.mosser.arduinoml.kernel.behavioral.UnaryExpression;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;
import io.github.mosser.arduinoml.kernel.structural.Sensor;

public class ExpressionBuilder {

    TransitionBuilder transitionBuilder ;


    Transition local;


    //private SIGNAL value;

    //private Sensor sensor;

    private UnaryExpression  expression;

    public ExpressionBuilder(TransitionBuilder transition){
        this.transitionBuilder = transition;
        local = new Transition();
        this.transitionBuilder.getParent().findState(this.transitionBuilder.getState().getName()).addTransition(local);
        expression = new UnaryExpression();
    }

    public ExpressionBuilder when(String sensor) {
        this.expression.setSensor(transitionBuilder.getParent().findSensor(sensor));
        return this;
    }

    public ExpressionBuilder createUnaryExpressionWithSensor(Sensor sensor,Transition transition,TransitionTableBuilder parent){
        //this.transition = transition;
       // this.parent = parent;
        //this.expression  = new UnaryExpression();
        //expression.setSensor(sensor);
        return this;
    }

    public ExpressionBuilder isHigh(){
        this.expression.setValue(SIGNAL.HIGH);
        //transition.addExpression(expression);
        //return this.transition;
        return this;
    }

    public ExpressionBuilder isLow(){
        this.expression.setValue(SIGNAL.HIGH);
        //transition.addExpression(expression);
        //return this.transition;
        return this;
    }

    public ExpressionBuilder or(){

        return null;
    }

    public ExpressionBuilder endExpr(){
        local.addExpression(this.expression);
        //this.transitionBuilder.getParent().findState(this.transitionBuilder.getState().getName()).addTransition(local);
        return this;
    }

    public TransitionTableBuilder goTo(String state) {
        local.setNext(this.transitionBuilder.getParent().findState(state));
        return this.transitionBuilder.getParent();
    }
}
