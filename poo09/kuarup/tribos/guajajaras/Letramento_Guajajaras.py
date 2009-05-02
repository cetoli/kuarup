"""
##################
 Guajajaras Game
##################
:Author: Guajajaras 
:Contact: Guajajaras (Mestrado - NCE/UFRJ)
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
        wallcentral = box (pos=(0, 64, 0), length=200,  height=thk, width=10,  color = color.red, opacity=1)
        portaosup =  box (pos=(0, side, 0), length=20,  height=thk, width=10,  color = color.red, opacity=1)
   
        barraa = box ( pos=( -70, 72,0), length=20, height=1,  width=1,  color = color.red, opacity=1)
        barrae = box ( pos=( -33, 72,0), length=20, height=1,  width=1,  color = color.red, opacity=1)
        barrai = box ( pos=( 0, 72,0), length=20, height=1,  width=1,  color = color.red, opacity=1)
        barrao = box ( pos=( 33, 72,0), length=20, height=1,  width=1,  color = color.red, opacity=1)
        barrau = box ( pos=( 70, 72,0), length=20, height=1,  width=1,  color = color.red, opacity=1)
        
#Define vogais superiores
        asladoe = box ( pos=( -80, 85, 0), length=1, height=20,  width=2, opacity=0 )
        asladod = box ( pos=( -60, 85, 0), length=1, height=20,  width=2, opacity=0)
        aslados = box ( pos=( -70, 95, 0), length=20, height=1,  width=2, opacity=0)
        asladom = box ( pos=( -70, 85, 0), length=20, height=1,  width=2, opacity=0)
        
        esladoe = box ( pos=( -43,85, 0), length=1, height=20,  width=1, opacity=0)
        eslados = box ( pos=( -33, 95, 0), length=20, height=1,  width=1, opacity=0)
        esladom = box ( pos=( -33, 85, 0), length=20, height=1,  width=1, opacity=0)
        esladoi = box ( pos=( -33, 75, 0), length=20, height=1,  width=1, opacity=0)

        islado = box ( pos=( 0, 85, 0), length=1, height=20,  width=1, opacity=0)

        osladoe = box ( pos=( 23, 85, 0), length=1, height=20,  width=1, opacity=0 )
        osladod = box ( pos=( 43, 85, 0), length=1, height=20,  width=1, opacity=0)
        oslados = box ( pos=( 33, 95, 0), length=20, height=1,  width=1, opacity=0)
        osladoi = box ( pos=( 33, 75, 0), length=20, height=1,  width=1, opacity=0)

        usladoe = box ( pos=( 60, 85, 0), length=1, height=20,  width=1, opacity=0)
        usladod = box ( pos=( 80, 85, 0), length=1, height=20,  width=1, opacity=0)
        usladoi = box ( pos=( 70, 75, 0), length=20, height=1,  width=1, opacity=0)                
        
#Define vogais inferiores
        ailadoe = box ( pos=( 65, -65, 0), length=1, height=20,  width=2)
        ailadod = box ( pos=( 85, -65, 0), length=1, height=20,  width=2)
        ailados = box ( pos=( 75, -55, 0), length=20, height=1,  width=2)
        ailadom = box ( pos=( 75, -65,0 ), length=20, height=1,  width=2)
        
        eiladoe = box ( pos=( -65,35, 0), length=1, height=20,  width=1)
        eilados = box ( pos=(-55, 45,0), length=20, height=1,  width=1)
        eiladom = box ( pos=(-55, 35,0), length=20, height=1,  width=1)
        eiladoi = box ( pos=(-55, 25,0), length=20, height=1,  width=1)

        iilado = box ( pos=( 90, 25,0), length=1, height=20,  width=1)


        oiladoe = box ( pos=( -80, -80, 0), length=1, height=20,  width=1 )
        oiladod = box ( pos=( -60, -80, 0), length=1, height=20,  width=1)
        oilados = box ( pos=( -70, -70, 0), length=20, height=1,  width=1)
        oiladoi = box ( pos=( -70, -90, 0), length=20, height=1,  width=1)

                            
        uiladoe = box ( pos=( 15, 15, 0), length=1, height=20,  width=1)
        uiladod = box ( pos=( 35, 15, 0), length=1, height=20,  width=1)
        uiladoi = box ( pos=( 25, 5, 0), length=20, height=1,  width=1)          

        botaoa = box(pos= ( 75, -65,0), length=5, height=5,width=1, color=color.blue, opacity=0)
        botaoe = box(pos=(-55, 35,0), length=5, height=5,width=1, color=color.blue, opacity=0)
        botaoi = box(pos=(90, 25,0), length=5, height=5,width=1, color=color.blue, opacity=0)       
        botaoo = box(pos=(-70, -80,0), length=5, height=5,width=1, color=color.blue, opacity=0)
        botaou = box(pos=(25, 15,0), length=5, height=5,width=1, color=color.blue, opacity=0)
        
        objetivo = label(pos=(0,110,0), text=' <<< Organize as vogais >>>' )

        traira1=Traira(escala =2.5, axis=(1,0,0), pos= (0,-90,0), opacity=0)              

        traira1.mass = 1.0
        traira1.p = vector (0,1,0)

        side = side - thk*0.5 - traira1.esqueleto.x
        quadro=0
        aux = 0;
        dt = 0.5
        t=0
        auxLado = 0
        auxEsquerdaDireita = 0
        contavogal = 1
 
        while 1:
# Captura de GIFs
            aux += 1
            if( aux == 5) :
                im = ImageGrab.grab((0,0,410,450))
                fn = "Traira Game"+str(quadro)+".png"
                im.save(fn)
                aux = 0
                
            rate(50)

# Controle da Traira1            
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
               
            if (fabs(traira1.esqueleto.x - botaoa.x)) < 20 and ( fabs (traira1.esqueleto.y - botaoa.y)) < 20 and contavogal==1:
                asladoe.opacity =1
                asladod.opacity =1
                aslados.opacity =1
                asladom.opacity =1
                ailadoe.opacity =0
                ailadod.opacity =0
                ailados.opacity =0
                ailadom.opacity =0
                contavogal=2

            if (fabs(traira1.esqueleto.x - botaoe.x)) < 20 and ( fabs (traira1.esqueleto.y - botaoe.y)) < 20 and contavogal==2:
                esladoe.opacity =1
                eslados.opacity =1
                esladom.opacity =1
                esladoi.opacity =1
                eiladoe.opacity =0
                eilados.opacity =0
                eiladom.opacity =0
                eiladoi.opacity =0
                contavogal=3              

            if (fabs(traira1.esqueleto.x - botaoi.x)) < 20 and ( fabs (traira1.esqueleto.y - botaoi.y)) < 20 and contavogal==3:
                islado.opacity =1
                iilado.opacity =0                
                contavogal=4          
                 
            if (fabs(traira1.esqueleto.x - botaoo.x)) < 20 and ( fabs (traira1.esqueleto.y - botaoo.y)) < 20 and contavogal==4:
                osladoe.opacity =1
                osladod.opacity =1
                oslados.opacity =1
                osladoi.opacity =1
                oiladoe.opacity =0
                oiladod.opacity =0
                oilados.opacity =0
                oiladoi.opacity =0
                contavogal=5

            if (fabs(traira1.esqueleto.x - botaou.x)) < 20 and ( fabs (traira1.esqueleto.y - botaou.y)) < 20 and contavogal==5:
                usladoe.opacity =1
                usladod.opacity =1
                usladoi.opacity =1
                uiladoe.opacity =0
                uiladod.opacity =0
                uiladoi.opacity =0
                final = label(pos=(0,0,0), text=' Parabens !!! ' )
                contavogal=6

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

class Alfa(SerMarinho):
    def desenha(self, escala=1):
        ladoe = box (frame = self.esqueleto, pos=( 0, 0, 0), length=1, height=20,  width=2 )
        ladod = box (frame = self.esqueleto, pos=( 20, 0, 0), length=1, height=20,  width=2)
        lados = box (frame = self.esqueleto, pos=( 10, 10, 0), length=20, height=1,  width=2)
        ladom = box (frame = self.esqueleto, pos=( 10, 0, 0), length=20, height=1,  width=2)


class Echo(SerMarinho):
    def desenha(self, escala=1):
        ladoe = box (frame = self.esqueleto, pos=( 0, 0, 0), length=1, height=20,  width=1)
        lados = box (frame = self.esqueleto, pos=( 10, 10, 0), length=20, height=1,  width=1)
        ladom = box (frame = self.esqueleto, pos=( 10, 0, 0), length=20, height=1,  width=1)
        ladoi = box (frame = self.esqueleto, pos=( 10, -10, 0), length=20, height=1,  width=1)


class India(SerMarinho):
    def desenha(self, escala=1):
        lado = box (frame = self.esqueleto, pos=( 0, 0, 0), length=1, height=20,  width=1)
        
class Oscar(SerMarinho):
    def desenha(self, escala=1):
        ladoe = box (frame = self.esqueleto, pos=( 0, 0, 0), length=1, height=20,  width=1 )
        ladod = box (frame = self.esqueleto, pos=( 20, 0, 0), length=1, height=20,  width=1)
        lados = box (frame = self.esqueleto, pos=( 10, 10, 0), length=20, height=1,  width=1)
        ladoi = box (frame = self.esqueleto, pos=( 10, -10, 0), length=20, height=1,  width=1)
        
class Uniform(SerMarinho):
    def desenha(self, escala=1):
        ladoe = box (frame = self.esqueleto, pos=( 0, 0, 0), length=1, height=20,  width=1)
        ladod = box (frame = self.esqueleto, pos=( 20, 0, 0), length=1, height=20,  width=1)
        ladoi = box (frame = self.esqueleto, pos=( 10, -10, 0), length=20, height=1,  width=1)

if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()
