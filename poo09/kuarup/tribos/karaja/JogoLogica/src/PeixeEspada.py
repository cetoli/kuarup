from visual import *
from SerMarinho import *

class PeixeEspada(SerMarinho):
    
    def desenha(self, escala=1):
     

        #defino o corpo         

        corpo = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=11*escala, height=3*escala, width=4*escala , opacity=1)
        corpo.color = (0.75,0.75,0.75)

         

        #todo peixe espadarte tem uma proteburancia que sai da boca em formato de lanca      
        bocaLanca = ellipsoid(frame = self.esqueleto, pos=(6*escala,0.1*escala,0), length=6*escala, height=0.4*escala, width=0.4*escala, color=(0.7,0.7,0.7))

         

        #os olhos e suas respectivas pupilas

        olho1 = sphere (frame = self.esqueleto, pos=(4*escala,0,1.2*escala), radius=.25*escala, color=color.white, opacity=.9, material=materials.emissive)
        olho2 = sphere (frame = self.esqueleto, pos=(4*escala,0,-1.2*escala), radius=.25*escala, color=color.white, opacity=.9, material=materials.emissive)

        pupila1 = sphere (frame = self.esqueleto, pos=(4*escala, 0, 1.4*escala), radius=.1*escala, color=color.black)
        pupila2 = sphere (frame = self.esqueleto, pos=(4*escala,0,-1.4*escala), radius=.1*escala, color=color.black)

        #agora defino o rosto do peixe
        boca = ellipsoid(frame = self.esqueleto, pos=(5.30*escala,-0.08*escala,0), length=1*escala, height=0.4*escala, width=0.4*escala, color=(0,0,0))
        boca.rotate(angle=2*84, axis=(0,1*escala,0))
        labio = ring(frame = self.esqueleto, pos=(5*escala,0,0), axis=(1*escala,1*escala,0),radius=.55*escala, thickness=0.22*escala,color = (0.7,0.7,0.7))

        #agora so faltaram o rabo e as barbatanas         
        rabo = pyramid(frame = self.esqueleto, pos=(-7*escala,0,0), size=(5*escala,2.9*escala,0.01*escala),  axis = (1*escala,0,0))
        rabo.color = (0,1*escala,1*escala)

        barbatanaTraseira = pyramid(frame = self.esqueleto, pos=(-3.5*escala,1.13*escala,0), size=(4*escala,2*escala,0.01*escala),  axis = (1*escala,0,0))
        barbatanaTraseira.color = (0,1,1)
        barbatanaTraseiraInferior = pyramid(frame = self.esqueleto, pos=(-1.3*escala,-1.13*escala,0), size=(4*escala,2*escala,0.01*escala),  axis = (1*escala,0,0))
        barbatanaTraseiraInferior.color = (0,1,1)
        barbatanaDianteira = pyramid(frame = self.esqueleto, pos=(1.5*escala,1*escala,0.4*escala), size=(2*escala,2*escala,0.1*escala),  axis = (1*escala,0,0))
        barbatanaDianteira.color = (0,1,1)
        
    
    def proximoFrame(self):
        pass
