
"""

##################

Game Memoria

##################

:Author: Tribo Karaja - Carlos Felippe Cardoso de Resende

:Contact: Tribo Karaja (PPGI/UFRJ)

:Date: $Date: 2009/05/01$

:Status: "work in progress"

:Revision: $Revision: 1.0$


"""

from visual import *

from math import *

from SerMarinho import *

from PeixeEspada import *

TITLE = 'Karaja Game Memoria'

import Image

import ImageGrab

class Principal:
    

    def __init__(self):

 

        self.cena = display(title=TITLE, width=400, height=400, center= (0,0,0), x=0, y=0)

        self.cena.x, self.cena.y =0,0

        self.cena.select()
        
        self.cena.autocenter = 1

        self.cena.autoscale = 1

        self.quadro = 0


    def principal(self):
        side = 100

        thk = 0.3

        nome1 = label(pos=(0,100,0), text='ENCONTRE OS PARES  ' ,box=0)

        wallA = box(pos=(-130,0,-30), axis=(1,0,0), length=5, height=280, width=5, color = color.yellow)
        wallB = box(pos=(130,0,-30), axis=(1,0,0), length=5, height=280, width=5, color = color.yellow)
        wallC = box(pos=(0,130,-30), axis=(1,0,0), length=280, height=5, width=5, color = color.yellow)
        wallD = box(pos=(0,-130,-30), axis=(1,0,0), length=280, height=5, width=5, color = color.yellow)

        peixeEspada = PeixeEspada(escala =1.5, axis=(1,0,0), pos= (0,-90,10))
        peixeEspada.esqueleto.rotate(angle=pi/2., axis=(1,0,0))


        caixa1 = box(pos= ( -60, 60, 0), length=39, height=39,width=1,color=color.cyan,  opacity=1)        
        tubarao1 = Tubarao (escala =.65, axis=(-1,0,2), pos= ( -58, 60, -13))

        caixa2 = box(pos=(0, 60,0), length=39, height=39,width=1, color=color.cyan, opacity=1)
        caracol1 = Caracol(escala =2.5, axis=(1,0,0), pos= (0,60,-10))
        
        caixa3 = box(pos=(60, 60,0), length=39, height=39,width=1, color=color.cyan, opacity=1)      
        aguaviva1 = Aguaviva(escala =5, axis=(-1,0,2), pos= (60,60,-12))
        
        caixa4 = box(pos=(-60, 0,0), length=39, height=39,width=1, color=color.cyan, opacity=1)
        submarino1 = Submarino (escala =3, axis=(-1,0,2), pos= ( -60, 0,-15))


        caixa6 = box(pos=(60, 0,0), length=39, height=39,width=1, color=color.cyan, opacity=1)       
        caracol2 = Caracol(escala =2.5, axis=(1,0,0), pos= (60,0,-10))
        
        caixa7 = box(pos=(-60, -60,0), length=39, height=39,width=1, color=color.cyan, opacity=1)
        tubarao2 = Tubarao (escala =.65, axis=(-1,0.7,2), pos= ( -60, -60, -13))

        caixa8 = box(pos=(0, -60,0), length=39, height=39,width=1, color=color.cyan, opacity=1)
        submarino2 = Submarino (escala =3, axis=(-1,0.3,2), pos= ( 0, -60,-15))


        caixa9 = box(pos=(60, -60,0), length=39, height=39,width=1, color=color.cyan, opacity=1)        
        aguaviva2 = Aguaviva(escala =5, axis=(-1,0.7,2), pos= (60,-60,-12))

        peixeEspada.mass = 1.0
        peixeEspada.p = vector (0,1,0)

        side = side - thk*0.5 - peixeEspada.esqueleto.x

        quadro=0

        aux = 0;

        dt = 0.5

        t=0

        auxLado = 0

        auxEsquerdaDireita = 0

        contapasso = 0 

        #scene.background= color.blue
       

        while 1:

            # Captura de GIFs

            aux += 1

            if( aux == 5) :

                im = ImageGrab.grab((0,0,400,400))
                
                fn = "Karaja GameMemoria"+str(quadro)+".png"

                im.save(fn)

                aux = 0

               

            rate(100)

# Controle do teclado           

            if self.cena.kb.keys:

                s = self.cena.kb.getkey()

                if (s == 'up'):

                    peixeEspada.p = vector (0,1,0)

                    if (peixeEspada.esqueleto.y >= 92):

                        auxLado += 0

                    else:

                        auxLado += 1

                       

                elif (s == 'down'):

                    peixeEspada.p = vector (0,-1,0)

                    if (peixeEspada.esqueleto.y <= -92):

                        auxLado -= 0

                    else:

                        auxLado -= 1

                   

                elif (s == 'left'):

                    peixeEspada.p = vector (-1,0,0)

                    if (peixeEspada.esqueleto.x <= -90):

                        auxEsquerdaDireita -= 0

                    else:

                        auxEsquerdaDireita -= 1

                elif (s == 'right'):

                    peixeEspada.p = vector (1,0,0)

                    if (peixeEspada.esqueleto.x >= 90):

                        auxEsquerdaDireita += 0

                    else:

                        auxEsquerdaDireita += 1

                               

                elif (s == 'q'):

                    print 'TCHAU'

                    break

                    quit

            peixeEspada.esqueleto.axis.y = peixeEspada.p.y + auxLado

            peixeEspada.esqueleto.axis.x = peixeEspada.p.x + auxEsquerdaDireita

            peixeEspada.esqueleto.axis.z = peixeEspada.p.z

            peixeEspada.esqueleto.y += auxLado

            peixeEspada.esqueleto.x += auxEsquerdaDireita

            rate(100)

            t = t + dt

            auxLado = 0

            auxEsquerdaDireita = 0

    

            if ( peixeEspada.esqueleto.y > side + 10):

                        label(pos=(60,120,0), text='Parabens !!!')

                        break

            if ( peixeEspada.esqueleto.y < -side - 10):

                label(pos=(-80,-80,0), text='Voce tem que subir !!!' )

                peixeEspada.p = vector (0,1,0)

#

            if (fabs(peixeEspada.esqueleto.x - caixa7.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa7.y)) < 20 and contapasso==0:

                caixa7.opacity=0

                contapasso=1

               

            if (fabs(peixeEspada.esqueleto.x - caixa8.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa8.y)) < 20 and contapasso==1:

                caixa8.opacity=0

                contapasso=2 

            if ((fabs(peixeEspada.esqueleto.x - caixa8.x)) > 20 or ( fabs (peixeEspada.esqueleto.y - caixa9.y)) > 20 )and contapasso==2:

                caixa7.opacity=1

                caixa8.opacity=1

                contapasso=3 

            if (fabs(peixeEspada.esqueleto.x - caixa4.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa4.y)) < 20 and contapasso==3:

                caixa4.opacity=0

                contapasso=4 

            if (fabs(peixeEspada.esqueleto.x - caixa8.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa8.y)) < 20 and contapasso==4:

                caixa8.opacity=0

                contapasso=5

            if (fabs(peixeEspada.esqueleto.x - caixa1.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa1.y)) < 20 and contapasso==5:

                caixa1.opacity=0

                contapasso=6

            if (fabs(peixeEspada.esqueleto.x - caixa7.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa7.y)) < 20 and contapasso==6:

                caixa7.opacity=0

                contapasso=7 

            if (fabs(peixeEspada.esqueleto.x - caixa9.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa9.y)) < 20 and contapasso==7:

                caixa9.opacity=0

                contapasso=8

               

            if (fabs(peixeEspada.esqueleto.x - caixa6.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa6.y)) < 20 and contapasso==8:

                caixa6.opacity=0

                contapasso=9 

            if ((fabs(peixeEspada.esqueleto.x - caixa6.x)) > 20 or ( fabs (peixeEspada.esqueleto.y - caixa6.y)) > 20 )and contapasso==9:

                caixa6.opacity=1

                caixa9.opacity=1

                contapasso=10 

            if (fabs(peixeEspada.esqueleto.x - caixa3.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa3.y)) < 20 and contapasso==10:

                caixa3.opacity=0

                contapasso=11 

            if (fabs(peixeEspada.esqueleto.x - caixa9.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa9.y)) < 20 and contapasso==11:

                caixa9.opacity=0

                contapasso=12 

            if (fabs(peixeEspada.esqueleto.x - caixa6.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa6.y)) < 20 and contapasso==12:

                caixa6.opacity=0

                contapasso=13 

            if (fabs(peixeEspada.esqueleto.x - caixa2.x)) < 20 and ( fabs (peixeEspada.esqueleto.y - caixa2.y)) < 20 and contapasso==13:

                caixa2.opacity=0

                contapasso=14

                final = label(pos=(0,-60,0), text='PARABENS !!!' )               

            peixeEspada.proximoFrame()

            quadro += 1

                  


'''

Estas classes sao as especializacoes da classe SerMarinho...

'''

class Caracol(SerMarinho):

    def desenha(self, escala=1):

        s=escala

        corpo = ellipsoid(frame = self.esqueleto, pos=(2,-4*s,0), length=7*s, height=s, width=4*s, color=color.yellow)

        casco1 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=8*s, height=8*s, width=2*s, color=color.orange, material=materials.wood)

        casco2 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=6*s, height=6*s, width=3*s, color=color.red, material=materials.wood)

        casco3 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=4*s, height=4*s, width=3.5*s, color=color.yellow, material=materials.wood)

        antenaE = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,-1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)

        antenaD = cylinder(frame = self.esqueleto, pos=(3*s,-4*s,1.5*s), axis=(2.5*s,1.5*s,0), radius=0.1*s, color=color.yellow)

        olhoE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.white, radius = 1.5*s, opacity=0.6)

        olhoD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.white, radius = 1.5*s, opacity=0.6)

        pupilaE = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,-1.5*s),color=color.black, radius = 1*s)

        pupilaD = sphere(frame = self.esqueleto, pos=(6*s,-1.2*s,1.5*s),color=color.black, radius = 1*s)

class Tubarao(SerMarinho):

    def desenha(self, escala=1):

        corpo01 = ellipsoid(frame = self.esqueleto, pos=(0,-2*escala,0), length=35*escala, height=10*escala, width=10*escala, color = color.white, opacity=1)

        corpo02 = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=40*escala, height=12.5*escala, width=15*escala, color = color.gray(0.5), opacity=1)

        corpo03 = ellipsoid(frame = self.esqueleto, pos=(-15*escala,-2*escala,0), length=15*escala, height=6*escala, width=5*escala, color = color.white, opacity=1)

        corpo04 = ellipsoid(frame = self.esqueleto, pos=(-15*escala,0,0), length=25*escala, height=9*escala, width=10*escala, color = color.gray(0.5), opacity=1)

        boca1 = pyramid (frame = self.esqueleto, pos=(14*escala,-3.5*escala,-2*escala), axis=(-1,0,0), length=10*escala, height=3*escala, width=2*escala, color = color.gray(0.5), opacity=1)

        boca2 = pyramid (frame = self.esqueleto, pos=(14*escala,-3.5*escala,2*escala), axis=(-1,0,0), length=10*escala, height=3*escala, width=2*escala, color = color.gray(0.5), opacity=1)

        boca3 = ellipsoid(frame = self.esqueleto, pos=(13*escala,-5*escala,0), axis=(1,-0.1,0), length=10*escala, height=1*escala, width=6.5*escala, color=color.white, opacity=1)

        boca4 = ellipsoid(frame = self.esqueleto, pos=(15*escala,-2.5*escala,0), axis=(1,0.4,0), length=10*escala, height=2*escala, width=7*escala, color=color.gray(0.5), opacity=1)

        boca5 = ellipsoid(frame = self.esqueleto, pos=(14.5*escala,-4.6*escala,0), axis=(1,-0.1,0), length=5.5*escala, height=1*escala, width=5*escala, color=color.red, opacity=1)

        boca6 = ellipsoid(frame = self.esqueleto, pos=(14.5*escala,-3.8*escala,0), axis=(1,0.4,0), length=5*escala, height=1.5*escala, width=5*escala, color=color.red, opacity=1)

        olho10 = ellipsoid (frame = self.esqueleto, pos=(11*escala,2*escala,-5.6*escala), axis=(-0.25,-0.4,1),length=0.5*escala, height=1*escala, width=1*escala, color = color.white)

        olho11 = ellipsoid (frame = self.esqueleto, pos=(11.5*escala,2*escala,-5.6*escala), axis=(-0.25,-0.4,1), length=0.5*escala, height=1*escala, width=1*escala, color = color.black)

        olho20 = ellipsoid (frame = self.esqueleto, pos=(11*escala,2*escala,5.6*escala), axis=(0.25,0.4,1), length=0.5*escala, height=1*escala, width=1*escala, color = color.white)

        olho21 = ellipsoid (frame = self.esqueleto, pos=(11.5*escala,2*escala,5.6*escala), axis=(0.25,0.4,1), length=0.5*escala, height=1*escala, width=1*escala, color = color.black)

        dente01 = cone(frame = self.esqueleto, pos=(15*escala,-2*escala,-3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente02 = cone(frame = self.esqueleto, pos=(15*escala,-2*escala,3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente03 = cone(frame = self.esqueleto, pos=(15.5*escala,-2*escala,-3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente04 = cone(frame = self.esqueleto, pos=(15.5*escala,-2*escala,3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente05 = cone(frame = self.esqueleto, pos=(16*escala,-2*escala,-2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente06 = cone(frame = self.esqueleto, pos=(16*escala,-2*escala,2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente07 = cone(frame = self.esqueleto, pos=(16.5*escala,-2*escala,-2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente08 = cone(frame = self.esqueleto, pos=(16.5*escala,-2*escala,2.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente09 = cone(frame = self.esqueleto, pos=(17*escala,-1.75*escala,-2.5*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente10 = cone(frame = self.esqueleto, pos=(17*escala,-1.75*escala,2.5*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente11 = cone(frame = self.esqueleto, pos=(17.5*escala,-1.5*escala,-2.2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente12 = cone(frame = self.esqueleto, pos=(17.5*escala,-1.5*escala,2.2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente13 = cone(frame = self.esqueleto, pos=(18*escala,-1.75*escala,-2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente14 = cone(frame = self.esqueleto, pos=(18*escala,-1.75*escala,2*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente15 = cone(frame = self.esqueleto, pos=(18.5*escala,-1.5*escala,-1.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente16 = cone(frame = self.esqueleto, pos=(18.5*escala,-1.5*escala,1.75*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente17 = cone(frame = self.esqueleto, pos=(18.75*escala,-1*escala,-1*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente18 = cone(frame = self.esqueleto, pos=(18.75*escala,-1*escala,1*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente19 = cone(frame = self.esqueleto, pos=(19*escala,-1*escala,-0.3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente20 = cone(frame = self.esqueleto, pos=(19*escala,-1*escala,0.3*escala), axis=(0,-1.5*escala,0), radius=0.3*escala, color=color.white)

        dente21 = cone(frame = self.esqueleto, pos=(14*escala,-5*escala,-2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente22 = cone(frame = self.esqueleto, pos=(14*escala,-5*escala,2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente23 = cone(frame = self.esqueleto, pos=(14.5*escala,-5*escala,-2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente24 = cone(frame = self.esqueleto, pos=(14.5*escala,-5*escala,2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente25 = cone(frame = self.esqueleto, pos=(15*escala,-5*escala,-2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente26 = cone(frame = self.esqueleto, pos=(15*escala,-5*escala,2.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente27 = cone(frame = self.esqueleto, pos=(15.5*escala,-5*escala,-2.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente28 = cone(frame = self.esqueleto, pos=(15.5*escala,-5*escala,2.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente29 = cone(frame = self.esqueleto, pos=(16*escala,-5*escala,2*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente30 = cone(frame = self.esqueleto, pos=(16*escala,-5*escala,-2*escala), axis=(0,0.5*escala,0), radius=.3, color=color.white)

        dente31 = cone(frame = self.esqueleto, pos=(16.5*escala,-5*escala,-1.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente32 = cone(frame = self.esqueleto, pos=(16.5*escala,-5*escala,1.75*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente33 = cone(frame = self.esqueleto, pos=(17*escala,-5.2*escala,-1.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente34 = cone(frame = self.esqueleto, pos=(17*escala,-5.2*escala,1.5*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente35 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,-1*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente36 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,1*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente37 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,-0.3*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dente38 = cone(frame = self.esqueleto, pos=(17.5*escala,-5.2*escala,0.3*escala), axis=(0,0.5*escala,0), radius=0.3*escala, color=color.white)

        dorsal1 =  pyramid(frame = self.esqueleto, pos=(-2*escala,5.5*escala,0), size=(7*escala,20*escala,0.5*escala), color=color.gray(0.5), opacity=1)

        dorsal2 =  pyramid(frame = self.esqueleto, pos=(-16*escala,4*escala,0), size=(5*escala,5*escala,0.5*escala), color=color.gray(0.5), opacity=1)

        barriga1 = pyramid(frame = self.esqueleto, pos=(-16*escala,-3*escala,0), size=(7*escala,6*escala,0.5*escala), axis=(1,-0.3,0), color=color.white, opacity=1)

        peitoral1 = pyramid(frame = self.esqueleto, pos=(3*escala,-4*escala,3.5*escala), size=(12*escala,1*escala,6*escala), axis=(-0.5,0,1),color=color.gray(0.5), opacity=1)

        peitoral2 = pyramid(frame = self.esqueleto, pos=(3*escala,-4*escala,-3.5*escala), size=(12*escala,1*escala,6*escala), axis=(-0.5,0,-1),color=color.gray(0.5), opacity=1)

        peitoral3 = pyramid(frame = self.esqueleto, pos=(-10*escala,-4*escala,2.5*escala), size=(5*escala,1*escala,6*escala), axis=(-0.5,0,1),color=color.gray(0.5), opacity=1)

        peitoral4 = pyramid(frame = self.esqueleto, pos=(-10*escala,-4*escala,-2.5*escala), size=(5*escala,1*escala,6*escala), axis=(-0.5,0,-1),color=color.gray(0.5), opacity=1)

        rabo1 = pyramid(frame = self.esqueleto, pos=(-25*escala,1*escala,0), size=(16*escala,5*escala,0.5*escala),axis=(-1,1,0), color=color.gray(0.5), opacity=1)

        rabo2 = pyramid(frame = self.esqueleto, pos=(-28*escala,-2*escala,0), size=(7*escala,6*escala,0.5*escala), axis=(1,-0.3,0), color=color.gray(0.5), opacity=1)

        guelra1 = cylinder (frame = self.esqueleto, pos=(6*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))

        guelra2 = cylinder (frame = self.esqueleto, pos=(5*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))

        guelra3 = cylinder (frame = self.esqueleto, pos=(4*escala,0,5.5*escala), axis=(0.1,0,0.1),radius=3*escala, color=color.gray(0.5))

        guelra4 = cylinder (frame = self.esqueleto, pos=(6*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))

        guelra5 = cylinder (frame = self.esqueleto, pos=(5*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))

        guelra6 = cylinder (frame = self.esqueleto, pos=(4*escala,0,-5.5*escala), axis=(0.1,0,-0.1),radius=3*escala, color=color.gray(0.5))

class Submarino (SerMarinho):

    def desenha(self, escala=1):

        esc=escala

        # Desenha o Corpo Principal do Submarino

        corpo = ellipsoid(frame = self.esqueleto, pos=(0,0,0), length=10*esc, height=3*esc, width=3*esc, color = color.yellow)

        # Desenha a Ponte ( Passadico ) do Submarino

        ponte = cylinder(frame = self.esqueleto, pos=(1*esc,0,0),axis=(0,3*esc,0), radius=1*esc, color = color.yellow)

        pontesup = cylinder(frame = self.esqueleto, pos=(1*esc,3*esc,0),axis=(0,0.4*esc,0*esc), radius=.4*esc, color = color.yellow)

        telescopio1 = cylinder(frame = self.esqueleto, pos=(1*esc,3.4*esc,0),axis=(0,0.6*esc,0), radius=.1*esc, color = color.yellow)

        telescopio2 = cylinder(frame = self.esqueleto, pos=(1*esc,3.9*esc,0),axis=(0.2*esc,0,0), radius=.1*esc, color = color.yellow)

        lemedaponte = box(frame = self.esqueleto, pos=(1*esc,2*esc,0), length=1*esc, height=0.05*esc, width=3*esc, color = color.yellow)

        # Desenha o leme de proa do Submarino

        lemedeproa = box(frame = self.esqueleto, pos=(3.5*esc,0*esc,0*esc), length=1*esc, height=0.05*esc, width=3.5*esc, color = color.yellow)

        # Desenha o leme de popa do Submarino

        popa1 = pyramid(frame = self.esqueleto, pos=(-4.5*esc,0,0), size=(1.5*esc,4*esc,0.1*esc), color = color.yellow )

        lemedapopa1 = box(frame = self.esqueleto, pos=(-5*esc,0,0), length=1*esc, height=4*esc, width=0.1*esc, color = color.yellow)

        popa2 = pyramid(frame = self.esqueleto, pos=(-4.5*esc,0,0), size=(1.5*esc,0.1*esc,4*esc), color = color.yellow )

        lemedapopa2 = box(frame = self.esqueleto, pos=(-5*esc,0,0), length=1*esc, height=0.1*esc, width=4*esc, color = color.yellow)

        esteira = helix(frame = self.esqueleto, pos=(-5.8*esc,0,0), axis=(-3*esc,0,0), radius=1*esc)       

class Aguaviva(SerMarinho):

    def desenha(self, escala=1):

        u=escala/6.0

        r=6*u

        l=6*r

        direcoes = [-r,0,r]        

        self.cor1 = (0.2,0.3,0.4)

        self.cor2 = color.white

        self.cor3 = (0.4,0.1,0.6)

        self.cor4 = color.blue

        self.cor5 = color.red

        self.desenharElipse((0,0,0),3*escala,2*escala,3*escala,self.cor2,0.4)

        self.desenharElipse ((0,0.4*escala,0),2*escala,1.5*escala,2*escala,self.cor3,0.4)

        self.desenharElipse ((0,0,0),3*escala,2*escala,3*escala,self.cor3,0.4,materials.marble)

        self.desenharElipse ((0,-0.2*escala,1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)

        self.desenharElipse ((0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)

        self.desenharElipse ((0,-0.2*escala,-1.2*escala),1.5*escala,1.5*escala,1*escala,self.cor1,0.3)

        self.desenharElipse ((-0.7,-0.2*escala,0.2*escala),2*escala,1.75*escala,2*escala,self.cor1,0.3)

        self.desenharCilindro((0,-0.65*escala,0), (0,0.7*escala,0),1.479*escala,self.cor3,0.5)

        self.desenharCilindro((0,-1*escala,0),(0,0.7*escala,0),1.55*escala,self.cor3,0.5)

        self.desenharAnel((-0.1*escala,0,0),(0,0.5*escala,0.1*escala),1.3*escala, 0.002*escala,self.cor5)

        self.desenharAnel((-0.1*escala,0.3*escala,0),(0,0.5*escala,0.1*escala), 1.1*escala, 0.002*escala,self.cor5)

        self.desenharAnel((-0.1*escala,0.5*escala,0),(0,0.5*escala,0.1*escala),1*escala, 0.002*escala,self.cor5)

        self.desenharAnel((-0.1*escala,0.7*escala,0),(0,0.5*escala,0.1*escala),0.8*escala,0.004*escala,self.cor5)

        self.desenharAnel((0.1*escala,0,0),(0,0.5*escala,-0.1*escala),1.3*escala,0.002*escala,self.cor5)

        self.desenharAnel((0.1*escala,0.3*escala,0),(0,0.5*escala,-0.1*escala),1.1*escala,0.002*escala,self.cor5)

        self.desenharAnel((0.1*escala,0.5*escala,0), (0,0.5*escala,-0.1*escala), 1*escala, 0.002*escala,self.cor5)

        self.desenharAnel((0.1*escala,0.7*escala,0),(0,0.5*escala,-0.1*escala),0.8*escala,0.004*escala,self.cor5)

        self.desenharAnel((0.1*escala,1*escala,0),(0,0,0),0.5,0.004*escala,self.cor5)      

        self.desenharEspiral((0,-0.8*escala,0),(0,1*escala,0), 1.4*escala,0.01*escala,self.cor2,materials.marble)

        self.desenharEspiral((0,-0.4*escala,0),(0,1*escala,0), 0.8*escala,0.01*escala,self.cor2,materials.marble)

        self.desenharEspiral((0,-1.5*escala,0),(0,1.5*escala,0),0.3*escala,0.3*escala,self.cor2,materials.marble)

        self.desenharEspiral((0,-1.1*escala,0),(0,0.7*escala,0),0.8*escala,0.35*escala,self.cor2,materials.marble)

        self.desenharEspiral((0.5*escala,-3*escala,0.3*escala),(-0.5*escala,3*escala,0),0.1*escala,0.15*escala,self.cor2,materials.marble)

        self.desenharEspiral((-0.5*escala,-3*escala,-0.2*escala),(0.5*escala,3*escala,0),0.1*escala,0.15*escala,self.cor2,materials.marble)

        self.desenharEspiral((0,-3*escala,0.3*escala),(0,3*escala,0),0.1*escala,0.15*escala,self.cor3,materials.marble)

        self.desenharEspiral((2*escala,-2*escala,0.3*escala),(-0.5*escala,1*escala,0),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((-2*escala,-2*escala,0.3*escala),(0.5*escala,1*escala,0),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((0,-2*escala,-2*escala),(0,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((0,-2*escala,2*escala),(0,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((1*escala,-2*escala,-2*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((-1*escala,-2*escala,-2*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((-1*escala,-2*escala,2*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((1*escala,-2*escala,2*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor3)

        self.desenharEspiral((1.5*escala,-2*escala,-1.5*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.5*escala,-2*escala,-1.5*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.5*escala,-2*escala,1.5*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.5*escala,-2*escala,1.5*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.25*escala,-2*escala,-1.75*escala), (-0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.25*escala,-2*escala,-1.75*escala), (0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.25*escala,-2*escala,1.75*escala), (-0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.25*escala,-2*escala,1.75*escala), (0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.75*escala,-2*escala,-1.25*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.75*escala,-2*escala,-1.25*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.75*escala,-2*escala,1.25*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.75*escala,-2*escala,1.25*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.40*escala,-2*escala,-1.60*escala),(-0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.40*escala,-2*escala,-1.60*escala),(0.5*escala,1*escala,0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.40*escala,-2*escala,1.60*escala),(-0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.40*escala,-2*escala,1.60*escala),(0.5*escala,1*escala,-0.5*escala), 0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.6*escala,-2*escala,-1.4*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.6*escala,-2*escala,-1.4*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((1.6*escala,-2*escala,1.4*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-1.6*escala,-2*escala,1.4*escala),(0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((2*escala,-2*escala,-1*escala),(-0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-2*escala,-2*escala,-1*escala),(0.5*escala,1*escala,0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((2*escala,-2*escala,1*escala),(-0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

        self.desenharEspiral((-2*escala,-2*escala,1*escala), (0.5*escala,1*escala,-0.5*escala),0.05*escala,0.01*escala,self.cor2)

    def desenharElipse(self,posicao=(0,0,0),comprimento=3,altura=2,largura=3,cor=color.yellow,opacidade=0.4, aparencia=materials.unshaded):

        return ellipsoid(

            frame = self.esqueleto,pos = posicao, length = comprimento, height = altura, width = largura, color = cor, opacity = opacidade, material = aparencia)  

    def desenharCilindro(self,posicao=(0,-0.65,0),eixos=(0,0.7,0),raio=1,cor=color.yellow,opacidade=0.5):

        return cylinder(

            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, color = cor, opacity = opacidade)

    def desenharAnel(self,posicao=(0,0,0),eixos=(1,1,1),raio=1,espessura=0.5,cor=color.yellow):

        return ring(

            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, thickness = 0.1, color = cor)

    def desenharEspiral(self,posicao=(0,0,0),eixos=(1,1,1),raio=1,espessura=0.01,cor=color.yellow,aparencia=materials.unshaded):

        return helix(

            frame = self.esqueleto, pos = posicao, axis = eixos, radius = raio, thickness = espessura, color = cor, material = aparencia)

 

if __name__ == "__main__":

    cenario = Principal()

    cenario.principal()