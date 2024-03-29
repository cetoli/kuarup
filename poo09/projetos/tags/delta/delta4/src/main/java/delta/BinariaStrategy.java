package delta;

/**
 * Classe da base binaria.
 * @author  Tiago Cruz de Fran�a
 * @author  Andre Sion
 * @version 4.0 03/05/2009
 */
public class BinariaStrategy implements BaseStrategy {

    /**
     * Guarda o valor da base binaria.
     */
    private final int valorBase = 2;

    /**
     * Guarda o prefixo a ser usado na impressao de um numero na base binaria.
     */
    private final String prefixoBase = "0b";

    /**
     * Retorna o valor da base binaria.
     * @return Valor da base binaria.
     */
    public final int getValorBase() {
        return valorBase;
    }

    /**
     * Converte um inteiro para string usando base binaria.
     *
     * @param integer Inteiro a ser convertido.
     * @return String convertida.
     */
    public final String toString(final Integer integer) {
        return prefixoBase + Integer.toBinaryString(integer);
    }
}
