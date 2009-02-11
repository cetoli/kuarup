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
#@+node:aluno.20090211132918.5:glossario
resposta_do_voluntario = "" 
palpite = 1
nao_acertou = True
#@-node:aluno.20090211132918.5:glossario
#@+node:carlo.20090104111700.4:Participantes
def apresenta_os_participantes():
    return "Eu sou o advinho, você é o voluntário"
#@nonl
#@-node:carlo.20090104111700.4:Participantes
#@+node:carlo.20090104111700.5:Regra do jogo
def diz_a_regra_do_jogo():
    return "pense um número de 1 a 7"," diga a se acertei, s para eu subir, d para eu descer"
#@nonl
#@-node:carlo.20090104111700.5:Regra do jogo
#@+node:carlo.20090104111700.7:Palpite
def diz_o_palpite():
    return " meu palpite é " + str(palpite)
#@nonl
#@-node:carlo.20090104111700.7:Palpite
#@+node:aluno.20090211132918.29:Tenta varios palpites
def tenta_varios_palpites():
    while nao_acertou:
          print diz_o_palpite()
          print escuta_o_voluntario()
          pensa_e_ve_se_acertou()
#@nonl
#@-node:aluno.20090211132918.29:Tenta varios palpites
#@+node:aluno.20090211132918.2:Escuta o voluntário
def escuta_o_voluntario():
    global resposta_do_voluntario
    resposta_do_voluntario = raw_input ("diga!")
    return "você disse: " + resposta_do_voluntario
#@nonl
#@-node:aluno.20090211132918.2:Escuta o voluntário
#@+node:aluno.20090211132918.28:Muda palpite
def muda_palpite():
    global palpite
    palpite = palpite + 1
#@nonl
#@-node:aluno.20090211132918.28:Muda palpite
#@+node:aluno.20090211132918.3:Pensa e ve se acertou
def pensa_e_ve_se_acertou():
    global nao acertou
    if resposta_do_voluntario == "a" : 
       nao acertou = False
        print "acertei!"
    else:
        muda_palpite()     

#@-node:aluno.20090211132918.3:Pensa e ve se acertou
#@+node:aluno.20090211132918.4:Joga o jogo do adivinho
def joga_o_jogo_do_adivinho():
    print apresenta_os_participantes()
    print diz_a_regra_do_jogo()
    Tenta_varios_palpites
    pensa_e_ve_se_acertou()

#@nonl
#@-node:aluno.20090211132918.4:Joga o jogo do adivinho
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
