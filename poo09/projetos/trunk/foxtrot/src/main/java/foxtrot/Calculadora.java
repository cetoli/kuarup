/*------------------------------------------------------------------------------
    Copyright 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;
import labase.poo.ICalculadoraVetorial;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Andre de Abrantes
 * @version 5.0 12/05/2009 Carlos Eduardo e Andre de Abrantes
 * @since   4.0 Inclu�das as funcionalidades: numeros vetoriais e subtracao
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   3.0 Inclu�das as funcionalidades: n�meros com nota��o cient�fica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   2.0 Inclu�das as funcionalidades: n�meros complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   1.0 Inclu�das as funcionalidades: n�meros em bases bin�rias e
 * hexadecimais.
 */
public class Calculadora implements ICalculadoraVetorial {

    // Estado da Caculadora
    private int opDecimal;
    private String opString;
    private Operando operando;
    private Operando acumulador;
    private Adicionador adicionador;
    private Adicionador montador;
    private Operando display;
    private Base base;
    private OperacaoState operacaoState;
  
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
        opString = base.toBase(opDecimal) + "1";
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
        operando = new Vetor(new Complexo());
        acumulador = new Vetor(new Complexo());
        adicionador = new ParteReal();
        montador = new ParteMantissa();
        adicionador.adicionaParteReal(0, operando, montador);
        adicionador.adicionaParteImaginaria(0, operando, montador);
        adicionador.adicionaParteReal(0, acumulador, montador);
        adicionador.adicionaParteImaginaria(0, acumulador, montador);
        display = new Vetor(new Complexo());
        adicionador.adicionaParteReal(0, display, montador);
        adicionador.adicionaParteImaginaria(0, display, montador);
        base = new Decimal();

        operacaoState = new OperacaoSomaState();

        return acumulador.mostra(base);
    }

    /**
     * Entra o comando soma.
     * @return conte�do do acumulador
     */
    public String comandoSoma() {
        operacaoState.fazOperacao(acumulador, operando);
        operacaoState = new OperacaoSomaState();

        String res = acumulador.mostra(base);
        display = acumulador;
        opDecimal = 0;
        opString = "";
        adicionador = new ParteReal();
        montador = new ParteMantissa();
        operando = new Vetor(new Complexo());
        adicionador.adicionaParteReal(0, operando, montador);
        adicionador.adicionaParteImaginaria(0, operando, montador);
        return res;
    }
    
    /**
     * Entra o comando subtrai.
     * @return conte�do do acumulador
     */
    public String comandoSubtrai() {
        operacaoState.fazOperacao(acumulador, operando);
        operacaoState = new OperacaoSubtracaoState();

        String res = acumulador.mostra(base);
        display = acumulador;
        opDecimal = 0;
        opString = "";
        adicionador = new ParteReal();
        montador = new ParteMantissa();
        operando = new Vetor(new Complexo());
        adicionador.adicionaParteReal(0, operando, montador);
        adicionador.adicionaParteImaginaria(0, operando, montador);
        return res;
    }
    
    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        base = new Hexadecimal();
    }
   
    /**
     * Entra a base bin�ria.
     */  
    public void modoBin() {
        base = new Binaria();
    }
    
    /**
     * Entra a base decimal.
     */   
    public void modoDec() {
        base = new Decimal();
    }
    
    /**
     * Entra a parte imagin�ria do n�mero complexo.
     */
    public void entraI() {
        adicionador = new ParteImaginaria();
        montador = new ParteMantissa();
        opDecimal = 0;
        opString = "";
        Operando exponencial = acumulador.getParteImaginaria().getParteExponencial();
        adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria().getValor(), acumulador, montador);
        adicionador.adicionaParteImaginaria(operando.getParteImaginaria().getValor(), operando, montador);
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
    
    /**
     *
     */
    public void entraV() {
        operando = operando.entraV();
        opDecimal = 0;
        opString = "";
        adicionador = new ParteReal();
        montador = new ParteMantissa();
    }
}
