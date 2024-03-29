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
     * @param inteiro
     * @param base
     * @return
     */
    public final String toString(final Inteiro inteiro,
            final BaseStrategy base) {
        return base.toString(inteiro.getParteReal());
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void entraUm(final Inteiro inteiro, final BaseStrategy base) {
        inteiro.entraUmParteReal(base);
    }

    /**
     * @param inteiro
     * @param inteiroState
     */
    public final void decideNovoEstado(final Inteiro inteiro,
            final InteiroState inteiroState) {
        inteiro.setEstado(inteiroState);
    }
}
