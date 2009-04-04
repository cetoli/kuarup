from visual import *

TITLE = 'Caranguejo'

class Cenario:

    def __init__(self):

        scene2 = display(title=TITLE, width=600, height=600, center= (0,0,0), x=0, y=0)

        scene2.x, scene2.y =0,0

        scene2.select()

        scene2.autoscale = 1

        self.quadro = 0

    def principal(self):

        caranguejo1 = Caranguejo(escala =1, axis=(1,0,0), pos= (1,-6,0))

        caranguejo1.carregarMochila(color.red)

        caranguejo1.colocarBigode(tamanho = 5, cor = color.black)

        caranguejo1.colocarChapeu(color.white)


class SerMarinho():

    def __init__(self, escala= 1, **qualquer_outro_parametro):

        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"

        self.esqueleto=frame(**qualquer_outro_parametro)

        self.setEscala(escala)

        self.desenha(escala)

    def getEsqueleto(self):

        return self.esqueleto

    def setEscala(self, escala):

        self.escala = escala

    def getEscala(self):

        return self.escala

    def desenha(self): pass


class Caranguejo(SerMarinho):

    def desenha(self, escala=1):

        corpo=sphere(frame = self.esqueleto, pos=vector(4*escala,7*escala,3*escala),radius=8*escala, color=color.orange)



        olhoEsquerdo=sphere(frame = self.esqueleto, pos=vector(1*escala,13*escala,10*escala),radius=1*escala,color=color.white)

        centroOlhoEsquerdo=sphere(frame = self.esqueleto, pos=vector(1*escala,13.2*escala,11*escala),radius=0.4*escala,color=color.black)

        olhoDireito=sphere(frame = self.esqueleto, pos=vector(6*escala,13*escala,10*escala),radius=1*escala,color=color.white)

        centroOlhoDireito=sphere(frame = self.esqueleto, pos=vector(6*escala,13.2*escala,11*escala),radius=0.4*escala,color=color.black)

        boca = ellipsoid(frame = self.esqueleto, pos=(4*escala,7*escala,9*escala), color=color.red, length=6*escala, height=4*escala, width=5*escala)

        bracoEsquerdo = ellipsoid(frame = self.esqueleto, pos=(-2*escala,9*escala,8*escala), color=color.orange, length=4*escala, height=8*escala, width=5*escala)

        bracoEsquerdo.rotate(angle=90, axis=(1,0,1))

        bracoDireito = ellipsoid(frame = self.esqueleto, pos=(11*escala,9*escala,8*escala), color=color.orange, length=4*escala, height=8*escala, width=5*escala)

        bracoDireito.rotate(angle=90, axis=(1,0,1))

        ganchoEsquerdo=sphere(frame = self.esqueleto, pos=vector(-6*escala,12.5*escala,9*escala),radius=3.5*escala,color=color.orange)

        ganchoDireito=sphere(frame = self.esqueleto, pos=vector(13*escala,12.5*escala,9*escala),radius=3.5*escala,color=color.orange)

        garraSupEsquerda1 = cone(frame = self.esqueleto, pos=(-6.5*escala,13*escala,11*escala), axis=(2,2,10), length=8*escala, radius=2*escala, color=color.white)

        garraSupDireita1 = cone(frame = self.esqueleto, pos=(-4.5*escala,13*escala,10*escala), axis=(4,3,10), length=8*escala, radius=2*escala, color=color.white)



        garraSupEsquerda2 = cone(frame = self.esqueleto, pos=(11.8*escala,13*escala,10*escala), axis=(-4,15,10), length=7*escala, radius=2*escala, color=color.white)

        garraSupDireita2 = cone(frame = self.esqueleto, pos=(14*escala,13*escala,10*escala), axis=(4,3,10), length=8*escala, radius=2*escala, color=color.white)

        cinto = ring(frame = self.esqueleto, pos=(3.3*escala,3*escala,2.8*escala), axis=(0,1,0), radius=8*escala)

        pata1 = cylinder(frame = self.esqueleto, pos=(-1.5*escala,-3*escala,8*escala), axis=(1,2,-1), radius=2*escala, height=5*escala, length=5*escala)

        ganchoPata1=sphere(frame = self.esqueleto, pos=(-3*escala,-5*escala,9*escala),radius=3.5*escala,color=color.orange)

        pata2 = cylinder(frame = self.esqueleto, pos=(7*escala,-3*escala,8*escala), axis=(0,1.5,-1), radius=2*escala, height=5*escala, length=5*escala)

        ganchoPata2=sphere(frame = self.esqueleto, pos=(7*escala,-5.0*escala,9*escala),radius=3.2*escala,color=color.orange)

    def carregarMochila(self, cor):

        mochila = Mochila(frame = self.esqueleto, escala = self.getEscala(), x = 4, y = 7, z = -6, cor = cor)

    def colocarBigode(self, tamanho = 5, cor = color.black):

        escala = self.getEscala()

        bigodeEsquerdo = ellipsoid(frame = self.esqueleto, pos=(3*escala,9*escala,11*escala), radius=1*escala,color=cor, length = tamanho * escala)

        bigodeDireito = ellipsoid(frame = self.esqueleto, pos=(5*escala,9*escala,11*escala),radius=1*escala,color=cor, length = tamanho * escala)

    def colocarChapeu(self, cor = color.magenta):

        escala = self.getEscala()

        suporteChapeu = ellipsoid(frame = self.esqueleto, pos=(4*escala,16*escala,4*escala), radius=1*escala,color=cor, length = 10 * escala, height = 4 * escala, width = 10 * escala)

        topoChapeu = ellipsoid(frame = self.esqueleto, pos=(4*escala,18*escala,4*escala), radius=1*escala,color=cor, length = 5 * escala, height = 6 * escala, width = 5 * escala)

class Mochila():

    def __init__(self, escala= 1, x = 4, y = 7, z = -6, cor = color.green, **qualquer_outro_parametro):

        self.esqueleto=frame(**qualquer_outro_parametro)

        self.desenha(escala, x, y, z, cor)

    def desenha(self, escala=1, x = 4, y = 7, z = -6, cor=color.green):

        mochila = ellipsoid(frame = self.esqueleto, pos = (x*escala,y*escala,z*escala), color=cor, length=11*escala, height=12*escala, width=4*escala)

if __name__ == "__main__":

    cenario = Cenario()

    cenario.principal()