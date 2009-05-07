/*-----------------------------------------------------------------------------
    Copyright 2002-2006        Carlo E. T. Oliveira et all
    ( see http://labase.nce.ufrj.br/curso/poo/team-list.html )

    This software is licensed as described in the file LICENSE.txt,
    which you should have received as part of this distribution.
-----------------------------------------------------------------------------*/
package echo;

/**
 * Calculadora com numeros complexos.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Andre de Abrantes)  $Author$
 * @version (4.0)    $Revision$ (04/05/09)      $Date$
 * @since   (3.0) suporte a notacao de engenharia
 */
public class ComplexoComposite implements Inteiro {

    private Inteiro real;
    private Inteiro imaginario;

    /**
     * Construtor.
     */
    public ComplexoComposite() {
        real = new Nulo();
        imaginario = new Nulo();
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void adicionaParteReal(Inteiro inteiro) {
        real = inteiro;
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void adicionaParteImaginaria(Inteiro inteiro) {
        imaginario = inteiro;
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void adicionaExpoente(Inteiro inteiro) {
        real.adicionaExpoente(inteiro);
        imaginario.adicionaExpoente(inteiro);
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public String mostra(BaseStrategy base) {
        return real.mostra(base) + imaginario.mostra(base);
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void soma(Inteiro inteiro) {
        real.soma(inteiro.getParteReal());
        imaginario.soma(inteiro.getParteImaginaria());
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public Inteiro getParteReal() {
        return real;
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public Inteiro getParteImaginaria() {
        return imaginario;
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public Inteiro getExpoente() {
        return new Nulo();
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public int getValor() {
        return 0;
    }
}
