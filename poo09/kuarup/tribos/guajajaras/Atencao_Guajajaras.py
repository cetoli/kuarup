"""
##################
 Guajajaras Game
##################
:Author: Guajajaras
:Contact: Guajajaras (Mestrado - NCE/UFRJ)
:Date: $Date: 2009/04/25$
:Status: This is a "work in progress"
:Revision: $Revision: 1.1$
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""
#! /usr/bin/env python
# -*- coding: UTF8 -*-
from visual import *
from math import *

TITLE = 'Guajajaras Game'
import Image
import ImageGrab

class Cenario:
    def principal(self):
        side = 100
        thk = 0.3
        s2 = 2*side - thk
        s3 = 2*side + thk

        wallR = box (pos=( side, 0, 0), length=thk, height=s2,  width=10,  color = color.red, opacity=1)
        wallL = box (pos=(-side, 0, 0), length=thk, height=s2,  width=10,  color = color.red, opacity=1)
        wallB1 = box (pos=(55, -side, 0), length=90,  height=thk, width=10,  color = color.red, opacity=1)
        wallB2 = box (pos=(-55, -side, 0), length=90,  height=thk, width=10,  color = color.red, opacity=1)        
        wallB1 = box (pos=(55, side, 0), length=90,  height=thk, width=10,  color = color.red, opacity=1)
        wallB2 = box (pos=(-55, side, 0), length=90,  height=thk, width=10,  color = color.red, opacity=1) 
        portaosup =  box (pos=(0, side, 0), length=20,  height=thk, width=10,  color = color.red, opacity=1)        

        Caracol1=Caracolok(escala =8, axis=(-1,-0.2,2.5), pos= (-35,50,0))
        Caracol2=Caracolnok(escala =8,  axis=(-2.1,-0.2,2.5), pos= (35,50,0))
        pergunta = label(pos=(0,10,0), text='Ha quantas diferencas aqui ?' )
        label1 = label(pos=(-60,-10,0), text='1' )
        label2 = label(pos=(-20,-10,0), text='2' )
        label3 = label(pos=(20,-10,0), text='3' )
        label4 = label(pos=(60,-10,0), text='4' )
        botao1 = box(pos=(-60,-10,0), length=10, height=10,width=5, color=color.blue)
        botao2 = box(pos=(-20,-10,0), length=10, height=10,width=5, color=color.blue)
        botao3 = box(pos=(20,-10,0), length=10, height=10,width=5, color=color.blue)        
        botao4 = box(pos=(60,-10,0), length=10, height=10,width=5, color=color.blue)
                
        traira1=Traira(escala =2.5, axis=(1,0,0), pos= (0,-90,0))              
        
        traira1.mass = 1.0
        traira1.p = vector (0,1,0)

        side = side - thk*0.5 - traira1.esqueleto.x
        quadro=0
        aux = 0;
        dt = 0.5
        t=0
        auxLado = 0
        auxEsquerdaDireita = 0
 
        while 1:
# Captura de GIFs
            aux += 1
            if( aux == 5) :
                im = ImageGrab.grab((0,0,410,450))
                fn = "Carpa-Comum Game"+str(quadro)+".png"
                im.save(fn)
                aux = 0
                
            rate(50)

# Controle da Traira            
            if scene.kb.keys:
                s = scene.kb.getkey()

                if (s == 'up'):
                    traira1.p = vector (0,1,0)
                    if (traira1.esqueleto.y >= -20):
                        auxLado += 0
                    else:
                        auxLado += 1
                        
                elif (s == 'down'):
                    traira1.p = vector (0,-1,0)
                    if (traira1.esqueleto.y <= -92):
                        auxLado -= 0
                    else:
                        auxLado -= 1
                    
                elif (s == 'left'):
                    traira1.p = vector (-1,0,0)
                    if (traira1.esqueleto.x <= -90):
                        auxEsquerdaDireita -= 0
                    else:
                        auxEsquerdaDireita -= 1

                elif (s == 'right'):
                    traira1.p = vector (1,0,0)
                    if (traira1.esqueleto.x >= 90):
                        auxEsquerdaDireita += 0
                    else:
                        auxEsquerdaDireita += 1
                                
                elif (s == 'q'):
                    print 'TCHAU'
                    break
                    quit

            traira1.esqueleto.axis.y = traira1.p.y + auxLado
            traira1.esqueleto.axis.x = traira1.p.x + auxEsquerdaDireita
            traira1.esqueleto.axis.z = traira1.p.z
            traira1.esqueleto.y += auxLado
            traira1.esqueleto.x += auxEsquerdaDireita
            rate(100)
            t = t + dt

            auxLado = 0
            auxEsquerdaDireita = 0
          
     

            if ( traira1.esqueleto.y > side + 10):
                        label(pos=(60,120,0), text='Parabens !!!')
                        break


            if ( traira1.esqueleto.y < -side - 10):
                label(pos=(-80,-80,0), text='Voce tem que subir !!!' )
                traira1.p = vector (0,1,0)
            if (fabs(traira1.esqueleto.x - botao1.x)) < 10 and ( fabs (traira1.esqueleto.y - botao1.y)) < 15:
                label(pos=(-40,-40,0), text='VOCE ERROU !!!' )
            if (fabs(traira1.esqueleto.x - botao2.x)) < 10 and ( fabs (traira1.esqueleto.y - botao2.y)) < 15:
                label(pos=(-40,-40,0), text='VOCE ERROU !!!' )                
            if (fabs(traira1.esqueleto.x - botao3.x)) < 10 and ( fabs (traira1.esqueleto.y - botao3.y)) < 15:
                label(pos=(-40,-40,0), text='VOCE ERROU !!!' )
            if (fabs(traira1.esqueleto.x - botao4.x)) < 10 and ( fabs (traira1.esqueleto.y - botao1.y)) < 15:
                label(pos=(-40,-40,0), text='VOCE ACERTOU !!!' )
            traira1.proximoFrame()
            quadro += 1
                    
'''
Classe base de qualquer ser marinho
'''
class SerMarinho():
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)

    def desenha(self): pass
'''
Estas classes são as especializações da classe SerMarinho...
'''
class Traira(SerMarinho):
    def desenha(self, escala=5):
        cabeca01 = ellipsoid(frame = self.esqueleto, pos=(5,1,0), length=10, height=9, width=8, color=color.green)
        cabeca02 = cone(frame = self.esqueleto, pos=(0,3,0), axis=(6,2,0), radius=3, color=color.green, opacity=1)
        boca = ring(frame = self.esqueleto, pos=(10,1,0), axis=(1,0,0), radius=1, thickness=0.5, color=color.red)
        olho01 = sphere(frame = self.esqueleto, pos=(5,4,3), radius=1, opacity=.5)
        olho02 = sphere(frame = self.esqueleto, pos=(5,4,3), radius=.5, color=color.black)
        olho11 = sphere(frame = self.esqueleto, pos=(5,4,-3), radius=1, opacity=.5)
        olho02 = sphere(frame = self.esqueleto, pos=(5,4,-3), radius=.5, color=color.black)
        corpo01 = sphere(frame = self.esqueleto, pos=(-1,0,0), radius=6, color = color.green, opacity=1)
        rabo1 = pyramid(frame = self.esqueleto, pos=(-12,0,0), size=(12,12,.3), color=color.green)
        rabo2 = pyramid(frame = self.esqueleto, pos=(-10,0,2), size=(6,6,.3), axis=(1,0,-0.4), color=color.blue)
        rabo3 = pyramid(frame = self.esqueleto, pos=(-10,0,-2), size=(6,6,.3), axis=(1,0,0.4), color=color.blue)
        dorsal1 = pyramid(frame = self.esqueleto, pos=(-4,4,0), size=(8,15,.3), axis=(2,.2,0),color=color.green)
        peitoralBE = pyramid(frame = self.esqueleto, pos=(-2,-1,9), size=(12,6,.3), axis=(2,.2,-4),color=color.blue)
        peitoralBB = pyramid(frame = self.esqueleto, pos=(-2,-1,-9), size=(12,6,.3), axis=(2,.2,4),color=color.blue)

    def proximoFrame(self):
        pass
class Caracolok(SerMarinho):
    def desenha(self, escala=1):
        s=escala
        corpo = ellipsoid(frame = self.esqueleto, pos=(2,-4*s,0), length=7*s, height=s, width=4*s, color=color.yellow)
        casco1 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=8*s, height=8*s, width=2*s, color=color.orange, material=materials.wood)
        casco2 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=6*s, height=6*s, width=3*s, color=color.red, material=materials.wood)
        casco3 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=4*s, height=4*s, width=3.5*s, color=color.yellow, material=materials.wood)
        antenaE = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,-1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)
        antenaD = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)
        olhoE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.white, radius = 1.5*s, opacity=0.3)
        olhoD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.white, radius = 1.5*s, opacity=0.3)
        pupilaE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.black, radius = 1*s)
        pupilaD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.black, radius = 1*s)
class Caracolnok(SerMarinho):
    def desenha(self, escala=1):
        s=escala
        corpo = ellipsoid(frame = self.esqueleto, pos=(2,-4*s,0), length=7*s, height=s, width=4*s, color=color.yellow)
        casco1 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=8*s, height=8*s, width=2*s, color=color.orange, material=materials.wood)
        casco2 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=6*s, height=6*s, width=3*s, color=color.yellow, material=materials.wood)
#        casco3 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=4*s, height=4*s, width=3.5*s, color=color.yellow, material=materials.wood)
        antenaE = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,-1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)
        antenaD = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)
        olhoE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.white, radius = 1.5*s, opacity=0.3)
        olhoD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.white, radius = 1.5*s, opacity=0.3)
#        pupilaE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.black, radius = 1*s)
#        pupilaD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.black, radius = 1*s)



if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()
