from Tabuleiro import *
from Peca import *
from PecaMemoriaListener import *
from Observer import *


class TabuleiroMemoria (Tabuleiro):
    def __init__ (self):
        Tabuleiro.__init__ (self)


    def verificarChoquePeixe (self, peca, peixe):
        peca.verificarEstado (peixe.getPosicao ()) # tem que passar a peca anterior a ter sido visitada ou

    def criarPecas (self, qtdPecas):
        listener= PecaMemoriaListener ()
        observador= Observer (listener, self)

        colunas= self.matriz.getQtdColunas ()
        linhas= self.matriz.getQtdLinhas ()

        valores= self.definirPecas (linhas, colunas, qtdPecas)

        cont= 0
        for i in range(linhas):
             for j in range(colunas):
                 ponto= self.calcularPontoMeioPeca (i, j)

                 str= 'ABCDEFGHIJKLMNOPQRSTUVXWYZ'

                 texto= ""

                 valor= valores.getItem (i, j)
                 if valor != -1:
                     texto= str[valor]

                 peca= Peca (ponto, texto, observador)

                 """ cria um tabuleiro de 9 pecas para debug ""
                 if (i >= 4) & (i <= 6):
                     if (j >= 6) & (j <= 8):
                         peca= Peca (ponto, str[cont])
                         cont+= 1
                 """
                 self.matriz.setItem (i, j, peca)

    def definirPecas (self, linhas, colunas, qtdPecas):
        matrizValores= Matriz (linhas, colunas, -1)

        if (linhas*colunas) <= (2*qtdPecas):
            raise Exception ("A quantidade de pecas e muito grande para a quantidade de espacos no tabuleiro!!!")


        qtdPecas-= 1
        while qtdPecas >= 0:
            # calcula para o valor.
            l, c= self.gerarLinhaColunaPeca (linhas, colunas, matrizValores)
            matrizValores.setItem (l, c, qtdPecas)

            # calcula para seu par
            l, c= self.gerarLinhaColunaPeca (linhas, colunas, matrizValores)
            matrizValores.setItem (l, c, qtdPecas)

            qtdPecas-= 1

        return matrizValores

    def alterarPlacar (self, valor, total):
        self.placar.text= str(valor) + " acertos de " + str(total)

# Fim