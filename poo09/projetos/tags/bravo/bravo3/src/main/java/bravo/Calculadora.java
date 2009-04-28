/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package bravo;
import labase.poo.ICalculadoraComplexo;

/**
 * A classe calculadora realiza operações matemáticas com números Imaginários.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (27 de abril de 2009) 
 * Esta versão trabalha com os numeros Imaginarios
 * @since   (2.0) Esta versao trabalha nas bases decimal, hexadecimal e binária
 */
public class Calculadora implements ICalculadoraComplexo {

    /**
     * Acumulador da Caculadora.
     */
    private Numero acumulador = new Numero();
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
    /**Declaracao do atributo do estado da impressao do resultado. */
    private IExibicaoValorState exibeValorState = new ExibicaoNumeroRealState();
    /**Declaracao do atributo do estado de operacao a ser executada. */
    private ITipoNumeroState tipoNumeroState = new TipoNumeroRealState();
    
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
        return tipoNumeroState.entraUm(base, operador, operadorImaginario);
    }
    /**
     * Entra a tecla I.
     */
    public final void entraI() {
        tipoNumeroState = new TipoNumeroImaginarioState();
        exibeValorState = new ExibicaoNumeroImaginarioState();
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
        this.exibeValorState = new ExibicaoNumeroRealState();
        return "0";
    }

    /**
     * Entra o comando soma.
     * @return  conteudo do acumulador
     */
    public final String comandoSoma() {
        tipoNumeroState.soma(base, operador, operadorImaginario, 
            acumulador, acumuladorImaginario);
        String retorno = exibeValorState.retornaValor(acumulador, 
            acumuladorImaginario, base);   
        operador = new Numero();
        operadorImaginario = new Numero();  
        tipoNumeroState = new TipoNumeroRealState();
        return retorno;
    }
}