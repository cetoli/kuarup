from visual import *

from random import randint

from commands import *

PHI= (1+sqrt(5))/2

PHI2= PHI**2

PHI3= PHI**3

PHI4= PHI**4

GRAUS_30= pi/6.0

EIXO_Z= (0,0,1)

EIXO_NE= (1,1,0)

EIXO_SE= (1,-1,0)

EIXO_SSE= (2,-1,1)

EIXO_SSO= (2,-1,-1)

class Cenario:

    def __init__(self):

        scene2 = display(title='Peexis',

            width=150, height=150,

            center= (0,0,0),

            x=0, y=0)

        scene2.x, scene2.y =0,0

        scene2.select()

        scene2.autoscale = 1

        self.quadro = 0

    def filmando(self):

        " so funciona no linux, e requer a instalacao do ImageMagick"

        #getoutput('import -window "Peexis"  peexis.%03d.gif' % self.quadro)

        self.quadro+=1

    def principal(self):

        peixinho=Peixe()

        #return

        for x in range(50):

            rate(4)

            peixinho.nadando()

            #self.filmando()

        return

        #getoutput('convert -delay 10 -loop 0 peexis.*.gif animated.peexis.gif')

        #getoutput('rm peexis.*.gif ')

class SerMarinho():

    '''

    Classe base de qualquer ser marinho

    '''

    def __init__(self, **qualquel_outro_parametro):

        "Construtor do ser marinho, definindo um esqueleto(frame) e desenhando"

        self.esqueleto=frame(**qualquel_outro_parametro)

        self.desenha()

    def desenha(self): pass

class Peixe(SerMarinho):

    def desenha(self):

        self.tamanho = t = 4

        self.ltop=0

        self.lbot=0

        self.angulo_nadadeiras =pi/16

        self.direcao_atual=(-1,0,0)

        self.cor_do_corpo=color.cyan

        self.cor_cauda = cor_cauda = color.red

        self.desenha_o_corpo(self.cor_do_corpo,l=t)

        self.cauda_superior=self.desenha_o_corpo(cor_cauda,l=t*1/PHI**2,d= (t*1.5/PHI,t*1/PHI4))

        self.cauda_inferior=self.desenha_o_corpo(cor_cauda,l=t*1/PHI**2,d= (t*1.5/PHI,t*-1/PHI4))

        self.cauda_superior.rotate(angle=GRAUS_30, axis=EIXO_Z)

        self.cauda_inferior.rotate(angle=-GRAUS_30, axis=EIXO_Z)

        self.labio_superior= self.desenha_o_labio(eixo= EIXO_NE)

        self.labio_inferior= self.desenha_o_labio(eixo= EIXO_SE)

        self.olho_esquerdo = self.desenha_o_olho(l=t,d=(-t*0.7/PHI,t*1/PHI4,t*1.2/PHI4))

        self.olho_direito = self.desenha_o_olho(l=t,d=(-t*0.7/PHI,t*1/PHI4,-t*1.2/PHI4))

        self.barbatana_dorsal= self.desenha_a_barbatana(l=t,d=(-t*0.1/PHI,t*1/PHI4),eixo= EIXO_NE)

        self.nadadeira_direita= self.desenha_a_nadadeira(l=t,d=(-t*0.2/PHI,-t*0.1/PHI4),eixo= EIXO_SSE)

        self.nadadeira_esquerda= self.desenha_a_nadadeira(l=t,d=(-t*0.2/PHI,-t*0.1/PHI4),eixo= EIXO_SSO)

    def desenha_a_barbatana(self,l=1,eixo=(0,0),d=(0,0)):

        return pyramid(

           frame=self.esqueleto,size=(l,l/PHI,l/PHI4),pos=d,color=self.cor_cauda, axis=eixo

        )

    def desenha_a_nadadeira(self,l=1,eixo=(0,0),d=(0,0)):

        return pyramid(

           frame=self.esqueleto,size=(l,l/PHI4,l/PHI),pos=d,color=self.cor_cauda, axis=eixo

        )

    def desenha_o_labio(self,eixo):

        t = self.tamanho

        return ring(

            frame=self.esqueleto,pos=(t*-1.1/PHI,0), axis=eixo,

            radius=t*0.15, thickness=t*0.07,color = self.cor_cauda

        )

    def desenha_o_corpo(self,cor,l=1,d=(0,0)):

        return ellipsoid(

                frame=self.esqueleto,size=(PHI*l,l,l/PHI),pos=d,color=cor

            )

    def desenha_o_olho(self,l=1,d=(0,0)):

        globo = l/PHI3

        return ellipsoid(

                frame=self.esqueleto,size=(globo,globo,globo),pos=d,color=color.blue

            )

    def nadando(self):

        "ainda nao e um   movimento decente, apenas se move aleatoriamente"

        self.ltop,self.lbot=(-self.ltop,-self.lbot)

        self.cauda_superior.rotate(angle=self.lbot, axis=(0,1,0))

        self.cauda_inferior.rotate(angle=self.ltop, axis=(0,1,0))

        self.ltop,self.lbot=(randint(-4,4)*pi/16,randint(-4,4)*pi/16)

        self.cauda_superior.rotate(angle=self.lbot, axis=(0,1,0))

        self.cauda_inferior.rotate(angle=self.ltop, axis=(0,1,0))

        self.esqueleto.pos=vector(self.esqueleto.pos)+vector(self.direcao_atual)*0.2

        rotation=pi/32+randint(-4,4)*pi/32

        self.direcao_atual=vector(self.direcao_atual).rotate(angle=rotation,axis=(0,1,0))

        self.esqueleto.rotate(angle=rotation,axis=(0,1,0))

        rotation=pi/64+randint(-4,4)*pi/64

        self.direcao_atual=vector(self.direcao_atual).rotate(angle=rotation,axis=(0,0,1))

        self.esqueleto.rotate(angle=rotation,axis=(0,0,1))

        self.angulo_nadadeiras = -self.angulo_nadadeiras

        self.nadadeira_direita.rotate(angle=-self.angulo_nadadeiras, axis=(1,0,0))

        self.nadadeira_esquerda.rotate(angle=self.angulo_nadadeiras, axis=(1,0,0))

if __name__ == "__main__":

    cenario= Cenario()

    cenario.principal()