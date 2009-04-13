from Observable import Observable

class Caixa(Observable):

    def __init__(self, x, y, jogador, tabuleiro):
        Observable.__init__(self)
        self.posX = x
        self.posY = y
        self.tabuleiro = tabuleiro
        self.derrubada = 0
        self.jogador = jogador

    def getX(self):
        return self.posX

    def getY(self):
        return self.posY

    def setPos(self, x, y):
        self.posX = x
        self.posY = y
        self.notify()

    def getDerrubada(self):
        return self.derrubada

    def setDerrubada(self, boolean):
        self.derrubada = boolean

    def getJogador(self):
        return self.jogador

    # Override de Observable
    def getState(self):
        return [self.getX(), self.getY(), self.getDerrubada()]
