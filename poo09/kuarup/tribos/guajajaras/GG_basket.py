"""
##################
 Guajajaras Game
##################
:Author: Ticuna e Guajajaras 
:Contact: GuajajarasGame (Mestrado - NCE/UFRJ)
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

TITLE = 'GuajajarasGame'
import Image
import ImageGrab

restitution=1.0
friction=1

class Cenario:
    def principal(self):
        carpa=Carpacomum(escala =1.2, axis=(0,0,-1), pos= (-15,2,10))    
        caracol=Caracol(escala =0.5, axis=(0,0,-1), pos= (15,2.5,10))  
        ball = sphere(pos=(0,4,0), color=color.red)
        ball.velocityy = vector(0,-1,0)
        ball.velocityx=vector(2,0,0)

        ball2 = sphere(pos=(0,4,0), color=color.red)
        ball2.velocityy = vector(0,-1,0)
        ball2.velocityz = vector(0,-0.5,0.6)        

# Paredes e piso
        floor = box(length=40, height=0.5, width=40, color=color.blue)
        wallR = box(pos=vector(20,2,0), length=0.2, height=4, width=40, color=color.green)
        wallL = box(pos=vector(-20,2,0), length=0.2, height=4, width=40, color=color.green)
        wallUp = box(pos=vector(0,2,-20), length=40, height=4, width=0.2, color=color.green)
        wallDown = box(pos=vector(0,2,20), length=40, height=4, width=0.2, color=color.green)
        ring(pos=(0,10,-15),axis=(0,1,0),radius=2,thickness=0.2,color=color.red)
        tabela = box(pos=vector(0,11.50,-17), length=5, height=5, width=0.3, color=color.yellow)
        travetabela = box(pos=vector(0,6,-17), length=0.3, height=12, width=0.3, color=color.yellow)


        dt = 0.1
        timestep=0.5
        carpa.mass = 1.0
        carpa.p = vector (0,0,-1)
        caracol.mass = 1.0
        caracol.p = vector (0,0,-1)
        side=20
        thk = 0.5
#        side = side - thk*0.5 - carpa.esqueleto.x
        quadro=0
        aux = 0;
        tcp=0
        tcc=0
        auxLadocp = 0
        auxEsquerdaDireitacp = 0
        auxLadocc = 0
        auxEsquerdaDireitacc = 0        

        auxarremesso=0

        while 1:
#            # Captura de GIFs
            aux += 1
            if( aux == 5) :
                im = ImageGrab.grab((0,0,410,450))
                fn = "GuajajarasGame"+str(quadro)+".png"
                im.save(fn)
                aux = 0
      
            rate(50)

            if caracol.esqueleto.x < 0:
                auxarremesso=1
            else:
                auxarremesso=0

            if (auxarremesso == 0):
                
                ball.opacity=1
                ball2.opacity=0
                rate(50)

                ball.pos = ball.pos + ball.velocityy*dt+ ball.velocityx*timestep
                
                if ball.y < 0 :
                    ball.velocityy.y = -ball.velocityy.y
                else:
                    ball.velocityy.y = ball.velocityy.y - 9.8*dt

                if ball.x > wallR.x or ((fabs(caracol.esqueleto.x - ball.pos.x) < 3) and ( fabs (caracol.esqueleto.z - ball.pos.z) < 3 )):
                    ball.velocityx.x = -ball.velocityx.x 

                if ball.x < wallL.x or ((fabs(carpa.esqueleto.x - ball.pos.x) < 3) and ( fabs (carpa.esqueleto.z - ball.pos.z) < 3 )):
                    ball.velocityx.x = -ball.velocityx.x

            if (auxarremesso == 1):

                ball.opacity=0
                ball2.opacity=1
                
                ball2.pos = ball2.pos + ball2.velocityy*dt - ball2.velocityz*timestep        
                                
                if ball2.z < -16 :
                    break
               

#Define movimentos da carpa

            if scene.kb.keys:
                s = scene.kb.getkey()

                if (s == 'up'):
                    carpa.p = vector (0,0,-1)
                    if (carpa.esqueleto.z <= -17):
                        auxLadocp += 0
                    else:
                        auxLadocp = auxLadocp - 1
                        
                elif (s == 'down'):
                    carpa.p = vector (0,0,1)
                    if (carpa.esqueleto.z >= 17):
                        auxLadocp -= 0
                    else:
                        auxEsquerdaDireitacp
                        auxLadocp += 1
                    
                elif (s == 'left'):
                    carpa.p = vector (-1,0,0)
                    if (carpa.esqueleto.x <= -17):
                        auxEsquerdaDireitacp -= 0
                    else:
                        auxEsquerdaDireitacp -= 1

                elif (s == 'right'):
                    carpa.p = vector (1,0,0)
                    if (carpa.esqueleto.x >= 17):
                        auxEsquerdaDireitacp += 0
                    else:
                        auxEsquerdaDireitacp += 1
                                
                elif (s == 'q'):
                    print 'TCHAU'
                    break
                    quit



#Define movimentos caracolauxLadocc

                if (s == 'w'):
                    caracol.p = vector (0,0,-1)
                    if (caracol.esqueleto.z <= -16):
                        auxLadocc += 0
                    else:
                        auxLadocc = auxLadocc - 1
                        
                elif (s == 's'):
                    caracol.p = vector (0,0,1)
                    if (caracol.esqueleto.z >= 16):
                        auxLadocc -= 0
                    else:
                        auxLadocc += 1
                    
                elif (s == 'a'):
                    caracol.p = vector (-1,0,0)
                    if (caracol.esqueleto.x <= -16):
                        auxEsquerdaDireitacc -= 0
                    else:
                        auxEsquerdaDireitacc -= 1

                elif (s == 'd'):
                    caracol.p = vector (1,0,0)
                    if (caracol.esqueleto.x >= 16):
                        auxEsquerdaDireitacc += 0
                    else:
                        auxEsquerdaDireitacc += 1
                                
            caracol.esqueleto.axis.z = caracol.p.z + auxLadocc
            caracol.esqueleto.axis.x = caracol.p.x + auxEsquerdaDireitacc
            caracol.esqueleto.axis.z = caracol.p.z
            caracol.esqueleto.z += auxLadocc
            caracol.esqueleto.x += auxEsquerdaDireitacc
            auxLadocc = 0
            auxEsquerdaDireitacc = 0                    

            carpa.esqueleto.axis.z = carpa.p.z + auxLadocp
            carpa.esqueleto.axis.x = carpa.p.x + auxEsquerdaDireitacp
            carpa.esqueleto.axis.z = carpa.p.z
            carpa.esqueleto.z += auxLadocp
            carpa.esqueleto.x += auxEsquerdaDireitacp
            rate(50)
            tcp = tcp + dt
            tcc = tcc + dt            
            auxLadocp = 0
            auxEsquerdaDireitacp = 0

            carpa.proximoFrame()
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
class Carpacomum (SerMarinho): 
    def desenha(self, escala=1):
        esc=escala*5

        
        corpo = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=0.8*esc, height=0.3*esc, width=0.3*esc , color= color.yellow, opacity=1)
        rabo = pyramid(frame = self.esqueleto, pos=(-0.5*esc,0*esc,0*esc), size=(0.4*esc,0.6*esc,0.01*esc),  axis = (1,0,0), color=color.blue)
        barbatanadir = pyramid(frame = self.esqueleto, pos=(0.15*esc,0*esc,0.2*esc), size=(0.25*esc,0.005*esc,0.1*esc),  axis = (0.3,0,-1), color=color.blue)
        barbatanaesq = pyramid(frame = self.esqueleto, pos=(0.15*esc,0*esc,-0.2*esc), size=(0.15*esc,0.005*esc,0.1*esc),  axis = (0.3,0,1), color=color.blue)
        barbatanasup = pyramid(frame = self.esqueleto, pos=(-0.1*esc,0.13*esc,0*esc), size=(0.3*esc,0.25*esc,0.01*esc),  axis = (1,0,0), color=color.blue)
        olhodir = sphere(frame = self.esqueleto, pos=(0.3*esc,0.07*esc,0.07*esc), radius=0.02*esc, color=color.white, opacity=0.5)
        irisolhodir = sphere(frame = self.esqueleto, pos=(0.3*esc,0.07*esc,0.07*esc), radius=0.01*esc, color=color.black)
        olhoesq = sphere(frame = self.esqueleto, pos=(0.3*esc,0.07*esc,-0.07*esc), radius=0.02*esc, opacity=0.5)
        irisolhoesq = sphere(frame = self.esqueleto, pos=(0.3*esc,0.07*esc,-0.07*esc), radius=0.01*esc, color=color.black)
        labio = ellipsoid(frame = self.esqueleto, pos=(0.38*esc,0*esc,0*esc), length=0.05*esc, height=0.05*esc, width=0.1*esc, color=color.blue )
        boca = ellipsoid(frame = self.esqueleto, pos=(0.382*esc,0*esc,0*esc), length=0.05*esc, height=0.02*esc, width=0.1*esc,color=color.black )
        bone = sphere(frame = self.esqueleto, pos=(0.27*esc,0.1*esc,0*esc), radius=0.06*esc, color=color.red)
        aba = cylinder(frame = self.esqueleto, pos=(0.31*esc,0.1*esc,0*esc),axis=(0.005,0.01,0), radius=0.05*esc, color=color.red)

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
        olhoE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.white, radius = 1.5*s, opacity=0.3)
        olhoD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.white, radius = 1.5*s, opacity=0.3)
        pupilaE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.black, radius = 1*s)
        pupilaD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.black, radius = 1*s)

    def proximoFrame(self):
        pass

if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()
