/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package charlie;
import labase.poo.ICalculadora;

/**
 * Esta eh a primeira versao da Calculadora. Nao possui nenhum design pattern ainda.
 *
 * @author  Andre Abrantes  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0    $Revision$ 31/03/2009      $Date$
 * @since   1.0   Esta versao soma um mais um
 */
public class Calculadora implements ICalculadora {
  /**Operador da Caculadora. */
  private Integer operador = new Integer(0);
  /**Acumulador da Caculadora. */
  private Integer acumulador = new Integer(0);

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
    operador = operador * 10 + 1;
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
      return operador.toString();
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
      acumulador += operador;
      operador = 0;
      return acumulador.toString();
  }
}
