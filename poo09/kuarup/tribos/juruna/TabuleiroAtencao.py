from Tabuleiro import *
from Peca import *
from Observer import *


class TabuleiroAtencao (Tabuleiro):
    def __init__ (self):
        Tabuleiro.__init__ (self)


    def criarPecas (self, qtdPecas):
        #listener= PecaAtencaoListener ()
        listener= None
        observador= Observer (listener, self)

        colunas= self.matriz.getQtdColunas ()
        linhas= self.matriz.getQtdLinhas ()

        valores= self.definirPecas (linhas, colunas, qtdPecas)

        str= 'ABCDEFGHIJKLMNOPQRSTUVXWYZ0123456789abcdefghijklmnopqrstuvxwyz'
        tam= len (str)

        cont= 0
        for i in range(linhas):
             for j in range(colunas):
                 ponto= self.calcularPontoMeioPeca (i, j)

                 texto= ""

                 valor= valores.getItem (i, j)
                 if valor != -1:
                     if valor >= tam:
                        valor%= tam

                     texto= str[valor]

                 peca= Peca (ponto, texto, observador)

                 self.matriz.setItem (i, j, peca)

    def definirPecas (self, linhas, colunas, qtdPecas):
        matrizValores= Matriz (linhas, colunas, -1)

        if (linhas*colunas) <= (qtdPecas):
            raise Exception ("A quantidade de pecas e muito grande para a quantidade de espacos no tabuleiro!!!")


        qtdPecas-= 1
        while qtdPecas >= 0:
            # calcula para o valor.
            l, c= self.gerarLinhaColunaPeca (linhas, colunas, matrizValores)
            matrizValores.setItem (l, c, self.gerarValorAleatorio (0, qtdPecas) )

            qtdPecas-= 1

        return matrizValores

    def procurarPosicaoAleatoria (self, vazia):
        colunas= self.matriz.getQtdColunas ()
        linhas= self.matriz.getQtdLinhas ()

        while 1:
            l= self.gerarValorAleatorio (0, linhas-1)
            c= self.gerarValorAleatorio (0, colunas-1)
            peca= self.matriz.getItem (l, c)
            valor= peca.getTexto ()

            if vazia == True:
                if valor == "":
                    return l, c
            else:
                if valor != "":
                    return l, c

    def buscarPosicaoPreenchida (self):
        return self.procurarPosicaoAleatoria (False)

    def buscarPosicaoVazia (self):
        return self.procurarPosicaoAleatoria (True)

    """
    Metodo de teste.
    """
    def testarPecas (self):
        pontoC= self.posicao.getPontoCima ()
        pontoB= self.posicao.getPontoBaixo ()

        xc, yc, zc= pontoC.getX (), pontoC.getY (), pontoC.getZ ()
        xb, yb, zb= pontoB.getX (), pontoB.getY (), pontoB.getZ ()

        dx= self.dxPeca
        xc+= (dx/2)
        dy= self.dyPeca
        yc-= (dy/2)

        #ponto= Ponto (xc, yc, zc)
        ponto= self.calcularPontoMeioPeca (0, 0)

        letras= ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U"]
        i= 0

        while (i < self.matriz.getQtdColunas ()):
            ponto.imprimir (letras[i])
            Peca (ponto, letras[i])

            i+= 1
            ponto= self.calcularPontoMeioPeca (0, i)


        # Faz vertical
        #yc-= dy
        #yc-= 0.25
        i= 0
        #k l m n  - o p q r s t u v x y w z
        letras= ["Z", "W", "Y", "X", "V", "T", "S", "R", "Q", "P", "O"]

        while (i < self.matriz.getQtdLinhas ()):
            ponto.imprimir (letras[i])
            Peca (ponto, letras[i])

            i+= 1
            ponto= self.calcularPontoMeioPeca (i, 0)

    def alterarPlacar (self, acertos, erros):
        self.placar.text= str (acertos) + " acertos e " + str(erros) + " erros"
# Fim