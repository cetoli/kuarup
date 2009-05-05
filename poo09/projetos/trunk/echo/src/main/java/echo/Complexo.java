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
    private Operando estado;

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaParteReal(Operando operando) {
        real = operando;
        estado = real;
    }

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaParteImaginaria(Operando operando) {
        imaginario = operando;
        estado = imaginario;
    }

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaExpoente(Operando operando) {
        estado.adicionaExpoente(operando);
    }


    /**
     * Metodo herdado de Operando.
     */
    public String mostra(Base base) {
        return real.mostra(base) + imaginario.mostra(base);
    }

    /**
     * Metodo herdado de Operando.
     */
    public void soma(Operando operando) {
        real.soma(operando.getParteReal());
        imaginario.soma(operando.getParteImaginaria());
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getParteReal() {
        return real;
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getParteImaginaria() {
        return imaginario;
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getExpoente() {
        return new Nulo();
    }

    /**
     * Metodo herdado de Operando.
     */
    public int getValor() {
        return 0;
    }
}
