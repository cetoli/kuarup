from visual import *
from Ativa import *
#from Resolvida import *
#from Selecionada import *
#from State import *
from EstadoFactory import *
from Posicao import *
from Ponto import *

class Peca:
    cor= (0, 1, 0) #(0.7,0.7,0.7)
    tamanho= 0.3
    profundidade= 0.5

    def __init__ (self, ponto= Ponto (0,0,0), texto="", observador= None):
        #self.posicao= ponto.calcularPosicaoPeloPontoMeio (self.tamanho, self.tamanho, self.profundidade)

        self.esqueleto= frame ()
        x, y, z= ponto.getX (), ponto.getY (), ponto.getZ ()
        self.peca= box (frame= self.esqueleto, pos= (x, y, z), length= self.tamanho, height= self.tamanho, width= self.profundidade, color= self.cor)

        deslocLetra= 0 #(-1) * (self.tamanho/2)
#        self.rotulo= label (frame= self.esqueleto, pos=(x,y,z), text=texto, xoffset=deslocLetra, yoffset=0, space=0, height=20, border=4, box= 0, line= 0, opacity= 0, font='monospace')
        self.rotulo= label (frame= self.esqueleto, pos=(x,y,z), text=texto, xoffset=deslocLetra, yoffset=0, space=0, height=20, border=4, box= 0, line= 0, opacity= 0, font='monospace', color= color.black)

        factory= EstadoFactory ()
        self.estado= factory.criarEstadoInicial()
        #self.texto= texto

        self.criarPosicao (ponto, self.tamanho, self.tamanho, self.profundidade)
        self.observador= observador

    def getPosicao (self):
        return self.posicao

    def criarPosicao (self, ponto, dx, dy, dz):
        self.posicao= Posicao ()
        x= ponto.getX ()- (dx/2)
        y= ponto.getY ()+ (dy/2)
        z= ponto.getZ ()- (dz/2)
        self.posicao.setPontoCima (x, y, z)

        x= ponto.getX ()+ (dx/2)
        y= ponto.getY ()- (dy/2)
        z= ponto.getZ ()+ (dz/2)
        self.posicao.setPontoBaixo (x, y, z)

    def setValor (self, valor):
        self.valor= valor

    def getValor (self):
        return self.valor

    def getDeslocamentoX (self):
        return self.tamanho

    def getDeslocamentoY (self):
        return self.tamanho

    def tratarColisao (self):
        pass

    def sumirTexto (self):
        self.rotulo.visible= 0
        #self.rotulo.text= ""

    def mostrarTexto (self):
        self.rotulo.visible= 1
        #self.rotulo.text= self.texto

    def estaDentroPeca (self, posPeixe):
        baixo= posPeixe.getPontoBaixo ()
        cima= posPeixe.getPontoCima ()

        # se peixe dentro do intervalo posTela[0] <-> posTela[6] => OK
        x0Peixe= baixo.getX ()
        y0Peixe= baixo.getY ()
        z0Peixe= baixo.getZ ()

        x6Peixe= cima.getX ()
        y6Peixe= cima.getY ()
        z6Peixe= cima.getZ ()

        baixo= self.posicao.getPontoBaixo ()
        cima= self.posicao.getPontoCima ()

        x0Peca= baixo.getX ()
        y0Peca= baixo.getY ()
        z0Peca= baixo.getZ ()

        x6Peca= cima.getX ()
        y6Peca= cima.getY ()
        z6Peca= cima.getZ ()

        if (x0Peixe > x0Peca) | (x0Peixe < x6Peca):
            return False

        if (y0Peixe < y0Peca) | (y0Peixe > y6Peca):
            return False

        return True

    """
    def setEstado (self, estadoNovo):
        self.estado= estadoNovo
    """

    def mudarEstado (self, dentro= False, selecionada= False, resolvida= False, temSelecaoAnt= False):
        factory= EstadoFactory ()
        estado= factory.criarProximoEstado(self.estado, dentro, selecionada, resolvida, temSelecaoAnt)
        if estado != None:
            print "Estado novo para [%s] de %s => %s \n" % (self.rotulo.text, self.estado.tipo, estado.tipo)
            estadoAnt= self.estado
            self.estado= estado
            self.observador.informarMudancaEstado (self, estadoAnt, estado)

        factory= None

    def verificarEstado (self, posPeixe):
        dentro= self.estaDentroPeca (posPeixe)
        self.mudarEstado (dentro)

    """
    def selecionarPeca (self):
        estadoNovo= self.mudarEstado (true, true)
        if self.estado.getSelecionada () == True:
            self.mostrarTexto ()
            #self.verificarResolvido ()
        else:
            self.sumirTexto ()
    """

    def andar (self, posicao):
        #self.esqueleto.pos= posicao.getLista ()
        self.peca.pos= posicao.getLista ()
        self.rotulo.pos= posicao.getLista ()
        self.criarPosicao (posicao, self.tamanho, self.tamanho, self.profundidade)

    def sumir (self):
        self.peca.visible= 0
        self.rotulo.visible= 0

    def getSelecionada (self):
        return self.estado.getSelecionada ()

    def getResolvida (self):
        return self.estado.getResolvida ()

    def getTexto (self):
        return self.rotulo.text

    def setTexto (self, texto):
        self.rotulo.text= texto

    def getEPecaResultado (self):
        return False
# Fim