from Ativa import *
from Resolvida import *
from Selecionada import *

class EstadoFactory:
    def criarEstadoInicial (self):
        return Ativa ()

    def criarProximoEstado (self, atual, dentroPeca, selecionou= False, resolvido= False, temSelecaoAnt= False):
        nomeClasse= atual.proximoNivel (dentroPeca, selecionou, resolvido, temSelecaoAnt)

        if nomeClasse != "":
            return eval (nomeClasse)

        return None


# Fim