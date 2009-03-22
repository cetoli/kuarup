#! /usr/bin/env python
# -*- coding: UTF8 -*-
"""
##################
Marujos Pe e Xis
##################

:Author: Txukarrame
:Contact: `Txucarramae <http://is.gd/n3Dr>`__
:Date: 2009-02-14 $Date$
:Status: This is a "work in progress"
:Revision: 1.0 $Revision$
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
"""

'''
Os marujos Pe e Xis são dois peixes que querem ser grandes empresários e montar  um grande centro de divertimento para criaturas do mar. No momento são apenas peixes comuns e atrapalhados que precisam de muita ajuda para seguir em frente. Eles vão ser desafiados pelas mais simples circunstâncias de seu ambiente natural a cada passo do seu caminho. A obtenção de suas metas vai ser um grande aprendizado para todos nós.
'''
from visual import *

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
    def principal(self):
        peixinho=Peixe()

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

if __name__ == "__main__":
    cenario= Cenario()
    cenario.principal()

