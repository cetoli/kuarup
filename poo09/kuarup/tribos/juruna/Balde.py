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
        #obj= ring(frame= self.esqueleto, pos=(x,y,z), axis=(0,1,0), radius=1.2, thickness=0.1)
        #self.elementos.append (obj)
        eixo= Eixo ()
        #obj.rotate (angle= eixo.converterGrausRadiano (90), axis= Eixo.EIXO_Z)

        #self.posicao.setPontoBaixo (x+obj.radius/2, y, z+obj.radius/2)

        #self.posicao.setPontoCima (x-obj.radius/2, y-l, z-obj.radius/2)

        raio= 0.5*self.escala

        obj= helix(frame= self.esqueleto, pos=(0,5,6), axis=(0,1,0), radius=raio, coils= 40, thickness=0.2*self.escala, color= (0.8,0.8,0.8))
        self.elementos.append (obj)

        obj= cylinder(frame= self.esqueleto, pos=obj.pos, axis=(0,0.3,0), radius=raio, thickness=0.2*self.escala, color= (0.8,0.8,0.8))
        self.elementos.append (obj)

# Fim