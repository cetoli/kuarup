# -*- coding: cp1252 -*-

from visual import *

from random import random, randrange

from BlueFish import * 

import os

from PIL import Image

from PIL import ImageGrab
 
TITLE = 'Jogo Atencao - Karajas!'

 

filelist = ""

basename = "atencao_"; extname = ".gif"

ImageWidth = 400; ImageHeight = 400

cont = 1

controleFoto = 1

 

class Cenario:

 

    def __init__(self):

 

        self.cena = display(title=TITLE, width=400, height=400, center= (0,0,0), x=0, y=0)

        self.cena.x, self.cena.y =0,0

        self.cena.select()
        
        self.cena.autocenter = 1

        self.cena.autoscale = 1

        self.quadro = 0

 

    def principal(self):

        blueFish = BlueFish(escala = 0.5, pos= (0,-50,-30), axis=(0,1,0))
        blueFish.esqueleto.rotate(angle=-pi/2., axis=(0,1,0))

        peixeEspada = PeixeEspada(escala =0.9, pos= (-10,10,0), axis=(1,0,0))
        peixeEspada.setVelocidade(300)
      

        tubarao = Tubarao(escala =0.4, axis=(1,0,0), pos= (40,-10,-5))
        tubarao.setVelocidade(100)




        i = 0

        while i < 1:       

            peixeEspada.mover("position", {"x" : -10, "y" : -10, "z" : -10}, 0.2)
            peixeEspada.mover("axis", {"x" : 1, "y" : 0, "z" : 0}, 0.2)
            peixeEspada.mover("position", {"x" : 10, "y" : -10, "z" : -10}, 0.2)
            peixeEspada.mover("axis", {"x" : 0, "y" : 1, "z" : 0}, 0.2)
            peixeEspada.mover("position", {"x" : 10, "y" : 10, "z" : -10}, 0.2)
            peixeEspada.mover("axis", {"x" : -1, "y" : 0, "z" : 0}, 0.2)
            peixeEspada.mover("position", {"x" : -10, "y" : 10, "z" : -10}, 0.2)
            peixeEspada.mover("axis", {"x" : 0, "y" : -1, "z" : 0}, 0.2)
            peixeEspada.mover("position", {"x" : -10, "y" : -10, "z" : -10}, 0.2)
            peixeEspada.mover("axis", {"x" : 1, "y" : 0, "z" : 0}, 0.2)
            
            #movimentando o tubarao
            tubarao.mover("position", {"x" : 40, "y" : -10, "z" : -10}, 0.2)
            tubarao.mover("axis", {"x" : 1, "y" : 0, "z" : 0}, 0.2)
            tubarao.mover("position", {"x" : 70, "y" : -10, "z" : -10}, 0.2)
            tubarao.mover("axis", {"x" : -1, "y" : 1, "z" : 0}, 0.2)
            tubarao.mover("position", {"x" : 55, "y" : 20, "z" : -10}, 0.2)
            tubarao.mover("axis", {"x" : -1, "y" : -1, "z" : 0}, 0.2)
            tubarao.mover("position", {"x" : 40, "y" : -10, "z" : -10}, 0.2)
            tubarao.mover("axis", {"x" : 1, "y" : 0, "z" : 0}, 0.2)
            
            blueFish.fotografar()
            i += 1
            
           

        label(frame=self.quadro ,pos=(-10,25,-5), text='Agora diga qual forma geometrica ', height=14 , box=0)
        label(frame=self.quadro ,pos=(-10,20,-5), text='NAO foi descrita pela trajet�ria dos peixes... ', height=14 , box=0)    

        #agora eh hora de perguntar qual a figura geometrica nao foi feita...
        tubarao.setVisibility(0)
        peixeEspada.setVisibility(0)
        
        caixa = box(pos=(-35,-8,-30), axis=(0,5,0), size=(7,7,7), color = color.blue)
        piramide = pyramid(pos=(-10,-10,-30), axis = (0,1,0), size=(7,7,7), color = color.green)
        circulo = sphere(pos=(15,-8,-30), axis = (0,5,0), radius=5, color = color.magenta)
        
        blueFish.p = vector (0,1,1)
        quadro = 0        

        auxVerticalBlueFish = 0
        auxHorizontalBlueFish = 0
        labelErrou = label(frame=self.quadro ,pos=(-10,10,-30), text='',box=0)

        while 1:
            if (fabs(blueFish.esqueleto.x - caixa.x) < 6) and ( fabs (blueFish.esqueleto.y - caixa.y) < 6 ):
                    #label1 = label(pos=(0,7,-30), text='OK', height=10, color=color.blue )
                    labelErrou = label(frame=self.quadro ,pos=(-10,10,-30), text='Voc� errou!O correto seria o c�rculo! ', height=14 , color=color.red)

            elif (fabs(blueFish.esqueleto.x - piramide.x) < 6) and ( fabs (blueFish.esqueleto.y - piramide.y) < 6 ):
                    labelErrou  = label(frame=self.quadro ,pos=(-10,10,-30), text='Voc� errou!O correto seria o c�rculo! ', height=14 , color=color.red)
                     
            elif (fabs(blueFish.esqueleto.x - circulo.x) < 6) and ( fabs (blueFish.esqueleto.y - circulo.y) < 6 ):
                    labelErrou.visible=0
                    labelAcertou = label(frame=self.quadro ,pos=(-10,10,-30), text='Parabens! Voce ACERTOU!!!', height=14, color=color.green )
                    
           
           
    
            # Controle do peixe          

            if self.cena.kb.keys:

                s = self.cena.kb.getkey()


                #UP
                if (s == 'up'):

                    blueFish.p = vector (0,1,1)

                    if (blueFish.esqueleto.y <= 50):

                        auxVerticalBlueFish += 1

                    else:

                        auxVerticalBlueFish += 0

                #DOWN            
                elif (s == 'down'):

                    blueFish.p = vector (0,-1,1)

                    if (blueFish.esqueleto.y <= -50):

                        auxVerticalBlueFish -= 0

                    else:

                        auxVerticalBlueFish -= 1

                #LEFT
                elif (s == 'left'):

                    blueFish.p = vector (-1,0,0)

                    if (blueFish.esqueleto.x <= -50):

                        auxHorizontalBlueFish -= 0

                    else:

                        auxHorizontalBlueFish -= 1

                #RIGHT
                elif (s == 'right'):

                    blueFish.p = vector (1,0,0)

                    if (blueFish.esqueleto.x >= 50):

                        auxHorizontalBlueFish += 0

                    else:

                        auxHorizontalBlueFish += 1
        
                #QUIT
                elif (s == 'q'):

                    print 'TCHAU'

                    break

                    quit
                
            blueFish.esqueleto.axis.y = blueFish.p.y + auxVerticalBlueFish
            blueFish.esqueleto.axis.x = blueFish.p.x + auxHorizontalBlueFish
            blueFish.esqueleto.axis.z = blueFish.p.z

            blueFish.esqueleto.y += auxVerticalBlueFish

            blueFish.esqueleto.x += auxHorizontalBlueFish


            blueFish.fotografar()

            #tc = tc + dt

            rate(100)

            auxVerticalBlueFish = 0

            auxHorizontalBlueFish = 0
    
class SerMarinho():

 

    def __init__(self, escala= 1, **qualquel_outro_parametro):

 

        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"

        self.esqueleto=frame(**qualquel_outro_parametro)

        self.desenha(escala)
        

    def desenha(self): pass

 

    # Xerente - 21-03-2009 

    def getPosition(self): 

        return (self.esqueleto.pos)

 

    # Xerente - 21-03-2009 

    def setPosition(self, pos): 

        self.esqueleto.pos = pos 

 

    # Xerente - 21-03-2009 

    def getAxis(self): 

        return self.esqueleto.axis 

 

    # Xerente - 21-03-2009 

    def setAxis(self, axis):

        self.esqueleto.axis = axis

    
    def setVisibility(self, visibility=1):

        self.esqueleto.visible = visibility


    # Xerente - 21-03-2009 

    def getVelocidade(self): 

        return self.velocidade

 

    # Xerente - 21-03-2009 

    def setVelocidade(self, velocidade = 0):

        self.velocidade = velocidade 

 

    # Xerente - 21-03-2009

    def mover(self, tipo, newPosition, salto):

 

        # Par�metros: tipo (axis ou position), coordenadas (x,y,z), salto (dist�ncia entre um ponto da anima��o e outro) 

 

        # Pegar posi��o original do objeto 

        if tipo == "position":

            pos = self.getPosition()

        elif tipo == "axis":

            pos = self.getAxis()

 

        # Verificar dist�ncia a ser movida na coordenada x 

        if pos.x > newPosition["x"]:

            distX = pos.x - newPosition["x"]

        else:

            distX = newPosition["x"] - pos.x 

 

        # Verificar dist�ncia a ser movida na coordenada y 

        if pos.y > newPosition["y"]:

            distY = pos.y - newPosition["y"]

        else:

            distY = newPosition["y"] - pos.y

 

        # Verificar dist�ncia a ser movida na coordenada z 

        if pos.z > newPosition["z"]:

            distZ = pos.z - newPosition["z"]

        else:

            distZ = newPosition["z"] - pos.z

 

        # Loop para fazer a anima��o com a velocidade pr�-determinada

        while distX > 0 or distY > 0 or distZ > 0:
            self.fotografar()

            rate(self.getVelocidade())

 

            # Pegar posi��o original do objeto

            if(tipo == "position"):

                pos = self.getPosition()

            elif tipo == "axis":

                pos = self.getAxis()

 

            # Move se a dist�ncia ainda � maior do que zero

            if distX > 0:

                # Condi��o para diferenciar valores negativos e positivos

                if pos.x > newPosition["x"]:

                    moverX = pos.x - salto

                else:

                    moverX = pos.x + salto

                distX -= salto

            else:

                moverX = pos.x

 

            # Move se a dist�ncia ainda � maior do que zero

            if distY > 0:

                # Condi��o para diferenciar valores negativos e positivos               

                if pos.y > newPosition["y"]:

                    moverY = pos.y - salto

                else:

                    moverY = pos.y + salto

                distY -= salto

            else:

                moverY = pos.y

 

            # Move se a dist�ncia ainda � maior do que zero

            if distZ > 0:

                # Condi��o para diferenciar valores negativos e positivos           

                if pos.z > newPosition["z"]:

                    moverZ = pos.z - salto

                else:

                    moverZ = pos.z + salto

                distZ -= salto

            else:

                moverZ = pos.z

            # Mover ou girar o objeto

            if(tipo == "position"):

                self.setPosition((moverX, moverY, moverZ))

            elif tipo == "axis":

                self.setAxis((moverX, moverY, moverZ))  


    def fotografar(self):

        global controleFoto

        if controleFoto % 20 == 0:        

            im = ImageGrab.grab((4,30,ImageWidth-4,ImageHeight-4))

            global filename

            filename = basename+str(cont)+extname

            global filelist

            filelist += filename + " "

            im.save(filename)

            global cont

            cont += 1

        controleFoto += 1 


class PeixeEspada(SerMarinho):
    def desenha(self, escala=1):
     

        #defino o corpo         

        corpo = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=11*escala, height=3*escala, width=4*escala , opacity=1)
        corpo.color = (0.75,0.75,0.75)

         

        #todo peixe espadarte tem uma proteburancia que sai da boca em formato de lanca      
        bocaLanca = ellipsoid(frame = self.esqueleto, pos=(6*escala,0.1*escala,0), length=6*escala, height=0.4*escala, width=0.4*escala, color=(0.7,0.7,0.7))

         

        #os olhos e suas respectivas pupilas

        olho1 = sphere (frame = self.esqueleto, pos=(4*escala,0,1.2*escala), radius=.25*escala, color=color.white, opacity=.9, material=materials.emissive)

        olho2 = sphere (frame = self.esqueleto, pos=(4*escala,0,-1.2*escala), radius=.25*escala, color=color.white, opacity=.9, material=materials.emissive)

         

        pupila1 = sphere (frame = self.esqueleto, pos=(4*escala, 0, 1.4*escala), radius=.1*escala, color=color.black)

        pupila2 = sphere (frame = self.esqueleto, pos=(4*escala,0,-1.4*escala), radius=.1*escala, color=color.black)

         

        #agora defino o rosto do peixe
        boca = ellipsoid(frame = self.esqueleto, pos=(5.30*escala,-0.08*escala,0), length=1*escala, height=0.4*escala, width=0.4*escala, color=(0,0,0))
        boca.rotate(angle=2*84, axis=(0,1*escala,0))

        labio = ring(frame = self.esqueleto, pos=(5*escala,0,0), axis=(1*escala,1*escala,0),radius=.55*escala, thickness=0.22*escala,color = (0.7,0.7,0.7))

         

        #agora so faltaram o rabo e as barbatanas         

        rabo = pyramid(frame = self.esqueleto, pos=(-7*escala,0,0), size=(5*escala,2.9*escala,0.01*escala),  axis = (1*escala,0,0))
        rabo.color = (0,1*escala,1*escala)

         

        barbatanaTraseira = pyramid(frame = self.esqueleto, pos=(-3.5*escala,1.13*escala,0), size=(4*escala,2*escala,0.01*escala),  axis = (1*escala,0,0))
        barbatanaTraseira.color = (0,1,1)

        barbatanaTraseiraInferior = pyramid(frame = self.esqueleto, pos=(-1.3*escala,-1.13*escala,0), size=(4*escala,2*escala,0.01*escala),  axis = (1*escala,0,0))
        barbatanaTraseiraInferior.color = (0,1,1)

        barbatanaDianteira = pyramid(frame = self.esqueleto, pos=(1.5*escala,1*escala,0.4*escala), size=(2*escala,2*escala,0.1*escala),  axis = (1*escala,0,0))
        barbatanaDianteira.color = (0,1,1)


#Utilizando a classe Tubarao da tribo amiga...
class Tubarao(SerMarinho):
    
            
   
    def colorir(self, cor):
        self.corpo01.color = cor
        self.corpo02.color=cor
        self.corpo03.color = cor
        self.corpo04.color=cor
        self.guelra1.color=cor
        self.guelra2.color=cor
        self.guelra3.color=cor
        self.guelra4.color=cor
        self.guelra5.color=cor
        self.guelra6.color=cor
        self.rabo1.color=cor
        self.rabo2.color=cor
        self.peitoral1.color=cor
        self.peitoral2.color=cor
        self.peitoral3.color=cor
        self.peitoral4.color=cor
        self.dorsal1.color=cor
        self.dorsal2.color=cor
                                
        
 

    def desenha(self, escala=1):

 

        self.corpo01 = ellipsoid(frame = self.esqueleto, pos=(0,-2*escala,0), length=35*escala, height=10*escala, width=10*escala, color = color.white, opacity=1)

        self.corpo02 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=40*escala, height=12.5*escala, width=15*escala, color = color.gray(0.5), opacity=1)

        self.corpo03 = ellipsoid(frame = self.esqueleto, pos=(-15*escala,-2*escala,0), length=15*escala, height=6*escala, width=5*escala, color = color.white, opacity=1)

        self.corpo04 = ellipsoid(frame = self.esqueleto, pos=(-15*escala,0,0), length=25*escala, height=9*escala, width=10*escala, color = color.gray(0.5), opacity=1)

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

        self.dorsal1 =  pyramid(frame = self.esqueleto, pos=(-2*escala,5.5*escala,0), size=(7*escala,20*escala,0.5*escala), color=color.gray(0.5), opacity=1)

        self.dorsal2 =  pyramid(frame = self.esqueleto, pos=(-16*escala,4*escala,0), size=(5*escala,5*escala,0.5*escala), color=color.gray(0.5), opacity=1)

        self.barriga1 = pyramid(frame = self.esqueleto, pos=(-16*escala,-3*escala,0), size=(7*escala,6*escala,0.5*escala), axis=(1,-0.3,0), color=color.white, opacity=1)

        self.peitoral1 = pyramid(frame = self.esqueleto, pos=(3*escala,-4*escala,3.5*escala), size=(12*escala,1*escala,6*escala), axis=(-0.5,0,1),color=color.gray(0.5), opacity=1)

        self.peitoral2 = pyramid(frame = self.esqueleto, pos=(3*escala,-4*escala,-3.5*escala), size=(12*escala,1*escala,6*escala), axis=(-0.5,0,-1),color=color.gray(0.5), opacity=1)

        self.peitoral3 = pyramid(frame = self.esqueleto, pos=(-10*escala,-4*escala,2.5*escala), size=(5*escala,1*escala,6*escala), axis=(-0.5,0,1),color=color.gray(0.5), opacity=1)

        self.peitoral4 = pyramid(frame = self.esqueleto, pos=(-10*escala,-4*escala,-2.5*escala), size=(5*escala,1*escala,6*escala), axis=(-0.5,0,-1),color=color.gray(0.5), opacity=1)

        self.rabo1 = pyramid(frame = self.esqueleto, pos=(-25*escala,1*escala,0), size=(16*escala,5*escala,0.5*escala),axis=(-1,1,0), color=color.gray(0.5), opacity=1)

        self.rabo2 = pyramid(frame = self.esqueleto, pos=(-28*escala,-2*escala,0), size=(7*escala,6*escala,0.5*escala), axis=(1,-0.3,0), color=color.gray(0.5), opacity=1)

        self.guelra1 = cylinder (frame = self.esqueleto, pos=(6*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))

        self.guelra2 = cylinder (frame = self.esqueleto, pos=(5*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))

        self.guelra3 = cylinder (frame = self.esqueleto, pos=(4*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))

        self.guelra4 = cylinder (frame = self.esqueleto, pos=(6*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))

        self.guelra5 = cylinder (frame = self.esqueleto, pos=(5*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))

        self.guelra6 = cylinder (frame = self.esqueleto, pos=(4*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))


 
if __name__ == "__main__":

 

    cenario = Cenario()

    cenario.principal()

 



 
