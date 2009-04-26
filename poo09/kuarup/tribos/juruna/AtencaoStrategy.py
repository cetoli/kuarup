from Strategy import *
from TabuleiroAtencao import *

class AtencaoStrategy (Strategy):
    qtdPecasDiferentes= 62

    def __init__ (self):
        self.tabuleiro= TabuleiroAtencao ()
        #self.tabuleiro.testarPecas ()
        self.tabuleiro.criarPecas (self.qtdPecasDiferentes)

        # calcula de acordo com a quantidade de pecas a serem memorizadas.
        taxa= (0.1 * self.qtdPecasDiferentes) + 0.8
        taxa= 1/taxa
        rate (taxa)
        self.rodada= False

        self.acertos= 0
        self.erros= 0
        self.tabuleiro.alterarPlacar (self.acertos, self.erros)

    def jogar(self):
        # Bloqueia uma nova rodada ate que a anterior tenha sido resolvida.
        if self.rodada == True:
            return True
            while 1:
                rate (0.5)
                if self.rodada == False:
                    break


        self.rodada= True
        iLetra, jLetra= self.tabuleiro.buscarPosicaoPreenchida ()
        iVazio, jVazio= self.tabuleiro.buscarPosicaoVazia ()

        pecaLetra= self.tabuleiro.getPeca (iLetra, jLetra)
        pecaVazia= self.tabuleiro.getPeca (iVazio, jVazio)

        print "Vazia %d %d\n letra %d %d\n" % (iVazio, jVazio, iLetra, jLetra)

        # conta 3 segundos para mudar o valor.
        msg= label (pos= (0, 0, 0), text= "3", xoffset=0, yoffset= 0, space= 1, height=15, color= color.white, font='sans')
        rate (1)
        msg.text= "2"
        rate (1)
        msg.text= "1"
        rate (1)
        msg.visible= false
        msg= None


        pecaVazia.setTexto (pecaLetra.getTexto ())
        pecaLetra.setTexto ("")
        self.tabuleiro.adicionarPecaSelecionada (pecaVazia)

        return True

    def selecionar (self, posicaoPeixe):
        peca= self.tabuleiro.buscarPecaNaPosicao (posicaoPeixe)
        if peca.getTexto () == "":
            return

        pecaAnt= self.obterPecaSelecaoAnterior ()
        if peca != None:
            if peca == pecaAnt:
                self.exibirMsg ('Voce acertou a peca que mudou', 3)
                self.tabuleiro.removerPecaSelecionada (peca)
                self.acertos+= 1
            else:
                self.exibirMsg ('Voce errou a peca que mudou', 3)
                self.erros+= 1

            self.rodada= False
            self.tabuleiro.alterarPlacar (self.acertos, self.erros)



# Fim