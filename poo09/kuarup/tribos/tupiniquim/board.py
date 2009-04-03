from visual import *
from renderable import *

class Board(Renderable):
    def __init__(self):
        self.maxgrid = 8
        self.enemies=[]
        self.blocks = []
        self.originalColor = color.white

        for i in range(self.maxgrid+1):
            c1 = curve(pos=[(2*i-self.maxgrid, 0, -self.maxgrid), (2*i-self.maxgrid, 0, self.maxgrid)], color=color.cyan)
            c2 = curve(pos=[(-self.maxgrid, 0, 2*i-self.maxgrid), (self.maxgrid, 0, 2*i-self.maxgrid)], color=color.cyan)

        for i in range(self.maxgrid):
            for j in range(self.maxgrid):
                self.blocks.append(box(pos=(2*i-self.maxgrid+1, -0.6, self.maxgrid - 1 - 2*j), width=2, length=2, height=1, color=self.originalColor))


    def solvePosition(self, coord):
        return (2*coord[0]-self.maxgrid + 1, 0.65, self.maxgrid - 1 - 2*coord[1])

    def setActiveBlock(self):
        for b in self.blocks:
            if(b.pos.x == self.player.getPosition().x and b.pos.z == self.player.getPosition().z):
                self.activeBlock = b
                b.color = color.yellow
            else:
                 b.color = self.originalColor

    def getBlockAhead(self, currentPosition):
        newPos = array(currentPosition)
        newPos[0]= newPos[0] - 2.0
        return (newPos[0], newPos[1], newPos[2])

    def getBlockBack(self, currentPosition):
        newPos = array(currentPosition)
        newPos[0]= newPos[0] + 2.0
        return (newPos[0], newPos[1], newPos[2])

    def getBlockUp(self, currentPosition):
        newPos = array(currentPosition)
        newPos[2]= newPos[2] - 2.0
        return (newPos[0], newPos[1], newPos[2])

    def getBlockDown(self, currentPosition):
        newPos = array(currentPosition)
        newPos[2]= newPos[2] + 2.0
        return (newPos[0], newPos[1], newPos[2])

    def addEnemy(self, enemy, coord=(0, 0)):
        enemy.setPosition(self.solvePosition(coord))
        self.enemies.append(enemy)

    def setPlayer(self, player):
        player.setPosition(self.solvePosition(player.coord))
        self.player = player

    def setFriend(self, friend, coord=(0,0)):
        friend.setPosition(self.solvePosition(coord))
        self.friend = friend