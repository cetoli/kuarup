/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package bravo;

import labase.poo.ICalculadoraVetorial;

/**
 * A classe calculadora realiza operações matemáticas com números Imaginários.
 * 
 * @author (Marcio Reis Teixeira) O papagaio
 * @author (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) Esta versão trabalha com exponencial
 * @since (2.0) Esta versao trabalha nas bases decimal, hexadecimal e binária
 */
public class Calculadora implements ICalculadoraVetorial {

	private int opDecimal;

	private String opString;

	private Numero operando;

	private Numero acumulador;

	private Adicionador adicionador;

	private Adicionador montador;

	private Numero display;

	private StrategyBase base;

	/**
	 * Construtor para objetos da classe Calculadora Sempre inicializa como
	 * decimal
	 */
	public Calculadora() {
		limpa();
	}

	/**
	 * Entra a tecla um
	 * 
	 * @return conteúdo do operando.
	 */
	public String entraUm() {
		opString = base.converterBase(opDecimal) + "1";
		opDecimal = base.toDecimal(opString);
		adicionador.adicionaParteReal(opDecimal, operando, montador);
		adicionador.adicionaParteImaginaria(opDecimal, operando, montador);
		display = operando;
		return operando.mostra(base);
	}

	/**
	 * Limpa o acumulador
	 * 
	 * @return conteúdo do acumulador
	 */
	public String limpa() {
		opDecimal = 0;
		opString = "";
		operando = new Complexo();
		acumulador = new Complexo();
		adicionador = new ParteReal();
		montador = new Fixo();
		adicionador.adicionaParteReal(0, operando, montador);
		adicionador.adicionaParteImaginaria(0, operando, montador);
		adicionador.adicionaParteReal(0, acumulador, montador);
		adicionador.adicionaParteImaginaria(0, acumulador, montador);
		display = new Complexo();
		adicionador.adicionaParteReal(0, display, montador);
		adicionador.adicionaParteImaginaria(0, display, montador);
		base = new BaseDecimal();
		return "0";
	}

	/**
	 * Entra o comando soma.
	 * 
	 * @return conteúdo do acumulador
	 */
	public String comandoSoma() {
		acumulador.soma(operando);
		String res = acumulador.mostra(base);
		display = acumulador;
		opDecimal = 0;
		opString = "";
		adicionador = new ParteReal();
		montador = new Fixo();
		operando = new Complexo();
		adicionador.adicionaParteReal(0, operando, montador);
		adicionador.adicionaParteImaginaria(0, operando, montador);
		return res;
	}

	/**
	 * Entra a base hexadecimal.
	 */
	public void modoHex() {
		base = new BaseHexadecimal();
	}

	/**
	 * Entra a base binária.
	 */
	public void modoBin() {
		base = new BaseBinaria();
	}

	/**
	 * Entra a base decimal.
	 */
	public void modoDec() {
		base = new BaseDecimal();
	}

	/**
	 * Entra a parte imaginária do número complexo.
	 */
	public void entraI() {
		adicionador = new ParteImaginaria();
		montador = new Fixo();
		opDecimal = 0;
		opString = "";
		Numero exponencial = acumulador.getParteImaginaria()
				.getParteExponencial();
		adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria()
				.getValor(), acumulador, montador);
		acumulador.getParteImaginaria().adicionaParteExponencial(exponencial);
	}

	/**
	 * Entra a parte exponencial do número.
	 */
	public void entraN() {
		montador = new ParteExponencial();
		opDecimal = 0;
		opString = "";
		adicionador.adicionaParteReal(acumulador.getParteReal()
				.getParteExponencial().getValor(), acumulador, montador);
		adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria()
				.getParteExponencial().getValor(), acumulador, montador);
	}

	public String comandoSubtrai() {
		// TODO Auto-generated method stub
		return null;
	}

	public void entraV() {
		adicionador = new ParteReal();
		montador = new Fixo();
		opDecimal = 0;
		opString = "";
		Numero exponencial = acumulador.getParteImaginaria()
				.getParteExponencial();
		adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria()
				.getValor(), acumulador, montador);
		acumulador.getParteImaginaria().adicionaParteExponencial(exponencial);
	}
}