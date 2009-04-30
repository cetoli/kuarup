from visual import *
from Pangacio import *
from SerMarinho import *
from Letra import *
from SelecionadorLetra import *
import Image
import ImageGrab

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
orientacao.text = 'Monte a palavra colocando as letras na ordem correta'
orientacao.y = 80

dica = label()
dica.text = 'Dica: E o nome pais'
dica.y = 70

l1 = Letra(escala=1,pos=(-52.5,0,0),carac='A')
l2 = Letra(escala=1,pos=(-37.5,0,0),carac='N')
l3 = Letra(escala=1,pos=(-22.5,0,0),carac='A')
l4 = Letra(escala=1,pos=(-7.5,0,0),carac='L')
l5 = Letra(escala=1,pos=(7.5,0,0),carac='M')
l6 = Letra(escala=1,pos=(22.5,0,0),carac='E')
l7 = Letra(escala=1,pos=(37.5,0,0),carac='A')
l8 = Letra(escala=1,pos=(52.5,0,0),carac='H')

auxLetra = Letra(escala=1,pos=(-82.5,0,0),visible=0,carac='0')
selecionador = Posicionador(auxLetra)

aux = 0
quadro = 0
auxEsquerdaDireita = 0
auxLado = 0
t = 0
dt = 0.5
while 1:

    rate(70)
    
    # Captura de GIFs
    aux += 1
    if( aux == 7) :
        im = ImageGrab.grab((0,0,585,585))
        fn = "Pangacio-teste-letramento-"+str(quadro)+".png"
        #im.save(fn)
        aux = 0
        quadro += 1
                    
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

        if ((fabs( pangacio.esqueleto.y - l1.esqueleto.y) < 5) and (fabs( pangacio.esqueleto.x - l1.esqueleto.x) < 5) ):
            selecionador.exibe(l1)

        if ((fabs( pangacio.esqueleto.y - l2.esqueleto.y) < 5) and (fabs( pangacio.esqueleto.x - l2.esqueleto.x) < 5) ):
            selecionador.exibe(l2)

        if ((fabs( pangacio.esqueleto.y - l3.esqueleto.y) < 5) and (fabs( pangacio.esqueleto.x - l3.esqueleto.x) < 5) ):
            selecionador.exibe(l3)

        if ((fabs( pangacio.esqueleto.y - l4.esqueleto.y) < 5) and (fabs( pangacio.esqueleto.x - l4.esqueleto.x) < 5) ):
            selecionador.exibe(l4)

        if ((fabs( pangacio.esqueleto.y - l5.esqueleto.y) < 5) and (fabs( pangacio.esqueleto.x - l5.esqueleto.x) < 5) ):
            selecionador.exibe(l5)

        if ((fabs( pangacio.esqueleto.y - l6.esqueleto.y) < 5) and (fabs( pangacio.esqueleto.x - l6.esqueleto.x) < 5) ):
            selecionador.exibe(l6)

        if ((fabs( pangacio.esqueleto.y - l7.esqueleto.y) < 5) and (fabs( pangacio.esqueleto.x - l7.esqueleto.x) < 5) ):
            selecionador.exibe(l7)

        if ((fabs( pangacio.esqueleto.y - l8.esqueleto.y) < 5) and (fabs( pangacio.esqueleto.x - l8.esqueleto.x) < 5) ):
            selecionador.exibe(l8) 
# se todas as letras estiverem acima da posicao inical, entao todas foram selecionadas
        if ((l1.esqueleto.y > 0)and(l2.esqueleto.y>0)and(l3.esqueleto.y>0)and(l4.esqueleto.y>0)and(l5.esqueleto.y>0)and(l6.esqueleto.y>0)and(l7.esqueleto.y>0)and(l8.esqueleto.y>0)):
            palavraCorreta = label()
            palavraCorreta.text = 'ALEMANHA'
            palavraCorreta.y = 37
            #palavraCorreta.visible = 0 # torna-se visivel qdo o jogador decide verficar se acertou a palavra

            final = label()
            final.text = 'FIM'
            final.color = color.red
            final.y = -50

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
