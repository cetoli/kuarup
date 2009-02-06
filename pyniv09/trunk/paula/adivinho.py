#! /usr/bin/env python
# -*- coding: UTF8 -*-
#@+leo-ver=4-thin
#@+node:carlo.20080914080659.3:@thin adivinho.py
#@@first
#@@first
#@@language python
#@@tabwidth -4
#@<< Cabeçalho >>
#@+node:carlo.20080914080659.5:<< Cabeçalho >>
"""
#@+others
#@+node:carlo.20080914080659.16:@rst-no-head Autor
##################
O Jogo do Adivinho
##################

:Author: *Paula*
:Contact: paulabastoscederj@gmail.com
:Date: $Date: 2009/02/06  $
:Status: This is a "work in progress"
:Revision: $Revision: 1.00 $
:Home: `LABASE <http://labase.nce.ufrj.br/>`__
:Copyright: ©2009, `GPL <http://is.gd/3Udt>`__
#@-node:carlo.20080914080659.16:@rst-no-head Autor
#@-others
"""
#@-node:carlo.20080914080659.5:<< Cabeçalho >>
#@nl
#@<< Jogo do Adivinho >>
#@+node:carlo.20081219153110.7:<< Jogo do Adivinho >>
#@+others
#@+node:carlo.20081219153110.8:Documentação
'''
>>> # Apresenta os participantes
Eu sou o advinho, você é o voluntário
>>> # Apresenta as regras
pense um número de 1 a 100
>>> # Dá o palpite
o meu palpite é 8
>>>
'''
#@nonl
#@-node:carlo.20081219153110.8:Documentação
#@+node:carlo.20090104111700.4:Participantes
print "Eu sou o advinho, você é o voluntário"
#@nonl
#@-node:carlo.20090104111700.4:Participantes
#@+node:carlo.20090104111700.5:Regra do jogo
print "pense um número de 1 a 7"
print "diga a se acertei, s para números maiores do que o palpite , d para números menores que o palpite"
#@nonl
#@-node:carlo.20090104111700.5:Regra do jogo
#@+node:carlo.20090104111700.7:Palpite
print "o meu palpite é 7"
#@nonl
#@-node:carlo.20090104111700.7:Palpite
#@+node:aluno.20090206141956.3:Escuta o voluntario
respostaDoVoluntario = raw_input ("Diga!")
print "você disse: " + respostaDoVoluntario 
#@nonl
#@-node:aluno.20090206141956.3:Escuta o voluntario
#@-others
#@-node:carlo.20081219153110.7:<< Jogo do Adivinho >>
#@nl

def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    _test()
#@-node:carlo.20080914080659.3:@thin adivinho.py
#@-leo
