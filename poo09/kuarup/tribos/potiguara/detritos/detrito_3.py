from visual import *
import Image
import ImageGrab


class Pneu ():
    def __init__(self,escala=1, corPneu1=color.black,corPneu2=(0.4,0.4,0.4), opacidade = 0.3,textura=materials.unshaded,**qualquer_parametro):

        self.esqueleto = frame(**qualquer_parametro)
        self.mat = textura
        
        p1 = ring(frame=self.esqueleto,pos=(1*escala,1*escala,1*escala), axis=(0,1*escala,0), radius=0.5*escala, thickness=0.2*escala,color=corPneu2,materials=textura)
        p2 = ring(frame=self.esqueleto,pos=(1*escala,1.1*escala,1*escala), axis=(0,0.2*escala,0), radius=0.3*escala, thickness=0.1*escala,color=corPneu2,materials=textura)
        p3 = ring(frame=self.esqueleto,pos=(1*escala,0.9*escala,1*escala), axis=(0,0.2*escala,0), radius=0.3*escala, thickness=0.1*escala,color=corPneu2,materials=textura)
        p4 = ring(frame=self.esqueleto,pos=(1*escala,1.1*escala,1*escala), axis=(0,0.2*escala,0), radius=0.67*escala, thickness=0.01*escala,color=corPneu1,materials=textura)
        p5 = ring(frame=self.esqueleto,pos=(1*escala,0.9*escala,1*escala), axis=(0,0.2*escala,0), radius=0.67*escala, thickness=0.01*escala,color=corPneu1,materials=textura)





p = Pneu()

im = ImageGrab.grab((0,0,585,585))
fn = "Pangacio-teste-letramento-"+str(quadro)+".png"
im.save(fn)


