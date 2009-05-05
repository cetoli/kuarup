/*------------------------------------------------------------------------------
    Copyright © 2002-2009        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package foxtrot;

/**
 * Classe que implementa a calculadora.
 * @author  Carlos Eduardo e Thiago Silva de Souza
 * @version 4.0 05/05/2009 Carlos Eduardo e Thiago Silva de Souza
 * @since   4.0 Incluídas as funcionalidades: números com notação científica.
 * @version 3.0 28/04/2009  Carlos Eduardo e Rodrigo Borges
 * @since   3.0 Incluídas as funcionalidades: números complexos.
 * @version 2.0 14/04/2009 Carlos Eduardo e Carlos Henrique
 * @since   2.0 Incluídas as funcionalidades: números em bases binárias e
 * hexadecimais.
 */
public class Calculadora {

    // Estado da Caculadora
    private int opDecimal;
    private String opString;
    private Operando operando;
    private Operando acumulador;
    private Adicionador adicionador;
    private Adicionador montador;
    private Operando display;
    private Base base;
  
    /**
     * Construtor para objetos da classe Calculadora
     * Sempre inicializa como decimal
     */
    public Calculadora() {
        // inicializa variáveis de instância
        limpa();
    }

    /**
     * Entra a tecla um
     * @return conteúdo do operando.
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
     * @return conteúdo do acumulador
     */
    public int limpa() {
        opDecimal = 0;
        opString = "";
        operando = new Complexo();
        acumulador = new Complexo();
        adicionador = new ParteReal();
        montador = new ParteMantissa();
        adicionador.adicionaParteReal(0, operando, montador);
        adicionador.adicionaParteImaginaria(0, operando, montador);
        adicionador.adicionaParteReal(0, acumulador, montador);
        adicionador.adicionaParteImaginaria(0, acumulador, montador);
        display = new Complexo();
        adicionador.adicionaParteReal(0, display, montador);
        adicionador.adicionaParteImaginaria(0, display, montador);
        base = new Decimal();
        return acumulador.getValor();
    }

    /**
     * Entra o comando soma.
     * @return conteúdo do acumulador
     */
    public String comandoSoma() {
        acumulador.soma(operando);
        String res = acumulador.mostra(base);
        display = acumulador;
        opDecimal = 0;
        opString = "";
        adicionador = new ParteReal();
        montador = new ParteMantissa();
        operando = new Complexo();
        adicionador.adicionaParteReal(0, operando, montador);
        adicionador.adicionaParteImaginaria(0, operando, montador);
        return res;
    }
    
    /**
     * Entra a base hexadecimal.
     */
    public String entraHexadecimal() {
        base = new Hexadecimal();
        return display.mostra(base);
    }
   
    /**
     * Entra a base binária.
     */  
    public String entraBinario() {
        base = new Binaria();
        return display.mostra(base);
    }
    
    /**
     * Entra a base decimal.
     */   
    public String entraDecimal() {
        base = new Decimal();
        return display.mostra(base);
    }
    
    /**
     * Entra a parte imaginária do número complexo.
     */
    public void entraI() {
        adicionador = new ParteImaginaria();
        montador = new ParteMantissa();
        opDecimal = 0;
        opString = "";
        Operando exponencial = acumulador.getParteImaginaria().getParteExponencial();
        adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria().getValor(), acumulador, montador);
        acumulador.getParteImaginaria().adicionaParteExponencial(exponencial);
    }
    
    /**
     * Entra a parte exponencial do número.
     */
    public void entraE() {
        montador = new ParteExponencial();
        opDecimal = 0;
        opString = "";
        adicionador.adicionaParteReal(acumulador.getParteReal().getParteExponencial().getValor(), acumulador, montador);
        adicionador.adicionaParteImaginaria(acumulador.getParteImaginaria().getParteExponencial().getValor(), acumulador, montador);
    }
}
