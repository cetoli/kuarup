from tribo_xerente import Caranguejo
from Parede import Parede
from tribo_guarani import Pinguim
from Peixe import Peixe

class Tabuleiro():

    def __init__(self):

        self.tamX = 5
        self.tamY = 7
        self.inicializarJogador()
        self.inicializarParedes()

    def inicializarJogador(self):

        self.jogador = Peixe(30,30)

    def inicializarParedes(self):
        self.paredes = []
        
        self.paredes.append(Parede(28,28))
        self.paredes.append(Parede(29,28))
        self.paredes.append(Parede(31,28))
        self.paredes.append(Parede(32,28))
        self.paredes.append(Parede(32,29))
        self.paredes.append(Parede(32,30))
        self.paredes.append(Parede(32,31))
        self.paredes.append(Parede(31,31))
        self.paredes.append(Parede(30,31))
        self.paredes.append(Parede(29,31))
        self.paredes.append(Parede(28,31))
        self.paredes.append(Parede(28,30))
        self.paredes.append(Parede(28,29))

        for i in range(26, 34) :
            self.paredes.append(Parede(i,26))
            if i != 30 :
                self.paredes.append(Parede(i,33))
                self.paredes.append(Parede(26,i))
            self.paredes.append(Parede(34,i))

        for i in range(24, 36) :
            self.paredes.append(Parede(i,24))
            self.paredes.append(Parede(i,35))
            self.paredes.append(Parede(24,i))
            if i != 30 :
                self.paredes.append(Parede(36,i))

        for i in range(22, 38) :
            self.paredes.append(Parede(i,22))
            self.paredes.append(Parede(i,37))
            if i != 30 :
                self.paredes.append(Parede(22,i))
            self.paredes.append(Parede(38,i))

        caranguejo = Caranguejo(escala =0.037,pos= (33.7, -30, 0))
        caranguejo.esqueleto.rotate(angle = 3.1412/2, axis = (1,0,0))
        caranguejo.esqueleto.rotate(angle = 3.1412/3, axis = (0,0,1))

        pinguim = Pinguim(escala = 0.2  , pos= (30,-37,0))
        pinguim.esqueleto.rotate(angle = 3.1412/2, axis = (1,0,0))
        pinguim.esqueleto.rotate(angle = 3.1412/3, axis = (0,0,1))

    def possuiParede(self, x, y):
        for parede in self.paredes :
            if parede.x == x and parede.y == y :
                return 1
        return 0

    def moverCima(self):
        x = self.jogador.x
        y = self.jogador.y
        if self.possuiParede(x, y - 1) == 1 :
            return 0
        self.jogador.y = y - 1
        return 1

    def moverBaixo(self):
        x = self.jogador.x
        y = self.jogador.y
        if self.possuiParede(x, y + 1) == 1 :
            return 0
        self.jogador.y = y + 1
        return 1

    def moverEsquerda(self):
        x = self.jogador.x
        y = self.jogador.y
        if self.possuiParede(x - 1, y) == 1 :
            return 0
        self.jogador.x = x - 1
        return 1

    def moverDireita(self):
        x = self.jogador.x
        y = self.jogador.y
        if self.possuiParede(x + 1, y) == 1 :
            return 0
        self.jogador.x = x + 1
        return 1


    def __str__(self):
        tabuleiro = [0] * self.tamY
        for i in range(self.tamY):
            tabuleiro[i] = [0] * self.tamX

        for parede in self.paredes :
            tabuleiro[parede.y][parede.x] = "P"

        tabuleiro[self.jogador.y][self.jogador.x] = "J"

        for i in range(0, self.tamY):
            for j in range(0, self.tamX):
                print tabuleiro[i][j],
            print ""
        print ""

        return ""

if __name__ == "__main__" :

    t = Tabuleiro()
    print t
    t.moverCima()
    print t