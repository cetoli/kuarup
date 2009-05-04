from visual import *
from SerMarinho import SerMarinho


TITLE = 'BlueFish'


class Cenario:
    
    def __init__(self):

        scene2 = display(title=TITLE,
                         width=150,
                         height=150,
                         center= (0,0,0),
                         x=0,
                         y=0)

        scene2.x, scene2.y =0,0

        scene2.select()

        scene2.autoscale = 1

        self.quadro = 0


class BlueFish(SerMarinho):

    def desenha(self, escala=1):
        
        self.corpo = Corpo(self.esqueleto)

        self.olho = Olho(self.esqueleto)

        self.barbatanaEsquerda = BarbatanaEsquerda(self.esqueleto)

        self.barbatanaDireita = BarbatanaDireita(self.esqueleto)

        self.guelrras = Guelrras(self.esqueleto)
        
        self.boca = Boca(self.esqueleto)
    
        self.rabo = Rabo(self.esqueleto)


class Corpo():

    def __init__(self, esqueleto):

        self.esqueleto = esqueleto

        self.desenha()

    def desenha(self, escala=1):

        self.estrutura1 = pyramid(frame = self.esqueleto, pos=(0,0,0), size=(3*escala,5*escala,.5*escala), color=color.yellow, opacity=.4)

        self.estrutura2 = pyramid(frame = self.esqueleto, pos=(0,0,0), size=(5*escala,5*escala,.5*escala), axis=(-1*escala,0,0), color=color.yellow, opacity=.4)    

        self.corpo = ellipsoid (frame = self.esqueleto, pos=(0,-.4*escala,0), length=8*escala, height=4*escala, width=2*escala, color=color.blue)


class BarbatanaEsquerda():

    def __init__(self, esqueleto):

        self.esqueleto = esqueleto

        self.desenha()

    def desenha(self, escala=1):

        self.barbatanaEsquerda = pyramid(frame = self.esqueleto, pos=(0,-.6*escala,0), size=(3*escala,3*escala,.3*escala), axis=(-1*escala,-.8*escala,-1*escala), color=color.yellow, opacity=.5)


class BarbatanaDireita():

    def __init__(self, esqueleto):

        self.esqueleto = esqueleto

        self.desenha()

    def desenha(self, escala=1):

        self.barbatanaDireita = pyramid(frame = self.esqueleto, pos=(0,-.6*escala,0), size=(3*escala,3*escala,.3*escala), axis=(-1*escala,-.8*escala,1*escala), color=color.yellow, opacity=.5)


class Guelrras():

    def __init__(self, esqueleto):

        self.esqueleto = esqueleto

        self.desenha()

    def desenha(self, escala=1):

        self.guelrrasEsqueda1 = cylinder(frame = self.esqueleto, pos=(2.32*escala,-.38*escala,-.3*escala), length=.1*escala, axis=(5*escala,0,-7*escala), radius=1.3*escala, color=color.blue)

        self.guelrrasEsqueda2 = cylinder(frame = self.esqueleto, pos=(2.3*escala,-.38*escala,-.25*escala), length=.05*escala, axis=(5*escala,0,-7*escala), radius=1.3*escala, color=color.red)

        self.guelrrasDireita1 = cylinder(frame = self.esqueleto, pos=(2.32*escala,-.38*escala,.3*escala), length=.1*escala, axis=(5*escala,0,7*escala), radius=1.3*escala, color=color.blue)

        self.guelrrasDireita2 = cylinder(frame = self.esqueleto, pos=(2.3*escala,-.38*escala,.25*escala), length=.05*escala, axis=(5*escala,0,7*escala), radius=1.3*escala, color=color.red)


class Olho():

    def __init__(self, esqueleto):

        self.esqueleto = esqueleto

        self.desenha()

    def desenha(self, escala=1):
        
        self.olho1 = ellipsoid (frame = self.esqueleto, pos=(2.5*escala,.5*escala,0), length=.6*escala, height=.6*escala, width=1.5*escala, color=color.white)

        self.olho2 = ellipsoid (frame = self.esqueleto, pos=(2.55*escala,.5*escala,0), length=.25*escala, height=.25*escala, width=1.6*escala, color=color.black)
        

class Boca():
    
    def __init__(self, esqueleto):

        self.esqueleto = esqueleto

        self.desenha()

    def desenha(self, escala=1):

        self.boca1 = ellipsoid (frame = self.esqueleto, pos=(3.5*escala,-.4,0*escala), length=1*escala, height=.5*escala, width=.7*escala, color=color.blue)

        self.boca2 = ellipsoid (frame = self.esqueleto, pos=(3.5*escala,-.3,0*escala), length=1*escala, height=.5*escala, width=.7*escala, color=color.blue)
    

class Rabo():

    def __init__(self, esqueleto):

        self.esqueleto = esqueleto

        self.desenha()

    def desenha(self, escala=1):

        self.rabo1 = pyramid(frame = self.esqueleto, pos=(-5*escala,-.4*escala,0), size=(4*escala,4*escala,1*escala), color=color.yellow, opacity=.5)

        self.rabo2 = pyramid(frame = self.esqueleto, pos=(-5.01*escala,-.4,0*escala), size=(4*escala,4.1*escala,.3*escala), color=color.black)


    def proximoFrame(self):

        pass


if __name__ == "__main__":

    cenario = Cenario()

    cenario.principal()
