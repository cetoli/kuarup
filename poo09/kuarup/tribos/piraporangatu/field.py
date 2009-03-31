from visual import *
from obj_base import *
import visual as vs
import Image

class Field(Obj_base):
    def __init__(self, pos=(0,0,0), scale=1., axis=[1,0,0]):
        self.esqueleto = frame()
        self.draw(esqueleto=self.esqueleto, pos=pos, scale=scale, axis=axis)


    ## Desenha o campo
    def draw(self, esqueleto, pos=(0,0,0), scale=1., axis=[1,0,0], phase = 1):
        l = 2. * scale
        h = 0.1 * scale
        w = 5. * scale
        field = box(pos=(0,0,0), length=l, height=h, width=w, color=(0,0.5,0), frame=esqueleto)

        self.draw_traps(frame = esqueleto, phase = phase, scale = scale)
        
        self.esqueleto.pos = pos
        self.esqueleto.axis = axis


    ## Desenha as armadilhas dependendo da fase
    def draw_traps(self, frame, phase = 1, scale = 1):

        trap_axis = (0,1,0)
        if phase == 1:
            trap1 = cylinder(pos=(0,-0.12*scale/2,3.*scale/2), radius=0.4*scale/2, length=0.1225*scale, axis=trap_axis, color=(0,0,0), frame=frame)
            trap2 = cylinder(pos=(-1.15*scale/2,-0.12*scale/2,2.5*scale/2), radius=0.7*scale/2, length=0.1225*scale, axis=trap_axis, color=(0,0,0), frame=frame)
            trap3 = cylinder(pos=(1.*scale/2,-0.12*scale/2,1.5*scale/2), radius=0.6*scale/2, length=0.1225*scale, axis=trap_axis, color=(0,0,0), frame=frame)
            trap4 = cylinder(pos=(0,-0.12*scale/2,-0.5*scale/2), radius=1.*scale/2, length=0.1225*scale, axis=trap_axis, color=(0,0,0), frame=frame)
            
