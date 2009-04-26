class Observer:
    def __init__ (self, listener, tabuleiro):
        self.listener= listener
        self.tabuleiro= tabuleiro

    def informarMudancaEstado (self, peca, estadoAntigo, estadoNovo):
        self.listener.receberInformacaoMudancaEstado (self.tabuleiro, peca, estadoAntigo, estadoNovo)