from __future__ import division
from visual import *
import Image
from SerMarinho import *
from Eixo import *
from Ponto import *
import math

class TartarugaMichelangelo (SerMarinho):
    corpo= None
    pernas= None
    cabeca= None
    cauda= None

    escala= None
    eixo= None

    def desenhar (self):
        texturaCorpo= self.carregarTextura ("L:/sincronizar/meus documentos/mestrado/poo/Trabalho3/src/imagem/texturaCorpoTartaruga.jpg", "rectangular", 127, 105)

        print "posicao %s \n escala %f\n" % (self.posicao, self.escala)

        self.desenharCorpo (self.posicao, texturaCorpo)
        self.desenharPernas (self.posicao, texturaCorpo)
        self.desenharCabeca (self.posicao, texturaCorpo)
        self.desenharCauda (self.posicao, texturaCorpo)


    def desenharCorpo (self, posicao, texturaCorpo):
        self.corpo= CorpoTartaruga (texturaCorpo, self.escala, self.esqueleto)
        self.corpo.desenhar (posicao)


    def desenharPernas (self, posicao, texturaCorpo):
        self.pernas= PernasTartaruga (texturaCorpo, self.escala, self.esqueleto)
        self.pernas.desenhar (posicao)


    def desenharCabeca (self, posicao, texturaCorpo):
        self.cabeca= CabecaTartaruga (texturaCorpo, self.escala, self.esqueleto)
        self.cabeca.desenhar (posicao)


    def desenharCauda (self, posicao, texturaCorpo):
        self.cauda= CaudaTartaruga (texturaCorpo, self.escala, self.esqueleto)
        self.cauda.desenhar (posicao)


    def nadar (self, pontoEixo):
        #pontoEixo= Ponto (1, 0, 0)
        eixo= pontoEixo.getVetor ()
       # self.posicao.somar (self.VELOCIDADE_NADO, eixo);

        #incremento= self.VELOCIDADE_NADO * eixo
        incremento= vector (self.VELOCIDADE_NADO * eixo[0], self.VELOCIDADE_NADO * eixo[1], self.VELOCIDADE_NADO * eixo[2])
        self.esqueleto.pos+= incremento #vector(self.esqueleto.pos)+vector(self.direcao_atual)*0.2

        self.pernas.mexerPernas ()

        print "esqueleto: %f | %f  | %f\n" % (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])


    def girar (self, angulo, eixo):
        self.esqueleto.rotate (angle= angulo, axis= eixo)

        #self.corpo.girar (angulo, eixo)
        #self.cabeca.girar (angulo, eixo)
        #self.pernas.girar (angulo, eixo)
        #self.cauda.girar (angulo, eixo)

# -----------------------------------------------------------------
class CorpoTartaruga:
    corpo= None

    COMPRIMENTO= 0.023
    ALTURA= 0.02
    LARGURA= 0.016
    escala= 1

    COR= color.cyan #(0, 0.667, 0) #(0.8, 0.35, 0)

    textura= None
    esqueleto= None

    def __init__ (self, textura, escala, esqueleto):
        self.esqueleto= esqueleto
        self.textura= textura
        self.escala= escala

    def getPosicao (self):
        return self.corpo.pos

    def setPosicao (self, posicao):
        self.corpo.pos= posicao

    """
    def girar (self, angulo, eixo):
        self.corpo.rotate (angle= angulo, axis= eixo)
    """

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        eixo= Eixo ()

        #base= box (pos= (x+ (self.COMPRIMENTO/2), y + (self.ALTURA * 0.1), z- (self.LARGURA/2)), length=self.COMPRIMENTO, height=self.ALTURA*0.2,
        #           width=self.LARGURA, color= color.green, texture= self.textura)

        self.corpo= ellipsoid (frame= self.esqueleto, pos= (x, y, z), length=self.COMPRIMENTO * self.escala, height=self.ALTURA*0.2*self.escala,
                         width=self.LARGURA*self.escala,  material= self.textura)

"""
    def nadar (self, incremento):
        self.corpo.pos[0]+= incremento[0];
        self.corpo.pos[1]+= incremento[1];
        self.corpo.pos[2]+= incremento[2];
"""

# -----------------------------------------------------------------
class PernasTartaruga:
    pernaFrenteEsq= None
    pernaFrenteDir= None
    pernaTrasEsq= None
    pernaTrasDir= None

    texturaCorpo= None

    LARGURA= 0.003
    COMPRIMENTO= 0.005
    DESLOC_X_PROPORCAO_CORPO= 0.75
    DESLOC_Y_PROPORCAO_CORPO= 0.30

    COR= color.black #CorpoTartaruga.COR

    escala= 1
    esqueleto= None

    pernaFrentePosNormal= true
    pernaTrasPosNormal= true

    def __init__ (self, texturaCorpo, escala, esqueleto):
        self.esqueleto= esqueleto
        self.escala= escala
        self.texturaCorpo= texturaCorpo

    """
    def girar (self, angulo, eixo):
        self.pernaFrenteDir.rotate (angle= angulo, axis= eixo)
        self.pernaFrenteEsq.rotate (angle= angulo, axis= eixo)
        self.pernaTrasDir.rotate (angle= angulo, axis= eixo)
        self.pernaTrasEsq.rotate (angle= angulo, axis= eixo)
    """

    def mexerPernas (self):
        if self.pernaFrentePosNormal == true:
            eixo= Eixo ()
            anguloFrenteEsqTrasDir= eixo.converterGrausRadiano (210)
            anguloFrenteDirTrasEsq= eixo.converterGrausRadiano (150)

            self.pernaFrenteDir.rotate (angle= anguloFrenteDirTrasEsq, axis=Eixo.EIXO_X)
            self.pernaFrenteEsq.rotate (angle= anguloFrenteEsqTrasDir, axis=Eixo.EIXO_X)

            if self.pernaTrasPosNormal != true:
                self.pernaTrasDir.rotate (angle= anguloFrenteEsqTrasDir, axis=Eixo.EIXO_X)
                self.pernaTrasEsq.rotate (angle= anguloFrenteDirTrasEsq, axis=Eixo.EIXO_X)

            self.pernaFrentePosNormal= false
            self.pernaTrasPosNormal= true
        else:
            eixo= Eixo ()
            anguloFrenteEsqTrasDir= eixo.converterGrausRadiano (150)
            anguloFrenteDirTrasEsq= eixo.converterGrausRadiano (210)

            self.pernaFrenteDir.rotate (angle= anguloFrenteDirTrasEsq, axis=Eixo.EIXO_X)
            self.pernaFrenteEsq.rotate (angle= anguloFrenteEsqTrasDir, axis=Eixo.EIXO_X)

            self.pernaTrasDir.rotate (angle= anguloFrenteEsqTrasDir, axis=Eixo.EIXO_X)
            self.pernaTrasEsq.rotate (angle= anguloFrenteDirTrasEsq, axis=Eixo.EIXO_X)

            self.pernaFrentePosNormal= true
            self.pernaTrasPosNormal= false

    """
    def nadar (self, incremento):
        self.pernaFrenteDir.pos[0]+= incremento[0];
        self.pernaFrenteEsq.pos[0]+= incremento[0];
        self.pernaTrasDir.pos[0]+= incremento[0];
        self.pernaTrasEsq.pos[0]+= incremento[0];

        self.pernaFrenteDir.pos[1]+= incremento[1];
        self.pernaFrenteEsq.pos[1]+= incremento[1];
        self.pernaTrasDir.pos[1]+= incremento[1];
        self.pernaTrasEsq.pos[1]+= incremento[1];

        self.pernaFrenteDir.pos[2]+= incremento[2];
        self.pernaFrenteEsq.pos[2]+= incremento[2];
        self.pernaTrasDir.pos[2]+= incremento[2];
        self.pernaTrasEsq.pos[2]+= incremento[2];

        self.mexerPernas ()
    """
    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        eixo= Eixo()
        #rotFrente= eixo.converterGrausRadiano(310)

        #adicionalEscala= (self.escala)

        comprimento= self.COMPRIMENTO * self.escala
        largura= self.LARGURA * self.escala

        xM= (CorpoTartaruga.COMPRIMENTO/2) * self.escala
        yM= (CorpoTartaruga.ALTURA/2) * self.escala
        zM= (CorpoTartaruga.LARGURA/2) * self.escala

        recuoX= (xM * self.DESLOC_X_PROPORCAO_CORPO)

        INCR_FRENTE_DIR= (CorpoTartaruga.LARGURA*0.1) *(-1)

        # def calcularParametrica (self, x0, y0, x, xM, yM):
        recuoZ= posicao.calcularParametrica (x, z, x+recuoX, xM, zM)

        # calculo a distancia do y0 para a borda da elipse
        deslocY= posicao.calcularParametrica (x, y, x-recuoX, xM, yM)
        deslocY-= y
        if deslocY < 0:
            deslocY*= (-1)

        recuoY= (deslocY) * self.DESLOC_Y_PROPORCAO_CORPO

        valores= list ([x-recuoX, y-recuoY, z+recuoZ])
        self.pernaTrasDir= box (frame= self.esqueleto, pos= valores, axis=(0,-1,1), length= comprimento, height=0, width= largura, material= self.texturaCorpo)

        valores= list ([x-recuoX, y-recuoY, z-recuoZ])
        self.pernaTrasEsq= box (frame= self.esqueleto, pos= valores, axis=(0,1,1), length= comprimento, height=0, width= largura, material= self.texturaCorpo)

        valores= list ([x+recuoX, y-recuoY, z+recuoZ])
        self.pernaFrenteDir= box (frame= self.esqueleto, pos= valores, axis=(0,1,-1), length= comprimento, height=0, width= largura, material= self.texturaCorpo)

        valores= list ([x+recuoX, y-recuoY, z-recuoZ])
        self.pernaFrenteEsq= box (frame= self.esqueleto, pos= valores, axis=(0,-1,-1), length= comprimento, height=0, width= largura, material= self.texturaCorpo)


# -----------------------------------------------------------------
class CabecaTartaruga:
    olhoDir= None
    pupilaDir= None
    olhoEsq= None
    pupilaEsq= None

    rosto= None
    pescoco= None
    labio= None

    narinaEsq= None
    narinaDir= None

    texturaCorpo= None
    esqueleto= None
    escala= 1

    COR= CorpoTartaruga.COR

    # constantes do pescoco
    LARGURA_PESCOCO= 0.0013
    COMPRIMENTO_PESCOCO= 0.003
    DESLOC_X_PESCOCO_PROPORCAO_CORPO= 0.92

    # constantes do rosto
    COMPRIMENTO_ROSTO= 0.0035

    # constantes do labio
    LARGURA_LABIO= 0.00018
    DESLOC_X_LABIO_PROPORCAO_LARGURA_LABIO= 0.75

    # constantes do nariz
    DESLOC_Y_NARIZ_PROPORCAO_ROSTO= 0.05
    ESPACO_ENTRE_NARINAS= 0.035
    TAMANHO_NARINA= 0.00003

    # constantes dos olhos
    DESLOC_X_OLHO_PROPORCAO_ROSTO= 0.7
    DESLOC_Y_OLHO_PROPORCAO_ROSTO= 0.5
    DESLOC_Z_OLHO_PROPORCAO_ROSTO= 0.6

    COMPRIMENTO_OLHO= 0.0004
    LARGURA_OLHO= 0.0002
    ALTURA_OLHO= 0.00075

    RAIO_PUPILA= 0.00015

    # variaveis do pescoco para uso no resto da cabeca
    #xPescoco
    #yPescoco
    #zPescoco
    #comprimentoPescocoEscala
    #larguraPescocoEscala

    def __init__ (self, texturaCorpo, escala, esqueleto):
        self.esqueleto= esqueleto
        self.escala= escala
        self.texturaCorpo= texturaCorpo

    """
    def girar (self, angulo, eixo):
        self.olhoDir.rotate (angle= angulo, axis= eixo)
        self.olhoEsq.rotate (angle= angulo, axis= eixo)
        self.pupilaDir.rotate (angle= angulo, axis= eixo)
        self.pupilaEsq.rotate (angle= angulo, axis= eixo)

        self.rosto.rotate (angle= angulo, axis= eixo)
        self.pescoco.rotate (angle= angulo, axis= eixo)
        self.labio.rotate (angle= angulo, axis= eixo)

        self.narinaDir.rotate (angle= angulo, axis= eixo)
        self.narinaEsq.rotate (angle= angulo, axis= eixo)


    def nadar (self, incremento):
        self.olhoDir.pos[0]+= incremento[0];
        self.pupilaDir.pos[0]+= incremento[0];
        self.olhoEsq.pos[0]+= incremento[0];
        self.pupilaEsq.pos[0]+= incremento[0];
        self.rosto.pos[0]+= incremento[0];
        self.pescoco.pos[0]+= incremento[0];
        self.labio.pos[0]+= incremento[0];
        self.narinaEsq.pos[0]+= incremento[0];
        self.narinaDir.pos[0]+= incremento[0];

        self.olhoDir.pos[1]+= incremento[1];
        self.pupilaDir.pos[1]+= incremento[1];
        self.olhoEsq.pos[1]+= incremento[1];
        self.pupilaEsq.pos[1]+= incremento[1];
        self.rosto.pos[1]+= incremento[1];
        self.pescoco.pos[1]+= incremento[1];
        self.labio.pos[1]+= incremento[1];
        self.narinaEsq.pos[1]+= incremento[1];
        self.narinaDir.pos[1]+= incremento[1];

        self.olhoDir.pos[2]+= incremento[2];
        self.pupilaDir.pos[2]+= incremento[2];
        self.olhoEsq.pos[2]+= incremento[2];
        self.pupilaEsq.pos[2]+= incremento[2];
        self.rosto.pos[2]+= incremento[2];
        self.pescoco.pos[2]+= incremento[2];
        self.labio.pos[2]+= incremento[2];
        self.narinaEsq.pos[2]+= incremento[2];
        self.narinaDir.pos[2]+= incremento[2];
    """

    def desenhar (self, posicao):
        posicaoPescoco, comprPescoco= self.desenharPescoco (posicao)
        posicaoRosto= self.desenharRosto (posicaoPescoco, comprPescoco)
        self.desenharOlhos (posicaoRosto)
        self.desenharBoca (posicaoRosto)
        self.desenharNariz (posicaoRosto)

    def desenharNariz (self, posicaoRosto):
        x= posicaoRosto.getX () + (self.rosto.length/2)
        y= posicaoRosto.getY () + (self.rosto.height * self.DESLOC_Y_NARIZ_PROPORCAO_ROSTO)
        z= posicaoRosto.getZ ()
        espaco= self.rosto.width * (self.ESPACO_ENTRE_NARINAS * self.escala)
        tamanho= self.TAMANHO_NARINA * self.escala

        # def calcularCircunferencia (self, x0, y0, x, r):
        #y= posicaoPescoco.calcularCircunferencia  (posicaoRosto.getX (), posicaoRosto.getY (), x, self.rosto.)
        #xM= (self.rosto.length/2 * self.escala)
        #yM= (self.rosto.height/2 * self.escala)
        #zM= (self.rosto.width/2 * self.escala)

        #deslocY= posicaoRosto.calcularParametrica (posicaoRosto.getX (), posicaoRosto.getY (), x, xM, yM)
        #deslocZ= posicaoRosto.calcularParametrica (posicaoRosto.getX (), posicaoRosto.getZ (), x, xM, zM)

        self.narinaEsq= cylinder(frame= self.esqueleto, pos= (x-tamanho,y,z-espaco), axis=(tamanho,0,0), radius=tamanho, color= (0.1, 0.1, 0.1))
        self.narinaDir= cylinder(frame= self.esqueleto, pos= (x-tamanho,y,z+espaco), axis=(tamanho,0,0), radius=tamanho, color= (0.1, 0.1, 0.1))


    def desenharRosto (self, posicaoPescoco, comprPescoco):
        x= posicaoPescoco.getX () + comprPescoco
        y= posicaoPescoco.getY ()
        z= posicaoPescoco.getZ ()

        comprimentoRosto= self.COMPRIMENTO_ROSTO * self.escala

        self.rosto= ellipsoid (frame= self.esqueleto, pos=(x, y, z), length=comprimentoRosto, height=self.pescoco.radius*2,
                               width=self.pescoco.radius*2, material= self.texturaCorpo)

        return Ponto (x, y, z)

    def desenharPescoco (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        comprimentoPescoco= self.COMPRIMENTO_PESCOCO * self.escala
        larguraPescoco= self.LARGURA_PESCOCO * self.escala

        xM= (CorpoTartaruga.COMPRIMENTO/2) * self.escala
        x1= x +  (xM * self.DESLOC_X_PESCOCO_PROPORCAO_CORPO)
        y1= y
        z1= z

        self.pescoco= cylinder (frame= self.esqueleto, pos=(x1,y1,z1), axis=(comprimentoPescoco, 0,0), radius=larguraPescoco, material= self.texturaCorpo)

        #self.xPescoco= x1
        #self.yPescoco= y1
        #self.zPescoco= z1
        #self.comprimentoPescocoEscala= comprimentoPescoco
        #self.larguraPescocoEscala= larguraPescoco

        return Ponto (x1, y1, z1), comprimentoPescoco


    def desenharBoca (self, posicaoRosto):

        tamanho= (self.rosto.length /2 - self.rosto.length/3) * 2

        larguraLabio= self.LARGURA_LABIO * self.escala

        x= posicaoRosto.getX () + (self.rosto.length/3) + (self.rosto.length * 0.05)
        y= posicaoRosto.getY ()#- (self.rosto.height/2)
        z= posicaoRosto.getZ ()

        self.labio= ellipsoid (pos= (x,y,z), length=tamanho, height=larguraLabio, width=self.rosto.width/2, color= color.red)
        #ring (pos= (x, y, z), radius= raio, thickness=larguraLabio, color= color.red) # color= (0.2, 0.2, 0.2))

        eixo= Eixo ()
        angulo= eixo.converterGrausRadiano (340)
        self.labio.rotate (angle= angulo, axis=Eixo.EIXO_Z)

        self.labio.frame= self.esqueleto


    def desenharOlhos (self, posicaoRosto):
        eixo= Eixo ()
        incrementoZ= (self.rosto.width/2) * self.DESLOC_Z_OLHO_PROPORCAO_ROSTO

        x= posicaoRosto.getX () + ( (self.rosto.length/2) * self.DESLOC_X_OLHO_PROPORCAO_ROSTO)
        y= posicaoRosto.getY () + ( (self.rosto.height/2) * self.DESLOC_Y_OLHO_PROPORCAO_ROSTO)
        z= posicaoRosto.getZ ()

        comprOlho= self.COMPRIMENTO_OLHO * self.escala
        alturaOlho= self.ALTURA_OLHO * self.escala
        larguraOlho= self.LARGURA_OLHO * self.escala
        raioPupila= self.RAIO_PUPILA * self.escala

        # lado direito
        self.olhoDir= ellipsoid (frame= self.esqueleto, pos= (x,y,z+incrementoZ), length=comprOlho, height=alturaOlho, width=larguraOlho, color= (0.2,0.2,0.2))
        angulo= eixo.converterGrausRadiano (110)
        self.olhoDir.rotate (angle= angulo, axis= Eixo.EIXO_Z)

        angulo= eixo.converterGrausRadiano (35)
        self.olhoDir.rotate (angle= angulo, axis= Eixo.EIXO_Y)

        angulo= eixo.converterGrausRadiano (340)
        self.olhoDir.rotate (angle= angulo, axis= Eixo.EIXO_X)

        self.pupilaDir= sphere (frame= self.esqueleto, pos=(x,y,z+incrementoZ), radius=raioPupila, color= color.black)

        # lado esquerdo
        self.olhoEsq= ellipsoid (frame= self.esqueleto, pos= (x,y,z-incrementoZ), length=comprOlho, height=alturaOlho, width=larguraOlho, color= (0.2,0.2,0.2))
        angulo= eixo.converterGrausRadiano (110)
        self.olhoEsq.rotate (angle= angulo, axis= Eixo.EIXO_Z)

        angulo= eixo.converterGrausRadiano (325)
        self.olhoEsq.rotate (angle= angulo, axis= Eixo.EIXO_Y)

        angulo= eixo.converterGrausRadiano (20)
        self.olhoEsq.rotate (angle= angulo, axis= Eixo.EIXO_X)

        self.pupilaEsq= sphere (frame= self.esqueleto, pos=(x,y,z-incrementoZ), radius=raioPupila, color= color.black)

        # insere o esqueleto depois de todas as rotacoes
        self.olhoDir.frame= self.esqueleto
        self.olhoEsq.frame= self.esqueleto


# -----------------------------------------------------------------
class CaudaTartaruga:
    LARGURA= 0.0025
    ALTURA= 0.00015
    INCLINACAO= 0.002
    COMPRIMENTO= PernasTartaruga.COMPRIMENTO/2

    DESLOC_X_PROPORCAO_CORPO= 1- 0.05

    cauda= None

    texturaCorpo= None
    esqueleto= None

    COR= CorpoTartaruga.COR

    escala= 1

    def __init__ (self, texturaCorpo, escala, esqueleto):
        self.esqueleto= esqueleto
        self.escala= escala
        self.texturaCorpo= texturaCorpo

    """
    def girar (self, angulo, eixo):
        pass
        #self.cauda.rotate (angle= angulo, axis= eixo)


    def nadar (self, incremento):
        #print '******************* %s **************\n' % (self.cauda.pos[0].__getitem__(0))
        for linha in self.cauda.pos:
            linha[0]+= incremento[0]
            linha[1]+= incremento[1]
            linha[2]+= incremento[2]

        #self.cauda.pos[0]+= incremento[0]
        #self.cauda.pos[1]+= incremento[1]
        #self.cauda.pos[2]+= incremento[2]
    """

    def desenhar (self, posicao):
        x= posicao.getX ()
        y= posicao.getY ()
        z= posicao.getZ ()

        #x+= (CorpoTartaruga.COMPRIMENTO * 0.01)
        #y+= (CorpoTartaruga.ALTURA* 0.10)
        #z-= (CorpoTartaruga.LARGURA/2)

        xM= (CorpoTartaruga.COMPRIMENTO/2) * self.escala

        x1= x - (self.DESLOC_X_PROPORCAO_CORPO * xM)

        # def calcularParametrica (self, x0, y0, x, xM, yM):
        #z1= posicao.calcularParametrica (x, z, x1, (CorpoTartaruga.COMPRIMENTO/2) * self.escala, (CorpoTartaruga.LARGURA/2) * self.escala)

        largura= self.LARGURA * self.escala
        altura= self.ALTURA * self.escala
        inclinacao= self.INCLINACAO * self.escala
        comprimento= self.COMPRIMENTO * self.escala

        valores= list ()
        # ponto mais externo
        valores.append ([x1 - comprimento, y - inclinacao + (altura / 2), z])
        valores.append ([x1 - comprimento, y - inclinacao - (altura /2), z])

        # pontos base do triangulo
        valores.append ([x1, y - (altura / 2), z + (largura/2)])
        valores.append ([x1, y + (altura / 2), z + (largura/2)])

        valores.append ([x1, y - (altura / 2), z - (largura/2)])
        valores.append ([x1, y + (altura / 2), z - (largura/2)])

        self.cauda= convex (frame= self.esqueleto, pos= valores, material= self.texturaCorpo)


# fim