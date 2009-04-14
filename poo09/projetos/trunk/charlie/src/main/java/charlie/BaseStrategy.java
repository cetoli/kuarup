package charlie;

/**
 * Interface da estrategia de Base de operacao.
 * @author  Andre Abrantes  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */

public interface BaseStrategy {
    /**
     * Esta e a Base de calculo.
     */
    Integer entraUm(Integer integer);

    /**
     * Conversor de inteiro para string.
     */
    String toString (Integer integer);
}
