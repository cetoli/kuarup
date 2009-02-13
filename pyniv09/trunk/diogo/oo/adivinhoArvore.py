#! /usr/bin/env python
# -*- coding: UTF8 -*-
#@+leo-ver=4-thin
#@+node:aluno.20090213142502.2:@thin adivinhoArvore.py
#@@first
#@@first
#@@language python
#@@tabwidth -4
#@<< Cabeçalho >>
#@+node:aluno.20090213142502.3:<< Cabeçalho >>
"""
#@+others
#@+node:aluno.20090213142502.4:@rst-no-head Autor
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
#@-node:aluno.20090213142502.4:@rst-no-head Autor
#@-others
"""
#@-node:aluno.20090213142502.3:<< Cabeçalho >>
#@nl
#@<< Jogo do Adivinho >>
#@+node:aluno.20090213142502.5:<< Jogo do Adivinho >>
#@+others
#@+node:aluno.20090213142502.6:Importa a classe
from adivinho import Adivinhacao
#@nonl
#@-node:aluno.20090213142502.6:Importa a classe
#@+node:aluno.20090213142502.7:Documentação
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
#@-node:aluno.20090213142502.7:Documentação
#@+node:aluno.20090213142502.8:Classe AdvinhaArvore
class AdivinhaArvore(Adivinhacao):
    #@    @+others
    #@+node:aluno.20090213142502.9:Atributos
    DESCE, SOBE = (0,1)
    _decide_palpite = [ 4, [
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
    #@-node:aluno.20090213142502.9:Atributos
    #@+node:aluno.20090213142502.12:Palpite
    def da_um_palpite(self):
        #import random
        #global palpite

        #palpite = random.randint(1,7)
        self.palpite = self._decide_palpite[0]
        return "\nEu acho que você pensou no número " + str(self.palpite)
    #@-node:aluno.20090213142502.12:Palpite
    #@+node:aluno.20090213142502.14:Muda Palpite
    def muda_palpite_pracima(self):
        self._decide_palpite = self._decide_palpite[1][self.SOBE]
        palpite = self._decide_palpite[0]


    def muda_palpite_prabaixo(self):
        self._decide_palpite = self._decide_palpite[1][self.DESCE]
        palpite = self._decide_palpite[0]

    #@-node:aluno.20090213142502.14:Muda Palpite
    #@-others
#@nonl
#@-node:aluno.20090213142502.8:Classe AdvinhaArvore
#@-others
#@-node:aluno.20090213142502.5:<< Jogo do Adivinho >>
#@nl

def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    minha_adivinhacao = AdivinhaArvore()
    minha_adivinhacao.joga_adivinha_um_numero()
#@-node:aluno.20090213142502.2:@thin adivinhoArvore.py
#@-leo
