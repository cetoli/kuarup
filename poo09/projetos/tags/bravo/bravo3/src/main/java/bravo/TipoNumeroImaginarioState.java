package bravo;


/**
 * Esta classe define o estado em que a calculadora está trabalhando.
 * Sua função é conhecer como se faz soma entre numeros IMAGINARIOS.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (14 de abril de 2009)
 * Esta versão trabalha com os numeros Imaginarios
 * @since   (3.0)
 */
public class TipoNumeroImaginarioState implements ITipoNumeroState
{
    private StrategyBase base = new BaseDecimal();
    /**
     * Constructor for objects of class TipoNumeroImaginarioState.
     */
    public TipoNumeroImaginarioState()
    { }
    /**
     * Constructor for objects of class TipoNumeroImaginarioState.
     */
    public String entraUm(StrategyBase base, Numero operador,
        Numero operadorImaginario) {
        operadorImaginario = base.entraUm(operadorImaginario);
        return base.converterBase(operadorImaginario);
        
    }

    /**
     * Constructor for objects of class TipoNumeroImaginarioState.
     */
    public String soma(StrategyBase base, Numero operador, 
        Numero operadorImaginario, Numero acumulador, 
        Numero acumuladorImaginario) {
       
        acumuladorImaginario.setX(acumuladorImaginario.getX() + 
            operadorImaginario.getX());
        
        acumulador.setX(acumulador.getX() + operador.getX());
        
        return base.converterBase(acumulador) + "I" + 
            base.converterBase(acumuladorImaginario);
    }
}
