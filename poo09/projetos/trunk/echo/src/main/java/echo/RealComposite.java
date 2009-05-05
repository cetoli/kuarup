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
 * @since   (3.0) suporte a numeros complexos
 */
public class RealComposite implements Inteiro {

    private int mantissa;
    private Inteiro expoente;

    /**
     * Metodo herdado de Inteiro.
     */
    public RealComposite (int valor) {
        mantissa = valor;
        expoente = new Nulo();
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void adicionaParteReal(Inteiro inteiro) {
        mantissa = inteiro.getParteReal().getValor();
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void adicionaParteImaginaria(Inteiro inteiro) { 
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void adicionaExpoente(Inteiro inteiro) {
        expoente = inteiro;
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public String mostra(BaseStrategy base) {
        return base.getId() + base.converteBase(mantissa) + expoente.mostra(base);
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void soma(Inteiro inteiro) {
        int diff = expoente.getValor() - inteiro.getExpoente().getValor();

        if (diff == 0) {
            mantissa += inteiro.getParteReal().getValor();
        }
        else if (diff > 0) {
            mantissa += inteiro.getParteReal().getValor() / (int)Math.pow(10, diff);
        }
        else {
            mantissa = mantissa / (int)Math.pow(10, -diff) + inteiro.getParteReal().getValor();
            expoente = new Expoente(inteiro.getExpoente().getValor());
        }
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public int getValor() {
        return mantissa;
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public Inteiro getParteReal() {
        return this;
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public Inteiro getParteImaginaria() {
        return new Nulo();
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public Inteiro getExpoente() {
        return expoente;
    }
}
