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
            self.expression.both()
                

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
