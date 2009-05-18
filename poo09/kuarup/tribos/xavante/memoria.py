#!/usr/bin/python

"""
:Author: Andre Abrantes
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`
"""

import visual
from peixe_xavante import *
from cavalo_marinho import *

import random


def init_window ():
    scene.title      = "Memoria"
    scene.width      = 300 +  9
    scene.height     = 300 + 30

    scene.autocenter = 1

    scene.forward = (0, 1, -1)
    scene.scale   = (0.4,0.4,0.4)

    cm=255.0
    scene.background=(128/cm,128/cm,255/cm)


nfotos=0
def grava_quadro ():
    global nfotos
    #os.system ("import -window Memoria memoria%03d.jpg" % nfotos)
    nfotos += 1
    import time
    time.sleep(.5)


if __name__ == "__main__":

    init_window()

    animais = []
    
    animais.append(PeixeXavante(color=color.red, tamanho=0.9))
    animais[-1].id = 1
    animais.append(PeixeXavante(color=color.red, tamanho=0.9))
    animais[-1].id = 1

    animais.append(PeixeXavante(color=color.blue, tamanho=0.9))
    animais[-1].id = 2
    animais.append(PeixeXavante(color=color.blue, tamanho=0.9))
    animais[-1].id = 2

    animais.append(PeixeXavante(color=color.green, tamanho=0.9))
    animais[-1].id = 3
    animais.append(PeixeXavante(color=color.green, tamanho=0.9))
    animais[-1].id = 3

    animais.append(PeixeXavante(color=color.yellow, tamanho=0.9))
    animais[-1].id = 4
    animais.append(PeixeXavante(color=color.yellow, tamanho=0.9))
    animais[-1].id = 4
    
    animais.append(CavaloMarinho(color=color.red, tamanho=0.9))
    animais[-1].id = 5
    animais.append(CavaloMarinho(color=color.red, tamanho=0.9))
    animais[-1].id = 5

    animais.append(CavaloMarinho(color=color.blue, tamanho=0.9))
    animais[-1].id = 6
    animais.append(CavaloMarinho(color=color.blue, tamanho=0.9))
    animais[-1].id = 6

    animais.append(CavaloMarinho(color=color.green, tamanho=0.9))
    animais[-1].id = 7
    animais.append(CavaloMarinho(color=color.green, tamanho=0.9))
    animais[-1].id = 7

    animais.append(CavaloMarinho(color=color.yellow, tamanho=0.9))
    animais[-1].id = 8
    animais.append(CavaloMarinho(color=color.yellow, tamanho=0.9))
    animais[-1].id = 8

    posicoes = {}
    while len(posicoes) < 16:
        pos = random.randint(0,15)
        if pos not in posicoes:
            animais[ len(posicoes) ].move((pos/4,pos%4,0))
            posicoes[pos] = len(posicoes)
 
    grava_quadro()
    grava_quadro()

    scene.autocenter = 0
    scene.autoscale  = 0

    caixas = []
    for i in range(0,16):
        caixas.append(box(pos=(i/4, i%4, 0.1), size=(0.6,0.6,0.6)))

    grava_quadro()

    while len(posicoes) > 0:

        a = random.randint(0,16)
        b = random.randint(0,16)

        if (a != b) and (a in posicoes) and (b in posicoes):
            caixas[a].visible = false

            grava_quadro()

            caixas[b].visible = false

            grava_quadro()

            if animais[ posicoes[a] ].id == animais[ posicoes[b] ].id:
                animais[ posicoes[a] ].frame.visible = false
                animais[ posicoes[b] ].frame.visible = false

                del posicoes[a]
                del posicoes[b]
            else:
                caixas[a].visible = true
                caixas[b].visible = true
                
            grava_quadro()

    print "fim"
