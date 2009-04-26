package charlie;

/**
 * Implementacao do estado de exibição do resultado para reais.
 * @author  Tiago Cruz de França  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */
public class RealExibeValorState implements ExibeValorState {
    /**
     * Implementacao do medotodo imprimeResultado para valores reais.
     */
    public final String imprimeResultado(Integer acumuladorReal,
                    Integer acumuladorImaginario, BaseStrategy modo) {
        return modo.toString(acumuladorReal);
    }
}