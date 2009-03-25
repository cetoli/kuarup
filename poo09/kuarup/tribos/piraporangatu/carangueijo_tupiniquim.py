from visual import *
from math import *
import Image

THETA_30 = math.pi/6
THETA_45 = math.pi/4
THETA_90 = math.pi/2

class Renderable:
    """Classe que representa um objeto que pode ser renderizado no universo"""

    def __init__(self, frame):

        self.frame = frame
  
    @classmethod
    def loadTexture(self, textureName):
        """Carrega uma textura a partir de um arquivo jpg"""
        name = textureName
        width = 1024
        height = 1024
        im = Image.open(name+".jpg")
        im = im.resize((width,height), Image.ANTIALIAS)
        materials.saveTGA(name,im)
    def rotate(self, axis, angle):
        """Rotaciona um objeto"""
        self.frame.rotate(angle=angle, axis=axis)

class Universe:
    " Representa o lugar onde todos os objetos serao desenhados..."
    def __init__(self):
        # todos os objetos que podem ser desenhados no universo
        self.renderableObjects = []

    def rotate(self,axis, angle):
        [renderable.rotate(axis,angle) for renderable in self.renderableObjects]

class CorpoCaranguejo(Renderable):
    """docstring for CorpoCaranguejo"""
    def __init__(self, frame, sizeSuperior, sizeInferior, formColor, scale=1, posSuperior=vector(0,0,0), posInferior=vector(0,0,0)):
        posSuperior = posSuperior * scale
        sizeSuperior = sizeSuperior * scale
        posInferior = posInferior * scale
        sizeInferior = sizeInferior * scale
        self.parteSuperior = ellipsoid(frame=frame, size=sizeSuperior, pos=posSuperior, color=formColor)
        posParteInferior = self.parteSuperior.pos + vector(0,-0.4 * scale,0)
        self.parteInferior = ellipsoid(frame=frame, pos=posParteInferior,size=sizeInferior, color=formColor)

class Caranguejo(Renderable):

    def __init__(self, scale=1):
        Renderable.__init__(self, frame())
        self.corpo = CorpoCaranguejo(frame=self.frame, scale=scale, sizeSuperior=vector(6.5, 3, 5), sizeInferior=vector(5,4,4) , formColor=color.red)
        self.pontoEsquerda = sphere(frame=self.frame, pos=vector(0.8,0.8,2.0) * scale,radius=0.1 * scale,color=color.black)
        self.pontoDireita  = sphere(frame=self.frame, pos=vector(-0.8,0.8,2.0) * scale ,radius=0.1 * scale,color=color.black)
        self.suporteOlhoDireito = cylinder(frame=self.frame, pos=vector(-0.8,1,1) * scale, axis=vector(0,1.5,0) * scale, radius=0.2 * scale, color=color.red)
        self.suporteOlhoDireito.rotate(angle=THETA_30, axis=(0,0,1))
        self.suporteOlhoEsquerdo = cylinder(frame=self.frame, pos=vector(0.8,1,1) * scale, axis=vector(0,1.5,0) * scale, radius=0.2 * scale, color=color.red)
        self.suporteOlhoEsquerdo.rotate(angle=-THETA_30, axis=(0,0,1))
        self.olhoDireito = sphere(frame=self.frame, pos=vector(-1.7,2.5,1) * scale, radius=0.5 * scale, color=color.white, opacity=0.5)
        self.pupilaDireita = sphere(frame=self.frame, pos=vector(-1.7,2.5,1) * scale, radius=0.25 * scale, color=color.black)
        self.olhoEsquerdo = sphere(frame=self.frame, pos=vector(1.7,2.5,1) * scale, radius=0.5 * scale, color=color.white, opacity=0.5)
        self.pupilaEsquerda = sphere(frame=self.frame, pos=vector(1.7,2.5,1) * scale, radius=0.25 * scale, color=color.black)
        self.bracoDireito = cylinder(frame=self.frame, pos=vector(2.5,0,1) * scale, axis=vector(2,0,0) * scale, radius=0.2 * scale, color=color.red)
        self.bracoDireito.rotate(angle=-THETA_30, axis=(0,0,1))
        self.bracoEsquerdo = cylinder(frame=self.frame, pos=vector(-4,-1,1) * scale, axis=vector(2,0,0) * scale, radius=0.2 * scale, color=color.red)
        self.bracoEsquerdo.rotate(angle=THETA_30, axis=(0,0,1))
        self.garraEsquerdo = ellipsoid(frame = self.frame, pos=vector(4.5,-1.2,1) * scale, size=vector(2.5, 1.5, 2) * scale, color=color.red)
        self.garraEsquerdo.rotate(angle=-THETA_30, axis=(0,0,1))
        self.garraEsquerdo.rotate(angle=-THETA_30*2, axis=(1,0,0))
        self.garraEsquerdo = ellipsoid(frame=self.frame, pos=vector(-4.5,-1.2,1) * scale, size=vector(2.5, 1.5, 2) * scale, color=color.red)
        self.garraEsquerdo.rotate(angle=THETA_30, axis=(0,0,1))
        self.garraEsquerdo.rotate(angle=THETA_30*2, axis=(1,0,0))
        self.pernasDireitas = []
        self.pernasEsquerdas = []
        for i in range(3):
            self.pernasDireitas.append(curve(pos=[vector(1,-1.3,1 - 0.6*i ) * scale, vector(2.5,-1.3,1 - 0.6*i) * scale, vector(3.5,-2.3,1 - 0.6*i) * scale], radius=0.25 * scale,color=color.red))
        for i in range(3):
            self.pernasEsquerdas.append(curve(pos=[vector(-1,-1.3,1 - 0.6*i ) * scale, vector(-2.5,-1.3,1 - 0.6*i) * scale, vector(-3.5,-2.3,1 - 0.6*i) * scale], radius=0.25 * scale,color=color.red))

if __name__ == "__main__":
    # seta a altura e lagura iniciais
    scene.width = scene.height = 600
    #Cria o universo...
    universe = Universe()
    universe.renderableObjects.append(Caranguejo())
