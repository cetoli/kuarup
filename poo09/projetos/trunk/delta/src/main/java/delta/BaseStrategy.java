package delta;

/**
 * Interface que define os metodos das bases da calculadora.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 24/04/2009 Andre Sion e Andre Abrantes
 * @since   0.2 Retirado metodo getId() e acrescentado getValorBase()
 */
public interface BaseStrategy {

    /**
     *
     */
    int getValorBase();

    /**
     *
     */
    String toString(final int integer);
}
