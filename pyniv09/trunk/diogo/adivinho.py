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

:Author: *Seu nome Aqui*
:Contact: seu email
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
pense um número de 1 a 7
>>> # Dá o palpite
o meu palpite é 4
>>>
'''
#@nonl
#@-node:carlo.20081219153110.8:Documentação
#@+node:aluno.20090211134413.3:VariaveisUtilizadas
import random
minimo=0
maximo=100
palpite=0
acertei = False
#@nonl
#@-node:aluno.20090211134413.3:VariaveisUtilizadas
#@+node:carlo.20090104111700.4:Participantes
def apresentaParticipantes():
    print "\nEu sou o advinho, você é o voluntário"
#@nonl
#@-node:carlo.20090104111700.4:Participantes
#@+node:carlo.20090104111700.5:Regra do jogo
def apresentaRegras():
    print "pense um número de %s a %s" % (minimo, maximo)
#@nonl
#@-node:carlo.20090104111700.5:Regra do jogo
#@+node:carlo.20090104111700.7:Joga
def jogar()
    while acertei==False:
        random.seed()
        palpite = (minimo+maximo)/2

        #random.randint(minimo,maximo)

        print "\nO meu palpite é %s \n" % palpite
        resposta = raw_input("Diga se acertei.\n Se o numero for maior, digite '>'\n Se for menor , digite '<'\n Ou se acertei, digite '='\n Qual a sua dica? ")

        if resposta == ">":
            print "O numero é maior que o palpite"
            minimo = palpite
        elif resposta == '<':
            print "O numero é menor que o palpite"
            maximo = palpite
        elif resposta == '=':
            print "Acertei!!!"
            acertei = True
        else:
            print "Dê uma dica válida!"

#@-node:carlo.20090104111700.7:Joga
#@+node:aluno.20090211134413.5:Inicio
def inicioJogo():
    apresentaParticipantes()
    apresentaRegras()
    jogar()
#@nonl
#@-node:aluno.20090211134413.5:Inicio
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
