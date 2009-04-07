/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package delta;
import labase.poo.ICalculadora;

/**
 * @todo Escreva a descricao da classe Calculadora aqui.
 *
 * @author  Thiago Silva de Souza  $Author$
 * @author  André Sion  $Author$
 * @version 1.1    $Revision$ (07/04/09)      $Date$
 * @since   1.1 Calculadora que soma um mais um
 */
public class Calculadora implements ICalculadora {
  /**Acumulador da Caculadora. */
  private Integer acumulador = new Integer(0);
  /**Operador da Caculadora. */
  private Integer operador = new Integer(0);

  /**
   * Construtor para objetos da classe Calculadora.
   */
  public Calculadora() {
    // inicializa variaveis de instância
  }

  /**
   * Entra a tecla um.
   *
   * @return  conteudo do operador
   */
  public final String entraUm() {
    operador = (operador * 10) + 1;
    return operador.toString();
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
    acumulador = 0;
    operador = 0;
    return "0";
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
    acumulador = acumulador + operador;
    operador = 0;
    return acumulador.toString();
  }
}
