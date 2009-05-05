package delta;

/**
 * @author Andre Abrantes
 * @author Andre Sion
 * @version 0.3
 */
public class InteiroComplexoState implements InteiroState {

    /**
     *
     */
    public InteiroComplexoState() {
    }

    /**
     * @param inteiro
     * @param base
     * @return
     */
    public final String toString(final Inteiro inteiro,
            final BaseStrategy base) {
        return base.toString(inteiro.getParteReal()) + "I"
            + base.toString(inteiro.getParteImaginaria());
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void entraUm(final Inteiro inteiro, final BaseStrategy base) {
        inteiro.entraUmParteImaginaria(base);
    }

    /**
     * @param inteiro
     * @param inteiroState
     */
    public final void decideNovoEstado(final Inteiro inteiro,
            final InteiroState inteiroState) {
    }
}
