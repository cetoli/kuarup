package delta;

/**
 * Classe da base decimal.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 07/04/2009 Andr� Sion e Thiago Silva de Souza
 */
public class DecimalStrategy implements BaseStrategy {

    /**
     *
     */
    private final int valorBase = 10;

    /**
     *
     */
    public final int getValorBase() {
        return valorBase;
    }

    /**
     *
     */
    public final String toString(final int integer) {
        return Integer.toString(integer);
    }
}
