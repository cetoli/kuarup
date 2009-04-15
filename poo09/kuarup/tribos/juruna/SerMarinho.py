from visual import *
from Ponto import *
import Image
from Posicao import *
from threading import Thread

# Classe generica do ser marinho
class SerMarinho (Thread):
    def __init__ (self, escala= 1, **complemento):
        Thread.__init__ (self)
        self.esqueleto= frame (**complemento)
        self.posicao= Posicao ()

        # Valores padrao
        self.escala= escala
        self.VELOCIDADE_NADO= 1 # 0.2
        self.dano= 5
        self.velocidade= self.VELOCIDADE_NADO
        self.funcaoThread= None

    def run (self):
        if self.funcaoThread != None:
            self.funcaoThread ()

    def getDano (self):
        return self.dano

    def setFuncaoThread (self, funcao):
        self.funcaoThread= funcao

    def setVelocidade (self, incremento):
        self.velocidade= self.VELOCIDADE_NADO * incremento

    def getPosicao (self):
        return self.posicao

    def getVelocidade (self):
        return self.velocidade

    # Retorna um objeto Ponto com o eixo do sentido multiplicado pela velocidade.
    # Ou seja, se multiplicarmos o x pelo x retornado teremos o x novo.
    def getIncrementoNado (self):
        sentido= self.posicao.getVetorSentido ()
        sentido= sentido.clonar ()

        sentido.multiplicarX (self.velocidade)
        sentido.multiplicarY (self.velocidade)
        sentido.multiplicarZ (self.velocidade)

        return sentido

    def calcularPosicaoNado (self, sentido):
        sentido.multiplicarX (self.velocidade)
        sentido.multiplicarY (self.velocidade)
        sentido.multiplicarZ (self.velocidade)

    def carregarTextura (self, arquivo, tipoMapeamento, comprimento, altura):
        im= Image.open (arquivo)
        im= im.resize ((comprimento,altura), Image.ANTIALIAS)
        return materials.texture (data=im, mapping=tipoMapeamento, interpolate=False)


    def nadar (self, pontoEixo):
        pass

    def girar (self, angulo, eixo):
        pass

    def matar (self):
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

    def chocou (self, posElem2):
        posElem1= self.posicao
        baixo= posElem1.getPontoBaixo ()
        cima= posElem1.getPontoCima ()

        x0Elem1= baixo.getX ()
        y0Elem1= baixo.getY ()
        z0Elem1= baixo.getZ ()

        x6Elem1= cima.getX ()
        y6Elem1= cima.getY ()
        z6Elem1= cima.getZ ()

        baixo= posElem2.getPontoBaixo ()
        cima= posElem2.getPontoCima ()

        x0Elem2= baixo.getX ()
        y0Elem2= baixo.getY ()
        z0Elem2= baixo.getZ ()

        x6Elem2= cima.getX ()
        y6Elem2= cima.getY ()
        z6Elem2= cima.getZ ()

        #print "pos 0 elem 1: %f %f %f\n" % (x0Elem1, y0Elem1, z0Elem1)
        #print "pos 6 elem 1: %f %f %f\n" % (x6Elem1, y6Elem1, z6Elem1)

        #print "pos 0 elem 2: %f %f %f\n" % (x0Elem2, y0Elem2, z0Elem2)
        #print "pos 6 elem 2: %f %f %f\n" % (x6Elem2, y6Elem2, z6Elem2)


        # caso onde o elemento 2 esta + a esquerda e o elemento 1 esta mais a baixo
        if ( (x0Elem2 >= x0Elem1) & (x0Elem2 <= x6Elem1) ) & ( (y0Elem2 <= y6Elem1) & (y0Elem2 >= y0Elem1) ):
            return 1


        if ( (x6Elem2 >= x6Elem1) & (x6Elem2 <= x0Elem1) ):
            # caso onde o elemento 1 esta + a esquerda e a baixo
            if ( (y0Elem2 <= y6Elem1) & (y0Elem2 >= y0Elem1) ) :
                return 1

            # caso onde o elemento 1 esta + a esquerda e a acima
            if ( (y6Elem2 <= y6Elem1) & (y6Elem2 >= y0Elem1) ) :
                return 1


        # caso onde o elemento 2 esta + a esquerda e o elemento 1 esta mais a acima
        if ( (x0Elem2 >= x6Elem1) & (x0Elem2 <= x0Elem1) ) & ( (y6Elem2 <= y6Elem1) & (y6Elem2 >= y0Elem1) ):
            return 1

        # caso onde o elemento 1 esta totalmente dentro do elemento 2
        if ( (x6Elem1 >= x6Elem2) & (x6Elem1 <= x0Elem2) ) & ( (y6Elem1 <= y6Elem2) & (y6Elem1 >= y0Elem2) ) :
            return 1

        # caso onde o elemento 2 esta totalmente dentro do elemento 1 => ja abordado acima

        # melhoria do caso funcionando a meia-boca, mas nao foi testado

        return 0


    def nadarPara (self, posicaoFinal):
        xFinal= posicaoFinal[0]
        yFinal= posicaoFinal[1]
        zFinal= posicaoFinal[2]

        x= self.esqueleto.pos[0]
        y= self.esqueleto.pos[1]
        z= self.esqueleto.pos[2]

#        print "Nadando XFINAL %f %f %f\n" % (xFinal, yFinal, zFinal)

        while (x != xFinal) | (y != yFinal) | (z != zFinal):
            xTemp= xFinal - x
            yTemp= yFinal - y
            zTemp= zFinal - z

            maior= self.buscarMaiorNumero (xTemp, yTemp, zTemp)

            self.nadar ( Ponto (xTemp/maior, yTemp/maior, zTemp/maior))
#            print "Nadando  %f %f %f\n" % (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

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
