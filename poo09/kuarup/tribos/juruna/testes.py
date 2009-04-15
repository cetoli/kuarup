from SacoPlastico import *
from Pneu import *
from Bota import *
from Balde import *
from PeixeEspada import *


class Testes:
    def testar (self):
        # Inicializacao
        self.cenario= display (title='Testes',width=700, height=500,center= (0,0,0),x=0, y=0, background=color.blue)
        self.cenario.select ()
        self.cenario.visible= 1

        self.posTela= Posicao ()
        self.posTela.setPontoCima (-15, 10, 10)
        self.posTela.setPontoBaixo (15, -10, 10)


        # Testes
        #self.testarObjetos ()
        self.testarPeixeEspada ()

    def testarPeixeEspada (self):
        ponto= self.posTela.getPontoCima ()
        peixeEspada = PeixeEspada(escala =0.2, pos= (ponto.getX ()+10, ponto.getY()-8, ponto.getZ ()), axis=(1,0,0))
        peixeEspada.desenha(peixeEspada.escala)
        peixeEspada.setVelocidade(500)

        #self.testarRedePesca (peixeEspada.posicao)
        self.testarBalde (peixeEspada.getPosicao())

    def testarBalde (self, posicao):
        c= posicao.getPontoCima ()
        b= posicao.getPontoBaixo ()
        lista= (c.getX()+((b.getX()-c.getX())/2+2), c.getY()-2, c.getZ()+((b.getZ()-c.getZ()))-5.3)

        obj= Balde (1, pos= lista)
        obj.desenhar ()

    def testarRedePesca (self, posPeixe):
        pontoCima= posPeixe.getPontoCima ()
        pontoBaixo= posPeixe.getPontoBaixo ()

        diferenca= 0.5

        x= pontoCima.getX ()
        y= pontoBaixo.getY ()
        z= pontoBaixo.getZ ()

        xFinal= pontoBaixo.getX ()
        yFinal= pontoCima.getY ()
        zFinal= pontoCima.getZ ()

        # Cria a rede na vertical
        deltaX= 0.5
        deltaY= (yFinal - y) /2
        deltaZ= (z - zFinal) / 3

        x+= 0.2

        while x < xFinal:
            lista= list()
            lista.append ((x, y, z+diferenca))
            lista.append ((x, y, z))
            lista.append ((x, y+deltaY, z))

            lista.append ((x+deltaX, yFinal, z-deltaZ))
            lista.append ((x+deltaX, yFinal, z-deltaZ*2))

            lista.append ((x, y+deltaY, zFinal))
            lista.append ((x, y, zFinal))
            lista.append ((x, y, zFinal-diferenca))
            curve (pos=lista, radius=0.02, color=color.red)

            x+= deltaX

        # cria a rede na Horizontal
        x= pontoCima.getX ()
        deltaY= 0.1
        while y < yFinal:
            lista= list()
            lista.append ((x, y, z))
            lista.append ((xFinal, y, z))

            lista.append ((xFinal, y, zFinal))
            lista.append ((x, y, zFinal))
            curve (pos=lista, radius=0.02, color=color.red)

            y+= deltaY



    def testarObjetos (self):
        #self.testarSacoPlastico ()
        #self.testarPneu ()
        self.testarBota ()

    def testarBota (self):
        ponto= self.posTela.getPontoCima ()
        obj= Bota (escala= 1, axis= (1,0,0), pos= (ponto.getX ()+10, ponto.getY()-8, ponto.getZ ()))
        obj.desenhar ()

        ponto= obj.getPosicao ()
        ponto.testeCubo ()
        rate (0.2)

        cont= 0
        while cont < 10:
            obj.afundar ()
            rate (2) # 0.5 segundos
            cont+= 1

        obj.matar ()


    def testarPneu (self):
        ponto= self.posTela.getPontoCima ()
        obj= Pneu (escala= 1, axis= (0,0,1), pos= (ponto.getX ()+15, ponto.getY()-8, ponto.getZ ()))
        obj.desenhar ()

        ponto= obj.getPosicao ()
        ponto.testeCubo ()
        rate (0.2)

        cont= 0
        while cont < 10:
            obj.afundar ()
            rate (2) # 0.5 segundos
            cont+= 1

        obj.matar ()


    def testarSacoPlastico (self):
        ponto= self.posTela.getPontoCima ()
        saco= SacoPlastico (escala= 1, axis= (1,0,0), pos= (ponto.getX ()+10, 0, ponto.getZ ()))
        saco.desenhar ()

        ponto= saco.getPosicao ()
        ponto.testeCubo ()
        rate (0.2)

        cont= 0
        while cont < 10:
            saco.afundar ()
            rate (2) # 0.5 segundos
            cont+= 1

        saco.matar ()

if __name__ == "__main__":
    teste= Testes ()
    teste.testar ()