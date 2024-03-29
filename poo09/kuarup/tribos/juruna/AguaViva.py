"""

:Author: Potiguar

:Contact: `Potiguar tcruz.franca@gmail.com`__ um indio moderno

:Date: $Date: 2009/03/16 $

:Status: This is a "work in progress"

:Revision: $Revision: 1.00 $

:Home: `LABASE http://labase.nce.ufrj.br/`__ (mestrando)

:Copyright: 2009, `GPL <http://is.gd/3Udt>`__

"""

from visual import *
from Ponto import *
from SerMarinho import *

TITLE = 'AguaViva'

'''

    author = Carlos

'''



class Cenario:

    def __init__(self):

        scene2 = display(title=TITLE,width=150, height=150,center= (0,0,0),x=0, y=0)

        scene2.x, scene2.y =0,0

        scene2.select()

        scene2.autoscale = 1

        self.quadro = 0

    def principal(self):

        aguaViva = AguaViva(escala = 5, axis=(0,0,-1), pos= (5,0.5,6))

'''

    author = Carlos

'''


'''

    author = Tiago C. de Franca

'''

class AguaViva(SerMarinho):

    def __init__ (self, escala= 1, **complemento):
        SerMarinho.__init__ (self, escala, **complemento)

        self.listaElementosCorpo= list ()


    def desenha (self):
        self.dano= 10

        escala= self.escala
        u=escala/6.0

        r=6*u

        l=6*r

        direcoes = [-r,0,r]

        self.cor1 = (0.2,0.3,0.4) #grafite

        self.cor2 = color.white

        self.cor3 = (0.4,0.1,0.6) #roxo ou algo parecido

        self.cor4 = color.blue

        self.cor5 = color.red

        #elipses

        #elipses maiores tansparentes

        elem= self.desenharElipse((0,0,0),3*escala,2*escala,3*escala,self.cor2,0.4)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharElipse ((0,0.4*escala,0),2*escala,1.5*escala,2*escala,self.cor3,0.4)
        self.listaElementosCorpo.append (elem)
            #elipses central

        elem= self.desenharElipse ((0,0,0),3*escala,2*escala,3*escala,self.cor3,0.4,materials.marble)
        self.listaElementosCorpo.append (elem)

            #elipses laterais de adorno

        elem= self.desenharElipse ((0,-0.2*escala,1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharElipse ((0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharElipse ((0,-0.2*escala,-1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharElipse ((-0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)
        self.listaElementosCorpo.append (elem)

 #cilindros (da um formato de 'saia' a agua viva)

        elem= self.desenharCilindro((0,-0.65*escala,0), (0,0.7*escala,0),1.479*escala,self.cor3,0.5)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharCilindro((0,-1*escala,0),(0,0.7*escala,0),1.55*escala,self.cor3,0.5)
        self.listaElementosCorpo.append (elem)

 #aneis (dao aparencias de riscos dentro da 'agua viva')

        elem= self.desenharAnel((-0.1*escala,0,0),(0,0.5*escala,0.1*escala),1.3*escala, 0.002*escala,self.cor5)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharAnel((-0.1*escala,0.3*escala,0),(0,0.5*escala,0.1*escala), 1.1*escala, 0.002*escala,self.cor5)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharAnel((-0.1*escala,0.5*escala,0),(0,0.5*escala,0.1*escala),1*escala, 0.002*escala,self.cor5)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharAnel((-0.1*escala,0.7*escala,0),(0,0.5*escala,0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharAnel((0.1*escala,0,0),(0,0.5*escala,-0.1*escala),1.3*escala,0.002*escala,self.cor5)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharAnel((0.1*escala,0.3*escala,0),(0,0.5*escala,-0.1*escala),1.1*escala,0.002*escala,self.cor5)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharAnel((0.1*escala,0.5*escala,0), (0,0.5*escala,-0.1*escala), 1*escala, 0.002*escala,self.cor5)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharAnel((0.1*escala,0.7*escala,0),(0,0.5*escala,-0.1*escala),0.8*escala,0.004*escala,self.cor5)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharAnel((0.1*escala,1*escala,0),(0,0,0),0.5,0.004*escala,self.cor5)
        self.listaElementosCorpo.append (elem)

 #Espirais

        elem= self.desenharEspiral((0,-0.8*escala,0),(0,1*escala,0), 1.4*escala,0.01*escala,self.cor2,materials.marble)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((0,-0.4*escala,0),(0,1*escala,0), 0.8*escala,0.01*escala,self.cor2,materials.marble)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((0,-1.5*escala,0),(0,1.5*escala,0),0.3*escala,0.3*escala,self.cor2,materials.marble)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((0,-1.1*escala,0),(0,0.7*escala,0),0.8*escala,0.35*escala,self.cor2,materials.marble)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((0.5*escala,-3*escala,0.3*escala),(-0.5*escala,3*escala,0),0.1*escala,0.15*escala,self.cor2,materials.marble)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-0.5*escala,-3*escala,-0.2*escala),(0.5*escala,3*escala,0),0.1*escala,0.15*escala,self.cor2,materials.marble)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((0,-3*escala,0.3*escala),(0,3*escala,0),0.1*escala,0.15*escala,self.cor3,materials.marble)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((2*escala,-2*escala,0.3*escala),(-0.5*escala,1*escala,0),0.05*escala,0.01*escala,self.cor3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-2*escala,-2*escala,0.3*escala),(0.5*escala,1*escala,0),0.05*escala,0.01*escala,self.cor3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((0,-2*escala,-2*escala),(0,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((0,-2*escala,2*escala),(0,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1*escala,-2*escala,-2*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1*escala,-2*escala,-2*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1*escala,-2*escala,2*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1*escala,-2*escala,2*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.5*escala,-2*escala,-1.5*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.5*escala,-2*escala,-1.5*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.5*escala,-2*escala,1.5*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.5*escala,-2*escala,1.5*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.25*escala,-2*escala,-1.75*escala), (-0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.25*escala,-2*escala,-1.75*escala), (0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.25*escala,-2*escala,1.75*escala), (-0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.25*escala,-2*escala,1.75*escala), (0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.75*escala,-2*escala,-1.25*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.75*escala,-2*escala,-1.25*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.75*escala,-2*escala,1.25*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.75*escala,-2*escala,1.25*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.40*escala,-2*escala,-1.60*escala),(-0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.40*escala,-2*escala,-1.60*escala),(0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.40*escala,-2*escala,1.60*escala),(-0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.40*escala,-2*escala,1.60*escala),(0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.6*escala,-2*escala,-1.4*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.6*escala,-2*escala,-1.4*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((1.6*escala,-2*escala,1.4*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-1.6*escala,-2*escala,1.4*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((2*escala,-2*escala,-1*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-2*escala,-2*escala,-1*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((2*escala,-2*escala,1*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        elem= self.desenharEspiral((-2*escala,-2*escala,1*escala), (0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)
        self.listaElementosCorpo.append (elem)

        # Calculo da caixa em volta do animal
        dX= 3*escala/2 + 2*escala/2
        dY= 2*escala
        dZ= 3*escala/2 + 2*escala / 2

        dYBaixo= (dY +  (4*escala)) /2
        dY/= 2

        pontoCima= Ponto (self.esqueleto.pos[0]-dX, self.esqueleto.pos[1]+dY, self.esqueleto.pos[2]-dZ)
        pontoBaixo= Ponto (self.esqueleto.pos[0]+dX, self.esqueleto.pos[1]-dYBaixo, self.esqueleto.pos[2]+dZ)

        self.posicao.setPontoBaixo (pontoBaixo.getX (), pontoBaixo.getY (), pontoBaixo.getZ ())
        self.posicao.setPontoCima (pontoCima.getX (), pontoCima.getY (), pontoCima.getZ ())

        self.posicao.setVetorSentido (-1, 0, 0)


    def matar (self):
        cont= 0

        while cont < self.listaElementosCorpo.__len__ ():
            temp= self.listaElementosCorpo.__getitem__ (cont)
            #if temp.__class__ is "<class 'visual.primitives.helix'>":
            if isinstance(temp, helix):
                temp.helix.visible= 0
            else:
                temp.visible= 0



            cont+= 1

    def buscarMaiorNumero (self, x, y, z):
        if x < 0:
            x*= (-1)

        if y < 0:
            y*= (-1)

        if z < 0:
            z*= (-1)

        maior= x
        if y > maior:
            maior= y

        if z > maior:
            maior= z

        return maior

    def nadar (self, pontoEixo):
        eixo= pontoEixo.getVetor ()
        #incremento= Ponto (self.VELOCIDADE_NADO * eixo[0], self.VELOCIDADE_NADO * eixo[1], self.VELOCIDADE_NADO * eixo[2])
        pontoEixo.multiplicar (self.VELOCIDADE_NADO)
        incremento= pontoEixo
        esqueleto= Ponto (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

        esqueleto.somar (incremento)

        self.esqueleto.pos= esqueleto.getLista ()
        self.posicao.deslocarPontos (incremento)


    # seta em relacao a velocidade normal
    def setVelocidadeNado (self, incremento):
        self.velocidade= self.VELOCIDADE_NADO * incremento

    def nadarPara (self, posicaoFinal):
        xFinal= posicaoFinal[0]
        yFinal= posicaoFinal[1]
        zFinal= posicaoFinal[2]

        x= self.esqueleto.pos[0]
        y= self.esqueleto.pos[1]
        z= self.esqueleto.pos[2]

        #print "Nadando XFINAL %f %f %f\n" % (xFinal, yFinal, zFinal)

        while (x != xFinal) | (y != yFinal) | (z != zFinal):
            xTemp= xFinal - x
            yTemp= yFinal - y
            zTemp= zFinal - z

            maior= self.buscarMaiorNumero (xTemp, yTemp, zTemp)

            self.nadar ( Ponto (xTemp/maior, yTemp/maior, zTemp/maior))
            #print "Nadando  %f %f %f\n" % (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

            x, y, z= self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2]

            if x == xFinal:
                if y == yFinal:
                    if z == zFinal:
                        return


    def desenharElipse(self,posicao=(0,0,0),comprimento=3,altura=2,largura=3,cor=color.yellow,opacidade=0.4, aparencia=materials.unshaded):

        return ellipsoid(

            frame = self.esqueleto,pos = posicao, length = comprimento, height = altura, width = largura, color = cor, opacity = opacidade, material = aparencia

        )

    def desenharCilindro(self,posicao=(0,-0.65,0),eixos=(0,0.7,0),raio=1,cor=color.yellow,opacidade=0.5):

        return cylinder(

            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, color = cor, opacity = opacidade

        )

    def desenharAnel(self,posicao=(0,0,0),eixos=(1,1,1),raio=1,espessura=0.5,cor=color.yellow):

        return ring(

            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, thickness = 0.1, color = cor

        )

    def desenharEspiral(self,posicao=(0,0,0),eixos=(1,1,1),raio=1,espessura=0.01,cor=color.yellow,aparencia=materials.unshaded):

        return helix(

            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, thickness = espessura, color = cor, material = aparencia

        )

"""
if __name__ == "__main__":

    cenario= Cenario()

    cenario.principal()
"""

# Fim