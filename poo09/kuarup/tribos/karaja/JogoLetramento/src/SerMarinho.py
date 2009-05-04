from visual import *

from PIL import Image
from PIL import ImageGrab


TITLE = 'SerMarinho'


filelist = ""
basename = "img_"; extname = ".gif"
ImageWidth = 450; ImageHeight = 450
cont = 1
controleFoto = 1


'Classe base dos seres marinhos'

class SerMarinho():
    
    def __init__(self, escala= 1, **qualquel_outro_parametro):

        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"

        self.esqueleto=frame(**qualquel_outro_parametro)

        self.escala = escala

        self.desenha(escala)
        
    def desenha(self): pass
    
    def getPosition(self):

        return (self.esqueleto.pos)
 
    def setPosition(self, pos):

        self.esqueleto.pos = pos

    def getAxis(self):

        return self.esqueleto.axis
 
    def setAxis(self, axis):

        self.esqueleto.axis = axis

    def getVelocidade(self):

        return self.velocidade

    def setVelocidade(self, velocidade = 0):

        self.velocidade = velocidade
        
    def mover(self, tipo, newPosition, salto):
    # tipo (axis ou position)
    # coordenadas (x,y,z)
    # salto (distancia entre um ponto da animacao e outro)

        # Pegar posicao original do objeto

        if tipo == "position":

            pos = self.getPosition()

        elif tipo == "axis":

            pos = self.getAxis()
            

        # Verificar distancia a ser movida na coordenada x

        if pos.x > newPosition["x"]:

            distX = pos.x - newPosition["x"]

        else:

            distX = newPosition["x"] - pos.x
            

        # Verificar distancia a ser movida na coordenada y

        if pos.y > newPosition["y"]:

            distY = pos.y - newPosition["y"]

        else:

            distY = newPosition["y"] - pos.y


        # Verificar distancia a ser movida na coordenada z

        if pos.z > newPosition["z"]:

            distZ = pos.z - newPosition["z"]

        else:

            distZ = newPosition["z"] - pos.z


        # Loop para fazer a animacao com a velocidade pre-determinada

        while distX > 0 or distY > 0 or distZ > 0:
            
            self.fotografar()

            rate(self.getVelocidade())


            # Pegar posicao original do objeto

            if(tipo == "position"):

                pos = self.getPosition()

            elif tipo == "axis":

                pos = self.getAxis()

 
            # Move se a distancia X ainda e maior do que zero

            if distX > 0:

                # Condicao para diferenciar valores negativos e positivos

                if pos.x > newPosition["x"]:

                    moverX = pos.x - salto

                else:

                    moverX = pos.x + salto

                distX -= salto

            else:

                moverX = pos.x

 
            # Move se a distancia Y ainda e maior do que zero

            if distY > 0:

                # Condicao para diferenciar valores negativos e positivos              

                if pos.y > newPosition["y"]:

                    moverY = pos.y - salto

                else:

                    moverY = pos.y + salto

                distY -= salto

            else:

                moverY = pos.y


            # Move se a distancia Z ainda e maior do que zero

            if distZ > 0:

                # Condicao para diferenciar valores negativos e positivos          

                if pos.z > newPosition["z"]:

                    moverZ = pos.z - salto

                else:

                    moverZ = pos.z + salto

                distZ -= salto

            else:

                moverZ = pos.z

 
            # Mover ou girar o objeto

            if(tipo == "position"):

                self.setPosition((moverX, moverY, moverZ))

            elif tipo == "axis":

                self.setAxis((moverX, moverY, moverZ))

    def fotografar(self):

        global controleFoto

        if controleFoto % 20 == 0:        

            im = ImageGrab.grab((4,30,ImageWidth-4,ImageHeight-4))

            global filename

            filename = basename+str(cont)+extname

            global filelist

            filelist += filename + " "

            im.save(filename)

            global cont

            cont += 1

        controleFoto += 1


if __name__ == "__main__":

    cenario = Cenario()

    cenario.principal()
