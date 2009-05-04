from visual import *
from Pangacio import *
from SerMarinho import *
from Objeto import *
from SelecionadorObjeto import *
import Image
import ImageGrab
from time import sleep

side = 100
thk = 0.3
s2 = 2*side - thk
s3 = 2*side + thk

cm=750.0
scene2 = display (title="Potiguara", width=600, height=600, background=(128/cm,128/cm,255/cm))
scene2.autoscale  = 60
scene2.select()

# Delimitação do aquário
wallR = box (pos=( side, 0, -5), length=thk, height=s2,  width=10,  color = color.blue, opacity=1) # esquerda
wallL = box (pos=(-side, 0, -5), length=thk, height=s2,  width=10,  color = color.blue, opacity=1) # direita
wallB1 = box (pos=(0, -side, -5), length=200,  height=thk, width=10,  color = color.blue, opacity=1)
#wallB2 = box (pos=(-55, -side, -5), length=90,  height=thk, width=10,  color = color.blue, opacity=1)        
wallB1 = box (pos=(0, side, -5), length=200,  height=thk, width=10,  color = color.blue, opacity=1)
#wallB2 = box (pos=(-55, side, -5), length=90,  height=thk, width=10,  color = color.blue, opacity=1) 
wallBK = box(pos=(0, 0, -5), length=s2,  height=s2,  width=thk, color = color.white, opacity=0.1)

#scene2.forward = (0,1.5,-0.3)
#scene2.scale = (1,0.22,1)

#lamp = local_light(pos=(1,1,1), color=color.yellow)

pangacio = Pangacio(escala =1, axis=(1,0,1), pos= (0,-50,5))
pangacio.esqueleto.rotate(angle = pi/2, axis=(1,1,1), original=(1,1,1))

orientacao = label()
orientacao.text = 'Tres formas sao necessarias para criar esta flor.'
orientacao.y = 80
orientacao.x = 20

tarefa = label()
tarefa.text = 'Selecione as tres.'
tarefa.y = 70
tarefa.x = 20

# Sequencia determinada
petala1 = Objeto(escala=15,pos=(-77,50,0),obj='elipse',cor=color.yellow)
petala1.esqueleto.rotate(angle = pi/2, axis=(0,0,1), original=(1,0,0))
petala1.esqueleto.rotate(angle = pi/2, axis=(1,0,0), original=(1,0,0))

petala2 = Objeto(escala=15,pos=(-42,50,0),obj='elipse',cor=color.yellow)
petala2.esqueleto.rotate(angle = pi/2, axis=(0,0,1), original=(1,0,0))
petala2.esqueleto.rotate(angle = pi/2, axis=(1,0,0), original=(1,0,0))

petala3 = Objeto(escala=12,pos=(-60,65,0),obj='elipse',cor=color.yellow)
petala3.esqueleto.rotate(angle = pi/2, axis=(0,0,1), original=(1,0,0))
petala3.esqueleto.rotate(angle = pi/2, axis=(1,0,0), original=(1,0,0))
petala3.esqueleto.rotate(angle = pi, axis=(1,1,0), original=(0,1,0))

petala4 = Objeto(escala=14,pos=(-68,35,0),obj='elipse',cor=color.yellow)
petala4.esqueleto.rotate(angle = pi/2, axis=(0,0,1), original=(1,0,0))
petala4.esqueleto.rotate(angle = pi/2, axis=(1,0,0), original=(1,0,0))
petala4.esqueleto.rotate(angle = pi, axis=(-0.6,1,0), original=(0,1,0))

petala5 = Objeto(escala=14,pos=(-52,35,0),obj='elipse',cor=color.yellow)
petala5.esqueleto.rotate(angle = pi/2, axis=(0,0,1), original=(1,0,0))
petala5.esqueleto.rotate(angle = pi/2, axis=(1,0,0), original=(1,0,0))
petala5.esqueleto.rotate(angle = pi, axis=(0.6,1,0), original=(0,1,0))

centro = Objeto(escala=7,pos=(-60,49,0),obj='circulo',cor=color.red)

talo = Objeto(escala=60,radius=0.01,pos=(-60,-20,-0.2),obj='cilindro',cor=color.green)

folha = Objeto(escala=10,pos=(-50,10,0),obj='elipse',cor=color.green)
folha.esqueleto.rotate(angle = pi/2, axis=(0,0,1), original=(1,0,0))
folha.esqueleto.rotate(angle = pi/2, axis=(1,0,0), original=(1,0,0))

#Formas
o1 = Objeto(escala=10,pos=(-80,-45,0),obj='caixa',cor=color.white)
o2 = Objeto(escala=10,pos=(-50,-45,0),obj='cone',cor=color.white)
o3 = Objeto(escala=10,pos=(-20,-45,0),obj='piramide',cor=color.white)
o4 = Objeto(escala=10,pos=(10,-45,0),obj='circulo',cor=color.white)
o5 = Objeto(escala=10,pos=(40,-50,0),obj='cilindro',cor=color.white)
o5.objeto.radius = 1
o6 = Objeto(escala=10,pos=(70,-45,0),obj='elipse',cor=color.white)
o6.esqueleto.rotate(angle = pi/2, axis=(0,0,1), original=(1,0,0))
o6.esqueleto.rotate(angle = pi/2, axis=(1,0,0), original=(1,0,0))

#Formas utilizadas
forma1 = Objeto(escala=10,pos=(15,35,0),obj='elipse',cor=color.orange)
forma1.esqueleto.rotate(angle = pi/2, axis=(0,0,1), original=(1,0,0))
forma1.esqueleto.rotate(angle = pi/2, axis=(1,0,0), original=(1,0,0))
forma2 = Objeto(escala=10,pos=(50,35,0),obj='circulo',cor=color.orange)
forma3 = Objeto(escala=10,pos=(85,35,0),obj='cilindro',cor=color.orange)
forma3.objeto.radius = 1

#Ocultando a resposta
forma1.esqueleto.visible = 0
forma2.esqueleto.visible = 0
forma3.esqueleto.visible = 0

sleep(2)

#utilizado para marcar a primeira posicao dos objtos
auxObjeto = Objeto(escala=5,pos=(-10.5,0,0),visible=0,obj='caixa')#obj='caixa' seria default
selecionador = Posicionador(auxObjeto)


aux = 0
quadro = 0
auxEsquerdaDireita = 0
auxLado = 0
t = 0
dt = 0.5
contadorEscolhas = 0
auxObjetoPosicao = auxObjeto #irá identificar o objeto selecionado para saber se ele foi escolhido ou 'desescolhido'
auxObjetoPosicao.estado = 2
while 1:

    rate(70)
                    
    # Controle o seu peixe!
    if scene2.kb.keys:
        s = scene2.kb.getkey()

        if (s == 'up'):
            pangacio.p = vector (0,1,0)
            if (pangacio.esqueleto.y < 121):
                auxLado += 1

        elif (s == 'down'):
            pangacio.p = vector (0,-1,0)
            if (pangacio.esqueleto.y > -100):
                auxLado -= 1
                    
        elif (s == 'left'):
            pangacio.p = vector (-1,0,0)
            if (pangacio.esqueleto.x > -100):
                auxEsquerdaDireita -= 1

        elif (s == 'right'):
            pangacio.p = vector (1,0,0)
            if (pangacio.esqueleto.x < 100):
                auxEsquerdaDireita += 1
        
        elif (s == 'q'):
            print 'TCHAU'
            break
            quit

        pangacio.esqueleto.axis.y = pangacio.p.y + auxLado
        pangacio.esqueleto.axis.x = pangacio.p.x + auxEsquerdaDireita
        pangacio.esqueleto.axis.z = pangacio.p.z
        pangacio.esqueleto.y += auxLado
        pangacio.esqueleto.x += auxEsquerdaDireita
        t = t + dt
          
        auxLado = 0
        auxEsquerdaDireita = 0

        if ((fabs( pangacio.esqueleto.y - o1.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o1.esqueleto.x) < 7) ):
            selecionador.exibe(o1)
            auxObjetoPosicao = o1
            
        elif ((fabs( pangacio.esqueleto.y - o2.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o2.esqueleto.x) < 7) ):
            selecionador.exibe(o2)
            auxObjetoPosicao = o2

        elif ((fabs( pangacio.esqueleto.y - o3.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o3.esqueleto.x) < 7) ):
            selecionador.exibe(o3)
            auxObjetoPosicao = o3

        elif ((fabs( pangacio.esqueleto.y - o4.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o4.esqueleto.x) < 7) ):
            selecionador.exibe(o4)
            auxObjetoPosicao = o4


        elif ((fabs( pangacio.esqueleto.y - o5.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o5.esqueleto.x) < 7) ):
            #o5.esqueleto.pos = (o5.esqueleto.x,o5.esqueleto.y-5,o5.esqueleto.z) # corrindo o posicionamento do cilindro
            selecionador.exibe(o5)
            auxObjetoPosicao = o5

        elif ((fabs( pangacio.esqueleto.y - o6.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o6.esqueleto.x) < 7) ):
            selecionador.exibe(o6)
            auxObjetoPosicao = o6

        else:
            auxObjetoPosicao = auxObjeto # nenhum objeto do campo de escolha foi selecionado/tocado

        if (auxObjetoPosicao.estado == 1): #Objeto foi selecionado
            contadorEscolhas += 1
            print contadorEscolhas
        elif (auxObjetoPosicao.estado == 0): #Objeto foi 'desescolhido'. auxObjetoPosicao == 2, significa que nada aconteceu c/ os objetos
            contadorEscolhas -= 1

        # Captura de GIFs
        aux += 1
        if( aux == 3) :
            im = ImageGrab.grab((0,0,585,585)) # já tem um imageGrab
            fn = "Pangacio-teste-Atencao-"+str(quadro)+".png"
            im.save(fn)
            aux = 0
            quadro += 1
            
# se todas as letras estiverem acima da posicao inical, entao todas foram selecionadas
        if (contadorEscolhas == 3): 
            final = label()
            final.text = 'FIM'
            final.color = color.red
            final.y = -40
            #Exibindo as formas utilizadas
            forma1.esqueleto.visible = 1
            forma2.esqueleto.visible = 1
            forma3.esqueleto.visible = 1

            #break

#corrigir o teste, letras se repetem e esta sequemcia esta errada
'''            if ((l8.esqueleto.x - l7.esqueleto.x == 15)and(l7.esqueleto.x - l6.esqueleto.x == 15)and(l6.esqueleto.x - l5.esqueleto.x == 15)and(l5.esqueleto.x - l4.esqueleto.x == 15)
                and (l4.esqueleto.x - l3.esqueleto.x == 15)and(l3.esqueleto.x - l2.esqueleto.x == 15)and(l2.esqueleto.x - l1.esqueleto.x == 15)):
                resultado = label()
                resultado.text = 'TENTE NOVAMENTE' # 'VOCE VENCEU' deveria estar aqui
                resultado.y = -40
            else:
                resultado = label()
                resultado.text = 'VOCE VENCEU' # 'TENTE NOVAMENTE' deveria estar aqui
                resultado.y = -40
'''
