#! /usr/bin/env python
# -*- coding: UTF8 -*-
"""
####################
   Peixe Traíra
####################
:Author: André Sion Fernandes Muniz Corrêa
:Contact: andre.sion@gmail.com
:Date: $Date: 2009/03/09  $
:Status: This is a "work in progress"
:Revision: $Revision: 1.00 $
:Home: `KUARUP - PBWiki <http://kuarup2009.pbwiki.com/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""
"""
As traíras são peixes de origem pré-histórica, da família “Erythrinidae”,
que pertencem ao gênero “Hopliasgill”, e são denominadas cientificamente
como “Hoplías malabacicus malabaricus (BLOCH, 1794) lobó, traira” .
 
São peixes de pequeno porte, podendo raramente alcançar  40 cm, e pesar
em torno de 2 Kg. Tem coloração verde, com listras transversais em castanho
escuro sobre a linha dorsal lateral de cor também castanho escuro.
Eventualmente os machos podem apresentar coloração mais escura, porém não
confundir com seu parente “Trairão”  “Hoplias lacerdae (RIBEIRO, 1908). Trairão”,
de coloração preta, de grande peso e tamanho.
 
As traíras são peixes com escamas, possuem hábitos alimentares piscívoros, isto é,
alimentam-se de pequenos peixes, insetos, larvas, anfíbios, etc.
"""
from visual import *
scene.background = color.gray(0.0)
cabeca01 = ellipsoid(pos=(5,1,0), length=10, height=9, width=8, color=color.green)
cabeca02 = cone(pos=(0,3,0), axis=(6,2,0), radius=3, color=color.green, opacity=1)
boca = ring(pos=(10,1,0), axis=(1,0,0), radius=1, thickness=0.5, color=color.red)
olho01 = sphere(pos=(5,4,3), radius=1, opacity=.5)
olho02 = sphere(pos=(5,4,3), radius=.5, color=color.black)
 
olho11 = sphere(pos=(5,4,-3), radius=1, opacity=.5)
olho02 = sphere(pos=(5,4,-3), radius=.5, color=color.black)
corpo01 = sphere(pos=(-1,0,0), radius=6, color = color.green, opacity=1)
 
rabo1 = pyramid(pos=(-12,0,0), size=(12,12,.3), color=color.green)
rabo2 = pyramid(pos=(-10,0,2), size=(6,6,.3), axis=(1,0,-0.4), color=color.blue)
rabo3 = pyramid(pos=(-10,0,-2), size=(6,6,.3), axis=(1,0,0.4), color=color.blue)
 
dorsal1 = pyramid(pos=(-4,4,0), size=(8,15,.3), axis=(2,.2,0),color=color.green)
peitoralBE = pyramid(pos=(-2,-1,9), size=(12,6,.3), axis=(2,.2,-4),color=color.blue)
peitoralBB = pyramid(pos=(-2,-1,-9), size=(12,6,.3), axis=(2,.2,4),color=color.blue)
 
