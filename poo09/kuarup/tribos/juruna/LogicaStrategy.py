from Strategy import *
from TabuleiroLogica import *

class LogicaStrategy (Strategy):

    def __init__ (self):
        self.tabuleiro= TabuleiroLogica ()
        self.tabuleiro.criarPecas ()

        #self.rodada= False


    def jogar(self):
        return True

    def selecionar (self, posicaoPeixe):
        peca= self.tabuleiro.buscarPecaNaPosicao (posicaoPeixe)
        if peca == None:
            return

        if peca.getTexto () == "":
            return

        self.tabuleiro.removerPecaSelecionada (peca)

        pecaAnt= self.obterPecaSelecaoAnterior ()
        if pecaAnt != None:
            if peca != pecaAnt:
                self.tabuleiro.removerPecaSelecionada (pecaAnt)
                # Volta para "Ativa".
                pecaAnt.mudarEstado (False, False, False, False)

        self.tabuleiro.adicionarPecaSelecionada (peca)
        # Vai para "Selecionada".
        peca.mudarEstado (False, True, False, False)


    def verificarPosicaoEPecaResultado (self, linha, coluna):
        qtdLinhas, qtdColunas= self.tabuleiro.calcularLinhasColunas ()

        i= qtdLinhas-self.tabuleiro.linhasResultado

        if linha < i:
            return False

        j= (qtdColunas/2) - (self.tabuleiro.colunasResultado/2)
        jFim= j + self.tabuleiro.colunasResultado

        if coluna < j:
            return False

        if coluna >= jFim:
            return False

        return True


    def movimentoPeca (self, linhaAntiga, colunaAntiga, linhaNova, colunaNova):
        peca= self.tabuleiro.getPeca (linhaAntiga, colunaAntiga)
        pecaPosFutura= self.tabuleiro.getPeca (linhaNova, colunaNova)

        if (pecaPosFutura != None):
            if pecaPosFutura.getEPecaResultado () == False:
                return
            else:
                pecaPosFutura.sumir ()

        self.tabuleiro.setPeca (linhaAntiga, colunaAntiga, None)
        self.tabuleiro.setPeca (linhaNova, colunaNova, peca)
        pontoNovo= self.tabuleiro.calcularPontoMeioPeca (linhaNova, colunaNova)
        peca.andar (pontoNovo)


        # se o local de origem e um ponto de solucao, crio a PecaResultado para ele
        if self.verificarPosicaoEPecaResultado (linhaAntiga, colunaAntiga) == True:
            ponto= self.tabuleiro.calcularPontoMeioPeca (linhaAntiga, colunaAntiga)
            pecaRes= PecaResultado (ponto, "", peca.observador)
            self.tabuleiro.setPeca (linhaAntiga, colunaAntiga, pecaRes)


    def verificarFinalizouJogo (self):
        qtdLinhas, qtdColunas= self.tabuleiro.calcularLinhasColunas ()

        i= qtdLinhas-self.tabuleiro.linhasResultado

        # testa a soma das linhas.
        while i < qtdLinhas:
            j= (qtdColunas/2) - (self.tabuleiro.colunasResultado/2)
            fim= j + self.tabuleiro.colunasResultado
            somaLinha= 0

            while j < fim:
                peca= self.tabuleiro.getPeca (i, j)
                if peca == None:
                    return False

                if peca.getEPecaResultado () == True:
                    return False

                somaLinha+= int (peca.getTexto ())

                j+= 1

            if somaLinha != 15:
                return False

            i+= 1


        # Testa a soma das colunas.
        j= (qtdColunas/2) - (self.tabuleiro.colunasResultado/2)
        fim= j + self.tabuleiro.colunasResultado
        while j < fim:
            i= qtdLinhas-self.tabuleiro.linhasResultado
            somaColuna= 0

            while i < qtdLinhas:
                peca= self.tabuleiro.getPeca (i, j)
                if peca == None:
                    return False

                if peca.getEPecaResultado () == True:
                    return False

                somaColuna+= int (peca.getTexto ())

                i+= 1

            if somaColuna != 15:
                return False

            j+= 1


        self.exibirMsg ("Parabens, voce acertou!", -1)
        return True


# Fim