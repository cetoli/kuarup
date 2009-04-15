from AguaViva import *
from Tubarao import *
from AcaraDisco import *
from SacoPlastico import *
from Pneu import *
from Bota import *
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
        # Lista de personagens sendo exibidos.
        self.personagens= list ()
        # Lista de lixos sendo exibidos.
        self.lixos= list ()
        # porcentagem de exibicao de cada lixo. Usado para saber qual criar.
        self.porcentagemLixo= list ()
        # Na inicializacao, esse vetor e preenchido com o tempo em que cada lixo sera exibido.
        self.posicoesLixo= list ()


        # Valores padrao
        self.qtdMaxPersonagens= 1
        self.velocidadePersonagem= 0.5
        self.taxa= 2

        # Define quantos quadros deverao se passar antes de criar outro personagem se for o caso
        self.tempoProxPersonagem= 0

    def getQtdPersonagens (self):
        return self.personagens.__len__()

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

    def destruirTodoLixo (self):
        cont= 0

        while cont < self.lixos.__len__():
            lixo= self.lixos.__getitem__(cont)
            lixo.destruir ()

            cont+= 1

    def matarTodosPersonagens (self):
        cont= 0

        while cont < self.personagens.__len__():
            personagem= self.personagens.__getitem__(cont)
            personagem.matar ()

            cont+= 1

    def inicializar (self):
        pass

    def getNomeNivel (self):
        pass

    def passarProximoNivel (self):
        pass

    def adicionarPersonagem (self, personagem):
        self.personagens.append (personagem)

    def removerPersonagem (self, personagem):
        self.personagens.remove (personagem)

    def adicionarLixo (self, lixo):
        self.lixos.append (lixo)

    def removerLixo (self, lixo):
        self.lixos.remove (lixo)

    def gerarPosicaoAleatoriaSerMarinho (self):
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

    def gerarPosicaoAleatoriaLixo (self):
       random= Random ()

       temp= self.posicaoTela.getPontoBaixo ()
       x0= temp.getX ()

       z= temp.getZ ()

       temp= self.posicaoTela.getPontoCima ()
       y= temp.getY ()-6
       #z-=  (z-temp.getZ ()) / 2
       z-= 5

       x1= temp.getX ()

       #print "i %f - f %f e \= %f\n" % (x0, x1, z)
       x= random.randint (x1+8, x0-8)

       return (x, y, z)


    def criarPneu (self, ponto):
        obj= Pneu (escala= 1, axis= (1,0,0), pos= ponto)
        obj.desenhar ()

        return obj

    def criarBota (self, ponto):
        obj= Bota (escala= 1, axis= (1,0,0), pos= ponto)
        obj.desenhar ()

        return obj

    def criarSacoPlastico (self, ponto):
        saco= SacoPlastico (escala= 1, axis= (1,0,0), pos= ponto)
        saco.desenhar ()

        return saco

    def criarLixo (self):
        tipo= self.gerarIntAleatorio (1, 100)
        posicao= self.gerarPosicaoAleatoriaLixo ()
        maxSaco= self.porcentagemLixo[0]
        maxBota= maxSaco + self.porcentagemLixo[1]
        maxPneu= maxBota + self.porcentagemLixo[2]

        if tipo <= maxSaco:
            lixo= self.criarSacoPlastico (posicao)
        elif tipo <= maxBota:
            lixo= self.criarBota (posicao)
        else:
            lixo= self.criarPneu (posicao)

        self.adicionarLixo (lixo)

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
     Faz o lixo afundar tambem.
    """
    def exibirProximoQuadro (self, contIteracao):

        ret= self.exibirProximoQuadroPersonagens ()

        self.exibirProximoQuadroLixos ()


        # Crio personagens novos se nao tiver chegado ao fim do nivel anterior.
        if (self.personagens.__len__ () < self.qtdMaxPersonagens) & (self.tempoProxPersonagem < 1) & (contIteracao < self.qtdIteracaoNivel):
            self.criarPersonagem ()
            self.tempoProxPersonagem= 5

        # verifica se e pra criar algum Lixo.
        if self.posicoesLixo.__len__() > 0:
            while contIteracao == self.posicoesLixo[0]:
                self.posicoesLixo.remove (contIteracao)
                self.criarLixo ()
                if self.posicoesLixo.__len__() == 0:
                    break

        return ret


    def exibirProximoQuadroPersonagens (self):
        cont= 0

        acara= self.acaraController.getAcara ()


        """
        Para cada personagem, verifico se ele anda sem sair da tela. Se sair,
        removo ele da cena. Se nao sair, verifico se ele bate no personagem
        principal. Se bater, - 1 vida para personagem principal.
        Se todas as verificacoes derem OK, o elemento anda.
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


        return 1


    def exibirProximoQuadroLixos (self):
        cont= 0
        while cont < self.lixos.__len__():
            obj= self.lixos.__getitem__(cont)
            obj.afundar()
            if obj.chegouFundo (self.posicaoTela) == 1:
                self.removerLixo (obj)
                obj.destruir()
            cont+= 1


    def exibirMsgJogo (self, msg, posicao= (0,0,0), cor= color.white):
        return label (pos= posicao, text= msg, xoffset=1, yoffset= 1, space= 1, height=15, border=3, color= cor, font='sans')

# Fim