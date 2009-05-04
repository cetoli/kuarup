package charlie;

/**
 * Interface do estado de exibição do resultado.
 * @author  Tiago Cruz de França  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */
public interface ExibeValorState {
    /**
     * Assinatura do metodo imprimeResultados.
     */
    public String imprimeResultado(Integer acumuladorReal,
            Integer acumuladorImaginario, BaseStrategy modo);
}
