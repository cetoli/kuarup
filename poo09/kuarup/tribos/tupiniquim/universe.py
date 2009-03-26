from visual import * 
import Image
#import ImageGrab
from tartaruga_pirapongatu import *
from random import random, randrange
from renderable import *
from mathHelper import *
from caracol import *
from marine import *
from fish import *
from animator import FishAnimator, CaracolAnimator, TurtleAnimator

class Universe:
    " Representa o lugar onde todos os objetos serao desenhados..."
    def __init__(self):
        """" carregas as texturas...
        Renderable.loadTexture(path="resources/clown_fish.jpg", keyName="clown_fish")
        Renderable.loadTexture(path="resources/tail.jpg", keyName="tail")
        """
        self.universeRate = 100

        #Cria o universo...
        self.fish = Fish(scale=.5, speed=10, pos = (15, -2, 0))

        self.turtle = Sea_turtle(scale=5, posFrame=(-20,10,0))
        
        self.caracol = Caracol(escala=1, axis=(1,0,0), pos= (7,-15,-3), speed=2)

        self.animate()

    def animate(self):
        frameNumber = 0
        fishAnimator = FishAnimator(animatedBeing=self.fish)
        caracolAnimator = CaracolAnimator(animatedBeing=self.caracol)
        turtleAnimator = TurtleAnimator(animatedBeing=self.turtle)        

        while 1:
            if(frameNumber>0 and frameNumber%20==0):
                im = ImageGrab.grab((40,90,430,450))
                fn = "gif/Kuarup"+str(frameNumber)+".gif"
                im.save(fn)

            rate(self.universeRate)
            fishAnimator.animate(frameNumber)
            caracolAnimator.animate(frameNumber)
            turtleAnimator.animate(frameNumber)
            
            if(frameNumber == 4000):
                break

            frameNumber += 1



if __name__ == "__main__":
    scene2 = display(title='Peexis', width=250, height=250, center= (0,0,0),x=0, y=0)
    scene2.x, scene2.y =0,0
    scene2.select()
    scene2.autoscale = 1
    Universe()