from visual import *
from Letra import *
from time import sleep

class Posicionador():
    def __init__(self,letra):
        self.letraAnterior = 0
        self.auxAcesso = 0
        self.exibe(letra)
        
    def exibe(self,letra):

        if (letra.estado == 0):
            remontagem = letra
            
            if (self.auxAcesso == 1):
                remontagem.esqueleto.x = self.letraAnterior.esqueleto.x + 15
                print 'Selecionador, entrou no if'
                print remontagem.esqueleto.x
            else: #primeiro acesso da classe
                remontagem.esqueleto.x = -67
                self.auxAcesso = 1

            remontagem.esqueleto.y += 20
            remontagem.estado = 1 # a letra foi selecionada
#            remontagem.letraAnterior = self.letraAnterior
            self.letraAnterior = remontagem
        else:
            remontagem = letra

            self.letraAnterior = Letra(escala=1,pos=(-82.5,0,0),visible=0,carac='0')
            self.letraAnterior.esqueleto.x = remontagem.esqueleto.x - 15
            self.letraAnterior.esqueleto.y = remontagem.esqueleto.y
            
            remontagem.esqueleto.x = letra.posicaoX #restaura a posicao inicial da letra
            remontagem.esqueleto.y = letra.posicaoY #restaura a posicao inicial da letra
            letra.estado = 0

'''
Montar um Anterior para saber onde acrescentar o próximo
Montar um Array para guardar os espaços com brechas
'''

