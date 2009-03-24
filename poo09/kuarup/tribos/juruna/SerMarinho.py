from visual import *
from Ponto import *
import Image

# Classe generica do ser marinho
class SerMarinho:
    posicao= Ponto (0,0,0)
    VELOCIDADE_NADO= 0.5 # 0.2

    def __init__ (self, escala= 1, **complemento):
        self.esqueleto= frame (**complemento)
        self.escala= escala

        print "Construtor: X %f Y %f Z %f\n" % (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])

        self.posicao= Ponto (0,0,0) #Ponto (self.esqueleto.pos[0], self.esqueleto.pos[1], self.esqueleto.pos[2])


    def carregarTextura (self, arquivo, tipoMapeamento, comprimento, altura):
        im= Image.open (arquivo)
        im= im.resize ((comprimento,altura), Image.ANTIALIAS)
        return materials.texture (data=im, mapping=tipoMapeamento, interpolate=False)

    def nadar (self):
        pass

    def girar (self, angulo, eixo):
        pass

    def desenhar (self):
        pass
