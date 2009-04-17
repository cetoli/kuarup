from threading import Thread
from visual import *
import Image
import ImageGrab

class MotionThread(Thread):

    def __init__(self, universe):
        Thread.__init__(self)
        self.universe = universe
        self.frame = 0
    def run(self):
        while 1 :
            rate(self.universe.speed*2.0)
            if(self.frame>0 and self.frame%5==0):
                im = ImageGrab.grab((24,30,200-4,200-4))
                fn = "resources/problema"+str(self.frame)+".gif"
                im.save(fn)

            self.frame += 1
            self.universe.nextStep()

class AnimatorThread(Thread):

    def __init__(self, universe):
        Thread.__init__(self)
        self.universe = universe
        self.player = universe.player
        self.enemies = universe.board.enemies
        self.grid = universe.board

    def run(self):
        delay = .5

        self.player.newPosition = self.grid.getBlockAhead(self.player.getPosition())
        self.player.moveAhead(), self.wait(delay, self.player)

        # fish tackle...
        self.player.newPosition = self.player.getPosition() - vector(0.5, 0, 0)
        self.player.moveAhead(), self.wait(delay/2, self.player)
        self.player.newPosition = self.player.getPosition() + vector(0.5, 0, 0)
        self.player.moveBackwards(), self.wait(delay/2, self.player)

        #collision
        self.enemies[3].newPosition = self.enemies[2].getPosition() + vector(0.5, 0, 0)
        self.enemies[3].moveAhead(), self.wait(delay, self.enemies[3])
        self.enemies[3].newPosition = self.grid.getBlockBack(self.enemies[2].getPosition())
        self.enemies[3].moveBackwards(), self.wait(delay, self.enemies[3])

        #die
        self.enemies[2].newPosition = self.enemies[2].getPosition() - vector(self.enemies[2].getPosition().x + self.grid.maxgrid, 0, 0)
        self.enemies[2].moveAhead(), self.wait(delay, self.enemies[2])
        self.enemies[2].frame.visible = 0

        self.player.newPosition = self.grid.getBlockUp(self.player.getPosition())
        self.player.moveUp(), self.wait(delay, self.player)

        self.player.newPosition = self.grid.getBlockAhead(self.player.getPosition())
        self.player.moveAhead(), self.wait(delay, self.player)

        self.player.newPosition = self.grid.getBlockAhead(self.player.getPosition())
        self.player.moveAhead(), self.wait(delay, self.player)

        self.player.newPosition = self.grid.getBlockAhead(self.player.getPosition())
        self.player.moveAhead(), self.wait(delay, self.player)

        self.player.moveDown(), self.wait(delay, self.player)

        # fish tackle...
        self.player.newPosition = self.player.getPosition() + vector(0, 0, 0.5)
        self.player.moveDown(), self.wait(delay/2, self.player)
        self.player.newPosition = self.player.getPosition() - vector(0, 0, 0.5)
        self.player.moveUpwards(), self.wait(delay/2, self.player)

        #collision
        self.enemies[3].newPosition = self.enemies[1].getPosition() + vector(0.5, 0, 0)
        self.enemies[3].moveDown(), self.wait(delay, self.enemies[3])
        self.enemies[3].newPosition = self.grid.getBlockUp(self.enemies[1].getPosition())
        self.enemies[3].moveUpwards(), self.wait(delay, self.enemies[3])

        self.enemies[1].newPosition = self.enemies[0].getPosition() + vector(0.5, 0, 0)
        self.enemies[1].moveDown(), self.wait(delay, self.enemies[1])
        self.enemies[1].newPosition = self.grid.getBlockUp(self.enemies[0].getPosition())
        self.enemies[1].moveUpwards(), self.wait(delay, self.enemies[1])

        #die
        self.enemies[0].newPosition = self.enemies[1].getPosition() - vector(0, 0, self.enemies[1].getPosition().z + self.grid.maxgrid) + vector(0.5, 0, 0)
        self.enemies[0].moveDown(), self.wait(delay, self.enemies[0])
        self.enemies[0].frame.visible = 0

        self.player.newPosition = self.grid.getBlockDown(self.player.getPosition())
        self.player.moveDown(), self.wait(delay, self.player)

        self.player.newPosition = self.grid.getBlockDown(self.player.getPosition())
        self.player.moveDown(), self.wait(delay, self.player)

        self.player.newPosition = self.grid.getBlockDown(self.player.getPosition())
        self.player.moveDown(), self.wait(delay, self.player)

        # fish tackle...
        self.player.newPosition = self.player.getPosition() + vector(0, 0, 0.5)
        self.player.moveDown(), self.wait(delay/2, self.player)
        self.player.newPosition = self.player.getPosition() - vector(0, 0, 0.5)
        self.player.moveUpwards(), self.wait(delay/2, self.player)

                #collision
        self.enemies[3].newPosition = self.enemies[1].getPosition() + vector(0.5, 0, 0)
        self.enemies[3].moveDown(), self.wait(delay, self.enemies[3])
        self.enemies[3].newPosition = self.grid.getBlockUp(self.enemies[1].getPosition())
        self.enemies[3].moveUpwards(), self.wait(delay, self.enemies[3])

        #die
        self.enemies[1].newPosition = self.enemies[1].getPosition() + vector(0, 0, self.grid.maxgrid)
        self.enemies[1].moveDown(), self.wait(delay, self.enemies[1])
        self.enemies[1].frame.visible = 0


        self.player.newPosition = self.grid.getBlockDown(self.player.getPosition())
        self.player.moveDown(), self.wait(delay, self.player)

        # fish tackle...
        self.player.newPosition = self.player.getPosition() + vector(0, 0, 0.5)
        self.player.moveDown(), self.wait(delay/2, self.player)
        self.player.newPosition = self.player.getPosition() - vector(0, 0, 0.5)
        self.player.moveUpwards(), self.wait(delay/2, self.player)

        #die
        self.enemies[3].newPosition = self.enemies[3].getPosition() + vector(0, 0, self.grid.maxgrid)
        self.enemies[3].moveDown(), self.wait(delay, self.enemies[3])
        self.enemies[3].frame.visible = 0

        self.player.newPosition = self.grid.getBlockDown(self.player.getPosition())
        self.player.moveDown(), self.wait(delay, self.player)

        self.player.newPosition = self.grid.getBlockDown(self.player.getPosition())
        self.player.moveDown(), self.wait(delay, self.player)

        self.player.newPosition = self.grid.getBlockDown(self.player.getPosition())
        self.player.moveDown(), self.wait(delay, self.player)

        self.player.newPosition = self.grid.getBlockAhead(self.player.getPosition())
        self.player.moveAhead(), self.wait(delay, self.player)

        label(pos=(0,-1,-5), height = 20, text='Parabens!!!')

    def wait(self, delay, element):
        while(element.stateNotChanged):
            time.sleep(delay)

    def waitSimple(self, delay):
        time.sleep(delay)