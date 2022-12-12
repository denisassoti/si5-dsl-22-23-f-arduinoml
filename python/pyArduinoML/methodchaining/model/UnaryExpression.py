import sys
sys.path.append('..')
from model.Expression import Expression
from model.Sensor import Sensor
from model.SIGNAL import value

class UnaryExpression(Expression) :
    def __init__(self, sensor: Sensor, signal):
        self.sensor = sensor
        self.signal = signal
    
    def get_sensors(self):
        return [self.sensor]
    
    def __str__(self):
        return "digitalRead(%s) == %s" % (self.sensor, value(self.signal))
    
    def __repr__(self):
        return self.__str__()

    def __eq__(self, __o: object) -> bool:
        if isinstance(__o, UnaryExpression):
            return self.sensor == __o.sensor and self.signal == __o.signal