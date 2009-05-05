package bravo;

/**
 * Classe concreta que implementa a interface StrategyBase.
 * Esta classe contem o metodo converterBase(Integer Valor).
 * Retorna uma String. Esta classe devolve a representacao Decimal.
 * @author  (Marcio Reis Teixeira) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */
public class BaseDecimal implements StrategyBase {

    /**
     * Constructor for objects of class BaseDecimal.
     */
    public BaseDecimal() {
    }
    
    public String getId(){
        return "";   
    }

    public int toDecimal(String numero) {
        return Integer.parseInt(numero);
    }

     /**
     * Metodo conversor para base decimal.
     * Utiliza o metodo estatico toBinaryString da classe Integer.
     * Retornar a String.
     * @param valor
     * @return String com a representacao na base binaria do valor
     */
    public String converterBase(int valor) {
        return String.valueOf(valor);    
    }
}