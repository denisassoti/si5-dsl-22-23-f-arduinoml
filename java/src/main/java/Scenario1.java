import io.github.mosser.arduinoml.kernel.App;
import io.github.mosser.arduinoml.kernel.generator.ToWiring;
import io.github.mosser.arduinoml.kernel.generator.Visitor;

import static io.github.mosser.arduinoml.embedded.java.dsl.AppBuilder.*;

public class Scenario1 {

    private static void scenario_1(){

        App myApp =
                application("red_button")
                        .uses(sensor("button", 9))
                        .uses(actuator("led", 12))
                        .uses(actuator("buzzer", 10))
                        .hasForState("on")
                        .setting("led").toHigh()
                        .setting("buzzer").toHigh()//
                        .endState()
                        .hasForState("off").initial()
                        .setting("led").toLow()
                        .setting("buzzer").toLow()//
                        .endState()
                        .beginTransitionTable()
                        .from("on").startUnary().when("button").isHigh().endExpr().goTo("off")
                        .from("off").startUnary().when("button").isHigh().endExpr().goTo("on")
                        .endTransitionTable()
                        .build();


        Visitor codeGenerator = new ToWiring();
        myApp.accept(codeGenerator);
        System.out.println(codeGenerator.getResult());
    }

    private static void scenario_2(){

        App myApp =
                application("red_button")
                        .uses(sensor("button1", 9))
                        .uses(sensor("button2", 12))
                        .uses(actuator("buzzer", 10))
                        .hasForState("on")
                        .setting("buzzer").toHigh()
                        .endState()
                        .hasForState("off").initial()
                        .setting("buzzer").toLow()
                        .endState()
                        .beginTransitionTable()
                        .from("on").startBinary().when("button1").isLow().or().when("button2").isLow().endExpr().goTo("off")
                        .from("off").startBinary().when("button1").isHigh().and().when("button2").isHigh().endExpr().goTo("on")
                        .endTransitionTable()
                        .build();


        Visitor codeGenerator = new ToWiring();
        myApp.accept(codeGenerator);
        System.out.println(codeGenerator.getResult());
    }

    private static void scenario_6(){

        App myApp =
                application("red_button")
                        .uses(sensor("button1", 9))
                        .uses(sensor("button2", 10))
                        .uses(sensor("button3", 11))
                        .uses(actuator("buzzer", 12))
                        .hasForState("on")
                        .setting("buzzer").toHigh()
                        .endState()
                        .hasForState("off").initial()
                        .setting("buzzer").toLow()
                        .endState()
                        .beginTransitionTable()
                        .from("off").startBinary().when("button1").isHigh().or().when("button2").isHigh().imb().and().when("button3").isHigh().endExpr().goTo("on")
                        .from("on").startBinary().when("button1").isLow().and().when("button2").isLow().endExpr().goTo("off")
                        .endTransitionTable()
                        .build();


        Visitor codeGenerator = new ToWiring();
        myApp.accept(codeGenerator);
        System.out.println(codeGenerator.getResult());
    }

    private static void scenario_3(){

        App myApp =
                application("red_button")
                        .uses(sensor("button", 9))
                        .uses(actuator("led", 12))
                        .hasForState("on")
                        .setting("led").toHigh()
                        .endState()
                        .hasForState("off").initial()
                        .setting("led").toLow()
                        .endState()
                        .beginTransitionTable()
                        .from("on").startUnary().when("button").isLow().endExpr().goTo("off")
                        .from("off").startUnary().when("button").isHigh().endExpr().goTo("on")
                        .endTransitionTable()
                        .build();


        Visitor codeGenerator = new ToWiring();
        myApp.accept(codeGenerator);
        System.out.println(codeGenerator.getResult());
    }
    public static void main (String[] args) {
         scenario_6();
    }

}
