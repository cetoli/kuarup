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

:Author: *Angela*
:Contact: amanume@gmail.com
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
#@+node:aluno.20090211133037.7:Glossario
resposta_do_voluntario = " "
palpite = 1
nao_acertou = True
#@nonl
#@-node:aluno.20090211133037.7:Glossario
#@+node:carlo.20090104111700.4:Participantes
def apresenta_os_participantes():
    return "Eu sou o advinho, você é o voluntário"
#@nonl
#@-node:carlo.20090104111700.4:Participantes
#@+node:carlo.20090104111700.5:Regra do jogo
def diz_a_regra_do_jogo():
    return "pense um número de 1 a 7", "diga a se acertei, s para eu subir, d para descer"
#@nonl
#@-node:carlo.20090104111700.5:Regra do jogo
#@+node:carlo.20090104111700.7:Palpite
def diz_o_palpite():
    return "o meu palpite é " + str (palpite)
#@nonl
#@-node:carlo.20090104111700.7:Palpite
#@+node:aluno.20090211133037.10:Tenta vários palpites
def tenta_varios_palpites():
    while nao_acertou:
        print diz_o_palpite()
        print escuta_o_voluntario()
        pense_e_ve_se_acertou()

#@-node:aluno.20090211133037.10:Tenta vários palpites
#@+node:aluno.20090211133037.3:Escuta o voluntário
def escuta_o_voluntario():
    global resposta_do_voluntario
    resposta_do_voluntario = raw_input("diga")
    return "você disse: " + resposta_do_voluntario
#@nonl
#@-node:aluno.20090211133037.3:Escuta o voluntário
#@+node:aluno.20090211133037.11:Muda Palpite
def muda_palpite():
    global palpite
    palpite = palpite + 1
#@nonl
#@-node:aluno.20090211133037.11:Muda Palpite
#@+node:aluno.20090211133037.4:Pense e ve se acertou
def pense_e_ve_se_acertou():
    global nao_acertou
    if resposta_do_voluntario == "a" :
        nao_acertou = False
        print "acertei" 
    else:
        muda_palpite()

#@-node:aluno.20090211133037.4:Pense e ve se acertou
#@+node:aluno.20090211133037.6:Joga o jogo do adivinho
def joga_o_jogo_do_adivinho():
        print apresenta_os_participantes()
        print diz_a_regra_do_jogo()
        tenta_varios_palpites()
#@-node:aluno.20090211133037.6:Joga o jogo do adivinho
#@-others
#@-node:carlo.20081219153110.7:<< Jogo do Adivinho >>
#@nl

def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    joga_o_jogo_do_adivinho()
#@-node:carlo.20080914080659.3:@thin adivinho.py
#@-leo
