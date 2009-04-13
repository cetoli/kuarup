from visual import *

class Topete():
    
    def __init__(self, peixe):
        
        self.peixe = peixe
        self.escala = peixe.escala
        
        self.pos1 = (-0.2 * self.escala, 0.1 * self.escala, 0)
        self.pos2 = (-1 * self.escala, 0.1 * self.escala, 0)
        self.pos3 = (0.5 * self.escala, 2.8 * self.escala, 0)
        
        self.length1 = self.escala * 4
        self.length2 = self.escala * 3.8

        self.size3 = (3 * self.escala, 2 * self.escala, 0.2 * self.escala)
        
        self.height1 = self.escala * 5.2
        self.height2 = self.escala * 4

        self.width1 = self.escala * 0.3
        self.width2 = self.escala * 0.3

        self.color1 = (0, 0, 0.7)
        self.color2 = (0, 0, 0.65)
        self.color3 = (0.8, 0.8, 0)

        self.angle = 2.9 * pi / 2.0

        self.topete1 = ellipsoid(frame = peixe.esqueleto, pos = self.pos1, length = self.length1, height = self.height1, width = self.width1, color = self.color1)
        self.topete2 = ellipsoid(frame = peixe.esqueleto, pos = self.pos2, length = self.length2, height = self.height2, width = self.width2, color = self.color2)
        self.topete3 = pyramid(frame = peixe.esqueleto, pos = self.pos3, size = self.size3, color = self.color3)
        self.topete3.rotate(angle = self.angle, axis=(0,0,1))

    def proximoFrame(self):
        pass
            