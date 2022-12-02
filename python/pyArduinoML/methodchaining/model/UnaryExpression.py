import sys
sys.path.append('..')
from model.Expression import Expression
from model.Sensor import Sensor

class UnaryExpression(Expression) :
    def __init__(self, sensor: Sensor, signal):
        self.sensor = sensor
        self.signal = signal
    
    def __str__(self):
        return "%s %s" % (self.sensor, self.signal if self.signal is not None else "")
    
    def __repr__(self):
        return self.__str__()