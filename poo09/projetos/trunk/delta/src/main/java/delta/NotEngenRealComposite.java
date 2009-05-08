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
        this.numReal = numero;
    }
    
    /**
     * @param base
     * @return
     */
    public final String toString(BaseStrategy base) {
        //só imprime acumulador
        String retorno;
        retorno = numReal.toString(base) + "N" + expoente.toString(base);
        return retorno;
    }

    /**
     * @param base
     * @return
     */
    public String toStringOperando(BaseStrategy base){
        String retorno;
        retorno = numReal.toStringOperando(base) + "N" + expoente.toStringOperando(base);
        return retorno;
    }

    /**
     * Implementacao do metodo entraUm.
     * @param base
     */
    public final void entraUm(BaseStrategy base) {
        expoente.entraUm(base);
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void soma() {
        numReal.soma();
        expoente.soma();
    }

    /**
     * @param inteiro
     * @param base
     */
    public final OperacaoComposite getOperando() {
        return numReal;
    }

    /**
     * @param inteiro
     * @param base
     */
    public final OperacaoComposite getInstancia() {
        return this;
    }

    /**
     * @param inteiro
     * @param base
     */
    public final OperacaoComposite getExpoente() {
        return expoente;
    }

}
