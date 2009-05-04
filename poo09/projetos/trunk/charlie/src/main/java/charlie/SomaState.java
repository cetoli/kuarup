package charlie;

/**
 * Interface do estado de soma.
 * @author  Tiago Cruz de França  $Author$
 * @author  Helio Salmon  $Author$
 * @version 1.0
 */
public interface SomaState {
    /**
     * Declaracao da assinatura do metodo soma.
     * @param Operador.
     */
    public Integer soma(Integer operador);

    /**
     * Declaracao da assinatura do metodo getAcumulador.
     */
    public Integer getAcumulador();

    /**
     * Declaracao da assinatura do metodo getOperador.
     */
    public Integer getOperador();

    /**
     * Declaracao da assinatura do metodo setOperador.
     * @param Operador.
     */
    public void setOperador(Integer operador);
}
