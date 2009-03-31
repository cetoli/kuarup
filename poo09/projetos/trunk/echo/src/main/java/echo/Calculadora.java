/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;
import labase.poo.ICalculadora;

/**
 * @todo Calculadora coms tres botões
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version (1.0)    $Revision$ (31/03/09)      $Date$
 * @since   (versao) Descreva aqui as alterações desta versao
 */
public class Calculadora implements ICalculadora {
  /**Acumulador da Caculadora. */
  private Integer acumulador = new Integer(0);
  /**Acumulador da ultimo valor. */
  private Integer atual = new Integer(0);
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
    String valor = atual.toString()+"1";
    atual = new Integer(valor);
    return atual.toString();
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
    atual = new Integer(0);
    acumulador = new Integer(0);
    return acumulador.toString();
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
      acumulador+= atual;
      atual= new Integer (0);
    return acumulador.toString();
  }
}
