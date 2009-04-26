from State import *

class Ativa (State):
    def __init__ (self):
        self.tipo= "ATIVA"

    def proximoNivel (self, dentroPeca, selecionou= False, resolvido= False, temSelecaoAnt= False):
        if selecionou == True:
            if temSelecaoAnt == False:
                return "Selecionada ()"
            elif resolvido == True:
                return "Resolvida ()"
            else:
                return ""

        return ""

    def getSelecionada (self):
        return False

    def getResolvida (self):
        return False


# Fim