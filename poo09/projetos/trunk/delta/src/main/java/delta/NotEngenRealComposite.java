package delta;


/**
 * Implementacao de Operacões com notação de engenharia.
 * 
 * @author Tiago Cruz de França - Papagaio
 * @author André Sion - Pirata
 * @version 4.0 06-05-2009
 */
public class NotEngenRealComposite implements OperacaoComposite {
    /** Guarda a referencia para o numero. */
    private OperacaoComposite numReal;
    /** Guarda a referencia para o expoente, sempre do tipo Real. */
    private OperacaoComposite expoente = new RealComposite();

    /**
     * Contrutor da classe.
     */
    public NotEngenRealComposite(OperacaoComposite numero) {
        this.numero = numReal;
    }
    
    /**
     * @param base
     * @return
     */
    public final String toString(BaseStrategy base) {
        //só imprime acumulador
        String retorno;
        retorno = numReal.toString(base) + expoente.toString(base);
        return retorno;
    }

    /**
     * @param base
     * @return
     */
    public String toStringOperando(BaseStrategy base){
        //stub
        return "";
    }

    /**
     * Implementacao do metodo entraUm.
     * @param base
     */
    public final void entraUm(BaseStrategy base) {
        this.expoente.entraUm(base);
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void soma() {
        numero.soma();
        expoente.soma();
    }

    /**
     * @param inteiro
     * @param base
     */
    public final OperacaoComposite getExpoente() {
        return this.expoente;
    }

    /**
     * @param inteiro
     * @param base
     */
    public final OperacaoComposite getInstacia(OperacaoComposite real,
                                            OperacaoComposite imaginario) {
        return this.expoente;
    }

}
