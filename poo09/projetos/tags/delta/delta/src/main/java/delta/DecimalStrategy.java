package delta;

/**
 * Classe da base decimal.
 * @author  Andre Sion
 * @author  Andre Abrantes
 * @version 0.3 07/04/2009 Andr� Sion e Thiago Silva de Souza
 */
public class DecimalStrategy implements BaseStrategy {

    /**
     * Guarda o valor da base decimal.
     */
    private final int valorBase = 10;

    /**
     * Retorna o valor da base decimal.
     * @return Valor da base decimal.
     */
    public final int getValorBase() {
        return valorBase;
    }

    /**
     * Converte um inteiro para string usando base decimal.
     *
     * @param integer Inteiro a ser convertido.
     * @return String convertida.
     */
    public final String toString(Integer integer) {
        return Integer.toString(integer);
    }
}
