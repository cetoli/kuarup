# -*- coding: cp1252 -*-

"""

##################

##################

:Author: Karajá

:Contact: `Karajá <http://is.gd/n3Dr>`__

:Date: $Date: 2009/03/12  $

:Status: This is a "work in progress"

:Revision: $Revision: 1.00 $

:Home: `LABASE <http://labase.nce.ufrj.br/>`__

:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__

"""

'''

Agua VIVA

'''

from visual import *
import Image


TITLE = 'Água Viva'

class Cenario:

    def __init__(self):
        

        scene2 = display(title=TITLE, width=150, height=150, center= (0,0,0), x=0, y=0)

        scene2.x, scene2.y =0,0

        scene2.select()

        scene2.background = color.blue

        scene2.autoscale = 1

        self.quadro = 0

    def principal(self):

        aguaViva1=AguaViva(escala=1, axis=(3,0,3), pos= (0,-0.5,0))

        aguaViva2=AguaViva(escala =0.6, axis=(1,1,0), pos= (-1,0,6))

     

class SerMarinho():

    '''

    Classe base de qualquer ser marinho

    '''

    def __init__(self, escala= 1, **qualquel_outro_parametro):

        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"

        self.esqueleto=frame(**qualquel_outro_parametro)

        self.desenha(escala)

    def desenha(self): pass

class AguaViva(SerMarinho):

    '''


    '''
    

    def desenha(self, escala=1):

        textura = self.get_texture(file_name="texturaAgua1.jpg", width=40, height=60)

        corpo = ellipsoid(frame = self.esqueleto, pos=(0,0.1*escala,0), length=escala*0.78, height=escala*0.56,
                          width=escala*0.78, color=(0.95,0.95,0.5), opacity=1, material=textura)

        olhoEsquerdo = sphere(frame = self.esqueleto, pos=(0.1*escala,0.2*escala,0.35*escala), radius=escala*0.04, color=(1,1,1),  material=materials.emissive)

        olhoDireito = sphere(frame = self.esqueleto, pos=(-0.1*escala,0.2*escala,0.35*escala), radius=escala*0.04, color=(1,1,1),  material=materials.emissive)

        irisEsquerda = sphere(frame = self.esqueleto, pos=(0.11*escala,0.20*escala,0.38*escala), radius=escala*0.022, color=(0,0,0))

        
        irisDireita = sphere(frame = self.esqueleto, pos=(-0.11*escala,0.2*escala,0.38*escala), radius=escala*0.022, color=(0,0,0))
       
        baseCorpo1 = cylinder(frame = self.esqueleto, pos=(0,0,0), axis=(0,-0.2*escala,0), radius=0.25*escala, color=color.white, opacity=0.75)
        baseCorpo2 = cylinder(frame = self.esqueleto, pos=(0,-0.12*escala,0), axis=(0,-0.4*escala,0), radius=0.10*escala, color=color.white, opacity=0.15)

        

        boca = ring(frame= self.esqueleto, pos=(-0.006*escala,-0.01*escala,0.33*escala), axis=(0,0.69*escala,0),
                    radius=0.05*escala, thickness=0.01*escala, color =color.red)
      
        #as caudas da agua viva, feita com diversas helices / tentando simular o que seria o de uma agua viva de verdade...
        caudacentroCorpo = helix(frame = self.esqueleto, pos=(0,0,0), axis=(0,-0.75,0), radius=0.03, thickness=0.035)
        caudacentroCorpo1 = helix(frame = self.esqueleto, pos=(0.2*escala,0,0), axis=(0,-0.75,0), radius=0.03, thickness=0.025)
        caudacentroCorpo2 = helix(frame = self.esqueleto, pos=(-0.2*escala,0,0), axis=(0,-0.75,0), radius=0.03, thickness=0.032)

        cauda1 = helix(frame = self.esqueleto, pos=(-0.16*escala,-0.05*escala,0.1*escala), axis=(0,-0.65,0), radius=0.05, thickness=0.02)
        
        cauda2 = helix(frame = self.esqueleto,pos=(0,0,0.1*escala), axis=(0,-0.65,0), radius=0.05, thickness=0.015)
        cauda3 = helix(frame = self.esqueleto,pos=(0.05*escala,0,0.18*escala), axis=(0,-0.65,0), radius=0.05, thickness=0.02)
        cauda4 = helix(frame = self.esqueleto,pos=(0.05*escala,0,-0.1*escala), axis=(0,-0.65,0), radius=0.05, thickness=0.025)
        cauda5 = helix(frame = self.esqueleto,pos=(0,0,-0.1*escala), axis=(0,-0.65,0), radius=0.05, thickness=0.015)
        cauda6 = helix(frame = self.esqueleto,pos=(-0.176*escala,0,-0.1*escala), axis=(0,-0.65,0), radius=0.05, thickness=0.02)


    def get_texture(self, file_name, width, height):
        im = Image.open(file_name)
        im = im.resize((width,height), Image.ANTIALIAS)
        return materials.texture(data=im, interpolate=False)


if __name__ == "__main__":

    cenario= Cenario()

    cenario.principal()
