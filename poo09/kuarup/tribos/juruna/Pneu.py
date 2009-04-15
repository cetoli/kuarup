from Lixo import *
from visual import *

class Pneu (Lixo):

    def desenhar (self):
        self.velocidade= 0.7
        self.dano= 20

        x= self.esqueleto.pos[0]
        y= self.esqueleto.pos[1]
        z= self.esqueleto.pos[2]

        obj= ring(frame= self.esqueleto, pos=(x,y,z), axis=(1,0,0), radius=1*self.escala, thickness=0.4*self.escala, color= color.black)
        self.elementos.append (obj)

        self.posicao.setPontoBaixo (x+obj.radius+obj.thickness-10, y-obj.radius-obj.thickness+2, z)
        self.posicao.setPontoCima (x-obj.radius-obj.thickness-10, y+obj.radius+obj.thickness+2, z)

"""
        self.posicao.setPontoBaixo (x, y-obj.radius-obj.thickness, z)
        self.posicao.setPontoCima (x-obj.radius, y+obj.radius+obj.thickness, z)
"""
