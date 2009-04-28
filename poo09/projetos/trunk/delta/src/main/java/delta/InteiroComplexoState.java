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
     * 
     */
    public String toString(Inteiro inteiro, BaseStrategy base) {
        return base.toString(inteiro.getParteReal()) + "I"
            + base.toString(inteiro.getParteImaginaria());
    }

    /**
     * 
     */
    public void entraUm(Inteiro inteiro, BaseStrategy base) {
        inteiro.entraUmParteImaginaria(base);
    }

    /**
     *
     */
    public void decideNovoEstado(Inteiro inteiro, InteiroState inteiroState) {
    }
}
