from visual import *

class Olho():
    
    def __init__(self, peixe, direita):
        
        if direita == 0 :
            self.lado = 1
        else : 
            self.lado = -1
        
        self.peixe = peixe
        self.escala = peixe.escala
        
        self.eye1 = sphere(frame = peixe.esqueleto, pos=(1.3*self.escala,0.6*self.escala,0.25*self.escala*self.lado), radius=self.escala*0.6, color=(1,1,1))
        self.iris1 = sphere(frame = peixe.esqueleto, pos=(1.7*self.escala,0.6*self.escala,0.5*self.escala*self.lado), radius=self.escala*0.2, color=(0.0,0.0,0.5))
        
