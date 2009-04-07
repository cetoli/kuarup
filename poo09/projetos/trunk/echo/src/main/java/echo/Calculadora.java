/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;
import labase.poo.ICalculadoraBase;

/**
 * @todo Calculadora coms tres botões
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version (1.0)    $Revision$ (31/03/09)      $Date$
 * @since   (versao) Descreva aqui as alterações desta versao
 */
public class Calculadora implements ICalculadoraBase {
  /**Acumulador da Caculadora. */
  private Valor acumulador = new Valor(0);
  /**Acumulador da ultimo valor. */
  private Valor atual = new Valor(0);
  /**Operador da Caculadora. */
  private Valor operador = new Valor(0);

  /**
   * Construtor para objetos da classe Calculadora.
   */
  public Calculadora() {
    // inicializa variaveis de instância
  }
  
   public void modoHex() {
       atual = new ValorHex(0);
    }
    
   public void modoBin() {
       atual = new ValorBin(0);
    }
    
   public void modoDec() {
       atual = new Valor(0);
    }
   
  /**
   * Entra a tecla um.
   *
   * @return  conteudo do operador
   */
  public final String entraUm() {
    //String valor = atual.converterEmString()+"1";
    atual.adicionarDigito("1");
    return atual.converterEmString();
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
