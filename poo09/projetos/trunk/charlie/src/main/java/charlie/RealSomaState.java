package charlie;

/**
 * Implementacao do estado da soma para valores reais.
 * @author  Tiago Cruz de França  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */
public class RealSomaState implements SomaState {
    /** Atributo acumulador dos operacoes com reais. */
    private Integer acumuladorReal = new Integer(0);

    /** Atributo acumulador dos operacoes com reais. */
    private Integer operadorReal = new Integer(0);

    /**
     * Implementacao do metodo soma para valores reais.
     * @param Operador 'operador'.
     * @return Acumulador real.
     */
    public final Integer soma(final Integer operador) {
        acumuladorReal = acumuladorReal + operador;
        return acumuladorReal;
    }

    /**
     * Implementacao do metodo getAcumulador.
     * @return Acumulador real.
     */
    public final Integer getAcumulador() {
        return acumuladorReal;
    }

    /**
     * Declaracao da assinatura do metodo getOperador.
     * @return Operador real.
     */
    public final Integer getOperador() {
        return operadorReal;
    }

    /**
     * Declaracao da assinatura do metodo setOperador.
     * @param Operador 'operador'.
     */
    public final void setOperador(final Integer operador) {
        operadorReal = operador;
    }
}
