import sys
sys.path.append('..')
from model.Expression import Expression


class TemporalExpression(Expression) :
    def __init__(self, time: int):
        self.time = time
    
    def __str__(self):
        return "(millis() - time > %s)" % (self.time)
    
    def __repr__(self):
        return self.__str__()

    def __eq__(self, __o: object) -> bool:
        if isinstance(__o, TemporalExpression):
            return self.key == __o.key

    def get_sensors(self):
        return []