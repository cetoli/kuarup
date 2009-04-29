from visual import *
import Image
import ImageGrab


class Bota ():
    def __init__(self,escala=1, corSolado=(0.2,0.2,0.2),corBota=(0.4,0.3,0.1), opacidade = 0.5,textura=materials.marble,**qualquer_parametro):

        self.esqueleto = frame(**qualquer_parametro)        
        self.cor1 = corSolado
        self.cor2 = corBota
        #self.mat = materials.unshaded #marble
        self.mat = textura
        
        #parte de cima da bota
        r = ring(frame=self.esqueleto,pos=(1*escala,1*escala,1*escala), axis=(0,1*escala,0), radius=0.35*escala, thickness=0.2*escala,color=self.cor2,material=self.mat)

        #cano da bota
        rod = cylinder(frame=self.esqueleto,pos=(1*escala,-0.6*escala,1*escala),axis=(0,1.5*escala,0), radius=0.5*escala,color=self.cor2,material=self.mat)
        rod2 = cylinder(frame=self.esqueleto,pos=(1*escala,0.55*escala,1*escala),axis=(0,0.4*escala,0), radius=0.55*escala,color=self.cor2,material=self.mat)
        rod2_1 = cylinder(frame=self.esqueleto,pos=(-0.25*escala,-0.42*escala,1*escala),axis=(0,0.3*escala,0), radius=0.45*escala,color=self.cor2,material=self.mat)# parte da frente da bota

        #solado
        rod3 = cylinder(frame=self.esqueleto,pos=(1*escala,-0.7*escala,0.7*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)# cone de trás
        rod4 = cylinder(frame=self.esqueleto,pos=(1.3*escala,-0.7*escala,0.9*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)# cone de trás
        rod5 = cylinder(frame=self.esqueleto,pos=(1.25*escala,-0.7*escala,1.2*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)# cone de trás
        rod6 = cylinder(frame=self.esqueleto,pos=(1*escala,-0.7*escala,1.3*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)# cone de trás
        rod7 = cylinder(frame=self.esqueleto,pos=(-0.19*escala,-0.6*escala,1*escala),axis=(0,0.3*escala,0), radius=0.5*escala,color=self.cor1,material=self.mat)# parte da frente da sola

        rod8 = cylinder(frame=self.esqueleto,pos=(-0.3*escala,-0.7*escala,0.7*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)
        rod9 = cylinder(frame=self.esqueleto,pos=(-0.1*escala,-0.7*escala,0.7*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)
        rod10 = cylinder(frame=self.esqueleto,pos=(0.1*escala,-0.7*escala,0.8*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)

        rod11 = cylinder(frame=self.esqueleto,pos=(-0.5*escala,-0.7*escala,1*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)
        rod12 = cylinder(frame=self.esqueleto,pos=(-0.3*escala,-0.7*escala,1.3*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)
        rod13 = cylinder(frame=self.esqueleto,pos=(-0.1*escala,-0.7*escala,1.3*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)
        rod14 = cylinder(frame=self.esqueleto,pos=(0.1*escala,-0.7*escala,1.2*escala),axis=(0,0.2*escala,0), radius=0.2*escala,color=self.cor1,material=self.mat)

        sola = ellipsoid(frame=self.esqueleto,pos=(0.3*escala,-0.57*escala,1*escala),length=1.75*escala, height=0.2*escala, width=0.78*escala,color=self.cor1,material=self.mat)
        solatras = ellipsoid(frame=self.esqueleto,pos=(1*escala,-0.52*escala,1*escala),length=1.1*escala, height=0.4*escala, width=1.1*escala,color=self.cor1,material=self.mat)

        c1 = ellipsoid(frame=self.esqueleto,pos=(0.3*escala,-0.2*escala,1*escala),length=2*escala, height=1*escala, width=1*escala,color=self.cor2,material=self.mat)
        c2 = ellipsoid(frame=self.esqueleto,pos=(0.9*escala,-0.15*escala,1*escala),length=1.3*escala, height=1*escala, width=1*escala,color=self.cor2,material=self.mat)

        # cadaços
        cadacoH = helix(pos=(0,0.05*escala,1*escala), axis=(0.7*escala,0,0), radius=0.3*escala, thickness=0.04*escala,color=corSolado,material=self.mat)
        cadacoV = helix(pos=(0.7,-0.1*escala,1*escala), axis=(0,0.7*escala,0), radius=0.3*escala, thickness=0.04*escala,color=corSolado,material=self.mat)
        #p1 = points(pos=[(-1,0,0), (1,0,0)], size=50, color=color.red)

cm=750.0
scene2 = display (title="Potiguara", width=600, height=600, background=(128/cm,128/cm,255/cm))
scene2.autoscale  = 60
scene2.select()
b = Bota()
im = ImageGrab.grab((0,0,585,585))
fn = "Pangacio-teste-letramento-"+str(quadro)+".png"
im.save(fn)
