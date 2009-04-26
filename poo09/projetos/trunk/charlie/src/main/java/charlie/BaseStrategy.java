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
     * @param integer Entra um inteiro.
     * @return Retorna um.
     */
    Integer entraUm(Integer integer);

    /**
     * Conversor de inteiro para string.
     * @param integer Converte para string.
     * @return Retorna string.
     */
    String toString(Integer integer);
}
