/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package bravo;
import labase.poo.ICalculadora;

/**
 * @A classe calculadora realiza opera��es matem�ticas com n�meros inteiros.
 * @author  (Tiago Cruz de Fran�a)  $Author$
 * @author  (Humberto Ferreira Ramos Junior)  $Author$
 * @version (1.0) $Revision$ (31 de mar�o de 2009) $Date$
 * @since   (1.0) Esta vers�o soma 1+1.
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
    // inicializa variaveis de inst�ncia
  }

  /**
   * Entra a tecla um.
   *
   * @return  conteudo do operador
   */
  public final String entraUm() {
    this.operador = this.operador * 10 + 1;
    return operador.toString();
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
    this.operador = 0;
    this.acumulador = 0;
    return "0";
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {    
    this.acumulador = this.acumulador + this.operador;
    this.operador = 0;    
    return acumulador.toString();
  }
}
