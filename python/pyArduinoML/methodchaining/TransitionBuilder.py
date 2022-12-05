__author__ = 'pascalpoizat'

from model.Transition import Transition
from UndefinedBrick import UndefinedBrick
from UndefinedState import UndefinedState

from model.OPERATOR import OR, AND
from model.BinaryExpression import BinaryExpression
from model.UnaryExpression import UnaryExpression

class TransitionBuilder:
    """
    Builder for transitions.
    """

    def __init__(self, root, sensor):
        """
        Constructor.

        :param root: BehaviorBuilder, root builder
        :param sensor: String, name of the brick used to trigger the transition
        :return:
        """
        self.root = root
        self.sensor = sensor
        self.value = None  # SIGNAL, state of the brick to trigger the transition
        self.next_state = None  # String, name of the target state
        self.binary_expression : BinaryExpression = BinaryExpression(None, None, None)  # Expression, expression to trigger the transition
        self.unary_expression : UnaryExpression = UnaryExpression(None, None)  # Expression, expression to trigger the transition

    def has_value(self, value):
        """
        Sets the action.

        :param value: SIGNAL, state of the brick to trigger the transition
        :return: TransitionBuilder, the builder
        """
        self.value = value
        return self
    
    # def has_value_(self, value):


    def go_to_state(self, next_state):
        """
        Sets the target state.

        :param next_state: String, name of the target state
        :return: StateBuilder, the builder root
        """
        self.next_state = next_state
        return self.root.root

    def get_contents(self, bricks, states):
        """
        Builds the transition.

        :param bricks: Map[String,Brick], the bricks of the application
        :param states: Map[String,State], the states of the application
        :return: Transition, the transition to build
        :raises: UndefinedBrick, if the transition references an undefined brick
        :raises: UndefinedState, if the transition references an undefined state
        """
        if self.sensor not in bricks.keys():
            raise UndefinedBrick()
        if self.next_state not in states.keys():
            raise UndefinedState()
        return Transition(bricks[self.sensor], self.value, states[self.next_state])

    def both(self, expression):
        """
        Sets the expression.

        :param expression: Expression, expression to trigger the transition
        :return: TransitionBuilder, the builder
        """
        print("type of both ",type(expression))
        self.binary_expression.left = expression
        return self
    
    def and_(self, expression):
        """
        Sets the expression.

        :param expression: Expression, expression to trigger the transition
        :return: TransitionBuilder, the builder
        """
        self.binary_expression.right = expression
        self.binary_expression.operator = AND
        return self

    def either(self, expression):
        """
        Sets the expression.

        :param expression: Expression, expression to trigger the transition
        :return: TransitionBuilder, the builder
        """
        self.binary_expression.left = expression
        return self
    
    def or_(self, expression):
        """
        Sets the expression.

        :param expression: Expression, expression to trigger the transition
        :return: TransitionBuilder, the builder
        """
        self.binary_expression.right = expression
        self.binary_expression.operator = OR
        return self

    def __str__(self) -> str:
        return self.binary_expression.__str__()
    
    def __repr__(self) -> str:
        return self.binary_expression.__repr__()

    
