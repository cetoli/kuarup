#!/usr/bin/python

"""
:Author: Andre Abrantes
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`
"""

from visual import *
from peixe_xavante import *
from peixe_potiguara import *
from tubarao import *

cm=255.0
scene2 = display (title="Xavante", width=600, height=600, background=(128/cm,128/cm,255/cm))
scene2.autoscale  = 0
scene2.select()

scene2.forward = (0,1.5,-0.3)
scene2.scale = (0.22,0.22,0.22)

peixinho = Pangacio (escala=0.03)
peixinho.rotate(angle=pi/2, axis=(1,0,0))
peixinho.rotate(angle=(5*pi)/2 - (2*pi)/3, axis=(0,0,1))

peixe_xavante = Peixe (tamanho=0.5, material=materials.marble)
peixe_xavante.rotate(angle=pi/2, axis=(1,0,0))
peixe_xavante.rotate(angle=pi/5, axis=(0,0,1))

tubarao = Tubarao (escala=0.1)
tubarao.rotate(angle=pi/2, axis=(1,0,0))
tubarao.rotate(angle=(3*pi)/2, axis=(0,0,1))

inicio = pi
fim = 3*pi
passo = pi/60
i=1
for t in arange(inicio, fim, passo):

    r = t + pi/3
    x = 5 * cos(r)
    y = 5 * sin(r)
    peixinho.move (pos=(x,y,0))
    peixinho.rotate (angle=passo, axis=(0,0,1))
    #points (pos=(x,y,0), color=color.white)

    r = t + pi/4
    x = 5 * cos(r)
    y = 5 * sin(r)
    peixe_xavante.move (pos=(x,y,0), velocidade=8)
    peixe_xavante.rotate (angle=passo, axis=(0,0,1))
    #points (pos=(x,y,0), color=color.white)

    r = t
    x = 5 * cos(r)
    y = 5 * sin(r)
    tubarao.move (pos=(x,y,0))
    tubarao.rotate(angle=passo, axis=(0,0,1))
    #points (pos=(x,y,0), color=color.white)

    os.system ("import -window Xavante img%03d.png" % i)
    i += 1
