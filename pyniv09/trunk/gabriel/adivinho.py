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
#@+node:aluno.20090211141308.17:A classe Adivinhacao
class Adivinhacao:
    #@    @+others
    #@+node:aluno.20090211141308.9:Glossario
    respostaDoVoluntario = ""
    palpite = 1
    nao_acertou = True
    #@nonl
    #@-node:aluno.20090211141308.9:Glossario
    #@+node:carlo.20090104111700.4:Participantes
    def apresentaOsParticipantes(self):
        print "Eu sou o advinho, você é o voluntário"
    #@nonl
    #@-node:carlo.20090104111700.4:Participantes
    #@+node:carlo.20090104111700.5:Regra do jogo
    def dizARegraDoJogo(self):
        print "pense um número de 1 a 7"
        print "diga a se acertei, s para eu subir e para eu descer."
    #@nonl
    #@-node:carlo.20090104111700.5:Regra do jogo
    #@+node:carlo.20090104111700.7:Palpite
    def dizOPalpite(self):
        print "o meu palpite é " + str(self.palpite)
        print "diga a se acertei, s para eu subir, d para descer o palpite"
    #@nonl
    #@-node:carlo.20090104111700.7:Palpite
    #@+node:aluno.20090211141308.16:Tenta Varios Palpites
    def tentaVariosPalpites(self):
        while self.nao_acertou:
            self.dizOPalpite()
            self.escutaOVoluntario()
            self.pensaEVeSeAcertou()
    #@nonl
    #@-node:aluno.20090211141308.16:Tenta Varios Palpites
    #@+node:aluno.20090206161713.3:Pensa e ve se acertou
    def pensaEVeSeAcertou(self):
        if self.respostaVoluntario =="a" : 
            print "acertei!"
            self.nao_acertou=False
        else:
            self.mudaPalpite()
    #@nonl
    #@-node:aluno.20090206161713.3:Pensa e ve se acertou
    #@+node:aluno.20090206161713.2:Escuta o voluntario
    def escutaOVoluntario(self):
        self.respostaVoluntario = raw_input("diga!")
        print "Voce disse:" + self.respostaVoluntario
    #@-node:aluno.20090206161713.2:Escuta o voluntario
    #@+node:aluno.20090211141308.15:Muda Palpite
    def mudaPalpite(self):
        self.palpite = self.palpite + 1
    #@nonl
    #@-node:aluno.20090211141308.15:Muda Palpite
    #@+node:aluno.20090211141308.2:Joga o Jogo do Adivinho
    def jogaOJogoDoAdivinho(self):
        self.apresentaOsParticipantes()
        self.dizARegraDoJogo()
        self.tentaVariosPalpites()
    #@-node:aluno.20090211141308.2:Joga o Jogo do Adivinho
    #@-others
#@nonl
#@-node:aluno.20090211141308.17:A classe Adivinhacao
#@-others
#@-node:carlo.20081219153110.7:<< Jogo do Adivinho >>
#@nl

def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    minhaAdivinhacao = Adivinhacao()
    minhaAdivinhacao.jogaOJogoDoAdivinho()
#@-node:carlo.20080914080659.3:@thin adivinho.py
#@-leo
