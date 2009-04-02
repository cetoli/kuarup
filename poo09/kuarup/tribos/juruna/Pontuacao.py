from visual import *

class Pontuacao:
    vida= 100

    def __init__ (self):
        self.vida= 100

    def decrementarVida (self, qtd):
        self.vida-= qtd

        if (self.vida < 0):
            self.vida= 0

    def incrementarVida (self, qtd):
        self.vida+= qtd

        if (self.vida > 100):
            self.vida= 100

    def getVida (self):
        return self.vida

    def temVida (self):
        if (self.vida > 0):
            return 1

        return 0
# Fim