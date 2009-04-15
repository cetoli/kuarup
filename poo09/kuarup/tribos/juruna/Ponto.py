from __future__ import division
import math
from visual import *

class Ponto:
    x= 0
    y= 0
    z= 0

    def __init__ (self, x=0, y=0,z=0):
        self.x= x
        self.y= y
        self.z= z


    def clonar (self):
        return Ponto (self.x, self.y, self.z)


    def getX (self):
        return self.x

    def getY (self):
        return self.y

    def getZ (self):
        return self.z


    def setX (self, x):
        self.x= x

    def setY (self, y):
        self.y= y

    def setZ (self, z):
        self.z= z

    def adicionarX (self, x):
        self.x+= x

    def adicionarY (self, y):
        self.y+= y

    def adicionarZ (self, z):
        self.z+= z


    def multiplicarX (self, inc):
        self.x*= inc

    def multiplicarY (self, inc):
        self.y*= inc

    def multiplicarZ (self, inc):
        self.z*= inc

    def getLista (self):
        return (self.x, self.y, self.z)


    def getVetor (self):
        return vector (self.x, self.y, self.z)


    def somar (self, valor, eixo= (1,1,1)):
            self.x+= valor.getX ()
            self.y+= valor.getY ()
            self.z+= valor.getZ ()

    def multiplicar (self, fator):
        self.x*= fator
        self.y*= fator
        self.z*= fator

    def imprimir (self, rotulo):
        print "%s - (%f, %f, %f)\n" % (rotulo, self.x, self.y, self.z)

    # calculo da elipse
    def calcularParametrica (self, x0, y0, x, xM, yM):
        if xM > yM:
            return self.calcularParametricaHorizontal (x0, y0, x, xM, yM)
        else:
            return self.calcularParametricaVertical (x0, y0, x, xM, yM)


    def calcularParametricaHorizontal (self, x0, y0, x, xM, yM):
        # (y - yo)^2 / ym^2 + (x - x0)^2 / xm^2 = 1

        # (y - y0)^2 = ( 1 - (x - x0)^2 / xm^2 ) * ym^2

        valorX= math.pow ( (x-x0), 2) / math.pow(xM, 2)
        #print "math.pow ( (x-x0), 2) %f, math.pow(xM, 2) %f, valorX= %f \n" % (math.pow ( (x-x0), 2), math.pow(xM, 2), valorX)
        return  math.sqrt ( (1-valorX) * math.pow (yM, 2)) + y0


    def calcularParametricaVertical (self, x0, y0, x, xM, yM):
        # (y - yo)^2 / xm^2 + (x - x0)^2 / ym^2 = 1

        # (y - y0)^2 = ( 1 - (x - x0)^2 / ym^2 ) * xm^2

        valorX= math.pow ( (x-x0), 2) / math.pow (yM, 2)
        return  math.sqrt ( (1-valorX) * math.pow (xM, 2)) + y0


    # calculo da circunferencia
    def calcularCircunferencia (self, x0, y0, x, r):
        #  (x - y0) ^2 + (y - x0)^2 = r^2

        parte1= math.pow (x-y0, 2)

        parte1= math.pow (r, 2) - parte1

        return math.sqrt (parte1) + x0

    def calcularDistanciaEntrePontos (self, ponto2):
        x2= ponto2.getX ()
        y2= ponto2.getY ()
        z2= ponto2.getZ ()

        x= math.pow (self.x - x2, 2)
        y= math.pow (self.y - y2, 2)
        z= math.pow (self.z - z2, 2)

        return math.sqrt(x+y+z)
# fim
