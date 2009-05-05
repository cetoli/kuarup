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
public class Imaginario implements Operando {

    private int mantissa;
    private Operando expoente;
    
    /**
     * Metodo herdado de Operando.
     */
    public Imaginario(int valor) {
        mantissa = valor;
    }

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaParteReal(Operando operando) {
    }

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaParteImaginaria(Operando operando) {
        mantissa = operando.getValor();
    }

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaExpoente(Operando operando) {
        expoente = operando;
    }

    /**
     * Metodo herdado de Operando.
     */
    public String mostra(Base base) {
        return "I" + base.getId() + base.converteBase(mantissa) + expoente.mostra(base);
    }

    /**
     * Metodo herdado de Operando.
     */
    public void soma(Operando operando) {
        mantissa += operando.getValor();
        //TODO
    }

    /**
     * Metodo herdado de Operando.
     */
    public int getValor() {
        return 0;
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getParteReal() {
        return new Nulo();
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return this;
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getExpoente() {
        return expoente;
    }
}
