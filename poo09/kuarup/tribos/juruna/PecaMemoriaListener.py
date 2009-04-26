from PecaListener import *

class PecaMemoriaListener (PecaListener):
    """
    def exibirTexto (self, peca):
        peca.exibirTexto ()

    def sumirTexto (self, peca):
        peca.sumirTexto ()
    """

    def verificarFoiResolvida (self, tabuleiro, peca):
        peca0= tabuleiro.getPecaSelecionada (0)
        # So uma peca selecionada.
        if peca0 == None:
            peca.mostrarTexto ()
            peca.setEstado (estadoNovo)
        else:
            if peca.getTexto () == peca0.getTexto ():
                peca.mostrarTexto ()

            else:
                # Exibe para que o jogador veja o valor da ultima selecao.
                peca.mostrarTexto ()
                rate (1)
                peca.sumirTexto ()
                peca0.sumirTexto ()
                self.removerPecasResolvidasTabuleiro (tabuleiro, peca)
                peca.setEstado (estadoNovo)

    """
    def removerPecasResolvidasTabuleiro (self, tabuleiro, peca):
        pecaAnt= tabuleiro.getPecaSelecionada (0)
        if pecaAnt != None:
            tabuleiro.removerPecaSelecionada (pecaAnt)

        tabuleiro.removerPecaSelecionada (peca)
    """

    def removerPecaResolvidaTabuleiro (self, tabuleiro, peca):
        tabuleiro.removerPecaSelecionada (peca)

    def tratarResolvidas (self, tabuleiro, peca):
        peca.mostrarTexto ()
        self.removerPecaResolvidaTabuleiro (tabuleiro, peca)


    def receberInformacaoMudancaEstado (self, tabuleiro, peca, estadoAntigo, estadoNovo):

        print "\n---------------- INICIO ---------------------\n"

        print "antigo %s  novo %s\n" % (estadoAntigo.tipo, estadoNovo.tipo)

        """
            Peca foi resolvida.
            Remove-la da lista de selecionadas e, por precaucao, mostrar texto.
        """
        if (estadoNovo.getResolvida () == True):
            if (estadoAntigo.getResolvida () == False):
                self.tratarResolvidas (tabuleiro, peca)

        elif (estadoNovo.getSelecionada () == True): # peca foi resolvida agora.
            if (estadoAntigo.getSelecionada () == False):
                peca.mostrarTexto ()
                """
                ret= self.verificarFoiResolvida (tabuleiro, peca)
                if ret == None:
                    pass
                else:
                    # As pecas foram resolvidas.
                    estadoNovo= ...
                    peca.setEstado (estadoNovo)
                    ret.setEstado (estadoNovo)
                """

        elif (estadoNovo.getSelecionada () == False): # tirou a selecionou da peca.
            if estadoAntigo.getSelecionada () == True:
                peca.sumirTexto ()
                tabuleiro.removerPecaSelecionada (peca)


        """
        elif (estadoNovo.getResolvida () == False):
            peca.setEstado (estadoNovo)
        """


        print "\n----------------- FIM --------------------\n"

# Fim