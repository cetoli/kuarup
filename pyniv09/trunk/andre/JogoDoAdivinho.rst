.. rst3: filename: JogoDoAdivinho.rst

.. footer:: LABASE - NCE

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

Código do Jogo
**************

Participantes
~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def apresenta_participantes(self):
	2:     return "\nEu sou o Jogo do Advinho, você é o voluntário! \n"

Regra do jogo
~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def diz_a_regra_do_jogo(self):    
	2:     return "Pense um número de 1 a 100 \n" "Diga a se acertei, s para eu subir o palpite e d para eu descer o palpite."

Palpite
~~~~~~~

**code**:

.. code-block:: Python

	1: def da_um_palpite(self):
	2:     #import random
	3:     #global palpite
	4: 
	5:     #palpite = random.randint(1,7)
	6:     return "\nEu acho que você pensou no número " + str(self.palpite)

Resposta do Voluntário
~~~~~~~~~~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def obtem_resposta_voluntario(self):
	2:     #global resposta 
	3:     self.resposta = raw_input ("Resultado do palpite:")
	4:     return "Você disse: " + self.resposta

Pense pra ver se acertou
~~~~~~~~~~~~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: def analisa_resposta(self):
	2:     #global nao_acertou
	3:     if (self.resposta == 'a'):
	4:         self.nao_acertou = False
	5:         return ("Acertei sua resposta!");
	6:     elif (self.resposta == 's'):
	7:         self.muda_palpite_pracima()
	8:         return ("Deverei subir o meu palpite!");
	9:     elif (self.resposta == 'd'):
	10:         self.muda_palpite_prabaixo()
	11:         return ("Deverei descer o palpite");
	12:     else:
	13:         return "Comando não reconhecido"

