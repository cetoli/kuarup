from visual import *
from Objeto import *
from time import sleep

class Posicionador():
    def __init__(self,obj):
        self.objAnterior = 0
        self.auxAcesso = 0
        self.exibe(obj)
        
    def exibe(self,obj):

        if (obj.estado == 0):
            remontagem = obj
            
            if (self.auxAcesso == 1):
                remontagem.esqueleto.x = self.objAnterior.esqueleto.x + 45
            else: #primeiro acesso da classe
                remontagem.esqueleto.x = -115
#                remontagem.esqueleto.y = 40 #posicao vertical(y) de amostragem das escolas
                self.auxAcesso = 1

            remontagem.esqueleto.y = 20
            remontagem.estado = 1 # a letra foi selecionada
            remontagem.escala = 15
#            remontagem.letraAnterior = self.letraAnterior
            self.objAnterior = remontagem
        else:
            remontagem = obj

            self.objAnterior = Objeto(escala=1,pos=(-82.5,0,0),visible=0)#observar esse trecho de código, pois foi reutilizado de letramento
            self.objAnterior.esqueleto.x = remontagem.esqueleto.x - 45
            self.objAnterior.esqueleto.y = remontagem.esqueleto.y
            
            remontagem.esqueleto.x = obj.posicaoX #restaura a posicao inicial da letra
            remontagem.esqueleto.y = obj.posicaoY #restaura a posicao inicial da letra
            remontagem.escala = 10
            obj.estado = 0

'''
Montar um Anterior para saber onde acrescentar o próximo
Montar um Array para guardar os espaços com brechas
'''
