__author__="leandrogomes"
__date__ ="$Apr 19, 2009 4:53:12 PM$"

from marinho.fish import Fish
from visual import *
from atencaoMotion import *
from keyboardMotion import *
from boxMarker import *

class AttentionGame():
    def __init__(self):
        self.speed=100
        self.width, self.height = 300, 300
        self.scene2 = display(title='Pixel, o Super Peixe', width=self.width, height=self.height,x=0, y=0)
        self.scene2.select()
        self.scene2.x, self.scene2.y =0,0
        self.scene2.range=(100,100,100)
        
        self.choosenIndex = 0

        self.fishes   = []
        self.elements = []

        for i in range(5):
            fish = Fish(scale=1.5, speed=50.0,coord=(0,20))
            fish.setPosition((fish.getPosition().x,fish.getPosition().y,fish.getPosition().z + 30*i))
            self.elements.append(fish)
            self.fishes.append(fish)

        self.scene2.forward=(50,-4,0)
        self.scene2.autocenter=1

        motion = MotionThread(self)
        motion.start()
        
        animator = AnimatorThread(self)
        animator.start()
        
        time.sleep(4)

    def nextStep(self):
       [el.nextStep() for el in self.elements]

    def selectPiece(self):
        if(self.marker.markedIndex == self.choosenIndex):
            labelWin = label(pos=(0,0,50), text='Vc acertou! ^_^', height=self.height/10)
            time.sleep(1)
            labelWin.visible=0
        else:
            labelLoose = label(pos=(0,0,50), text='Vc errou... :(', height=self.height/10)
            time.sleep(1)
            labelLoose.visible=0
    
    def startUserInteraction(self):
        self.placeMarker()

        self.keyboard = self.scene2.kb
        keyboardThread = KeyboardThread(self)
        keyboardThread.start()

    def placeMarker(self):
        self.marker = BoxMarker(speed=100.0, coord=(0,20))
        self.elements.append(self.marker)

if __name__ == "__main__":
    AttentionGame()