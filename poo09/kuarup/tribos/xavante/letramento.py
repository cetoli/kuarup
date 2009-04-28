#!//usr/bin/python

from visual import *
from peixe_xavante import *

import time

class Aquario:

    def __init__(self, espessura=0.002, niveis=5):

        self.frame = frame()
        self.niveis = niveis
        self.espessura = espessura
        self.altura = altura = niveis+1

        vidro1 = box(width=espessura, height=altura, length=altura, color = color.white, opacity=0.1)
        vidro1.pos=(0,0.1*altura,-0.5*altura)
        
        vidro2 = box(width=espessura, height=altura, length=altura, color = color.white, opacity=0.1)
        vidro2.pos=(0,0.1*altura, 0.5*altura)

        vidro3 = box(width=espessura, height=altura, length=altura, color = color.white, opacity=0.1)
        vidro3.pos=( 0.5*altura,0.1*altura,0)
        vidro3.rotate(axis=(0,1,0), angle=pi/2)

        vidro4 = box(width=espessura, height=altura, length=altura, color = color.white, opacity=0.1)
        vidro4.pos=(-0.5*altura,0.1*altura,0)
        vidro4.rotate(axis=(0,1,0), angle=pi/2)

        vidro5 = box(width=espessura, height=altura, length=altura, color = color.white, opacity=0.1)
        vidro5.pos=(0,-0.4*altura,0)
        vidro5.rotate(axis=(1,0,0), angle=pi/2)

        altura_nivel = 1
        self.frames_agua = []
        n = 0
        i = 0

        for n in range(-niveis/2+1,niveis/2+1):

            self.frames_agua.append( frame() )

            agua1 = box(width=espessura, height=altura_nivel, length=altura*0.99, color = color.blue, opacity=0.3, frame=self.frames_agua[i])
            agua1.pos=(0, 0.1+n,-0.49*altura)


            agua3 = box(width=espessura, height=altura_nivel, length=altura*0.99, color = color.blue, opacity=0.3, frame=self.frames_agua[i])
            agua3.pos=( 0.49*altura, 0.1+n, 0)
            agua3.rotate(axis=(0,1,0), angle=pi/2)

            agua4 = box(width=espessura, height=altura_nivel, length=altura*0.99, color = color.blue, opacity=0.3, frame=self.frames_agua[i])
            agua4.pos=(-0.49*altura, 0.1+n, 0)
            agua4.rotate(axis=(0,1,0), angle=pi/2)

            i += 1

        agua = box(width=espessura, height=altura*0.99, length=altura*0.99, color = color.blue, opacity=0.3)
        agua.pos=(0,-0.39*altura,0)
        agua.rotate(axis=(1,0,0), angle=pi/2)

    def diminui_nivel(self):
        self.niveis -= 1

        if (self.niveis >= 0):
            self.frames_agua[self.niveis].visible=false


def init_window ():
    scene.title      = "Colaboradores"
    scene.width      = 600 +  9
    scene.height     = 600 + 30

    scene.autocenter = 1
    scene.autoscale  = 1

    #scene.forward = (0, -1.65, -1)
    #scene.scale   = (0.095, 0.095, 0.095)
    #scene.up      = (0, 0, pi)

    cm=255.0
    scene.background=(128/cm,128/cm,255/cm)


if __name__ == "__main__":

    init_window()

    aquario = Aquario(niveis=5)

    peixe = PeixeXavante(tamanho=2)
    peixe.rotate(axis=(0,0,1), angle=pi/2)
    peixe.rotate(axis=(0,1,1), angle=pi)

    peixe.start_moving()


    h = 5/2.0
    peixe.move((0,h,0))
    h -= 1

    time.sleep(1)
    aquario.diminui_nivel()
    peixe.move((0,h,0))
    h -= 1

    time.sleep(1)
    aquario.diminui_nivel()
    peixe.move((0,h,0))
    h -= 1
    
    time.sleep(1)
    aquario.diminui_nivel()
    peixe.move((0,h,0))
    h -= 1
    
    time.sleep(1)
    aquario.diminui_nivel()
    peixe.move((0,h,0))
    h -= 1
    
    time.sleep(1)
    aquario.diminui_nivel()
    peixe.move((0,h,0))
    h -= 1
