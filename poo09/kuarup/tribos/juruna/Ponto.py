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


    def getX (self):
        return self.x


    def getY (self):
        return self.y


    def getZ (self):
        return self.z


    def getLista (self):
        return (self.x, self.y, self.z)


    def getVetor (self):
        return vector (self.x, self.y, self.z)


    def somar (self, valor, eixo):
        if eixo[0] > 0:
            self.x+= valor

        if eixo[1] > 0:
            self.y+= valor

        if eixo[2] > 0:
            self.z+= valor


    # calculo da elipse
    def calcularParametrica (self, x0, y0, x, xM, yM):
        print "xm %f e ym %f \n" % (xM, yM)
        print "x0 %f e y0 %f x %f \n" % (x0, y0, x)

        if xM > yM:
            return self.calcularParametricaHorizontal (x0, y0, x, xM, yM)
        else:
            return self.calcularParametricaVertical (x0, y0, x, xM, yM)


    def calcularParametricaHorizontal (self, x0, y0, x, xM, yM):
        # (y - yo)^2 / ym^2 + (x - x0)^2 / xm^2 = 1

        # (y - y0)^2 = ( 1 - (x - x0)^2 / xm^2 ) * ym^2

        valorX= math.pow ( (x-x0), 2) / math.pow(xM, 2)
        print "math.pow ( (x-x0), 2) %f, math.pow(xM, 2) %f, valorX= %f \n" % (math.pow ( (x-x0), 2), math.pow(xM, 2), valorX)
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

# fim