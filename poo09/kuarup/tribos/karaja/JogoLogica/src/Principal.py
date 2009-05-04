# -*- coding: cp1252 -*-

from visual import *
from PeixeEspada import *
from SerMarinho import SerMarinho
from math import *
import Image
import ImageGrab


TITLE = 'Letramento Karaja'

class Cenario:

    def __init__(self):

        self.scene2 = display(title=TITLE,
                         width=450,
                         height=450,
                         center= (0,0,0),
                         x=0,
                         y=0)

        self.scene2.x, self.scene2.y = 0, 0

        self.scene2.select()

        self.scene2.autoscale = 0
        
        self.palavraEmFormacao = []
        
        self.palavras = []

        

    def principal(self):

        peixeEspada = PeixeEspada(escala = 0.5, pos= (0,0,-30), axis=(0,-1,1))

        wallA = box(pos=(-27,0,-30), axis=(1,0,0), length=0.5, height=49, width=5, color = color.yellow)
        wallB = box(pos=(27,0,-30), axis=(1,0,0), length=0.5, height=49, width=5, color = color.yellow)
        wallC = box(pos=(0,24.5,-30), axis=(1,0,0), length=54.5, height=0.5, width=5, color = color.yellow)
        wallD = box(pos=(0,-24.5,-30), axis=(1,0,0), length=54.5, height=0.5, width=5, color = color.yellow)
        wallE = box(pos=(0,10,-30), axis=(1,0,0), length=54.5, height=0.5, width=5, color = color.yellow)
        
        #sequencia 1
        letraA = label(pos=(-23,21,-30), text='1' ,box=0)
        caixa1 = box(pos=(-20,21,-30), axis=(0,5,0), size=(2,2,2), color = color.blue)
        caixa2 = box(pos=(-16,21,-30), axis=(0,5,0), size=(3.5,3.5,3.5), color = color.magenta)
        caixa3 = box(pos=(-10,21,-30), axis=(0,5,0), size=(5,5,5), color = color.green)
        caixa4 = box(pos=(-4,21,-30), axis=(0,5,0), size=(3.5,3.5,3.5), color = color.green)
        caixa5 = box(pos=(0,21,-30), axis=(0,5,0), size=(2,2,2), color = color.magenta)
        
         #sequencia 2
        letraB = label(pos=(-23,13,-30), text='2' ,box=0)
        caixa11 = pyramid(pos=(-19,12,-30), axis=(0,5,0), size=(3,3,3), color = color.blue)
        caixa21 = box(pos=(-15,13,-30), axis=(0,5,0), size=(3,3,3), color = color.magenta)
        caixa31 = sphere(pos=(-10,13,-30), axis=(0,5,0), radius=2, color = color.green)
        caixa41 = pyramid(pos=(-4,11,-30), axis=(0,5,0), size=(4,4,4), color = color.blue)
        caixa51 = box(pos=(0,13,-30), axis=(0,5,0), size=(3,3,3), color = color.magenta)
        
         #sequencia3
        letraA2 = label(pos=(5,19,-30), text='3' ,box=0)
        caixa12 = sphere(pos=(8,19,-30), axis=(0,5,0), radius=1,  color = color.cyan)
        caixa22 = sphere(pos=(11,19,-30), axis=(0,5,0), radius=1.5, color = color.red)
        caixa32 = sphere(pos=(15,19,-30), axis=(0,5,0), radius=1.8, color = color.green)
        caixa42 = sphere(pos=(19.7,19,-30), axis=(0,5,0), radius=2, color = color.blue)
        caixa52 = sphere(pos=(24.5,19,-30), axis=(0,5,0), radius=2.2, color = color.orange)
        
         #sequencia 4
        letraA2 = label(pos=(5,14,-30), text='4' ,box=0)
        caixa12 = pyramid(pos=(8,12,-30), axis=(0,5,0), size=(2,2,2), color = color.cyan)
        caixa22 = pyramid(pos=(12,12,-30), axis=(0,5,0), size=(3,3,3), color = color.cyan)
        caixa32 = pyramid(pos=(16.5,12,-30), axis=(0,5,0), size=(4,4,4), color = color.green)
        caixa42 = pyramid(pos=(20.5,12,-30), axis=(0,5,0), size=(3,3,3), color = color.green)
        caixa52 = pyramid(pos=(23.5,12,-30), axis=(0,5,0), size=(2,2,2), color = color.cyan)
        #piramide = pyramid(pos=(-10,10,-30), axis = (0,1,0), size=(7,7,7), color = color.green)
      
        
        label(pos=(0,5,-35), text='Qual objeto nunca completaria nenhuma das sequencias?', height=12 , box=0)
        #label(pos=(0,17,-35), text='(Aperte ESPACO quando terminar)!', height=14,box=0 )
        
        opcao1 = pyramid(pos=(-21,-16,-30), axis=(0,5,0), size=(2,2,2), color = color.cyan)
        opcao2 = box(pos=(-11,-16,-30), axis=(0,5,0), size=(2,2,2), color = color.blue)
        opcao3 = sphere(pos=(0,-16,-30), axis=(0,5,0), radius=2, color = color.green)
        opcao4 = box(pos=(11,-16,-30), axis=(0,5,0), size=(2,2,2), color = color.magenta)
        opcao5 = sphere(pos=(21,-16,-30), axis = (0,5,0), radius=3.2, color = color.magenta)

      
        peixeEspada.p = vector (0,-1,1)

        quadro = 0        

        auxVerticalpeixeEspada = 0
        auxHorizontalpeixeEspada = 0
 


        labelErrou = label(pos=(0,10,-30), text='',box=0)

        while 1:
            if (fabs(peixeEspada.esqueleto.x - opcao1.x) < 5) and ( fabs (peixeEspada.esqueleto.y - opcao1.y) < 5 ):
                   
                    labelErrou = label(pos=(0,10,-30), text='Você errou!', height=14 , color=color.red)

            elif (fabs(peixeEspada.esqueleto.x - opcao2.x) < 5) and ( fabs (peixeEspada.esqueleto.y - opcao2.y) < 5 ):
                    labelErrou  = label(pos=(0,10,-30), text='Você errou!', height=14 , color=color.red)
            elif (fabs(peixeEspada.esqueleto.x - opcao3.x) < 5) and ( fabs (peixeEspada.esqueleto.y - opcao3.y) < 5 ):
                    labelErrou  = label(pos=(0,10,-30), text='Você errou!', height=14 , color=color.red)
            elif (fabs(peixeEspada.esqueleto.x - opcao4.x) < 5) and ( fabs (peixeEspada.esqueleto.y - opcao4.y) < 5 ):
                    labelErrou  = label(pos=(0,10,-30), text='Parabens, voce acertou!', height=14 , color=color.green)
            elif (fabs(peixeEspada.esqueleto.x - opcao5.x) < 5) and ( fabs (peixeEspada.esqueleto.y - opcao5.y) < 5 ):
                    labelErrou  = label(pos=(0,10,-30), text='Você errou!', height=14 , color=color.red)
                 

    
# Controle dos peixes           

            if self.scene2.kb.keys:

                s = self.scene2.kb.getkey()


                #UP
                if (s == 'up'):

                    peixeEspada.p = vector (0,1,1)

                    if (peixeEspada.esqueleto.y <= 9):

                        auxVerticalpeixeEspada += 1

                    else:

                        auxVerticalpeixeEspada += 0

                #DOWN            
                elif (s == 'down'):

                    peixeEspada.p = vector (0,-1,1)

                    if (peixeEspada.esqueleto.y <= -18):

                        auxVerticalpeixeEspada -= 0

                    else:

                        auxVerticalpeixeEspada -= 1

                #LEFT
                elif (s == 'left'):

                    peixeEspada.p = vector (-1,0,0)

                    if (peixeEspada.esqueleto.x <= -22):

                        auxHorizontalpeixeEspada -= 0

                    else:

                        auxHorizontalpeixeEspada -= 1

                #RIGHT
                elif (s == 'right'):

                    peixeEspada.p = vector (1,0,0)

                    if (peixeEspada.esqueleto.x >= 22):

                        auxHorizontalpeixeEspada += 0

                    else:

                        auxHorizontalpeixeEspada += 1
          
        
                #QUIT
                elif (s == 'q'):

                    print 'TCHAU'

                    break

                    quit
                
            peixeEspada.esqueleto.axis.y = peixeEspada.p.y + auxVerticalpeixeEspada
            peixeEspada.esqueleto.axis.x = peixeEspada.p.x + auxHorizontalpeixeEspada
            peixeEspada.esqueleto.axis.z = peixeEspada.p.z

            peixeEspada.esqueleto.y += auxVerticalpeixeEspada

            peixeEspada.esqueleto.x += auxHorizontalpeixeEspada


            peixeEspada.fotografar()

            #tc = tc + dt

            rate(100)

            auxVerticalpeixeEspada = 0

            auxHorizontalpeixeEspada = 0

    

if __name__ == "__main__":

    cenario = Cenario()

    cenario.principal()
