package delta;

/**
 * Write a description of class Inteiro here.
 *
 * @author Andre Sion
 * @author Andre Abrantes
 * @version 0.3
 */
public class Inteiro {
    /**
     * Variavel que guarda o valor da parte Real do Inteiro aqui representado.
     */
    private int parteReal;

    /**
     * Variavel que guarda o valor da parte Imaginaria do Inteiro aqui
     * representado.
     */
    private int parteImaginaria;

    /**
     * Variavel que guarda se Inteiro esta trabalhando com numeros reais ou
     * complexos.
     */
    private InteiroState estado;

    /**
     *
     */
    public Inteiro() {
        parteReal = 0;
        parteImaginaria = 0;
        estado = new InteiroRealState();
    }

    /**
     *
     */
    public final int getParteReal() {
        return parteReal;
    }

    /**
     *
     */
    public final int getParteImaginaria() {
        return parteImaginaria;
    }

    /**
     *
     */
    public final InteiroState getEstado() {
        return estado;
    }

    /**
     *
     */
    public final void setEstado(final InteiroState inteiroState) {
        estado = inteiroState;
    }

    /**
     *
     */
    public final String toString(final BaseStrategy base) {
        return estado.toString(this, base);
    }

    /**
     *
     */
    public final void entraUm(final BaseStrategy base) {
        estado.entraUm(this, base);
    }

    /**
     *
     */
    public final void entraUmParteReal(final BaseStrategy base) {
        parteReal = parteReal * base.getValorBase() + 1;
    }

    /**
     *
     */
    public final void entraUmParteImaginaria(final BaseStrategy base) {
        parteImaginaria = parteImaginaria * base.getValorBase() + 1;
    }

    /**
     *
     */
    public final void entraI() {
        estado = new InteiroComplexoState();
    }

    /**
     *
     */
    public final void soma(final Inteiro inteiro) {
        parteReal += inteiro.getParteReal();
        parteImaginaria += inteiro.getParteImaginaria();

        estado.decideNovoEstado(this, inteiro.getEstado());
    }
}
