package bravo;


/**
 * Classe ExibicaoNumeroRealState.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (14 de abril de 2009) 
 * Esta versão trabalha com os numeros Imaginarios
 * @since   (3.0)
 */
public class ExibicaoNumeroRealState implements IExibicaoValorState
{

    /**
     * Constructor for objects of class ExibicaoNumeroRealState.
     */
    public ExibicaoNumeroRealState() { }


    /**
     * Retorna resultado.
     */  
        
    public String retornaValor(Numero acumuladorReal,
                    Numero acumuladorImaginario, 
                    StrategyBase baseNumericaUsada) {
     
        String resultado = baseNumericaUsada.converterBase(acumuladorReal);
        
        return resultado;
    }
}
