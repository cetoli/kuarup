package charlie;

/**
 * Implementacao do estado de exibi��o do resultado para imaginarios.
 * @author  Tiago Cruz de Fran�a  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */
public class ImaginarioExibeValorState implements ExibeValorState {
    /**
     * Implementacao do medotodo imprimeResultado para valores imaginarios.
     */
    public final String imprimeResultado(Integer acumuladorReal,
                    Integer acumuladorImaginario, BaseStrategy modo) {
        String resultado = modo.toString(acumuladorReal);
        resultado = resultado + "I" + modo.toString(acumuladorImaginario);
        return resultado;
    }
}