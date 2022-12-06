__author__ = 'pascalpoizat'

from model.Transition import Transition
from UndefinedBrick import UndefinedBrick
from UndefinedState import UndefinedState

from model.OPERATOR import OR, AND
from model.BinaryExpression import BinaryExpression
from model.UnaryExpression import UnaryExpression
from ExpressionBuilder import ExpressionBuilder

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
        self.expression = ExpressionBuilder(self, sensor)

    def has_value(self, value):
        """
        Sets the action.

        :param value: SIGNAL, state of the brick to trigger the transition
        :return: TransitionBuilder, the builder
        """
        self.value = value
        self.expression.has_value(value)
        return self
    
    def both(self, sensor):
        return self.expression.both(sensor)

    def either(self, sensor):
        return self.expression.either(sensor)
    
    def and_(self):
        return self.expression.and_()
    
    def or_(self):
        return self.expression.or_()

    def key(self, key):
        return self.expression.key(key)

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
        return Transition(bricks[self.sensor], self.value, states[self.next_state], self.expression)
