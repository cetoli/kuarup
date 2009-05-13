/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;

import golf.impressao.ImpressaoBinarioStrategy;
import golf.impressao.ImpressaoDecimalStrategy;
import golf.impressao.ImpressaoHexadecimalStrategy;
import golf.impressao.ImpressaoPadraoStrategy;
import golf.impressao.ImpressaoStrategy;
import labase.poo.ICalculadoraEngenharia;

/**
 * Calculadora com tres botoes.
 * 
 * @author (Marcos de Castro) $Author$
 * @author (Rodrigo Santos Borges) $Author$
 * @version (2.0) $Revision$ (07/04/09) $Date$
 * @since (2.0) Botoes para entrar valores em binario, hexadecimal e decimal
 */
public class Calculadora implements ICalculadoraEngenharia {
	/**
	 * Acumulador da Caculadora.
	 */

	private ValorBase acumulador = new Valor(0);

	/**
	 * Acumulador da ultimo valor.
	 */
	private ValorBase atual = new Valor(0);

	private ImpressaoStrategy proximoModoEntrada;
	private ImpressaoStrategy proximoModoImpressao;

	/**
	 * Construtor para objetos da classe Calculadora.
	 */
	public Calculadora() {
		proximoModoEntrada = new ImpressaoPadraoStrategy();
		proximoModoImpressao = new ImpressaoPadraoStrategy();
	}

	/**
	 * Modo Complexo.
	 */
	public void entraI() {
		atual = atual.instanciarComplexo();
	}

	/**
	 * Modo Engenharia.
	 */
	public void entraN() {
		proximoModoImpressao = new ImpressaoPadraoStrategy();

		atual = atual.instanciarEngenharia();
	}

	/**
	 * Botao para entrada de valores em hexadecimal.
	 */
	public void modoHex() {
		proximoModoEntrada = new ImpressaoHexadecimalStrategy();
		proximoModoImpressao = new ImpressaoHexadecimalStrategy();

		// atual = atual.modoHexa();
		atual.impressaoHexa();
	}

	/**
	 * Botao para entrada de valores em binario.
	 */
	public void modoBin() {
		proximoModoEntrada = new ImpressaoBinarioStrategy();
		proximoModoImpressao = new ImpressaoBinarioStrategy();
		// atual = atual.modoBin();
		atual.impressaoBin();
	}

	/**
	 * Botao para entrada de valores em decimal.
	 */
	public void modoDec() {
		proximoModoEntrada = new ImpressaoDecimalStrategy();
		proximoModoImpressao = new ImpressaoDecimalStrategy();
		atual = atual.modoDec();
		atual.impressaoDec();
	}

	/**
	 * Entra a tecla um.
	 * 
	 * @return conteudo do operador
	 */
	public final String entraUm() {
		return atual.adicionarDigito("1", proximoModoEntrada,
				proximoModoImpressao);
	}

	/**
	 * Limpa o acumulador.
	 * 
	 * @return conteudo do acumulador
	 */
	public final String limpa() {
		atual.limparValor();
		return acumulador.limparValor();
	}

	/**
	 * Entra o comando soma.
	 * 
	 * @return conteudo do acumulador
	 */
	public final String comandoSoma() {
		acumulador = acumulador.somar(atual);

		atual.limparValor();

		atual = new Valor();
		atual.impressao = acumulador.getModoImpressao();

		return acumulador.converterEmString();
	}

}
