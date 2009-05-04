package charlie;

/**
 * Implementacao do estado de exibição do resultado para imaginarios.
 * @author  Tiago Cruz de França  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */
public class ImaginarioExibeValorState implements ExibeValorState {
    /**
     * Implementacao do medotodo imprimeResultado para valores imaginarios.
     * @return Retorna resultado.
     * @param Acumulador Real 'acumuladorReal'.
     * @param Acumulador Imaginario 'acumuladorImaginario'.
     * @param Modo 'modo'.
     */
    public final String imprimeResultado(final Integer acumuladorReal,
                    final Integer acumuladorImaginario, final BaseStrategy modo) {
        String resultado = modo.toString(acumuladorReal);
        resultado = resultado + "I" + modo.toString(acumuladorImaginario);
        return resultado;
    }
}
