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
     * Retorna o valor da base.
     * @return Valor da base.
     */
    int getValorBase();

    /**
     * Converte um inteiro para string usando uma base.
     *
     * @param integer Inteiro a ser convertido.
     * @return String convertida.
     */
    String toString(final int integer);
}
