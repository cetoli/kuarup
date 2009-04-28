package bravo;


/**
 * Esta classe define o estado em que a calculadora está trabalhando. 
 * Sua função é conhecer como se faz soma entre numeros inteiros.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (14 de abril de 2009) 
 * Esta versão trabalha com os numeros Reais e Imaginarios
 * @since   (3.0)
 */
public class TipoNumeroRealState implements ITipoNumeroState
{
    /**
     * Constructor for objects of class TipoNumeroRealState.
     */
    public TipoNumeroRealState()
    {
        // initialise instance variables
    /**
     * Constructor for objects of class TipoNumeroRealState.
     */
    }
    /**
     * Constructor for objects of class TipoNumeroRealState.
     */    
    public  String entraUm(StrategyBase base, Numero operador, 
        Numero operadorImaginario) {
        operador = base.entraUm(operador);
        return base.converterBase(operador);
    }
    /**
     * Constructor for objects of class TipoNumeroRealState.
     */
    public String soma(StrategyBase base, Numero operador, 
        Numero operadorImaginario, Numero acumulador, 
        Numero acumuladorImaginario) {
        acumulador.setX(acumulador.getX() + operador.getX());
        operadorImaginario = new Numero();
       // acumuladorImaginario = new Numero();
        return base.converterBase(acumulador);
    }
   
}
