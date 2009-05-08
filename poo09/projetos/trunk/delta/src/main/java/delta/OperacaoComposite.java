package delta;


/**
 * Interface de assinatura dos metodos.
 * 
 * @author (Tiago Cruz de Fran�a) - Papagaio
 * @author (Andre Sion) - Pirata
 * @version 3.0 de 03-05-2009
 */
public interface OperacaoComposite {
    /** Assinatura do m�todo de impress�o acumulador. */
    public String toString(BaseStrategy base);
    /** Assinatura do m�todo de impress�o operando. */
    public String toStringOperando(BaseStrategy base);
    /** Assinatura do m�todo de soma. */
    public void soma();
    /** Assinatura do m�todo de entrada. */
    public void entraUm(BaseStrategy base);
    /** Assinatura do m�todo de instancia. */
}
