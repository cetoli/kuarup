/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;
import labase.poo.ICalculadora;

/**
 * Descri��o:
 * Calculadora que exerce somente as fun��es de soma, limpa e tecla 1
 *
 * Autores:
 * Carlos Henrique Pinto Rodriguez
 * Carlos Eduardo Ferr�o
 * 
 * Vers�o 1     Data 31/03/2009
 */
public class Calculadora implements ICalculadora {
  /**Acumulador da Caculadora. */
  private Integer acumulador = new Integer(0);
  private Integer acumuladorAux = new Integer(0);
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
      String aux = acumuladorAux.toString();
      if(aux.equals("0"))
        aux = "1";
      else
        aux += "1";
      acumuladorAux = Integer.parseInt(aux);
      return acumuladorAux.toString();
    //return operador.toString();
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
      acumulador = acumuladorAux = 0;
    return acumulador.toString();
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
      acumulador += acumuladorAux ;
      acumuladorAux = 0;
      return acumulador.toString();
  }
  
  public static void main(String [] args) {
      Calculadora c = new Calculadora();
      System.out.println(c.comandoSoma());
    }
}
