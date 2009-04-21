from threading import Thread
import time
from visual import *

class KeyboardThread(Thread):

    def __init__(self, game):
        Thread.__init__(self)
        self.game = game
        self.keyboard = game.keyboard
        self.marker = game.marker

    def run(self):

        while 1:
            while self.marker.stateNotChanged :
                time.sleep(0.1)

            key = self.keyboard.getkey()
            
            if key == 'left':
                self.marker.newPosition = self.marker.getPosition() - vector(0,0,30)
                self.marker.markedIndex -= 1
                self.marker.moveDirection='dontcare'
            elif key == 'right':
                self.marker.newPosition = self.marker.getPosition() + vector(0,0,30)
                self.marker.markedIndex += 1
                self.marker.moveDirection='dontcare'
            elif key == 's' or key == 'S':
                self.game.selectPiece()
