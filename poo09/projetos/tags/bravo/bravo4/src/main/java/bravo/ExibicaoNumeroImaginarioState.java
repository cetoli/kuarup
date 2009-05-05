package bravo;


/**
 * Classe ExibicaoNumeroImaginarioState here.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (14 de abril de 2009)
 * Esta versão trabalha com os numeros Imaginarios
 * @since   (3.0)
 */
public class ExibicaoNumeroImaginarioState implements IExibicaoValorState {


/**
 * Retorna o valor real.
 */


    public String retornaValor(Numero acumuladorReal,
                    Numero acumuladorImaginario, 
                    StrategyBase baseNumericaUsada) {
     
        String resultado = baseNumericaUsada.converterBase(acumuladorReal);
        
        resultado = resultado + "I" +
            baseNumericaUsada.converterBase(acumuladorImaginario);
        return resultado;
    }  
}