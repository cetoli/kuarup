from NivelState import *
from Nivel2State import *

class Nivel1State (NivelState):

    def __init__ (self, acaraCtrl):
        NivelState.__init__(self, acaraCtrl)

        self.qtdIteracaoNivel= 120 # 60 segundos na taxa definida de 2 (0.5 segundos)
        self.qtdMaxPersonagens= 2
        self.velocidadePersonagem= 0.2
        self.taxa= 2 # 0,5 segundos
        self.porcentagemLixo= (40, 40, 20) # porcentagem saco, porcentagem bota, porcentagem pneu. Total= 100

    def inicializar (self):
        msg= self.exibirMsgJogo ("Para jogar pressione as setas.")
        rate (0.5) # 2 segundos de espera
        msg.visible= 0
        i= 0
        f= (self.qtdIteracaoNivel-3) /4
        cont= 0
        random= Random ()

        while (cont < 4) & (i <= f):
            valor= random.randint (i, f)
            self.posicoesLixo.append (valor)

            i= valor
            f= self.qtdIteracaoNivel / (4-cont)

            cont+= 1


    def criarPersonagem (self):
        tipo= self.gerarIntAleatorio (1, 100)
        posicao= self.gerarPosicaoAleatoriaSerMarinho ()

        if tipo <= 30:
            personagem= self.criarAguaViva (posicao)
        else:
            personagem= self.criarTubarao (posicao)

        self.adicionarPersonagem (personagem)


#    def criarPersonagens (self):
        #posicao= self.gerarPosicaoAleatoriaSerMarinho ()
        #pers= self.criarAguaViva (posicao)
        #self.adicionarPersonagem (pers)

#        personagem= self.criarTubarao (posicao)
 #       self.adicionarPersonagem (pers)

    def getNomeNivel (self):
        return "Nivel 1"

    def passarProximoNivel (self):
        nivel= Nivel2State (self.acaraController)
        nivel.setPontuacao (self.pontuacao)

        self.matarTodosPersonagens ()


        return nivel

# Fim