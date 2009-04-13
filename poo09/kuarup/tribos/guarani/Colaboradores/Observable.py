
class Observable:

    def __init__(self):
        self.observers = []

    def addObserver(self, observer):
        self.observers.append(observer)

    def removeObserver(self, observer):
        self.remove(observer)

    def notify(self):
        for observer in self.observers :
            observer.update(self)

    def getState(self):
        print "getState not overrided"