from AguaViva import *
from Tubarao import *
from AcaraDisco import * # temporario
from random import *
from Pontuacao import *

class NivelState:
    acaraController= None
    posicaoTela= None

    personagens= None
    pontuacao= None

    def __init__ (self, acaraCtrl):
        self.acaraController= acaraCtrl
        self.posicaoTela= acaraCtrl.getTela ()
        self.pontuacao= Pontuacao ()
        self.personagens= list ()

        # Valores padrao
        self.qtdMaxPersonagens= 1
        self.velocidadePersonagem= 0.5
        self.taxa= 2

        # Define quantos quadros deverao se passar antes de criar outro personagem se for o caso
        self.tempoProxPersonagem= 0

    def setPosicaoTela (self, posNova):
        self.posicaoTela= posNova

    def getTaxaQuadros (self):
        return self.taxa

    def setPontuacao (self, novo):
        self.pontuacao= novo

    def getPontuacao (self):
        return self.pontuacao

    def getQtdIteracaoNivel (self):
        return self.qtdIteracaoNivel

    def matarTodosPersonagens (self):
        cont= 0

        while cont < self.personagens.__len__():
            personagem= self.personagens.__getitem__(cont)
            personagem.matar ()

            cont+= 1

    def getNomeNivel (self):
        pass

    def passarProximoNivel (self):
        pass

    def adicionarPersonagem (self, personagem):
        self.personagens.append (personagem)

    def removerPersonagem (self, personagem):
        self.personagens.remove (personagem)

    def gerarPosicaoAleatoria (self):
       random= Random ()

       temp= self.posicaoTela.getPontoBaixo ()
       y0= temp.getY ()

       x= temp.getX ()
       z= temp.getZ ()

       temp= self.posicaoTela.getPontoCima ()
       z-=  (z-temp.getZ ()) / 2

       #valorOk= 0

       #while valorOk != 1:
       y1= temp.getY ()
       y= random.randint (y0+2, y1-2)



       return (x, y, z)

    def gerarIntAleatorio (self, min, max):
       random= Random ()

       return random.randint (min, max)

    def criarAguaViva (self, listaPosicao):
        obj= AguaViva (escala = 0.5, axis=(-1,0,0), pos= listaPosicao) # escala antiga = 1

        obj.setFuncaoThread (obj.desenha)
        obj.run ()
        #obj.desenha (obj.escala)

        return obj

    def criarTubarao (self, listaPosicao):
        obj= Tubarao (escala = 0.1, axis=(-1,0,0), pos= listaPosicao) # escala antiga 0.2

        obj.setFuncaoThread (obj.desenha)
        obj.run ()
        #obj.desenha (obj.escala)

        return obj

    def imprimir (self, acara, id):
        temp= acara.getPosicao ()
        a= temp.getPontoBaixo ()
        b= temp.getPontoCima ()
        print "\n\n**********\nACARA %s baixo x %f y %f z %f\n" % (id, a.getX (), a.getY(), a.getZ())
        print "ACARA  %s cima x %f y %f z %f\n*******\n\n" % (id, b.getX (), b.getY(), b.getZ())


    """
     Metodo chamado para preparar os figurantes, fazendo-os andar, criando novos e o que mais for
    preciso.
    """
    def exibirProximoQuadro (self):
        cont= 0

        acara= self.acaraController.getAcara ()


        """
        Para cada personagem, verifico se ele anda sem sair da tela. Se sair, removo ele da cena
        Se nao sair, verifico se ele bate no personagem principal. Se bater, - 1 vida para personagem principal.
        Se todas as verificacoes derem OK, o elemento anda
        """
        while cont < self.personagens.__len__():
            personagem= self.personagens.__getitem__(cont)

            incremento= personagem.getIncrementoNado ()

            #incremento.setX (incremento.getX () * (-1))
            #incremento.setY (0)
            #incremento.setZ (0)

            pos= personagem.getPosicao ()
            if pos.passouCompletoCantoEsquerdo (incremento, self.posicaoTela) != 1:
                personagem.nadar (incremento)

                chocou= acara.chocou (personagem.getPosicao ())
                if chocou == 1:
                    dano= personagem.getDano ()
                    self.pontuacao.decrementarVida (dano)

                    if self.pontuacao.temVida () == 0:
                        return 0

            else:
                personagem.setFuncaoThread (personagem.matar)
                personagem.run ()
                #personagem.matar ()
                self.removerPersonagem (personagem)
                self.tempoProxPersonagem= 3

            cont+= 1
            self.tempoProxPersonagem-= 1


        # Crio personagens novos
        if (self.personagens.__len__ () < self.qtdMaxPersonagens) & (self.tempoProxPersonagem < 1):
            self.criarPersonagem ()
            self.tempoProxPersonagem= 5

        return 1

# Fim