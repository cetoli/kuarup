from visual import *
from EstadoFactory import *
from Posicao import *
from Ponto import *
from Peca import *

class PecaResultado (Peca):
    cor= (1, 0, 0) #(0.7,0.7,0.7)
    tamanho= 0.3
    profundidade= 0.1

    def __init__ (self, ponto= Ponto (0,0,0), texto="", observador= None):
        Peca.__init__ (self, ponto, "", observador)
        self.peca.width= 0.1
        self.peca.color= self.cor
        self.textoEsperado= texto

    def getEPecaResultado (self):
        return True

# Fim