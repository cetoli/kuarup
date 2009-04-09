from visual import *

class Corpo():
    
    def __init__(self, peixe):
        
        self.peixe = peixe
        self.escala = peixe.escala
        
        self.pos1 = (0, 0, 0)
        self.pos2 = (-0.8 * self.escala, 0, 0)
        self.pos3 = (-1.8 * self.escala, 0, 0)
        
        self.length1 = self.escala * 4
        self.length2 = self.escala * 3.8
        self.length3 = self.escala * 3.5
        
        self.height1 = self.escala * 5
        self.height2 = self.escala * 3.8
        self.height3 = self.escala * 2.5

        self.width1 = self.escala * 2
        self.width2 = self.escala * 1.6
        self.width3 = self.escala * 1.2

        self.color1 = (0, 0, 1)
        self.color2 = (0, 0, 0.9)
        self.color3 = (0, 0, 0.8)

        self.corpo1 = ellipsoid(frame = peixe.esqueleto, pos = self.pos1, length = self.length1, height = self.height1, width = self.width1, color = self.color1)
        self.corpo2 = ellipsoid(frame = peixe.esqueleto, pos = self.pos2, length = self.length2, height = self.height2, width = self.width2, color = self.color2)
        self.corpo3 = ellipsoid(frame = peixe.esqueleto, pos = self.pos3, length = self.length3, height = self.height3, width = self.width3, color = self.color3)

    def proximoFrame(self):
        pass
            