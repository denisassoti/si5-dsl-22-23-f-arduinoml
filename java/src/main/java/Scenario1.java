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
                        .from("on").when("button").isHigh().endExpr().goTo("off")
                         .from("on").when("button").isHigh().endExpr().goTo("off")
                        .from("off").when("button").isHigh().endExpr().goTo("on")
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
                        .uses(actuator("button2", 12))
                        .uses(actuator("buzzer", 10))
                        .hasForState("on")
                        .setting("buzzer").toHigh()
                        .endState()
                        .hasForState("off").initial()
                        .setting("buzzer").toLow()
                        .endState()
                        .beginTransitionTable()
                        .from("on").when("button1").isLow().or().when("button1").isHigh().endExpr().goTo("off")
                        .from("on").when("button").isHigh().endExpr().goTo("off")
                        .from("off").when("button").isHigh().endExpr().goTo("on")
                        .endTransitionTable()
                        .build();


        Visitor codeGenerator = new ToWiring();
        myApp.accept(codeGenerator);
        System.out.println(codeGenerator.getResult());
    }


    public static void main (String[] args) {
         scenario_1();
    }

}
