from Lixo import *
from visual import *

class SacoPlastico (Lixo):

    def __init__ (self, escala= 1, **complemento):
        Lixo.__init__ (self, escala, **complemento)

    def desenhar (self):
        self.velocidade= 0.1
        self.dano= 10

        x= self.esqueleto.pos[0]
        y= self.esqueleto.pos[1]
        z= self.esqueleto.pos[2]
        obj= box(frame= self.esqueleto, pos=(x,y,z), length=1.3*self.escala, height=1.5*self.escala, width=0.1*self.escala, opacity= 0.20, color= (0.75,0.75,0.75))
        self.elementos.append (obj)

        self.posicao.setPontoBaixo (x+obj.length, y-obj.height, z+obj.width)
        self.posicao.setPontoCima (x-obj.length, y+obj.height, z-obj.width)

        """ funcionou no teste
        self.posicao.setPontoBaixo (x+obj.length-10, y-obj.height, z+obj.width)
        self.posicao.setPontoCima (x-obj.length-10, y+obj.height, z-obj.width)
        """

        obj= label(frame= self.esqueleto, pos=(x,y,z), text='Batata', opacity= 0.20, color= (0.75,0.75,0.75), box= 0, border= 0)
        self.elementos.append (obj)


