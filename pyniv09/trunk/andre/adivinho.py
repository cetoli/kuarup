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
#@+node:carlo.20090104111700.4:Participantes
def apresenta_participantes():
    return "\nEu sou o Jogo do Advinho, você é o voluntário! \n"
#@nonl
#@-node:carlo.20090104111700.4:Participantes
#@+node:aluno.20090211135634.3:Globais
resposta = ""
palpite = 1
nao_acertou = True
#@nonl
#@-node:aluno.20090211135634.3:Globais
#@+node:carlo.20090104111700.5:Regra do jogo
def diz_a_regra_do_jogo():    
    return "Pense um número de 1 a 100 \n" "Diga a se acertei, s para eu subir o palpite e d para eu descer o palpite."
#@-node:carlo.20090104111700.5:Regra do jogo
#@+node:carlo.20090104111700.7:Palpite
def da_um_palpite():
    #import random
    #global palpite

    #palpite = random.randint(1,7)
    return "\nEu acho que você pensou no número " + str(palpite)
#@-node:carlo.20090104111700.7:Palpite
#@+node:aluno.20090206164348.2:Resposta do Voluntário
def obtem_resposta_voluntario():
    global resposta 
    resposta = raw_input ("Diga sua resposta:")
    return "Você disse: " + resposta
#@nonl
#@-node:aluno.20090206164348.2:Resposta do Voluntário
#@+node:aluno.20090211135634.4:Muda Palpite
def muda_palpite_pracima():
    global palpite
    palpite += 1

def muda_palpite_prabaixo():
    global palpite
    palpite -= 1
#@nonl
#@-node:aluno.20090211135634.4:Muda Palpite
#@+node:aluno.20090206164348.3:Pense pra ver se acertou
def analisa_resposta():
    global nao_acertou
    if (resposta == 'a'):
        nao_acertou = False
        return ("Acertei sua resposta!");
    elif (resposta == 's'):
        muda_palpite_pracima()
        return ("Deverei subir o meu palpite!");
    elif (resposta == 'd'):
        muda_palpite_prabaixo()
        return ("Deverei descer o palpite");
    else:
        return "Comando não reconhecido"
#@nonl
#@-node:aluno.20090206164348.3:Pense pra ver se acertou
#@+node:aluno.20090211135634.5:Tenta varios palpites
def tenta_varios_palpites():
    while nao_acertou == True:
        from time import sleep
        sleep(2)

        print da_um_palpite()
        print obtem_resposta_voluntario()
        print analisa_resposta()
#@-node:aluno.20090211135634.5:Tenta varios palpites
#@+node:aluno.20090211135634.2:Joga o jogo do advinho
def joga_adivinha_um_numero():
    print apresenta_participantes()
    print diz_a_regra_do_jogo()
    tenta_varios_palpites()
#@-node:aluno.20090211135634.2:Joga o jogo do advinho
#@-others
#@-node:carlo.20081219153110.7:<< Jogo do Adivinho >>
#@nl

def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    joga_adivinha_um_numero()
#@-node:carlo.20080914080659.3:@thin adivinho.py
#@-leo
