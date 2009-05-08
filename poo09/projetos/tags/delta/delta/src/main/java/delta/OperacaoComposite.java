package delta;


/**
 * Interface de assinatura dos metodos.
 * 
 * @author (Tiago Cruz de França) - Papagaio
 * @author (Andre Sion) - Pirata
 * @version 3.0 de 03-05-2009
 */
public interface OperacaoComposite {
    /** Assinatura do método de impressão acumulador. */
    public String toString(BaseStrategy base);
    /** Assinatura do método de impressão operando. */
    public String toStringOperando(BaseStrategy base);
    /** Assinatura do método de soma. */
    public void soma();
    /** Assinatura do método de entrada. */
    public void entraUm(BaseStrategy base);
    /** Assinatura do método de retorno de operando. */
    public OperacaoComposite getOperando();
    /** Assinatura do método de retorno de operando. */
    public OperacaoComposite getInstancia();
    /** Assinatura do método de retorno de operando. */
    public OperacaoComposite getExpoente();
}
