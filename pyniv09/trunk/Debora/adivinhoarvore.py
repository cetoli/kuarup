#! /usr/bin/env python
# -*- coding: UTF8 -*-
#@+leo-ver=4-thin
#@+node:aluno.20090213161718.2:@thin adivinhoarvore.py
#@@first
#@@first
#@@language python
#@@tabwidth -4
#@<< Cabeçalho >>
#@+node:aluno.20090213161718.3:<< Cabeçalho >>
"""
#@+others
#@+node:aluno.20090213161718.4:@rst-no-head Autor
##################
O Jogo do Adivinho
##################

:Author: *Samantha*
:Contact: svrabl@gmail.com
:Date: $Date: 2009/02/06  $
:Status: This is a "work in progress"
:Revision: $Revision: 1.00 $
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
#@-node:aluno.20090213161718.4:@rst-no-head Autor
#@-others
"""
#@-node:aluno.20090213161718.3:<< Cabeçalho >>
#@nl
#@<< Jogo do Adivinho >>
#@+node:aluno.20090213161718.5:<< Jogo do Adivinho >>
#@+others
#@+node:aluno.20090213161718.10:Importa do Adivinho
from adivinho import Adivinhacao
#@nonl
#@-node:aluno.20090213161718.10:Importa do Adivinho
#@+node:aluno.20090213161718.6:Documentação
'''
>>> # Apresenta os participantes
Eu sou o advinho, você é o voluntário
>>> # Apresenta as regras
pense um número de 1 a 7
>>> # Dá o palpite
o meu palpite é 4
>>>
'''
#@nonl
#@-node:aluno.20090213161718.6:Documentação
#@+node:aluno.20090213161718.7:A classe Adivinhacao
class AdivinhaArvore(Adivinhacao):
    #@    @+others
    #@+node:aluno.20090213161718.8:Glossario
    resposta_do_voluntario = ""
    nao_acertou = True
    PALPITE,COLECAO =(0,1)
    DESCE,SOBE = (0,1)
    decide_palpite = [4,[
       [2,[
          [1,[]],
          [3,[]]
        ]
       ],
       [6,[
            [5,[]],
            [7,[]],
          ]
        ]
     ]]           
    palpite = decide_palpite[PALPITE]
    #@nonl
    #@-node:aluno.20090213161718.8:Glossario
    #@+node:aluno.20090213161718.9:Muda palpite
    def muda_palpite(self):
        colecao_de_subarvores= self.decide_palpite[self.COLECAO]
        if self.resposta_do_voluntario == "d":
            self.decide_palpite = colecao_de_subarvores[self.DESCE]
        else:
            self.decide_palpite = colecao_de_subarvores[self.SOBE]
            self.palpite =self.decide_palpite[self.PALPITE]    
    #@nonl
    #@-node:aluno.20090213161718.9:Muda palpite
    #@-others
    # others - tudo que está pendurado na classe Adivinhacao coloca debaixo da classe. #
    # é uma notaçao do leo#
#@nonl
#@-node:aluno.20090213161718.7:A classe Adivinhacao
#@-others
#@nonl
#@-node:aluno.20090213161718.5:<< Jogo do Adivinho >>
#@nl

def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    minha_adivinhacao = AdivinhaArvore() #chama o fabricador da maquina de van neuman
    minha_adivinhacao.joga_o_jogo_do_adivinho()
#@-node:aluno.20090213161718.2:@thin adivinhoarvore.py
#@-leo
