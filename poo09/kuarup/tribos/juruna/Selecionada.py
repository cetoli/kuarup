from State import *

class Selecionada (State):
    def __init__ (self):
        self.tipo= "SELECIONADA"

    def proximoNivel (self, dentroPeca, selecionou= False, resolvido= False, temSelecaoAnt= False):
        if resolvido == True:
            return "Resolvida ()"
        else: # ou selecionou elemento com valor diferente ou selecionou pela 2 vez a peca (= deselecionar).
            return "Ativa ()"

        return ""

    def getSelecionada (self):
        return True

    def getResolvida (self):
        return False


# Fim