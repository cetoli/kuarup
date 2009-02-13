#! /usr/bin/env python
# -*- coding: UTF8 -*-
#@+leo-ver=4-thin
#@+node:aluno.20090213133441.2:@thin adivinhoarvore.py
#@@first
#@@first
#@@language python
#@@tabwidth -4
#@<< Cabeçalho >>
#@+node:aluno.20090213133441.3:<< Cabeçalho >>
"""
#@+others
#@+node:aluno.20090213133441.4:@rst-no-head Autor
##################
O Jogo do Adivinho
##################

:Author: *Seu nome Aqui*
:Contact: seu email
:Date: $Date: 2009/02/06  $
:Status: This is a "work in progress"
:Revision: $Revision: 1.00 $
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
#@-node:aluno.20090213133441.4:@rst-no-head Autor
#@-others
"""
#@-node:aluno.20090213133441.3:<< Cabeçalho >>
#@nl
#@<< Jogo do Adivinho >>
#@+node:aluno.20090213133441.5:<< Jogo do Adivinho >>
#@+others
#@+node:aluno.20090213133441.7:Documentação
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
#@-node:aluno.20090213133441.7:Documentação
#@+node:aluno.20090213133441.6:Importa e Cria a classe
from adivinho import Adivinhacao

#@-node:aluno.20090213133441.6:Importa e Cria a classe
#@+node:aluno.20090213133441.8:Classe Advinhacao
class AdivinhaLista(Adivinhacao):
    #@    @+others
    #@+node:aluno.20090213133441.9:Globais
    decide_palpite = [ 4, [
                            [2, [
                                [1, []],
                                [3, []]
                                ]
                            ],
                            [6, [
                                [5, []],
                                [7, []]
                            ]
                        ]
                    ]]
    resposta = ""
    palpite = decide_palpite[0]
    nao_acertou = True
    PALPITE,COLECAO = (0,1)
    DESCE,SOBE = (0,1)
    #@-node:aluno.20090213133441.9:Globais
    #@+node:aluno.20090213133441.14:Muda Palpite
    def muda_palpite_pracima(self):
        self.decide_palpite = self.decide_palpite[self.COLECAO][self.SOBE]
        self.palpite = self.decide_palpite[self.PALPITE] 

    def muda_palpite_prabaixo(self):
        self.decide_palpite = self.decide_palpite[self.COLECAO][self.DESCE]
        self.palpite = self.decide_palpite[self.PALPITE]
    #@-node:aluno.20090213133441.14:Muda Palpite
    #@-others
#@nonl
#@-node:aluno.20090213133441.8:Classe Advinhacao
#@-others
#@-node:aluno.20090213133441.5:<< Jogo do Adivinho >>
#@nl

def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    minha_adivinhacao = AdivinhaLista()
    minha_adivinhacao.joga_adivinha_um_numero()
#@-node:aluno.20090213133441.2:@thin adivinhoarvore.py
#@-leo
