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
  /**Visor da Caculadora. */
  private Integer visor = new Integer(0);
  /**Memoria da Caculadora. */
  private Integer memoria = new Integer(0);

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
    visor = visor * 10 + 1;
    return visor.toString();
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
      memoria = 0;
      visor = 0;
      return visor.toString();
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
      memoria += visor;
      visor = 0;
      return memoria.toString();
  }
}
