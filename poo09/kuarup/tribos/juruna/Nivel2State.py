from NivelState import *
from Nivel3State import *

class Nivel2State (NivelState):

    def __init__ (self, acaraCtrl):
        NivelState.__init__(self, acaraCtrl)

        self.qtdIteracaoNivel= 130 # 45 segundos na taxa definida de 2.8 (0.35 segundos)
        self.qtdMaxPersonagens= 5
        self.velocidadePersonagem= 0.5
        self.taxa= 2.8 # 0.35 segundos

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
        return "Nivel 2"

    def passarProximoNivel (self):
        nivel= Nivel3State (self.acaraController)
        nivel.setPontuacao (self.pontuacao)

        self.matarTodosPersonagens ()

        return nivel

# Fim