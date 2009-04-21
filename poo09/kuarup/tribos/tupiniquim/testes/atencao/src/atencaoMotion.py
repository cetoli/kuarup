from threading import Thread
from visual import *
import Image

class MotionThread(Thread):

    def __init__(self, universe):
        Thread.__init__(self)
        self.universe = universe
        self.frame = 0
    def run(self):
        while 1 :
            rate(self.universe.speed*2.0)
            self.frame += 1
            self.universe.nextStep()

class AnimatorThread(Thread):

    def __init__(self, game):
        Thread.__init__(self)
        self.game = game
        self.beings = game.fishes

    def run(self):
        delay = 3
        index = random.randint(0, len(self.beings)-1)
        print 'Escolhido = peixe ' , index

        peixeEscolhido = self.beings[index]
        
        self.game.choosenIndex = index

        peixeEscolhido.body.changeColor(color.red), self.waitSimple(delay)        
        peixeEscolhido.body.changeColor(color.orange), self.waitSimple(delay)
        peixeEscolhido.marked = 1
        
        for i in range(1):
            for j in range(random.randint(0,len(self.beings)-1)):                
                current1 = 0
                current2 = 0
                while current1 == current2:
                    current1 = random.randint(0,len(self.beings)-1)
                    current2 = random.randint(0,len(self.beings)-1)

                print '[' , current1, ',', current2, ']'
                self.beings[current1].newPosition = array(self.beings[current2].getPosition())
                self.beings[current2].newPosition = array(self.beings[current1].getPosition())
                self.beings[current1].moveDirection='dontcare'
                self.beings[current2].moveDirection='dontcare'
                a=2, self.waitSimple(delay*1.5)
        
        self.game.startUserInteraction()

    def wait(self, delay, element):
        while(element.stateNotChanged):
           time.sleep(delay)

    def waitSimple(self, delay):
        time.sleep(delay)