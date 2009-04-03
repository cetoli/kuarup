from threading import Thread
import time

class SolucionadorThread(Thread):

    def __init__(self, universe):
        Thread.__init__(self)
        self.universe = universe
        self.player = universe.player

    def run(self):
        delay = 0.01

    def wait(self, delay):
        time.sleep(delay)