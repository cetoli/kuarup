/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package hotel;
import labase.poo.ICalculadoraComplexo;

/**
 * @todo Escreva a descricao da classe Calculadora aqui.
 *
 * @author  (Alexandre Louzada & Marcio Reis)  $Author$
 * @version (2.0)    $Revision$ (31/03/2009)      $Date$
 * @since   (versao) Soma 1 mais 1
 */
public class Calculadora implements ICalculadoraComplexo {  
  
  private BaseState baseDecimal;
  
  private BaseState baseBinaria;
  
  private BaseState baseHexadecimal;
  
  private BaseState baseAtual;
  
  /**
   * Construtor para objetos da classe Calculadora.
   */
  public Calculadora() {
    // inicializa variaveis de instância
    this.baseDecimal = new BaseDecimal();
    this.baseBinaria = new BaseBinaria();
    this.baseHexadecimal = new BaseHexadecimal();
    this.baseAtual = this.baseDecimal;
  }
  
  public void modoHex(){
	  this.baseHexadecimal.init(baseAtual);
	  this.baseAtual = this.baseHexadecimal;
  }

  public void modoBin(){
	  this.baseBinaria.init(baseAtual);
	  this.baseAtual = this.baseBinaria;
  }
  
  public void modoDec(){
	  this.baseDecimal.init(baseAtual);
	  this.baseAtual = this.baseDecimal;
  }
  
  /**
   * Entra a tecla um.
   *
   * @return  conteudo do operador
   */
  public final String entraUm() {
      return this.baseAtual.entraUm(this);
  }
  
  /**
   * Entra um numero complexo.
   *
   * @return  conteudo do operador
   */
  public final void entraI() {
	  this.baseAtual.setConverterStrategy(new ConverterImaginarioStrategy());
	  this.baseAtual.setEntraNumeroStrategy(new EntraNumeroComplexoStrategy());
  }

  /**
   * Limpa o acumulador.
   *
   * @return  conteudo do acumulador
   */
  public final String limpa() {
      return this.baseAtual.limpa(this);
  }

  /**
   * Entra o comando soma.
   *
   * @return  conteudo do acumulador
   */
  public final String comandoSoma() {
      return this.baseAtual.comandoSoma(this);
  }
}
