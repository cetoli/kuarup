/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package alpha;
import labase.poo.ICalculadoraBase;

/**
 * Esta é a classe principal da calculadora do time alpha.
 *
 * @author  Diego Mury Gomes de Lima  $Author$
 * @author  Carlos Felippe Cardoso de Resende  $Author$
 * @version 2.0    $Revision$ 2.0      $Date$ 07/04/09
 * @since   1.0 Calculadora com o operador "+", o número "1" e a tecla "limpa"
 */
public class Calculadora implements ICalculadoraBase {
    
    /**Acumulador da Caculadora. */
    private INumero acumulador = new NumeroDecimal();
    
    /**Operador da Caculadora. */
    private INumero operador = new NumeroDecimal();

    /**
     * Construtor para objetos da classe Calculadora.
     */
    public Calculadora() {
    // inicializa variaveis de instância
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
     * Entra a tecla um.
     *
     * @return  conteudo do operador
     */
    public final String entraUm() {
        operador.entraUm();
        return operador.mostraNumeroNaMinhaRepresentacaoBase();
    }

    /**
     * Entra o comando soma.
     *
     *@return  conteudo do acumulador
     */
    public final String comandoSoma() {
      
        Integer temp = operador.converteEmNumeroDecimal().intValue() + 
                acumulador.converteEmNumeroDecimal().intValue();
        acumulador = operador.converterParaBase(temp);
        operador.zeraRepresentacaoNumerica();
        return acumulador.mostraNumeroNaMinhaRepresentacaoBase();
    }
    
    /**
     * * Opera em modo hexadecimal.
     */
    public final void modoHex() {
        operador = new NumeroHexadecimal();
   
      //return acumulador.toString();
    }
    
    /**
     * Opera em modo binario.
     */
    public final void modoBin() {
        operador = new NumeroBinario();
   
      //return acumulador.toString();
    }
    
    /**
     * Opera em modo decimal.
     */
    public final void modoDec() {
        operador = new NumeroDecimal();
   
      //return acumulador.toString();
    }
}