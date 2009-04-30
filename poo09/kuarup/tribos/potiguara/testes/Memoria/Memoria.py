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

sleep(5)# gambiarra pra ajustar a tela, é só ajustar o imagegrab ou o local em que a tela se apresenta...

pangacio = Pangacio(escala =1, axis=(1,0,1), pos= (0,-50,5))
pangacio.esqueleto.rotate(angle = pi/2, axis=(1,1,1), original=(1,1,1))

orientacao = label()
orientacao.text = 'Observe a sequencia para remonta-la'
orientacao.y = 80

dica = label()
dica.text = 'Considera as cores, os objetos e sequencia sao importantes'
dica.y = 70

# Sequencia determinada
oBase1 = Objeto(escala=15,pos=(-60,50,0),obj='caixa',cor=color.red)
oBase2 = Objeto(escala=15,pos=(-20,50,0),obj='cone',cor=color.yellow)
oBase3 = Objeto(escala=15,pos=(20,50,0),obj='piramide',cor=color.green)
oBase4 = Objeto(escala=15,pos=(60,50,0),obj='circulo',cor=color.white)

#opções de escolha para remontar a sequencia determinada
#
o1 = Objeto(escala=10,pos=(-85,-65,0),obj='caixa',cor=color.red)
o1_2 = Objeto(escala=10,pos=(-65,-68,0),obj='caixa',cor=color.green)
o1_3 = Objeto(escala=10,pos=(-83,-85,0),obj='caixa',cor=color.orange)

o2 = Objeto(escala=10,pos=(-75,-23,0),obj='cone',cor=color.yellow)
o2_2 = Objeto(escala=10,pos=(-55,-35,0),obj='cone',cor=color.cyan)
o2_3 = Objeto(escala=10,pos=(-80,-40,0),obj='cone',cor=color.white)

o3 = Objeto(escala=10,pos=(12,-57,0),obj='piramide',cor=color.white)
o3_2 = Objeto(escala=10,pos=(-10,-65,0),obj='piramide',cor=color.green)
o3_3 = Objeto(escala=10,pos=(10,-77,0),obj='piramide',cor=color.red)

o4 = Objeto(escala=10,pos=(85,-65,0),obj='circulo',cor=color.white)
o4_2 = Objeto(escala=10,pos=(65,-68,0),obj='circulo',cor=color.magenta)
o4_3 = Objeto(escala=10,pos=(83,-85,0),obj='circulo',cor=color.orange)

o5 = Objeto(escala=10,pos=(75,-23,0),obj='cilindro',cor=color.orange)
o5_2 = Objeto(escala=10,pos=(55,-35,0),obj='cilindro',cor=color.cyan)
o5_3 = Objeto(escala=10,pos=(80,-40,0),obj='cilindro',cor=color.yellow)

sleep(2)

#utilizado para marcar a primeira posicao dos objtos
auxObjeto = Objeto(escala=5,pos=(-132.5,0,0),visible=0,obj='caixa')#obj='caixa' seria default
selecionador = Posicionador(auxObjeto)



aux = 4 #iniciar em uma posicao proximo para gravacao
quadro = 0

while (oBase4.objeto.opacity > 0): #poderia utiliza qq objeto OBase
    rate(20)
    
    im = ImageGrab.grab((0,0,585,585))
    fn = "Pangacio-teste-letramento-"+str(quadro)+".png"
    im.save(fn)
    quadro += 1
        
    oBase1.apagarExibir(oBase1.objeto.opacity - 0.1)
    oBase2.apagarExibir(oBase2.objeto.opacity - 0.1)
    oBase3.apagarExibir(oBase3.objeto.opacity - 0.1)
    oBase4.apagarExibir(oBase4.objeto.opacity - 0.1)

oBase1.esqueleto.visible = 0
oBase2.esqueleto.visible = 0
oBase3.esqueleto.visible = 0
oBase4.esqueleto.visible = 0

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
            
        elif ((fabs( pangacio.esqueleto.y - o1_2.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o1_2.esqueleto.x) < 7) ):
            selecionador.exibe(o1_2)
            auxObjetoPosicao = o1_2

        elif ((fabs( pangacio.esqueleto.y - o1_3.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o1_3.esqueleto.x) < 7) ):
            selecionador.exibe(o1_3)
            auxObjetoPosicao = o1_3

        elif ((fabs( pangacio.esqueleto.y - o2.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o2.esqueleto.x) < 7) ):
            selecionador.exibe(o2)
            auxObjetoPosicao = o2

        elif ((fabs( pangacio.esqueleto.y - o2_2.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o2_2.esqueleto.x) < 7) ):
            selecionador.exibe(o2_2)
            auxObjetoPosicao = o2_2

        elif ((fabs( pangacio.esqueleto.y - o2_3.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o2_3.esqueleto.x) < 7) ):
            selecionador.exibe(o2_3)
            auxObjetoPosicao = o2_3

        elif ((fabs( pangacio.esqueleto.y - o3.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o3.esqueleto.x) < 7) ):
            selecionador.exibe(o3)
            auxObjetoPosicao = o3

        elif ((fabs( pangacio.esqueleto.y - o3_2.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o3_2.esqueleto.x) < 7) ):
            selecionador.exibe(o3_2)
            auxObjetoPosicao = o3_2

        elif ((fabs( pangacio.esqueleto.y - o3_3.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o3_3.esqueleto.x) < 7) ):
            selecionador.exibe(o3_3)
            auxObjetoPosicao = o3_3

        elif ((fabs( pangacio.esqueleto.y - o4.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o4.esqueleto.x) < 7) ):
            selecionador.exibe(o4)
            auxObjetoPosicao = o4

        elif ((fabs( pangacio.esqueleto.y - o4_2.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o4_2.esqueleto.x) < 7) ):
            selecionador.exibe(o4_2)
            auxObjetoPosicao = o4_2

        elif ((fabs( pangacio.esqueleto.y - o4_3.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o4_3.esqueleto.x) < 7) ):
            selecionador.exibe(o4_3)
            auxObjetoPosicao = o4_3

        elif ((fabs( pangacio.esqueleto.y - o5.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o5.esqueleto.x) < 7) ):
            selecionador.exibe(o5)
            auxObjetoPosicao = o5

        elif ((fabs( pangacio.esqueleto.y - o5_2.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o5_2.esqueleto.x) < 7) ):
            selecionador.exibe(o5_2)
            auxObjetoPosicao = o5_2

        elif ((fabs( pangacio.esqueleto.y - o5_3.esqueleto.y) < 7) and (fabs( pangacio.esqueleto.x - o5_3.esqueleto.x) < 7) ):
            selecionador.exibe(o5_3)
            auxObjetoPosicao = o5_3

        else:
            auxObjetoPosicao = auxObjeto # nenhum objeto do campo de escolha foi selecionado/tocado

        if (auxObjetoPosicao.estado == 1): #Objeto foi selecionado
            contadorEscolhas += 1
            print contadorEscolhas
        elif (auxObjetoPosicao.estado == 0): #Objeto foi 'desescolhido'. auxObjetoPosicao == 2, significa que nada aconteceu c/ os objetos
            contadorEscolhas -= 1

        # Captura de GIFs
        aux += 1
        if( aux == 7) :
            im = ImageGrab.grab((0,0,585,585))
            fn = "Pangacio-teste-letramento-"+str(quadro)+".png"
            im.save(fn)
            aux = 0
            quadro += 1
            
# se todas as letras estiverem acima da posicao inical, entao todas foram selecionadas
        if (contadorEscolhas == 4): 
            oBase1.apagarExibir(1)
            oBase1.esqueleto.visible = 1
            
            oBase2.apagarExibir(1)
            oBase2.esqueleto.visible = 1
            
            oBase3.apagarExibir(1)
            oBase3.esqueleto.visible = 1

            oBase4.apagarExibir(1)
            oBase4.esqueleto.visible = 1
            
            final = label()
            final.text = 'FIM'
            final.color = color.red
            final.y = -40

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
