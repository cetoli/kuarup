'''
Created on 04/05/2009

@author: cfc
'''
from visual import *

class Detrito:

    def __init__(self, escala=1, **qualquel_outro_parametro):

        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"

        self.esqueleto = frame(**qualquel_outro_parametro)

        self.escala = escala

        self.desenha(escala)

    def desenha(self, escala=1):
     
        
        #defino o corpo         
        #letraB = label(pos=(-23,13,-30), text='2' ,box=0)
        #caixa11 = pyramid(pos=(0,0,0), axis=(0,5,0), size=(3,3,3), color = color.blue)
        #caixa21 = box(pos=(-15,13,-30), axis=(0,5,0), size=(3,3,3), color = color.magenta)
        #caixa31 = sphere(pos=(-10,13,-30), axis=(0,5,0), radius=2, color = color.green)
        #caixa41 = pyramid(pos=(-4,11,-30), axis=(0,5,0), size=(4,4,4), color = color.blue)
        #caixa51 = box(pos=(0,13,-30), axis=(0,5,0), size=(3,3,3), color = color.magenta)
        
        corpoPrincipal = box(frame=self.esqueleto,pos=(0,0,0),  size=(8,2.2,3),  color=color.white,material=materials.marble)
        traseira = box(frame=self.esqueleto,pos=(0,1,-2),  size=(8,4.25,1), color = color.white, material=materials.marble)
        
        bracoDireito=box(frame=self.esqueleto,pos=(-4,0.485,-1),  size=(0.5,3.2,3), color = color.gray(0.8), material=materials.marble)
        bracoEsquerdo=box(frame=self.esqueleto,pos=(4,0.485,-1),  size=(0.5,3.2,3), color = color.gray(0.8),material=materials.marble)
        buraco1 = ellipsoid(frame=self.esqueleto, axis=(1,0,2) ,pos=(-1, 0.7, 0), length=2.5 * escala, height=1 * escala, width=1 * escala , opacity=1)
        buraco1.color=color.black         
        mola1Buraco1 = helix(pos=(-1,0.7,0),thickness=0.05,  axis=(0,1,-0.5), radius=0.25,color=color.gray(1))
        mola2Buraco1 = helix(pos=(-1,0.7,0),thickness=0.05,  axis=(0,1,0.5), radius=0.25,color=color.gray(1))

        buraco2 = ellipsoid(frame=self.esqueleto, axis=(2,0,-1) ,pos=(2, 0.7, 0.8), length=1.75 * escala, height=1 * escala, width=1 * escala , opacity=1)
        buraco2.color=color.black 
        mola1Buraco2 = helix(pos=(2, 1, 0.8),thickness=0.05,  axis=(0,0.4,-0.6), radius=0.25,color=color.gray(1))

        '''
        
        corpo = ellipsoid(frame=self.esqueleto, pos=(0, 0, 0), length=11 * escala, height=3 * escala, width=4 * escala , opacity=1)
        corpo.color = (0.75, 0.75, 0.75)

         

        todo peixe espadarte tem uma proteburancia que sai da boca em formato de lanca      
        bocaLanca = ellipsoid(frame=self.esqueleto, pos=(6 * escala, 0.1 * escala, 0), length=6 * escala, height=0.4 * escala, width=0.4 * escala, color=(0.7, 0.7, 0.7))

         

        os olhos e suas respectivas pupilas

        olho1 = sphere (frame=self.esqueleto, pos=(4 * escala, 0, 1.2 * escala), radius=.25 * escala, color=color.white, opacity=.9, material=materials.emissive)
        olho2 = sphere (frame=self.esqueleto, pos=(4 * escala, 0, - 1.2 * escala), radius=.25 * escala, color=color.white, opacity=.9, material=materials.emissive)

        pupila1 = sphere (frame=self.esqueleto, pos=(4 * escala, 0, 1.4 * escala), radius=.1 * escala, color=color.black)
        pupila2 = sphere (frame=self.esqueleto, pos=(4 * escala, 0, - 1.4 * escala), radius=.1 * escala, color=color.black)

        agora defino o rosto do peixe
        boca = ellipsoid(frame=self.esqueleto, pos=(5.30 * escala, - 0.08 * escala, 0), length=1 * escala, height=0.4 * escala, width=0.4 * escala, color=(0, 0, 0))
        boca.rotate(angle=2 * 84, axis=(0, 1 * escala, 0))
        labio = ring(frame=self.esqueleto, pos=(5 * escala, 0, 0), axis=(1 * escala, 1 * escala, 0), radius=.55 * escala, thickness=0.22 * escala, color=(0.7, 0.7, 0.7))

        agora so faltaram o rabo e as barbatanas         
        rabo = pyramid(frame=self.esqueleto, pos=(-7 * escala, 0, 0), size=(5 * escala, 2.9 * escala, 0.01 * escala), axis=(1 * escala, 0, 0))
        rabo.color = (0, 1 * escala, 1 * escala)

        barbatanaTraseira = pyramid(frame=self.esqueleto, pos=(-3.5 * escala, 1.13 * escala, 0), size=(4 * escala, 2 * escala, 0.01 * escala), axis=(1 * escala, 0, 0))
        barbatanaTraseira.color = (0, 1, 1)
        barbatanaTraseiraInferior = pyramid(frame=self.esqueleto, pos=(-1.3 * escala, - 1.13 * escala, 0), size=(4 * escala, 2 * escala, 0.01 * escala), axis=(1 * escala, 0, 0))
        barbatanaTraseiraInferior.color = (0, 1, 1)
        barbatanaDianteira = pyramid(frame=self.esqueleto, pos=(1.5 * escala, 1 * escala, 0.4 * escala), size=(2 * escala, 2 * escala, 0.1 * escala), axis=(1 * escala, 0, 0))
        barbatanaDianteira.color = (0, 1, 1)
        '''
if __name__ == '__main__':
    cenario = Detrito(1)
    cenario.desenha(1)