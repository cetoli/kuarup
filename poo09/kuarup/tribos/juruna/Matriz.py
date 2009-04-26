class Matriz(object):
    def __init__(self, linhas, colunas, valorInicializacao= 0):
        self.cols = colunas
        self.linhas = linhas

        #inicializa a matriz e preenche com 0.
        self.matriz = []
        for i in range(linhas):
            vetLinha = []

            for j in range(colunas):
                vetLinha.append(valorInicializacao)

            self.matriz.append(vetLinha)

    def setItem(self, linha, col, v):
        self.matriz[linha][col] = v

    def getItem(self, linha, col):
        if (linha >= self.linhas) | (col >= self.cols):
            return None

        if (linha < 0) | (col < 0):
            return None

        return self.matriz[linha][col]

    def getQtdLinhas (self):
        return self.linhas

    def getQtdColunas (self):
        return self.cols

    def __repr__(self):
        strMatriz = ""
        for i in range(self.linhas):
            strMatriz += 'Linha %s = %s\n' % (i+1, self.matriz[i])

        return strMatriz

# Fim