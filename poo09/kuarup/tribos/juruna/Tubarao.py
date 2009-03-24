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

'''

Classe base de qualquer ser marinho

'''


'''

Esta classe e uma especializacao da classe SerMarinho...

'''

class Tubarao(SerMarinho):

    def desenha(self, escala=1):

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


    def girar (self, angulo, eixoRotacao):
        eixo= Eixo ()
        anguloRad= eixo.converterGrausRadiano (angulo)
        self.esqueleto.rotate (angle= anguloRad, axis= eixoRotacao)
'''

Nao mexa aqui!

'''

if __name__ == "__main__":

    cenario = Cenario()

    cenario.principal()