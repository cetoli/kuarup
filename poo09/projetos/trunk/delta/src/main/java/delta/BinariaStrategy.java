package delta;

/**
 * Classe da base binaria.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 24/04/2009 Andre Sion e Andre Abrantes
 */
public class BinariaStrategy implements BaseStrategy {

    /**
     *
     */
    private final int valorBase = 2;

    /**
     *
     */
    private final String prefixoBase = "0b";

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
        return prefixoBase + Integer.toBinaryString(integer);
    }
}
