/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package golf;
import labase.poo.ICalculadoraBase;

/**
 * @Class Calculadora - equipe Golf.
 *
 * @author  Guga  
 * @author  Leandro  
 * @version 1.0  31/03
 * @since   0.0 Descreva aqui as alterações desta versao
 */
public class Calculadora implements ICalculadoraBase {
  /**Acumulador da Caculadora. */
  private AbstractNumero acumulador;
  /**Operador da Caculadora. */
  private AbstractNumero operador;
  /**Base da calculadora. */
  private final Integer base = 10;

  /**
   * Construtor para objetos da classe Calculadora.
   */
  public Calculadora() {
    this.modoDec();
  }

  /**
   * Entra a tecla um.
   *
   * @return  conteudo do operador
   */
  public final String entraUm() {
    operador.setValor(operador.getValor() * operador.getBase() + 1);
    return operador.converte();
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
    operador.setValor(0);
    acumulador.setValor(0);
    return "0";
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
    acumulador.setValor(acumulador.getValor() + operador.getValor());
    operador.setValor(0);
    return acumulador.converte();
  }

  /**
   * Muda a base da calculadora para Hexadecimal.
   *
   */
  public final void modoHex() {
      acumulador = new NumeroHex(0);
      operador = new NumeroHex(0);
  }

  /**
   * Muda a base da calculadora para Binario.
   *
   */
  public final void modoBin() {
      acumulador = new NumeroBin(0);
      operador = new NumeroBin(0);
  }

  /**
   * Muda a base da calculadora para Decimal.
   *
   */
  public final void modoDec() {
      acumulador = new NumeroDec(0);
      operador = new NumeroDec(0);
  }
}
