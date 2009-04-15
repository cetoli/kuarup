from NivelState import *
from Nivel4State import *

class Nivel3State (NivelState):

    def __init__ (self, acaraCtrl):
        NivelState.__init__(self, acaraCtrl)

        self.qtdIteracaoNivel= 180 # 45 segundos na taxa definida de 4 (0.25 segundos)
        self.qtdMaxPersonagens= 5
        self.velocidadePersonagem= 0.7
        self.taxa= 4 # 0,25 segundos
        self.porcentagemLixo= (50, 20, 30) # porcentagem saco, porcentagem bota, porcentagem pneu. Total= 100

    def criarPersonagem (self):
        tipo= self.gerarIntAleatorio (1, 100)
        posicao= self.gerarPosicaoAleatoriaSerMarinho ()

        if tipo <= 50:
            personagem= self.criarAguaViva (posicao)
        else:
            personagem= self.criarTubarao (posicao)

        self.adicionarPersonagem (personagem)

    def inicializar (self):
        msg= self.exibirMsgJogo ("Nivel 3 ...")
        rate (0.5) # 2 segundos de espera
        msg.visible= 0
        i= 0
        f= (self.qtdIteracaoNivel-3) /4
        cont= 0
        random= Random ()

        while (cont < 4) & (i <= f):
            valor= random.randint (i, f)
            self.posicoesLixo.append (valor)

            i= valor+ 3
            f= self.qtdIteracaoNivel/ (4-cont)

            cont+= 1


#    def criarPersonagens (self):
        #posicao= self.gerarPosicaoAleatoriaSerMarinho ()
        #pers= self.criarAguaViva (posicao)
        #self.adicionarPersonagem (pers)

#        personagem= self.criarTubarao (posicao)
 #       self.adicionarPersonagem (pers)

    def getNomeNivel (self):
        return "Nivel 3"

    def passarProximoNivel (self):
        nivel= Nivel4State (self.acaraController)
        nivel.setPontuacao (self.pontuacao)

        self.matarTodosPersonagens ()

        return nivel

# Fim