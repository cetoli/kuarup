from visual import *
from marine import *


class SerMarinho(Marine):
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=self.frame
        self.render(escala)

    def render(escala): pass
