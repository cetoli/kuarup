from visual import *
from Ponto import *
import Image

# Classe generica do ser marinho
class SerMarinho:
    posicao= Ponto (0,0,0)
    VELOCIDADE_NADO= 0.5 # 0.2
    velocidade= 0

    def __init__ (self, escala= 1, **complemento):
        self.esqueleto= frame (**complemento)
        self.escala= escala
        self.velocidade= self.VELOCIDADE_NADO

        print "Construtor: X %f Y %f Z %f\n" % (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

        self.posicao= Ponto (0,0,0) #Ponto (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

    def setVelocidade (self, incremento):
        self.velocidade= self.VELOCIDADE_NADO * incremento


    def carregarTextura (self, arquivo, tipoMapeamento, comprimento, altura):
        im= Image.open (arquivo)
        im= im.resize ((comprimento,altura), Image.ANTIALIAS)
        return materials.texture (data=im, mapping=tipoMapeamento, interpolate=False)

    def nadar (self):
        pass

    def girar (self, angulo, eixo):
        pass

    def desenhar (self):
        pass
    def buscarMaiorNumero (self, x, y, z):
        if x < 0:
            x*= (-1)

        if y < 0:
            y*= (-1)

        if z < 0:
            z*= (-1)

        maior= x
        if y > maior:
            maior= y

        if z > maior:
            maior= z

        return maior

    def nadarPara (self, posicaoFinal):
        xFinal= posicaoFinal[0]
        yFinal= posicaoFinal[1]
        zFinal= posicaoFinal[2]

        x= self.esqueleto.pos[0]
        y= self.esqueleto.pos[1]
        z= self.esqueleto.pos[2]

        print "Nadando XFINAL %f %f %f\n" % (xFinal, yFinal, zFinal)

        while (x != xFinal) | (y != yFinal) | (z != zFinal):
            xTemp= xFinal - x
            yTemp= yFinal - y
            zTemp= zFinal - z

            maior= self.buscarMaiorNumero (xTemp, yTemp, zTemp)

            self.nadar ( Ponto (xTemp/maior, yTemp/maior, zTemp/maior))
            print "Nadando  %f %f %f\n" % (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

            x, y, z= self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2]

            if x == xFinal:
                if y == yFinal:
                    if z == zFinal:
                        return

    def girarPara (self, anguloTotal, anguloVez, eixo):
        angulo= anguloVez

        while angulo <= anguloTotal:
            self.girar (angulo, eixo)
            angulo+= anguloVez
            if angulo > anguloTotal:
                angulo= anguloTotal

# FIM
