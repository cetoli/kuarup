<?xml version="1.0" encoding="utf-8"?>
<?xml-stylesheet ekr_test?>
<leo_file>
<leo_header file_format="2" tnodes="0" max_tnode_index="0" clone_windows="0"/>
<globals body_outline_ratio="0.5">
	<global_window_position top="36" left="10" height="645" width="935"/>
	<global_log_window_position top="0" left="0" height="0" width="0"/>
</globals>
<preferences/>
<find_panel_settings/>
<vnodes>
<v t="carlo.20080914080659.1" str_leo_pos="1,0,4,0,3"><vh>@chapters</vh></v>
<v t="carlo.20080914080659.10" a="E"><vh>@rst JogoDoAdivinho.rst</vh>
<v t="carlo.20080914080659.14" a="E"><vh>@rst-no-head Jogo do Adivinho</vh>
<v t="carlo.20080914080659.16"><vh>@rst-no-head Autor</vh></v>
<v t="carlo.20080914080659.15"><vh>Introdução</vh></v>
<v t="carlo.20080914080659.23"><vh>O Jogo do Adivinho</vh></v>
<v t="carlo.20090104111700.3"><vh>Descrição do Jogo</vh></v>
<v t="carlo.20081219153110.6" a="E"><vh>Código do Jogo</vh>
<v t="carlo.20080914080659.24" a="E"><vh>@rst-code</vh>
<v t="carlo.20090104111700.4"><vh>Participantes</vh></v>
<v t="carlo.20090104111700.5"><vh>Regra do jogo</vh></v>
<v t="carlo.20090104111700.7"><vh>Palpite</vh></v>
<v t="aluno.20090206161713.2"><vh>Escuta o voluntario</vh></v>
<v t="aluno.20090206161713.3"><vh>Pensa e ve se acertou</vh></v>
</v>
</v>
</v>
</v>
<v t="carlo.20080914080659.3" a="E"
expanded="carlo.20081219153110.7,"><vh>@thin adivinho.py</vh></v>
</vnodes>
<tnodes>
<t tx="aluno.20090206161713.2">respostaVoluntario = raw_input("diga!")
print "Voce disse:" + respostaVoluntario
</t>
<t tx="aluno.20090206161713.3">if respostaVoluntario =="a" : print "acertei!"</t>
<t tx="carlo.20080914080659.1"></t>
<t tx="carlo.20080914080659.10">@ @rst-options
@c
</t>
<t tx="carlo.20080914080659.14">
.. footer:: LABASE - NCE
</t>
<t tx="carlo.20080914080659.15">Programando Jogos
~~~~~~~~~~~~~~~~~

* Descrever em texto o que se quer
* Programar para que outros leiam
* Desenvolver em versões incrementais
* Testar o que se quer programar</t>
<t tx="carlo.20080914080659.16">##################
O Jogo do Adivinho
##################

:Author: *Seu nome Aqui*
:Contact: seu email
:Date: $Date: 2009/02/06  $
:Status: This is a "work in progress"
:Revision: $Revision: 1.00 $
:Home: `LABASE &lt;http://labase.nce.ufrj.br/&gt;`__
:Copyright: ©2009, `GPL &lt;http://is.gd/3Udt&gt;`__
</t>
<t tx="carlo.20080914080659.23">
* Observe uma partida de advinha
 
* Escreva um slide documentando o jogo que advinha
 
* Inicie criando o jogo mais rudimentar - um palpite

* Escreva um teste para saber se o jogo funciona
</t>
<t tx="carlo.20080914080659.24"></t>
<t tx="carlo.20081219153110.6"></t>
<t tx="carlo.20090104111700.3">* o jogo tem um advinho e um voluntário - Participantes

* o advinho pede que se pense um número de 1 a 7 - Regra

* o voluntário pensa em um número - Início

* o advinho dá um palpite - Palpite

* o voluntário diz se o número é maior ou menor que o palpite - Dica

* o diálogo prossegue até que o advinho acerte o palpite - Diálogo</t>
<t tx="carlo.20090104111700.4">print "Eu sou o advinho, você é o voluntário"</t>
<t tx="carlo.20090104111700.5">print "pense um número de 1 a 7"</t>
<t tx="carlo.20090104111700.7">print "o meu palpite é 4"
print "diga a se acertei, s para eu subir, d para descer o palpite"</t>
</tnodes>
</leo_file>
