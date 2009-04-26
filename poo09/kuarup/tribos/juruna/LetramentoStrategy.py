from Strategy import *
from TabuleiroLetramento import *

class LetramentoStrategy (Strategy):

    def __init__ (self):
        self.tabuleiro= TabuleiroLetramento ()
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


    def movimentoPeca (self, linhaAntiga, colunaAntiga, linhaNova, colunaNova):
        peca= self.tabuleiro.getPeca (linhaAntiga, colunaAntiga)
        pecaPosFutura= self.tabuleiro.getPeca (linhaNova, colunaNova)

        if (pecaPosFutura != None):
            if pecaPosFutura.getEPecaResultado () == False:
                return

        self.tabuleiro.setPeca (linhaAntiga, colunaAntiga, None)
        self.tabuleiro.setPeca (linhaNova, colunaNova, peca)
        pontoNovo= self.tabuleiro.calcularPontoMeioPeca (linhaNova, colunaNova)
        peca.andar (pontoNovo)


    def verificarFinalizouJogo (self):
        qtdLinhas, qtdColunas= self.tabuleiro.calcularLinhasColunas ()

        i= qtdLinhas-1
        tam= len (self.tabuleiro.resultado)
        j= (qtdColunas - tam) /2

        pos= 0
        fim= tam + j
        while j < fim:
            peca= self.tabuleiro.getPeca (i, j)
            if peca == None:
                return False

            if peca.getEPecaResultado () == True:
                return False

            if peca.getTexto () != self.tabuleiro.resultado[pos]:
                return False

            pos+= 1
            j+= 1


        self.exibirMsg ("Parabens! acertou a palavra.", -1)
        return True


# Fim