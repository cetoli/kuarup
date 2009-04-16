#!/usr/bin/env python
# -*- coding: UTF8 -*-

"""
:Author: Guajajaras
:Contact: `Guajajaras <http://kuarup2009.pbwiki.com/Tribo-Guajajaras>`__
:Date: $Date: 2009/03/24$
:Status: This is a "work in progress"
:Revision: $Revision: 1.00$
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""

from visual import *

'''
Classe base de qualquer ser marinho
'''
 
class SerMarinho():
    def __init__(self, escala= 5, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)
    def desenha(self): pass
'''
Esta classe é uma especialização da classe SerMarinho...
'''
class Traira(SerMarinho):
    def desenha(self, escala=1):
        s=escala
        cabeca01 = ellipsoid(frame = self.esqueleto, pos=(5*escala,escala,0), length=10*escala, height=9*escala, width=8*escala, color=color.green)
        cabeca02 = cone(frame = self.esqueleto, pos=(0,3*escala,0), axis=(6*escala,2*escala,0), radius=3*escala, color=color.green, opacity=1)
        boca = ring(frame = self.esqueleto, pos=(10*escala,escala,0), axis=(escala,0,0), radius=escala, thickness=0.5*escala, color=color.red)
        olho01 = sphere(frame = self.esqueleto, pos=(5*escala,4*escala,3*escala), radius=escala, opacity=0.5)
        olho02 = sphere(frame = self.esqueleto, pos=(5*escala,4*escala,3*escala), radius=.5*escala, color=color.black)
        olho11 = sphere(frame = self.esqueleto, pos=(5*escala,4*escala,-3*escala), radius=escala, opacity=.5)
        olho02 = sphere(frame = self.esqueleto, pos=(5*escala,4*escala,-3*escala), radius=.5*escala, color=color.black)
        corpo01 = sphere(frame = self.esqueleto, pos=(-1*escala,0,0), radius=6*escala, color = color.green, opacity=1)
        rabo1 = pyramid(frame = self.esqueleto, pos=(-12*escala,0,0), size=(12*escala,12*escala,.3*escala), color=color.green)
        rabo2 = pyramid(frame = self.esqueleto, pos=(-10*escala,0,2*escala), size=(6*escala,6*escala,.3*escala), axis=(1*escala,0,-0.4*escala), color=color.blue)
        rabo3 = pyramid(frame = self.esqueleto, pos=(-10*escala,0,-2*escala), size=(6*escala,6*escala,.3*escala), axis=(1*escala,0,0.4*escala), color=color.blue)
        dorsal1 = pyramid(frame = self.esqueleto, pos=(-4*escala,4*escala,0), size=(8*escala,15*escala,.3*escala), axis=(2*escala,.2*escala,0),color=color.green)
        peitoralBE = pyramid(frame = self.esqueleto, pos=(-2*escala,-1*escala,9*escala), size=(12*escala,6*escala,.3*escala), axis=(2*escala,.2*escala,-4*escala),color=color.blue)
        peitoralBB = pyramid(frame = self.esqueleto, pos=(-2*escala,-1*escala,-9*escala), size=(12*escala,6*escala,.3*escala), axis=(2*escala,.2*escala,4*escala),color=color.blue)


    def rotate (self, angle=0.0, axis=(0,0,0), origin=(0,0,0)):
        self.esqueleto.rotate(angle=angle, axis=axis, origin=origin)

    def move (self, pos=(0,0,0)):
        self.esqueleto.pos = pos
