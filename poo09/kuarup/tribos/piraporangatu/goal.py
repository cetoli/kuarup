from visual import *
from obj_base import *
import visual as vs
import Image

class Goal(Obj_base):
    def __init__(self, pos=(0,0,0), scale=1., axis=[1,0,0]):
        self.esqueleto = frame()
        self.draw(esqueleto=self.esqueleto, pos=pos, scale=scale, axis=axis)


    ## Desenha as traves
    def draw(self, esqueleto, pos=(0,0,0), scale=1., axis=[1,0,0]):
        l = 2 * scale
        h = 2 * scale
        goal = curve(pos=[(-l,0,0),(-l,h,0),(l,h,0),(l,0,0)], radius = 0.1 * scale, frame = esqueleto)

        self.esqueleto.pos = pos
        self.esqueleto.pos[1] -= h/2
        self.esqueleto.axis = axis

        
