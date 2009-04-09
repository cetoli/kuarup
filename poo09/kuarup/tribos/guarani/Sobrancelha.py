from visual import *

class Sobrancelha():
    
    def __init__(self, peixe, direita):
        
        if direita == 0 :
            self.lado = 1
        else : 
            self.lado = -1
        
        self.velocidade = 0.08
        self.sentido = 0
        self.amplitude = 0.18
        self.peixe = peixe
        self.escala = peixe.escala
        
        self.sobrancelha = box(frame = peixe.esqueleto, pos=(1.5*self.escala,1.3*self.escala,0.5*self.escala*self.lado), length=self.escala*0.1, height=self.escala*0.1, width=self.escala*0.7, color=(0.7,0.7,0))
        self.sobrancelha.rotate(angle=-pi/4*self.lado, axis=(0,1,0))
        self.sobrancelha.rotate(angle=pi/30 * self.lado, axis=(1,0,0))
        
        self.posInicial = array(self.sobrancelha.pos)
        
    def setVelocidade(self, velocidade):
        self.velocidade = velocidade
        if velocidade < 0 :
            self.velocidade = 1
        
    def setAmplitude(self, distancia):
        self.amplitude = distancia

    def proximoFrame(self):
        if self.sentido == 0 :  
            # levantar sobrancelha
            self.sobrancelha.pos += (0, 0.01 * self.escala * self.velocidade, 0)
        else :                          
            # baixar sobrancelha
            self.sobrancelha.pos -= (0, 0.01 * self.escala * self.velocidade, 0)

        posAtual = array(self.sobrancelha.pos)
        if(posAtual[1] >= self.posInicial[1] + self.amplitude) :
            self.sobrancelha.pos = (self.posInicial[0], self.posInicial[1] + self.amplitude, self.posInicial[2])
            self.sentido = not(self.sentido)
        elif(posAtual[1] < self.posInicial[1]) :
            self.sobrancelha.pos = (self.posInicial[0], self.posInicial[1], self.posInicial[2])
            self.sentido = not(self.sentido)
            
            
            
            
            
            