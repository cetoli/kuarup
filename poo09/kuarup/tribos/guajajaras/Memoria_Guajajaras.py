"""
###################
  Guajajaras Game
###################
:Author: Tribo Guajajaras
:Contact: Tribo Guajajaras (Mestrado - NCE/UFRJ)
:Date: $Date: 2009/03/29$
:Status: This is a "work in progress"
:Revision: $Revision: 1.1$
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""
#! /usr/bin/env python
# -*- coding: UTF8 -*-

from visual import *
from math import *

TITLE = 'Jogo de Memoria - Guajajaras'
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
        botao1 = box(pos= ( -40, 40, 0), length=39, height=39,width=1,color=color.red,  opacity=1)
        botao2 = box(pos=(0, 40,0), length=39, height=39,width=1, color=color.green, opacity=1)
        botao3 = box(pos=(40, 40,0), length=39, height=39,width=1, color=color.cyan, opacity=1)       
        botao4 = box(pos=(-40, 0,0), length=39, height=39,width=1, color=color.cyan, opacity=1)
        botao6 = box(pos=(40, 0,0), length=39, height=39,width=1, color=color.magenta, opacity=1)        
        botao7 = box(pos=(-40, -40,0), length=39, height=39,width=1, color=color.magenta, opacity=1)
        botao8 = box(pos=(0, -40,0), length=39, height=39,width=1, color=color.red, opacity=1)
        botao9 = box(pos=(40, -40,0), length=39, height=39,width=1, color=color.green, opacity=1)         
        nome1 = label(pos=(0,8,0), text='Jogo da ' )        
        nome2 = label(pos=(0,-5,0), text='Memoria' )
        traira1 = Traira(escala =2.5, axis=(1,0,0), pos= (0,-90,10))
        traira1.esqueleto.rotate(angle=pi/2., axis=(1.5,0,0)) 
        submarino1 = Submarino (escala =3, axis=(-1,0,2), pos= ( -40, 0, -15))
        submarino2 = Submarino (escala =3, axis=(-1,0.3,2), pos= ( 0, -40, -15))
        tubarao1 = Tubarao (escala =.7, axis=(-1,0,2), pos= ( -40, 40,-13))
        tubarao2 = Tubarao (escala =.7, axis=(-1,0.7,2), pos= ( -40, -40,-13))
        aguaviva1 = Aguaviva(escala =5, axis=(-1,0,2), pos= (40,40,-12))
        aguaviva2 = Aguaviva(escala =5, axis=(-1,0.7,2), pos= (40,-36,-12))
        caracol1 = Caracol(escala =2.5, axis=(1,0,0), pos= (-5,40,-10))
        caracol2 = Caracol(escala =2.5, axis=(1,0,0), pos= (35,0,-10)) 
        traira1.mass = 1.0
        traira1.p = vector (0,1,0)
        side = side - thk*0.5 - traira1.esqueleto.x
        quadro=0
        aux = 0;
        dt = 0.5
        t=0
        auxLado = 0
        auxEsquerdaDireita = 0
        contapasso = 0  
        while 1:
# Captura de GIFs
            aux += 1
            if( aux == 5) :
                im = ImageGrab.grab((0,0,410,450))
                fn = "Carpa-Comum Game"+str(quadro)+".png"
                im.save(fn)
                aux = 0
            rate(50)

# Controle da Carpa            
            if scene.kb.keys:
                s = scene.kb.getkey()
                if (s == 'up'):
                    traira1.p = vector (0,1,0)
                    if (traira1.esqueleto.y >= 92):
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


            if (fabs(traira1.esqueleto.x - botao7.x)) < 20 and ( fabs (traira1.esqueleto.y - botao7.y)) < 20 and contapasso==0:
                botao7.opacity=0
                contapasso=1 
                
            if (fabs(traira1.esqueleto.x - botao8.x)) < 20 and ( fabs (traira1.esqueleto.y - botao8.y)) < 20 and contapasso==1:
                botao8.opacity=0
                contapasso=2  

            if ((fabs(traira1.esqueleto.x - botao8.x)) > 20 or ( fabs (traira1.esqueleto.y - botao9.y)) > 20 )and contapasso==2:
                botao7.opacity=1
                botao8.opacity=1
                contapasso=3  

            if (fabs(traira1.esqueleto.x - botao4.x)) < 20 and ( fabs (traira1.esqueleto.y - botao4.y)) < 20 and contapasso==3:
                botao4.opacity=0
                contapasso=4  

            if (fabs(traira1.esqueleto.x - botao8.x)) < 20 and ( fabs (traira1.esqueleto.y - botao8.y)) < 20 and contapasso==4:
                botao8.opacity=0
                contapasso=5 

            if (fabs(traira1.esqueleto.x - botao1.x)) < 20 and ( fabs (traira1.esqueleto.y - botao1.y)) < 20 and contapasso==5:
                botao1.opacity=0
                contapasso=6 

            if (fabs(traira1.esqueleto.x - botao7.x)) < 20 and ( fabs (traira1.esqueleto.y - botao7.y)) < 20 and contapasso==6:
                botao7.opacity=0
                contapasso=7  

            if (fabs(traira1.esqueleto.x - botao9.x)) < 20 and ( fabs (traira1.esqueleto.y - botao9.y)) < 20 and contapasso==7:
                botao9.opacity=0
                contapasso=8 
                
            if (fabs(traira1.esqueleto.x - botao6.x)) < 20 and ( fabs (traira1.esqueleto.y - botao6.y)) < 20 and contapasso==8:
                botao6.opacity=0
                contapasso=9  

            if ((fabs(traira1.esqueleto.x - botao6.x)) > 20 or ( fabs (traira1.esqueleto.y - botao6.y)) > 20 )and contapasso==9:
                botao6.opacity=1
                botao9.opacity=1
                contapasso=10  

            if (fabs(traira1.esqueleto.x - botao3.x)) < 20 and ( fabs (traira1.esqueleto.y - botao3.y)) < 20 and contapasso==10:
                botao3.opacity=0
                contapasso=11  

            if (fabs(traira1.esqueleto.x - botao9.x)) < 20 and ( fabs (traira1.esqueleto.y - botao9.y)) < 20 and contapasso==11:
                botao9.opacity=0
                contapasso=12  

            if (fabs(traira1.esqueleto.x - botao6.x)) < 20 and ( fabs (traira1.esqueleto.y - botao6.y)) < 20 and contapasso==12:
                botao6.opacity=0
                contapasso=13  

            if (fabs(traira1.esqueleto.x - botao2.x)) < 20 and ( fabs (traira1.esqueleto.y - botao2.y)) < 20 and contapasso==13:
                botao2.opacity=0
                contapasso=14 
                final = label(pos=(0,-60,0), text='PARABENS !!!' )                

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
        s=escala
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
class Caracol(SerMarinho):
    def desenha(self, escala=1):
        s=escala
        corpo = ellipsoid(frame = self.esqueleto, pos=(2,-4*s,0), length=7*s, height=s, width=4*s, color=color.yellow)
        casco1 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=8*s, height=8*s, width=2*s, color=color.orange, material=materials.wood)
        casco2 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=6*s, height=6*s, width=3*s, color=color.red, material=materials.wood)
        casco3 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=4*s, height=4*s, width=3.5*s, color=color.yellow, material=materials.wood)
        antenaE = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,-1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)
        antenaD = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)
        olhoE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.white, radius = 1.5*s, opacity=0.6)
        olhoD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.white, radius = 1.5*s, opacity=0.6)
        pupilaE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.black, radius = 1*s)
        pupilaD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.black, radius = 1*s)

class Tubarao(SerMarinho):
    def desenha(self, escala=1):
        corpo01 = ellipsoid(frame = self.esqueleto, pos=(0,-2*escala,0), length=35*escala, height=10*escala, width=10*escala, color = color.white, opacity=1)
        corpo02 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=40*escala, height=12.5*escala, width=15*escala, color = color.gray(0.5), opacity=1)
        corpo03 = ellipsoid(frame = self.esqueleto, pos=(-15*escala,-2*escala,0), length=15*escala, height=6*escala, width=5*escala, color = color.white, opacity=1)
        corpo04 = ellipsoid(frame = self.esqueleto, pos=(-15*escala,0,0), length=25*escala, height=9*escala, width=10*escala, color = color.gray(0.5), opacity=1)
        boca1 = pyramid (frame = self.esqueleto, pos=(14*escala,-3.5*escala,-2*escala), axis=(-1,0,0), length=10*escala, height=3*escala, width=2*escala, color = color.gray(0.5), opacity=1)
        boca2 = pyramid (frame = self.esqueleto, pos=(14*escala,-3.5*escala,2*escala), axis=(-1,0,0), length=10*escala, height=3*escala, width=2*escala, color = color.gray(0.5), opacity=1)
        boca3 = ellipsoid(frame = self.esqueleto, pos=(13*escala,-5*escala,0), axis=(1,-0.1,0), length=10*escala, height=1*escala, width=6.5*escala, color=color.white, opacity=1)
        boca4 = ellipsoid(frame = self.esqueleto, pos=(15*escala,-2.5*escala,0), axis=(1,0.4,0), length=10*escala, height=2*escala, width=7*escala, color=color.gray(0.5), opacity=1)
        boca5 = ellipsoid(frame = self.esqueleto, pos=(14.5*escala,-4.6*escala,0), axis=(1,-0.1,0), length=5.5*escala, height=1*escala, width=5*escala, color=color.red, opacity=1)
        boca6 = ellipsoid(frame = self.esqueleto, pos=(14.5*escala,-3.8*escala,0), axis=(1,0.4,0), length=5*escala, height=1.5*escala, width=5*escala, color=color.red, opacity=1)
        olho10 = ellipsoid (frame = self.esqueleto, pos=(11*escala,2*escala,-5.6*escala), axis=(-0.25,-0.4,1),length=0.5*escala, height=1*escala, width=1*escala, color = color.white)
        olho11 = ellipsoid (frame = self.esqueleto, pos=(11.5*escala,2*escala,-5.6*escala), axis=(-0.25,-0.4,1), length=0.5*escala, height=1*escala, width=1*escala, color = color.black)
        olho20 = ellipsoid (frame = self.esqueleto, pos=(11*escala,2*escala,5.6*escala), axis=(0.25,0.4,1), length=0.5*escala, height=1*escala, width=1*escala, color = color.white)
        olho21 = ellipsoid (frame = self.esqueleto, pos=(11.5*escala,2*escala,5.6*escala), axis=(0.25,0.4,1), length=0.5*escala, height=1*escala, width=1*escala, color = color.black)
        dente01 = cone(frame = self.esqueleto, pos=(15*escala,-2*escala,-3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente02 = cone(frame = self.esqueleto, pos=(15*escala,-2*escala,3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente03 = cone(frame = self.esqueleto, pos=(15.5*escala,-2*escala,-3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente04 = cone(frame = self.esqueleto, pos=(15.5*escala,-2*escala,3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente05 = cone(frame = self.esqueleto, pos=(16*escala,-2*escala,-2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente06 = cone(frame = self.esqueleto, pos=(16*escala,-2*escala,2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente07 = cone(frame = self.esqueleto, pos=(16.5*escala,-2*escala,-2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente08 = cone(frame = self.esqueleto, pos=(16.5*escala,-2*escala,2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente09 = cone(frame = self.esqueleto, pos=(17*escala,-1.75*escala,-2.5*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente10 = cone(frame = self.esqueleto, pos=(17*escala,-1.75*escala,2.5*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente11 = cone(frame = self.esqueleto, pos=(17.5*escala,-1.5*escala,-2.2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente12 = cone(frame = self.esqueleto, pos=(17.5*escala,-1.5*escala,2.2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente13 = cone(frame = self.esqueleto, pos=(18*escala,-1.75*escala,-2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente14 = cone(frame = self.esqueleto, pos=(18*escala,-1.75*escala,2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente15 = cone(frame = self.esqueleto, pos=(18.5*escala,-1.5*escala,-1.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente16 = cone(frame = self.esqueleto, pos=(18.5*escala,-1.5*escala,1.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente17 = cone(frame = self.esqueleto, pos=(18.75*escala,-1*escala,-1*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente18 = cone(frame = self.esqueleto, pos=(18.75*escala,-1*escala,1*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente19 = cone(frame = self.esqueleto, pos=(19*escala,-1*escala,-0.3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente20 = cone(frame = self.esqueleto, pos=(19*escala,-1*escala,0.3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        dente21 = cone(frame = self.esqueleto, pos=(14*escala,-5*escala,-2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente22 = cone(frame = self.esqueleto, pos=(14*escala,-5*escala,2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente23 = cone(frame = self.esqueleto, pos=(14.5*escala,-5*escala,-2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente24 = cone(frame = self.esqueleto, pos=(14.5*escala,-5*escala,2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente25 = cone(frame = self.esqueleto, pos=(15*escala,-5*escala,-2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente26 = cone(frame = self.esqueleto, pos=(15*escala,-5*escala,2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente27 = cone(frame = self.esqueleto, pos=(15.5*escala,-5*escala,-2.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente28 = cone(frame = self.esqueleto, pos=(15.5*escala,-5*escala,2.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente29 = cone(frame = self.esqueleto, pos=(16*escala,-5*escala,2*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente30 = cone(frame = self.esqueleto, pos=(16*escala,-5*escala,-2*escala), axis=(0,0.5*escala,0), radius=.3, color=color.white)
        dente31 = cone(frame = self.esqueleto, pos=(16.5*escala,-5*escala,-1.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente32 = cone(frame = self.esqueleto, pos=(16.5*escala,-5*escala,1.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente33 = cone(frame = self.esqueleto, pos=(17*escala,-5.2*escala,-1.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente34 = cone(frame = self.esqueleto, pos=(17*escala,-5.2*escala,1.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente35 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,-1*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente36 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,1*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente37 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,-0.3*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dente38 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,0.3*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        dorsal1 =  pyramid(frame = self.esqueleto, pos=(-2*escala,5.5*escala,0), size=(7*escala,20*escala,0.5*escala), color=color.gray(0.5), opacity=1)
        dorsal2 =  pyramid(frame = self.esqueleto, pos=(-16*escala,4*escala,0), size=(5*escala,5*escala,0.5*escala), color=color.gray(0.5), opacity=1)
        barriga1 = pyramid(frame = self.esqueleto, pos=(-16*escala,-3*escala,0), size=(7*escala,6*escala,0.5*escala), axis=(1,-0.3,0), color=color.white, opacity=1)
        peitoral1 = pyramid(frame = self.esqueleto, pos=(3*escala,-4*escala,3.5*escala), size=(12*escala,1*escala,6*escala), axis=(-0.5,0,1),color=color.gray(0.5), opacity=1)
        peitoral2 = pyramid(frame = self.esqueleto, pos=(3*escala,-4*escala,-3.5*escala), size=(12*escala,1*escala,6*escala), axis=(-0.5,0,-1),color=color.gray(0.5), opacity=1)
        peitoral3 = pyramid(frame = self.esqueleto, pos=(-10*escala,-4*escala,2.5*escala), size=(5*escala,1*escala,6*escala), axis=(-0.5,0,1),color=color.gray(0.5), opacity=1)
        peitoral4 = pyramid(frame = self.esqueleto, pos=(-10*escala,-4*escala,-2.5*escala), size=(5*escala,1*escala,6*escala), axis=(-0.5,0,-1),color=color.gray(0.5), opacity=1)
        rabo1 = pyramid(frame = self.esqueleto, pos=(-25*escala,1*escala,0), size=(16*escala,5*escala,0.5*escala),axis=(-1,1,0), color=color.gray(0.5), opacity=1)
        rabo2 = pyramid(frame = self.esqueleto, pos=(-28*escala,-2*escala,0), size=(7*escala,6*escala,0.5*escala), axis=(1,-0.3,0), color=color.gray(0.5), opacity=1)
        guelra1 = cylinder (frame = self.esqueleto, pos=(6*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))
        guelra2 = cylinder (frame = self.esqueleto, pos=(5*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))
        guelra3 = cylinder (frame = self.esqueleto, pos=(4*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))
        guelra4 = cylinder (frame = self.esqueleto, pos=(6*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))
        guelra5 = cylinder (frame = self.esqueleto, pos=(5*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))
        guelra6 = cylinder (frame = self.esqueleto, pos=(4*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))

class Submarino (SerMarinho):
    def desenha(self, escala=1):
        esc=escala
        # Desenha o Corpo Principal do Submarino
        corpo = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=10*esc, height=3*esc, width=3*esc, color = color.yellow)
        # Desenha a Ponte ( Passadiço ) do Submarino
        ponte = cylinder(frame = self.esqueleto, pos=(1*esc,0,0),axis=(0,3*esc,0), radius=1*esc, color = color.yellow)
        pontesup = cylinder(frame = self.esqueleto, pos=(1*esc,3*esc,0),axis=(0,0.4*esc,0*esc), radius=.4*esc, color = color.yellow)
        telescopio1 = cylinder(frame = self.esqueleto, pos=(1*esc,3.4*esc,0),axis=(0,0.6*esc,0), radius=.1*esc, color = color.yellow)
        telescopio2 = cylinder(frame = self.esqueleto, pos=(1*esc,3.9*esc,0),axis=(0.2*esc,0,0), radius=.1*esc, color = color.yellow)
        lemedaponte = box(frame = self.esqueleto, pos=(1*esc,2*esc,0), length=1*esc, height=0.05*esc, width=3*esc, color = color.yellow)
        # Desenha o leme de proa do Submarino
        lemedeproa = box(frame = self.esqueleto, pos=(3.5*esc,0*esc,0*esc), length=1*esc, height=0.05*esc, width=3.5*esc, color = color.yellow)
        # Desenha o leme de popa do Submarino
        popa1 = pyramid(frame = self.esqueleto, pos=(-4.5*esc,0,0), size=(1.5*esc,4*esc,0.1*esc), color = color.yellow )
        lemedapopa1 = box(frame = self.esqueleto, pos=(-5*esc,0,0), length=1*esc, height=4*esc, width=0.1*esc, color = color.yellow)
        popa2 = pyramid(frame = self.esqueleto, pos=(-4.5*esc,0,0), size=(1.5*esc,0.1*esc,4*esc), color = color.yellow )
        lemedapopa2 = box(frame = self.esqueleto, pos=(-5*esc,0,0), length=1*esc, height=0.1*esc, width=4*esc, color = color.yellow)
        esteira = helix(frame = self.esqueleto, pos=(-5.8*esc,0,0), axis=(-3*esc,0,0), radius=1*esc)        

class Aguaviva(SerMarinho):
    def desenha(self, escala=1):
        u=escala/6.0
        r=6*u
        l=6*r
        direcoes = [-r,0,r]         
        self.cor1 = (0.2,0.3,0.4)
        self.cor2 = color.white
        self.cor3 = (0.4,0.1,0.6)
        self.cor4 = color.blue
        self.cor5 = color.red
        self.desenharElipse((0,0,0),3*escala,2*escala,3*escala,self.cor2,0.4)
        self.desenharElipse ((0,0.4*escala,0),2*escala,1.5*escala,2*escala,self.cor3,0.4)
        self.desenharElipse ((0,0,0),3*escala,2*escala,3*escala,self.cor3,0.4,materials.marble)
        self.desenharElipse ((0,-0.2*escala,1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.desenharElipse ((0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)
        self.desenharElipse ((0,-0.2*escala,-1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.desenharElipse ((-0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)
        self.desenharCilindro((0,-0.65*escala,0), (0,0.7*escala,0),1.479*escala,self.cor3,0.5)
        self.desenharCilindro((0,-1*escala,0),(0,0.7*escala,0),1.55*escala,self.cor3,0.5)
        self.desenharAnel((-0.1*escala,0,0),(0,0.5*escala,0.1*escala),1.3*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.3*escala,0),(0,0.5*escala,0.1*escala), 1.1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.5*escala,0),(0,0.5*escala,0.1*escala),1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.7*escala,0),(0,0.5*escala,0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.desenharAnel((0.1*escala,0,0),(0,0.5*escala,-0.1*escala),1.3*escala,0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.3*escala,0),(0,0.5*escala,-0.1*escala),1.1*escala,0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.5*escala,0), (0,0.5*escala,-0.1*escala), 1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.7*escala,0),(0,0.5*escala,-0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.desenharAnel((0.1*escala,1*escala,0),(0,0,0),0.5,0.004*escala,self.cor5)       
        self.desenharEspiral((0,-0.8*escala,0),(0,1*escala,0), 1.4*escala,0.01*escala,self.cor2,materials.marble)
        self.desenharEspiral((0,-0.4*escala,0),(0,1*escala,0), 0.8*escala,0.01*escala,self.cor2,materials.marble)
        self.desenharEspiral((0,-1.5*escala,0),(0,1.5*escala,0),0.3*escala,0.3*escala,self.cor2,materials.marble)
        self.desenharEspiral((0,-1.1*escala,0),(0,0.7*escala,0),0.8*escala,0.35*escala,self.cor2,materials.marble)
        self.desenharEspiral((0.5*escala,-3*escala,0.3*escala),(-0.5*escala,3*escala,0),0.1*escala,0.15*escala,self.cor2,materials.marble)
        self.desenharEspiral((-0.5*escala,-3*escala,-0.2*escala),(0.5*escala,3*escala,0),0.1*escala,0.15*escala,self.cor2,materials.marble)
        self.desenharEspiral((0,-3*escala,0.3*escala),(0,3*escala,0),0.1*escala,0.15*escala,self.cor3,materials.marble)
        self.desenharEspiral((2*escala,-2*escala,0.3*escala),(-0.5*escala,1*escala,0),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((-2*escala,-2*escala,0.3*escala),(0.5*escala,1*escala,0),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((0,-2*escala,-2*escala),(0,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((0,-2*escala,2*escala),(0,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((1*escala,-2*escala,-2*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((-1*escala,-2*escala,-2*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((-1*escala,-2*escala,2*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((1*escala,-2*escala,2*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((1.5*escala,-2*escala,-1.5*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.5*escala,-2*escala,-1.5*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.5*escala,-2*escala,1.5*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.5*escala,-2*escala,1.5*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.25*escala,-2*escala,-1.75*escala), (-0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.25*escala,-2*escala,-1.75*escala), (0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.25*escala,-2*escala,1.75*escala), (-0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.25*escala,-2*escala,1.75*escala), (0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.75*escala,-2*escala,-1.25*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.75*escala,-2*escala,-1.25*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.75*escala,-2*escala,1.25*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.75*escala,-2*escala,1.25*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.40*escala,-2*escala,-1.60*escala),(-0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.40*escala,-2*escala,-1.60*escala),(0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.40*escala,-2*escala,1.60*escala),(-0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.40*escala,-2*escala,1.60*escala),(0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.6*escala,-2*escala,-1.4*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.6*escala,-2*escala,-1.4*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.6*escala,-2*escala,1.4*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.6*escala,-2*escala,1.4*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((2*escala,-2*escala,-1*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-2*escala,-2*escala,-1*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((2*escala,-2*escala,1*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-2*escala,-2*escala,1*escala), (0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
    def desenharElipse(self,posicao=(0,0,0),comprimento=3,altura=2,largura=3,cor=color.yellow,opacidade=0.4, aparencia=materials.unshaded):
        return ellipsoid(
            frame = self.esqueleto,pos = posicao, length = comprimento, height = altura, width = largura, color = cor, opacity = opacidade, material = aparencia)   
    def desenharCilindro(self,posicao=(0,-0.65,0),eixos=(0,0.7,0),raio=1,cor=color.yellow,opacidade=0.5):
        return cylinder(
            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, color = cor, opacity = opacidade)
    def desenharAnel(self,posicao=(0,0,0),eixos=(1,1,1),raio=1,espessura=0.5,cor=color.yellow):
        return ring(
            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, thickness = 0.1, color = cor)
    def desenharEspiral(self,posicao=(0,0,0),eixos=(1,1,1),raio=1,espessura=0.01,cor=color.yellow,aparencia=materials.unshaded):
        return helix(
            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, thickness = espessura, color = cor, material = aparencia)
 
if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()
