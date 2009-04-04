from threading import Thread
import time
from visual import *

class TecladoThread(Thread):

    def __init__(self, cenario):
        Thread.__init__(self)
        self.cenario = cenario
        self.jogador3D = cenario.jogador3D

    def wait(self, segundos):
        while self.jogador3D.getFoiMovido() != -1 :
            time.sleep(segundos)
            
    def run(self):

        while 1:
            k = self.cenario.scene2.kb.getkey()
            if k == 'up':
                self.cenario.moverCima()
            elif k == 'down':
                self.cenario.moverBaixo()
            elif k == 'left':
                self.cenario.moverEsquerda()
            elif k == 'right':
                self.cenario.moverDireita()
            elif k == 'r':
                #self.cenario.reset()
                pass
            elif k == 'q':
                #self.cenario.quit()
                pass
            self.wait(0.01)

        return

        delay = 0.01

        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverDireita(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverBaixo(), self.wait(delay)
        self.cenario.moverEsquerda(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)
        self.cenario.moverCima(), self.wait(delay)