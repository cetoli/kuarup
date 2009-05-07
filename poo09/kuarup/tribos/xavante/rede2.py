#!/usr/bin/python

from visual import *
from peixe_xavante import *


def init_window ():
    scene.title      = "Rede"
    scene.width      = 300 +  9
    scene.height     = 300 + 30

    scene.autocenter = 1
    scene.autoscale  = 1

    #scene.forward = (0, -1.65, -1)
    #scene.scale   = (0.095, 0.095, 0.095)
    #scene.up      = (0, 0, pi)

    cm=255.0
    scene.background=(128/cm,128/cm,255/cm)


nfotos=0
def grava_quadro ():
    global nfotos
    #os.system ("import -window Rede rede%03d.jpg" % nfotos)
    nfotos += 1

    import time
    time.sleep(1)


def f(x, y):
    return (x/2)**2 + (y/2)**2


if __name__ == "__main__":

    init_window()

    inicio      = -5.0
    fim         =  5.0
    passo       = 0.5
    raio_fio    = 0.02
    cor_fio     = (color.green[0] - 0.5, color.green[1] - 0.5, color.green[2] - 0.5)

    for x in arange(inicio, fim, passo):
        if x == inicio or x == fim-passo:
            raio_fio *= 2
        if x == inicio+passo:
            raio_fio /= 2
        c = curve(pos=(x,inicio,f(x,inicio)), color=cor_fio, radius=raio_fio)
        for y in arange(inicio, fim, passo):
            c.append(pos=(x,y,f(x,y)))

    raio_fio /= 2
    
    for y in arange(inicio, fim, passo):
        if y == inicio or y == fim-passo:
            raio_fio *= 2
        if y == inicio+passo:
            raio_fio /= 2
        c = curve(pos=(inicio,y,f(inicio,y)), color=cor_fio, radius=raio_fio)
        for x in arange(inicio, fim, passo):
            c.append(pos=(x,y,f(x,y)))

    peixe = PeixeXavante(tamanho=10)
    peixe.rotate(axis=(1,0,0), angle=pi/2)
    peixe.rotate(axis=(0,0,1), angle=pi/2)
    peixe.move( (0,0,3.5) )
