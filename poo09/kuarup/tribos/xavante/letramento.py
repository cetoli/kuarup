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

    altura = 5/2.0 - 0.5
    peixe.move((0,altura,0))
    altura -= 1

    p = label(pos=( 5,-2,0), text='_')
    y = label(pos=( 6,-2,0), text='_')
    t = label(pos=( 7,-2,0), text='_')
    h = label(pos=( 8,-2,0), text='_')
    o = label(pos=( 9,-2,0), text='_')
    n = label(pos=(10,-2,0), text='_')

    for i in range(0,341):

        rate(30)

        if i == 30:
            label(pos=(5,3,0), text='A')
        if i == 40:
            aquario.diminui_nivel()
            peixe.move((0,altura,0))
            altura -= 1

        if i == 70:
            label(pos=(6,3,0), text='E')
        if i == 80:
            aquario.diminui_nivel()
            peixe.move((0,altura,0))
            altura -= 1

        if i == 110:
            o.text = "O"
            
        if i == 150:
            label(pos=(7,3,0), text='B')
        if i == 160:
            aquario.diminui_nivel()
            peixe.move((0,altura,0))
            altura -= 1
        
        if i == 190:
            p.text = "P"

        if i == 220:
            t.text = "T"

        if i == 250:
            label(pos=(8,3,0), text='D')
        if i == 260:
            aquario.diminui_nivel()
            peixe.move((0,altura,0))
            altura -= 1

        if i == 290:
            n.text = "N"

        if i == 320:
            label(pos=(9,3,0), text='I')
        if i == 340:
            aquario.diminui_nivel()
            peixe.move((0,altura+1,0))
            peixe.rotate(axis=(1,0,0), angle=pi/2)
            peixe.velocidade = 9
            scene.autocenter = 0
            scene.autoscale  = 0

            peixe.start_moving()
