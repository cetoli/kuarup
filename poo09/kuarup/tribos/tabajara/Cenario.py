from MovimentoThread import MovimentoThread
from Parede3D import Parede3D
from Peixe3D import Peixe3D
from Tabuleiro import Tabuleiro
from TecladoThread import TecladoThread
from visual import *

class Cenario():

    def __init__(self):
        self.scene2 = display(title="Labirinto",
            #width=150, height=150,
            center= (0,0,0),
            x=0, y=0)
        self.scene2.x, self.scene2.y =0,0
        self.scene2.select()
        self.scene2.autoscale = 1

        self.scene2.autocenter = 1
        self.scene2.forward = (8,-5,-3)

        self.tabuleiro = Tabuleiro()

        self.inicializarJogador()
        self.inicializarParedes()

        self.movimentoThread = MovimentoThread(self)
        self.movimentoThread.start()

        self.tecladoThread = TecladoThread(self)
        self.tecladoThread.start()


    def proximoFrame(self):
        self.jogador3D.proximoFrame()

    def inicializarJogador(self):
        self.jogador3D =  Peixe3D(self.tabuleiro.jogador.x, self.tabuleiro.jogador.y)

    def inicializarParedes(self):
        self.paredes3D = []
        for parede in self.tabuleiro.paredes :
            parede3D = Parede3D(parede.x, parede.y)
            self.paredes3D.append(parede3D)
            #coadjuvantes no lugar de paredes
            if parede.x == 30 and parede.y == 37 or parede.x == 34 and parede.y == 30 :
                parede3D.esqueleto.visible = 0

    def moverCima(self):

        resultado = self.tabuleiro.moverCima()

        if resultado == 0 :
            return 0

        self.jogador3D.novoDestinoCima()

    def moverBaixo(self):

        resultado = self.tabuleiro.moverBaixo()

        if resultado == 0 :
            return 0

        self.jogador3D.novoDestinoBaixo()

    def moverEsquerda(self):

        resultado = self.tabuleiro.moverEsquerda()

        if resultado == 0 :
            return 0

        self.jogador3D.novoDestinoEsquerda()

    def moverDireita(self):

        resultado = self.tabuleiro.moverDireita()

        if resultado == 0 :
            return 0

        self.jogador3D.novoDestinoDireita()


if __name__ == "__main__" :

    c = Cenario()
    
