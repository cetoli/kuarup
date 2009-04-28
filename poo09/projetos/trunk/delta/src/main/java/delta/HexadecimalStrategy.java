package delta;

/**
 * Classe da base hexadecimal.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 24/04/2009 Andre Sion e Andre Abrantes
 */
public class HexadecimalStrategy implements BaseStrategy {

    /**
     *
     */
    private final int valorBase = 16;

    /**
     *
     */
    private final String prefixoBase = "0x";

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
        return prefixoBase + Integer.toHexString(integer);
    }
}
