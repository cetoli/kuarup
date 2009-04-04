from threading import Thread
from visual import *

class MovimentoThread(Thread):

    def __init__(self, cenario):
        Thread.__init__(self)
        self.cenario = cenario

    def run(self):
        while 1 :
            rate(60)
            self.cenario.proximoFrame()
