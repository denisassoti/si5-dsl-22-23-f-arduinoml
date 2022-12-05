from model.Expression import Expression
from model.BinaryExpression import BinaryExpression
from model.UnaryExpression import UnaryExpression

class ExpressionBuilder:
    """
    Builder for expressions.
    """

    def __init__(self, root, sensor=None):
        """
        Constructor.

        :return:
        """
        self.root = root
        self.both_validator = 0
        self.either_validator = 0
        self.expression = UnaryExpression(sensor, None) if sensor else BinaryExpression(None, None, None)        

    def both(self, sensor=None):
        self.expression.both(sensor)
        return self

    def either(self, sensor=None):
        self.expression.either(sensor)
        return self
    
    def has_value(self, value):
        if type(self.expression) is UnaryExpression:
            self.expression.signal = value
        else: 
            self.expression.has_value(value)
        return self
    
    def and_(self, sensor=None):
        self.expression.and_(sensor)
        return self
    
    def or_(self, sensor=None):
        self.expression.or_(sensor)
        return self
                
    def __str__(self) -> str:
        return str(self.expression)

    def __repr__(self) -> str:
        return self.__str__()

    def go_to_state(self, next_state):
        """
        Sets the target state.

        :param next_state: String, name of the target state
        :return: StateBuilder, the builder root
        """
        return self.root.go_to_state(next_state)
            

exp_builder = ExpressionBuilder(None, "Button1")

# digitalRead(%s) == %s


# exp_builder.either("Button 1").has_value("HIGH").or_().both("Button 2").has_value("HIGH").and_("Button 3").has_value("HIGH")
# exp_builder.has_value("HIGH")
# print(exp_builder.expression)