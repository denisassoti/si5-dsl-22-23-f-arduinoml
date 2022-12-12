import sys
sys.path.append('..')

class Beep() :
    def __init__(self, buzzer):
        self.buzzer = buzzer
        self.duration = None
        self.count = None
        
    def short(self):
        self.duration = 300
        return self
    
    def long(self):
        self.duration = 1000
        return self

    def times(self, times):
        self.count = times
        return self

    
    def __str__(self):
        return "for (int i = 0; i < %s; i++) { tone(%s, 1000, %s); delay(%s); noTone(%s); delay(100); }" % (self.count, self.buzzer, self.duration, self.duration, self.buzzer)
        
    def __repr__(self):
        return self.__str__()

    def __eq__(self, __o: object) -> bool:
        if isinstance(__o, Beep):
            return self.buzzer == __o.buzzer and self.duration == __o.duration and self.times == __o.times