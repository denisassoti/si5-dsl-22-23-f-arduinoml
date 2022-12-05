import sys
sys.path.append('..')
from model.Expression import Expression
from model.UnaryExpression import UnaryExpression
from model.OPERATOR import value
import copy

class BinaryExpression(Expression):
    def __init__(self, left: Expression, right: Expression, operator):
        self.left = left
        self.right = right
        self.operator = operator

    def __str__(self):
        return "(%s %s %s)" % (self.left, value(self.operator), self.right)
    
    def __repr__(self):
        return self.__str__()

    def both(self, sensor=None):
        initial = copy.deepcopy(self)
        if self.left is None and self == initial:
            self.operator = 0
            self.left = BinaryExpression(None, None, None) if not sensor else UnaryExpression(sensor, None)
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.both(sensor)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.both(sensor)
        if self.right is None and self == initial:
            self.operator = 0
            self.right = BinaryExpression(None, None, None) if not sensor else UnaryExpression(sensor, None)

    
    def either(self, sensor=None):
        initial = copy.deepcopy(self)
        if self.left is None and self == initial:
            self.operator = 1
            self.left = UnaryExpression(sensor, None) if sensor else BinaryExpression(None, None, None)
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.either(sensor)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.either(sensor)         
        if self.right is None and self == initial:
            self.operator = 1
            self.right = UnaryExpression(sensor, None) if sensor else BinaryExpression(None, None, None)
    
    def or_(self, sensor=None):
        initial = copy.deepcopy(self)
        if self.left is None and self == initial:
            self.left = BinaryExpression(None, None, None) if not sensor else UnaryExpression(sensor, None)
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.or_(sensor)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.or_(sensor)
        if self.right is None and self == initial:
            self.right = BinaryExpression(None, None, None) if not sensor else UnaryExpression(sensor, None)

    
    def has_value(self, signal):
        initial = copy.deepcopy(self)
        if self.left is not None and type(self.left) is UnaryExpression and self.left.sensor is not None and self.left.signal is None and self == initial:
            self.left.signal = signal
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.has_value(signal)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.has_value(signal)
        if self.right is not None and type(self.right) is UnaryExpression and self.right.sensor is not None and self.right.signal is None and self == initial:
            self.right.signal = signal
    
    def __eq__(self, __o: object) -> bool:
        if isinstance(__o, BinaryExpression):
            return self.left == __o.left and self.right == __o.right and self.operator == __o.operator
        
    def and_(self, sensor=None):
        initial = copy.deepcopy(self)
        if self.left is None and self == initial:
            self.left = UnaryExpression(sensor, None) if sensor else BinaryExpression(None, None, None)
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.and_(sensor)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.and_(sensor)         
        if self.right is None and self == initial:
            self.right = UnaryExpression(sensor, None) if sensor else BinaryExpression(None, None, None)

