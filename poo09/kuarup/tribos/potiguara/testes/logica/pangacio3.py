#! /usr/bin/env python
# -*- coding: UTF8 -*-

######## Pangacio com escala

from visual import *

TITLE ='Pangacio'

'''
Classe base de qualquer ser marinho
'''
class SerMarinho():
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)

    def desenha(self): pass



class Pangacio(SerMarinho): 
    def desenha(self, escala=1):
                
        corpo1 = sphere(frame = self.esqueleto,pos=(0,0,0),color=color.orange, radius = 5*escala, opacity=1)

        olhoE = sphere(frame = self.esqueleto,pos=(4*escala,1*escala,-1.5*escala),color=color.white, radius = 2*escala, opacity=.5)
        olhoD = sphere(frame = self.esqueleto,pos=(4*escala,1*escala,1.5*escala),color=color.white, radius = 2*escala, opacity=.5)

        pupilaE = sphere(frame = self.esqueleto,pos=(5*escala,1*escala,-1.5*escala),color=color.black, radius = .8*escala)
        pupilaD = sphere(frame = self.esqueleto,pos=(5*escala,1*escala,1.5*escala),color=color.black, radius = .8*escala)

        labioSup = ellipsoid(frame = self.esqueleto,pos=(5*escala,-2*escala,0), length=2*escala, height=2*escala, width=3*escala, color=color.red)
        labioInf = ellipsoid(frame = self.esqueleto,pos=(4*escala,-3*escala,0), length=2*escala, height=2*escala, width=3*escala, color=color.red)

        rabo1 = pyramid(frame = self.esqueleto,pos=(-8*escala,0,0), size=(8*escala,10*escala,.1*escala),axis=(1*escala,0,0), color=color.orange, opacity=.6)
        rabo1.append = cylinder(frame = self.esqueleto,pos=(-8*escala,3*escala,-0.2*escala),axis=(0,0,.3*escala), radius=2*escala, color=color.orange, opacity=1)
        rabo1.append = cylinder(frame = self.esqueleto,pos=(-7*escala,0,-0.2*escala),axis=(0,0,.3*escala), radius=2*escala, color=color.orange, opacity=1)
        rabo1.append = cylinder(frame = self.esqueleto,pos=(-8*escala,-3*escala,-0.2*escala),axis=(0,0,.3*escala), radius=2*escala, color=color.orange, opacity=1)


        dorsal1 = cylinder(frame = self.esqueleto,pos=(0,4*escala,0),axis=(0,0,.1*escala), radius=3*escala, color=color.orange, opacity=.5)
        dorsal2 = cylinder(frame = self.esqueleto,pos=(-3*escala,3.5*escala,0),axis=(0,0,.1*escala), radius=1*escala, color=color.orange, opacity=1)
        dorsal3 = cylinder(frame = self.esqueleto,pos=(-1.5*escala,4.5*escala,0),axis=(0,0,.1*escala), radius=1*escala, color=color.orange, opacity=1)
        dorsal4 = cylinder(frame = self.esqueleto,pos=(0,5*escala,0),axis=(0,0,.1*escala), radius=1*escala, color=color.orange, opacity=1)
        dorsal5 = cylinder(frame = self.esqueleto,pos=(1.2*escala,4.5*escala,0),axis=(0,0,.1*escala), radius=1*escala, color=color.orange, opacity=1)
        dorsal6 = cylinder(frame = self.esqueleto,pos=(2*escala,4*escala,0),axis=(0,0,.1*escala), radius=1*escala, color=color.orange, opacity=1)

        barbatana10 = cylinder(frame = self.esqueleto,pos=(0,0,5*escala),axis=(-0.1*escala,0,-0.1*escala), radius=2*escala, color=color.orange)
        barbatana11 = cylinder(frame = self.esqueleto,pos=(0,-2*escala,5*escala),axis=(-0.1*escala,0,-0.1*escala), radius=1*escala, color=color.orange)

        barbatana10 = cylinder(frame = self.esqueleto,pos=(0,0,-5*escala),axis=(0.1*escala,0,-0.1*escala), radius=2*escala, color=color.orange)
        barbatana11 = cylinder(frame = self.esqueleto,pos=(0,-2*escala,-5*escala),axis=(0.1*escala,0,-0.1*escala), radius=1*escala, color=color.orange)

    def proximoFrame(self):
        pass

