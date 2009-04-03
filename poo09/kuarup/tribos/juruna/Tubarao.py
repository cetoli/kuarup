"""

#########################################

Tutubarao - o terror dos sete mares!

#########################################

:Author: Helio Mendes Salmon

:Contact: helio.salmon@gmail.com

:Date: $Date: 2009/03/15  $

:Status: This is a "work in progress"

:Revision: $Revision: 1.00 $

:Home: `KUARUP - PBWiki <http://kuarup2009.pbwiki.com/>`__

:Copyright: 2009, `GPL <http://is.gd/3Udt>`__

"""

'''

Os tubaroes brancos sao perigosos...

'''

from visual import *
from SerMarinho import *
from Eixo import *

TITLE = 'Tutubarao!'

'''

Aqui carrega o cenario.... e onde instanciamos o ser marinho.

Nao se esqueca: o professor mandou usar uma janela de 150(width) x 150(height)!

'''

"""
class Cenario:

    def __init__(self):

        scene2 = display(title=TITLE, width=150, height=150, center= (0,0,0), x=0, y=0)

        scene2.x, scene2.y =0,0

        scene2.select()

        scene2.autoscale = 1

        self.quadro = 0

    def principal(self):

        tubarao1 = Tubarao(escala =1, axis=(1,0,0), pos= (1,-6,0))       #Primeiro peixe

        tubarao2 = Tubarao(escala =0.2, axis=(1,1,-2), pos= (-5,-3,20))  #Segundo peixinho

        tubarao3 = Tubarao(escala =0.2, axis=(0,-1,3), pos= (17,5,6))    #Terceiro peixinho
"""

'''

Classe base de qualquer ser marinho

'''


'''

Esta classe e uma especializacao da classe SerMarinho...

'''

class Tubarao(SerMarinho):

    def __init__ (self, escala= 1, **complemento):
        SerMarinho.__init__ (self, escala, **complemento)

        self.listaElementosCorpo= list ()

    def desenha (self):
        self.dano= 20

        escala= self.escala
        u=escala/6.0

        r=6*u

        l=6*r

        direcoes = [-r,0,r]

        '''

        Este e o Tutubarao, o terror dos sete mares!!!

        ATENCAO Indios: duas coisas a serem feitas:

        1. multiplicar os tamanhos (lenght, width, height e radius) e as posicoes (pos) de todos os objetos utilizados pela "escala"; e

        2. adicionar TUDO que compoe o seu ser marinho a um frame, no nosso caso: "frame = self.esqueleto".

        '''

        corpo01 = ellipsoid(frame = self.esqueleto, pos=(0,-2*escala,0), length=35*escala, height=10*escala, width=10*escala, color = color.white, opacity=1)
        self.listaElementosCorpo.append (corpo01)

        corpo02 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=40*escala, height=12.5*escala, width=15*escala, color = color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (corpo02)

        corpo03 = ellipsoid(frame = self.esqueleto, pos=(-15*escala,-2*escala,0), length=15*escala, height=6*escala, width=5*escala, color = color.white, opacity=1)
        self.listaElementosCorpo.append (corpo03)

        corpo04 = ellipsoid(frame = self.esqueleto, pos=(-15*escala,0,0), length=25*escala, height=9*escala, width=10*escala, color = color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (corpo04)

        boca1 = pyramid (frame = self.esqueleto, pos=(14*escala,-3.5*escala,-2*escala), axis=(-1,0,0), length=10*escala, height=3*escala, width=2*escala, color = color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (boca1)

        boca2 = pyramid (frame = self.esqueleto, pos=(14*escala,-3.5*escala,2*escala), axis=(-1,0,0), length=10*escala, height=3*escala, width=2*escala, color = color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (boca2)

        boca3 = ellipsoid(frame = self.esqueleto, pos=(13*escala,-5*escala,0), axis=(1,-0.1,0), length=10*escala, height=1*escala, width=6.5*escala, color=color.white, opacity=1)
        self.listaElementosCorpo.append (boca3)

        boca4 = ellipsoid(frame = self.esqueleto, pos=(15*escala,-2.5*escala,0), axis=(1,0.4,0), length=10*escala, height=2*escala, width=7*escala, color=color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (boca4)

        boca5 = ellipsoid(frame = self.esqueleto, pos=(14.5*escala,-4.6*escala,0), axis=(1,-0.1,0), length=5.5*escala, height=1*escala, width=5*escala, color=color.red, opacity=1)
        self.listaElementosCorpo.append (boca5)

        boca6 = ellipsoid(frame = self.esqueleto, pos=(14.5*escala,-3.8*escala,0), axis=(1,0.4,0), length=5*escala, height=1.5*escala, width=5*escala, color=color.red, opacity=1)
        self.listaElementosCorpo.append (boca6)

        olho10 = ellipsoid (frame = self.esqueleto, pos=(11*escala,2*escala,-5.6*escala), axis=(-0.25,-0.4,1),length=0.5*escala, height=1*escala, width=1*escala, color = color.white)
        self.listaElementosCorpo.append (olho10)

        olho11 = ellipsoid (frame = self.esqueleto, pos=(11.5*escala,2*escala,-5.6*escala), axis=(-0.25,-0.4,1), length=0.5*escala, height=1*escala, width=1*escala, color = color.black)
        self.listaElementosCorpo.append (olho11)

        olho20 = ellipsoid (frame = self.esqueleto, pos=(11*escala,2*escala,5.6*escala), axis=(0.25,0.4,1), length=0.5*escala, height=1*escala, width=1*escala, color = color.white)
        self.listaElementosCorpo.append (olho20)

        olho21 = ellipsoid (frame = self.esqueleto, pos=(11.5*escala,2*escala,5.6*escala), axis=(0.25,0.4,1), length=0.5*escala, height=1*escala, width=1*escala, color = color.black)
        self.listaElementosCorpo.append (olho21)

        dente01 = cone(frame = self.esqueleto, pos=(15*escala,-2*escala,-3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente01)

        dente02 = cone(frame = self.esqueleto, pos=(15*escala,-2*escala,3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente02)

        dente03 = cone(frame = self.esqueleto, pos=(15.5*escala,-2*escala,-3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente03)

        dente04 = cone(frame = self.esqueleto, pos=(15.5*escala,-2*escala,3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente04)

        dente05 = cone(frame = self.esqueleto, pos=(16*escala,-2*escala,-2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente05)

        dente06 = cone(frame = self.esqueleto, pos=(16*escala,-2*escala,2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente06)

        dente07 = cone(frame = self.esqueleto, pos=(16.5*escala,-2*escala,-2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente07)

        dente08 = cone(frame = self.esqueleto, pos=(16.5*escala,-2*escala,2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente08)

        dente09 = cone(frame = self.esqueleto, pos=(17*escala,-1.75*escala,-2.5*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente09)

        dente10 = cone(frame = self.esqueleto, pos=(17*escala,-1.75*escala,2.5*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente10)

        dente11 = cone(frame = self.esqueleto, pos=(17.5*escala,-1.5*escala,-2.2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente11)

        dente12 = cone(frame = self.esqueleto, pos=(17.5*escala,-1.5*escala,2.2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente12)

        dente13 = cone(frame = self.esqueleto, pos=(18*escala,-1.75*escala,-2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente13)

        dente14 = cone(frame = self.esqueleto, pos=(18*escala,-1.75*escala,2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente14)

        dente15 = cone(frame = self.esqueleto, pos=(18.5*escala,-1.5*escala,-1.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente15)

        dente16 = cone(frame = self.esqueleto, pos=(18.5*escala,-1.5*escala,1.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente16)

        dente17 = cone(frame = self.esqueleto, pos=(18.75*escala,-1*escala,-1*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente17)

        dente18 = cone(frame = self.esqueleto, pos=(18.75*escala,-1*escala,1*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente18)

        dente19 = cone(frame = self.esqueleto, pos=(19*escala,-1*escala,-0.3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente19)

        dente20 = cone(frame = self.esqueleto, pos=(19*escala,-1*escala,0.3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente20)

        dente21 = cone(frame = self.esqueleto, pos=(14*escala,-5*escala,-2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente21)

        dente22 = cone(frame = self.esqueleto, pos=(14*escala,-5*escala,2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente22)

        dente23 = cone(frame = self.esqueleto, pos=(14.5*escala,-5*escala,-2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente23)

        dente24 = cone(frame = self.esqueleto, pos=(14.5*escala,-5*escala,2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente24)

        dente25 = cone(frame = self.esqueleto, pos=(15*escala,-5*escala,-2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente25)

        dente26 = cone(frame = self.esqueleto, pos=(15*escala,-5*escala,2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente26)

        dente27 = cone(frame = self.esqueleto, pos=(15.5*escala,-5*escala,-2.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente27)

        dente28 = cone(frame = self.esqueleto, pos=(15.5*escala,-5*escala,2.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente28)

        dente29 = cone(frame = self.esqueleto, pos=(16*escala,-5*escala,2*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente29)

        dente30 = cone(frame = self.esqueleto, pos=(16*escala,-5*escala,-2*escala), axis=(0,0.5*escala,0), radius=.3, color=color.white)
        self.listaElementosCorpo.append (dente30)

        dente31 = cone(frame = self.esqueleto, pos=(16.5*escala,-5*escala,-1.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente31)

        dente32 = cone(frame = self.esqueleto, pos=(16.5*escala,-5*escala,1.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente32)

        dente33 = cone(frame = self.esqueleto, pos=(17*escala,-5.2*escala,-1.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente33)

        dente34 = cone(frame = self.esqueleto, pos=(17*escala,-5.2*escala,1.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente34)

        dente35 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,-1*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente35)

        dente36 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,1*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente36)

        dente37 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,-0.3*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente37)

        dente38 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,0.3*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)
        self.listaElementosCorpo.append (dente38)

        dorsal1 =  pyramid(frame = self.esqueleto, pos=(-2*escala,5.5*escala,0), size=(7*escala,20*escala,0.5*escala), color=color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (dorsal1)

        dorsal2 =  pyramid(frame = self.esqueleto, pos=(-16*escala,4*escala,0), size=(5*escala,5*escala,0.5*escala), color=color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (dorsal2)

        barriga1 = pyramid(frame = self.esqueleto, pos=(-16*escala,-3*escala,0), size=(7*escala,6*escala,0.5*escala), axis=(1,-0.3,0), color=color.white, opacity=1)
        self.listaElementosCorpo.append (barriga1)

        peitoral1 = pyramid(frame = self.esqueleto, pos=(3*escala,-4*escala,3.5*escala), size=(12*escala,1*escala,6*escala), axis=(-0.5,0,1),color=color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (peitoral1)

        peitoral2 = pyramid(frame = self.esqueleto, pos=(3*escala,-4*escala,-3.5*escala), size=(12*escala,1*escala,6*escala), axis=(-0.5,0,-1),color=color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (peitoral2)

        peitoral3 = pyramid(frame = self.esqueleto, pos=(-10*escala,-4*escala,2.5*escala), size=(5*escala,1*escala,6*escala), axis=(-0.5,0,1),color=color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (peitoral3)

        peitoral4 = pyramid(frame = self.esqueleto, pos=(-10*escala,-4*escala,-2.5*escala), size=(5*escala,1*escala,6*escala), axis=(-0.5,0,-1),color=color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (peitoral4)

        rabo1 = pyramid(frame = self.esqueleto, pos=(-25*escala,1*escala,0), size=(16*escala,5*escala,0.5*escala),axis=(-1,1,0), color=color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (rabo1)

        rabo2 = pyramid(frame = self.esqueleto, pos=(-28*escala,-2*escala,0), size=(7*escala,6*escala,0.5*escala), axis=(1,-0.3,0), color=color.gray(0.5), opacity=1)
        self.listaElementosCorpo.append (rabo2)

        guelra1 = cylinder (frame = self.esqueleto, pos=(6*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))
        self.listaElementosCorpo.append (guelra1)

        guelra2 = cylinder (frame = self.esqueleto, pos=(5*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))
        self.listaElementosCorpo.append (guelra2)

        guelra3 = cylinder (frame = self.esqueleto, pos=(4*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))
        self.listaElementosCorpo.append (guelra3)

        guelra4 = cylinder (frame = self.esqueleto, pos=(6*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))
        self.listaElementosCorpo.append (guelra4)

        guelra5 = cylinder (frame = self.esqueleto, pos=(5*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))
        self.listaElementosCorpo.append (guelra5)

        guelra6 = cylinder (frame = self.esqueleto, pos=(4*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))
        self.listaElementosCorpo.append (guelra6)


        pontoCima= Ponto (self.esqueleto.pos[0]-20*escala, self.esqueleto.pos[1]+15*escala, self.esqueleto.pos[2]-12.2*escala)
        pontoBaixo= Ponto (self.esqueleto.pos[0]+35*escala, self.esqueleto.pos[1]-6.5*escala, self.esqueleto.pos[2]+12.2*escala)

        self.posicao.setPontoBaixo (pontoBaixo.getX (), pontoBaixo.getY (), pontoBaixo.getZ ())
        self.posicao.setPontoCima (pontoCima.getX (), pontoCima.getY (), pontoCima.getZ ())

        self.posicao.setVetorSentido (-1, 0, 0)

    def matar (self):
        cont= 0
        while cont < self.listaElementosCorpo.__len__ ():
            temp= self.listaElementosCorpo.__getitem__ (cont)
            temp.visible= 0

            cont+= 1

    def girar (self, angulo, eixoRotacao):
        eixo= Eixo ()
        anguloRad= eixo.converterGrausRadiano (angulo)
        self.esqueleto.rotate (angle= anguloRad, axis= eixoRotacao)

    def nadar (self, pontoEixo):
        pontoEixo.multiplicar (self.VELOCIDADE_NADO)
        incremento= pontoEixo
        esqueleto= Ponto (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

        esqueleto.somar (incremento)

        self.esqueleto.pos= esqueleto.getLista ()
        self.posicao.deslocarPontos (incremento)



'''

Nao mexa aqui!

'''

"""
if __name__ == "__main__":

    cenario = Cenario()

    cenario.principal()

"""

# Fim