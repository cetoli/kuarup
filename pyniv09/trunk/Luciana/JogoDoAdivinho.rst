.. rst3: filename: JogoDoAdivinho.rst

.. footer:: LABASE - NCE

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

	1: print "Eu sou o advinho, você é o voluntário"

Regra do jogo
~~~~~~~~~~~~~

**code**:

.. code-block:: Python

	1: print "pense um número de 1 a 7"

Palpite
~~~~~~~

**code**:

.. code-block:: Python

	1: print "o meu palpite é 4"

