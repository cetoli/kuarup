from Lixo import *
from visual import *

class Teste (Lixo):

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

        #frame= self.esqueleto,





        """
        dy= (0.005*self.escala)/2
        obj= helix(pos=(x,y+dy,z), axis=(0.9*self.escala,0,0), radius=0.005*self.escala, coils= 5*self.escala, thickness=0.01*self.escala, color= color.red)
        self.elementos.append (obj)

        dy= (0.005*self.escala)/2
        obj= helix(pos=(x,y-dy,z), axis=(0.9*self.escala,0,0), radius=0.005*self.escala, coils= 5*self.escala, thickness=0.01*self.escala, color= color.red)
        self.elementos.append (obj)

        dz= (0.005*self.escala)/2
        obj= helix(pos=(x,y,z-dz), axis=(0.9*self.escala,0,0), radius=0.005*self.escala, coils= 5*self.escala, thickness=0.01*self.escala, color= color.red)
        self.elementos.append (obj)

        dz= (0.005*self.escala)/2
        obj= helix(pos=(x,y,z+dz), axis=(0.9*self.escala,0,0), radius=0.005*self.escala, coils= 5*self.escala, thickness=0.01*self.escala, color= color.red)
        self.elementos.append (obj)
        """
# Fim.