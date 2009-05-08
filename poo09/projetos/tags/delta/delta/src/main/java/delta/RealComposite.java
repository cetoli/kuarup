package delta;

/**
 * Classe que realiza as operacoes Imaginarias.
 * 
 * @author (Tiago Cruz de França) - Papagaio
 * @author (Andre Sion) - Pirata
 * @version 3.0 de 03-05-2009
 */
public class RealComposite implements OperacaoComposite {
    /** Operando guarda os valores de entrada. */
    private Integer operando = new Integer(0);
    /** Operando guarda os resultados da soma. */
    private Integer acumulador = new Integer(0);
    
    /**
     * @param inteiro
     * @param base
     * @return
     */
    public final String toString(BaseStrategy base) {
        //só imprime acumulador
        return base.toString(this.acumulador);
    }

    /**
     * @param inteiro
     * @param base
     * @return
     */
    public String toStringOperando(BaseStrategy base){
        return base.toString(this.operando);
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void entraUm(BaseStrategy base) {
        this.operando = this.operando * base.getValorBase() + 1;
    }

    /**
     * @param inteiro
     * @param base
     */
    public final void soma() {
        this.acumulador += this.operando;
        this.operando = 0;
    }

    /**
     * @param inteiro
     * @param base
     */
    public final OperacaoComposite getOperando() {
        return this;
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
        return this;
    }

}
