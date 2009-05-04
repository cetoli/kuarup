#!/usr/bin/python

import visual
from peixe_xavante import *

def init_window ():
    scene.title      = "Atencao"
    scene.width      = 300 +  9
    scene.height     = 300 + 30


    scene.forward = (0, 2, -1)
    scene.scale   = (0.2,0.2,0.2)

    cm=255.0
    scene.background=(128/cm,128/cm,255/cm)


nfotos=0
def grava_quadro ():
    global nfotos
    os.system ("import -window Atencao atencao%03d.jpg" % nfotos)
    nfotos += 1


def cria_peixe(peixes, pos):
    c = None
    if   pos == -2:
        c = color.green
    elif pos == -1:
        c = color.red
    elif pos ==  0:
        c = color.yellow
    elif pos ==  1:
        c = color.blue
    elif pos ==  2:
        c = color.orange

    peixes.append(PeixeXavante(color=c))
    peixes[-1].move((pos,13,0.2))

def move_peixes(peixes):
    remover = []

    for i in range(0, len(peixes)):
        x = peixes[i].frame.pos[0]
        y = peixes[i].frame.pos[1] - 0.5
        z = peixes[i].frame.pos[2]

        peixes[i].frame.pos = (x,y,z)

        err = 0.0000001

        if -6-err < y < -6+err:
            peixes[i].lamp = local_light(pos=(x,y,z), color=color.white)
        if y < -6-err:
            peixes[i].lamp.visible = false
        
        if -7-err < y < -7+err:
            remover.append(i)
        
    for i in remover:
        x = remover.pop()
        peixes.pop(x)


if __name__ == "__main__":

    init_window()

    linha1 = cylinder( pos=(-2,13,0), axis=(0,-20,0), radius=0.03 )
    #linha1.color = color.green
    anel1  = ring(pos=(-2,-5,0.1), axis=(0,0,1), radius=0.25, thickness=0.02)
    anel1.color = color.green

    linha2 = cylinder( pos=(-1,13,0), axis=(0,-20,0), radius=0.03 )
    #linha2.color = color.red
    anel2  = ring(pos=(-1,-5,0.1), axis=(0,0,1), radius=0.25, thickness=0.02)
    anel2.color = color.red

    linha3 = cylinder( pos=( 0,13,0), axis=(0,-20,0), radius=0.03 )
    #linha3.color = color.yellow
    anel3  = ring(pos=( 0,-5,0.1), axis=(0,0,1), radius=0.25, thickness=0.02)
    anel3.color = color.yellow

    linha4 = cylinder( pos=( 1,13,0), axis=(0,-20,0), radius=0.03 )
    #linha4.color = color.blue
    anel4  = ring(pos=( 1,-5,0.1), axis=(0,0,1), radius=0.25, thickness=0.02)
    anel4.color = color.blue

    linha5 = cylinder( pos=( 2,13,0), axis=(0,-20,0), radius=0.03 )
    #linha5.color = color.orange
    anel5  = ring(pos=( 2,-5,0.1), axis=(0,0,1), radius=0.25, thickness=0.02)
    anel5.color = color.orange

    peixes = []

    for i in range(0,130):

        rate(20)

        if i == 0:
            cria_peixe(peixes, -2)
        if i == 3:
            cria_peixe(peixes, -1)
        
        if i == 6:
            cria_peixe(peixes, -2)
        if i == 9:
            cria_peixe(peixes, -1)

        if i == 15:
            cria_peixe(peixes,  0)
            cria_peixe(peixes,  1)
        if i == 18:
            cria_peixe(peixes,  0)
            cria_peixe(peixes,  1)

        if i == 23:
            cria_peixe(peixes, -2)
        if i == 26:
            cria_peixe(peixes, -2)

        if i == 29:
            cria_peixe(peixes,  2)
        if i == 32:
            cria_peixe(peixes,  2)
        if i == 35:
            cria_peixe(peixes,  2)
        if i == 38:
            cria_peixe(peixes,  2)

        if i == 45:
            cria_peixe(peixes, -2)
        if i == 48:
            cria_peixe(peixes, -1)
        if i == 51:
            cria_peixe(peixes, -0)
        if i == 54:
            cria_peixe(peixes,  1)
        if i == 58:
            cria_peixe(peixes,  2)

        if i == 61:
            cria_peixe(peixes, -2)
        if i == 63:
            cria_peixe(peixes, -1)
        if i == 66:
            cria_peixe(peixes,  0)
        if i == 69:
            cria_peixe(peixes,  1)
        if i == 72:
            cria_peixe(peixes,  2)

        if i == 75:
            cria_peixe(peixes,  2)
        if i == 78:
            cria_peixe(peixes,  1)
        if i == 81:
            cria_peixe(peixes,  0)
        if i == 83:
            cria_peixe(peixes, -1)
        if i == 86:
            cria_peixe(peixes, -2)

        grava_quadro()
        move_peixes(peixes)

    print "fim"
