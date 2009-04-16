#! /usr/bin/env python
# -*- coding: UTF8 -*-

"""
############################################
Peixe Pangacio e seu problema
############################################
:Author: Tiago Cruz de França
:Contact: tcruz.franca@gmail.com
:Date: $Date: 2009/03/30 $
:Status: This is a "work in progress"
:Revision: $Revision: 1.00 $ 
:Home: `KUARUP - PBWiki <http://kuarup2009.pbwiki.com/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""

from visual import *
from math import *

'''
Classe base de qualquer ser marinho
'''
class SerMarinho():
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)

        self.dir = 1

    def desenha(self):
        pass


class AguaViva(SerMarinho):

    def desenha(self, escala=1):

        self.escala = escala

        u=escala/6.0
        r=6*u
        l=6*r
        direcoes = [-r, 0, r] 

        self.cor1 = (0.2, 0.3, 0.4) #grafite
        self.cor2 = color.white
        self.cor3 = (0.4, 0.1, 0.6) #roxo ou algo parecido
        self.cor4 = color.blue
        self.cor5 = color.red

        #elipses
        #elipses maiores tansparentes
        self.desenharElipse((0, 0, 0), 3, 2, 3, self.cor2, 0.4)
        self.desenharElipse ((0, 0.4, 0), 2, 1.5, 2, self.cor3, 0.4)
        #elipses central
        self.desenharElipse ((0, 0, 0), 3, 2, 3, self.cor3, 0.4, materials.marble)
        #elipses laterais de adorno
        self.desenharElipse ((0, -0.2, 1.2), 1.5, 1.5, 1, self.cor1, 0.3)
        self.desenharElipse ((0.7, -0.2, 0.2), 2, 1.75, 2, self.cor1, 0.3)
        self.desenharElipse ((0, -0.2, -1.2), 1.5, 1.5, 1, self.cor1, 0.3)
        self.desenharElipse ((-0.7* escala, -0.2, 0.2), 2, 1.75, 2, self.cor1, 0.3)

        #cilindros (da um formato de 'saia' a agua viva)
        self.desenharCilindro((0, -0.65, 0), (0, 0.7, 0), 1.479, self.cor3, 0.5)
        self.desenharCilindro((0, -1, 0), (0, 0.7, 0), 1.55, self.cor3, 0.5)

        #aneis (dao aparencias de riscos dentro da 'agua viva')
        self.desenharAnel((-0.1, 0, 0), (0, 0.5, 0.1), 1.3, 0.002, self.cor5)
        self.desenharAnel((-0.1, 0.3, 0), (0, 0.5, 0.1), 1.1, 0.002, self.cor5)
        self.desenharAnel((-0.1, 0.5, 0), (0, 0.5, 0.1), 1, 0.002, self.cor5)
        self.desenharAnel((-0.1, 0.7, 0), (0, 0.5, 0.1), 0.8, 0.004, self.cor5)
        self.desenharAnel((0.1, 0, 0), (0, 0.5, -0.1), 1.3, 0.002, self.cor5)
        self.desenharAnel((0.1, 0.3, 0), (0, 0.5, -0.1), 1.1, 0.002, self.cor5)
        self.desenharAnel((0.1, 0.5, 0), (0, 0.5, -0.1), 1, 0.002, self.cor5)
        self.desenharAnel((0.1, 0.7, 0), (0, 0.5, -0.1), 0.8, 0.004, self.cor5)
        self.desenharAnel((0.1, 1, 0), (0, 0, 0), 0.5, 0.004, self.cor5) 

        #Espirais
        self.desenharEspiral((0, -0.8, 0), (0, 1, 0), 1.4, 0.01, self.cor2, materials.marble)
        self.desenharEspiral((0, -0.4, 0), (0, 1, 0), 0.8, 0.01, self.cor2, materials.marble)

        self.desenharEspiral((0, -1.5, 0), (0, 1.5, 0), 0.3, 0.3, self.cor2, materials.marble)
        self.desenharEspiral((0, -1.1, 0), (0, 0.7, 0), 0.8, 0.35, self.cor2, materials.marble)

        self.desenharEspiral((0.5, -3, 0.3), (-0.5, 3, 0), 0.1, 0.15, self.cor2, materials.marble)
        self.desenharEspiral((-0.5, -3, -0.2), (0.5, 3, 0), 0.1, 0.15, self.cor2, materials.marble)
        self.desenharEspiral((0, -3, 0.3), (0, 3, 0), 0.1, 0.15, self.cor3, materials.marble)

        self.desenharEspiral((2, -2, 0.3), (-0.5, 1, 0), 0.05, 0.01, self.cor3)
        self.desenharEspiral((-2, -2, 0.3), (0.5, 1, 0), 0.05, 0.01, self.cor3)

        self.desenharEspiral((0, -2, -2), (0, 1, 0.5), 0.05, 0.01, self.cor3)
        self.desenharEspiral((0, -2, 2), (0, 1, -0.5), 0.05, 0.01, self.cor3)

        self.desenharEspiral((1, -2, -2), (-0.5, 1, 0.5), 0.05, 0.01, self.cor3)
        self.desenharEspiral((-1, -2, -2), (0.5, 1, 0.5), 0.05, 0.01, self.cor3)
        self.desenharEspiral((-1, -2, 2), (0.5, 1, -0.5), 0.05, 0.01, self.cor3)
        self.desenharEspiral((1, -2, 2), (-0.5, 1, -0.5), 0.05, 0.01, self.cor3)

        self.desenharEspiral((1.5, -2, -1.5), (-0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.5, -2, -1.5), (0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((1.5, -2, 1.5), (-0.5, 1, -0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.5, -2, 1.5), (0.5, 1, -0.5), 0.05, 0.01, self.cor2)

        self.desenharEspiral((1.25, -2, -1.75), (-0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.25, -2, -1.75), (0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((1.25, -2, 1.75), (-0.5, 1, -0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.25, -2, 1.75), (0.5, 1, -0.5), 0.05, 0.01, self.cor2)

        self.desenharEspiral((1.75, -2, -1.25), (-0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.75, -2, -1.25), (0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((1.75, -2, 1.25), (-0.5, 1, -0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.75, -2, 1.25), (0.5, 1, -0.5), 0.05, 0.01, self.cor2)

        self.desenharEspiral((1.40, -2, -1.60), (-0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.40, -2, -1.60), (0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((1.40, -2, 1.60), (-0.5, 1, -0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.40, -2, 1.60), (0.5, 1, -0.5), 0.05, 0.01, self.cor2)

        self.desenharEspiral((1.6, -2, -1.4), (-0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.6, -2, -1.4), (0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((1.6, -2, 1.4), (-0.5, 1, -0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-1.6, -2, 1.4), (0.5, 1, -0.5), 0.05, 0.01, self.cor2)

        self.desenharEspiral((2, -2, -1), (-0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-2, -2, -1), (0.5, 1, 0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((2, -2, 1), (-0.5, 1, -0.5), 0.05, 0.01, self.cor2)
        self.desenharEspiral((-2, -2, 1), (0.5, 1, -0.5), 0.05, 0.01, self.cor2)


    def desenharElipse(self, posicao=(0,0,0), comprimento=3, altura=2, largura=3, cor=color.yellow, opacidade=0.4, aparencia=materials.unshaded):
        return ellipsoid (
            frame = self.esqueleto,
            pos = (posicao[0] * self.escala, posicao[1] * self.escala, posicao[2] * self.escala),
            length = comprimento * self.escala,
            height = altura * self.escala,
            width = largura * self.escala,
            color = cor, opacity = opacidade, material = aparencia
            )
    def desenharCilindro(self, posicao=(0,-0.65,0), eixos=(0,0.7,0), raio=1, cor=color.yellow, opacidade=0.5):
        return cylinder(
            frame = self.esqueleto,
            pos = (posicao[0] * self.escala, posicao[1] * self.escala, posicao[2] * self.escala),
            axis = (eixos[0] * self.escala, eixos[1] * self.escala, eixos[2] * self.escala),
            radius = raio * self.escala,
            color = cor, opacity = opacidade
            )
    def desenharAnel(self, posicao=(0,0,0), eixos=(1,1,1), raio=1, espessura=0.5, cor=color.yellow):
        return ring(
            frame = self.esqueleto,
            pos = (posicao[0] * self.escala, posicao[1] * self.escala, posicao[2] * self.escala),
            axis = (eixos[0] * self.escala, eixos[1] * self.escala, eixos[2] * self.escala),
            radius = raio * self.escala,
            thickness = 0.1 * self.escala,
            color = cor
            )
    def desenharEspiral(self, posicao=(0,0,0), eixos=(1,1,1), raio=1, espessura=0.01, cor=color.yellow, aparencia=materials.unshaded):
        return helix(
            frame = self.esqueleto,
            pos = (posicao[0] * self.escala, posicao[1] * self.escala, posicao[2] * self.escala),
            axis = (eixos[0] * self.escala, eixos[1] * self.escala, eixos[2] * self.escala),
            radius = raio * self.escala,
            thickness = espessura * self.escala,
            color = cor, material = aparencia
            )

    def move (self, pos=(0,0,0)):
        self.esqueleto.pos = pos

    def rotate (self, angle=0, axis=(0,0,0), origin=(0,0,0)):
        self.esqueleto.rotate(angle=angle, axis=axis, origin=origin)
