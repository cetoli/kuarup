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
        obj= cylinder (frame= self.esqueleto, pos=(x,y,z), axis= (0,1,0), length= 0.8*self.escala, radius=raio, color= color.black)
        self.elementos.append (obj)

        obj= helix(frame= self.esqueleto, pos=(x-(0.1*self.escala),y+(0.3*self.escala),z), axis=(0,0.3*self.escala,0), radius=raio*0.8, coils= 3, thickness=0.04*self.escala, color= (0.8,0.8,0.8))
        self.elementos.append (obj)

        #obj= helix(frame= self.esqueleto, pos=(x-0.1,y+0.55,z), axis=(0,-0.3,0), radius=raio*0.8, coils= 3, thickness=0.04*self.escala, color= (0.8,0.8,0.8))
        #self.elementos.append (obj)

        yC= y+obj.length

        comprimento= 1.5*self.escala
        x1= x - (obj.radius*2) #+ (comprimento/2) # - (0.1*self.escala)

        obj= ellipsoid (frame= self.esqueleto, pos=(x1,y,z), length=comprimento, height=0.6*self.escala, width=0.9*self.escala, color= color.black)
        self.elementos.append (obj)

        comprimento= raio*2
        #x1= x - (raio/2) + comprimento/2
        #y1= y - obj.height/2


        zC= z-(obj.width/2)
        self.posicao.setPontoBaixo (x1+comprimento, y-(obj.height/2)+2, z+10-obj.width/2)
        self.posicao.setPontoCima (x1-comprimento, yC+2, z+10+obj.width/2)

        obj= box (frame= self.esqueleto, pos=(x,y-(obj.height/3),z), length=raio*2, height= (0.3*self.escala), width=raio*2, color= color.black)
        self.elementos.append (obj)


        l= raio*2
        x= x1-l+(comprimento/4)
        obj= box (frame= self.esqueleto, pos=(x,y-(obj.height/3),z), length=l, height= (0.3*self.escala), width=raio*2, color= color.black)
        self.elementos.append (obj)


# Fim.