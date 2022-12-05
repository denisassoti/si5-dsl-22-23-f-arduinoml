package io.github.mosser.arduinoml.embedded.java.dsl;


import io.github.mosser.arduinoml.kernel.behavioral.Expression;
import io.github.mosser.arduinoml.kernel.behavioral.State;
import io.github.mosser.arduinoml.kernel.behavioral.Transition;
import io.github.mosser.arduinoml.kernel.behavioral.UnaryExpression;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;

public class TransitionBuilder {


    private TransitionTableBuilder parent;

    private Transition local;

    private ExpressionBuilder expression;

    private State state;


    TransitionBuilder(TransitionTableBuilder parent, String source) {
        this.parent = parent;
        //this.local = new Transition();
        //parent.findState(source).setTransition(local);
        this.state = parent.findState(source);

    }


    public ExpressionBuilder when(String sensor) {
        ExpressionBuilder expressionBuilder = new ExpressionBuilder(null);
      //ajouter une expression avec un sensor, il va manquer le HIGH on reviendra
        ExpressionBuilder unaryExpr = expressionBuilder.createUnaryExpressionWithSensor(parent.findSensor(sensor),local,parent);

        return unaryExpr;
    }

   /* public TransitionBuilder when(String sensor) {
        ExpressionBuilder expressionBuilder =new ExpressionBuilder();
        Expression unaryExpr = expressionBuilder.createUnaryExpressionWithSensor(parent.findSensor(sensor));

        local.setSensor(parent.findSensor(sensor));
        return this;
    }

    public TransitionBuilder isHigh() {
        local.setValue(SIGNAL.HIGH);
        return this;
    }

    public TransitionBuilder isLow() {
        local.setValue(SIGNAL.LOW);
        return this;
    }*/

    public TransitionTableBuilder goTo(String state) {
        local.setNext(parent.findState(state));
        return parent;
    }

    public TransitionTableBuilder getParent(){
        return parent;
    }

    public State getState(){
        return state;
    }


}
