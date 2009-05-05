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
    private Operando operando;
    private Operando acumulador;
    private Compositor compositor;
    private String display;
    private Base base;

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
     * @return conteudo do operando.
     */
    public String entraUm() {
        opString = base.converteBase(opDecimal) + "1";
        opDecimal = base.converteBaseParaDecimal(opString);
        compositor.adicionaParteReal(opDecimal, operando);
        compositor.adicionaParteImaginaria(opDecimal, operando);
        compositor.adicionaExpoente(opDecimal, operando);
        display = operando.mostra(base);
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

        operando = new Complexo();
        acumulador = new Complexo();
        compositor = new CompositorParteReal();

        compositor.adicionaParteReal(0, operando);
        compositor.adicionaParteImaginaria(0, operando);
        compositor.adicionaExpoente(0, operando);

        compositor.adicionaParteReal(0, acumulador);
        compositor.adicionaParteImaginaria(0, acumulador);
        compositor.adicionaExpoente(0, acumulador);

        base = new BaseDecimal();

        return acumulador.mostra(base);
    }

    /**
     * Entra o comando soma.
     * @return conteudo do acumulador
     */
    public String comandoSoma() {
        acumulador.soma(operando);
        display = acumulador.mostra(base);
        opDecimal = 0;
        opString = "";
        compositor = new CompositorParteReal();
        compositor.adicionaParteReal(0, operando);
        compositor.adicionaParteImaginaria(0, operando);
        compositor.adicionaExpoente(0, operando);
        return display;
    }

    /**
     * Entra a base hexadecimal.
     */
    public void modoHex() {
        base = new BaseHexadecimal();
    }

    /**
     * Entra a base binaria.
     */  
    public void modoBin() {
        base = new BaseBinaria();
    }

    /**
     * Entra a base decimal.
     */   
    public void modoDec() {
        base = new BaseDecimal();
    }

    /**
     * Entra a parte imaginaria do numero complexo.
     */
    public void entraI() {
        compositor = new CompositorParteImaginaria();
        opDecimal = 0;
        opString = "";
        compositor.adicionaParteImaginaria(acumulador.getParteImaginaria().getValor(), acumulador);
    }

    /**
     * Entra o expoente da notacao de engenharia.
     */
    public void entraN() {
        compositor = new CompositorExpoente();
        opDecimal = 0;
        opString = "";
        compositor.adicionaExpoente(0, acumulador);
    }
}
