from model.Expression import Expression
from model.BinaryExpression import BinaryExpression
from model.UnaryExpression import UnaryExpression

# exemple d'utilisation :
# builder = ExpressionBuilder()
# builder.both().both("Button 1").has_value("HIGH").and_("Button 2").has_value("HIGH").and_("Button 3").has_value("HIGH").go_to_state("State 2")
# correspond à :
# ((Button 1 == HIGH) && (Button 2 == HIGH)) && (Button 3 == HIGH)
class ExpressionBuilder:
    """
    Builder for expressions.
    """

    def __init__(self):
        """
        Constructor.

        :return:
        """
        self.expression: BinaryExpression = BinaryExpression(None, None, None)  # Expression, expression to trigger the transition
        self.structure = [None, None]

    def both(self, sensor=None):
        """
        Sets the action.

        :param sensor: String, name of the brick used to trigger the transition
        :return: TransitionBuilder, the builder
        """
        if sensor is None:
            if self.expression is None:
                print("here")
                self.expression = BinaryExpression(None, None, 0)
                return
            else:
                if self.expression.left is None:
                    print("left none")
                    self.expression.left = BinaryExpression(None, None, 0)
                elif self.expression.left is not None and type(self.expression.left) is BinaryExpression:
                    print("left binary", self.expression.left)
                    self.both(self.expression.left)
                elif self.expression.right is not None and type(self.expression.right) is BinaryExpression:
                    print("right binary", self.expression.right)
                    self.both(self.expression.right)
                else:
                    print("right none")
                    self.expression.right = BinaryExpression(None, None, 0)
                
                # if self.expression.left is not None and type(self.expression.left) is BinaryExpression:
                #     self.both(self.expression.left)
                # elif self.expression.right is None and type(self.expression.right) is  BinaryExpression:
                #     self.both(self.expression.right)
                # elif self.expression.right is not None:
                #     self.expression.right = BinaryExpression(None, None, 0)
                
                

    def has_value(self, value):
        """
        Sets the action.

        :param value: SIGNAL, state of the brick to trigger the transition
        :return: TransitionBuilder, the builder
        """
    
    def go_through(self):
        tree = []
        def _go_through(node):
            if node is None:
                return []
            return _go_through(node.left) + [node] + _go_through(node.right)
        return _go_through(self.expression)
    
        

eb = ExpressionBuilder()
# eb.expression.left = BinaryExpression(None, None, 0)
print("before both")
eb.expression.left = BinaryExpression(None, None, 0)
print(eb.expression)

print("after both")
eb.both(eb.expression.left)
print(eb.expression.left.left)
