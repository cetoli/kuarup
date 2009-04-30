#! /usr/bin/env python
# -*- coding: UTF8 -*-

"""
############################################
Logica 
############################################
"""

from visual import *
from pangacio3 import *
from domino12 import *
from domino23 import *
from domino34 import *
from domino45 import *
from domino56 import *
from domino66 import *
from domino13 import *
from domino24 import *

TITLE = 'Logica'

import Image
import ImageGrab

class Cenario:
    
    def principal(self):
        myscene = display.get_selected()
        myscene.center = (0,0,0)
        myscene.width = 550
        myscene.height = 550
        myscene.x = 0
        myscene.y = 0
                
        # Instanciando os peixes do aquário
        pangacio1=Pangacio(escala = 1, axis=(1,0,0), pos= (-10,-75,5))         # Este é você!
        pangacio1.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        # Delimitação do aquário
        side = 100
        thk = 0.3
        s2 = 2*side - thk
        s3 = 2*side + thk
        
        arrumados = box(pos=(-20, 50, -5), length=120,  height=40,  width=thk, color = color.cyan, opacity=1)

        # tabuleiro a ser completado
        D12 = domino12(pos=(-60,50,0), escala=1)
        D12.esqueleto.rotate(angle=pi/2., axis=(1,0,0))
        
        D23 = domino23(pos=(-40,50,0), escala=1)
        D23.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        D34 = domino34(pos=(-20,50,0), escala=1)
        D34.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        D56 = domino56(pos=(20,50,0), escala=1)
        D56.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        # escolha a peca certa para completar

        D45 = domino45(pos=(15,0,0), escala=1)
        D45.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        D66 = domino66(pos=(-15,0,0), escala=1)
        D66.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        D13 = domino13(pos=(38,0,0), escala=1)
        D13.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        D24 = domino24(pos=(-50,0,0), escala=1)
        D24.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        


        # Saída
        saida = box (pos=(0, -side, 0), length=20,  height=2*thk, width=10,  color = color.yellow, opacity=0)

        # Boas vindas!
        info1 = label(pos=(0,80,0),box = 0, text='Complete a sequencia...', color = color.white, opacity=1)
        
        pangacio1.mass = 1.0
        pangacio1.p = vector (0,1,0)
      
        side = side - thk*0.5 - pangacio1.esqueleto.x
        
        quadro=0
        aux = 0
        dt = 0.5
        t=0
        auxLado = 0
        auxEsquerdaDireita = 0
         
        while 1:
            # Captura de GIFs
            aux += 1
            if( aux == 5) :
                im = ImageGrab.grab((0,0,550,550))
                fn = "logica-"+str(quadro)+".png"
                im.save(fn)
                aux = 0
            #    
            rate(30)
            
            # Controle o seu peixe!
            if scene.kb.keys:
                s = scene.kb.getkey()

                # Controle do Pangacio
                if (s == 'up'):
                    pangacio1.p = vector (0,1,0)
                    if (pangacio1.esqueleto.y >= 121):
                        auxLado += 0
                    else:
                        auxLado += 1

                elif (s == 'down'):
                    pangacio1.p = vector (0,-1,0)
                    if (pangacio1.esqueleto.y <= -110):
                        auxLado -= 0
                    else:    
                        auxLado -= 1
                    
                elif (s == 'left'):
                    pangacio1.p = vector (-1,0,0)
                    if (pangacio1.esqueleto.x <= -90):
                        auxEsquerdaDireita -= 0
                    else:
                        auxEsquerdaDireita -= 1

                elif (s == 'right'):
                    pangacio1.p = vector (1,0,0)
                    if (pangacio1.esqueleto.x >= 90):
                        auxEsquerdaDireita += 0
                    else:
                        auxEsquerdaDireita += 1

                elif (s == 'q'):
                    print 'TCHAU'
                    break
                    quit

            pangacio1.esqueleto.axis.y = pangacio1.p.y + auxLado
            pangacio1.esqueleto.axis.x = pangacio1.p.x + auxEsquerdaDireita
            pangacio1.esqueleto.axis.z = pangacio1.p.z
            pangacio1.esqueleto.y += auxLado
            pangacio1.esqueleto.x += auxEsquerdaDireita
            rate(100)
            t = t + dt
            auxLado = 0
            auxEsquerdaDireita = 0

            # Acerta Domino
            if (fabs(pangacio1.esqueleto.x - D45.esqueleto.x) < 15) and ( fabs (pangacio1.esqueleto.y - D45.esqueleto.y) < 15 ):
                D45.esqueleto.pos = (0,50,0)
                    
                              

            # Proximo quadro da filmagem
            pangacio1.proximoFrame()
            quadro += 1


'''
Classe base de qualquer ser marinho
'''
class SerMarinho():
    def __init__(self, escala= 1, **qualquel_outro_parametro):
        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"
        self.esqueleto=frame(**qualquel_outro_parametro)
        self.desenha(escala)

    def desenha(self): pass

        
if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()

