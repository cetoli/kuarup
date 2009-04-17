from visual import *
from tartaruga_pirapongatu import *
from random import uniform, randint
from renderable import *
from mathHelper import *
from caracol import *
from peixe_potiguara import *
from agua_viva_potiguara import *
from marine import *
from fish import *
from animator import FishAnimator, CaracolAnimator, TurtleAnimator
from board import *
from motion import *

class Universe:
    " Representa o lugar onde todos os objetos serao desenhados..."
    def __init__(self):
        """" carregas as texturas...
        Renderable.loadTexture(path="resources/clown_fish.jpg", keyName="clown_fish")
        Renderable.loadTexture(path="resources/tail.jpg", keyName="tail")
        """
        self.scene2 = display(title='Pixel, o Super Peixe', width=250, height=250, center= (0,0,0),x=0, y=0)
        self.scene2.x, self.scene2.y =0,0
        self.scene2.select()
        self.scene2.autoscale = 1

        self.speed = 150

        self.scene2.forward = (0, -2, -4)

        self.board = Board()

        self.player = Fish(scale=0.08, speed=10.0, coord=(7,6))

#inclusao dos objetos da tribo potiguara no cenario
        self.player2 = Peixe_Potiguara(scale=0.1, speed=10.0, coord=(7,7))
        self.agua_viva1 = Agua_Viva_Potiguara(scale=0.5, speed=10.0, coord=(2 ,2))
#elemento que atrapalha a destruicao dos caracois
        self.impecilio = box(pos=(-3,2,1), length=1, height=1, width = 1, color = color.red)
                
        self.board.setPlayer(player=self.player)
        

        #scene.center = self.player.getPosition()

        self.elements=[]

        for i in range(4):
            self.elements.append(Caracol(scale=0.12, axis=X_AXIS, speed=10.0))

        self.board.addEnemy(enemy=self.elements[0], coord=(3, 0))
        self.board.addEnemy(enemy=self.elements[1], coord=(3, 2))
        self.board.addEnemy(enemy=self.elements[2], coord=(2, 6))
        self.board.addEnemy(enemy=self.elements[3], coord=(5, 6))

        self.friend = Sea_turtle(scale=0.5)
        self.board.setFriend(friend= self.friend, coord=(0, 0))

        self.elements.append(self.player)
        self.elements.append(self.friend)
        [self.elements.append(e) for e in self.board.enemies]

        animator = AnimatorThread(self)
        animator.start()

        motion = MotionThread(self)
        motion.start()

    def nextStep(self):
        [el.nextStep() for el in self.elements]
        self.board.setActiveBlock()


if __name__ == "__main__":

    Universe()
