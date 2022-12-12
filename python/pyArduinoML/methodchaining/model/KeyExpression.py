import sys
sys.path.append('..')
from model.Expression import Expression


class KeyExpression(Expression) :
    def __init__(self, key: str):
        self.key = key
    
    def __str__(self):
        return "(incomingByte == '%s' || incomingByte == '%s')" % (self.key.lower(), self.key.upper())
    
    def __repr__(self):
        return self.__str__()

    def __eq__(self, __o: object) -> bool:
        if isinstance(__o, KeyExpression):
            return self.key == __o.key