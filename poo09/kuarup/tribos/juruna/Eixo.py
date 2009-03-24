from __future__ import division
from visual import *

class Eixo:
    EIXO_Z= (0, 0, 1)
    EIXO_X= (1, 0, 0)
    EIXO_Y= (0, 1, 0)

    EIXO_NE= (1, 1, 0)
    EIXO_SE= (1, -1, 0)
    EIXO_X_Z= (0, 1, 1)

    def converterGrausRadiano (self, graus):
        return graus*pi/180

    def calcularRazao (self, posicao):
        return 1

#fim
