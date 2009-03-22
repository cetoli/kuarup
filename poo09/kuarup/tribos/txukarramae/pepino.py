#! /usr/bin/env python
# -*- coding: UTF8 -*-
"""
##################
Marujos Pe e Xis
##################

:Author: Txukarrame
:Contact: `Txucarramae <http://is.gd/n3Dr>`__
:Date: $Date$
:Status: This is a "work in progress"
:Revision: $Revision$
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""

'''
Os marujos Pe e Xis são dois peixes que querem ser grandes empresários e montar  um grande centro de divertimento para criaturas do mar. No momento são apenas peixes comuns e atrapalhados que precisam de muita ajuda para seguir em frente. Eles vão ser desafiados pelas mais simples circunstâncias de seu ambiente natural a cada passo do seu caminho. A obtenção de suas metas vai ser um grande aprendizado para todos nós.
'''
from visual import *
from random import randint
from commands import *

PHI= (1+sqrt(5))/2
PHI2= PHI**2
PHI3= PHI**3
PHI4= PHI**4
GRAUS_30= pi/6.0
EIXO_Z= (0,0,1)
EIXO_NE= (1,1,0)
EIXO_SE= (1,-1,0)
EIXO_SSE= (2,-1,1)
EIXO_SSO= (2,-1,-1)
TITLE = 'Pepino'

class Cenario:
    def __init__(self):
        scene2 = display(title=TITLE,
            width=150, height=150,
            center= (0,0,0),
            x=0, y=0)
        scene2.x, scene2.y =0,0
        scene2.select()
        scene2.autoscale = 1
        self.quadro = 0
    def filmando(self):
    	getoutput('import -window %s  peexis.%03d.gif' % (TITLE,self.quadro))
    	self.quadro+=1
    def principal(self):
        pepino=Pepino(axis=(1,1,0))
        pepino2=Pepino(escala =2, axis=(2,-2,0))
        return
        for x in range(50):
            rate(4)
            peixinho.nadando()
            #self.filmando()
        return
        getoutput('convert -delay 10 -loop 0 peexis.*.gif animated.peexis.gif')
        getoutput('rm peexis.*.gif ')

class SerMarinho():
    '''
    Classe base de qualquer ser marinho
    '''
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)
    def desenha(self): pass

class Pepino(SerMarinho):
    def desenha(self, escala=1):
        u=escala
        r=6*u
        l=6*r
        uno = [-r,0,r]
        [cone(radius=u, frame= self.esqueleto,  pos= (l+r,x/4.0,y/4.0), axis = (0,x,y)) for x in uno for y in uno]
        cylinder(radius=r, frame= self.esqueleto, axis=(l,0,0), color=color.green)
        [sphere(frame= self.esqueleto, color=color.green, radius=r, pos=(x,0,0))for x in (0,l)]

if __name__ == "__main__":
    cenario= Cenario()
    cenario.principal()

