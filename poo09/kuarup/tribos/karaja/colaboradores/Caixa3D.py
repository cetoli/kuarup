from Observer import Observer
from visual import *

class Caixa3D(Observer):

    def __init__(self, x, y):

        self.esqueleto = frame()
        size = 0.9
        self.box = box(frame = self.esqueleto, pos = (x,-y,0), length = size, height = size, width = size)
        self.setColorAzul()
        # -1 - nao foi movido, 0 = esq , 1 = cima, 2 = direita, 3 = baixo
        self.foiMovida = -1
        self.velocidade = 0.05
        self.posDestino = self.box.pos # evitar null pointer
        self.derrubada = 0

    def setColor(self, numero):
        if numero == 0 :
            self.setColorAzul()
        else :
            self.setColorCinza()

    def setColorCinza(self):
        self.box.color = (0.6, 0.6, 0.6)

    def setColorAzul(self):
        self.box.color = (0, 0, 1)

    def setColorDerrubada(self):
        self.box.color = (0, 1, 1)

    def novoDestinoEsquerda(self):
        self.posDestino = self.box.pos - (1, 0, 0)
        self.setFoiMovida(0)

    def novoDestinoCima(self):
        self.posDestino = self.box.pos + (0, 1, 0)
        self.setFoiMovida(1)

    def novoDestinoDireita(self):
        self.posDestino = self.box.pos + (1, 0, 0)
        self.setFoiMovida(2)

    def novoDestinoBaixo(self):
        self.posDestino = self.box.pos - (0, 1, 0)
        self.setFoiMovida(3)

    def getFoiMovida(self):
        return self.foiMovida

    def setFoiMovida(self, direcao):
        self.foiMovida = direcao

    def proximoFrame(self):
        posAtual = array(self.box.pos)
        posDestino = array(self.posDestino)
        if self.foiMovida == 0 :
            self.box.pos += (-self.velocidade, 0, 0)
            if posAtual[0] - self.velocidade < posDestino[0] :
                self.box.pos += (posDestino[0] - (posAtual[0] - self.velocidade), 0, 0)
                if self.derrubada != 0 :
                    self.setFoiMovida(4)
                else :
                    self.setFoiMovida(-1)
        elif self.foiMovida == 1 :
            self.box.pos += (0, self.velocidade, 0)
            if posAtual[1] + self.velocidade > posDestino[1] :
                self.box.pos += (0, posDestino[1] - (posAtual[1] + self.velocidade), 0)
                if self.derrubada != 0 :
                    self.setFoiMovida(4)
                else :
                    self.setFoiMovida(-1)
        elif self.foiMovida == 2 :
            self.box.pos += (self.velocidade, 0, 0)
            if posAtual[0] + self.velocidade > posDestino[0] :
                self.box.pos += (posDestino[0] - (posAtual[0] + self.velocidade), 0, 0)
                if self.derrubada != 0 :
                    self.setFoiMovida(4)
                else :
                    self.setFoiMovida(-1)
        elif self.foiMovida == 3 :
            self.box.pos += (0, -self.velocidade, 0)
            if posAtual[1] - self.velocidade < posDestino[1] :
                self.box.pos += (0, posDestino[1] - (posAtual[1] - self.velocidade), 0)
                if self.derrubada != 0 :
                    self.setFoiMovida(4)
                else :
                    self.setFoiMovida(-1)
        elif self.foiMovida == 4 :
            self.box.pos += (0, 0, -self.velocidade)
            if posAtual[2] - self.velocidade < -1 :
                self.box.pos += (0, 0, -1 - (posAtual[2] - self.velocidade))
                self.setFoiMovida(-1)
                self.setColorDerrubada()

    def setDerrubada(self):
        pos = array(self.box.pos)
        self.box.pos = (pos[0], pos[1], -1)
        self.setColorDerrubada()

    # Override de Observer
    def update(self, observable):
        data = observable.getState()

        self.derrubada = data[2]

        destinoX = data[0]
        destinoY = data[1]
        posAtual = array(self.box.pos)

        posAtual[1] = -posAtual[1]

        # usei -0.5 posi estava tendo um bug onde
        # destinoX < posAtual[0]
        # dizia que  1.0 < 1.0 era verdadeiro
        # dai fazendo destinoX - posAtual[0] obtive 2.22044604925e-016

        # se foi movido pra esquerda
        if destinoX - posAtual[0] < -0.5:
            self.novoDestinoEsquerda()

        # se foi movido pra direita
        elif destinoX - posAtual[0] > 0.5 :
            self.novoDestinoDireita()

        # se foi movido pra cima
        elif destinoY - posAtual[1] < -0.5 :
            self.novoDestinoCima()

        # se foi movido pra baixo
        elif destinoY - posAtual[1] > 0.5 :
            self.novoDestinoBaixo()

