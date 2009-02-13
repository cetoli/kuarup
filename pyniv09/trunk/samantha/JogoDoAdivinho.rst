.. rst3: filename: JogoDoAdivinho.rst

.. footer:: LABASE - NCE

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

Introdução
**********

Programando Jogos
~~~~~~~~~~~~~~~~~

* Descrever em texto o que se quer
* Programar para que outros leiam
* Desenvolver em versões incrementais
* Testar o que se quer programar

O Jogo do Adivinho
******************

* Observe uma partida de advinha
 
* Escreva um slide documentando o jogo que advinha
 
* Inicie criando o jogo mais rudimentar - um palpite

* Escreva um teste para saber se o jogo funciona

Descrição do Jogo
*****************

* o jogo tem um advinho e um voluntário - Participantes

* o advinho pede que se pense um número de 1 a 7 - Regra

* o voluntário pensa em um número - Início

* o advinho dá um palpite - Palpite

* o voluntário diz se o número é maior ou menor que o palpite - Dica

* o diálogo prossegue até que o advinho acerte o palpite - Diálogo

Glossario
^^^^^^^^^

resposta_do_voluntario = ""
palpite = 1
nao_acertou = True

Código do Jogo
**************

Participantes
~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def apresenta_os_participantes(self):
	2:     return "Eu sou o advinho, você é o voluntário"

Regra do jogo
~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def diz_a_regra_do_jogo(self):
	2:     return "Pense um número de 1 a 7"
	3:     return "Diga a se devo aumentar o valor do palpite, d para diminuir e ok, se o palpite estiver correto"

Palpite
~~~~~~~

**code**:

.. code-block:: Python

	1: def diz_o_palpite(self):
	2:     return "o meu palpite é " + str(self.palpite)

Tenta varios palpites
~~~~~~~~~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def tenta_varios_palpites(self):
	2:     while self.nao_acertou:
	3:         print self.diz_o_palpite()
	4:         print self.escuta_o_voluntario()
	5:         self.pensa_e_ve_se_acertou()

Escuta o voluntario
~~~~~~~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def escuta_o_voluntario(self):
	2:     self.resposta_do_voluntario = raw_input("diga!")
	3:     return "você disse: " + self.resposta_do_voluntario

Pensa e ve se acertou
~~~~~~~~~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def pensa_e_ve_se_acertou(self):
	2:     if self.resposta_do_voluntario=="ok" :
	3:         self.nao_acertou = False 
	4:         return "acertei! Sou demais!"
	5:     else:
	6:         self.muda_palpite()

Muda palpite
~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def muda_palpite(self):
	2:     self.palpite = self.palpite+1

Joga o jogo do adivinho
~~~~~~~~~~~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def joga_o_jogo_do_adivinho(self):
	2:     self.apresenta_os_participantes()
	3:     self.diz_a_regra_do_jogo()
	4:     self.tenta_varios_palpites()

