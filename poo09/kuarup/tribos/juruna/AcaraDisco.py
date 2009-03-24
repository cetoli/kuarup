from __future__ import division
from visual import *
import Image
from SerMarinho import *
from Eixo import *
from Ponto import *


class PeixeAcaraDisco (SerMarinho) :
    corpo= None
    cauda= None
    labios= None
    olhos= None

    barbatanaDorsal= None
    barbatanaAnal= None
    barbatanaPeitoral= None
    barbatanaPelvica= None

    def desenhar (self):

        #self.posicao= ponto
        texturaCorpo= self.carregarTextura ("L:/sincronizar/meus documentos/mestrado/poo/Trabalho3/src/imagem/texturaCorpoPeixe.jpg", "spherical", 128, 128)
        #texturaCorpo= self.carregarTextura ("./imagem/texturaCorpoPeixe.jpg", "spherical", 128, 128)
        self.desenharCorpo (self.posicao, texturaCorpo)
        self.desenharBarbatanas (self.posicao, texturaCorpo)
        self.desenharCauda (self.posicao, texturaCorpo)
        self.desenharOlhos (self.posicao)
        self.desenharLabios (self.posicao)

    def desenharCorpo (self, posicao, texturaCorpo):

        self.corpo= CorpoAcaraDisco (texturaCorpo, self.escala, self.esqueleto)
        self.corpo.desenhar (posicao)

    def desenharBarbatanas (self, posicao, texturaCorpo):
        self.barbatanaPeitoral= BarbatanaPeitoralAcaraDisco (self.escala, self.esqueleto)
        self.barbatanaPeitoral.desenhar (posicao)

        self.barbatanaPelvica= barbatanaPelvicaAcaraDisco (self.escala, self.esqueleto)
        self.barbatanaPelvica.desenhar (posicao)

        self.barbatanaDorsal= BarbatanaDorsal (self.escala, self.esqueleto)
        self.barbatanaDorsal.desenhar (posicao)

        self.barbatanaAnal= BarbatanaAnal (texturaCorpo, self.escala, self.esqueleto)
        self.barbatanaAnal.desenhar (posicao)

    def desenharCauda (self, posicao, texturaCorpo):
        self.cauda= CaudaAcaraDisco (texturaCorpo, self.escala, self.esqueleto)
        self.cauda.desenhar (posicao)

    def desenharOlhos (self, posicao):
        self.olhos= OlhosAcaraDisco (self.escala, self.esqueleto)
        self.olhos.desenhar (posicao)

    def desenharLabios (self, posicao):
        self.labios= BocaAcaraDisco (self.escala, self.esqueleto)
        self.labios.desenhar (posicao)

    def nadar (self, pontoEixo):
        eixo= pontoEixo.getVetor ()
        incremento= vector (self.velocidade * eixo[0], self.velocidade * eixo[1], self.velocidade * eixo[2])
        self.esqueleto.pos+= incremento
        self.barbatanaPeitoral.mexer ()

        #sentidoPositivo= true
        #if eixo[0] < 0:
        #    sentidoPositivo= false

       # self.cauda.mexer (sentidoPositivo)

    def girar (self, angulo, eixoRotacao):
        eixo= Eixo ()
        anguloRad= eixo.converterGrausRadiano (angulo)
        self.esqueleto.rotate (angle= anguloRad, axis= eixoRotacao)
        self.barbatanaPeitoral.mexer ()


# -----------------------------------------------------------------
class CorpoAcaraDisco:
    corpo= None

    textura= None
    escala= None
    esqueleto= None

    def __init__ (self, texturaCorpo, escala, esqueleto):
        self.escala= escala
        self.esqueleto= esqueleto
        self.textura= texturaCorpo

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        eixo= Eixo ()
        fator= eixo.calcularRazao (posicao.getZ ())
        self.corpo= ellipsoid(frame= self.esqueleto, pos=(posicao.getX (),posicao.getY (), posicao.getZ ()), length=4*self.escala, height=2*self.escala, width=1.5*self.escala,color=(0.8,0.8,0.8),material=self.textura)#, opacity=(0.15))


# -----------------------------------------------------------------
class CaudaAcaraDisco:
    caudaCima= None
    caudaBaixo= None

    textura= None
    escala= None
    esqueleto= None

    ROTACAO_CAUDA_NADO= 20

    # Posicao indica em que lado ela esta durante o nado. Os valore sao:
    # 0 - parado
    # 1 - direita
    # 2 - esquerda
    posicaoCauda= 0

    # indica de da posicao neutra vai para a esquerda (1) ou direita (0)
    ladoMovimentoCauda= 0

    pontoInicialCaudaCima= None
    pontoInicialCaudaBaixo= None

    def __init__ (self, texturaCorpo, escala, esqueleto):
        self.escala= escala
        self.esqueleto= esqueleto
        self.textura= texturaCorpo

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        self.caudaCima= pyramid(frame= self.esqueleto, pos=(x-(2.5*self.escala),y+(0.2*self.escala),z), size=(1*self.escala,0.8*self.escala,0.1*self.escala), material=self.textura, opacity=(0.75))
        self.caudaBaixo= pyramid(frame= self.esqueleto, pos=(x-(2.5*self.escala),y,z), size=(1*self.escala,0.8*self.escala,0.1*self.escala), axis=(1,-0.5,0), material=self.textura, opacity=(0.75))

        self.pontoInicialCaudaCima= (x-(2.5*self.escala),y+(0.2*self.escala),z)
        self.pontoInicialCaudaBaixo= ((x-(2.5*self.escala),y,z))

    def mexer (self, sentidoPositivo):
        eixo= Eixo ()
        angulo= 0
        posicaoCima= self.pontoInicialCaudaCima
        posicaoBaixo= self.pontoInicialCaudaBaixo

        # posicao neutra
        if self.posicaoCauda == 0:
            self.ladoMovimentoCauda= self.ladoMovimentoCauda % 2
            seno= math.sin (self.ROTACAO_CAUDA_NADO)
            distancia= seno*self.caudaBaixo.pos[0]


            # direita
            if self.ladoMovimentoCauda == 0:
                angulo= eixo.converterGrausRadiano (360-self.ROTACAO_CAUDA_NADO)
                self.posicaoCauda= 1
                posicaoCima= (self.caudaCima.pos[0] +(self.caudaCima.length * 0.03), self.caudaCima.pos[1], self.caudaCima.pos[2]+distancia)
                posicaoBaixo= (self.caudaBaixo.pos[0] +(self.caudaBaixo.length * 0.03), self.caudaBaixo.pos[2]+distancia)

            else: # esquerda
                angulo= eixo.converterGrausRadiano (self.ROTACAO_CAUDA_NADO)
                self.posicaoCauda= 2
                posicaoCima= (self.caudaCima.pos[0] +(self.caudaCima.length * 0.03), self.caudaCima.pos[1], self.caudaCima.pos[2]-distancia)
                posicaoBaixo= (self.caudaBaixo.pos[0] +(self.caudaBaixo.length * 0.03), self.caudaBaixo.pos[1], self.caudaBaixo.pos[2]-distancia)

            self.ladoMovimentoCauda+= 1

        # direita
        elif self.posicaoCauda == 1:
            angulo= eixo.converterGrausRadiano (self.ROTACAO_CAUDA_NADO)
            self.posicaoCauda= 1

        # esquerda
        if self.posicaoCauda == 2:
            angulo= eixo.converterGrausRadiano (360-self.ROTACAO_CAUDA_NADO)
            self.posicaoCauda= 0

        self.caudaCima.rotate (angle= angulo, axis= Eixo.EIXO_Y)
        self.caudaBaixo.rotate (angle= angulo, axis= Eixo.EIXO_Y)


# -----------------------------------------------------------------
class BocaAcaraDisco:
    labioSuperior= None
    labioInferior= None

    #textura= None
    escala= None
    esqueleto= None

    def __init__ (self, escala, esqueleto):
        self.escala= escala
        self.esqueleto= esqueleto
        #self.textura= texturaCorpo

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        self.labioSuperior=ring(frame= self.esqueleto, pos=(x+(1.9*self.escala),y,z), axis=Eixo.EIXO_SE,radius=0.15*self.escala, thickness=0.07*self.escala,color=color.red)
        self.labioInferior= ring(frame= self.esqueleto, pos=(x+(1.9*self.escala), y, z), axis=Eixo.EIXO_NE,radius=0.15*self.escala, thickness=0.07*self.escala,color= color.red)
        self.labioInferior.rotate (angle=6.2,axis=Eixo.EIXO_Z)


# -----------------------------------------------------------------
class OlhosAcaraDisco:
    retinaDir= None
    olhoDir= None
    envoltaOlhoDir= None
    retinaEsq= None
    olhoEsq= None
    envoltaOlhoEsq= None

    #textura= None
    escala= None
    esqueleto= None

    def __init__ (self, escala, esqueleto):
        self.escala= escala
        self.esqueleto= esqueleto
        #self.textura= texturaCorpo

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        self.retinaDir= sphere (frame= self.esqueleto, pos= (x+(1.5*self.escala), y+(0.1*self.escala), z+(0.6*self.escala)),radius=0.08*self.escala,color=color.black)
        self.olhoDir= sphere (frame= self.esqueleto, pos= (x+(1.5*self.escala), y+(0.1*self.escala), z+(0.5*self.escala)),radius=0.12*self.escala,color=(0.8,0.8,0.8))
        self.envoltaOlhoDir= sphere (frame= self.esqueleto, pos= (x+(1.5*self.escala), y+(0.1*self.escala), z+(0.4*self.escala)),radius=0.18*self.escala,color=color.yellow)

        self.retinaEsq= sphere (frame= self.esqueleto, pos= (x+(1.5*self.escala), y+(0.1*self.escala), z-(0.6*self.escala)), radius=0.08*self.escala,color=color.black)
        self.olhoEsq= sphere (frame= self.esqueleto, pos= (x+(1.5*self.escala), y+(0.1*self.escala), z-(0.5*self.escala)), radius=0.12*self.escala,color=(0.8,0.8,0.8))
        self.envoltaOlhoEsq= sphere (frame= self.esqueleto, pos= (x+(1.5*self.escala), y+(0.1*self.escala), z-(0.4*self.escala)), radius=0.18*self.escala, color=color.yellow)


# -----------------------------------------------------------------
class BarbatanaDorsal:
    barbatanaDorsal= None

    escala= None
    esqueleto= None

    def __init__ (self, escala, esqueleto):
        self.escala= escala
        self.esqueleto= esqueleto

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        self.barbatanaDorsal= box (frame= self.esqueleto, pos= (x-(0.3*self.escala), y+(0.8*self.escala), z), length=1.5*self.escala, height=0.5*self.escala, width=0.1*self.escala,color=color.yellow)
        self.barbatanaDorsal.rotate (angle=0.10, axis=Eixo.EIXO_Z)


# -----------------------------------------------------------------
class BarbatanaAnal:
    barbatanaAnal= None

    textura= None
    escala= None
    esqueleto= None

    def __init__ (self, texturaCorpo, escala, esqueleto):
        self.escala= escala
        self.esqueleto= esqueleto
        self.textura= texturaCorpo

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        self.barbatanaAnal= box (frame= self.esqueleto, pos= (x-(0.8*self.escala), y-(0.8*self.escala), z), length=1.4*self.escala, height=0.5*self.escala, width=0.1*self.escala,color=color.yellow)
        self.barbatanaAnal.rotate (angle=5.94, axis=Eixo.EIXO_Z)


# -----------------------------------------------------------------
class BarbatanaPeitoralAcaraDisco:
    GRAUS_BARBATANA_DIR= 30 #12.86
    GRAUS_BARBATANA_ESQ= 330 # -0.5236 # 329.99 graus

    barbatanaInferiorEsq= None
    barbatanaInferiorDir= None
    barbatanaDir= None
    barbatanaEsq= None

    escala= None
    esqueleto= None

    """
        A posicao comeca em 2 com a barbatana toda pra cima e vai ate 0 quando estiver toda
    pra baixo.
        Quando voltar pra cima volta negativo.
    """
    posicao= 2
    movimentoBaixo= true

    def __init__ (self, escala, esqueleto):
        self.escala= escala
        self.esqueleto= esqueleto
        #self.textura= texturaCorpo

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()
        eixo= Eixo ()

        self.barbatanaDir= pyramid (frame= self.esqueleto, pos= (x+(0.2*self.escala), y, z+(0.8*self.escala)), size=(0.5*self.escala,0.9*self.escala,0*self.escala), axis=(-1,-1,0), color=color.yellow)
        self.barbatanaDir.rotate (angle=eixo.converterGrausRadiano (self.GRAUS_BARBATANA_DIR), axis=Eixo.EIXO_X)

        self.barbatanaEsq= pyramid (frame= self.esqueleto, pos= (x+(0.2*self.escala), y, z-(0.8*self.escala)), size=(0.5*self.escala,0.9*self.escala,0*self.escala),axis=(-1,-1,0),color=color.yellow)
        self.barbatanaEsq.rotate (angle= eixo.converterGrausRadiano (self.GRAUS_BARBATANA_ESQ), axis=Eixo.EIXO_X)

    def mexer (self):
        eixo= Eixo ()

        if self.movimentoBaixo == true:
            self.posicao-= 1
        else:
            self.posicao+= 1

        grausIncremento= 20 # * posicao

        if self.movimentoBaixo == false:
            grausIncremento*= (-1)

        if self.posicao == 0:
            self.movimentoBaixo= false
        elif self.posicao == 2:
            self.movimentoBaixo= true


        anguloDir= eixo.converterGrausRadiano (grausIncremento)
        anguloEsq= eixo.converterGrausRadiano (360 - grausIncremento)
        self.barbatanaDir.rotate (angle= anguloDir, axis= Eixo.EIXO_X)
        self.barbatanaEsq.rotate (angle= anguloEsq, axis= Eixo.EIXO_X)


# -----------------------------------------------------------------
class barbatanaPelvicaAcaraDisco:
    barbatanaInferiorEsq= None
    barbatanaInferiorDir= None

    escala= None
    esqueleto= None

    def __init__ (self, escala, esqueleto):
        self.escala= escala
        self.esqueleto= esqueleto

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        self.barbatanaInferiorDir= box(frame= self.esqueleto, pos= (x+(0.3*self.escala), y-(0.8*self.escala), z+(0.2*self.escala)), axis=(-1,1,1), length=0.4*self.escala, height=0.4*self.escala, width=0.1*self.escala,color=color.yellow)
        self.barbatanaInferiorEsq= box(frame= self.esqueleto, pos= (x+(0.3*self.escala), y-(0.8*self.escala), z-(0.2*self.escala)), axis=(1,1,1), length=0.4*self.escala, height=0.4*self.escala, width=0.1*self.escala,color=color.yellow)

# fim
