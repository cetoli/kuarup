#!/usr/bin/python

import visual
import random
from peixe_xavante import *

def init_window ():
    scene.title      = "Memoria"
    scene.width      = 600 +  9
    scene.height     = 600 + 30

    scene.autoscale  = true
    scene.autocenter = true

    scene.forward = (0, 0.5, -1)
    #scene.scale   = (0.2,0.2,0.2)

    cm=255.0
    scene.background=(128/cm,128/cm,255/cm)


nfotos=0
def grava_quadro ():
    global nfotos
    #os.system ("import -window Memoria memoria%03d.jpg" % nfotos)
    nfotos += 1

    import time
    time.sleep(1)




peixes={}
mapa = [[0,0,1,1,1,0,0],
        [0,0,1,1,1,0,0],
        [1,1,1,1,1,1,1],
        [1,1,1,2,1,1,1],
        [1,1,1,1,1,1,1],
        [0,0,1,1,1,0,0],
        [0,0,1,1,1,0,0]]

def pode(a, b):
    if a[0] < 0 or a[0] > 6:
        return false
    if a[1] < 0 or a[1] > 6:
        return false
    if b[0] < 0 or b[0] > 6:
        return false
    if b[1] < 0 or b[1] > 6:
        return false

    if mapa[a[0]][a[1]] == 1 and mapa[b[0]][b[1]] == 1:
        return true

    return false


def encontra_jogada():
    for i in range(0,7):
        for j in range(0,7):
            if mapa[i][j] == 2:
                
                ordem = range(0,4)
                random.shuffle(ordem)

                for k in ordem:
                    if   k == 0 and pode((i-1,j), (i-2,j)):
                        return ( (i-2,j), (i,j) )
                    elif k == 1 and pode((i+1,j), (i+2,j)):
                        return ( (i+2,j), (i,j) )
                    elif k == 2 and pode((i,j-1), (i,j-2)):
                        return ( (i,j-2), (i,j) )
                    elif k == 3 and pode((i,j+1), (i,j+2)):
                        return ( (i,j+2), (i,j) )

    return None
    

def faz_jogada(j):
    a = j[0]
    b = j[1]
    c = ( (a[0]+b[0])/2, (a[1]+b[1])/2 )

    p1 = peixes[a]
    p2 = peixes[c]

    mapa[a[0]][a[1]] = 2
    mapa[b[0]][b[1]] = 1
    mapa[c[0]][c[1]] = 2

    p2.move( (100,100,100) )
    del peixes[a]
    del peixes[c]

    peixes[b] = p1

    grava_quadro()

    dir = norm( (b[0]-a[0], b[1]-a[1]) )
    ang = acos(dir[0]*p1.angle[0] + dir[1]*p1.angle[1])

    p1.move( (b[0],b[1],0) )
    grava_quadro()
    



if __name__ == "__main__":

    init_window()

    for i in range(0,7):
        for j in range(0,7):
            if mapa[i][j] == 1:
                peixes[(i,j)] = PeixeXavante()
                peixes[(i,j)].move((i,j,0))
                peixes[(i,j)].angle = (0,-1,0)

    scene.autoscale  = false
    scene.autocenter = false

    grava_quadro()

    while true:
        j = encontra_jogada()
        if j == None:
            break

        faz_jogada(j)

    print "fim"
