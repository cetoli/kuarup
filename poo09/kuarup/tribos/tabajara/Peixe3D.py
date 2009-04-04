#Kuarup 2009 - IM/DCC/NCE
#Autor: Tribo Tabajara
#Personagem: Oscar, o peixinho inteligente
#O Astronotus ocellatus, tambem conhecido como Oscar ou Apaiari, eh considerado o peixe mais inteligente pelos aquaristas.
#Nativo da regiao amazonica, pode chegar a ate 45cm de comprimento.

from MovimentoThread import MovimentoThread
from TecladoThread import TecladoThread
from tribo_xerente import Caranguejo
from tribo_guarani import Pinguim
from visual import *

class SerMarinho():
    '''
    Classe base de qualquer ser marinho
    '''
    def __init__(self, escala= 0.03, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto = frame(**qualquel_outro_parametro)
        self.desenha(escala)
    def desenha(self): pass

class Peixe3D(SerMarinho):

    def __init__(self, x, y, escala= 0.03, **qualquer_outro_parametro):
        SerMarinho.__init__(self, escala, **qualquer_outro_parametro)
        self.esqueleto.pos = (x, -y, 0)
        self.esqueleto.rotate(angle = pi / 2, axis = (1, 0, 0))
        # -1 - nao foi movido, 0 = esq , 1 = cima, 2 = direita, 3 = baixo
        self.setFoiMovido(-1)
        self.velocidade = 0.04
        self.axisInicial = array(self.esqueleto.axis)
        # 0 = esq, 1 = cima, 2 = dir, 3 = baixo
        self.sentido = 0
        self.esqueleto.rotate(angle = pi, axis = (0, 0, 1))

    def desenha(self, escala=1):

        e = escala

       #Corpo
        corpo = Corpo(self.esqueleto, (-1*e,0,0), 18*e, 12*e, 9*e, color.yellow, 1)

        #Olhos
        olho1 = Olho(self.esqueleto, (7.3*e,1.2*e,1.4*e), 0.7*e, color.blue, (8*e,1.4*e,1.7*e), color.black, (6.5*e,1*e,1*e), color.white)
        olho2 = Olho(self.esqueleto, (7.4*e,1.2*e,-1.25*e), 0.7*e, color.blue, (8*e,1.4*e,-1.4*e), color.black, (6.5*e,1*e,-1*e), color.white)

        #Dentes
        dente1 = Dente(self.esqueleto, (7.2*e,-2*e,-0.3*e), 0.5*e, 1*e, 0.5*e, color.white)
        dente2 = Dente(self.esqueleto, (7.2*e,-2*e,0.4*e), 0.5*e, 1*e, 0.5*e, color.white)

        #Oculos
        oculos = Oculos(self.esqueleto, color.blue, 0.1*e, (8*e,1.5*e,1.5*e), (5,1,0), 1.5*e, (8*e,1.5*e,-1.5*e), (5,1,0), 1.5*e, (5*e,2*e,2.9*e), (5*e,2*e,-2.9*e), (5,0,0), 0.1*e, 2.9*e)

        #Boca
        boca = Boca(self.esqueleto, (7.3*e,-1.5*e,0), 1*e, 1*e, 2*e, color.red)

        #Nariz
        nariz = Nariz(self.esqueleto, (8.3*e,-.4*e,0), (8.3*e,-.3*e,0), 2*e, .5*e, .7*e, color.blue)

        #Barbatanas
        self.barbatana_peitoral_direita = Barbatana(self.esqueleto, (2*e,1*e,3*e), (8*e,3*e,.3*e), (-2,-2,1.5), color.blue, 0.6, 1*e) # 1 = direita
        self.barbatana_peitoral_esquerda = Barbatana(self.esqueleto, (2*e,1*e,-3*e), (8*e,3*e,.3*e), (-2,-2,-1.5), color.blue, 0.6, -1*e) # -1 = esquerda

        barbatana_dorsal_espinhosa1 = Barbatana(self.esqueleto, (3*e,5.7*e,0), (5*e,3*e,.3*e), (-2,-2,0), color.blue, 0.6, 0)
        barbatana_dorsal_espinhosa2 = Barbatana(self.esqueleto, (2*e,6*e,0), (5*e,3*e,.3*e), (-2,-2,0), color.blue, 0.6, 0)
        barbatana_dorsal_espinhosa3 = Barbatana(self.esqueleto, (1*e,5.5*e,0), (5*e,3*e,.3*e), (-2,-2,0), color.blue, 0.6, 0)

        self.barbatana_caudal = BarbatanaCaudal(self.esqueleto, (-15*e,1*e,0), (8*e,7*e,.3*e), (4*e,3*e,.5*e), color.yellow, color.black, 0.6, 1*e)

        barbatana_pelvica = Barbatana(self.esqueleto, (2*e,-4*e,0), (5*e,3*e,.3*e), (-2,-2,0), color.blue, 0.6, 0)
        barbatana_anal = Barbatana(self.esqueleto, (-4*e,-4*e,0), (5*e,3*e,.3*e), (-2,-2,0), color.blue, 0.6, 0)
        barbatana_dorsal_mole = Barbatana(self.esqueleto, (-3*e,6.5*e,0), (9*e,3*e,.3*e), (-2,-2,0), color.blue, 0.6, 0)


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

        self.barbatana_caudal.proximoFrame()
        self.barbatana_peitoral_direita.proximoFrame()
        self.barbatana_peitoral_esquerda.proximoFrame()

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
        self.foiMovido = direcao


class Corpo():

    def __init__(self, esqueleto, posicao, tamanho, altura, largura, cor, opacidade):
        self.esqueleto = esqueleto
        self.posicao = posicao
        self.tamanho = tamanho
        self.altura = altura
        self.largura = largura
        self.cor = cor
        self.opacidade = opacidade
        self.desenha()

    def desenha(self, escala=1):
        ellipsoid(frame = self.esqueleto, pos=self.posicao, length=self.tamanho, height=self.altura, width=self.largura, color=self.cor, opacity=self.opacidade)

class Barbatana():

    def __init__(self, esqueleto, posicao, tamanho, eixo, cor, opacidade, lado, escala = 1):
        self.escala = escala
        self.esqueleto = esqueleto
        self.posicao = posicao
        self.tamanho = tamanho
        self.eixo = eixo
        self.cor = cor
        self.opacidade = opacidade
        self.desenha()

        # atributos do movimento
        self.velocidade = 1.5
        self.sentido = 0
        self.amplitude = pi/10
        self.axisInicial = array(self.pyramid.axis)
        self.lado = lado


    def desenha(self, escala=1):
        self.pyramid = pyramid(frame = self.esqueleto, pos=self.posicao, size=self.tamanho, axis=self.eixo, color=self.cor, opacity=self.opacidade)

    def proximoFrame(self):
        # calcula a diferenca de angulo entre a cauda e a parte do corpo onde ela esta conectada
        axisInicial = vector(self.axisInicial[0], self.axisInicial[1], self.axisInicial[2])
        angulo = axisInicial.diff_angle(self.pyramid.axis)

        if(angulo > self.amplitude / 2.0) :
            self.sentido = not(self.sentido)

        if self.sentido == 0 :
            self.pyramid.rotate(angle = self.amplitude * self.velocidade * self.lado, axis = (0, 1, 0), origin = (0, -2 * self.escala, 0))
        elif self.sentido != 0 :
            self.pyramid.rotate(angle = -self.amplitude * self.velocidade * self.lado, axis = (0, 1, 0), origin = (0, -2 * self.escala, 0))

class BarbatanaCaudal():

    def __init__(self, esqueleto, posicao, tamanhoGrande, tamanhoPequena, corGrande, corPequena, opacidadeGrande, opacidadePequena, escala = 1):
        self.escala = escala
        self.esqueleto = esqueleto
        self.posicao = posicao
        self.tamanhoGrande = tamanhoGrande
        self.tamanhoPequena = tamanhoPequena
        self.corGrande = corGrande
        self.corPequena = corPequena
        self.opacidadeGrande = opacidadeGrande
        self.opacidadePequena = opacidadePequena

        self.desenha()

        # atributos do movimento
        self.velocidade = 0.03
        self.amplitude = pi/10
        # 0 pra um lado, 1 pro outro
        self.sentido = 0
        # guardar a posicao inicial da cauda que eh reta em relacao ao corpo
        self.axisInicial = array(self.pyramid1.axis)


    def desenha(self, escala=1):
        self.pyramid1 = pyramid(frame = self.esqueleto, pos=self.posicao, size=self.tamanhoGrande, color=self.corGrande, opacity=self.opacidadeGrande)
        self.pyramid2 = pyramid(frame = self.esqueleto, pos=self.posicao, size=self.tamanhoPequena, color=self.corPequena, opacity=self.opacidadePequena)
        #pintas_barbatana_caudal = points(pos=[(-15,3,0.3), (-15,3,-0.3), (-13,2,0.3), (-13,2,-0.3), (-15,-1,0.3), (-15,-1,-0.3), (-13,0,0.3), (-13,0,-0.3)], size=7, color=color.blue)

    # soh funciona pras barbatanas laterais
    def proximoFrame(self):
        # transformando o axis em vetor para poder usar a funcao diff_angle
        axisInicial = vector(self.axisInicial[0], self.axisInicial[1], self.axisInicial[2])
        # calcula a diferenca de angulo entre a cauda e o corpo do peixe
        angulo = axisInicial.diff_angle(self.pyramid1.axis)

        if(angulo > self.amplitude / 2.0) :
            self.sentido = not(self.sentido)

        x = -0.2
        if self.sentido == 0 :
            self.pyramid1.rotate(angle = self.amplitude * self.velocidade, axis = (0, 1, 0), origin = (x * self.escala, 0, 0))
            self.pyramid2.rotate(angle = self.amplitude * self.velocidade, axis = (0, 1, 0), origin = (x * self.escala, 0, 0))
        elif self.sentido != 0 :
            self.pyramid1.rotate(angle = -self.amplitude * self.velocidade, axis = (0, 1, 0), origin = (x * self.escala, 0, 0))
            self.pyramid2.rotate(angle = -self.amplitude * self.velocidade, axis = (0, 1, 0), origin = (x * self.escala, 0, 0))


class Olho():
    def __init__(self, esqueleto, posicaoIris, raioIris, corIris, posicaoPupila, corPupila, posicaoGlobo, corGlobo):
        self.esqueleto = esqueleto
        self.posicaoIris = posicaoIris
        self.raioIris = raioIris
        self.corIris = corIris
        self.posicaoPupila = posicaoPupila
        self.corPupila = corPupila
        self.posicaoGlobo = posicaoGlobo
        self.corGlobo = corGlobo
        self.desenha()

    def desenha(self, escala=1):
        sphere(frame = self.esqueleto, pos=self.posicaoIris, radius=self.raioIris, color = self.corIris)
        sphere(frame = self.esqueleto, pos=self.posicaoPupila, radius=self.raioIris*0.5, color = self.corPupila)
        sphere(frame = self.esqueleto, pos=self.posicaoGlobo, radius=self.raioIris*2, color = self.corGlobo)

class Dente():

    def __init__(self, esqueleto, posicao, tamanho, altura, largura, cor):
        self.esqueleto = esqueleto
        self.posicao = posicao
        self.tamanho = tamanho
        self.altura = altura
        self.largura = largura
        self.cor = cor
        self.desenha()

    def desenha(self, escala=1):
        box(frame = self.esqueleto, pos=self.posicao, length=self.tamanho, height=self.altura, width=self.largura, color=self.cor)

class Boca():

    def __init__(self, esqueleto, posicao, tamanho, altura, largura, cor):
        self.esqueleto = esqueleto
        self.posicao = posicao
        self.tamanho = tamanho
        self.altura = altura
        self.largura = largura
        self.cor = cor
        self.desenha()

    def desenha(self, escala=1):
        ellipsoid(frame = self.esqueleto, pos=self.posicao, length=self.tamanho, height=self.altura, width=self.largura, color=self.cor)

class Oculos():

    def __init__(self, esqueleto, cor, grossuraLente, posicaoLente1, eixoLente1, raioLente1, posicaoLente2, eixoLente2, raioLente2, posicaoPerna1, posicaoPerna2, eixoPerna, raioPerna, tamanhoPerna):
        self.esqueleto = esqueleto
        self.cor = cor
        self.grossuraLente = grossuraLente
        self.posicaoLente1 = posicaoLente1
        self.eixoLente1 = eixoLente1
        self.raioLente1 = raioLente1
        self.posicaoLente2 = posicaoLente2
        self.eixoLente2 = eixoLente2
        self.raioLente2 = raioLente2
        self.posicaoPerna1 = posicaoPerna1
        self.posicaoPerna2 = posicaoPerna2
        self.eixoPerna = eixoPerna
        self.raioPerna = raioPerna
        self.tamanhoPerna = tamanhoPerna
        self.desenha()

    def desenha(self, escala=1):
        ring(frame = self.esqueleto, pos=self.posicaoLente1, axis=self.eixoLente1, radius=self.raioLente1, thickness=self.grossuraLente, color=self.cor)
        ring(frame = self.esqueleto, pos=self.posicaoLente2, axis=self.eixoLente2, radius=self.raioLente2, thickness=self.grossuraLente, color=self.cor)
        cylinder(frame = self.esqueleto, pos=self.posicaoPerna1, axis=self.eixoPerna, radius=self.raioPerna, length=self.tamanhoPerna, color=self.cor)
        cylinder(frame = self.esqueleto, pos=self.posicaoPerna2, axis=self.eixoPerna, radius=self.raioPerna, length=self.tamanhoPerna, color=self.cor)

class Nariz():

    def __init__(self, esqueleto, posicaoCima, posicaoBaixo, tamanho, altura, largura, cor):
        self.esqueleto = esqueleto
        self.posicaoCima = posicaoCima
        self.posicaoBaixo = posicaoBaixo
        self.tamanho = tamanho
        self.altura = altura
        self.largura = largura
        self.cor = cor
        self.desenha()

    def desenha(self, escala=1):
        ellipsoid(frame = self.esqueleto, pos=self.posicaoCima, length=self.tamanho, height=self.altura, width=self.largura, color=self.cor)
        ellipsoid(frame = self.esqueleto, pos=self.posicaoBaixo, length=self.tamanho, height=self.altura, width=self.largura, color=self.cor)


if __name__ == "__main__":

    cenario = Cenario()
    #cenario.principal()
    