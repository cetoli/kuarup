from visual import *

TITLE = 'Submarino'

class Cenario:

    def __init__(self):

        scene2 = display(title=TITLE, width=150, height=150, center= (0,0,0), x=0, y=0)

        scene2.x, scene2.y =0,0

        scene2.select()

        scene2.autoscale = 1

        self.quadro = 0

    def principal(self):

        Submarino1=Submarino(escala =1, axis=(1,0,1.5), pos= (1,-3,0))

        Submarino2=Submarino(escala =0.2, axis=(1,0,3), pos= (-1,-4,2))

 

class SerMarinho():

    '''

    Classe base de qualquer ser marinho

    '''

    def __init__(self, escala= 1, **qualquel_outro_parametro):

        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"

        self.esqueleto=frame(**qualquel_outro_parametro)

        self.desenha(escala)

    def desenha(self): pass

 

 # Especialização da classe SerMarinho! Especializamos tanto que virou um Submarino ...

class Submarino (SerMarinho):

    '''

    Esta é o Submarino.

    '''

    def desenha(self, escala=1):

        esc=escala

 

        # Desenha o Corpo Principal do Submarino

        corpo = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=10*esc, height=3*esc, width=3*esc, color = color.yellow)

 

        # Desenha a Ponte ( Passadiço ) do Submarino

        ponte = cylinder(frame = self.esqueleto, pos=(1*esc,0,0),axis=(0,3*esc,0), radius=1*esc, color = color.yellow)

        pontesup = cylinder(frame = self.esqueleto, pos=(1*esc,3*esc,0),axis=(0,0.4*esc,0*esc), radius=.4*esc, color = color.yellow)

        telescopio1 = cylinder(frame = self.esqueleto, pos=(1*esc,3.4*esc,0),axis=(0,0.6*esc,0), radius=.1*esc, color = color.yellow)

        telescopio2 = cylinder(frame = self.esqueleto, pos=(1*esc,3.9*esc,0),axis=(0.2*esc,0,0), radius=.1*esc, color = color.yellow)

        lemedaponte = box(frame = self.esqueleto, pos=(1*esc,2*esc,0), length=1*esc, height=0.05*esc, width=3*esc, color = color.yellow)

 

        # Desenha o leme de proa do Submarino

        lemedeproa = box(frame = self.esqueleto, pos=(3.5*esc,0*esc,0*esc), length=1*esc, height=0.05*esc, width=3.5*esc, color = color.yellow)

 

        # Desenha o leme de popa do Submarino

        popa1 = pyramid(frame = self.esqueleto, pos=(-4.5*esc,0,0), size=(1.5*esc,4*esc,0.1*esc), color = color.yellow )

        lemedapopa1 = box(frame = self.esqueleto, pos=(-5*esc,0,0), length=1*esc, height=4*esc, width=0.1*esc, color = color.yellow)

        popa2 = pyramid(frame = self.esqueleto, pos=(-4.5*esc,0,0), size=(1.5*esc,0.1*esc,4*esc), color = color.yellow )

        lemedapopa2 = box(frame = self.esqueleto, pos=(-5*esc,0,0), length=1*esc, height=0.1*esc, width=4*esc, color = color.yellow)

        esteira = helix(frame = self.esqueleto, pos=(-5.8*esc,0,0), axis=(-3*esc,0,0), radius=1*esc)

        esteira2 = helix(frame = self.esqueleto, pos=(-5.8*esc,0,0), axis=(-3*esc,0,0), radius=0.5*esc)

 

 

if __name__ == "__main__":

    cenario= Cenario()

    cenario.principal()
