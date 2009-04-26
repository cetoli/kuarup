from Command import *

class SelecaoCommand (Command):

    def executar (self, peixe, tela, estrategia):
        estrategia.selecionar (peixe.getPontoEsqueleto ())


# Fim