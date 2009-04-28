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
     */
    public Integer soma(Integer operador);

    /**
     * Declaracao da assinatura do metodo getAcumulador.
     */
    public Integer getAcumulador();
}