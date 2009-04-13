from visual import *

class Cauda():
    
    def __init__(self, peixe):
        
        self.velocidade = 0.01
        self.sentido = 0
        self.amplitude = pi/6
        self.peixe = peixe
        self.escala = peixe.escala
        self.size = (4.0 * self.escala, 2 * self.escala, 0.5 * self.escala)
        self.pos = (-5 * self.escala, 0, 0)
        self.color = (0.7, 0.7, 0)
        self.cauda = pyramid(frame = peixe.esqueleto, pos=self.pos, size = self.size, color=self.color)
        self.axisInicial = array(self.cauda.axis)

    def setVelocidade(self, velocidade):
        self.velocidade = velocidade / 12.0
        if velocidade < 0 :
            self.velocidade = 1

    def proximoFrame(self):
        axisInicial = vector(self.axisInicial[0], self.axisInicial[1], self.axisInicial[2])
        # calcula a diferenca de angulo entre a cauda e a parte do corpo onde ela esta conectada
        angulo = axisInicial.diff_angle(self.cauda.axis)

        if(angulo > self.amplitude / 2.0) :
            self.sentido = not(self.sentido)
        
        if self.sentido == 0 :
            self.cauda.rotate(angle = self.amplitude * self.velocidade, axis = (0, 1, 0), origin = (-3 * self.escala, 0, 0))
        elif self.sentido != 0 :
            self.cauda.rotate(angle = -self.amplitude * self.velocidade, axis = (0, 1, 0), origin = (-3 * self.escala, 0, 0))
            
            