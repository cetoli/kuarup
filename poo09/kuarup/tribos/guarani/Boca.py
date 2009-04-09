from visual import *

class Boca():
    
    def __init__(self, peixe):
        
        self.escala = peixe.escala
        self.velocidade = 0.02 * peixe.escala
        self.sentido = 0
        self.amplitude = 0.25 * peixe.escala
        self.peixe = peixe

        self.labioSuperior = ellipsoid(frame = peixe.esqueleto, pos=(0.6*self.escala,-0.8*self.escala,0), length=self.escala*2.8, height=self.escala*0.3, width=self.escala*1.6, color=(0,0,1))
        
        self.labioInferior = ellipsoid(frame = peixe.esqueleto, pos=(0.8*self.escala,-0.37*self.escala,0), length=self.escala*2.8, height=self.escala*0.4, width=self.escala*1.6, color=(0,0,1))
        self.labioInferior.rotate(angle=-pi/4, axis=(0,0,1))
        
        self.dentesBaixo = ellipsoid(frame = peixe.esqueleto, pos=(0.7*self.escala,-0.37*self.escala,0), length=self.escala*2.8, height=self.escala*0.4, width=self.escala*1.6, color=(1,1,1))
        self.dentesBaixo.rotate(angle=-pi/5, axis=(0,0,1))
        
        self.dentesCima = ellipsoid(frame = peixe.esqueleto, pos=(0.52*self.escala,-0.69*self.escala,0), length=self.escala*2.8, height=self.escala*0.4, width=self.escala*1.6, color=(1,1,1))
        self.dentesCima.rotate(angle=-pi/20, axis=(0,0,1))
        
        self.posInicial = array(self.labioInferior.pos)

    def setVelocidade(self, velocidade):
        self.velocidade = velocidade / 1000
        if velocidade < 0 :
            self.velocidade = 1

    def proximoFrame(self):
        if self.sentido == 0 :  
            self.labioInferior.pos += (0, 0.1 * self.escala * self.velocidade, 0)
            self.dentesBaixo.pos += (0, 0.1 * self.escala * self.velocidade, 0)
        else :                          
            self.labioInferior.pos -= (0, 0.1 * self.escala * self.velocidade, 0)
            self.dentesBaixo.pos -= (0, 0.1 * self.escala * self.velocidade, 0)

        posAtual = array(self.labioInferior.pos)
        if(posAtual[1] >= self.posInicial[1] + self.amplitude) :
            self.sentido = not(self.sentido)
        elif(posAtual[1] < self.posInicial[1]) :
            self.sentido = not(self.sentido)
            
            
            
            