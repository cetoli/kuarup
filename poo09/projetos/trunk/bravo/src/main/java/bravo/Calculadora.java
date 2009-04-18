/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package bravo;
import labase.poo.ICalculadoraComplexo;

/**
 * A classe calculadora realiza operações matemáticas com números inteiros.
 * @author  (Tiago Cruz de França) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (2.0) (12 de abril de 2009)
 * @since   (2.0) Esta versao trabalha nas bases decimal, hexadecimal e binária
 */
public class Calculadora implements ICalculadoraComplexo {

    /**
     * Acumulador da Caculadora.
     */
    private Numero acumulador = new Numero();
    
    private String teste = "aaaaa";
    /**
     * Acumulador da Caculadora.
     */
    private Numero acumuladorImaginario = new Numero();
    /**
     * Operador da Caculadora.
     */
    private Numero operador = new Numero();
    /**
     * Operador da Caculadora.
     */
    private Numero operadorImaginario = new Numero();
    /**
     * Conversor de base.
     */
    private StrategyBase base = new BaseDecimal();

    
    private ITipoNumeroState state = new TipoNumeroRealState();
    
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
     * @return conteudo do operador
     */
    public final String entraUm() {
        return state.entraUm(base, operador, operadorImaginario);
    }
    /**
     * Entra a tecla I.
     */
    public final void entraI() {
        state = new TipoNumeroImaginarioState();
    
    }   
    
    
    /**
     * Limpa o acumulador.
     * @return  conteudo do acumulador
     */
    public final String limpa() {
        this.operador = new Numero();
        this.operadorImaginario = new Numero();
        this.acumulador = new Numero();
        this.acumuladorImaginario = new Numero();
        return "0";
    }

    /**
     * Entra o comando soma.
     * @return  conteudo do acumulador
     */
    public final String comandoSoma() {
        String retorno = state.soma(base, operador, operadorImaginario, acumulador, acumuladorImaginario);
        operador = new Numero();
        operadorImaginario = new Numero();  
        state = new TipoNumeroRealState();
        return retorno;
    }
}