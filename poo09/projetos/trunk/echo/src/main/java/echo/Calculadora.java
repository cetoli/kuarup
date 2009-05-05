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
    private Inteiro inteiro;
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
        limpa();
    }

    /**
     * Entra a tecla um.
     * @return conteudo do inteiro.
     */
    public String entraUm() {
        opString = base.converteBase(opDecimal) + "1";
        opDecimal = base.converteBaseParaDecimal(opString);

        dispatcher.adicionaParteReal(opDecimal, inteiro);
        dispatcher.adicionaParteImaginaria(opDecimal, inteiro);
        dispatcher.adicionaExpoente(opDecimal, inteiro);

        display = inteiro.mostra(base);

        return display;
    }

    /**
     * Limpa o acumulador.
     * @return conteudo do acumulador
     */
    public String limpa() {
        opDecimal = 0;
        opString = "";
        display = "";

        inteiro = new ComplexoComposite();
        acumulador = new ComplexoComposite();
        dispatcher = new ParteRealDispatcher();

        dispatcher.adicionaParteReal(0, inteiro);
        dispatcher.adicionaParteImaginaria(0, inteiro);
        dispatcher.adicionaExpoente(0, inteiro);

        dispatcher.adicionaParteReal(0, acumulador);
        dispatcher.adicionaParteImaginaria(0, acumulador);
        dispatcher.adicionaExpoente(0, acumulador);

        base = new BaseDecimalStrategy();

        return acumulador.mostra(base);
    }

    /**
     * Entra o comando soma.
     * @return conteudo do acumulador
     */
    public String comandoSoma() {
        acumulador.soma(inteiro);
        display = acumulador.mostra(base);

        opDecimal = 0;
        opString = "";

        dispatcher = new ParteRealDispatcher();
        dispatcher.adicionaParteReal(0, inteiro);
        dispatcher.adicionaParteImaginaria(0, inteiro);
        dispatcher.adicionaExpoente(0, inteiro);

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
        dispatcher.adicionaParteImaginaria(acumulador.getParteImaginaria().getValor(), acumulador);
    }

    /**
     * Entra o expoente da notacao de engenharia.
     */
    public void entraN() {
        dispatcher = new ExpoenteDispatcher();
        opDecimal = 0;
        opString = "";
        dispatcher.adicionaExpoente(0, acumulador);
    }
}
