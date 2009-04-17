from threading import Thread
import time

class boardSolver(Thread):

    def __init__(self, universe):
        Thread.__init__(self)
        self.universe  = universe

    def run(self):
        delay = 0.01
        self.universe.fish.swin(direction='left')

    def wait(self, segundos):
        while self.jogador3D.getFoiMovido() != -1 :
            time.sleep(segundos)