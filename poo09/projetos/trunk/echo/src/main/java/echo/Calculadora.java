/*-----------------------------------------------------------------------------
    Copyright 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
-----------------------------------------------------------------------------*/
package echo;
import labase.poo.ICalculadoraEngenharia;

/**
 * Calculadora com numeros complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Andre de Abrantes)  $Author$
 * @version (4.0)    $Revision$ (04/05/09)      $Date$
 * @since   (3.0) suporte a notacao de engenharia
 */

public class Calculadora implements ICalculadoraEngenharia {

    // Estado da Caculadora
    private int opDecimal;
    private String opString;
    private Inteiro operando;
    private Inteiro acumulador;
    private Dispatcher dispatcher;
    private String display;
    private BaseStrategy base;

    /**
     * Construtor para objetos da classe Calculadora.
     * Sempre inicializa como decimal
     */
    public Calculadora() {
        // inicializa variaveis de instancia
        base = new BaseDecimalStrategy();
        limpa();
    }

    /**
     * Limpa o acumulador.
     * @return conteudo do acumulador
     */
    public String limpa() {
        opDecimal = 0;
        opString = "";

        operando = new ComplexoComposite();
        acumulador = new ComplexoComposite();
        dispatcher = new ParteRealDispatcher();

        dispatcher.adicionaParteReal(0, operando);
        dispatcher.adicionaParteImaginaria(0, operando);
        dispatcher.adicionaExpoente(0, operando);

        dispatcher.adicionaParteReal(0, acumulador);
        dispatcher.adicionaParteImaginaria(0, acumulador);
        dispatcher.adicionaExpoente(0, acumulador);

        display = operando.mostra(base);
        return display;
    }
    
    /**
     * Entra a tecla um.
     * @return conteudo do operando.
     */
    public String entraUm() {
        opString = base.converteBase(opDecimal) + "1";
        opDecimal = base.converteBaseParaDecimal(opString);

        dispatcher.adicionaParteReal(opDecimal, operando);
        dispatcher.adicionaParteImaginaria(opDecimal, operando);
        dispatcher.adicionaExpoente(opDecimal, operando);

        display = operando.mostra(base);

        return display;
    }

    /**
     * Entra o comando soma.
     * @return conteudo do acumulador
     */
    public String comandoSoma() {
        acumulador.soma(operando);

        dispatcher = new ParteRealDispatcher();

        operando = new ComplexoComposite();
        dispatcher.adicionaParteReal(0, operando);
        dispatcher.adicionaParteImaginaria(0, operando);
        dispatcher.adicionaExpoente(0, operando);

        opDecimal = 0;
        opString = "";
        display = acumulador.mostra(base);

        return display;
    }

    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        base = new BaseHexadecimalStrategy();
    }

    /**
     * Entra a base binaria.
     */  
    public void modoBin() {
        base = new BaseBinariaStrategy();
    }

    /**
     * Entra a base decimal.
     */   
    public void modoDec() {
        base = new BaseDecimalStrategy();
    }

    /**
     * Entra a parte imaginaria do numero complexo.
     */
    public void entraI() {
        dispatcher = new ParteImaginariaDispatcher();
        opDecimal = 0;
        opString = "";
        dispatcher.adicionaParteImaginaria(0, operando);

        Inteiro expoente = acumulador.getParteImaginaria().getExpoente();
        dispatcher.adicionaParteImaginaria(acumulador.getParteImaginaria().getValor(), acumulador);
        acumulador.getParteImaginaria().adicionaExpoente(expoente);
    }

    /**
     * Entra o expoente da notacao de engenharia.
     */
    public void entraN() {
        dispatcher = dispatcher.entraExpoente();
        opDecimal = 0;
        opString = "";
        dispatcher.adicionaExpoente(0, operando);
    }
}
