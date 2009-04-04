#! /usr/bin/env python
# -*- coding: UTF8 -*-

"""
############################################
Guajajara e seu problema
############################################
:Author: André Sion
:Contact: andre.sion@gmail.com
:Date: $Date: 2009/03/30  $
:Status: This is a "work in progress"
:Revision: $Revision: 1.00 $ 
:Home: `KUARUP - PBWiki <http://kuarup2009.pbwiki.com/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""

from visual import *
from math import *

TITLE = 'Saia da Área de Perigo'

import Image
import ImageGrab

class Cenario:
    def __init__(self):
        self.scene2 = display(title = "Tribo Guajajara", center= (0,0,0), x=0, y=0)
        self.scene2.x, self.scene2.y = 0, 0
        self.scene2.select()
        self.scene2.autoscale = 1
        self.scene2.autocenter = 1

    def principal(self):
        # Instanciando os peixes do aquário
        traira=Traira(escala =1, axis=(1,0,1), pos= (0,-115,0))         #
        tubarao1=Tubarao(escala =1, axis=(1,0,0), pos= (-50,20,0))          #
        tubarao2=Tubarao(escala =1, axis=(-1,0,0), pos= (-40,-60,0))        #
        tubarao3=Tubarao(escala =1, axis=(1,0,0), pos= (-10,80,0))          #
        tubarao4=Tubarao(escala =1, axis=(1,0,0), pos= (10,-90,0))          #
        aguaviva1=AguaViva(escala =3, axis=(1,0,0), pos= (40,-20,0))        # 
        aguaviva2=AguaViva(escala =3, axis=(-1,0,0), pos= (50,60,0))        #  

        # Delimitação do aquário
        side = 100
        thk = 0.3
        s2 = 2*side - thk
        s3 = 2*side + thk
        wallR = box (pos=( side, 0, 0), length=thk, height=s2,  width=10,  color = color.blue, opacity=1)
        wallL = box (pos=(-side, 0, 0), length=thk, height=s2,  width=10,  color = color.blue, opacity=1)
        wallB1 = box (pos=(55, -side, 0), length=90,  height=thk, width=10,  color = color.blue, opacity=1)
        wallB2 = box (pos=(-55, -side, 0), length=90,  height=thk, width=10,  color = color.blue, opacity=1)        
        wallB1 = box (pos=(55, side, 0), length=90,  height=thk, width=10,  color = color.blue, opacity=1)
        wallB2 = box (pos=(-55, side, 0), length=90,  height=thk, width=10,  color = color.blue, opacity=1) 
        wallBK = box(pos=(0, 0, -5), length=s2,  height=s2,  width=thk, color = color.white, opacity=0.1)

        botaoAbrir = box(pos=(-90, -85, -1), length=10, height=10,width=2, color = color.red, opacity=0.6)
        botaoAbrir2 = box(pos=(90, 85, -1), length=10, height=10,width=2, color = color.red, opacity=0.6) 
        portaSaida = box(pos=(0, 100, 0), length=20, height=2,width=2, material = materials.wood, opacity=0.6) 
        
        # Boas vindas!
        label(pos=(60,-120,0), text='Chegue ao outro lado !!!')
        
        traira.mass = 1.0
        traira.p = vector (0,1,0)
        tubarao1.mass = 1.0
        tubarao1.p = vector (1,0,0)
        tubarao2.mass = 1.0
        tubarao2.p = vector (-1,0,0)
        tubarao3.mass = 1.0
        tubarao3.p = vector (-1,0,0)
        tubarao4.mass = 1.0
        tubarao4.p = vector (1,0,0)
        aguaviva1.mass = 1.0
        aguaviva1.p = vector (-1,0,0)
        aguaviva2.mass = 1.0
        aguaviva2.p = vector (1,0,0) 
        side = side - thk*0.5 - traira.esqueleto.x
        traira.mass = 1.0
        traira.p = vector (0,1,0)
        quadro=0
        aux = 0;
        dt = 0.5
        t=0
        auxLado = 0
        auxEsquerdaDireita = 0

        win = 0
        
        while 1:
            # Captura de GIFs
            aux += 1
            if( aux == 5) :
                im = ImageGrab.grab((0,0,410,450))
                fn = "traira-primeiro-problema-"+str(quadro)+".png"
                im.save(fn)
                aux = 0
                
            #rate(30)
            
            # Controle o seu peixe!
            if scene.kb.keys:
                s = scene.kb.getkey()

                if (s == 'up'):
                    traira.p = vector (0,1,0)
                    if (traira.esqueleto.y >= 121):
                        auxLado += 0
                    else:
                        auxLado += 1

                elif (s == 'down'):
                    traira.p = vector (0,-1,0)
                    if (traira.esqueleto.y <= -100):
                        auxLado -= 0
                    else:
                        auxLado -= 1
                    
                elif (s == 'left'):
                    traira.p = vector (-1,0,0)
                    if (traira.esqueleto.x <= -100):
                        auxEsquerdaDireita -= 0
                    else:
                        auxEsquerdaDireita -= 1

                elif (s == 'right'):
                    traira.p = vector (1,0,0)
                    if (traira.esqueleto.x >= 100):
                        auxEsquerdaDireita += 0
                    else:
                        auxEsquerdaDireita += 1
        
                elif (s == 'q'):
                    print 'TCHAU'
                    break
                    quit

            traira.esqueleto.axis.y = traira.p.y + auxLado
            traira.esqueleto.axis.x = traira.p.x + auxEsquerdaDireita
            traira.esqueleto.axis.z = traira.p.z
            traira.esqueleto.y += auxLado
            traira.esqueleto.x += auxEsquerdaDireita
            rate(100)
            t = t + dt

            auxLado = 0
            auxEsquerdaDireita = 0
          
            tubarao1.esqueleto.axis.x = tubarao1.p.x
            tubarao2.esqueleto.axis.x = tubarao2.p.x
            tubarao3.esqueleto.axis.x = tubarao3.p.x
            tubarao4.esqueleto.axis.x = tubarao4.p.x

            aguaviva1.esqueleto.axis.x = tubarao1.p.x
            aguaviva2.esqueleto.axis.x = tubarao2.p.x

            #fechada = label()
            if ((botaoAbrir.color == color.red)and(botaoAbrir2.color == color.red)):
                fechada = label(pos=(-60,110,0),text='Porta Fechada!!!')
            
            if ((fabs( traira.esqueleto.y - botaoAbrir.y) < 3) and (fabs( traira.esqueleto.x - botaoAbrir.x) < 3) ):
                botaoAbrir.color = color.green

            if ((fabs( traira.esqueleto.y - botaoAbrir2.y) < 3) and (fabs( traira.esqueleto.x - botaoAbrir2.x) < 3) ):
                botaoAbrir2.color = color.green
                
            if((botaoAbrir.color == color.green)and
               (botaoAbrir2.color == color.green)and
               (win == 0)
               ):
                fechada = label(pos=(-60,110,0),text='Porta Aberta!!!')
                win = 1
                portaSaida.length=2
                portaSaida.height=20
                portaSaida.x -=10
                portaSaida.y +=15
            
            if (( traira.esqueleto.y > side + 10)and (botaoAbrir.color == color.green)):
                        label(pos=(60,120,0), text='Parabens !!!')
                        break
                         
            tubarao1.esqueleto.pos = tubarao1.esqueleto.pos + (tubarao1.p/tubarao1.mass)*dt
            if not (side > tubarao1.esqueleto.x > -side):
                tubarao1.p.x = -tubarao1.p.x

            tubarao2.esqueleto.pos = tubarao2.esqueleto.pos + (tubarao2.p/tubarao2.mass)*dt
            if not (side > tubarao2.esqueleto.x > -side):
                tubarao2.p.x = -tubarao2.p.x

            tubarao3.esqueleto.pos = tubarao3.esqueleto.pos + (tubarao3.p/tubarao3.mass)*dt
            if not (side > tubarao3.esqueleto.x > -side):
                tubarao3.p.x = -tubarao3.p.x

            tubarao4.esqueleto.pos = tubarao4.esqueleto.pos + (tubarao4.p/tubarao4.mass)*dt
            if not (side > tubarao4.esqueleto.x > -side):
                tubarao4.p.x = -tubarao4.p.x

            aguaviva1.esqueleto.pos = aguaviva1.esqueleto.pos + (aguaviva1.p/aguaviva1.mass)*dt
            if not (side > aguaviva1.esqueleto.x > -side):
                aguaviva1.p.x = -aguaviva1.p.x
            
            aguaviva2.esqueleto.pos = aguaviva2.esqueleto.pos + (aguaviva2.p/aguaviva2.mass)*dt
            if not (side > aguaviva2.esqueleto.x > -side):
                aguaviva2.p.x = -aguaviva2.p.x
              
            if (fabs(traira.esqueleto.x - tubarao1.esqueleto.x) < 20) and ( fabs (traira.esqueleto.y - tubarao1.esqueleto.y) < 15 ):
                        label(pos=(0,20,0), text='Tubarao na area!!! Tente novamente !!!' )
                        break
                    
            if (fabs(traira.esqueleto.x - tubarao2.esqueleto.x) < 20) and ( fabs (traira.esqueleto.y - tubarao2.esqueleto.y) < 15 ):
                        label(pos=(0,-60,0), text='O tubarao estava faminto !!! Jogue de novo!!!')
                        break

            if (fabs(traira.esqueleto.x - tubarao3.esqueleto.x) < 20) and ( fabs (traira.esqueleto.y - tubarao3.esqueleto.y) < 15 ):
                        label(pos=(0,20,0), text='Tubarao na area!!! Tente novamente !!!' )
                        break
                    
            if (fabs(traira.esqueleto.x - tubarao4.esqueleto.x) < 20) and ( fabs (traira.esqueleto.y - tubarao4.esqueleto.y) < 15 ):
                        label(pos=(0,-60,0), text='O tubarao estava faminto !!! Jogue de novo!!!')
                        break

            if (fabs(traira.esqueleto.x - aguaviva1.esqueleto.x) < 5) and ( fabs (traira.esqueleto.y - aguaviva1.esqueleto.y) < 5 ):
                        label(pos=(0,-20,0), text='A Agua-viva pegou voce !!! Vamos jogar de novo?')
                        break

            if (fabs(traira.esqueleto.x - aguaviva2.esqueleto.x) < 5) and ( fabs (traira.esqueleto.y - aguaviva2.esqueleto.y) < 5 ):
                        label(pos=(0,60,0), text='Cuidado !!! Tente mais uma vez')
                        break
            traira.proximoFrame()
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

    def proximoFrame(self):
        pass


class Tubarao(SerMarinho): 
    def desenha(self, escala=1):
        u=escala/6.0
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


class AguaViva(SerMarinho):

    def desenha(self, escala=1):

        u=escala/6.0
        r=6*u
        l=6*r
        direcoes = [-r,0,r]          
        
        self.cor1 = (0.2,0.3,0.4) #grafite
        self.cor2 = color.white
        self.cor3 = (0.4,0.1,0.6) #roxo ou algo parecido
        self.cor4 = color.blue
        self.cor5 = color.red

        #elipses
            #elipses maiores tansparentes
        self.desenharElipse((0,0,0),3*escala,2*escala,3*escala,self.cor2,0.4)
        self.desenharElipse ((0,0.4*escala,0),2*escala,1.5*escala,2*escala,self.cor3,0.4)
            #elipses central
        self.desenharElipse ((0,0,0),3*escala,2*escala,3*escala,self.cor3,0.4,materials.marble)
            #elipses laterais de adorno
        self.desenharElipse ((0,-0.2*escala,1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.desenharElipse ((0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)
        self.desenharElipse ((0,-0.2*escala,-1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.desenharElipse ((-0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)

	#cilindros (da um formato de 'saia' a agua viva)
        self.desenharCilindro((0,-0.65*escala,0), (0,0.7*escala,0),1.479*escala,self.cor3,0.5)
        self.desenharCilindro((0,-1*escala,0),(0,0.7*escala,0),1.55*escala,self.cor3,0.5)

	#aneis (dao aparencias de riscos dentro da 'agua viva')
        self.desenharAnel((-0.1*escala,0,0),(0,0.5*escala,0.1*escala),1.3*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.3*escala,0),(0,0.5*escala,0.1*escala), 1.1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.5*escala,0),(0,0.5*escala,0.1*escala),1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.7*escala,0),(0,0.5*escala,0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.desenharAnel((0.1*escala,0,0),(0,0.5*escala,-0.1*escala),1.3*escala,0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.3*escala,0),(0,0.5*escala,-0.1*escala),1.1*escala,0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.5*escala,0), (0,0.5*escala,-0.1*escala), 1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.7*escala,0),(0,0.5*escala,-0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.desenharAnel((0.1*escala,1*escala,0),(0,0,0),0.5,0.004*escala,self.cor5)        

	#Espirais
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
            frame = self.esqueleto,pos = posicao, length = comprimento, height = altura, width = largura, color = cor, opacity = opacidade, material = aparencia
        )    
    def desenharCilindro(self,posicao=(0,-0.65,0),eixos=(0,0.7,0),raio=1,cor=color.yellow,opacidade=0.5):
        return cylinder(
    