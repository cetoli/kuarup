"""
#######################
 Guajajaras - Detrito
#######################
:Author: Tribo Guajajaras
:Contact: Tribo Guajajaras(Mestrado - NCE/UFRJ)
:Date: $Date: 2009/05/04$
:Status: This is a "work in progress"
:Revision: $Revision: 1.0$
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""
from visual import *
TITLE = 'Detrito'

class Cenario:
      def principal(self):
          ancora = Ancora(escala =1, pos = (0,0,0), axis=(1,0,0))
          ancora.esqueleto.rotate(angle=pi/2, axis=(1,0,0))


class SerMarinho():
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)
    def desenha(self): pass
    
class Ancora(SerMarinho):
# Ancora
      def desenha(self, escala=1):
        esc=escala          
        tuboCorpo = cylinder(frame = self.esqueleto,pos=(0,12*esc,0), axis=(30*esc,0,0), radius=1*esc, color = (0.4,0.4,0.4), opacity = 1)
        tuboPonta1 = cylinder(frame = self.esqueleto,pos=(30*esc,2*esc,0), axis=(0,20,0), radius=1*esc, color = (0.4,0.4,0.4), opacity = 1)
        tuboPonta2 = cylinder(frame = self.esqueleto,pos=(30*esc,12*esc,-10*esc), axis=(0,0,20), radius=1*esc, color = (0.4,0.4,0.4), opacity = 1)
        tuboSuperior = cylinder(frame = self.esqueleto,pos=(10*esc,7*esc,0), axis=(0,10,0), radius=1*esc, color = (0.4,0.4,0.4), opacity = 1)
        pontaSup1 = pyramid(frame = self.esqueleto,pos=(30*esc,20*esc,0), size = (6*esc,6*esc,4*esc), axis=(-1,1,0), color = (0.4,0.4,0.4), opacity = 1)
        pontaInf1 = pyramid(frame = self.esqueleto,pos=(30*esc,3*esc,0), size = (6*esc,6*esc,4*esc), axis=(-1,-1,0), color = (0.4,0.4,0.4), opacity = 1)
        pontaEsq2 = pyramid(frame = self.esqueleto,pos=(30*esc,12*esc,-10*esc), size = (6*esc,6*esc,4*esc), axis=(-1,0,-1), color = (0.4,0.4,0.4), opacity = 1)
        pontaDir2 = pyramid(frame = self.esqueleto,pos=(30*esc,12*esc,10*esc), size = (6*esc,6*esc,4*esc), axis=(-1,0,1), color = (0.4,0.4,0.4), opacity = 1)

        base = ring(pos=(-3*esc,0,12*esc), axis=(0,1,0), radius=3*esc, thickness=1*esc, color = (0.4, 0.4, 0.4))
      def proximoFrame(self):
          pass

if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()

