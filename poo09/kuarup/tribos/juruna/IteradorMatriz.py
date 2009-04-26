from Matriz import *

class IteradorMatriz:
    def __init__ (self, matriz):
        self.matriz= matriz
        self.linha= 0
        self.coluna= 0
        self.tamLinhas= matriz.getQtdLinhas ()
        self.tamColunas= matriz.getQtdColunas ()

    def proximo (self):
        if (self.coluna >= self.tamColunas) & (self.linha >= self.tamLinhas):
            return None

        elem= self.matriz.getItem (self.linha, self.coluna)

        self.coluna+= 1
        if self.coluna >= self.tamColunas:
            self.coluna= 0
            self.linha+= 1

        return elem

    def temProximo (self):
        if self.matriz == None:
            return False

        if (self.linha >= self.tamLinhas):
            return False

        return True

# Fim