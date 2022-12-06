__author__ = 'pascalpoizat'

class Transition :
    """
    A transition between two states.
    """

    def __init__(self, nextstate, expression):
        self.nextstate = nextstate
        self.expression = expression
