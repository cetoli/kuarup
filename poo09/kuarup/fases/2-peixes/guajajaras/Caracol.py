#! /usr/bin/env python
# -*- coding: UTF8 -*-
"""
##################
     Caracol
##################
:Author: Guajajara
:Contact: `Guajajara <http://kuarup2009.pbwiki.com/Tribo-Guajajaras>`__
:Date: $Date: 2009/03/17$
:Status: This is a "work in progress"
:Revision: $Revision: 1.00$
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""
'''
O caracol é um molusco gastrópode de concha espiralada calcária, pertencente à família Helicidae.
São animais terrestres com ampla distribuição ambiental e geográfica..
'''
from visual import *

TITLE = 'Caracol'

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
    def principal(self):
        Caracol1=Caracol(escala =2, axis=(1,0,1.5), pos= (-8,-1,3))
        Caracol2=Caracol(escala =1, axis=(1,0,.5), pos= (7,1,1))
        Caracol3=Caracol(escala =1, axis=(1,0,.5), pos= (-2,7,-3))

        
class SerMarinho():
    '''
    Classe base de qualquer ser marinho
    '''
    def __init__(self, escala=1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)
        
    def desenha(self): pass

    
class Caracol(SerMarinho):
    '''
    Caracol!
    '''
    def desenha(self, escala=1):
        s=escala
        #f=frame()
        corpo = ellipsoid(frame = self.esqueleto, pos=(2,-4*s,0), length=7*s, height=s, width=4*s, color=color.yellow)
        casco1 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=8*s, height=8*s, width=2*s, color=color.orange, material=materials.wood)
        casco2 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=6*s, height=6*s, width=3*s, color=color.red, material=materials.wood)
        casco3 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=4*s, height=4*s, width=3.5*s, color=color.yellow, material=materials.wood)
        antenaE = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,-1.5*s), axis=(3*s,1.5*s,0), radius=0.1*s, color=color.yellow)
        antenaD = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,1.5*s), axis=(3*s,1.5*s,0), radius=0.1*s, color=color.yellow)
        antenaIE = cylinder(frame = self.esqueleto, pos=(3.6*s,-4*s,-0.5*s), axis=(1.5*s,-0.3*s,0), radius=0.1*s, color=color.yellow)
        antenaID = cylinder(frame = self.esqueleto, pos=(3.6*s,-4*s,0.5*s), axis=(1.5*s,-0.3*s,0), radius=0.1*s, color=color.yellow)

        bocaIE = sphere(frame = self.esqueleto, pos=(5.1*s,-4.3*s,-0.5*s),color=color.yellow, radius = 0.1*s)
        bocaID = sphere(frame = self.esqueleto, pos=(5.1*s,-4.3*s,0.5*s),color=color.yellow, radius = 0.1*s)

        olhoE = sphere(frame = self.esqueleto, pos=(6.5*s,-1.5*s,-1.5*s),color=color.white, radius = 1.2*s, opacity=0.6)
        olhoD = sphere(frame = self.esqueleto, pos=(6.5*s,-1.5*s,1.5*s),color=color.white, radius = 1.2*s, opacity=0.6)
        pupilaE = sphere(frame = self.esqueleto, pos=(6.5*s,-1.5*s,-1.5*s),color=color.black, radius = .5*s)
        pupilaD = sphere(frame = self.esqueleto, pos=(6.5*s,-1.5*s,1.5*s),color=color.black, radius = .5*s)
       
      
if __name__ == "__main__":
    cenario= Cenario()
    cenario.principal()
