#! /usr/bin/env python
# -*- coding: UTF8 -*-
"""
:Author: Potiguar
:Contact: `Potiguar tcruz.franca@gmail.com`__ um índio moderno
:Date: $Date: 2009/03/16 $
:Status: This is a "work in progress"
:Revision: $Revision: 1.00 $
:Home: `LABASE http://labase.nce.ufrj.br/`__ (mestrando)
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""
 
from visual import *
TITLE = 'Carpa Comun em movimento'
class Cenario:
    def __init__(self):
        scene2 = display(title=TITLE, width=300, height=300, center= (0,0,0), x=0, y=0)
        scene2.x, scene2.y =0,0
        scene2.select()
        scene2.autoscale = 1
        self.quadro = 0
    def principal(self):
        pangacio=Pangacio(escala =1, axis=(1,0,0), pos= (1,-3,0))    #Primeiro peixe
class SerMarinho():
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)
    def desenha(self): pass
class Pangacio(SerMarinho):
       
    def desenha(self,escala=1):
        u=escala/6.0
        r=6*u
        l=6*r
        direcoes = [-r,0,r]
       
        self.cor1 = color.orange;
        self.cor2 = color.white;
        self.cor3 = color.black;
        self.cor4 = color.red;
       
        corpo1 = self.desenharEsfera((0,0,0),self.cor1,5*escala,1)
        olhoE = self.desenharEsfera((4*escala,1*escala,-1.5*escala),self.cor2,2*escala,0.5)
        olhoD = self.desenharEsfera((4*escala,1*escala,1.5*escala),self.cor2,2*escala,0.5)
        pupilaE = self.desenharEsfera((5*escala,1*escala,-1.5*escala),self.cor3,0.8*escala)
        pupilaD = self.desenharEsfera((5*escala,1*escala,1.5*escala),self.cor3,0.8*escala)
        labioSup = self.desenhaElipse((5*escala,-2*escala,0),2*escala,2*escala,3*escala, self.cor4)
        labioInf = self.desenhaElipse((4*escala,-3*escala,0*escala),2*escala,2*escala,3*escala,self.cor4)
        rabo1 = self.desenharPiramide((-10*escala,0,0),(8*escala,10*escala,.1*escala),(1*escala,0,0),self.cor1,0.6)
        rabo1.append = self.desenharCilindro((-10*escala,3*escala,-0.2*escala),(0,0,.3*escala),2*escala,self.cor1,1)
        rabo1.append = self.desenharCilindro((-9*escala,0,-0.2*escala),(0,0,.3*escala),2*escala,self.cor1,1)
        rabo1.append = self.desenharCilindro((-10*escala,-3*escala,-0.2*escala),(0,0,.3*escala),2*escala,self.cor1,1)
        dorsal1 = self.desenharCilindro((0,4*escala,0),(0,0,.1*escala),3*escala,self.cor1,0.5)
        dorsal2 = self.desenharCilindro((3*escala,3.5*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)
        dorsal3 = self.desenharCilindro((1.5*escala,4.5*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)
        dorsal4 = self.desenharCilindro((0,5*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)
        dorsal5 = self.desenharCilindro((-1.2*escala,4.5*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)
        dorsal6 = self.desenharCilindro((-2*escala,4*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)
        barbatana10 = self.desenharCilindro((0,0,-5*escala),(0.1*escala,0,-0.1*escala),2*escala,self.cor1)
        barbatana11 = self.desenharCilindro((0,-2*escala,-5*escala),(0.1*escala,0,-0.1*escala),1*escala,self.cor1)
        barbatana10 = self.desenharCilindro((0,0,5*escala),(-0.1*escala,0,-0.1*escala),2*escala,self.cor1)
        barbatana11 = self.desenharCilindro((0,-2*escala,5*escala),(-0.1*escala,0,-0.1*escala),1*escala,self.cor1)
       
    def desenharEsfera(self,posicao=(0,0,0),cor=color.blue,raio=1, opacidade=1):
        return sphere(
            frame=self.esqueleto, pos=posicao,color=cor, radius = raio, opacity=opacidade
        )
    def desenhaElipse(self,posicao=(0,0,0),comprimento=1,altura=1,largura=1,cor=color.blue):
        return ellipsoid(
           
            frame=self.esqueleto,pos=posicao, length=comprimento, height=altura, width=largura, color=cor
   
        )
    def desenharPiramide(self,posicao=(0,0,0),tamanho=(1,1,1),eixos=(1,0,0),cor=color.blue,opacidade=1):
        return pyramid(
            frame=self.esqueleto,pos=posicao, size=tamanho,axis=eixos, color=cor, opacity=opacidade
           
        )
    def desenharCilindro(self,posicao=(0,0,0),eixo=(1,0,0),raio=1,cor=color.blue,opacidade=1):
        return cylinder(
            frame=self.esqueleto,pos=posicao,axis=eixo, radius=raio, color=cor, opacity=opacidade
        )

    def rotate (self, angle=0.0, axis=(0,0,0), origin=(0,0,0)):
        self.esqueleto.rotate(angle=angle, axis=axis, origin=origin)

    def move (self, pos=(0,0,0)):
        self.esqueleto.pos = pos

'''
Main
'''
if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()
