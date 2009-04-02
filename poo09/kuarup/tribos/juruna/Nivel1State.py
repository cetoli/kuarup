from NivelState import *
from Nivel2State import *

class Nivel1State (NivelState):

    def __init__ (self, acaraCtrl):
        NivelState.__init__(self, acaraCtrl)

        self.qtdIteracaoNivel= 120 # 60 segundos na taxa definida de 2 (0.5 segundos)
        self.qtdMaxPersonagens= 1
        self.velocidadePersonagem= 0.2
        self.taxa= 2 # 0,5 segundos

    def criarPersonagem (self):
        tipo= self.gerarIntAleatorio (1, 100)
        posicao= self.gerarPosicaoAleatoria ()

        if tipo <= 30:
            personagem= self.criarAguaViva (posicao)
        else:
            personagem= self.criarTubarao (posicao)

        self.adicionarPersonagem (personagem)


#    def criarPersonagens (self):
        #posicao= self.gerarPosicaoAleatoria ()
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