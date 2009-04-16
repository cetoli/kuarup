#!/usr/bin/python

from visual import *
from peixe_xavante import *
from peixe_potiguara import *
from tubarao import *
from aguaviva import *


def move_shark (shark, pos_fish, velocidade):
    pos = [0,0]
    pos[0] = shark.esqueleto.pos[0]
    pos[1] = shark.esqueleto.pos[1]

    if pos[0] != pos_fish[0]:
        tg = (pos[1]-pos_fish[1]) / (pos[0]-pos_fish[0])
        ang = arctan(tg)
        if pos_fish[0] < pos[0]:
            ang += pi
    else:
        if pos_fish[1] > pos[1]:
            ang = pi/2
        else:
            ang = -pi/2
    shark.rotate(angle=ang+shark.angle, axis=(0,0,1))
    shark.angle = -ang

    dir    = [0,0]
    dir[0] = pos_fish[0] - pos[0]
    dir[1] = pos_fish[1] - pos[1]
    dir    = norm (dir)

    pos[0] += dir[0] * velocidade
    pos[1] += dir[1] * velocidade

    shark.move(pos)


def move_aguasvivas (aguasvivas):
    for av in aguasvivas:
        if (av.esqueleto.pos[0] < 0.0):
            av.dir = +1.0
        elif (av.esqueleto.pos[0] > 9.0):
            av.dir = -1.0

        pos = av.esqueleto.pos[0]
        pos += av.dir * 0.1

        av.esqueleto.pos = (pos, av.esqueleto.pos[1], av.esqueleto.pos[2])


def init_window ():
    scene.title      = "Colaboradores"
    scene.width      = 600 +  9
    scene.height     = 600 + 30

    scene.autocenter = 1
    scene.autoscale  = 1

    scene.forward = (0, -1.65, -1)
    scene.scale   = (0.095, 0.095, 0.095)
    scene.up      = (0, 0, pi)

    cm=255.0
    scene.background=(128/cm,128/cm,255/cm)

    box (pos=(-1.0,  9.5, 0.5), length= 1, height=20, width=1, color=color.blue)
    box (pos=(10.0,  9.5, 0.5), length= 1, height=20, width=1, color=color.blue)
    box (pos=( 4.5, -1.0, 0.5), length=12, height= 1, width=1, color=color.blue)
    
    box (pos=( 1.0, 20.0, 0.5), length= 5, height= 1, width=1, color=color.blue)
    box (pos=( 8.0, 20.0, 0.5), length= 5, height= 1, width=1, color=color.blue)

    return box (pos=(4.5, 20.0, 0.5), length=2, height=1, width=1, color=color.blue)


i=0
def grava_quadro ():
    global i
    os.system ("import -window Colaboradores img%03d.jpg" % i)
    i += 1

if __name__ == "__main__":

    porta = init_window()

    width  = 10
    height = 20

    velocidade_tubarao = 0.045

    #inicializacao dos peixes
    peixe1 = PeixeXavante(material=materials.marble)
    peixe1.rotate(angle=-pi/2, axis=(0,0,1))

    peixe2 = Pangacio (escala=0.025)
    peixe2.rotate(angle=pi/2, axis=(1,0,0))

    #criando os tubaroes
    tubarao1 = Tubarao (escala=0.03)
    tubarao1.rotate(angle=pi/2, axis=(1,0,0))
    tubarao1.move ( (0.5, 18.5) )

    tubarao2 = Tubarao (escala=0.03)
    tubarao2.rotate(angle=pi/2, axis=(1,0,0))
    tubarao2.move ( (0.0, 10.5) )

    #criando as aguas-vivas
    aguasvivas = []
    aguasvivas.append ( AguaViva(escala=0.2) )
    aguasvivas[-1].rotate(angle=pi, axis=(0,0,1))
    aguasvivas[-1].rotate(angle=-pi/2, axis=(1,0,0))
    aguasvivas[-1].move((5.0, 5.5))
    aguasvivas.append ( AguaViva(escala=0.2) )
    aguasvivas[-1].rotate(angle=pi, axis=(0,0,1))
    aguasvivas[-1].rotate(angle=-pi/2, axis=(1,0,0))
    aguasvivas[-1].move((2.5, 10.5))
    aguasvivas.append ( AguaViva(escala=0.2) )
    aguasvivas[-1].rotate(angle=pi, axis=(0,0,1))
    aguasvivas[-1].rotate(angle=-pi/2, axis=(1,0,0))
    aguasvivas[-1].move((0.0, 15.5))

    #criando os botoes
    botao1 = box (pos=(0, 9.5, -0.1), length=0.5, height=0.5, width=0)
    botao1.color = color.red
    botao2 = box (pos=(9, 9.5, -0.1), length=0.5, height=0.5, width=0)
    botao2.color = color.red

    #travando a camera
    scene.autocenter = 0
    scene.autoscale  = 0

    #peixes vao de encontro aos botoes
    raio   = 9.5
    passos = 150
    inicio = pi/2
    fim    = pi
    passo  = (fim-inicio)/passos
    for teta in arange(inicio, fim, passo):
        rate(30)

        x = raio * cos(teta) + 9.5
        y = raio * sin(teta) + 9.5

        peixe1.move( (x,y) )
        peixe1.rotate (angle=passo, axis=(0,0,1))

        move_shark (tubarao1, (x,y), velocidade_tubarao )


        x = raio * cos(teta+pi) - 0.5
        y = raio * sin(teta+pi) + 9.5
        
        peixe2.move( (x,y) )
        peixe2.rotate (angle=passo, axis=(0,0,1))
        
        move_shark (tubarao2, (x,y), velocidade_tubarao )

        move_aguasvivas (aguasvivas)
        
        grava_quadro()

    #portao abre e botoes mudam de cor
    porta.visible = 0
    botao1.color = color.green
    botao2.color = color.green
    
    peixe1.rotate (angle=pi/2, axis=(0,0,1))
    peixe2.rotate (angle=pi/2, axis=(0,0,1))

    #peixes vao em direcao a saida
    raio   =  4.5
    passos = 150
    inicio = (3*pi)/2
    fim    = 2.07*pi
    passo  = (fim-inicio)/passos
    for teta in arange(inicio, fim, passo):
        rate(30)

        x = raio * cos(teta)
        y = 2 * (raio * sin(teta) + 14) - 9.5

        peixe1.move( (x,y) )
        peixe1.rotate (angle=passo, axis=(0,0,1))

        move_shark (tubarao1, (x,y), velocidade_tubarao )


        x = raio * cos(teta+pi) + 9.0
        y = 2 * (14 - raio * sin(teta+pi)) - 9.5
        
        peixe2.move( (x,y) )
        peixe2.rotate (angle=-passo, axis=(0,0,1))
        
        move_shark (tubarao2, (x,y), velocidade_tubarao )
        
        move_aguasvivas (aguasvivas)

        grava_quadro()
