/*------------------------------------------------------------------------------
    Copyright  2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package bravo;
import labase.poo.ICalculadoraEngenharia;

/**
 * A classe calculadora realiza opera��es matem�ticas com n�meros Imagin�rios.
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta vers�o trabalha com exponencial
 * @since   (2.0) Esta versao trabalha nas bases decimal, hexadecimal e bin�ria
 */
public class Calculadora implements ICalculadoraEngenharia{

    // Estado da Caculadora
    private int opDecimal;
    private String opString;
    private Numero operando;
    private Numero acumulador;
    private Adicionador adicionador;
    private Adicionador montador;
    private Numero display;
    private StrategyBase base;
  
    /**
     * Construtor para objetos da classe Calculadora
     * Sempre inicializa como decimal
     */
    public Calculadora() {
        // inicializa vari�veis de inst�ncia
        limpa();
    }

    /**
     * Entra a tecla um
     * @return conte�do do operando.
     */
    public String entraUm() {
        opString = base.converterBase(opDecimal) + "1";
        opDecimal = base.toDecimal(opString);
        adicionador.adicionaParteReal(opDecimal, operando, montador);
        adicionador.adicionaParteImaginaria(opDecimal, operando, montador);
        display = operando;
        return operando.mostra(base);
    }

    /**
     * Limpa o acumulador
     * @return conte�do do acumulador
     */
    public String limpa() {
        opDecimal = 0;
        opString = "";
        operando = new Complexo();
        acumulador = new Complexo();
        adicionador = new ParteReal();
        montador = new Fixo();
        adicionador.adicionaParteReal(0, operando, montador);
        adicionador.adicionaParteImaginaria(0, operando, montador);
        adicionador.adicionaParteReal(0, acumulador, montador);
        adicionador.adicionaParteImaginaria(0, acumulador, montador);
        display = new Complexo();
        adicionador.adicionaParteReal(0, display, montador);
        adicionador.adicionaParteImaginaria(0, display, montador);
        base = new BaseDecimal();
        //return acumulador.getValor() + "";
        return "0";
    }

    /**
     * Entra o comando soma.
     * @return conte�do do acumulador
     */
    public String comandoSoma() {
        acumulador.soma(operando);
        String res = acumulador.mostra(base);
        display = acumulador;
        opDecimal = 0;
        opString = "";
        adicionador = new ParteReal();
        montador = new Fixo();
        operando = new Complexo();
        adicionador.adicionaParteReal(0, operando, montador);
        adicionador.adicionaParteImaginaria(0, operando, montador);
        return res;
    }
    
    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        base = new BaseHexadecimal();
        //return display.mostra(base);
    }
   
    /**
     * Entra a base bin�ria.
     */  
    public void modoBin() {
        base = new BaseBinaria();
        //return display.mostra(base);
    }
    
    /**
     * Entra a base decimal.
     */   
    public void modoDec() {
        base = new BaseDecimal();
        //return display.mostra(base);
    }
    
    /**
     * Entra a parte imagin�ria do n�mero complexo.
     */
    public void entraI() {
        adicionador = new ParteImaginaria();
        montador = new Fixo();
        opDecimal = 0;
        opString = "";
        Numero exponencial = acumulador.getParteImaginaria().getParteExponencial();
        adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria().getValor(), acumulador, montador);
        acumulador.getParteImaginaria().adicionaParteExponencial(exponencial);
    }
    
    /**
     * Entra a parte exponencial do n�mero.
     */
    public void entraN() {
        montador = new ParteExponencial();
        opDecimal = 0;
        opString = "";
        adicionador.adicionaParteReal(acumulador.getParteReal().getParteExponencial().getValor(), acumulador, montador);
        adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria().getParteExponencial().getValor(), acumulador, montador);
    }
}