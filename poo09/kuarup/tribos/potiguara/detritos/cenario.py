from visual import *
from math import *
from time import sleep
from detrito_1 import *
from detrito_2 import *
from detrito_3 import *

TITLE = 'Saia da Área de Perigo'

import Image
import ImageGrab

class Cenario:
    def __init__(self):
        #self.scene2 = display(title = "Tribo Potiguara", center= (0,0,0), x=0, y=0)
        #self.scene2.x, self.scene2.y = 0, 0
        #self.scene2.select()
        #self.scene2.autoscale = 1
        self.scene2.autocenter = 1
        cm=750.0
        scene2 = display (title="Potiguara", width=600, height=600, background=(128/cm,128/cm,255/cm))
        scene2.autoscale  = 60
        scene2.select()
        
    def principal(self):

        p1 = Pneu(pos=(-1,0,0))
        p2 = Pneu(pos=(-1,1,0))
        p2.esqueleto.rotate(angle = pi/2, axis=(1,1,1), original=(1,1,1))

        b1 = Bota(pos=(2,0,0))
        b1.esqueleto.rotate(angle = pi/2, axis=(1,1,1), original=(1,1,1))
        b2 = Bota(pos=(2.5,0.5,0))
        b2.esqueleto.rotate(angle = pi/3, axis=(1,1,0), original=(1,1,1))

        g1 = Garrafa(pos=(1,-2,1))
        g1.esqueleto.rotate(angle = pi/3, axis=(1,1,0), original=(1,1,1))
        g2 = Garrafa(pos=(1,-2,1))
        g2.esqueleto.rotate(angle = pi/3, axis=(1,1,0), original=(1,1,1))          
        g3 = Garrafa(pos=(1,-2,1))
        g3.esqueleto.rotate(angle = pi/3, axis=(1,1,0), original=(1,1,1))
        g4 = Garrafa(pos=(1,-2,1))
        g4.esqueleto.rotate(angle = pi/3, axis=(1,1,0), original=(1,1,1))

if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()
