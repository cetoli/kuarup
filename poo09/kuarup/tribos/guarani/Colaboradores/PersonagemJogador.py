from Observable import Observable

class PersonagemJogador(Observable):

    def __init__(self, x, y, numero, tabuleiro):
        Observable.__init__(self)
        self.posX = x
        self.posY = y
        self.tabuleiro = tabuleiro
        self.numero = numero

    def moverEsquerda(self):
        result = self.tabuleiro.moverJogador(self, self.getX() - 1, self.getY())
        if result != 0 :
            self.posX -= 1
            self.notify()
            return 1
        return 0

    def moverCima(self):
        result = self.tabuleiro.moverJogador(self, self.getX(), self.getY() - 1)
        if result != 0 :
            self.posY -= 1
            self.notify()
            return 1
        return 0

    def moverDireita(self):
        result = self.tabuleiro.moverJogador(self, self.getX() + 1, self.getY())
        if result != 0 :
            self.posX += 1
            self.notify()
            return 1
        return 0

    def moverBaixo(self):
        result = self.tabuleiro.moverJogador(self, self.getX(), self.getY() + 1)
        if result != 0 :
            self.posY += 1
            self.notify()
            return 1
        return 0

    def getX(self):
        return self.posX

    def getY(self):
        return self.posY

    def getNumero(self):
        return self.numero

    # Override de Observable
    def getState(self):
        return [self.getX(), self.getY()]



