package delta;

/**
 * Implementacao de Operacões com notação de engenharia.
 * 
 * @author Tiago Cruz de França - Papagaio
 * @author André Sion - Pirata
 * @version 4.0 06-05-2009
 */
public class NotEngenImaginarioComposite implements OperacaoComposite {
    /** Guarda a referencia para o numero. */
    private OperacaoComposite complexo;
    /** Guarda a referencia para o expoente, sempre do tipo Real. */
    private OperacaoComposite expoente = new RealComposite();

    /**
     * Contrutor da classe.
     */
    public NotEngenImaginarioComposite(OperacaoComposite numero) {
        this.complexo = numero;
    }
    
    /**
     * @param base
     * @return
     */
    public final String toString(BaseStrategy base) {
        BaseStrategy baseAux = new DecimalStrategy();
        String retorno;
        retorno = complexo.toString(base) + "N" +  expoente.toString(baseAux);
        return retorno;
    }

    /**
     * @param base
     * @return
     */
    public String toStringOperando(BaseStrategy base){
        String retorno;
        BaseStrategy baseAux = new DecimalStrategy();
        retorno = complexo.toStringOperando(base) +
                      "N" + expoente.toStringOperando(baseAux);
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
        complexo.soma();
        expoente.soma();
    }

    /**
     * @param inteiro
     * @param base
     */
    public final OperacaoComposite getOperando() {
        return complexo.getOperando();
    }

    /**
     * @param inteiro
     * @param base
     */
    public final OperacaoComposite getOperando(OperacaoComposite real) {
        return real;
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
