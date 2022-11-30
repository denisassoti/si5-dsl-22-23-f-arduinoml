package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.generator.Visitable;

public interface Expression extends Visitable {

    public Expression getExpression();
    public String getCondition();
}
