from PersonagemJogador import PersonagemJogador
from Caixa import Caixa

class Tabuleiro():

    def __init__(self):
        self.initFase()

    def initFase(self):

        # inicializa os jogadores
        self.jogadores = []
        self.jogadores.append(PersonagemJogador(6, 8, 0, self))
        self.jogadores.append(PersonagemJogador(5, 8, 1, self))

        # inicializa as Caixas
        self.caixas = []
        self.caixas.append(Caixa(2,2, self.jogadores[0], self))
        self.caixas.append(Caixa(3,3, self.jogadores[0], self))
        self.caixas.append(Caixa(5,4, self.jogadores[0], self))
        self.caixas.append(Caixa(4,4, self.jogadores[0], self))
        self.caixas.append(Caixa(6,5, self.jogadores[0], self))
        self.caixas.append(Caixa(1,4, self.jogadores[1], self))
        self.caixas.append(Caixa(3,5, self.jogadores[1], self))
        self.caixas.append(Caixa(1,7, self.jogadores[1], self))
        self.caixas.append(Caixa(3,7, self.jogadores[1], self))
        self.caixas.append(Caixa(5,2, self.jogadores[1], self))

        for i in range(7) :
            for j in range(9) :
                caixa = Caixa(i,j, self.jogadores[0], self)
                caixa.setDerrubada(1)
                self.caixas.append(caixa)

        for i in range(15, 18) :
            for j in range(3, 6) :
                caixa = Caixa(i,j, self.jogadores[0], self)
                caixa.setDerrubada(1)
                self.caixas.append(caixa)


    def possuiCaixa(self, x, y):
        for caixa in self.caixas:
            if(caixa.getX() == x and caixa.getY() == y and caixa.getDerrubada() == 0):
                return caixa
        return 0

    def possuiChao(self, x, y):
        for caixa in self.caixas:
            if(caixa.getX() == x and caixa.getY() == y and caixa.getDerrubada() != 0):
                return caixa
        return 0

    def possuiJogador(self, x, y):
        for jogador in self.jogadores:
            if(jogador.getX() == x and jogador.getY() == y):
                return jogador
        return 0

    def moverJogador(self, jogador, x, y):
        if self.possuiChao(x, y) == 0 :
            return 0

        if self.possuiJogador(x, y) != 0 :
            return 0

        caixa = self.possuiCaixa(x, y)
        if caixa == 0 :
            return 1

        if caixa.getJogador() != jogador :
            return 0

        xAtual = jogador.getX()
        yAtual = jogador.getY()

        # se movendo pra esquerda
        if xAtual - x > 0 :
            return self.moverCaixa(caixa, x - 1, y)
        # se movendo pra direita
        if xAtual - x < 0 :
            return self.moverCaixa(caixa, x + 1, y)
        # se movendo pra cima
        if yAtual - y > 0 :
            return self.moverCaixa(caixa, x, y - 1)
        # se movendo pra baixo
        if yAtual - y < 0 :
            return self.moverCaixa(caixa, x, y + 1)

    def moverCaixa(self, caixa, x, y):
        if self.possuiCaixa(x, y) != 0 or self.possuiJogador(x, y) != 0 :
            return 0
        else:
            if self.possuiChao(x, y) == 0 :
                caixa.setDerrubada(1)
            caixa.setPos(x, y)
            return 1

    def getCaixas(self):
        return self.caixas

    def getJogadores(self):
        return self.jogadores