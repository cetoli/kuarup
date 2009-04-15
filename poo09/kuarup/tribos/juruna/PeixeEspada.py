# -*- coding: cp1252 -*-

from visual import *

from random import random, randrange

from SerMarinho import *

import os

from PIL import Image

from PIL import ImageGrab


class PeixeEspada(SerMarinho):

    def desenha(self, escala=1):
        self.dano= 0
        self.velocidade= 0

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

        """
        Calculo da posicao do peixe.
        """
        x0= 9*escala #6*escala + 6*escala # 2.4
        y0= -2*escala
        z0= 2*escala
        #self.posicao.setPontoBaixo (-3.2,1.6,10.4) # otimizado

        x6= -7*escala  # correto e -5*escala - ...
        y6= 1.13*escala + 1*escala # correto ... + 2*escala
        z6= -2*escala # correto e 4 e nao 3
        #self.posicao.setPontoCima (-6.4,2.4,9.6) # otimizado

        pontoCima= Ponto (self.esqueleto.pos[0]+x6, self.esqueleto.pos[1]+y6, self.esqueleto.pos[2]+z6)
        pontoBaixo= Ponto (self.esqueleto.pos[0]+x0, self.esqueleto.pos[1]+y0, self.esqueleto.pos[2]+z0)

        self.posicao.setPontoBaixo (pontoBaixo.getX (), pontoBaixo.getY (), pontoBaixo.getZ ())
        self.posicao.setPontoCima (pontoCima.getX (), pontoCima.getY (), pontoCima.getZ ())

        self.posicao.setVetorSentido (1, 0, 0)

        #self.posicao.testeQuadrado ()

    # Xerente - 21-03-2009

    def mover(self, tipo, newPosition, salto):

        # Parâmetros: tipo (axis ou position), coordenadas (x,y,z), salto (distância entre um ponto da animação e outro)



        # Pegar posição original do objeto

        if tipo == "position":

            pos = self.getPosition()

        elif tipo == "axis":

            pos = self.getAxis()



        # Verificar distância a ser movida na coordenada x

        if pos.x > newPosition["x"]:

            distX = pos.x - newPosition["x"]

        else:

            distX = newPosition["x"] - pos.x



        # Verificar distância a ser movida na coordenada y

        if pos.y > newPosition["y"]:

            distY = pos.y - newPosition["y"]

        else:

            distY = newPosition["y"] - pos.y



        # Verificar distância a ser movida na coordenada z

        if pos.z > newPosition["z"]:

            distZ = pos.z - newPosition["z"]

        else:

            distZ = newPosition["z"] - pos.z



        # Loop para fazer a animação com a velocidade pré-determinada

        while distX > 0 or distY > 0 or distZ > 0:

            self.fotografar()

            rate(self.getVelocidade())



            # Pegar posição original do objeto

            if(tipo == "position"):

                pos = self.getPosition()

            elif tipo == "axis":

                pos = self.getAxis()



            # Move se a distância ainda é maior do que zero

            if distX > 0:

                # Condição para diferenciar valores negativos e positivos

                if pos.x > newPosition["x"]:

                    moverX = pos.x - salto

                else:

                    moverX = pos.x + salto

                distX -= salto

            else:

                moverX = pos.x



            # Move se a distância ainda é maior do que zero

            if distY > 0:

                # Condição para diferenciar valores negativos e positivos

                if pos.y > newPosition["y"]:

                    moverY = pos.y - salto

                else:

                    moverY = pos.y + salto

                distY -= salto

            else:

                moverY = pos.y



            # Move se a distância ainda é maior do que zero

            if distZ > 0:

                # Condição para diferenciar valores negativos e positivos

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

    def nadar (self, pontoEixo):
        pontoEixo.multiplicar (self.VELOCIDADE_NADO)
        incremento= pontoEixo
        esqueleto= Ponto (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

        esqueleto.somar (incremento)

        self.esqueleto.pos= esqueleto.getLista ()
        self.posicao.deslocarPontos (incremento)


# Fim