from visual import *

TITLE = 'Domino 3 4'

'''
Classe base de qualquer ser marinho
'''
class SerMarinho():
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto = frame(**qualquel_outro_parametro)
        self.desenha(escala)

    def desenha(self): pass


class domino34(SerMarinho): 
    def desenha(self, escala=1):
        A1 = box(frame = self.esqueleto, pos=( 0, 0, 0), length=16, height=3,width=28, color = color.white, opacity=1)
        A4 = box(frame = self.esqueleto, pos=( 0, 1.1, 0), length=16, height=1,width=1, color = color.black, opacity=1)

        #A2 = cylinder(frame = self.esqueleto, pos=(4,1.1,-10), axis=(0,1,0), radius=1, color = color.blue, opacity=1)
        #A3 = cylinder(frame = self.esqueleto, pos=(-4,1.1,-3), axis=(0,1,0), radius=1, color = color.blue, opacity=1)
        #A2 = cylinder(frame = self.esqueleto, pos=(4,1.1,3), axis=(0,1,0), radius=1, color = color.blue, opacity=1)
        #A3 = cylinder(frame = self.esqueleto, pos=(-4,1.1,10), axis=(0,1,0), radius=1, color = color.blue, opacity=1)
        #A2 = cylinder(frame = self.esqueleto, pos=(0,1.1,-7), axis=(0,1,0), radius=1, color = color.blue, opacity=1)
        A2 = cylinder(frame = self.esqueleto, pos=(4,1.1,-10), axis=(0,1,0), radius=1, color = color.blue, opacity=1)
        A3 = cylinder(frame = self.esqueleto, pos=(0,1.1,-7), axis=(0,1,0), radius=1, color = color.blue, opacity=1)
        A3 = cylinder(frame = self.esqueleto, pos=(-4,1.1,-3), axis=(0,1,0), radius=1, color = color.blue, opacity=1)
        
        A2 = cylinder(frame = self.esqueleto, pos=(4,1.1,3), axis=(0,1,0), radius=1, color = color.red, opacity=1)
        A3 = cylinder(frame = self.esqueleto, pos=(-4,1.1,3), axis=(0,1,0), radius=1, color = color.red, opacity=1)
        A2 = cylinder(frame = self.esqueleto, pos=(4,1.1,10), axis=(0,1,0), radius=1, color = color.red, opacity=1)
        A3 = cylinder(frame = self.esqueleto, pos=(-4,1.1,10), axis=(0,1,0), radius=1, color = color.red, opacity=1)

        
        

    def proximoFrame(self):
        pass
