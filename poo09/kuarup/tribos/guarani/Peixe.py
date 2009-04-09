from Observer import Observer
from visual import *

from Cauda import *
from Corpo import *
from Topete import *
from Barbatana import *
from Sobrancelha import *
from Boca import *
from Olho import *

class SerMarinho():
    '''

    Classe base de qualquer ser marinho

    '''
    def __init__(self, escala= 0.13, **qualquer_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto = frame(**qualquer_outro_parametro)
        self.desenha(escala)

    def desenha(self): pass


class Peixe(SerMarinho, Observer):

    def __init__(self, x, y, escala= 0.09, **qualquer_outro_parametro):
        SerMarinho.__init__(self, escala, **qualquer_outro_parametro)
        self.esqueleto.pos = (x, -y, 0)
        self.esqueleto.rotate(angle = pi / 2, axis = (1, 0, 0))
        # -1 - nao foi movido, 0 = esq , 1 = cima, 2 = direita, 3 = baixo
        self.setFoiMovido(-1)
        self.velocidade = 0.05
        self.axisInicial = array(self.esqueleto.axis)
        # 0 = esq, 1 = cima, 2 = dir, 3 = baixo
        self.sentido = 0
        self.esqueleto.rotate(angle = pi, axis = (0, 0, 1))



    def desenha(self, escala=1):
        self.escala = escala
        
        self.corpo = Corpo(self)
        self.cauda = Cauda(self)
        self.topete = Topete(self)
        self.barbatanaDireita = Barbatana(self, true)
        self.barbatanaEsquerda = Barbatana(self, false)
        self.sobrancelhaEsquerda = Sobrancelha(self, false)
        self.sobrancelhaDireita = Sobrancelha(self, true)
        self.boca = Boca(self)
        self.olhoDireito = Olho(self, true)
        self.olhoEsquerdo = Olho(self, false)

    def proximoFrame(self):

        # se nao foi movido, fazer nada
        if self.foiMovido == -1:
            pass

        # se foi movido para esquerda (0)
        elif self.foiMovido == 0:
            self.passoParaEsquerda()

        # se foi movido para cima (1)
        elif self.foiMovido == 1:
            self.passoParaCima()

        # se foi movido para direita (2)
        elif self.foiMovido == 2:
            self.passoParaDireita()

        # se foi movido para baixo (3)
        elif self.foiMovido == 3:
            self.passoParaBaixo()

        self.cauda.proximoFrame()
        self.corpo.proximoFrame()
        self.topete.proximoFrame()
        self.barbatanaDireita.proximoFrame()
        self.barbatanaEsquerda.proximoFrame()
        self.sobrancelhaEsquerda.proximoFrame()
        self.sobrancelhaDireita.proximoFrame()
        self.boca.proximoFrame()
        
    def estadoParado(self):
        self.barbatanaDireita.setVelocidade(0.01)
        self.barbatanaEsquerda.setVelocidade(0.01)
        self.cauda.setVelocidade(0.1)
        self.sobrancelhaEsquerda.setVelocidade(0.15)
        self.sobrancelhaDireita.setVelocidade(0.15)
        
    def estadoNadando(self):
        self.barbatanaDireita.setVelocidade(0.1)
        self.barbatanaEsquerda.setVelocidade(0.1)
        self.cauda.setVelocidade(1)
        self.sobrancelhaEsquerda.setVelocidade(0.15)
        self.sobrancelhaDireita.setVelocidade(0.15)

    def novoDestinoEsquerda(self):
        self.posDestino = self.esqueleto.pos - (1, 0, 0)
        self.setFoiMovido(0) # 0 = esquerda

    def novoDestinoCima(self):
        self.posDestino = self.esqueleto.pos + (0, 1, 0)
        self.setFoiMovido(1) # 1 = cima

    def novoDestinoDireita(self):
        self.posDestino = self.esqueleto.pos + (1, 0, 0)
        self.setFoiMovido(2) # 2 = direita

    def novoDestinoBaixo(self):
        self.posDestino = self.esqueleto.pos - (0, 1, 0)
        self.setFoiMovido(3) # 3 = baixo

    def apontarParaEsquerda(self):
        if self.sentido == 0 :
            pass
        elif self.sentido == 1 :
            self.esqueleto.rotate(angle = pi / 2, axis = (0, 0, 1))
        elif self.sentido == 2 :
            self.esqueleto.rotate(angle = pi, axis = (0, 0, 1))
        elif self.sentido == 3 :
            self.esqueleto.rotate(angle = - pi / 2, axis = (0, 0, 1))
        self.sentido = 0

    def apontarParaCima(self):
        if self.sentido == 0 :
            self.esqueleto.rotate(angle = - pi / 2, axis = (0, 0, 1))
        elif self.sentido == 1 :
            pass
        elif self.sentido == 2 :
            self.esqueleto.rotate(angle = pi / 2, axis = (0, 0, 1))
        elif self.sentido == 3 :
            self.esqueleto.rotate(angle = pi, axis = (0, 0, 1))
        self.sentido = 1
        
    def apontarParaDireita(self):
        if self.sentido == 0 :
            self.esqueleto.rotate(angle = pi, axis = (0, 0, 1))
        elif self.sentido == 1 :
            self.esqueleto.rotate(angle = - pi / 2, axis = (0, 0, 1))
        elif self.sentido == 2 :
            pass
        elif self.sentido == 3 :
            self.esqueleto.rotate(angle = pi / 2, axis = (0, 0, 1))
        self.sentido = 2

    def apontarParaBaixo(self):
        if self.sentido == 0 :
            self.esqueleto.rotate(angle = pi / 2, axis = (0, 0, 1))
        elif self.sentido == 1 :
            self.esqueleto.rotate(angle = pi, axis = (0, 0, 1))
        elif self.sentido == 2 :
            self.esqueleto.rotate(angle = - pi / 2, axis = (0, 0, 1))
        elif self.sentido == 3 :
            pass
        self.sentido = 3

    def passoParaEsquerda(self):
        self.apontarParaEsquerda()
        posAtual = array(self.esqueleto.pos)
        posDestino = array(self.posDestino)
        posAtual[0] -= self.velocidade
        if posAtual[0] <= posDestino[0]:
            posAtual[0] = posDestino[0]
            self.setFoiMovido(-1)
        self.esqueleto.pos = (posAtual[0], posAtual[1], posAtual[2])

    def passoParaCima(self):
        self.apontarParaCima()
        axisInicial = vector(self.axisInicial[0], self.axisInicial[1], self.axisInicial[2])
        angulo = axisInicial.diff_angle(self.esqueleto.axis)
        posAtual = array(self.esqueleto.pos)
        posDestino = array(self.posDestino)
        posAtual[1] += self.velocidade
        if posAtual[1] >= posDestino[1]:
            posAtual[1] = posDestino[1]
            self.setFoiMovido(-1)
        self.esqueleto.pos = (posAtual[0], posAtual[1], posAtual[2])

    def passoParaDireita(self):
        self.apontarParaDireita()
        axisInicial = vector(self.axisInicial[0], self.axisInicial[1], self.axisInicial[2])
        angulo = axisInicial.diff_angle(self.esqueleto.axis)
        posAtual = array(self.esqueleto.pos)
        posDestino = array(self.posDestino)
        posAtual[0] += self.velocidade
        if posAtual[0] >= posDestino[0]:
            posAtual[0] = posDestino[0]
            self.setFoiMovido(-1)
        self.esqueleto.pos = (posAtual[0], posAtual[1], posAtual[2])

    def passoParaBaixo(self):
        self.apontarParaBaixo()
        posAtual = array(self.esqueleto.pos)
        posDestino = array(self.posDestino)
        posAtual[1] -= self.velocidade
        if posAtual[1] <= posDestino[1]:
            posAtual[1] = posDestino[1]
            self.setFoiMovido(-1)
        self.esqueleto.pos = (posAtual[0], posAtual[1], posAtual[2])

    def getFoiMovido(self):
        return self.foiMovido

    def setFoiMovido(self, direcao):
        if direcao != -1 :
            self.estadoNadando()
        else :
            self.estadoParado()
        self.foiMovido = direcao

    def terminouMovimento(self):
        if self.getFoiMovido() == -1 :
            return 1
        return 0

    # Override de Observer
    def update(self, observable):
        data = observable.getState()
        destinoX = data[0]
        destinoY = data[1]
        posAtual = array(self.esqueleto.pos)

        posAtual[1] = -posAtual[1]

        # usei -0.5 posi estava tendo um bug onde
        # destinoX < posAtual[0]
        # dizia que  1.0 < 1.0 era verdadeiro
        # dai fazendo destinoX - posAtual[0] obtive 2.22044604925e-016

        # se foi movido pra esquerda
        if destinoX - posAtual[0] < -0.5:
            self.novoDestinoEsquerda()

        # se foi movido pra direita
        elif destinoX - posAtual[0] > 0.5 :
            self.novoDestinoDireita()

        # se foi movido pra cima
        elif destinoY - posAtual[1] < -0.5 :
            self.novoDestinoCima()

        # se foi movido pra baixo
        elif destinoY - posAtual[1] > 0.5 :
            self.novoDestinoBaixo()


if __name__ == "__main__":
    cenario= Cenario()
    cenario.principal()
    
    
