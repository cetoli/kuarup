from visual import *
from MovimentoCimaCommand import *
from MovimentoBaixoCommand import *
from MovimentoEsquerdaCommand import *
from MovimentoDireitaCommand import *


class AcaraDiscoControlador:
    acara= None
    tela= None

    moverCima= None
    moverBaixo= None
    moverDireita= None
    moverEsquerda= None

    cenario= None

    def __init__ (self, cenario):
        self.cenario= cenario

        self.moverCima= MovimentoCimaCommand ()
        self.moverBaixo= MovimentoBaixoCommand ()
        self.moverEsquerda= MovimentoEsquerdaCommand ()
        self.moverDireita= MovimentoDireitaCommand ()

    def setAcara (self, acara):
        self.acara= acara

    def getAcara (self):
        return self.acara

    def setTela (self, tela):
        self.tela= tela

    def getTela (self):
        return self.tela

    def esperarTecla (self):
        return self.cenario.kb.getkey()

    def buscarTeclaPressionada (self):
        if self.cenario.kb.keys: # is there an event waiting to be processed?
            return self.esperarTecla () # obtain keyboard information

        return false

    def tratarTeclaPessionada (self, tecla):
        if tecla == "up":
            self.moverCima.executar (self.acara, self.tela)
        elif tecla == "down":
            self.moverBaixo.executar (self.acara, self.tela)
        elif tecla == "left":
            self.moverEsquerda.executar (self.acara, self.tela)
        elif tecla == "right":
            self.moverDireita.executar (self.acara, self.tela)




