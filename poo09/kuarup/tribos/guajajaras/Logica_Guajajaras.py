"""
#############################
 Guajajaras - Jogo de Logica
#############################
:Author: Tribo Guajajaras
:Contact: Tribo Guajajaras(Mestrado - NCE/UFRJ)
:Date: $Date: 2009/04/06$
:Status: This is a "work in progress"
:Revision: $Revision: 1.0$
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""
from visual import *
from math import *
TITLE = 'Jogo de Logica - Guajajaras'
import Image
import ImageGrab
class Cenario:

    def principal(self):
        traira1=Traira(escala =6, axis=(1,0,0), pos= (0,-90,0))
        traira1.esqueleto.rotate(angle=pi/2., axis=(1,0,0))
        trairalegenda=Traira(escala =2.5, axis=(1,0,0), pos= (-90,-110,0))
        trairalegenda.esqueleto.rotate(angle=pi/2., axis=(1,0,0))        
        pangacio1=Pangacio(escala =1, axis=(1,0,0), pos= (15,-90,0))
        pangacio1.esqueleto.rotate(angle=pi/2., axis=(1,0,0))
        pangaciolegenda=Pangacio(escala =1, axis=(-1,0,0), pos= (90,-110,0))
        pangaciolegenda.esqueleto.rotate(angle=pi/2., axis=(1,0,0))        
        tubarao1=Tubarao(escala =1, axis=(1,0,0), pos= (-50,20,0))
        tubarao1.esqueleto.rotate(angle=pi/2., axis=(1,0,0))        
        tubarao2=Tubarao(escala =1, axis=(-1,0,0), pos= (-40,-40,0))       
        tubarao2.esqueleto.rotate(angle=pi/2., axis=(1,0,0))
        tubarao3=Tubarao(escala =1, axis=(-2,0,0), pos= (-60,-10,0))
        tubarao3.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        casaTraira = Casa ( pos= ( 50, 100,17), escala = 2.5, axis=( 1,0,0))
        casaTraira.esqueleto.rotate(angle= pi/2., axis=(1,0,0))
        
        casaPangacio = Casa ( pos= ( -50, 100,4), escala = 1, axis=(1,0,0))
        casaPangacio.esqueleto.rotate(angle=pi/2., axis=(1,0,0))

        label(pos=(60,120,80), text='Onde mora cada peixe ?')        
        side = 100
        thk = 0.3
        s2 = 2*side - thk
        s3 = 2*side + thk
        wallR = box (pos=( side, 0, 0), length=thk, height=s2,  width=10,  color = color.white, opacity=1)
        wallL = box (pos=(-side, 0, 0), length=thk, height=s2,  width=10,  color = color.white, opacity=1)
        wallLsup = box (pos=(0, 100, 0), length=200, height=0.3,  width=10,  color = color.white, opacity=1)
        wallB1 = box (pos=(55, -side, 0), length=90,  height=thk, width=10,  color = color.white, opacity=1)
        wallB2 = box (pos=(-55, -side, 0), length=90,  height=thk, width=10,  color = color.white, opacity=1)       
        wallBK = box(pos=(0, 0, -5), length=s2,  height=s2,  width=thk, color = (0.4,0.4,0.4), opacity=1)
        label(pos=(-70,-125,0), text='Utilize (I,J,K,L)') 
        label(pos=(70,-125,0), text='Utilize as setas')         
        traira1.mass = 1.0
        traira1.p = vector (0,1,0)
        pangacio1.mass = 1.0
        pangacio1.p = vector (0,1,0)
        tubarao1.mass = 1.0
        tubarao1.p = vector (-1,0,0)
        tubarao2.mass = 1.0
        tubarao2.p = vector (-1,0,0)
        tubarao3.mass = 1.0
        tubarao3.p = vector (-1,0,0)
         
        
        side = side - thk*0.5 - traira1.esqueleto.x
        quadro=0
        aux = 0;
        dt = 0.5
        tc=0
        tt=0
        auxLadoc = 0
        auxEsquerdaDireitac = 0
        auxLadot = 0
        auxEsquerdaDireitat = 0
        contacubo=1
        contafinaltraira=0
        contafinalpangacio=0

        while 1:

#Captura de GIFs
            aux += 1
            if( aux == 5) :
                im = ImageGrab.grab((0,0,410,450))
                fn = "Traira Game"+str(quadro)+".png"
                im.save(fn)
                aux = 0
            rate(100)

#Movimento dos peixes           
            if scene.kb.keys:
                s = scene.kb.getkey()
                if (s == 'up'):
                    traira1.p = vector (0,1,0)
                    if (traira1.esqueleto.y <= 92):
                        auxLadoc += 1
                    elif (fabs(traira1.esqueleto.x + 50) < 10):
                        auxLadoc += 1
                        if (traira1.esqueleto.y >= side+28):
                            contafinaltraira =1
                            auxLadoc = 0
                            if contafinaltraira ==1 and contafinalpangacio==0:
                                label(pos=(60,120,40), text='Traga o Pangacio!')

                elif (s == 'down'):
                    traira1.p = vector (0,-1,0)
                    if (traira1.esqueleto.y <= -92):
                        auxLadoc -= 0
                    else:
                        auxLadoc -= 1

                elif (s == 'left'):
                    traira1.p = vector (-1,0,0)
                    if (traira1.esqueleto.x <= -90):
                        auxEsquerdaDireitac -= 0
                    else:
                        auxEsquerdaDireitac -= 1

                elif (s == 'right'):
                    traira1.p = vector (1,0,0)

                    if (traira1.esqueleto.x >= 90):
                        auxEsquerdaDireitac += 0
                    else:

                        auxEsquerdaDireitac += 1

                if (s == 'i'):
                    pangacio1.p = vector (0,1,0)
                    if (pangacio1.esqueleto.y <= 92):
                        auxLadot += 1
                    elif (fabs(pangacio1.esqueleto.x - 50) < 10):
                        auxLadot += 1
                        if (pangacio1.esqueleto.y >= side+10):
                            contafinalpangacio =1
                            auxLadot = 0
                            if contafinalpangacio ==1 and contafinaltraira==0:
                                label(pos=(60,120,30), text='Traga a Traira!')                       
 
                elif (s == 'k'):
                    pangacio1.p = vector (0,-1,0)
                    if (pangacio1.esqueleto.y <= -92):
                        auxLadot -= 0
                    else:
                        auxLadot -= 1
 
                elif (s == 'j'):
                    pangacio1.p = vector (-1,0,0)
                    if (pangacio1.esqueleto.x <= -90):
                        auxEsquerdaDireitat -= 0
                    else:

                        auxEsquerdaDireitat -= 1

                elif (s == 'l'):
                    pangacio1.p = vector (1,0,0)
                    if (pangacio1.esqueleto.x >= 90):
                        auxEsquerdaDireitat += 0
                    else:
                        auxEsquerdaDireitat += 1

 
                elif (s == 'q'):
                    print 'TCHAU'
                    break
                    quit

            traira1.esqueleto.axis.y = traira1.p.y + auxLadoc
            traira1.esqueleto.axis.x = traira1.p.x + auxEsquerdaDireitac
            traira1.esqueleto.axis.z = traira1.p.z
            traira1.esqueleto.y += auxLadoc
            traira1.esqueleto.x += auxEsquerdaDireitac
            tc = tc + dt
            pangacio1.esqueleto.axis.y = pangacio1.p.y + auxLadot
            pangacio1.esqueleto.axis.x = pangacio1.p.x + auxEsquerdaDireitat
            pangacio1.esqueleto.axis.z = pangacio1.p.z
            pangacio1.esqueleto.y += auxLadot
            pangacio1.esqueleto.x += auxEsquerdaDireitat

            rate(100)

            tt = tt + dt
            auxLadoc = 0
            auxEsquerdaDireitac = 0
            auxLadot = 0
            auxEsquerdaDireitat = 0

            tubarao1.esqueleto.axis.x = tubarao1.p.x
            tubarao2.esqueleto.axis.x = tubarao2.p.x
            tubarao3.esqueleto.axis.x = tubarao3.p.x

 
#Etapa vitória
            if (contafinaltraira+contafinalpangacio) == 2:
                label(pos=(0,0,0), text='Parabens !!!')

#Etapa movimentos outros seres marinho              

            tubarao1.esqueleto.pos = tubarao1.esqueleto.pos + (tubarao1.p/tubarao1.mass)*dt
            if not (side-20 > tubarao1.esqueleto.x > -side+20):
                tubarao1.p.x = -tubarao1.p.x

            tubarao2.esqueleto.pos = tubarao2.esqueleto.pos + (tubarao2.p/tubarao2.mass)*dt
            if not (side-20 > tubarao2.esqueleto.x > -side+20):
                tubarao2.p.x = -tubarao2.p.x

            tubarao3.esqueleto.pos = tubarao3.esqueleto.pos + (tubarao3.p/tubarao3.mass)*dt
            if not (side-20 > tubarao3.esqueleto.x > -side+20):
                tubarao3.p.x = -tubarao3.p.x

#Etapa colisões
            if (fabs(traira1.esqueleto.x - tubarao1.esqueleto.x) < 20) and ( fabs (traira1.esqueleto.y - tubarao1.esqueleto.y) < 15 ) or  (fabs(pangacio1.esqueleto.x - tubarao1.esqueleto.x) < 20) and ( fabs (pangacio1.esqueleto.y - tubarao1.esqueleto.y) < 15 ):
                        label(pos=(0,20,0), text='Tubarao na area!!! Tente novamente !!!' )
                        break
            if (fabs(traira1.esqueleto.x - tubarao2.esqueleto.x) < 20) and ( fabs (traira1.esqueleto.y - tubarao2.esqueleto.y) < 15 ) or (fabs(pangacio1.esqueleto.x - tubarao2.esqueleto.x) < 20) and ( fabs (pangacio1.esqueleto.y - tubarao2.esqueleto.y) < 15 ):
                        label(pos=(0,-60,0), text='O tubarao estava faminto !!! Jogue de novo!!!')
                        break
            if (fabs(traira1.esqueleto.x - tubarao3.esqueleto.x) < 20) and ( fabs (traira1.esqueleto.y - tubarao3.esqueleto.y) < 15 ) or (fabs(pangacio1.esqueleto.x - tubarao3.esqueleto.x) < 20) and ( fabs (pangacio1.esqueleto.y - tubarao3.esqueleto.y) < 15 ):
                        label(pos=(0,-60,0), text='O tubarao estava faminto !!! Jogue de novo!!!')
                        break
            traira1.proximoFrame()
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
'''
Estas classes são as especializações da classe SerMarinho...
'''
class Traira(SerMarinho):
    def desenha(self, escala=5):
        s=escala
        cabeca01 = ellipsoid(frame = self.esqueleto, pos=(5,1,0), length=10, height=9, width=8, color=color.green)
        cabeca02 = cone(frame = self.esqueleto, pos=(0,3,0), axis=(6,2,0), radius=3, color=color.green, opacity=1)
        boca = ring(frame = self.esqueleto, pos=(10,1,0), axis=(1,0,0), radius=1, thickness=0.5, color=color.red)
        olho01 = sphere(frame = self.esqueleto, pos=(5,4,3), radius=1, opacity=.5)
        olho02 = sphere(frame = self.esqueleto, pos=(5,4,3), radius=.5, color=color.black)
        olho11 = sphere(frame = self.esqueleto, pos=(5,4,-3), radius=1, opacity=.5)
        olho02 = sphere(frame = self.esqueleto, pos=(5,4,-3), radius=.5, color=color.black)
        corpo01 = sphere(frame = self.esqueleto, pos=(-1,0,0), radius=6, color = color.green, opacity=1)
        rabo1 = pyramid(frame = self.esqueleto, pos=(-12,0,0), size=(12,12,.3), color=color.green)
        rabo2 = pyramid(frame = self.esqueleto, pos=(-10,0,2), size=(6,6,.3), axis=(1,0,-0.4), color=color.blue)
        rabo3 = pyramid(frame = self.esqueleto, pos=(-10,0,-2), size=(6,6,.3), axis=(1,0,0.4), color=color.blue)
        dorsal1 = pyramid(frame = self.esqueleto, pos=(-4,4,0), size=(8,15,.3), axis=(2,.2,0),color=color.green)
        peitoralBE = pyramid(frame = self.esqueleto, pos=(-2,-1,9), size=(12,6,.3), axis=(2,.2,-4),color=color.blue)
        peitoralBB = pyramid(frame = self.esqueleto, pos=(-2,-1,-9), size=(12,6,.3), axis=(2,.2,4),color=color.blue)
    def proximoFrame(self):
        pass

class Tubarao(SerMarinho):
    def desenha(self, escala=1):
        u=escala/6.0
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

class Pangacio(SerMarinho):
    def desenha(self,escala=1):
        u=escala/6.0
        r=6*u
        l=6*r
        direcoes = [-r,0,r]
        self.cor1 = color.orange;
        self.cor2 = color.white;
        self.cor3 = color.black;
        self.cor4 = color.red;
        corpo1 = self.desenharEsfera((0,0,0),self.cor1,5*escala,1)
        olhoE = self.desenharEsfera((4*escala,1*escala,-1.5*escala),self.cor2,2*escala,0.5)
        olhoD = self.desenharEsfera((4*escala,1*escala,1.5*escala),self.cor2,2*escala,0.5)
        pupilaE = self.desenharEsfera((5*escala,1*escala,-1.5*escala),self.cor3,0.8)
        pupilaD = self.desenharEsfera((5*escala,1*escala,1.5*escala),self.cor3,0.8)
        labioSup = self.desenhaElipse((5*escala,-2*escala,0),2*escala,2*escala,3*escala, self.cor4)
        labioInf = self.desenhaElipse((4*escala,-3*escala,0*escala),2*escala,2*escala,3*escala,self.cor4)
        rabo1 = self.desenharPiramide((-10*escala,0,0),(8*escala,10*escala,.1*escala),(1*escala,0,0)*escala,self.cor1,0.6)
        rabo1.append = self.desenharCilindro((-10*escala,3*escala,-0.2*escala),(0,0,.3*escala),2*escala,self.cor1,1)
        rabo1.append = self.desenharCilindro((-9*escala,0,-0.2*escala),(0,0,.3*escala),2*escala,self.cor1,1)
        rabo1.append = self.desenharCilindro((-10*escala,-3*escala,-0.2*escala),(0,0,.3*escala),2*escala,self.cor1,1)
        dorsal1 = self.desenharCilindro((0,4*escala,0),(0,0,.1*escala),3*escala,self.cor1,0.5)
        dorsal2 = self.desenharCilindro((3*escala,3.5*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)
        dorsal3 = self.desenharCilindro((1.5*escala,4.5*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)
        dorsal4 = self.desenharCilindro((0,5*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)
        dorsal5 = self.desenharCilindro((-1.2*escala,4.5*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)
        dorsal6 = self.desenharCilindro((-2*escala,4*escala,0),(0,0,.1*escala),1*escala,self.cor1,1)

        barbatana10 = self.desenharCilindro((0,0,-5*escala),(0.1*escala,0,-0.1*escala),2*escala,self.cor1)
        barbatana11 = self.desenharCilindro((0,-2*escala,-5*escala),(0.1*escala,0,-0.1*escala),1*escala,self.cor1)
        barbatana10 = self.desenharCilindro((0,0,5*escala),(-0.1*escala,0,-0.1*escala),2*escala,self.cor1)
        barbatana11 = self.desenharCilindro((0,-2*escala,5*escala),(-0.1*escala,0,-0.1*escala),1*escala,self.cor1)
    def desenharEsfera(self,posicao=(0,0,0),cor=color.blue,raio=1, opacidade=1):
        return sphere(
            frame=self.esqueleto, pos=posicao,color=cor, radius = raio, opacity=opacidade
        )
    def desenhaElipse(self,posicao=(0,0,0),comprimento=1,altura=1,largura=1,cor=color.blue):
        return ellipsoid(
            frame=self.esqueleto,pos=posicao, length=comprimento, height=altura, width=largura, color=cor
        )
    def desenharPiramide(self,posicao=(0,0,0),tamanho=(1,1,1),eixos=(1,0,0),cor=color.blue,opacidade=1):
        return pyramid(
            frame=self.esqueleto,pos=posicao, size=tamanho,axis=eixos, color=cor, opacity=opacidade
        )
    def desenharCilindro(self,posicao=(0,0,0),eixo=(1,0,0),raio=1,cor=color.blue,opacidade=1):
        return cylinder(
            frame=self.esqueleto,pos=posicao,axis=eixo, radius=raio, color=cor, opacity=opacidade
        )
    def proximoFrame(self):
        pass

class Casa(SerMarinho):
    def desenha(self, escala=1):
        esc=escala
        parede = box ( frame = self.esqueleto, pos=( 0, 0, 0), length=20*esc, height=16*esc,  width=2*esc, color=color.magenta )
        porta  = box ( frame = self.esqueleto, pos=( 0, -3*esc, 0.1*esc), length=8*esc, height=10*esc,  width=2*esc , color=color.orange)
        telhado = pyramid(frame = self.esqueleto,  pos=(0,8*esc,0), size=(5*esc,20*esc,2*esc), axis = (0,1,0), color=color.red)
        chamine = box ( frame = self.esqueleto, pos=( 6*esc, 10.5*esc, -0.1*esc), length=4*esc, height=5*esc,  width=2*esc, color=color.red )

if __name__ == "__main__":
    cenario = Cenario()
    cenario.principal()

