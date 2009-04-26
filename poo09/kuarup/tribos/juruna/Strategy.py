from AcaraDisco import *
from visual import *

class Strategy:
    def __init__ (self):
        pass

    def jogar (self):
        pass

    def selecionar (self, posPeixe):
        pass

    def verificarFinalizouJogo (self):
        return False

    def getNomeJogo (self):
        return self.nome

    def criarPeixe (self):
        qtdLinhas, qtdColunas= self.tabuleiro.calcularLinhasColunas ()
        qtdLinhas/= 2
        qtdColunas/= 2
        ponto= self.tabuleiro.calcularPontoMeioPeca (qtdLinhas, qtdColunas)

        #ponto= self.tabuleiro.getPontoMeio ()
        peixe= PeixeAcaraDisco (escala= 0.08, axis= (1,0,0), pos= (ponto.getX (), ponto.getY (), ponto.getZ ()+0.3))
        peixe.desenhar ()

        # velocidade basica com incremento= 1.
        atual= peixe.getVelocidade ()
        desejada= self.tabuleiro.getDistanciaEntreCentrosPecas ()
        # na verdade "seto" o incremento da velocidade.
        peixe.setVelocidade (desejada/atual)

        return peixe

    def getPosicaoTabuleiro (self):
        return self.tabuleiro.getPosicao ()

    # espera em segundos
    def exibirMsg (self, msg, espera= 2):
        msg= label (pos= (0, 0, 0), text= msg, xoffset=0, yoffset= 0, space= 1, height=15, color= color.white, font='sans')

        if espera == 0:
            espera= 2

        tempo= float (1.0/espera)

        if tempo == 0:
            tempo= 0.5

        # ou seja, mensagem por tempo infinito.
        if espera < 0:
            return

        time.sleep (espera)

        msg.visible= 0
        msg= None

    def obterPecaSelecaoAnterior (self):
        return self.tabuleiro.getPecaSelecionada (0)


    """
        Algoritmo:
        peca que o peixe esta em cima esta selecionada?
        > Nao: SAI

        tem espaco vazio ou peca do tipo Resultado no local onde o peixe quer ir?
        > Nao: SAI

        move peixe e peca
        verifica concluiu peca
        > Se concluiu peca: concluiu o jogo?

    """
    def movimentoCima (self, peixe, tela):
        peca= self.tabuleiro.buscarPecaNaPosicao (peixe.getPontoEsqueleto ())

        qtdLinhas, qtdColunas= self.tabuleiro.calcularLinhasColunas ()

        pos= peixe.getPosicao ()
        pos.setVetorSentido (0,1,0)
        incremento= peixe.getIncrementoNado ()

        # Com peca eu pego a linha e colunas, mas sem peca nao posso pegar a linha nem a coluna dela.
        if peca != None:
            linha, coluna= self.tabuleiro.buscarLinhaColunaPeca (peca)
            linha-= 1
            if linha < 0:
                return

        else:
            posC= pos.getPontoCima ()
            posB= pos.getPontoBaixo ()
            if pos.permitidoPeixeMover (peixe, incremento, tela) == False:
                return

        peixe.nadar (incremento)

        if peca == None:
            return

        if peca.getSelecionada () == False:
            return

        pecaPosNova= self.tabuleiro.getPeca (linha, coluna)
        if (pecaPosNova == None):
            self.movimentoPeca (linha+1, coluna, linha, coluna)
        elif (pecaPosNova.getEPecaResultado () == True): # idem a linha acima, mas evita problema com o objeto nulo.
            self.movimentoPeca (linha+1, coluna, linha, coluna)
            self.verificarFinalizouJogo ()

            """
            pos= peixe.getPosicao ()
            pos.setVetorSentido (0,1,0)
            incremento= peixe.getIncrementoNado ()

            posC= pos.getPontoCima ()
            posB= pos.getPontoBaixo ()

            if pos.permitidoPeixeMover (peixe, incremento, tela) != 0:
                posicao= peixe.getPosicao ()
                peixe.nadar (incremento)
            """


    def movimentoBaixo (self, peixe, tela):
        peca= self.tabuleiro.buscarPecaNaPosicao (peixe.getPontoEsqueleto ())

        qtdLinhas, qtdColunas= self.tabuleiro.calcularLinhasColunas ()

        pos= peixe.getPosicao ()
        pos.setVetorSentido (0,-1,0)
        incremento= peixe.getIncrementoNado ()

        # Com peca eu pego a linha e colunas, mas sem peca nao posso pegar a linha nem a coluna dela.
        if peca != None:
            linha, coluna= self.tabuleiro.buscarLinhaColunaPeca (peca)
            linha+= 1
            if linha >= qtdLinhas:
                return

        else:
            posC= pos.getPontoCima ()
            posB= pos.getPontoBaixo ()
            if pos.permitidoPeixeMover (peixe, incremento, tela) == False:
                return

        peixe.nadar (incremento)

        if peca == None:
            return

        if peca.getSelecionada () == False:
            return

        pecaPosNova= self.tabuleiro.getPeca (linha, coluna)
        if (pecaPosNova == None):
            self.movimentoPeca (linha-1, coluna, linha, coluna)
        elif (pecaPosNova.getEPecaResultado () == True): # idem a linha acima, mas evita problema com o objeto nulo.
            self.movimentoPeca (linha-1, coluna, linha, coluna)
            self.verificarFinalizouJogo ()


    def movimentoEsquerda (self, peixe, tela):
        peca= self.tabuleiro.buscarPecaNaPosicao (peixe.getPontoEsqueleto ())

        qtdLinhas, qtdColunas= self.tabuleiro.calcularLinhasColunas ()

        pos= peixe.getPosicao ()
        pos.setVetorSentido (-1,0,0)
        incremento= peixe.getIncrementoNado ()

        # Com peca eu pego a linha e colunas, mas sem peca nao posso pegar a linha nem a coluna dela.
        if peca != None:
            linha, coluna= self.tabuleiro.buscarLinhaColunaPeca (peca)
            coluna-= 1
            if coluna < 0:
                return

        else:
            posC= pos.getPontoCima ()
            posB= pos.getPontoBaixo ()
            if pos.permitidoPeixeMover (peixe, incremento, tela) == False:
                return

        peixe.nadar (incremento)

        if peca == None:
            return

        if peca.getSelecionada () == False:
            return

        pecaPosNova= self.tabuleiro.getPeca (linha, coluna)
        if (pecaPosNova == None):
            self.movimentoPeca (linha, coluna+1, linha, coluna)
        elif (pecaPosNova.getEPecaResultado () == True): # idem a linha acima, mas evita problema com o objeto nulo.
            self.movimentoPeca (linha, coluna+1, linha, coluna)
            self.verificarFinalizouJogo ()


    def movimentoDireita (self, peixe, tela):
        peca= self.tabuleiro.buscarPecaNaPosicao (peixe.getPontoEsqueleto ())

        qtdLinhas, qtdColunas= self.tabuleiro.calcularLinhasColunas ()

        pos= peixe.getPosicao ()
        pos.setVetorSentido (1,0,0)
        incremento= peixe.getIncrementoNado ()

        # Com peca eu pego a linha e colunas, mas sem peca nao posso pegar a linha nem a coluna dela.
        if peca != None:
            linha, coluna= self.tabuleiro.buscarLinhaColunaPeca (peca)
            coluna+= 1
            if coluna >= qtdColunas:
                return

        else:
            posC= pos.getPontoCima ()
            posB= pos.getPontoBaixo ()
            if pos.permitidoPeixeMover (peixe, incremento, tela) == False:
                return

        peixe.nadar (incremento)

        if peca == None:
            return

        if peca.getSelecionada () == False:
            return

        pecaPosNova= self.tabuleiro.getPeca (linha, coluna)
        if (pecaPosNova == None):
            self.movimentoPeca (linha, coluna-1, linha, coluna)
        elif (pecaPosNova.getEPecaResultado () == True): # idem a linha acima, mas evita problema com o objeto nulo.
            self.movimentoPeca (linha, coluna-1, linha, coluna)
            self.verificarFinalizouJogo ()


    def movimentoPeca (linhaAntiga, colunaAntiga, linhaNova, colunaNova):
        pass
# Fim