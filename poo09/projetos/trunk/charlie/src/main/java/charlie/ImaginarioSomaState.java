package charlie;


/**
 * Implementacao do estado da soma para valores imaginarios.
 * @author  Tiago Cruz de França  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */
public class ImaginarioSomaState implements SomaState {
    /** Atributo acumulador dos operacoes com imaginarios. */
    private Integer acumuladorImaginario = new Integer(0);

    /** Atributo acumulador dos operacoes com imaginarios. */
    private Integer operadorImaginario = new Integer(0);

    /**
     * Implementacao do metodo soma para valores imaginarios.
     * @return Acumulador Imaginario.
     * @param Operador 'operador'.
     */
    public final Integer soma(final Integer operador) {
        acumuladorImaginario = acumuladorImaginario + operador;
        return acumuladorImaginario;
    }

    /**
     * Implementacao do metodo getAcumulador.
     * @return Acumulador Imaginario.
     */
    public final Integer getAcumulador() {
        return acumuladorImaginario;
    }

    /**
     * Declaracao da assinatura do metodo getOperador.
     * @return Operador Imaginario.
     */
    public final Integer getOperador() {
        return operadorImaginario;
    }

    /**
     * Declaracao da assinatura do metodo setOperador.
     * @param Operador 'operador'.
     */
    public final void setOperador(final Integer operador) {
        operadorImaginario = operador;
    }
}
