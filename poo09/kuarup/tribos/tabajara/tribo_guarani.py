from visual import *

TITLE = 'Pinguim'

class Cenario:

    def __init__(self):
        scene2 = display(title=TITLE,
            #width=150, height=150,
            center= (0,0,0),
            x=0, y=0)
        scene2.x, scene2.y =0,0
        scene2.select()
        scene2.autoscale = 1
        self.quadro = 0

    def principal(self):
        pinguim1=Pinguim(escala =2  , pos= (0,0,0), axis=(0.1,0,0.2))
        pinguim2=Pinguim(escala =1.2  , pos= (-6,-2.5,7), axis=(40,0,1))
        pinguim3=Pinguim(escala =0.8, pos= (7,-3.5,-3), axis=(0.4,0,1))


class SerMarinho():
    '''

    Classe base de qualquer ser marinho

    '''
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto = frame(**qualquel_outro_parametro)
        self.desenha(escala)

    def desenha(self): pass


class Pinguim(SerMarinho):

    def desenha(self, escala=1):
        corpoPartePreta = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=escala*3.7, height=escala*7, width=escala*4.2, color=(0.4,0.4,0.4))
        corpoParteBranca = ellipsoid(frame = self.esqueleto, pos=(0.2*escala,0,0), length=escala*3.7, height=escala*6.5, width=escala*4.1, color=(1,1,1))
        
        cabecaPartePreta = ellipsoid(frame = self.esqueleto, pos=(0,2.5*escala,0), length=escala*3, height=escala*3.9, width=escala*3, color=(0.4,0.4,0.4))
        cabecaParteBranca = ellipsoid(frame = self.esqueleto, pos=(0.1*escala,2.5*escala,0), length=escala*3, height=escala*3.6, width=escala*2.9, color=(1,1,1))
        
        olhoEsquerdo = sphere(frame = self.esqueleto, pos=(1.3*escala,3.2*escala,0.3*escala), radius=escala*0.2, color=(1,1,1))
        irisEsquerda = sphere(frame = self.esqueleto, pos=(1.44*escala,3.2*escala,0.3*escala), radius=escala*0.1, color=(0,0,0))
        
        olhoDireito = sphere(frame = self.esqueleto, pos=(1.3*escala,3.2*escala,-0.3*escala), radius=escala*0.2, color=(1,1,1))
        irisDireita = sphere(frame = self.esqueleto, pos=(1.44*escala,3.2*escala,-0.3*escala), radius=escala*0.1, color=(0,0,0))
        
        bicoSuperior = pyramid(frame = self.esqueleto, pos=(1.4*escala,2.9*escala,0), size=(1*escala,1.4*escala,0.05*escala), color=(0.7,0.7,0))
        bicoSuperior.rotate(angle=pi/2, axis=(1,0,0))
        
        bicoInferior = pyramid(frame = self.esqueleto, pos=(1.4*escala,2.9*escala,0), size=(1*escala,1.4*escala,0.05*escala), color=(0.7,0.7,0))
        bicoInferior.rotate(angle=pi/2, axis=(1,0,0))
        bicoInferior.rotate(angle=-pi/7, axis=(0,0,1))
        
        lingua = pyramid(frame = self.esqueleto, pos=(1.4*escala,2.91*escala,0), size=(0.7*escala,0.9*escala,0.05*escala), color=(0.7,0.1,0.3))
        lingua.rotate(angle=pi/2, axis=(1,0,0))
        lingua.rotate(angle=-pi/7, axis=(0,0,1))
        
        sobrancelhaEsquerda = box(frame = self.esqueleto, pos=(1.3*escala,3.5*escala,0.4*escala), length=escala*0.05, height=escala*0.08, width=escala*0.55, color=(0.4,0.4,0.4))
        sobrancelhaEsquerda.rotate(angle=-pi/6, axis=(0,1,0))
        sobrancelhaEsquerda.rotate(angle=-pi/20, axis=(1,0,0))
        
        sobrancelhaDireita = box(frame = self.esqueleto, pos=(1.3*escala,3.5*escala,-0.4*escala), length=escala*0.05, height=escala*0.08, width=escala*0.55, color=(0.4,0.4,0.4))
        sobrancelhaDireita.rotate(angle=+pi/6, axis=(0,1,0))
        sobrancelhaDireita.rotate(angle=+pi/20, axis=(1,0,0))
        
        pataEsquerda = pyramid(frame = self.esqueleto, pos=(1.5*escala,-3*escala,1.4*escala), size=(2*escala,1.5*escala,0.2*escala), color=(0.5,0.5,0))
        pataEsquerda.rotate(angle=pi/2, axis=(1,0,0))
        pataEsquerda.rotate(angle=pi/1.3, axis=(0,1,0))
        
        pataDireita = pyramid(frame = self.esqueleto, pos=(1.5*escala,-3*escala,-1.4*escala), size=(2*escala,1.5*escala,0.2*escala), color=(0.5,0.5,0))
        pataDireita.rotate(angle=pi/2, axis=(1,0,0))
        pataDireita.rotate(angle=-pi/1.3, axis=(0,1,0))
        
        anteBracoEsquerdo = box(frame = self.esqueleto, pos=(0.3*escala,1*escala,2*escala), length=escala*0.7, height=escala*0.05, width=escala*3, color=(0.4,0.4,0.4)) 
        anteBracoEsquerdo.rotate(angle=pi/3, axis=(1,0,0))
        
        anteBracoDireito = box(frame = self.esqueleto, pos=(0.3*escala,1*escala,-2*escala), length=escala*0.7, height=escala*0.05, width=escala*3, color=(0.4,0.4,0.4)) 
        anteBracoDireito.rotate(angle=-pi/3, axis=(1,0,0))
        

if __name__ == "__main__":
    cenario= Cenario()
    cenario.principal()