from Tabuleiro import *
from Peca import *
from PecaResultado import *
from PecaListener import *
from Observer import *


class TabuleiroLogica (Tabuleiro):
    linhasResultado= 3
    colunasResultado= 3

    def __init__ (self):
        Tabuleiro.__init__ (self)
        self.placar.visible= False


    def verificarChoquePeixe (self, peca, peixe):
        peca.verificarEstado (peixe.getPosicao ()) # tem que passar a peca anterior a ter sido visitada ou

    def criarPecas (self):
        listener= PecaListener ()
        observador= Observer (listener, self)

        colunas= self.matriz.getQtdColunas ()
        linhas= self.matriz.getQtdLinhas ()

        str= "123456789"

        i= self.gerarValorAleatorio (0, str.__len__()-1)

        tam= len (str)
        if tam > colunas:
            raise Exception ("Tamanho da palavra maior que a coluna!")

        # Guardo 2 linhas sendo uma para fronteira e a putra para os valores montados.
        valores= self.definirPecas (linhas - 4, colunas, tam)


        cont= 0
        for i in range(linhas-4):
             for j in range(colunas):
                 ponto= self.calcularPontoMeioPeca (i, j)

                 texto= ""

                 valor= valores.getItem (i, j)
                 if valor != -1:
                     texto= str[valor]
                     peca= Peca (ponto, texto, observador)
                     self.matriz.setItem (i, j, peca)

        # Crio pecas do tipo resultado.
        i= linhas-self.linhasResultado

        pos= 0

        while i < linhas:
            j= (colunas/2) - (self.colunasResultado/2)
            fim= j + self.colunasResultado

            while j < fim:
                ponto= self.calcularPontoMeioPeca (i, j)
                peca= PecaResultado (ponto, str[pos], observador)
                self.matriz.setItem (i, j, peca)

                j+= 1
                pos+= 1

            i+= 1

    def definirPecas (self, linhas, colunas, qtdPecas):
        matrizValores= Matriz (linhas, colunas, -1)

        if (linhas*colunas) <= (qtdPecas):
            raise Exception ("A quantidade de pecas e muito grande para a quantidade de espacos no tabuleiro!!!")

        qtdPecas-= 1
        while qtdPecas >= 0:
            # calcula para o valor.
            l, c= self.gerarLinhaColunaPeca (linhas, colunas, matrizValores)
            matrizValores.setItem (l, c, qtdPecas)

            qtdPecas-= 1

        return matrizValores

# Fim