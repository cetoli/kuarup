from NivelState import *

class Nivel3State (NivelState):

    def __init__ (self, acaraCtrl):
        NivelState.__init__(self, acaraCtrl)

        self.qtdIteracaoNivel= 180 # 45 segundos na taxa definida de 4 (0.25 segundos)
        self.qtdMaxPersonagens= 5
        self.velocidadePersonagem= 0.7
        self.taxa= 4 # 0,25 segundos

    def criarPersonagem (self):
        tipo= self.gerarIntAleatorio (1, 100)
        posicao= self.gerarPosicaoAleatoria ()

        if tipo <= 50:
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
        return "Nivel 3"

    def passarProximoNivel (self):
        return None

# Fim