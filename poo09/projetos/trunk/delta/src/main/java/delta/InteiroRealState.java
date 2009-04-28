package delta;

/**
 * Write a description of class RealState here.
 * 
 * @author Andre Sion
 * @author Andre Abrantes
 * @version 0.3
 */
public class InteiroRealState implements InteiroState {

    /**
     * 
     */
    public InteiroRealState() {
    }

    /**
     * 
     */
    public final String toString(Inteiro inteiro, BaseStrategy base) {
        return base.toString(inteiro.getParteReal());
    }

    /**
     * 
     */
    public final void entraUm(Inteiro inteiro, BaseStrategy base) {
        inteiro.entraUmParteReal(base);
    }

    /**
     *
     */
    public final void decideNovoEstado(Inteiro inteiro, InteiroState inteiroState) {
        inteiro.setEstado(inteiroState);
    }
}
