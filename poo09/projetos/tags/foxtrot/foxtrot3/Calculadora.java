/*------------------------------------------------------------------------------
    Copyright © 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
------------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com números complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Thiago Silva de Souza)  $Author$
 * @version (3.0)    $Revision$ (28/04/09)      $Date$
 * @since   (3.0) Suporte a números complexos
 * @version (2.0)    $Revision$ (07/04/09)      $Date$
 * @since   (2.0) Botoes para entrar valores em binario, hexadecimal e decimal
 */

public class Calculadora {

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
        // inicializa variáveis de instância
        limpa();
    }

    /**
     * Entra a tecla um.
     * @return conteúdo do operando.
     */
    public String entraUm() {
        opString = base.converteBase(opDecimal) + "1";
        opDecimal = base.converteBaseParaDecimal(opString);
        compositor.adicionaParteReal(opDecimal, operando);
        compositor.adicionaParteImaginaria(opDecimal, operando);
        display = operando.mostra(base);
        return display;
    }

    /**
     * Limpa o acumulador.
     * @return conteúdo do acumulador
     */
    public int limpa() {
        opDecimal = 0;
        opString = "";
        operando = new Complexo();
        acumulador = new Complexo();
        compositor = new CompositorParteReal();
        compositor.adicionaParteReal(0, operando);
        compositor.adicionaParteImaginaria(0, operando);
        compositor.adicionaParteReal(0, acumulador);
        compositor.adicionaParteImaginaria(0, acumulador);
        display = "";
        base = new BaseDecimal();
        return acumulador.getValor();
    }

    /**
     * Entra o comando soma.
     * @return conteúdo do acumulador
     */
    public String comandoSoma() {
        acumulador.soma(operando);
        display = acumulador.mostra(base);
        opDecimal = 0;
        opString = "";
        compositor = new CompositorParteReal();
        compositor.adicionaParteReal(0, operando);
        compositor.adicionaParteImaginaria(0, operando);
        return display;
    }
    
    /**
     * Entra a base hexadecimal.
     */
    public void entraHexadecimal() {
        base = new BaseHexadecimal();
    }
   
    /**
     * Entra a base binária.
     */  
    public void entraBinario() {
        base = new BaseBinaria();
    }
    
    /**
     * Entra a base decimal.
     */   
    public void entraDecimal() {
        base = new BaseDecimal();
    }
    
    /**
     * Entra a parte imaginária do número complexo.
     */
    public void entraI() {
        compositor = new CompositorParteImaginaria();
        opDecimal = 0;
        opString = "";
        compositor.adicionaParteImaginaria(acumulador.getParteImaginaria().getValor(), acumulador);
    }
}
