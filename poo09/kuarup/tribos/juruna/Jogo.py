from visual import *
from AcaraDiscoControlador import *
from LogicaStrategy import *
from LetramentoStrategy import *
from MemoriaStrategy import *
from AtencaoStrategy import *

class Jogo:

    def __init__ (self):
        self.estrategia= None
        self.cenario= display (title='Jogos da Tribo Juruna',width=415, height=350, center= (0,0,0), x=0, y=0, background=color.black)
        #self.cenario= display (title='Jogos da Tribo Juruna',width=700, height=500, center= (0,0,0), x=0, y=0, background=color.black)
        self.cenario.select ()
        self.cenario.visible= 1
        self.quadroInfo= None

        #self.posTela.setPontoCima (-15, 10, 10)
        #self.posTela.setPontoBaixo (15, -10, 10)

    def exibirTiposJogos (self):
        self.acaraCtrl= AcaraDiscoControlador (self.cenario)

        msg1= self.exibirMsgJogo('Escolha o jogo:\n1- Memoria\n2- Atencao\n3- Letramento\n4- Logica', (0, 1, -2))
        msg2= self.exibirMsgJogo('Pressione um dos numeros listados acima de acordo com o jogo desejado ...', (-0.2, 0.6, -2))

        escolha= self.acaraCtrl.buscarTeclaPressionada ()
        while (escolha == false):
            rate (1) # dorme 1 segundo
            escolha= self.acaraCtrl.buscarTeclaPressionada ()

        msg1.visible= 0
        msg2.visible= 0

        return escolha

    def exibirMsgJogo (self, msg, posicao= (0,0,0), cor= color.white):
        return label (pos= posicao, text= msg, xoffset=1, yoffset= 1, space= 1, height=15, border=3, color= cor, font='sans')

    def criarTabuleiro (self, escolha):
        if escolha == "1":
            self.estrategia= MemoriaStrategy ()
        elif escolha == "2":
            self.estrategia= AtencaoStrategy ()
        elif escolha == "3":
            #self.estrategia= AtencaoStrategy ()
            self.estrategia= LetramentoStrategy ()
        elif escolha == "4":
            self.estrategia= LogicaStrategy ()

        peixe= self.estrategia.criarPeixe ()
        self.acaraCtrl.setAcara (peixe)
        self.acaraCtrl.setEstrategia (self.estrategia)

        posTabuleiro= self.estrategia.getPosicaoTabuleiro ()
        self.acaraCtrl.setTela (posTabuleiro)


    def jogar (self):
        self.tratarTecla ()
        while 1:
            if self.estrategia.jogar () == False:
                break


    def tratarTecla (self):
        tecla= self.acaraCtrl.iniciarThread ()


if __name__ == "__main__":
    jogo= Jogo ()
    escolha= jogo.exibirTiposJogos ()
    jogo.criarTabuleiro (escolha)
    jogo.jogar ()






# fim