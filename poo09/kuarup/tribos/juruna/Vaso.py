from Lixo import *
from visual import *

class Vaso (Lixo):

    def __init__ (self, escala= 1, **complemento):
        Lixo.__init__ (self, escala, **complemento)

    def desenhar (self):
        cor= (0.36,0.18,0)
        self.velocidade= 0.1
        self.dano= 10

        x= self.esqueleto.pos[0]
        y= self.esqueleto.pos[1]
        z= self.esqueleto.pos[2]


        obj= ellipsoid(pos=(x,y,z), axis=(0,1,0), length=1, height=0.5, width=0.5, color= cor)
        obj= cylinder (pos=(x,y+((obj.length/2)*0.9),z), axis= (0,1,0), length= 0.06*self.escala, radius=0.04*self.escala, color= cor)

# Fim.