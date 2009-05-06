from Lixo import *
from visual import *

class Pneu (Lixo):

    def desenhar (self):
        self.velocidade= 0.7
        self.dano= 20

        x= self.esqueleto.pos[0]
        y= self.esqueleto.pos[1]
        z= self.esqueleto.pos[2]

        raio= 1*self.escala

        """
        obj= ring(frame= self.esqueleto, pos=(x,y,z), axis=(1,0,0), radius=1*self.escala, thickness=0.4*self.escala, color= color.black)
        self.elementos.append (obj)

        self.posicao.setPontoBaixo (x+obj.radius+obj.thickness-10, y-obj.radius-obj.thickness+2, z)
        self.posicao.setPontoCima (x-obj.radius-obj.thickness-10, y+obj.radius+obj.thickness+2, z)
        """
        obj= helix(pos=(x,y,z), axis=(0,0.6*self.escala,0), radius=raio, coils= 40*self.escala, thickness=0.4*self.escala, color= color.black)
        self.elementos.append (obj)


        obj= helix(pos=(x,y-((obj.axis[1]/2)*1.0),z), axis=(0,obj.axis[1]*1.7,0), radius=raio*0.7, coils= 80*self.escala, thickness=0.2*self.escala, color= (0.4,0.4,0.4))
        self.elementos.append (obj)


"""
        self.posicao.setPontoBaixo (x, y-obj.radius-obj.thickness, z)
        self.posicao.setPontoCima (x-obj.radius, y+obj.radius+obj.thickness, z)
"""
