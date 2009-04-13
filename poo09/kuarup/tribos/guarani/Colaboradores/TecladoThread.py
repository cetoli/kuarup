from threading import Thread
import time
from visual import *

class TecladoThread(Thread):

    def __init__(self, keyboard, jogadores, jogadores3D):
        Thread.__init__(self)
        self.kb = keyboard
        self.jogadores = jogadores
        self.jogadores3D = jogadores3D

    def run(self):

        while 1:

            k = self.kb.getkey()

            if k == 'up':
                if self.jogadores3D[0].terminouMovimento() != 0 :
                    self.jogadores[0].moverCima()
            elif k == 'down':
                if self.jogadores3D[0].terminouMovimento() != 0 :
                    self.jogadores[0].moverBaixo()
            elif k == 'left':
                if self.jogadores3D[0].terminouMovimento() != 0 :
                    self.jogadores[0].moverEsquerda()
            elif k == 'right':
                if self.jogadores3D[0].terminouMovimento() != 0 :
                    self.jogadores[0].moverDireita()
            if k == 'w':
                if self.jogadores3D[1].terminouMovimento() != 0 :
                    self.jogadores[1].moverCima()
            elif k == 's':
                if self.jogadores3D[1].terminouMovimento() != 0 :
                    self.jogadores[1].moverBaixo()
            elif k == 'a':
                if self.jogadores3D[1].terminouMovimento() != 0 :
                    self.jogadores[1].moverEsquerda()
            elif k == 'd':
                if self.jogadores3D[1].terminouMovimento() != 0 :
                    self.jogadores[1].moverDireita()
            elif k == 'r':
                #self.cenario.reset()
                pass
            elif k == 'q':
                #self.cenario.quit()
                pass

            #espera alguns milisegundos para nao executar o while muito rapido
            #melhora a jogabilidade
            time.sleep(0.01) #segundos
