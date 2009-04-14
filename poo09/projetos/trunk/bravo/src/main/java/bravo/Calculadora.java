/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package bravo;
import labase.poo.ICalculadoraBase;

/**
 * A classe calculadora realiza operações matemáticas com números inteiros.
 * @author  (Tiago Cruz de França) - O papagaio
 * @author  (Humberto Ferreira Ramos Junior) - O pirata
 * @version (2.0) (12 de abril de 2009)
 * @since   (2.0) Esta versao trabalha nas bases decimal, hexadecimal e binária.
 */
public class Calculadora implements ICalculadoraBase {

    /**
     * Acumulador da Caculadora.
     */
    private Integer acumulador = new Integer(0);

    /**
     * Operador da Caculadora.
     */
    private Integer operador = new Integer(0);

    /**
     * Conversor de base.
     */
    private StrategyBase base = new BaseDecimal();

    /**
     * Construtor para objetos da classe Calculadora.
     */
    public Calculadora() {
    }

    /**
     * Metodo utilizado para indicar operacoes na base Hexadecimal.
     */
    public void modoHex() {
        base = new BaseHexadecimal();
    }

    /**
     * Metodo utilizado para indicar operacoes na base Binaria.
     */
    public void modoBin() {
        base = new BaseBinaria();
    }

    /**
     * Metodo utilizado para indicar operacoes na base Decimal.
     */
    public void modoDec() {
        base = new BaseDecimal();
    }

    /**
     * Entra a tecla um.
     *
     * @return conteudo do operador
     */
    public final String entraUm() {
        this.operador = base.entraUm(this.operador);
        return base.converterBase(this.operador);
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
        return base.converterBase(acumulador);
    }
}