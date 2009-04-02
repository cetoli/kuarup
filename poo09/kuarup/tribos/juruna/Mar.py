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

#from TartarugaMichelangelo import *


#from AguaViva import *
#from Tubarao import *

# Classe que trata do canvas
class Mar:
    animais= None
    cenario= None

    posTela= Posicao ()

    taxa= 7

    MSG_FIM_SUCESSO= 'Parabens!!! Voce soltou sua amada.'
    MSG_FIM_PERDEU= 'Voce Perdeu!!! Nao conseguiu soltar sua amada.'

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
        peixe= PeixeAcaraDisco (escala= 1, axis= (1,0,0), pos= (-15, 0, -10))
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
        pos= nivel.gerarPosicaoAleatoria ()
        temp= nivel.criarTubarao (pos)
        rate (10)
        temp.matar ()

        return ctrlAcara, nivel

    def jogar (self):
        ctrlAcara, nivel= self.inicializar ()

        # Exibe a mensagem aguardando que se pressione qq tecla para o inicio do jogo
        msg= self.exibirMsgJogo ("Pressione qualquer tecla para comecar a jogar ...")
        ctrlAcara.esperarTecla ()
        msg.visible= 0
        msg= None

        while nivel != None:
            cont= 0
            qtdIteracaoNivel= nivel.getQtdIteracaoNivel ()
            taxa= nivel.getTaxaQuadros ()

            while cont < qtdIteracaoNivel:
                self.exibirInformacoes (nivel)

                vivo= nivel.exibirProximoQuadro ()
                if vivo == 0:
                    # So para exibir 0 de vida
                    self.exibirInformacoes (nivel)
                    self.exibirMsgJogo (self.MSG_FIM_PERDEU)
                    return

                tecla= ctrlAcara.buscarTeclaPressionada ()
                print "###### tecla %s \n" % (tecla)

                if tecla != false:
                    ctrlAcara.tratarTeclaPessionada (tecla)

                rate (taxa)

                cont+= 1

            nivel= nivel.passarProximoNivel ()
            if nivel != None:
                msg= self.exibirMsgJogo ("Proximo nivel ...")
                rate (0.5) # 2 segundos de espera
                msg.visible= 0

        self.exibirMsgJogo (self.MSG_FIM_SUCESSO)

    def exibirInformacoes (self, nivel):
        if self.quadroInfo != None:
            self.quadroInfo.visible= 0

        pontuacao= nivel.getPontuacao ()
        pontoC= self.posTela.getPontoCima ()
        pontoB= self.posTela.getPontoBaixo ()

        local= (pontoB.getX (), pontoC.getY (), pontoC.getZ ())

        msg= nivel.getNomeNivel () + "    -     Vida: " + str (pontuacao.getVida ())
        self.quadroInfo= self.exibirMsgJogo (msg, local, color.red)

    def montarQuadro (self):
        pontoC= self.posTela.getPontoCima ()
        pontoB= self.posTela.getPontoBaixo ()

        xc, yc, zc= pontoC.getX (), pontoC.getY (), pontoC.getZ ()
        xb, yb, zb= pontoB.getX (), pontoB.getY (), pontoB.getZ ()

        dx= xb-xc
        dy= yc-yb
        dz= zb-zc

        # cima
        box (pos= (xc+dx/2, yc+1, zb+5), length= dx, height=2, width=1, color= color.black)

        # baixo
        box (pos= (xc+dx/2, yb-1, zb+5), length= dx, height=2, width=1, color= color.black)

        # esquerda
        box (pos= (xc, yb+dy/2, zb+5), axis= (0,1,0), length= xb-xc+1, height=10, width=1, color= color.black)

        # direita
        box (pos= (xb, yb+dy/2, zb+5), axis= (0,1,0), length= xb-xc+1, height=10, width=1, color= color.black)


if __name__ == "__main__":
    print "A FAZER: \n Testar o Command::estaDentroTela e descomentar os IFs\n"
    print "\nConclusao do a fazer:\n Chamar tubarao e agua viva"
    mar= Mar ()

    mar.jogar ()




"""
pontos:
superior esquerdo: -1.25, 1.4, -0.7
        direito: 1.25, 1.4, -0.7

inferior esquerdo: -1.25, -1.4, -0.7
        direito: 1.25, -1.4, -0.7

"""

"""
        self.animais= list ()

        peixe= PeixeAcaraDisco (escala= 1, axis= (-1,0,-1), pos= (14, 0, 10))
        self.animais.append (peixe)
        peixe.desenhar ()

        aguaViva= AguaViva (escala = self.ESCALA_AGUA_VIVA, axis=(0,0,1), pos= (8,0.5,4))
        aguaViva.desenha (aguaViva.escala)
        self.animais.append (aguaViva)

           tubarao= Tubarao(escala= self.ESCALA_TUBARAO, axis=(1,0,1), pos= (-1, 1,-5))
           tubarao.desenha (tubarao.escala)
           self.animais.append (tubarao)

    def getQtdAnimais (self):
        return self.animais.__len__();

    def getAnimal (self, pos):
        return self.animais.__getitem__(pos)



    def baterAguaViva (self, posBatida):
        # Vai de encontro com a agua viva
        self.animais[0].nadarPara (posBatida)
        rate (self.taxa)

    def aguaVivaIndoBocaTubarao (self, posFinalAguaViva):
        # seta a velocidade para 2X maior que o normal
        self.animais[1].setVelocidadeNado (1.3)

        # Voa para a boca do tubarao
        self.animais[1].nadarPara (posFinalAguaViva)

    def peixeFugir (self, pos1Peixe, posFinalPeixe):
        self.animais[0].nadarPara (pos1Peixe)
        self.animais[0].girarPara (-30, -10, Eixo.EIXO_Y)
        rate (self.taxa)
        self.animais[0].nadarPara (posFinalPeixe)

    def tubaraoTossir (self, pos):
        listaAngulo= [10, 350]
        self.animais[2].girar (listaAngulo[pos%2], Eixo.EIXO_Z)


    def fazerGraca (self):
        cont= 0
        listaAngulo= [10, 350]

        alturaCorpo= self.animais[0].corpo.corpo.height
        msg= label(pos= self.animais[0].esqueleto.pos, text='Na na na na', xoffset=30, yoffset= alturaCorpo, space= alturaCorpo, height=15, border=3, font='sans')

        while cont < 5:
            # danca para um lado
            angulo= listaAngulo[0]

            self.animais[0].girar (angulo, Eixo.EIXO_Y)
            self.tubaraoTossir (0)
            rate (self.taxa/2)

            # danca para o outro lado
            angulo= listaAngulo[1]

            self.animais[0].girar (angulo, Eixo.EIXO_Y)
            self.tubaraoTossir (1)
            rate (self.taxa/3)


            cont+= 1

        msg.visible= 0


    def tubaraoCuspirAguaViva (self, posAguaVivaBoca, posAguaViva):
        posicao= (posAguaViva[0]+2, posAguaViva[1]-1.5, posAguaViva[2])

        cuspe= list ()
        cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
        cuspe.append (cuspeTemp)

        posicao= (posAguaViva[0]+1.8, posAguaViva[1]-2, posAguaViva[2]-1)
        cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
        cuspe.append (cuspeTemp)

        posicao= (posAguaViva[0]+2.3, posAguaViva[1]-1.5, posAguaViva[2]+0.5)
        cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
        cuspe.append (cuspeTemp)

        posicao= (posAguaViva[0]+1.8, posAguaViva[1]-2, posAguaViva[2]+1)
        cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
        cuspe.append (cuspeTemp)

        posicao= (posAguaViva[0]+1.8, posAguaViva[1]-2, posAguaViva[2]+1.5)
        cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
        cuspe.append (cuspeTemp)

        posicao= (posAguaViva[0]+1, posAguaViva[1]-2, posAguaViva[2]+1.5)
        cuspeTemp= box (pos= posicao, length= 0.2, height= 0.2, width= 0.08, color= color.white)
        cuspe.append (cuspeTemp)

        rate (self.taxa)

        x= (posAguaViva[0] - posAguaVivaBoca[0])/2
        y= (posAguaViva[1] - posAguaVivaBoca[1])/2
        z= (posAguaViva[2] - posAguaVivaBoca[2])/2

        # move o cuspe
        cont= 0
        while cont < 2:
            # joga a agua viva pra fora da boca
            self.animais[1].esqueleto.pos+= (self.animais[1].esqueleto.pos[0]+x, self.animais[1].esqueleto.pos[1]+y, self.animais[1].esqueleto.pos[2]+z)

            # movimenta o cuspe junto com a agua viva
            for i in range(len(cuspe)):
                 cuspe[i].pos= (cuspe[i].pos[0] + x, cuspe[i].pos[1] + y, cuspe[i].pos[2] + z)

            rate (self.taxa)
            cont+= 1

        for i in range(len(cuspe)):
             cuspe[i].visible= 0

    def fugirTubarao (self):
        posTubarao= self.animais[2].esqueleto.pos
        posAguaViva= self.animais[1].esqueleto.pos

        # posTubarao e a posicao final da agua viva apos ser comida pelo tubarao
        posAguaVivaBoca= list ()
        posAguaVivaBoca.append (posTubarao[0]+ (20 * self.ESCALA_TUBARAO)/2)
        posAguaVivaBoca.append (posTubarao[1])
        posAguaVivaBoca.append (posTubarao[2]+ (23 * self.ESCALA_TUBARAO)/2)

        posBatida= list ()
        posBatida.append (posAguaViva[0] + (4 * self.ESCALA_AGUA_VIVA)/2)
        posBatida.append (posAguaViva[1])
        posBatida.append (posAguaViva[2] + (4 * self.ESCALA_AGUA_VIVA)/2)

        posFugaPeixe= list ()
        posFugaPeixe.append (posTubarao[0] * 3)
        posFugaPeixe.append (posTubarao[1])
        posFugaPeixe.append ((self.animais[0].esqueleto.pos[2] - self.animais[2].esqueleto.pos[2])/2)

        posFinalPeixe= list ()
        posFinalPeixe.append (posTubarao[0] * 19)
        posFinalPeixe.append (posTubarao[1])
        posFinalPeixe.append ((self.animais[0].esqueleto.pos[2] - self.animais[2].esqueleto.pos[2])/2)

        pos1Peixe= list ()
        pos1Peixe.append (posTubarao[0])
        pos1Peixe.append (posTubarao[1])
        pos1Peixe.append (self.animais[0].esqueleto.pos[2])


        self.baterAguaViva (posBatida)
        self.aguaVivaIndoBocaTubarao (posAguaVivaBoca)

        # vira para fugir
        self.animais[0].girar (30, Eixo.EIXO_Y)
        rate (self.taxa)

        # faz uma graca
        self.fazerGraca ()

        self.peixeFugir (pos1Peixe, posFugaPeixe)

        self.tubaraoCuspirAguaViva (posAguaVivaBoca, posAguaViva)

        self.animais[0].setVelocidade (3)
        self.animais[0].nadarPara (posFinalPeixe)

if __name__ == "__main__":
    mar= Mar ()
    mar.popular ()

    # so para preparar a gravacao
    rate (0.10)
    mar.fugirTubarao ()

    #mar.nadarAleatoriamente ()
"""

# fim
