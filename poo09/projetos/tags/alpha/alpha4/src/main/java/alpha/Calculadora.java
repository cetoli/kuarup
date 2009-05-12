/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package alpha;
import labase.poo.ICalculadoraEngenharia;

/**
 * Esta é a classe principal da calculadora do time alpha.
 *
 * @author  Diego Mury Gomes de Lima  $Author$
 * @author  Leandro Oliveira Gomes  $Author$
 * @version 4.0    $Revision$ 3.0      $Date$ 11/05/09
 * @since   3.0 Calculadora com numeros complexos
 */
public class Calculadora implements ICalculadoraEngenharia {
    // Estado da Caculadora
    private int valorDecimal;
    private String valorString;
    private INumero operando;
    private INumero acumulador;
    private Composite adicionador;
    private Composite montador;
    private INumero display;
    private BaseStrategy base;
    /**
     * Construtor para objetos da classe Calculadora.
     */
    public Calculadora() {
        // inicializa variáveis de instância
        limpa();
    }
    /**
     * Entra a tecla um.
     * @return conteúdo do operando.
     */
    public String entraUm() {
        valorString = base.converterBase(valorDecimal) + "1";
        valorDecimal = base.toDecimal(valorString);
        adicionador.adicionaParteReal(valorDecimal, operando, montador);
        adicionador.adicionaParteImaginaria(valorDecimal, operando, montador);
        display = operando;
        return operando.mostra(base);
    }
    /**
     * Limpa o acumulador.
     * @return conteúdo do acumulador
     */
    public String limpa() {
        valorDecimal = 0;
        valorString = "";
        operando = new Complexo();
        acumulador = new Complexo();
        adicionador = new ParteRealComposite();
        montador = new MantissaComposite();
        adicionador.adicionaParteReal(0, operando, montador);
        adicionador.adicionaParteImaginaria(0, operando, montador);
        adicionador.adicionaParteReal(0, acumulador, montador);
        adicionador.adicionaParteImaginaria(0, acumulador, montador);
        display = new Complexo();
        adicionador.adicionaParteReal(0, display, montador);
        adicionador.adicionaParteImaginaria(0, display, montador);
        base = new BaseDecimalStrategy();
        return "0";
    }
    /**
     * Entra o comando soma.
     * @return conteúdo do acumulador
     */
    public String comandoSoma() {
        acumulador.soma(operando);
        String res = acumulador.mostra(base);
        display = acumulador;
        valorDecimal = 0;
        valorString = "";
        adicionador = new ParteRealComposite();
        montador = new MantissaComposite();
        operando = new Complexo();
        adicionador.adicionaParteReal(0, operando, montador);
        adicionador.adicionaParteImaginaria(0, operando, montador);
        return res;
    }
    /**
     * Opera na base hexadecimal.
     */
    public void modoHex() {
        base = new BaseHexadecimalStrategy();
    }
    /**
     * Opera na base binaria.
     */  
    public void modoBin() {
        base = new BaseBinariaStrategy();
    }
    /**
     * Opera na base decimal.
     */   
    public void modoDec() {
        base = new BaseDecimalStrategy();
    }
    /**
     * Entra a parte imaginária do número complexo.
     */
    public void entraI() {
        adicionador = new ParteImaginariaComposite();
        montador = new MantissaComposite();
        valorDecimal = 0;
        valorString = "";
        INumero exponencial = acumulador.getParteImaginaria().getParteExponencial();
        adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria().getValor(), acumulador, montador);
        acumulador.getParteImaginaria().adicionaParteExponencial(exponencial);
    }
    /**
     * Entra a parte exponencial do número.
     */
    public void entraN() {
        montador = new ParteExponencialComposite();
        valorDecimal = 0;
        valorString = "";
        adicionador.adicionaParteReal(acumulador.getParteReal().getParteExponencial().getValor(), acumulador, montador);
        adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria().getParteExponencial().getValor(), acumulador, montador);
    }
}
