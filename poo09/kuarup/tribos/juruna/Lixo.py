from Posicao import *
from Ponto import *
from Eixo import *

class Lixo:
    def __init__ (self, escala= 1, **complemento):
        self.esqueleto= frame (**complemento)
        self.elementos= list ()
        self.escala= escala

        self.posicao= Posicao ()

        self.velocidade= 0.2
        self.dano= 10

    def desenhar (self):
        pass

    def setVelocidade (self, valor):
        self.velocidade= valor

    def getPosicao (self):
        return self.posicao

    def girar (self, angulo, eixoRotacao):
        eixo= Eixo ()
        anguloRad= eixo.converterGrausRadiano (angulo)
        self.esqueleto.rotate (angle= anguloRad, axis= eixoRotacao)

    def afundar (self):
        esqueleto= Ponto (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

        incremento= Ponto (0,self.velocidade * (-1), 0)
        esqueleto.somar (incremento)

        self.esqueleto.pos= esqueleto.getLista ()
        self.posicao.deslocarPontos (incremento)

    def destruir (self):
        cont= 0
        while cont < self.elementos.__len__ ():
            temp= self.elementos.__getitem__ (cont)
            temp.visible= 0

            cont+= 1

    def chegouFundo (self, posTela):
        temp= self.posicao.getPontoBaixo()
        y= temp.getY ()
        temp= posTela.getPontoBaixo ()
        yTela= temp.getY ()

        if y < yTela:
            return 1

        return 0