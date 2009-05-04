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

        peixeEspada = PeixeEspada(escala = 0.3, pos= (0,0,-30))

        wallA = box(pos=(-27,0,-30), axis=(1,0,0), length=0.5, height=49, width=5, color = color.yellow)
        wallB = box(pos=(27,0,-30), axis=(1,0,0), length=0.5, height=49, width=5, color = color.yellow)
        wallC = box(pos=(0,24.5,-30), axis=(1,0,0), length=54.5, height=0.5, width=5, color = color.yellow)
        wallD = box(pos=(0,-24.5,-30), axis=(1,0,0), length=54.5, height=0.5, width=5, color = color.yellow)
        wallE = box(pos=(0,-18.5,-30), axis=(1,0,0), length=54.5, height=0.5, width=5, color = color.yellow)
        self.palavrasJaFormadas = label(pos=(-9,-21.5,-30),text='', height=9 , box=0) 
        
        label(pos=(0,20,-35), text='Forme pelo menos 5 palavras com as letras abaixo!', height=14 , box=0)
        label(pos=(0,17,-35), text='(Aperte ESPACO quando terminar)!', height=14,box=0 )
        
        
        
        letraA = label(pos=(0,4,0), text='A' ,box=0)
        letraR = label(pos=(8,0,0), text='R' ,box=0)
        letraT = label(pos=(-8,0,0), text='T' ,box=0)
        letraO1 = label(pos=(-4,5,0), text='O' ,box=0)
        letraO2 = label(pos=(0,-5,0), text='O' ,box=0)
        letraE = label(pos=(4,-4,0), text='E' ,box=0)
        letraP = label(pos=(-4,-4,0), text='P' ,box=0) 

        peixeEspada.p = vector (0,-1,1)

        quadro = 0        

        auxVerticalpeixeEspada = 0
        auxHorizontalpeixeEspada = 0
 

        while 1:

            if (fabs(peixeEspada.esqueleto.x - letraA.x) < 2) and ( fabs (peixeEspada.esqueleto.y - letraA.y) < 2 ):
                    #label1 = label(pos=(0,7,-30), text='OK', height=10, color=color.blue )
                    if(letraA.visible==1):
                        self.palavraEmFormacao.append('A')
                    
                    letraA.visible=0

            elif (fabs(peixeEspada.esqueleto.x - letraR.x) < 2) and ( fabs (peixeEspada.esqueleto.y - letraR.y) < 2 ):
                    #label2 = label(pos=(0,-7,-30), text='OK', height=10, color=color.green )
                    if(letraR.visible==1):
                        self.palavraEmFormacao.append('R')
                    letraR.visible=0
            elif (fabs(peixeEspada.esqueleto.x - letraP.x) < 2) and ( fabs (peixeEspada.esqueleto.y - letraP.y) < 2 ):
                    #label2 = label(pos=(0,-7,-30), text='OK', height=10, color=color.green )
                    if(letraP.visible==1):
                        self.palavraEmFormacao.append('P')
                    letraP.visible=0
           
            elif (fabs(peixeEspada.esqueleto.x - letraT.x) < 2) and ( fabs (peixeEspada.esqueleto.y - letraT.y) < 2 ):
                    #label2 = label(pos=(0,-7,-30), text='OK', height=10, color=color.green )
                    if(letraT.visible==1):
                        self.palavraEmFormacao.append('T')
                    letraT.visible=0
            elif (fabs(peixeEspada.esqueleto.x - letraE.x) < 2) and ( fabs (peixeEspada.esqueleto.y - letraE.y) < 2 ):
                    #label2 = label(pos=(0,-7,-30), text='OK', height=10, color=color.green )
                    if(letraE.visible==1):
                        self.palavraEmFormacao.append('E')
                    letraE.visible=0
                    
            elif (fabs(peixeEspada.esqueleto.x - letraO1.x) < 2) and ( fabs (peixeEspada.esqueleto.y - letraO1.y) < 2 ):
                    #label2 = label(pos=(0,-7,-30), text='OK', height=10, color=color.green )
                    if(letraO1.visible==1):
                        self.palavraEmFormacao.append('O')
                    letraO1.visible=0
            elif (fabs(peixeEspada.esqueleto.x - letraO2.x) < 2) and ( fabs (peixeEspada.esqueleto.y - letraO2.y) < 2 ):
                    #label2 = label(pos=(0,-7,-30), text='OK', height=10, color=color.green )
                    if(letraO2.visible==1):
                        self.palavraEmFormacao.append('O')
                    letraO2.visible=0     

    
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
                #ENTER
                elif (s == 'm'):
                    palavra=''
                    for elem in self.palavraEmFormacao:
                        palavra += elem
                    
                    
                        
                    self.palavras.append(palavra)
                    
                    if(len(self.palavras)>=5):
                        print 'ENCHEU A LISTA COM SUCESSO'
                        label(pos=(0,0,-30),text='PARABENS, VOCE CONSEGUIU!!!', height=18 , box=1)
                    else:
                        print 'ainda falta gente a entrar na lista'
                    
                    palavra1=''
                    for elem in self.palavras:
                        if(palavra1 ==''):
                            palavra1 = elem
                        else:
                            palavra1 = palavra1 + '  -  ' + elem 
                    
                    self.palavrasJaFormadas.text = palavra1
                    self.palavraEmFormacao = []
                    
                    print 'teste'
                    print palavra
                    print self.palavraEmFormacao
                    print self.palavras
                    letraA.visible=1
                    letraR.visible=1
                    letraT.visible=1
                    letraO1.visible=1
                    letraO2.visible=1
                    letraE.visible=1
                    letraP.visible=1
        
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
