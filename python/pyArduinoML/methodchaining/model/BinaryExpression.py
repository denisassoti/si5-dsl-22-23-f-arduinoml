import sys
sys.path.append('..')
from model.Expression import Expression
from model.OPERATOR import value

class BinaryExpression(Expression):
    def __init__(self, left: Expression, right: Expression, operator):
        self.left = left
        self.right = right
        self.operator = operator

    def __str__(self):
        return "(%s %s %s)" % (self.left, value(self.operator), self.right)
    
    def __repr__(self):
        return self.__str__()

    def both(self):
        if self.left is None:
            self.left = BinaryExpression(None, None, 0)
        elif self.left is not None and type(self.left) is BinaryExpression:
            self.left.both()
        elif self.right is not None and type(self.right) is BinaryExpression:
            self.right.both()
        else:
            self.right = BinaryExpression(None, None, 0)