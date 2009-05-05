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
public class Complexo implements Operando {

    private Operando real;
    private Operando imaginario;
    private Operando expoente;

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaParteReal(Operando operando) {
        this.real = operando;
    }

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaParteImaginaria(Operando operando) {
        this.imaginario = operando;
    }

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaExpoente(Operando operando) {
        this.expoente = operando;
    }


    /**
     * Metodo herdado de Operando.
     */
    public String mostra(Base base) {
        return this.real.mostra(base) + this.imaginario.mostra(base) + this.expoente.mostra(base);
    }

    /**
     * Metodo herdado de Operando.
     */
    public void soma(Operando operando) {
        this.real.soma(operando.getParteReal());
        this.imaginario.soma(operando.getParteImaginaria());
        this.expoente.soma(operando.getExpoente());
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getParteReal() {
        return this.real;
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return this.imaginario;
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getExpoente() {
        return this.expoente;
    }

    /**
     * Metodo herdado de Operando.
     */
    public int getValor() {
        return 0;
    }
}
