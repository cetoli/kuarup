package delta;

/**
 * Classe da base hexadecimal.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 24/04/2009 Andre Sion e Andre Abrantes
 */
public class HexadecimalStrategy implements BaseStrategy {

    /**
     * Guarda o valor da base hexadecimal.
     */
    private final int valorBase = 16;

    /**
     * Guarda o prefixo a ser usado na impressao de um numero na base hexadecimal.
     */
    private final String prefixoBase = "0x";

    /**
     * Retorna o valor da base hexadecimal.
     * @return Valor da base hexadecimal.
     */
    public final int getValorBase() {
        return valorBase;
    }

    /**
     * Converte um inteiro para string usando base hexadecimal.
     *
     * @param integer Inteiro a ser convertido.
     * @return String convertida.
     */
    public final String toString(final int integer) {
        return prefixoBase + Integer.toHexString(integer);
    }
}
