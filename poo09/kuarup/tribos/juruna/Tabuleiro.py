from Posicao import *
from Ponto import *
from Peca import *
from Matriz import *
from IteradorMatriz import *
from random import *

class Tabuleiro:
    # Medidas tabuleiro.
    largura= 4.60
    altura= 3.50

    # Medidas Borda.
    alturaBorda= 0.5
    profundidadeBorda= 1

    intervaloEntrePecas= 0.01

    def __init__ (self, pontoMeio= Ponto (0,0,0)):
        self.selecionadas= list ()
        self.pontoMeio= pontoMeio
        self.calcularBorda ()
        self.definirAreaUtil ()
        self.criarTabuleiro ()
        self.pecas= vector ()

        peca= Peca ()
        self.dxPeca= peca.getDeslocamentoX ()
        self.dyPeca= peca.getDeslocamentoY ()
        peca.sumir ()
        peca= None

        linhas, colunas= self.calcularLinhasColunas ()
        self.criarNumeracaoTabuleiro ()
        self.criarPlacar ()
        self.matriz= Matriz (linhas, colunas, None)

    def criarPlacar (self):
        linhas, colunas= self.calcularLinhasColunas ()

        # Monto pelo ponto de cima.
        temp= self.borda.getPontoCima ()
        xCima= temp.getX ()
        y= temp.getY () + (self.alturaBorda/2)
        z= temp.getZ ()

        temp= self.borda.getPontoBaixo ()
        xBaixo= temp.getX ()

        x= xCima + ((xBaixo-xCima)/2)

        posicao= (x,y,z)
        self.placar= label (pos= posicao, text= "", xoffset=0, yoffset= 0, space= 0, border= 4, height=15, color= color.white, font='sans')

    def criarNumeracaoTabuleiro (self):
        linhas, colunas= self.calcularLinhasColunas ()

        # Monto as numeracoes de cima e de baixo.
        temp= self.borda.getPontoCima ()
        yCima= temp.getY ()
        z= temp.getZ ()

        temp= self.borda.getPontoBaixo ()
        yBaixo= temp.getY ()

        for j in range (colunas):
            ponto= self.calcularPontoMeioPeca (0, j)
            ponto.setZ (z)
            ponto.setY (yCima)
            posicao= ponto.getLista ()
            label (pos= posicao, text= str (j), xoffset=0, yoffset= 0, space= 0, border= 4, height=15, color= color.white, font='sans')

            ponto.setY (yBaixo)
            posicao= ponto.getLista ()
            label (pos= posicao, text= str (j), xoffset=0, yoffset= 0, space= 0, border= 4, height=15, color= color.white, font='sans')

        # Monto a numeracao da esquerda e da direita.
        temp= self.borda.getPontoCima ()
        xEsq= temp.getX ()
        z= temp.getZ ()

        temp= self.borda.getPontoBaixo ()
        xDir= temp.getX ()
        for i in range (linhas):
            ponto= self.calcularPontoMeioPeca (i, 0)
            ponto.setZ (z)
            ponto.setX (xEsq)
            posicao= ponto.getLista ()
            label (pos= posicao, text= str (i), xoffset=0, yoffset= 0, space= 0, border= 4, height=15, color= color.white, font='sans')

            ponto.setX (xDir)
            posicao= ponto.getLista ()
            label (pos= posicao, text= str (i), xoffset=0, yoffset= 0, space= 0, border= 4, height=15, color= color.white, font='sans')

    def calcularLinhasColunas (self):
        dx= self.dxPeca
        dy= self.dyPeca

        # qtdColunas= Maior inteiro (dx*Qtd + intervalo* (Qtd-1)) = largura
        qtdColunas= self.calcularQtdPecas (dx, self.intervaloEntrePecas, self.largura)

        qtdLinhas= self.calcularQtdPecas (dy, self.intervaloEntrePecas, self.altura)

        print "Linhas %d Colunas %d\n" % (qtdLinhas, qtdColunas)

        return qtdLinhas, qtdColunas

    def calcularQtdPecas (self, desloc, intervalo, esperado):
        maximo= int (esperado/desloc)

        return self.calcularQtdPecas_recursivo (desloc, intervalo, esperado, maximo)

    def calcularQtdPecas_recursivo (self, desloc, intervalo, esperado, valor):
        if valor == 0:
            return 0

        calculo= (valor * desloc) + (intervalo * (valor-1))
        if calculo <= esperado:
            return valor

        return self.calcularQtdPecas_recursivo (desloc, intervalo, esperado, valor-1)

    def calcularPontoMeioPeca (self, linha, coluna):
        #
        dx= self.dxPeca/2 + (self.dxPeca * coluna) + (self.intervaloEntrePecas * coluna)
        dy= self.dyPeca/2 + (self.dyPeca * linha) + (self.intervaloEntrePecas * linha)

        pontoC= self.posicao.getPontoCima ()
        x, y, zC= pontoC.getX (), pontoC.getY (), pontoC.getZ ()

        x+= dx
        y-= dy

        pontoB= self.borda.getPontoBaixo ()
        zB= pontoB.getZ ()
        z= zC + ((zB - zC)/2)

        return Ponto (x, y, z)

    def calcularBorda (self):
        z= self.pontoMeio.getZ ()

        # Ponto cima
        x= self.pontoMeio.getX () - (self.largura/2) - (self.alturaBorda/2)
        y= self.pontoMeio.getY () + (self.altura/2) + (self.alturaBorda/2)
        self.borda= Posicao ()
        self.borda.setPontoCima (x, y, z)

        # Ponto baixo
        x= self.pontoMeio.getX () + (self.largura/2) + (self.alturaBorda/2)
        y= self.pontoMeio.getY () - (self.altura/2) - (self.alturaBorda/2)
        self.borda.setPontoBaixo (x, y, z)

    def definirAreaUtil (self):
        pontoC= self.borda.getPontoCima ()
        pontoB= self.borda.getPontoBaixo ()

        xc, yc, zc= pontoC.getX (), pontoC.getY (), pontoC.getZ ()
        xb, yb, zb= pontoB.getX (), pontoB.getY (), pontoB.getZ ()

        dx= self.alturaBorda/2
        xc+= dx
        dy= dx

        self.posicao= Posicao ()
        self.posicao.setPontoCima (xc, yc-0.25, zc)


        #dx= 0.3 # Peca.tamanho
        xb-= dx
        self.posicao.setPontoBaixo (xb, yb+0.25, zb)
        self.posicao.imprimir ('Area Util')

    def criarTabuleiro (self):
        # so para marcar o meio.
        #points(pos=[(0,0,0.51)], size=10, color=color.red)

        pontoC= self.borda.getPontoCima ()
        pontoB= self.borda.getPontoBaixo ()

        xc, yc, zc= pontoC.getX (), pontoC.getY (), pontoC.getZ ()
        xb, yb, zb= pontoB.getX (), pontoB.getY (), pontoB.getZ ()

        self.borda.imprimir ('Borda')

        dx= xb-xc
        dy= yc-yb
        dz= zb-zc

        h= self.alturaBorda
        w= self.profundidadeBorda

        # cima
        self.bordaCima= box (pos= (xc+(dx/2), yc, zb), length= dx, height= h, width= w, color= color.white)
        #box (pos= (xc+dx/2, yc+3, zb+5), length= dx, height= h, width= w, color= color.white)

        # baixo
        self.bordaBaixo= box (pos= (xc+(dx/2), yb, zb), length= dx, height= h, width= w, color= color.white)
        #box (pos= (xc+dx/2, yb-3, zb+5), length= dx, height= h, width= w, color= color.white)

        # esquerda
        self.bordaEsquerda= box (pos= (xc, yb + (dy/2), zb), axis= (0,1,0), length= dy, height= h, width= w, color= color.white)
        #box (pos= (xc-h/2, yb+dy/2, zb+5), axis= (0,1,0), length= xb-xc+1, height= h, width= w, color= color.white)

        # direita
        self.bordaDireita= box (pos= (xb, yb + (dy/2), zb), axis= (0,1,0), length= dy, height= h, width= w, color= color.white)
        #box (pos= (xb+h/2, yb+dy/2, zb+5), axis= (0,1,0), length= xb-xc+1, height= h, width= w, color= color.white)

        # Fundo
        self.fundo= box (pos= (xc+(dx/2), yb + (dy/2), zb-(w/2)), length= dx, height= dy, width= 0.1, color= color.white, opacity= 0.5)

    def buscarPecaNaPosicao (self, posPeixe):
        it= IteradorMatriz (self.matriz)

        while (it.temProximo () == True):
            peca= it.proximo ()
            if (peca == None) | (peca == 0):
                continue

            if self.verificarChoqueComPeixe (peca, posPeixe) == True:
                return peca

        return None

    def verificarChoqueComPeixe (self, peca, posPeixe):
        #posPeixe.estaDentroTela (peca.getPosicao ())

    #def estaDentroTela (self, posTela):
        pontoPeixe= posPeixe #.calcularPontoMeio ()
        posPeca= peca.getPosicao ()

        # se peixe dentro do intervalo posTela[0] <-> posTela[6] => OK
        xPeixe= pontoPeixe.getX ()
        yPeixe= pontoPeixe.getY ()
        zPeixe= pontoPeixe.getZ ()


        baixo= posPeca.getPontoBaixo ()
        cima= posPeca.getPontoCima ()

        x0Tela= baixo.getX ()
        y0Tela= baixo.getY ()
        z0Tela= baixo.getZ ()

        x6Tela= cima.getX ()
        y6Tela= cima.getY ()
        z6Tela= cima.getZ ()

        if (xPeixe > x0Tela) | (xPeixe < x6Tela):
            return False

        if (yPeixe < y0Tela) | (yPeixe > y6Tela):
            return False

        return True


    """
    def selecionarPeca (self, posPeixe):
        it= IteradorMatriz (self.matriz)

        while (it.temProximo ()):
            peca= it.proximo ()
            if peca.estaDentroPeca (posPeixe) == True:
                peca.selecionarPeca ()
    """

    def getPontoMeio (self):
        return self.pontoMeio

    def getPosicao (self):
        return self.posicao

    def getDistanciaEntreCentrosPecas (self):
        return self.dxPeca + self.intervaloEntrePecas

    def getPecaSelecionada (self, pos):
        if self.selecionadas.__len__() <= pos:
            return None

        return self.selecionadas.__getitem__(pos)

    def adicionarPecaSelecionada (self, peca):
        print "Adicionando peca\n"
        self.selecionadas.append (peca)

    def removerPecaSelecionada (self, peca):
        print "Removendo peca\n"
        if self.selecionadas.__contains__(peca):
            self.selecionadas.remove (peca)

    def gerarValorAleatorio (self, min, max):
       random= Random ()
       return random.randint (min, max)

    def gerarLinhaColunaPeca (self, linhas, colunas, matrizValores):
        while 1:
            l= self.gerarValorAleatorio (0, linhas-1)
            c= self.gerarValorAleatorio (0, colunas-1)
            valor= matrizValores.getItem (l, c)
            if valor == -1:
                return l, c

    def sumirTextoPecas (self):
        colunas= self.matriz.getQtdColunas ()
        linhas= self.matriz.getQtdLinhas ()

        for i in range(linhas):
            for j in range(colunas):
                peca= self.matriz.getItem (i, j)

                if peca != None:
                    peca.sumirTexto ()


    def getPeca (self, linha, coluna):
        return self.matriz.getItem(linha, coluna)

    def setPeca (self, linha, coluna, peca):
        return self.matriz.setItem(linha, coluna, peca)

    def buscarLinhaColunaPeca (self, peca):
        colunas= self.matriz.getQtdColunas ()
        linhas= self.matriz.getQtdLinhas ()

        for i in range(linhas):
            for j in range(colunas):
                if self.getPeca (i, j) == peca:
                    return i, j

        return None

# Fim