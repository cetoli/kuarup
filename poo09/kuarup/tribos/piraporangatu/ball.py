from visual import *
from obj_base import *
import visual as vs
import Image

class Ball(Obj_base):
    def __init__(self, pos=(0,0,0), scale=1., axis=[1,0,0]):
        self.esqueleto = frame()
        self.draw(esqueleto=self.esqueleto, pos=pos, scale=scale, axis=axis)


    ## Desenha a bola
    def draw(self, esqueleto, pos=(0,0,0), scale=1., axis=[1,0,0], phase = 1):
        ball = sphere(pos=(0,0,0), radius=1.*scale/2, opacity=(0.6), frame=esqueleto)
        
        self.esqueleto.pos = pos
        self.esqueleto.axis = axis


    def roll(self, axis, speed=0.05):        
        ## Roll the ball
        posIncrement = 1. * speed
        self.esqueleto.pos += posIncrement * norm(axis)

