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
     */    
    public final Integer soma(Integer operador) {
        acumuladorReal = acumuladorReal + operador;
        return acumuladorReal;
    }

    /**
     * Implementacao do metodo getAcumulador.
     */ 
    public final Integer getAcumulador() {
        return acumuladorReal;
    }

    /**
     * Declaracao da assinatura do metodo getOperador.
     */
    public final Integer getOperador() {
        return operadorReal;
    }

    /**
     * Declaracao da assinatura do metodo setOperador.
     */
    public final void setOperador(Integer operador) {
        operadorReal = operador;
    }
}
