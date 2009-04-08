/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;
import labase.poo.ICalculadoraBase;

/**
 * Descrição:
 * Calculadora que exerce somente as funções de soma, limpa e tecla 1
 *
 * Autores:
 * Carlos Henrique Pinto Rodriguez
 * Carlos Eduardo Ferrão
 * 
 * Versão 2     Data 07/04/2009
 */
public class Calculadora implements ICalculadoraBase {
  /**Acumulador da Caculadora. */
  private Integer acumulador = new Integer(0);
  /**Operador da Caculadora. */
  private Integer operador = new Integer(0);
  /**Estado da Calculadora (Binário, Hexadecimal ou Decimal) */
  private State estado = new Decimal();

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
      return estado.entraUm(this);
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
      return estado.limpa(this);
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
      return estado.comandoSoma(this);
  }
  
  public void modoBin() {
      estado = new Binario();
  }
  
  public void modoDec() {
      estado = new Decimal();
  }

  public void modoHex() {
      estado = new Hexadecimal();
  }
  
  public Integer getAcumulador() {
      return acumulador;
  }

  public Integer getOperador() {
      return operador;
  }
  
  public void setOperador(Integer operador) {
      this.operador = operador;
  }
  
  public void setAcumulador(Integer acumulador) {
      this.acumulador = acumulador;
  }
  
  public static void main(String [] args) {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoBin();
		calculad1.entraUm();
		System.out.println(calculad1.comandoSoma());
		System.out.println(calculad1.entraUm());
		System.out.println(calculad1.comandoSoma());
    }
}
