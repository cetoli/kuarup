package delta;

/**
 * Classe que realiza as operacoes Imaginarias.
 * 
 * @author (Tiago Cruz de França) - Papagaio
 * @author (Andre Sion) - Pirata
 * @version 3.0 de 03-05-2009
 */
public class ComplexoComposite implements OperacaoComposite {
    /** Referencia da parte real. */
    private OperacaoComposite real;
    /** Referencia da parte imaginaria. */
    private OperacaoComposite imaginario;

    /**
     * Contrutor exigido para instanciar o complexo.
     */
    public ComplexoComposite(OperacaoComposite real, OperacaoComposite imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    /**
     * @param inteiro
     * @param base
     * @return
     */
    public final String toString(BaseStrategy base) {
        String retorno;
        retorno = (real.toString(base) + imaginario.toString(base));
        return retorno;
    }

    /**
     * @param inteiro
     * @param base
     * @return
     */
    public String toStringOperando(BaseStrategy base){
        String retorno = (real.toStringOperando(base) + imaginario.toStringOperando(base));
        return retorno;
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void entraUm(BaseStrategy base) {
        real.entraUm(base);
        imaginario.entraUm(base);
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void soma() {
        real.soma();
        imaginario.soma();
    }

}
