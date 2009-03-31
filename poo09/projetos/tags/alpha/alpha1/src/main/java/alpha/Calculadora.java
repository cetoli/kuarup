/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package alpha;
import labase.poo.ICalculadora;

/**
 * Esta é a classe principal da calculadora do time alpha
 *
 * @author  (Diego Mury Gomes de Lima)  $Author$
 * @author  (Carlos Felippe Cardoso de Resende)  $Author$
 * @version (1.0)    $Revision$ (1.0)      $Date$ 31/03/09
 * @since   (1.0) Calculadora com o operador "+", o número "1" e a tecla "limpa"
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
    String op = operador.toString() + "1";
    operador = Integer.parseInt(op);
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
      
      acumulador = new Integer(operador.intValue() + acumulador.intValue());
      operador = new Integer(0);
      
    return acumulador.toString();
  }
}
