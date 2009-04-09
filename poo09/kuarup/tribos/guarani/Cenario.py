from Caixa3D import Caixa3D
from TecladoThread import TecladoThread
from MovimentoThread import MovimentoThread
from Peixe import Peixe
from visual import *
from Tabuleiro import Tabuleiro

class Cenario():

    def __init__(self):
        self.scene2 = display(title = "Tribo Guarani", width=400, height=400, center= (0,0,0), x=0, y=0)
        self.scene2.x, self.scene2.y = 0, 0
        self.scene2.select()
        self.scene2.autoscale = 1
        self.scene2.autocenter = 1
        self.scene2.forward = (0,1,-1)
        #scene2.range = (6,6,6)

        self.tabuleiro = Tabuleiro()
        self.inicializarCaixas()
        self.inicializarJogadores()

        self.movimentoThread = MovimentoThread(self)
        self.movimentoThread.start()

        tecladoThread = TecladoThread(self.scene2.kb, self.jogadores, self.jogadores3D)
        tecladoThread.start()

    def inicializarCaixas(self):
        caixas = self.tabuleiro.getCaixas()

        # lista com todos as instancias de Parede3D
        self.caixas3D = []

        # map que relaciona uma Caixa (do model) com uma Caixa3D
        self.caixasMap = {}

        count = 0
        for caixa in caixas :
            caixa3D = Caixa3D(caixa.getX(), caixa.getY())
            jogador = caixa.getJogador()
            caixa3D.setColor(jogador.getNumero())
            if caixa.getDerrubada() != 0 :
                caixa3D.setDerrubada()
            caixa.addObserver(caixa3D)
            self.caixas3D.append(caixa3D)
            self.caixasMap[caixas[count]] = self.caixas3D[count]
            count += 1

    def inicializarJogadores(self):
        self.jogadores = self.tabuleiro.getJogadores()
        self.jogadores3D = []

        peixe3D = Peixe(self.jogadores[0].getX(), self.jogadores[0].getY())
        self.jogadores3D.append(peixe3D)
        self.jogadores[0].addObserver(self.jogadores3D[0])

        #TODO mudar pro peixe Karaja
        peixe3D = Peixe(self.jogadores[1].getX(), self.jogadores[1].getY())
        self.jogadores3D.append(peixe3D)
        self.jogadores[1].addObserver(self.jogadores3D[1])

    # metodo chamado a cada frame (60 vezes por segundo, por exemplo)
    def proximoFrame(self):
        # cada elemento do cenario eh responsavel por desenhar seu proximo frame
        for jogador3D in self.jogadores3D :
            jogador3D.proximoFrame()
        for caixa3D in self.caixas3D :
            caixa3D.proximoFrame()


if __name__ == "__main__":
    cenario = Cenario()