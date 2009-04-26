from Strategy import *
from TabuleiroMemoria import *

class MemoriaStrategy (Strategy):
    qtdPecasDiferentes= 10
    tempoMostraPeca= 1

    def __init__ (self):
        self.nome= "Jogo da Memoria"
        self.tabuleiro= TabuleiroMemoria ()
        self.tabuleiro.criarPecas (self.qtdPecasDiferentes)

        # calcula de acordo com a quantidade de pecas a serem memorizadas.
        taxa= (0.1 * self.qtdPecasDiferentes) + 0.5
        taxa= 1.0/taxa
        rate (taxa)
        self.tabuleiro.sumirTextoPecas ()
        self.qtdPecasResolvidas= 0
        self.tabuleiro.alterarPlacar (self.qtdPecasResolvidas, self.qtdPecasDiferentes)


    def jogar(self):
        return True


    def selecionar (self, posicaoPeixe):
        peca= self.tabuleiro.buscarPecaNaPosicao (posicaoPeixe)
        if peca.getTexto () == "":
            return

        pecaAnt= self.obterPecaSelecaoAnterior ()
        if peca != None:
            if pecaAnt != None:
                temSelecaoAnt= True
            else:
                temSelecaoAnt= False
                self.tabuleiro.adicionarPecaSelecionada (peca)

            resolvida= self.verificarResolvido (pecaAnt, peca)

            peca.mudarEstado (False, True, resolvida, temSelecaoAnt)
            # Resolveu a peca.
            if peca.getResolvida () == True:
                pecaAnt.mudarEstado (False, True, resolvida, temSelecaoAnt)
                self.tabuleiro.removerPecaSelecionada (pecaAnt)
                self.qtdPecasResolvidas+= 1
                self.tabuleiro.alterarPlacar (self.qtdPecasResolvidas, self.qtdPecasDiferentes)

                if self.qtdPecasResolvidas == self.qtdPecasDiferentes:
                    self.exibirMsg ("Parabens acertou todos os pares!", -1)
                else:
                    self.exibirMsg ("Acertou o par!", 1)
            else:
                if pecaAnt != None:
                    # Exibe para que o jogador veja o valor da ultima selecao.
                    peca.mostrarTexto ()
                    time.sleep(1)
                    peca.sumirTexto ()
                    pecaAnt.mudarEstado (False, True, resolvida, temSelecaoAnt)
                    self.tabuleiro.removerPecaSelecionada (pecaAnt)
                    self.exibirMsg ("Par errado.", 1)




    """
    def selecionar (self, posicaoPeixe):
        #pontoCentralPeixe= posicaoPeixe.calcularPontoMeio ()
        peca= self.tabuleiro.buscarPecaNaPosicao (posicaoPeixe)
        if peca != None:
            peca.selecionarPeca ()

        " "" Passou a ser feito pelo listener
            if peca.getSelecionada () == True:
                if self.verificarResolvido (peca) != True:
                    self.tabuleiro.adicionarPecaSelecionada (peca)
            else:
                self.tabuleiro.removerPecaSelecionada (peca)
        """

#        else:
#            print "MS: peca nao achada"

    def verificarResolvido (self, peca, pecaNova):
        if pecaNova == None:
            return False

        if peca == None:
            return False

        if peca.getTexto () == pecaNova.getTexto ():
            #peca.alterarEstado (False, False, True)
            return True


        return False

# Fim