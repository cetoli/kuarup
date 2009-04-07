/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package india;
import labase.poo.ICalculadoraBase;

/**
 * @todo Escreva a descricao da classe Calculadora aqui.
 *
 * @author  (seu nome)  $Author$
 * @version (versao)    $Revision$ (data)      $Date$
 * @since   (versao) Descreva aqui as alteracoes desta versao
 */
public class Calculadora implements ICalculadoraBase {
  /**Acumulador da Caculadora. */
  private Integer acumulador = new Integer(0);
  /**Operador da Caculadora. */
  private Integer operador = new Integer(0);

  /**
   * Construtor para objetos da classe Calculadora.
   */
  public Calculadora() {
    // inicializa variaveis de inst�ncia
  }

  /**
   * Entra a tecla um.
   *
   * @return  conteudo do operador
   */
  public final String entraUm() {
    return operador.toString();
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
    return "0";
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
    return acumulador.toString();
  }
  /**
   * Ativa o modo Hexadecimal.
   */
  public final void modoHex() {
   }

  /**
   * Ativa o modo Binário.
   */
  public final void modoBin() {
  }

  /**
   * Ativa o modo Decimal.
   */
  public final void modoDec() {
  }

}
