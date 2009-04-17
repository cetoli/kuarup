from renderable import *

class Marine(Renderable):
    def swin(self, direction='left'):
        """docstring for swin"""
        posIncrement = 0.004 * self.speed
        if(direction == 'left'):
            self.frame.pos -= posIncrement * norm(self.frame.axis)
        elif (direction == 'rigth'):
            self.frame.pos += posIncrement * norm(self.frame.axis)
