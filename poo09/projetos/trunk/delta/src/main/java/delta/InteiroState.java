package delta;

/**
 * Write a description of interface State here.
 *
 * @author Andre Sion
 * @author Andre Abrantes
 * @version 0.3
 */

public interface InteiroState {

    /**
     * @param inteiro
     * @param base
     * @return
     */
    String toString(Inteiro inteiro, BaseStrategy base);

    /**
     * @param inteiro
     * @param base
     */
    void entraUm(Inteiro inteiro, BaseStrategy base);

    /**
     * @param inteiro
     * @param inteiroState
     */
    void decideNovoEstado(Inteiro inteiro, InteiroState inteiroState);
}
