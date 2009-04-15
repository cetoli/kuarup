from Ponto import *


"""
    Vertices do cubo

      6 |---------------| 5
        |               |
   2|------------| 1    |
    | 7 |--------|------| 4
    |            |
   3|------------| 0


"""
class Posicao:
    pontoBaixo= Ponto (0,0,0)
    pontoCima= Ponto (0,0,0)
    sentido= Ponto (1,0,0)

    # variavel que representa uma caixa usada como teste
    teste= None

    # ponto 0
    def setPontoBaixo (self, x= 0, y= 0, z= 0):
        #print ">>>>>>>>> PONTO BAIXO %f %f %f\n" % (x, y, z)
        self.pontoBaixo= Ponto (x, y, z)

    # ponto 6
    def setPontoCima (self, x= 0, y= 0, z= 0):
        #print ">>>>>>>>> PONTO CIMA %f %f %f\n" % (x, y, z)
        self.pontoCima= Ponto (x, y, z)

    def setVetorSentido (self, x= 0, y= 0, z= 0):
        self.sentido= Ponto (x, y, z)

    def getPontoBaixo (self):
        return self.pontoBaixo

    def getPontoCima (self):
        return self.pontoCima

    def getVetorSentido (self):
        return self.sentido

    def clonar (self):
        obj= Posicao ()
        ponto= self.pontoBaixo
        obj.pontoBaixo= Ponto (ponto.getX (), ponto.getY (), ponto.getZ ())

        ponto= self.pontoCima
        obj.pontoCima= Ponto (ponto.getX (), ponto.getY (), ponto.getZ ())

        ponto= self.sentido
        obj.sentido= Ponto (ponto.getX (), ponto.getY (), ponto.getZ ())

        return obj

    def deslocarPontos (self, incremento):
        sentidoDesloc= Ponto (self.sentido.getX (), self.sentido.getY (), self.sentido.getZ ())

        #print ">>%s<<\n" % (incremento)
        #incr= Ponto (incremento.getX (), incremento.getY (), incremento.getZ ())
        incr= incremento

        self.pontoBaixo.somar (incr, sentidoDesloc)
        self.pontoCima.somar (incr, sentidoDesloc)

        self.testeQuadrado()

    def passouCompletoCantoEsquerdo (self, incremento, posTela):
        posFuturaPeixe= self.clonar ()

        posFuturaPeixe.deslocarPontos (incremento)

        baixo= posFuturaPeixe.getPontoBaixo ()
        cima= posFuturaPeixe.getPontoCima ()

        # se peixe dentro do intervalo posTela[0] <-> posTela[6] => OK
        #x0Peixe= baixo.getX ()
        #y0Peixe= baixo.getY ()
        #z0Peixe= baixo.getZ ()

        x6Peixe= cima.getX ()
        #y6Peixe= cima.getY ()
        #z6Peixe= cima.getZ ()

        baixo= posTela.getPontoBaixo ()
        cima= posTela.getPontoCima ()

        #x0Tela= baixo.getX ()
        #y0Tela= baixo.getY ()
        #z0Tela= baixo.getZ ()

        x6Tela= cima.getX ()-1
        #y6Tela= cima.getY ()
        #z6Tela= cima.getZ ()

        # quando passar um pouco, para passar por completo tem que ser o x0Peixe
        if (x6Peixe <= x6Tela):
            return 1

        return 0

    def estaDentroTela (self, posTela):
        baixo= self.getPontoBaixo ()
        cima= self.getPontoCima ()

        # se peixe dentro do intervalo posTela[0] <-> posTela[6] => OK
        x0Peixe= baixo.getX ()
        y0Peixe= baixo.getY ()
        z0Peixe= baixo.getZ ()

        x6Peixe= cima.getX ()
        y6Peixe= cima.getY ()
        z6Peixe= cima.getZ ()

        baixo= posTela.getPontoBaixo ()
        cima= posTela.getPontoCima ()

        x0Tela= baixo.getX ()
        y0Tela= baixo.getY ()
        z0Tela= baixo.getZ ()

        x6Tela= cima.getX ()
        y6Tela= cima.getY ()
        z6Tela= cima.getZ ()

        if (x0Peixe > x0Tela) | (x0Peixe < x6Tela):
            return 0

        if (y0Peixe < y0Tela) | (y0Peixe > y6Tela):
            return 0

        return 1


    def permitidoPeixeMover (self, peixe, incremento, posTela):
        posFuturaPeixe= peixe.getPosicao ()
        posFuturaPeixe= posFuturaPeixe.clonar ()

        posFuturaPeixe.deslocarPontos (incremento)

        # incremento peixe esta fora tela?
        ret= posFuturaPeixe.estaDentroTela (posTela)

        return ret

    def testeQuadrado (self):
        pass
        """     " ""
        p, l, h, w= self.calculoQuadrado ()

        if self.teste != None:
            self.teste.visible= 0

        self.teste= box (pos= p, length=l, height=h, width=w, color=color.yellow, opacity= 0.1)
        " ""    """

    def imprimir (self, rotulo):
        self.pontoCima.imprimir (rotulo+" - CIMA")
        self.pontoBaixo.imprimir (rotulo+" - BAIXO")

    def calculoQuadrado (self):
        posBaixo, posCima= self.pontoBaixo, self.pontoCima
        xC= posCima.getX()
        yC= posCima.getY()
        zC= posCima.getZ()

        xB= posBaixo.getX()
        yB= posBaixo.getY()
        zB= posBaixo.getZ()

        l= (xB-xC)
        h= (yC-yB)
        w= (zB-zC)

        pX= xC + l/2
        pY= yB + h/2
        pZ= zC + w/2

        if l < 0:
            l*= (-1)

        if h < 0:
            h*= (-1)

        if w < 0:
            w*= (-1)

        return (pX, pY, pZ), l, h, w

# Fim