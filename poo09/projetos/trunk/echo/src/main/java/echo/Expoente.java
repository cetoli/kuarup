package echo;

/**
 * Write a description of class Expoente here.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Andre de Abrantes)  $Author$
 * @version (4.0)    $Revision$ (04/05/09)      $Date$
 * @since   (3.0) suporte a numeros complexos
 */
public class Expoente implements Inteiro {

    private int valor;

    /**
     * Metodo herdado de Inteiro.
     */
    public Expoente(int valor) {
        this.valor = valor;
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
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void adicionaExpoente(Inteiro inteiro) {
        valor = inteiro.getValor();
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public String mostra(BaseStrategy base) {
        return "N" + base.getId() + base.converteBase(valor);
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public void soma(Inteiro inteiro) {
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public int getValor() {
        return valor;
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
        return new Nulo();
    }

    /**
     * Metodo herdado de Inteiro.
     */
    public Inteiro getExpoente() {
        return this;
    }
}
