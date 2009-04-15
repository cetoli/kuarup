from Lixo import *
from visual import *

class Bota (Lixo):

    def desenhar (self):
        self.velocidade= 0.5
        self.dano= 15

        x= self.esqueleto.pos[0]
        y= self.esqueleto.pos[1]
        z= self.esqueleto.pos[2]

        raio= 0.25*self.escala
        obj= cylinder (frame= self.esqueleto, pos=(x,y,z), axis= (0,1,0), length= 0.7*self.escala, radius=raio, color= color.black)
        self.elementos.append (obj)

        yC= y+obj.length

        comprimento= 1.5*self.escala
        x1= x + (comprimento/2) - (obj.radius*2)# - (0.1*self.escala)

        obj= ellipsoid (frame= self.esqueleto, pos=(x1,y,z), length=comprimento, height=0.3*self.escala, width=0.9*self.escala, color= color.black)
        self.elementos.append (obj)

        comprimento= raio*2
        #x1= x - (raio/2) + comprimento/2
        #y1= y - obj.height/2


        zC= z-(obj.width/2)
        self.posicao.setPontoBaixo (x1+comprimento, y-(obj.height/2)+2, z+10-obj.width/2)
        self.posicao.setPontoCima (x1-comprimento, yC+2, z+10+obj.width/2)

        #obj= box (frame= self.esqueleto, pos=(x1,y1,z), length=comprimento, height= (0.1*self.escala), width=obj.width, color= color.black)
        #self.elementos.append (obj)

        #obj= box (frame= self.esqueleto, pos=(obj.pos[0]+obj.length/2+raio/2,y1,z), length=raio, height= (0.1*self.escala), width=obj.width, color= color.black)
        #self.elementos.append (obj)

        #obj= box (frame= self.esqueleto, pos=(obj.pos[0]+obj.length/2+raio/2,y1,z), length=raio, height= (0.1*self.escala), width=obj.width, color= color.black)
        #self.elementos.append (obj)

        #obj= box (frame= self.esqueleto, pos=(obj.pos[0]+obj.length/2+raio/2,y,z), length=raio, height=obj.height/3 + (0.2*self.escala), width=obj.width, color= color.black)
        #self.elementos.append (obj)