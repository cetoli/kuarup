from State import *

class Resolvida (State):
    def __init__ (self):
        self.tipo= "RESOLVIDA"

    def proximoNivel (self, dentroPeca, selecionou= False, resolvido= False, temSelecaoAnt= False):
        return ""

    def getSelecionada (self):
        return False

    def getResolvida (self):
        return True


# Fim