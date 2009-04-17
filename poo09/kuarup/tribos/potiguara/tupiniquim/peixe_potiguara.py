from visual import *
from marine import *

'''
Estas classes são as especializações da classe SerMarinho...
'''
class Peixe_Potiguara(Marine):
    
    

    def render(self):

        self.esqueleto = self.frame
#este valores irão sempre substituir os valores passados para movimentação do peIXE - CORRIGIR- ver tb a agua viva
        self.esqueleto.x = 3
        self.esqueleto.y = 0.5
        self.esqueleto.z = 1

        self.esqueleto.rotate(angle=3*pi/2,axis=(0,1,0),pos=(0,0,0))
        
        self.escala = self.scale
            
        u=self.escala/6.0
        r=6*u
        l=6*r
        direcoes = [-r,0,r]
        
        self.cor1 = color.orange;
        self.cor2 = color.white;
        self.cor3 = color.black;
        self.cor4 = color.red;
        
        corpo1 = self.desenharEsfera((0,0,0),self.cor1,5*self.escala,1)

        olhoE = self.desenharEsfera((4*self.escala,1*self.escala,-1.5*self.escala),self.cor2,2*self.escala,0.5)
        olhoD = self.desenharEsfera((4*self.escala,1*self.escala,1.5*self.escala),self.cor2,2*self.escala,0.5)

        pupilaE = self.desenharEsfera((5*self.escala,1*self.escala,-1.5*self.escala),self.cor3,1*self.escala,0.8)
        pupilaD = self.desenharEsfera((5*self.escala,1*self.escala,1.5*self.escala),self.cor3,1*self.escala,0.8)

        labioSup = self.desenhaElipse((5*self.escala,-2*self.escala,0),2*self.escala,2*self.escala,3*self.escala, self.cor4)
        labioInf = self.desenhaElipse((4*self.escala,-3*self.escala,0*self.escala),2*self.escala,2*self.escala,3*self.escala,self.cor4)

        rabo1 = self.desenharPiramide((-10*self.escala,0,0),(8*self.escala,10*self.escala,0.1*self.escala),(1*self.escala,0,0),self.cor1,0.6)
    
        rabo1.append = self.desenharCilindro((-10*self.escala,3*self.escala,-0.2*self.escala),(0,0,0.3*self.escala),2*self.escala,self.cor1,1)
        rabo1.append = self.desenharCilindro((-9*self.escala,0,-0.2*self.escala),(0,0,0.3*self.escala),2*self.escala,self.cor1,1)
        rabo1.append = self.desenharCilindro((-10*self.escala,-3*self.escala,-0.2*self.escala),(0,0,0.3*self.escala),2*self.escala,self.cor1,1)

        dorsal1 = self.desenharCilindro((0,4*self.escala,0),(0,0,0.1*self.escala),3*self.escala,self.cor1,0.5)
        dorsal2 = self.desenharCilindro((3*self.escala,3.5*self.escala,0),(0,0,0.1*self.escala),1*self.escala,self.cor1,1)
        dorsal3 = self.desenharCilindro((1.5*self.escala,4.5*self.escala,0),(0,0,0.1*self.escala),1*self.escala,self.cor1,1)
        dorsal4 = self.desenharCilindro((0,5*self.escala,0),(0,0,0.1*self.escala),1*self.escala,self.cor1,1)
        dorsal5 = self.desenharCilindro((-1.2*self.escala,4.5*self.escala,0),(0,0,0.1*self.escala),1*self.escala,self.cor1,1)
        dorsal6 = self.desenharCilindro((-2*self.escala,4*self.escala,0),(0,0,0.1*self.escala),1*self.escala,self.cor1,1)

        barbatana10 = self.desenharCilindro((0,0,-5*self.escala),(0.1*self.escala,0,-0.1*self.escala),2*self.escala,self.cor1)
        barbatana11 = self.desenharCilindro((0,-2*self.escala,-5*self.escala),(0.1*self.escala,0,-0.1*self.escala),1*self.escala,self.cor1)

        barbatana10 = self.desenharCilindro((0,0,5*self.escala),(-0.1*self.escala,0,-0.1*self.escala),2*self.escala,self.cor1)
        barbatana11 = self.desenharCilindro((0,-2*self.escala,5*self.escala),(-0.1*self.escala,0,-0.1*self.escala),1*self.escala,self.cor1)
        

    def desenharEsfera(self,posicao=(0,0,0),cor=color.blue,raio=1, opacidade=1):

        return sphere(

            frame=self.esqueleto, pos=posicao,color=cor, radius = raio, opacity=opacidade

        )

    def desenhaElipse(self,posicao=(0,0,0),comprimento=1,altura=1,largura=1,cor=color.blue):
        return ellipsoid(
            
            frame=self.esqueleto,pos=posicao, length=comprimento, height=altura, width=largura, color=cor
    
        )

    def desenharPiramide(self,posicao=(0,0,0),tamanho=(1,1,1),eixos=(1,0,0),cor=color.blue,opacidade=1):
        return pyramid(

            frame=self.esqueleto,pos=posicao, size=tamanho,axis=eixos, color=cor, opacity=opacidade
            
        )

    def desenharCilindro(self,posicao=(0,0,0),eixo=(1,0,0),raio=1,cor=color.blue,opacidade=1):
        return cylinder(

            frame=self.esqueleto,pos=posicao,axis=eixo, radius=raio, color=cor, opacity=opacidade

        )

    def proximoFrame(self):
        pass
