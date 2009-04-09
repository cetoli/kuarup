from visual import *

class Barbatana():
    
    def __init__(self, peixe, direita):
        
        if direita != 0 :
            self.lado = 1
        else : 
            self.lado = -1
        
        self.velocidade = 0.01
        self.sentido = 0
        self.amplitude = pi/10
        self.peixe = peixe
        self.escala = peixe.escala
        self.pos = (-1 * self.escala, -0.2 * self.escala, 2 * self.escala * self.lado )
        self.size = (2.5 * self.escala, 1 * self.escala, 0.2 * self.escala)
        self.color = (0.7, 0.7, 0)
        
        self.barbatana = pyramid(frame = peixe.esqueleto, pos = self.pos, size = self.size, color = self.color)
        self.barbatana.rotate(angle = +pi / 2 * self.lado, axis = (0, 1, 0))
        self.barbatana.rotate(angle = -pi / 5 * self.lado, axis = (1, 0, 0))
        self.barbatana.rotate(angle = -pi / 5 * self.lado, axis = (0, 1, 0))
        
        self.axisInicial = array(self.barbatana.axis)
        
    def setVelocidade(self, velocidade):
        self.velocidade = velocidade
        if velocidade < 0 :
            self.velocidade = 1

    def setAmplitude(self, angulo):
        self.amplitude = angulo

    def proximoFrame(self):
        # calcula a diferenca de angulo entre a cauda e a parte do corpo onde ela esta conectada
        axisInicial = vector(self.axisInicial[0], self.axisInicial[1], self.axisInicial[2])
        angulo = axisInicial.diff_angle(self.barbatana.axis)

        if(angulo > self.amplitude / 2.0) :
            self.sentido = not(self.sentido)
        
        if self.sentido == 0 :
            self.barbatana.rotate(angle = self.amplitude * self.velocidade * self.lado, axis = (0, 1, 0), origin = (0, -2, 0))
        elif self.sentido != 0 :
            self.barbatana.rotate(angle = -self.amplitude * self.velocidade * self.lado, axis = (0, 1, 0), origin = (0, -2, 0))
            