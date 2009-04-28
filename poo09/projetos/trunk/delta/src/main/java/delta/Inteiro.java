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
    public int getParteReal() {
        return parteReal;
    }

    /**
     *
     */
    public int getParteImaginaria() {
        return parteImaginaria;
    }

    /**
     *
     */
    public InteiroState getEstado() {
        return estado;
    }

    /**
     *
     */
    public void setEstado(InteiroState inteiroState) {
        estado = inteiroState;
    }

    /**
     *
     */
    public String toString(BaseStrategy base) {
        return estado.toString(this, base);
    }

    /**
     *
     */
    public void entraUm(BaseStrategy base) {
        estado.entraUm(this, base);
    }

    /**
     *
     */
    public void entraUmParteReal(BaseStrategy base) {
        parteReal = parteReal * base.getValorBase() + 1;
    }

    /**
     *
     */
    public void entraUmParteImaginaria(BaseStrategy base) {
        parteImaginaria = parteImaginaria * base.getValorBase() + 1;
    }

    /**
     *
     */
    public void entraI() {
        estado = new InteiroComplexoState();
    }

    /**
     *
     */
    public void soma(Inteiro inteiro) {
        parteReal += inteiro.getParteReal();
        parteImaginaria += inteiro.getParteImaginaria();

        estado.decideNovoEstado(this, inteiro.getEstado());
    }
}
