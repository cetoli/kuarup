<?xml version="1.0" encoding="utf-8"?>
<?xml-stylesheet ekr_test?>
<leo_file>
<leo_header file_format="2" tnodes="0" max_tnode_index="0" clone_windows="0"/>
<globals body_outline_ratio="0.658450704225">
	<global_window_position top="25" left="0" height="852" width="1280"/>
	<global_log_window_position top="0" left="0" height="0" width="0"/>
</globals>
<preferences/>
<find_panel_settings/>
<vnodes>
<v t="carlo.20080914080659.1" str_leo_pos="2,1,6"><vh>@chapters</vh></v>
<v t="carlo.20080914080659.10" a="E"><vh>@rst JogoDoAdivinho.rst</vh>
<v t="carlo.20080914080659.14" a="E"><vh>@rst-no-head Jogo do Adivinho</vh>
<v t="carlo.20080914080659.16"><vh>@rst-no-head Autor</vh></v>
<v t="carlo.20080914080659.15"><vh>Introdução</vh></v>
<v t="carlo.20080914080659.23"><vh>O Jogo do Adivinho</vh></v>
<v t="carlo.20090104111700.3"><vh>Descrição do Jogo</vh></v>
<v t="aluno.20090211133037.8" a="E"><vh>Definições  do Jogo</vh>
<v t="aluno.20090211133037.9"><vh>@rst-code</vh></v>
<v t="aluno.20090211133037.7"><vh>Glossario</vh></v>
<v t="carlo.20090104111700.4"><vh>Participantes</vh></v>
</v>
<v t="carlo.20081219153110.6" a="E"><vh>Código do Jogo</vh>
<v t="carlo.20080914080659.24" a="E"><vh>@rst-code</vh>
<v t="carlo.20090104111700.5"><vh>Regra do jogo</vh></v>
<v t="carlo.20090104111700.7"><vh>Palpite</vh></v>
<v t="aluno.20090211133037.10"><vh>Tenta vários palpites</vh></v>
<v t="aluno.20090211133037.3"><vh>Escuta o voluntário</vh></v>
<v t="aluno.20090211133037.11"><vh>Muda Palpite</vh></v>
<v t="aluno.20090211133037.4"><vh>Pense e ve se acertou</vh></v>
<v t="aluno.20090211133037.6"><vh>Joga o jogo do adivinho</vh></v>
</v>
</v>
</v>
</v>
<v t="carlo.20080914080659.3" a="E"
expanded="carlo.20081219153110.7,"><vh>@thin adivinho.py</vh></v>
</vnodes>
<tnodes>
<t tx="aluno.20090211133037.3">def escuta_o_voluntario():
    global resposta_do_voluntario
    resposta_do_voluntario = raw_input("diga")
    return "você disse: " + resposta_do_voluntario</t>
<t tx="aluno.20090211133037.4">def pense_e_ve_se_acertou():
    global nao_acertou
    if resposta_do_voluntario == "a" :
        nao_acertou = False
        print "acertei" 
    else:
        muda_palpite()

</t>
<t tx="aluno.20090211133037.6">def joga_o_jogo_do_adivinho():
        print apresenta_os_participantes()
        print diz_a_regra_do_jogo()
        tenta_varios_palpites()
</t>
<t tx="aluno.20090211133037.7">resposta_do_voluntario = " "
palpite = 1
nao_acertou = True</t>
<t tx="aluno.20090211133037.8"></t>
<t tx="aluno.20090211133037.9"></t>
<t tx="aluno.20090211133037.10">def tenta_varios_palpites():
    while nao_acertou:
        print diz_o_palpite()
        print escuta_o_voluntario()
        pense_e_ve_se_acertou()

</t>
<t tx="aluno.20090211133037.11">def muda_palpite():
    global palpite
    palpite = palpite + 1</t>
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

:Author: *Angela*
:Contact: amanume@gmail.com
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

* o diálogo prossegue até que o advinho acerte o palpite - Diálogo
</t>
<t tx="carlo.20090104111700.4">def apresenta_os_participantes():
    return "Eu sou o advinho, você é o voluntário"</t>
<t tx="carlo.20090104111700.5">def diz_a_regra_do_jogo():
    return "pense um número de 1 a 7", "diga a se acertei, s para eu subir, d para descer"</t>
<t tx="carlo.20090104111700.7">def diz_o_palpite():
    return "o meu palpite é " + str (palpite)</t>
</tnodes>
</leo_file>
