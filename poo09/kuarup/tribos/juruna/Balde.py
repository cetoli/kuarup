from Lixo import *
from visual import *

class Balde (Lixo):

    def __init__ (self, escala= 1, **complemento):
        Lixo.__init__ (self, escala, **complemento)

    def desenhar (self):
        self.velocidade= 0.5
        self.dano= 0

        x= self.esqueleto.pos[0]
        y= self.esqueleto.pos[1]
        z= self.esqueleto.pos[2]

        l= 2*self.escala
        obj= cylinder(frame= self.esqueleto, pos=(x,y,z), axis=(l,0,0), radius=1.2)
        eixo= Eixo ()
        obj.rotate (angle= eixo.converterGrausRadiano (80), axis= Eixo.EIXO_Z)
        self.elementos.append (obj)

        self.posicao.setPontoBaixo (x+obj.radius/2, y, z+obj.radius/2)

        self.posicao.setPontoCima (x-obj.radius/2, y-l, z-obj.radius/2)


# Fim