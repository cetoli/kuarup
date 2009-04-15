from __future__ import division
from visual import *
import Image
from Eixo import *
from Ponto import *
from Posicao import *

from SerMarinho import *
from AcaraDisco import *
from AcaraDiscoControlador import *
from Nivel1State import *

# Classe que trata do canvas
class Mar:
    animais= None
    cenario= None

    posTela= Posicao ()

    taxa= 7

    MSG_FIM_SUCESSO= 'Parabens!!! Voce venceu seus inimigos.'
    MSG_FIM_PERDEU= 'Voce Perdeu!!! Nao conseguiu derrotar todos os inimigos.'

    def __init__ (self):
        #self.cenario= display (title='Oceano',width=150, height=150,center= (0.5,0,0),x=0, y=0, background=color.blue)
        self.cenario= display (title='Oceano',width=700, height=500,center= (0,0,0),x=0, y=0, background=color.blue)
        self.cenario.select ()
        self.cenario.visible= 1
        self.quadroInfo= None

        self.posTela.setPontoCima (-15, 10, 10)
        self.posTela.setPontoBaixo (15, -10, 10)

        #self.quadro = 0
        #scene.range = 3

    def criarPersonagemPrincipal (self):
        ponto= self.posTela.getPontoCima ()
        peixe= PeixeAcaraDisco (escala= 0.6, axis= (1,0,0), pos= (ponto.getX ()+5, 0, ponto.getZ ()))
        peixe.desenhar ()

        return peixe

    def exibirMsgJogo (self, msg, posicao= (0,0,0), cor= color.white):
        return label (pos= posicao, text= msg, xoffset=1, yoffset= 1, space= 1, height=15, border=3, color= cor, font='sans')

    def inicializar (self):
        acara= self.criarPersonagemPrincipal ()

        ctrlAcara= AcaraDiscoControlador (self.cenario)
        ctrlAcara.setAcara (acara)

        posicaoTela= self.posTela.clonar ()
        self.montarQuadro ()

        #posicaoTela.setPontoCima (-15, 1, -10)
        #posicaoTela.setPontoBaixo (15, -1, -10)
        ctrlAcara.setTela (posicaoTela)

        nivel= Nivel1State (ctrlAcara)

        # cria um tubarao para mostrar a tela ja como deve ficar depois

        """pos= nivel.gerarPosicaoAleatoria ()
        temp= nivel.criarTubarao (pos)
        rate (10)
        temp.matar ()"""

        return ctrlAcara, nivel

    def jogar (self):
        ctrlAcara, nivel= self.inicializar ()

        # Exibe a mensagem aguardando que se pressione qq tecla para o inicio do jogo
        msg= self.exibirMsgJogo ("Pressione qualquer tecla para comecar a jogar ...")
        ctrlAcara.esperarTecla ()
        msg.visible= 0
        msg= None

        ctrlAcara.iniciarThread ()

        while nivel != None:
            cont= 0
            qtdIteracaoNivel= nivel.getQtdIteracaoNivel ()
            taxa= nivel.getTaxaQuadros ()
            temPersonagem= 0

            nivel.inicializar ()

            while cont < qtdIteracaoNivel | temPersonagem > 0:
                self.exibirInformacoes (nivel)

                vivo= nivel.exibirProximoQuadro (cont)
                if vivo == 0:
                    # So para exibir 0 de vida
                    self.exibirInformacoes (nivel)
                    self.exibirMsgJogo (self.MSG_FIM_PERDEU)
                    return

                temPersonagem= nivel.getQtdPersonagens ()

                # rodando via thread
                """
                tecla= ctrlAcara.buscarTeclaPressionada ()
                if tecla != false:
                    ctrlAcara.tratarTeclaPessionada (tecla)
                """

                rate (taxa)

                cont+= 1

            #ctrlAcara.join ()
            nivel= nivel.passarProximoNivel ()
            """if nivel != None:
                msg= self.exibirMsgJogo ("Proximo nivel ...")
                rate (0.5) # 2 segundos de espera
                msg.visible= 0
            """
        self.exibirMsgJogo (self.MSG_FIM_SUCESSO)

    def exibirInformacoes (self, nivel):
        if self.quadroInfo != None:
            self.quadroInfo.visible= 0

        pontuacao= nivel.getPontuacao ()
        pontoC= self.posTela.getPontoCima ()
        pontoB= self.posTela.getPontoBaixo ()

        local= (pontoB.getX (), pontoC.getY ()+1.5, pontoC.getZ ())

        msg= nivel.getNomeNivel () + "    -     Vida: " + str (pontuacao.getVida ())
        self.quadroInfo= self.exibirMsgJogo (msg, local, color.white)

    def montarQuadro (self):
        pontoC= self.posTela.getPontoCima ()
        pontoB= self.posTela.getPontoBaixo ()

        xc, yc, zc= pontoC.getX (), pontoC.getY (), pontoC.getZ ()
        xb, yb, zb= pontoB.getX (), pontoB.getY (), pontoB.getZ ()

        dx= xb-xc
        dy= yc-yb
        dz= zb-zc

        h= 6
        w=1

        # cima
        box (pos= (xc+dx/2, yc+3, zb+5), length= dx, height= h, width= w, color= color.black)

        # baixo
        box (pos= (xc+dx/2, yb-3, zb+5), length= dx, height= h, width= w, color= color.black)

        # esquerda
        box (pos= (xc-h/2, yb+dy/2, zb+5), axis= (0,1,0), length= xb-xc+1, height= h, width= w, color= color.black)

        # direita
        box (pos= (xb+h/2, yb+dy/2, zb+5), axis= (0,1,0), length= xb-xc+1, height= h, width= w, color= color.black)


if __name__ == "__main__":
    mar= Mar ()
    mar.jogar ()


# fim
