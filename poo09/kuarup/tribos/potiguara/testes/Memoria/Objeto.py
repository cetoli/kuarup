from visual import *

class Objeto():

        estado = 0 # a letra ainda não foi selecionada, estado 1 - letra foi selecionada

        def __init__(self, escala= 1, obj = 'caixa',cor=color.blue,**qualquel_outro_parametro):
                "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
                self.esqueleto=frame(**qualquel_outro_parametro)
                self.posicaoX = self.esqueleto.x
                self.posicaoY = self.esqueleto.y
                self.escala = escala
                self.desenha(obj,cor)
                self.objeto
                #u=escala/6.0
                #r=6*u
                #l=6*r
                #direcoes = [-r,0,r]

        def desenha(self,obj='caixa',cor=color.blue):
                if (obj == 'caixa'):
                        self.objeto = box(frame=self.esqueleto,pos=(0,0,0),length=1*self.escala,height=1*self.escala,width=1*self.escala,color=cor)
                elif (obj == 'circulo'):
                        self.objeto = sphere(frame=self.esqueleto,pos=(0,0,0),radius=0.7*self.escala,color=cor)
                elif (obj == 'cone'):
                        self.objeto = cone(frame=self.esqueleto,pos=(0,-0.5*self.escala,0),axis=(0,1.1*self.escala,0),radius=0.8*self.escala,color=cor)
                elif (obj == 'cilindro'):
                        self.objeto = cylinder(frame=self.esqueleto,pos=(0,0,0),axis=(0,1.2*self.escala,0),radius=0.6*self.escala,color = cor)
                elif (obj == 'piramide'):
                        self.objeto = pyramid(frame=self.esqueleto,pos=(0,-0.5*self.escala,0), size=(1*self.escala,1.5*self.escala,1*self.escala),axis=(0,1*self.escala,0),color=cor)
                self.posicaoX = self.esqueleto.x
                self.posicaoY = self.esqueleto.y
        def apagarExibir(self,valor=1):
                self.objeto.opacity = valor
