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
     * 
     */
    String toString(Inteiro inteiro, BaseStrategy base);

    /**
     * 
     */
    void entraUm(Inteiro inteiro, BaseStrategy base);

    /**
     *
     */
    void decideNovoEstado(Inteiro inteiro, InteiroState inteiroState);
}
