from visual import *
from Observer import Observer

class SerMarinho():
    '''

    Classe base de qualquer ser marinho

    '''
    def __init__(self, escala= 0.13, **qualquer_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto = frame(**qualquer_outro_parametro)
        self.desenha(escala)

    def desenha(self): pass


class PeixeEspada(SerMarinho, Observer):

    def __init__(self, x, y, escala= 0.09, macho=1, **qualquer_outro_parametro):
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
   
        if macho != 1 :
            self.colorirCorpo((0.95,0.7,0.85))
   
    def colorirCorpo(self, color):
        self.corpo.color = color
        self.labio.color = (1,0,0)
        

    def desenha(self, escala=1):
        #defino o corpo         
        self.corpo = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=11*escala, height=3*escala, width=4*escala , opacity=1)
        self.corpo.color = (0.75,0.75,0.75)
        
        #todo peixe espadarte tem uma proteburancia que sai da boca em formato de lanca      
        self.bocaLanca = ellipsoid(frame = self.esqueleto, pos=(6*escala,0.1*escala,0), length=6*escala, height=0.4*escala, width=0.4*escala, color=(0.7,0.7,0.7))
   
        #os olhos e suas respectivas pupilas
        self.olho1 = sphere (frame = self.esqueleto, pos=(4*escala,0,1.2*escala), radius=.25*escala, color=color.white, opacity=.9, material=materials.emissive)
        self.olho2 = sphere (frame = self.esqueleto, pos=(4*escala,0,-1.2*escala), radius=.25*escala, color=color.white, opacity=.9, material=materials.emissive)

        self.pupila1 = sphere (frame = self.esqueleto, pos=(4*escala, 0, 1.4*escala), radius=.1*escala, color=color.black)
        self.pupila2 = sphere (frame = self.esqueleto, pos=(4*escala,0,-1.4*escala), radius=.1*escala, color=color.black)

        #agora defino o rosto do peixe
        self.boca = ellipsoid(frame = self.esqueleto, pos=(5.30*escala,-0.08*escala,0), length=1*escala, height=0.4*escala, width=0.4*escala, color=(0,0,0))
        self.boca.rotate(angle=2*84, axis=(0,1*escala,0))

        self.labio = ring(frame = self.esqueleto, pos=(5*escala,0,0), axis=(1*escala,1*escala,0),radius=.55*escala, thickness=0.22*escala,color = (0.7,0.7,0.7))

        #agora so faltaram o rabo e as barbatanas         
        self.rabo = pyramid(frame = self.esqueleto, pos=(-7*escala,0,0), size=(5*escala,2.9*escala,0.01*escala),  axis = (1*escala,0,0))
        self.rabo.color = (0,1*escala,1*escala)

        self.barbatanaTraseira = pyramid(frame = self.esqueleto, pos=(-3.5*escala,1.13*escala,0), size=(4*escala,2*escala,0.01*escala),  axis = (1*escala,0,0))
        self.barbatanaTraseira.color = (0,1,1)

        self.barbatanaTraseiraInferior = pyramid(frame = self.esqueleto, pos=(-1.3*escala,-1.13*escala,0), size=(4*escala,2*escala,0.01*escala),  axis = (1*escala,0,0))
        self.barbatanaTraseiraInferior.color = (0,1,1)

        self.barbatanaDianteira = pyramid(frame = self.esqueleto, pos=(1.5*escala,1*escala,0.4*escala), size=(2*escala,2*escala,0.1*escala),  axis = (1*escala,0,0))
        self.barbatanaDianteira.color = (0,1,1)


    
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

        #self.cauda.proximoFrame()
        #self.corpo.proximoFrame()
        #self.topete.proximoFrame()
        #self.barbatanaDireita.proximoFrame()
        #self.barbatanaEsquerda.proximoFrame()
        #self.sobrancelhaEsquerda.proximoFrame()
        #self.sobrancelhaDireita.proximoFrame()
        #self.boca.proximoFrame()
        
    def estadoParado(self):
        pass
        #self.barbatanaDireita.setVelocidade(0.01)
        #self.barbatanaEsquerda.setVelocidade(0.01)
        #self.cauda.setVelocidade(0.1)
        #self.sobrancelhaEsquerda.setVelocidade(0.15)
        #self.sobrancelhaDireita.setVelocidade(0.15)
        
    def estadoNadando(self):
        pass
        #self.barbatanaDireita.setVelocidade(0.1)
        #self.barbatanaEsquerda.setVelocidade(0.1)
        #self.cauda.setVelocidade(1)
        #self.sobrancelhaEsquerda.setVelocidade(0.15)
        #self.sobrancelhaDireita.setVelocidade(0.15)

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

