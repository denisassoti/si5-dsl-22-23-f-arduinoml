package io.github.mosser.arduinoml.externals.antlr;

import io.github.mosser.arduinoml.externals.antlr.grammar.*;


import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.structural.Actuator;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;
import io.github.mosser.arduinoml.kernel.structural.Sensor;
import io.github.mosser.arduinoml.kernel.structural.OPERATOR;


import java.util.*;

public class ModelBuilder extends ArduinomlBaseListener {

    /********************
     ** Business Logic **
     ********************/

    private App theApp = null;
    private boolean built = false;

    public App retrieve() {
        if (built) { return theApp; }
        throw new RuntimeException("Cannot retrieve a model that was not created!");
    }

    /*******************
     ** Symbol tables **
     *******************/

    private Map<String, Sensor>   sensors   = new HashMap<>();
    private Map<String, Actuator> actuators = new HashMap<>();
    private Map<String, State>    states  = new HashMap<>();
    private Map<String, LinkedList<String>> StatesNextStates = new HashMap<>(); // state -> list of next states (names)


    private State currentState = null;

    private Transition currentTransition = null;
    private String nextStateName = null;

    /**************************
     ** Listening mechanisms **
     **************************/

    @Override
    public void enterRoot(ArduinomlParser.RootContext ctx) {
        built = false;
        theApp = new App();
    }

    @Override public void exitRoot(ArduinomlParser.RootContext ctx) {
        this.built = true;

        this.StatesNextStates.forEach((stateName, nextStates) -> {
            //get the state in this.App.states with the name stateName and set its transitions next
            for (State s : this.theApp.getStates()) {
                if (s.getName().equals(stateName)) {
                    //add to the first state transition the first next state and so on
                    for (String nextStateName : nextStates) {
                        for (Transition t : s.getTransitions()) {
                            if (t.getNext() == null) {
                                t.setNext(this.states.get(nextStateName));
                                break;
                            }
                        }
                    }

                }
            }
        });
    }

    @Override
    public void enterDeclaration(ArduinomlParser.DeclarationContext ctx) {
        theApp.setName(ctx.name.getText());
    }

    @Override
    public void enterSensor(ArduinomlParser.SensorContext ctx) {
        Sensor sensor = new Sensor();
        sensor.setName(ctx.location().id.getText());
        sensor.setPin(Integer.parseInt(ctx.location().port.getText()));
        this.theApp.getBricks().add(sensor);
        sensors.put(sensor.getName(), sensor);
    }

    @Override
    public void enterActuator(ArduinomlParser.ActuatorContext ctx) {
        Actuator actuator = new Actuator();
        actuator.setName(ctx.location().id.getText());
        actuator.setPin(Integer.parseInt(ctx.location().port.getText()));
        this.theApp.getBricks().add(actuator);
        actuators.put(actuator.getName(), actuator);
    }

    @Override
    public void enterState(ArduinomlParser.StateContext ctx) {
        State local = new State();
        local.setName(ctx.name.getText());
        this.currentState = local;
        this.states.put(local.getName(), local);
    }

    @Override
    public void exitState(ArduinomlParser.StateContext ctx) {
        this.theApp.getStates().add(this.currentState);
        this.currentState = null;
    }

    @Override
    public void enterAction(ArduinomlParser.ActionContext ctx) {
        Action action = new Action();
        action.setActuator(actuators.get(ctx.receiver.getText()));
        action.setValue(SIGNAL.valueOf(ctx.value.getText()));

        this.currentState.getActions().add(action);
    }

    @Override
    public void enterTransition(ArduinomlParser.TransitionContext ctx) {
        Transition transition = new Transition();
        this.currentTransition = transition;
        this.nextStateName = ctx.next.getText();
    }

    @Override
    public void exitTransition(ArduinomlParser.TransitionContext ctx) {
        this.currentState.getTransitions().add(this.currentTransition);
        this.StatesNextStates.computeIfAbsent(this.currentState.getName(), k -> new LinkedList<>()).add(this.nextStateName);
        this.currentTransition = null;
        this.nextStateName = null;
    }


    @Override
    public void enterUnaryExpression(ArduinomlParser.UnaryExpressionContext ctx) {

         if(ctx.getParent() instanceof ArduinomlParser.AbstractExpressionContext) {
             this.currentTransition.setExpression(getUnaryExpression(ctx));
         }
    }

    public UnaryExpression getUnaryExpression(ArduinomlParser.UnaryExpressionContext ctx) {
        UnaryExpression unaryExpression = new UnaryExpression();
        unaryExpression.setSensor(sensors.get(ctx.trigger.getText()));
        unaryExpression.setValue(SIGNAL.valueOf(ctx.value.getText()));

        return unaryExpression;
    }

    @Override
    public void enterBinaryExpression(ArduinomlParser.BinaryExpressionContext ctx) {
        BinaryExpression binaryExpression = new BinaryExpression();
        binaryExpression.setOperator(OPERATOR.valueOf(ctx.operator.getText()));
        binaryExpression.getExpressions().add(getUnaryExpression(ctx.left));
        binaryExpression.getExpressions().add(getUnaryExpression(ctx.right));

        this.currentTransition.setExpression(binaryExpression);
    }

    @Override
    public void enterTemporalExpression(ArduinomlParser.TemporalExpressionContext ctx) {
        TemporalExpression temporalExpression = new TemporalExpression();
        temporalExpression.setValue(Integer.parseInt(ctx.duration.getText()));

        this.currentTransition.setExpression(temporalExpression);

    }

    @Override
    public void enterInitial(ArduinomlParser.InitialContext ctx) {
        this.theApp.setInitial(this.currentState);
    }

}
