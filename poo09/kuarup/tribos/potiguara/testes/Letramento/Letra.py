from visual import *

class Letra():

        estado = 0 # a letra ainda não foi selecionada, estado 1 - letra foi selecionada

        def __init__(self, escala= 1, carac = '', **qualquel_outro_parametro):
                "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
                self.esqueleto=frame(**qualquel_outro_parametro)
                self.posicaoX = self.esqueleto.x
                self.posicaoY = self.esqueleto.y
                self.desenha(escala,carac)
                #u=escala/6.0
                #r=6*u
                #l=6*r
                #direcoes = [-r,0,r]

        def desenha(self,escala=1,carac=''):
                #caixa = box (frame = self.esqueleto, pos=(1,1,1)*escala, color= color.white)
                caracter = label(frame=self.esqueleto)
                #caracter.x = #caixa.x + caixa.x/10
                #caracter.y = #caixa.y + caixa.y/10
                caracter.text = carac
                self.posicaoX = self.esqueleto.x
                self.posicaoY = self.esqueleto.y



