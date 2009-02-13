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

:Author: *Samantha*
:Contact: svrabl@gmail.com
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
#@+node:aluno.20090211133038.8:A classe Adivinhacao
class Adivinhacao:
    #@    @+others
    #@+node:aluno.20090211133038.3:Glossario
    resposta_do_voluntario = ""
    palpite = 1
    nao_acertou = True
    #@nonl
    #@-node:aluno.20090211133038.3:Glossario
    #@+node:carlo.20090104111700.4:Participantes
    def apresenta_os_participantes(self):
        return "Eu sou o advinho, você é o voluntário"
    #@nonl
    #@-node:carlo.20090104111700.4:Participantes
    #@+node:carlo.20090104111700.5:Regra do jogo
    def diz_a_regra_do_jogo(self):
        return "Pense um número de 1 a 7"
        return "Diga a se devo aumentar o valor do palpite, d para diminuir e ok, se o palpite estiver correto" 
    #@nonl
    #@-node:carlo.20090104111700.5:Regra do jogo
    #@+node:carlo.20090104111700.7:Palpite
    def diz_o_palpite(self):
        return "o meu palpite é " + str(self.palpite)

    #@-node:carlo.20090104111700.7:Palpite
    #@+node:aluno.20090211133038.7:Tenta varios palpites
    def tenta_varios_palpites(self):
        while self.nao_acertou:
            print self.diz_o_palpite()
            print self.escuta_o_voluntario()
            self.pensa_e_ve_se_acertou()

    #@-node:aluno.20090211133038.7:Tenta varios palpites
    #@+node:aluno.20090206161612.4:Escuta o voluntario
    def escuta_o_voluntario(self):
        self.resposta_do_voluntario = raw_input("diga!")
        return "você disse: " + self.resposta_do_voluntario
    #@nonl
    #@-node:aluno.20090206161612.4:Escuta o voluntario
    #@+node:aluno.20090206161612.5:Pensa e ve se acertou
    def pensa_e_ve_se_acertou(self):
        if self.resposta_do_voluntario=="a" :
            self.nao_acertou = False 
            return "acertei! Sou demais!"
        else:
            self.muda_palpite()

    #@-node:aluno.20090206161612.5:Pensa e ve se acertou
    #@+node:aluno.20090211133038.6:Muda palpite
    def muda_palpite(self):
        self.palpite = self.palpite+1
    #@nonl
    #@-node:aluno.20090211133038.6:Muda palpite
    #@+node:aluno.20090211133038.2:Joga o jogo do adivinho
    def joga_o_jogo_do_adivinho(self):
        self.apresenta_os_participantes()
        self.diz_a_regra_do_jogo()
        self.tenta_varios_palpites()

    #@-node:aluno.20090211133038.2:Joga o jogo do adivinho
    #@-others
    # others - tudo que está pendurado na classe Adivinhacao coloca debaixo da classe. #
    # é uma notaçao do leo#
#@nonl
#@-node:aluno.20090211133038.8:A classe Adivinhacao
#@-others
#@-node:carlo.20081219153110.7:<< Jogo do Adivinho >>
#@nl

def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    minha_adivinhacao = Adivinhacao() #chama o fabricador da maquina de van neuman
    minha_adivinhacao.joga_o_jogo_do_adivinho()
#@-node:carlo.20080914080659.3:@thin adivinho.py
#@-leo
