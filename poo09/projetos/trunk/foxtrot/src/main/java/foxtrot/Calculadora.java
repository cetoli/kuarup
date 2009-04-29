/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

import labase.poo.ICalculadoraComplexo;

/**
 * Calculadora com tres botoes.
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version (2.0)    $Revision$ (07/04/09)      $Date$
 * @since   (2.0) Botoes para entrar valores em binario, hexadecimal e decimal
 */
public class Calculadora implements ICalculadoraComplexo {
  /**
   * Acumulador da Caculadora.
   */

  private Valor acumulador = new Valor(0);

  /**
   * Acumulador da ultimo valor.
   */
  private Valor atual = new Valor(0);

  /* *Operador da Caculadora. */
  // private Valor operador = new Valor(0);
  /**
   * Construtor para objetos da classe Calculadora.
   */
  public Calculadora() {

  }

  /**
   * Modo Complexo.
   */
  public void entraI () {
	  acumulador.somarTudo(atual);

	  //Valor ac= (Valor)atual.clone();
	  //atual.setValor("0");
	  atual.limparValor();

      atual = atual.instanciarComplexo();
      acumulador = acumulador.instanciarComplexo();
  }

  /**
   * Botao para entrada de valores em hexadecimal.
   */
  public void modoHex() {
    atual = atual.modoHexa();
    acumulador = acumulador.modoHexa();
  }

  /**
   * Botao para entrada de valores em binario.
   */
  public void modoBin() {
    atual = atual.modoBin();
    acumulador = acumulador.modoBin();
  }

  /**
   * Botao para entrada de valores em decimal.
   */
  public void modoDec() {
    atual = atual.modoDec();
    acumulador = acumulador.modoDec();
  }

  /**
   * Entra a tecla um.
   *
   * @return  conteudo do operador
   */
  public final String entraUm() {
    //String valor = atual.converterEmString()+"1";
    return atual.adicionarDigito("1");
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
    atual.limparValor();
    return acumulador.limparValor();
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
	    acumulador.somar(atual);

	    atual.limparValor();

	    acumulador.modoInteiro();
	    atual.modoInteiro();

	    return acumulador.converterEmString();
	  }

}
