#! /usr/bin/env python
# -*- coding: UTF8 -*-
"""
###########################################
     Movimento Caracol x Coadjuvantes
###########################################
:Author: Guajajaras
:Contact: `Guajajaras <http://kuarup2009.pbwiki.com/Tribo-Guajajaras>`__
:Date: $Date: 2009/03/24$
:Status: This is a "work in progress"
:Revision: $Revision: 1.00$
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""
from visual import *
import Image
import ImageGrab

TITLE = 'Traira em movimento'

class Cenario:
    def __init__(self):
        self.scene2 = display(title = TITLE, width=250, height=250, center= (0,0,0), x=0, y=0)
        self.scene2.x, self.scene2.y = 0, 0
        self.scene2.select()
        self.scene2.autoscale = 1

    def principal(self):
        traira1=Traira(escala =30, axis=(7,3,4), pos= (18,0,0))           # Primeiro peixe
        aguaviva=AguaViva(escala =8, axis=(0.5,0,0.5), pos= (-45,-9,3))  # Primeiro Coadjuvante
        Submarino1=Submarino(escala =4, axis=(1,0,1), pos= (50,-3,0))    # Segundo Coadjuvante

        side = 40
        thk = 0.3
        s2 = 2*side - thk
        s3 = 2*side + thk
        wallR = box (pos=( side, 0, 0), length=thk, height=s2,  width=s3,  color = color.green, opacity=0)
        wallL = box (pos=(-side, 0, 0), length=thk, height=s2,  width=s3,  color = color.red, opacity=0)
        wallB = box (pos=(0, -side, 0), length=s3,  height=thk, width=s3,  color = color.blue, opacity=0)
        wallT = box (pos=(0,  side, 0), length=s3,  height=thk, width=s3,  color = color.orange, opacity=0)
        wallBK = box(pos=(0, 0, -side), length=s2,  height=s2,  width=thk, color = (0.7,0.7,0.7), opacity=0)

        traira1.mass = 1.0
        traira1.p = vector (-0.15, -0.23, +0.27)

        side = side - thk*0.5 - traira1.esqueleto.x

        quadro = 0
        aux = 0
        dt = 0.5
        t=0.0
        while 1:
          aux += 1
          if(aux == 5) :
                im = ImageGrab.grab((24,30,250-4,250-4))
                fn = "Kuarup"+str(quadro)+".png"
                im.save(fn)
                aux = 0
          rate(100)
          self.scene2.center = traira1.esqueleto.pos
          traira1.esqueleto.axis.x = traira1.p.x
          traira1.esqueleto.axis.y = traira1.p.y
          traira1.esqueleto.axis.z = traira1.p.z
          rate(100)
          t = t + dt
          traira1.esqueleto.pos = traira1.esqueleto.pos + (traira1.p/traira1.mass)*dt
          if not (side > traira1.esqueleto.x > -side):
            traira1.p.x = -traira1.p.x
          if not (side > traira1.esqueleto.y > -side):
            traira1.p.y = -traira1.p.y
          if not (side > traira1.esqueleto.z > -side):
            traira1.p.z = -traira1.p.z
          traira1.proximoFrame() 
          quadro += 1
          
'''
Classe base de qualquer ser marinho
'''
class SerMarinho():
    def __init__(self, escala= 5, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)
    def desenha(self): pass
'''
Esta classe é uma especialização da classe SerMarinho...
'''
class Traira(SerMarinho):
    def desenha(self, escala=5):
        s=escala
        cabeca01 = ellipsoid(frame = self.esqueleto, pos=(5,1,0), length=10, height=9, width=8, color=color.green)
        cabeca02 = cone(frame = self.esqueleto, pos=(0,3,0), axis=(6,2,0), radius=3, color=color.green, opacity=1)
        boca = ring(frame = self.esqueleto, pos=(10,1,0), axis=(1,0,0), radius=1, thickness=0.5, color=color.red)
        olho01 = sphere(frame = self.esqueleto, pos=(5,4,3), radius=1, opacity=.5)
        olho02 = sphere(frame = self.esqueleto, pos=(5,4,3), radius=.5, color=color.black)
        olho11 = sphere(frame = self.esqueleto, pos=(5,4,-3), radius=1, opacity=.5)
        olho02 = sphere(frame = self.esqueleto, pos=(5,4,-3), radius=.5, color=color.black)
        corpo01 = sphere(frame = self.esqueleto, pos=(-1,0,0), radius=6, color = color.green, opacity=1)
        rabo1 = pyramid(frame = self.esqueleto, pos=(-12,0,0), size=(12,12,.3), color=color.green)
        rabo2 = pyramid(frame = self.esqueleto, pos=(-10,0,2), size=(6,6,.3), axis=(1,0,-0.4), color=color.blue)
        rabo3 = pyramid(frame = self.esqueleto, pos=(-10,0,-2), size=(6,6,.3), axis=(1,0,0.4), color=color.blue)
        dorsal1 = pyramid(frame = self.esqueleto, pos=(-4,4,0), size=(8,15,.3), axis=(2,.2,0),color=color.green)
        peitoralBE = pyramid(frame = self.esqueleto, pos=(-2,-1,9), size=(12,6,.3), axis=(2,.2,-4),color=color.blue)
        peitoralBB = pyramid(frame = self.esqueleto, pos=(-2,-1,-9), size=(12,6,.3), axis=(2,.2,4),color=color.blue)

    def proximoFrame(self):
        pass

class AguaViva(SerMarinho):
    def desenha(self, escala=1):
        u=escala/6.0
        r=6*u
        l=6*r
        direcoes = [-r,0,r]          
        
        self.cor1 = (0.2,0.3,0.4) 
        self.cor2 = color.white
        self.cor3 = (0.4,0.1,0.6) 
        self.cor4 = color.blue
        self.cor5 = color.red

        
        self.desenharElipse((0,0,0),3*escala,2*escala,3*escala,self.cor2,0.4)
        self.desenharElipse ((0,0.4*escala,0),2*escala,1.5*escala,2*escala,self.cor3,0.4)
        
        self.desenharElipse ((0,0,0),3*escala,2*escala,3*escala,self.cor3,0.4,materials.marble)
        
        self.desenharElipse ((0,-0.2*escala,1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.desenharElipse ((0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)
        self.desenharElipse ((0,-0.2*escala,-1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.desenharElipse ((-0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)

        self.desenharCilindro((0,-0.65*escala,0), (0,0.7*escala,0),1.479*escala,self.cor3,0.5)
        self.desenharCilindro((0,-1*escala,0),(0,0.7*escala,0),1.55*escala,self.cor3,0.5)

        self.desenharAnel((-0.1*escala,0,0),(0,0.5*escala,0.1*escala),1.3*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.3*escala,0),(0,0.5*escala,0.1*escala), 1.1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.5*escala,0),(0,0.5*escala,0.1*escala),1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((-0.1*escala,0.7*escala,0),(0,0.5*escala,0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.desenharAnel((0.1*escala,0,0),(0,0.5*escala,-0.1*escala),1.3*escala,0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.3*escala,0),(0,0.5*escala,-0.1*escala),1.1*escala,0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.5*escala,0), (0,0.5*escala,-0.1*escala), 1*escala, 0.002*escala,self.cor5)
        self.desenharAnel((0.1*escala,0.7*escala,0),(0,0.5*escala,-0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.desenharAnel((0.1*escala,1*escala,0),(0,0,0),0.5,0.004*escala,self.cor5)        

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
    def proximoFrame(self):
        pass

class Submarino (SerMarinho): 
    def desenha(self, escala=1):
        esc=escala

        # Desenha o Corpo Principal do Submarino
        corpo = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=10*esc, height=3*esc, width=3*esc, color = color.yellow)

        # Desenha a Ponte ( Passadiço ) do Submarino
        ponte = cylinder(frame = self.esqueleto, pos=(1*esc,0,0),axis=(0,3*esc,0), radius=1*esc, color = color.yellow)
        pontesup = cylinder(frame = self.esqueleto, pos=(1*esc,3*esc,0),axis=(0,0.4*esc,0*esc), radius=.4*esc, color = color.yellow)
        telescopio1 = cylinder(frame = self.esqueleto, pos=(1*esc,3.4*esc,0),axis=(0,0.6*esc,0), radius=.1*esc, color = color.yellow)
        telescopio2 = cylinder(frame = self.esqueleto, pos=(1*esc,3.9*esc,0),axis=(0.2*esc,0,0), radius=.1*esc, color = color.yellow)
        lemedaponte = box(frame = self.esqueleto, pos=(1*esc,2*esc,0), length=1*esc, height=0.05*esc, width=3*esc, color = color.yellow)

        # Desenha o leme de proa do Submarino
        lemedeproa = box(frame = self.esqueleto, pos=(3.5*esc,0*esc,0*esc), length=1*esc, height=0.05*esc, width=3.5*esc, color = color.yellow)

        # Desenha o leme de popa do Submarino
        popa1 = pyramid(frame = self.esqueleto, pos=(-4.5*esc,0,0), size=(1.5*esc,4*esc,0.1*esc), color = color.yellow )
        lemedapopa1 = box(frame = self.esqueleto, pos=(-5*esc,0,0), length=1*esc, height=4*esc, width=0.1*esc, color = color.yellow)
        popa2 = pyramid(frame = self.esqueleto, pos=(-4.5*esc,0,0), size=(1.5*esc,0.1*esc,4*esc), color = color.yellow )
        lemedapopa2 = box(frame = self.esqueleto, pos=(-5*esc,0,0), length=1*esc, height=0.1*esc, width=4*esc, color = color.yellow) 
        esteira = helix(frame = self.esqueleto, pos=(-5.8*esc,0,0), axis=(-3*esc,0,0), radius=1*esc)
        esteira2 = helix(frame = self.esqueleto, pos=(-5.8*esc,0,0), axis=(-3*esc,0,0), radius=0.5*esc)
    


'''
Não mexa aqui!
'''
if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()
