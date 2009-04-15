from NivelState import *
from PeixeEspada import *
from SacoPlastico import *
from Pneu import *
from Bota import *
from Balde import *
#from LinhaPesca import *
#from RedePesca import *

"""
Nivel final onde o peixe espada e salvo.
"""
class Nivel4State (NivelState):


    def __init__ (self, acaraCtrl):
        NivelState.__init__(self, acaraCtrl)

        self.qtdIteracaoNivel= 2000
        self.qtdMaxPersonagens= 1
        self.velocidadePersonagem= 0.5
        self.taxa= 4 # 0,25 segundos
        self.peixeEspada= None
        self.armadilha= None
        self.batidas= 0

    def criarPersonagem (self):
        temp= self.posicaoTela.getPontoBaixo ()

        posicao= temp.clonar ()
        temp= self.posicaoTela.getPontoCima ()
        posicao.setX (temp.getX()+(posicao.getX()-temp.getX())/2)

        #posicao.setY (posicao.getY()+7.4)
        posicao.setY (posicao.getY()+8)

        personagem= self.criarPeixeEspada (posicao)
        self.adicionarPersonagem (personagem)

    def inicializar (self):
        msg= self.exibirMsgJogo ("Nivel 4, se choque com o balde para soltar o peixe espada ...")
        rate (0.5) # 2 segundos de espera
        msg.visible= 0
        self.criarPersonagem ()
        #self.moverAcara ()
        self.popularCenario ()

    def criar3Pneus (self, posicao):
        obj= self.criarPneu (posicao.getLista ())
        obj.girar (90, Eixo.EIXO_Z)
        obj.setVelocidade (0)
        self.adicionarLixo (obj)

        # 2 pneu
        posicao.setY (posicao.getY()+0.5)

        obj= self.criarPneu (posicao.getLista ())
        obj.girar (90, Eixo.EIXO_Z)
        obj.setVelocidade (0)
        self.adicionarLixo (obj)

        # 3 pneu
        posicao.setY (posicao.getY()+0.5)
        obj= self.criarPneu (posicao.getLista ())
        obj.girar (90, Eixo.EIXO_Z)
        obj.setVelocidade (0)
        self.adicionarLixo (obj)


    def popularCenario (self):
        tempPosBaixo= self.posicaoTela.getPontoBaixo ()
        tempPosCima= self.posicaoTela.getPontoCima ()

        posicao= tempPosBaixo.clonar ()

        xa= tempPosCima.getX ()+8

        temp= self.peixeEspada.getPosicao ()
        temp= temp.getPontoCima ()
        xi= temp.getX ()-6

        temp= self.peixeEspada.getPosicao ()
        temp= temp.getPontoBaixo ()
        xf= tempPosBaixo.getX ()+3

        posicaoPeixe= self.peixeEspada.getPosicao ()
        temp= posicaoPeixe.getPontoCima ()
        cont= 0
        y0= temp.getY()+5
        z0= temp.getZ()-5


        while xa < xi:
            temp= posicaoPeixe.getPontoCima ()
            posicao= temp.clonar ()
            posicao.setX (xa)
            #temp= self.peixeEspada.getPosicao ()
            posicao.setY (y0)
            posicao.setZ (z0)

            contZ= 0
            while contZ < 4:
                posicao.setZ (posicao.getZ() - contZ*2)

                if ((cont+contZ)%3) == 0:
                    self.criar3Pneus (posicao)
                elif ((cont+contZ)%3) == 1:
                    obj= self.criarSacoPlastico (posicao.getLista ())
                    obj.setVelocidade (0)
                    self.adicionarLixo (obj)
                else:
                    obj= self.criarBota (posicao.getLista ())
                    obj.setVelocidade (0)
                    self.adicionarLixo (obj)

                contZ+= 1


            xa+= 3
            cont+= 1



    def criarPeixeEspada (self, ponto):
        self.peixeEspada= PeixeEspada(escala =0.2, pos= (ponto.getX ()+10, ponto.getY()-8, ponto.getZ ()), axis=(-1,0,0))
        self.peixeEspada.desenha(self.peixeEspada.escala)
        self.peixeEspada.setVelocidade(500)

        self.armadilha= self.criarBalde (self.peixeEspada.posicao)
        #self.criarRedePesca (self.peixeEspada.posicao)
        #self.criarLinhaPesca ()

        return self.peixeEspada

    def criarBalde (self, posicao):
        c= posicao.getPontoCima ()
        b= posicao.getPontoBaixo ()
        lista= (c.getX()+((b.getX()-c.getX())/2)-5, c.getY()+4.5, c.getZ()+((b.getZ()-c.getZ()))-5.6)

        obj= Balde (1, pos= lista)
        obj.desenhar ()

        return obj

    def getNomeNivel (self):
        return "Nivel 4"

    def passarProximoNivel (self):
        return None

    def exibirProximoQuadro (self, contIteracao):
        acara= self.acaraController.getAcara ()

        chocou= acara.chocou (self.peixeEspada.getPosicao ())
        if chocou == 1:
            if self.batidas < 2:
                self.armadilha.girar (5, Eixo.EIXO_Z)
            elif self.batidas == 2:
                self.peixeEspada.nadar (Ponto (-1,0,0))

            self.batidas+= 1

        if self.batidas >= 2:
            if self.armadilha.chegouFundo (self.posicaoTela) == 0:
                self.armadilha.afundar ()


# Fim