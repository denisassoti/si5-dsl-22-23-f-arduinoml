import sys

sys.path.append('..')
from model.Expression import Expression
from model.UnaryExpression import UnaryExpression
from model.OPERATOR import value
from model.KeyExpression import KeyExpression
from model.TemporalExpression import TemporalExpression

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
            self.left = BinaryExpression(UnaryExpression(sensor, None), None, 0) if sensor else BinaryExpression(None, None, 0)
            return
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.both(sensor)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.both(sensor)
        if self.right is None and self == initial:
            self.right = BinaryExpression(UnaryExpression(sensor, None), None, 0) if sensor else BinaryExpression(None, None, 0)
            return

    
    def either(self, sensor=None):
        initial = copy.deepcopy(self)
        if self.left is None and self == initial:
            self.left = BinaryExpression(UnaryExpression(sensor, None), None, 1) if sensor else BinaryExpression(None, None, 1)
            return
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.either(sensor)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.either(sensor)         
        if self.right is None and self == initial:
            self.right = BinaryExpression(UnaryExpression(sensor, None), None, 1) if sensor else BinaryExpression(None, None, 1)
            return
    
    def or_(self, sensor=None):
        initial = copy.deepcopy(self)
        if sensor is None:
            return self
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
        if sensor is None:
            return self
        if self.left is None and self == initial:
            self.left = UnaryExpression(sensor, None) if sensor else BinaryExpression(None, None, None)
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.and_(sensor)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.and_(sensor)         
        if self.right is None and self == initial:
            self.right = UnaryExpression(sensor, None) if sensor else BinaryExpression(None, None, None)

    def key(self, key):
        initial = copy.deepcopy(self)
        if self.left is None and self == initial:
            self.left = KeyExpression(key)
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.key(key)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.key(key)
        if self.right is None and self == initial:
            self.right = KeyExpression(key)

    def after(self, time):
        initial = copy.deepcopy(self)
        if self.left is None and self == initial:
            self.left = TemporalExpression(time)
        if self.left is not None and type(self.left) is BinaryExpression:
            self.left.after(time)
        if self.right is not None and type(self.right) is BinaryExpression:
            self.right.after(time)
        if self.right is None and self == initial:
            self.right = TemporalExpression(time)

    def get_sensors(self):
        sensors = []
        if self.left is not None and type(self.left) is UnaryExpression:
            sensors.append(self.left.sensor)
        if self.left is not None and type(self.left) is BinaryExpression:
            sensors.extend(self.left.get_sensors())
        if self.right is not None and type(self.right) is BinaryExpression:
            sensors.extend(self.right.get_sensors())
        if self.right is not None and type(self.right) is UnaryExpression:
            sensors.append(self.right.sensor)
        return sensors