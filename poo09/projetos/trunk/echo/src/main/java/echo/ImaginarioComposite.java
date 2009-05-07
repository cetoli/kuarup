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
public class ImaginarioComposite implements Inteiro {

    private int mantissa;
    private Inteiro expoente;
    
    /**
     * Metodo herdado de Inteiro.
     */
    public ImaginarioComposite(int valor) {
        mantissa = valor;
        expoente = new Nulo();
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void adicionaParteReal(Inteiro inteiro) {
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void adicionaParteImaginaria(Inteiro inteiro) {
        mantissa = inteiro.getParteImaginaria().getValor();
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
        return "I" + base.getId() + base.converteBase(mantissa) + expoente.mostra(base);
    }

    /**
     * Metodo herdado de Inteiro. Conforme o Prof. Carlo, esse if eh aritmetico, e nao logico. Logo, esta liberado.
     */
    public void soma(Inteiro inteiro) {
        int diff = expoente.getValor() - inteiro.getParteImaginaria().getExpoente().getValor();

        if (diff == 0) {
            mantissa += inteiro.getParteImaginaria().getValor();
        }
        else if (diff > 0) {
            mantissa += inteiro.getParteImaginaria().getValor() / (int)Math.pow(10, diff);
        }
        else {
            mantissa = mantissa / (int)Math.pow(10, -diff) + inteiro.getParteImaginaria().getValor();
            expoente = new Expoente(inteiro.getParteImaginaria().getExpoente().getValor());
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
        return new Nulo();
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public Inteiro getParteImaginaria() {
        return this;
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public Inteiro getExpoente() {
        return expoente;
    }
}
