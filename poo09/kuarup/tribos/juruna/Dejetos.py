from Pneu import *
from Bota import *
from SacoPlastico import *
from RedePesca import *
from Balde import *
from Vaso import *
from Teste import *

class Dejetos:
    deslocX= 1.8

    def __init__ (self):
        #self.cenario= display (title='Oceano',width=150, height=150,center= (0.5,0,0),x=0, y=0, background=color.blue)
        self.cenario= display (title='Oceano',width=700, height=500,center= (0,0,0),x=0, y=0, background=color.blue)
        self.cenario.select ()
        self.cenario.visible= 1
        self.quadroInfo= None

        self.posTela= Posicao ()

        self.posTela.setPontoCima (-15, 10, 10)
        self.posTela.setPontoBaixo (15, -10, 10)


    def desenhar (self):

        pontoCimaTela= self.posTela.getPontoCima()
        pontoBaixoTela= self.posTela.getPontoBaixo()
        x= pontoCimaTela.getX() + self.deslocX
        y= pontoCimaTela.getY() - (pontoCimaTela.getY()-pontoBaixoTela.getY())/2
        z= pontoCimaTela.getZ()
        ponto= Ponto(x,y,pontoCimaTela.getZ())
        self.criarPneu(ponto)

        x= x + self.deslocX
        ponto.setX(x)
        self.criarBota(ponto)

        x= x + self.deslocX
        ponto.setX(x)
        self.criarSacoPlastico(ponto)

        x= x + self.deslocX + 0.8
        ponto.setX(x)
        #self.criarBalde(ponto)

        # Cria outra linha a frente da linha atual.
        z= z + 15

        x= pontoCimaTela.getX()  + (self.deslocX/2)
        ponto.setX(x)
        ponto.setZ(z)
        self.criarVaso(ponto)


        # teste
        obj= Teste (escala= 2.5, axis= (0,0,1), pos= ponto.getLista())
        obj.desenhar ()

    def criarVaso (self, ponto):
        obj= Vaso (escala= 2.5, axis= (0,1,0), pos= ponto.getLista())
        obj.desenhar ()

        return obj

    def criarPneu (self, ponto):
        obj= Pneu (escala= 2.5, axis= (0,0,1), pos= ponto.getLista())
        obj.desenhar ()

        return obj

    def criarBota (self, ponto):
        obj= Bota (escala= 2, axis= (1,0,0), pos= ponto.getLista())
        obj.desenhar ()

        return obj

    def criarBalde (self, ponto):
        obj= Balde (escala= 1, axis= (1,0,0), pos= ponto.getLista())
        obj.desenhar ()

        return obj

    def criarSacoPlastico (self, ponto):
        saco= SacoPlastico (escala= 2.5, axis= (1,0,0), pos= ponto.getLista())
        saco.desenhar ()

        return saco

if __name__ == "__main__":
    obj= Dejetos ()
    obj.desenhar ()


# fim