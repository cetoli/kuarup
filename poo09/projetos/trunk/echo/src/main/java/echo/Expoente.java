package echo;

/**
 * Write a description of class Expoente here.
 * 
 * @author  (Marcos de Castro)  $Author$
 * @author  (Andre de Abrantes)  $Author$
 * @version (4.0)    $Revision$ (04/05/09)      $Date$
 * @since   (3.0) suporte a numeros complexos
 */
public class Expoente implements Operando {

    private int valor;

    /**
     * Metodo herdado de Operando.
     */
    public Expoente(int valor) {
        this.valor = valor;
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
    }

    /**
     * Metodo herdado de Operando.
     */
    public void adicionaExpoente(Operando operando) {
        valor = operando.getValor();
    }

    /**
     * Metodo herdado de Operando.
     */
    public String mostra(Base base) {
        return base.getId() + base.converteBase(valor);
    }

    /**
     * Metodo herdado de Operando.
     */
    public void soma(Operando operando) {
        //TODO
    }

    /**
     * Metodo herdado de Operando.
     */
    public int getValor() {
        return valor;
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
        return new Nulo();
    }

    /**
     * Metodo herdado de Operando.
     */
    public Operando getExpoente() {
        return this;
    }
}
