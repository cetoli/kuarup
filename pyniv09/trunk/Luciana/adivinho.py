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

:Author: *Luciana Daflon*
:Contact: daflonbotelho@gmail.com
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
#@+node:aluno.20090211132912.6:A Classe Adivinhacao
class Adivinhacao:
    #@    @+others
    #@+node:aluno.20090211132912.3:Glossario
    reposta_do_voluntario=""
    palpite = 1
    nao_acertou = True
    #@nonl
    #@-node:aluno.20090211132912.3:Glossario
    #@+node:carlo.20090104111700.4:Participantes
    def apresenta_os_participantes(self): 
        return    "Eu sou advinho, você é o voluntário"
    #@nonl
    #@-node:carlo.20090104111700.4:Participantes
    #@+node:carlo.20090104111700.5:Regra do jogo
    def diz_a_regra_do_jogo(self):
        return "pense um número de 1 a 7"
        return "diga a se acertei o palpite,s para eu subir o palpite,d para descer o palpite"
    #@nonl
    #@-node:carlo.20090104111700.5:Regra do jogo
    #@+node:carlo.20090104111700.7:Palpite
    def diz_o_palpite(self):
        return "o meu palpite é " +str(self.palpite)
    #@nonl
    #@-node:carlo.20090104111700.7:Palpite
    #@+node:aluno.20090211132912.5:Tenta varios Palpites
    def tenta_varios_palpites(self):
        while self.  nao_acertou:
            print self.diz_o_palpite()
            print self.escuta_o_voluntario()
            self.pensa_e_ve_se_acertou()
    #@nonl
    #@-node:aluno.20090211132912.5:Tenta varios Palpites
    #@+node:aluno.20090206161548.5:Escuta a resposta
    def escuta_o_voluntario(self):
        self.resposta_do_voluntario=raw_input("diga") 
        return "você disse: "+ self.resposta_do_voluntario
    #@-node:aluno.20090206161548.5:Escuta a resposta
    #@+node:aluno.20090206161548.7:Pensa e ve se acertou
    def pensa_e_ve_se_acertou(self):
        if self.resposta_do_voluntario == "a" :
            self.nao_acertou = False
            print "acertei!Sou demais!!"
        else:
            self.muda_palpite()
    #@nonl
    #@-node:aluno.20090206161548.7:Pensa e ve se acertou
    #@+node:aluno.20090211132912.4:Muda Palpite
    def muda_palpite(self):
        self.palpite = palpite + 1
    #@nonl
    #@-node:aluno.20090211132912.4:Muda Palpite
    #@+node:aluno.20090211132912.2:joga o jogo do adivinho
    def joga_o_jogo_do_adivinho(self):
        print self.apresenta_os_participantes()
        print self.diz_a_regra_do_jogo()
        self.tenta_varios_palpites() 

    #@-node:aluno.20090211132912.2:joga o jogo do adivinho
    #@-others
#@nonl
#@-node:aluno.20090211132912.6:A Classe Adivinhacao
#@-others
#@-node:carlo.20081219153110.7:<< Jogo do Adivinho >>
#@nl

def _test():
    import doctest
    doctest.testmod()

if __name__ == "__main__":
    minha_adivinhacao = AdivinhaArvore()
    minha_adivinhacao.joga_o_jogo_do_adivinho()
#@-node:carlo.20080914080659.3:@thin adivinho.py
#@-leo
