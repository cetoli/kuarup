from visual import *
from SerMarinho import *
from marine import *

class AguaViva(SerMarinho):

    def render(self, escala=1):

        u=escala/6.0
        r=6*u
        l=6*r
        direcoes = [-r,0,r]          
        
        self.cor1 = (0.2,0.3,0.4) #grafite
        self.cor2 = color.white
        self.cor3 = (0.4,0.1,0.6) #roxo ou algo parecido
        self.cor4 = color.blue
        self.cor5 = color.red

        #elipses
            #elipses maiores tansparentes
        self.desenharElipse((0,0,0),3*escala,2*escala,3*escala,self.cor2,0.4)
        self.desenharElipse ((0,0.4*escala,0),2*escala,1.5*escala,2*escala,self.cor3,0.4)
            #elipses central
        self.desenharElipse ((0,0,0),3*escala,2*escala,3*escala,self.cor3,0.4,materials.marble)
            #elipses laterais de adorno
        self.desenharElipse ((0,-0.2*escala,1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.desenharElipse ((0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)
        self.desenharElipse ((0,-0.2*escala,-1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.desenharElipse ((-0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)

	#cilindros (da um formato de 'saia' a agua viva)
        self.desenharCilindro((0,-0.65*escala,0), (0,0.7*escala,0),1.479*escala,self.cor3,0.5)
        self.desenharCilindro((0,-1*escala,0),(0,0.7*escala,0),1.55*escala,self.cor3,0.5)

	#aneis (dao aparencias de riscos dentro da 'agua viva')
        self.desenharAnel((-0.1*escala,0,0),(0,0.5*escala,0.1*escala),1.3*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.3*escala,0),(0,0.5*escala,0.1*escala), 1.1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.5*escala,0),(0,0.5*escala,0.1*escala),1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.7*escala,0),(0,0.5*escala,0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.desenharAnel((0.1*escala,0,0),(0,0.5*escala,-0.1*escala),1.3*escala,0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.3*escala,0),(0,0.5*escala,-0.1*escala),1.1*escala,0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.5*escala,0), (0,0.5*escala,-0.1*escala), 1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.7*escala,0),(0,0.5*escala,-0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.desenharAnel((0.1*escala,1*escala,0),(0,0,0),0.5,0.004*escala,self.cor5)        

	#Espirais
        self.desenharEspiral((0,-0.8*escala,0),(0,1*escala,0), 1.4*escala,0.01*escala,self.cor2,materials.marble)
        self.desenharEspiral((0,-0.4*escala,0),(0,1*escala,0), 0.8*escala,0.01*escala,self.cor2,materials.marble)

        self.desenharEspiral((0,-1.5*escala,0),(0,1.5*escala,0),0.3*escala,0.3*escala,self.cor2,materials.marble)
        self.desenharEspiral((0,-1.1*escala,0),(0,0.7*escala,0),0.8*escala,0.35*escala,self.cor2,materials.marble)

        self.desenharEspiral((0.5*escala,-3*escala,0.3*escala),(-0.5*escala,3*escala,0),0.1*escala,0.15*escala,self.cor2,materials.marble)
        self.desenharEspiral((-0.5*escala,-3*escala,-0.2*escala),(0.5*escala,3*escala,0),0.1*escala,0.15*escala,self.cor2,materials.marble)
        self.desenharEspiral((0,-3*escala,0.3*escala),(0,3*escala,0),0.1*escala,0.15*escala,self.cor3,materials.marble)

        self.desenharEspiral((2*escala,-2*escala,0.3*escala),(-0.5*escala,1*escala,0),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((-2*escala,-2*escala,0.3*escala),(0.5*escala,1*escala,0),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((0,-2*escala,-2*escala),(0,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((0,-2*escala,2*escala),(0,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((1*escala,-2*escala,-2*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((-1*escala,-2*escala,-2*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((-1*escala,-2*escala,2*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.desenharEspiral((1*escala,-2*escala,2*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((1.5*escala,-2*escala,-1.5*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.5*escala,-2*escala,-1.5*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.5*escala,-2*escala,1.5*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.5*escala,-2*escala,1.5*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.25*escala,-2*escala,-1.75*escala), (-0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.25*escala,-2*escala,-1.75*escala), (0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.25*escala,-2*escala,1.75*escala), (-0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.25*escala,-2*escala,1.75*escala), (0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.75*escala,-2*escala,-1.25*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.75*escala,-2*escala,-1.25*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.75*escala,-2*escala,1.25*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.75*escala,-2*escala,1.25*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.40*escala,-2*escala,-1.60*escala),(-0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.40*escala,-2*escala,-1.60*escala),(0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.40*escala,-2*escala,1.60*escala),(-0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.40*escala,-2*escala,1.60*escala),(0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.6*escala,-2*escala,-1.4*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.6*escala,-2*escala,-1.4*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((1.6*escala,-2*escala,1.4*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-1.6*escala,-2*escala,1.4*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((2*escala,-2*escala,-1*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-2*escala,-2*escala,-1*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((2*escala,-2*escala,1*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.desenharEspiral((-2*escala,-2*escala,1*escala), (0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        
    def desenharElipse(self,posicao=(0,0,0),comprimento=3,altura=2,largura=3,cor=color.yellow,opacidade=0.4, aparencia=materials.unshaded):
        return ellipsoid(
            frame = self.esqueleto,pos = posicao, length = comprimento, height = altura, width = largura, color = cor, opacity = opacidade, material = aparencia
        )    
    def desenharCilindro(self,posicao=(0,-0.65,0),eixos=(0,0.7,0),raio=1,cor=color.yellow,opacidade=0.5):
        return cylinder(
            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, color = cor, opacity = opacidade
        )
    def desenharAnel(self,posicao=(0,0,0),eixos=(1,1,1),raio=1,espessura=0.5,cor=color.yellow):
        return ring(
            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, thickness = 0.1, color = cor
        )
    def desenharEspiral(self,posicao=(0,0,0),eixos=(1,1,1),raio=1,espessura=0.01,cor=color.yellow,aparencia=materials.unshaded):
        return helix(
            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, thickness = espessura, color = cor, material = aparencia
        )
