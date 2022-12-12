from model.Beep import Beep
from UndefinedBrick import UndefinedBrick


class StateBeepBuilder:

    def __init__(self, root, actuator):
        self.root = root
        self.actuator = actuator
        self.beeps = []

    def short(self):
        self.beeps.append(Beep(self.actuator).short())
        return self
    
    def long(self):
        self.beeps.append(Beep(self.actuator).long())
        return self
    
    def times(self, times):
        self.beeps = self.beeps[:-1] + [self.beeps[-1].times(times)]
        return self.root
    
    def __str__(self) -> str:
        result = ""
        for beep in self.beeps:
            result += str(beep) + "\n\t\t"
        return result[:-3]