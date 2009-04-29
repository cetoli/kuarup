from visual import *
import Image
import ImageGrab


class Garrafa ():
    def __init__(self,escala=1, corGarrafa=color.green,corTampa=color.red, opacidade = 0.3,textura=materials.marble,**qualquer_parametro):

        self.esqueleto = frame(**qualquer_parametro)
        self.mat = textura
        
        corpo = cylinder(frame=self.esqueleto, pos=(0,0,0), axis=(5*escala,0,0), radius=1*escala, color = corGarrafa, opacity = opacidade, material = self.mat)
        bola = sphere(frame=self.esqueleto, pos=(5*escala,0,0), radius=1*escala, color = corGarrafa, opacity = opacidade, material = self.mat)
        gargalo = cylinder(frame=self.esqueleto, pos=(5*escala,0,0), axis=(1.5*escala,0,0), radius=0.3*escala, color = corGarrafa, opacity = opacidade, material = self.mat)
        tampa = cylinder(frame=self.esqueleto, pos=(6.5*escala,0,0), axis=(0.3*escala,0,0), radius=0.4*escala, color = corTampa, opacity = opacidade+0.4, material = self.mat)



g=Garrafa()
im = ImageGrab.grab((0,0,585,585))
fn = "Pangacio-teste-letramento-"+str(quadro)+".png"
im.save(fn)
