from model.Expression import Expression
from model.BinaryExpression import BinaryExpression
from model.UnaryExpression import UnaryExpression
from model.KeyExpression import KeyExpression
from model.TemporalExpression import TemporalExpression

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
        self.expression = UnaryExpression(sensor, None) if sensor else None
        self.parenthesis = "" 

    def both(self, sensor=None):
        self.parenthesis += "("
        if self.expression is None:
            if sensor is None:
                self.expression = BinaryExpression(None, None, 0)
            else:
                self.expression = BinaryExpression(UnaryExpression(sensor, None), None, 0)
        else :
            self.expression.both(sensor)
        return self

    def either(self, sensor=None):
        self.parenthesis += "["
        if self.expression is None:
            if sensor is None:
                self.expression = BinaryExpression(None, None, 1)
            else:
                self.expression = BinaryExpression(UnaryExpression(sensor, None), None, 1)            
        else: 
            self.expression.either(sensor)
        return self
    
    def has_value(self, value):
        if type(self.expression) is UnaryExpression:
            self.expression.signal = value
        else: 
            self.expression.has_value(value)
        return self
    
    def and_(self, sensor=None):
        if self.parenthesis[-1] != "(":
            raise Exception("Expecting or_ rather than and_")
        else : 
            self.parenthesis = self.parenthesis[:-1]
        self.expression.and_(sensor)
        return self
    
    def or_(self, sensor=None):
        if self.parenthesis[-1] != "[":
            raise Exception("Expecting and_ rather than or_")
        else :
            self.parenthesis = self.parenthesis[:-1]
        self.expression.or_(sensor)
        return self
    
    def key(self, key):
        self.root.used_remote()
        if self.expression is None:
            self.expression = KeyExpression(key)
        else:
            self.expression.key(key)
        return self
    
    def after(self, time):
        if self.expression is None:
            self.expression = TemporalExpression(time)
        else:
            self.expression.after(time)
        return self

    def get_sensors(self):
        if type(self.expression) is UnaryExpression:
            return [self.expression.sensor]
        elif type(self.expression) is BinaryExpression:
            return self.expression.left.get_sensors() + self.expression.right.get_sensors()
        else :
            return []

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
        

