from visual import *

class Parede3D():

    def __init__(self, x, y):

        self.esqueleto = frame()
        self.box = box(frame = self.esqueleto, pos = (x,-y,0), length = 1, height = 1, width = 1, color = (0,1,1))