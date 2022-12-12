package io.github.mosser.arduinoml.embedded.java.dsl;


import io.github.mosser.arduinoml.kernel.behavioral.*;

public class TransitionBuilder {


    private TransitionTableBuilder parent;

    private Transition local;

    private Expression expression;

    private State state;

    ExpressionBuilder unaryExprBuilder;
    BinaryExpressionBuilder binaryExpression;

    TransitionBuilder(TransitionTableBuilder parent, String source) {
        this.parent = parent;
        this.local = new Transition();
        parent.findState(source).addTransition(local);
        this.state = parent.findState(source);
    }

    public ExpressionBuilder startTmp(){
        this.unaryExprBuilder = new ExpressionBuilder(this);
        return unaryExprBuilder;
    }

    public ExpressionBuilder startUnary(){
        this.unaryExprBuilder = new ExpressionBuilder(this);
        return unaryExprBuilder;
    }

    public BinaryExpressionBuilder startBinary(){
        this.binaryExpression = new BinaryExpressionBuilder(this);
        return binaryExpression;
    }

    public void setExpression(Expression expression){
        this.expression = expression;
    }

    public TransitionTableBuilder goTo(String state) {
        local.setExpression(this.expression);
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
