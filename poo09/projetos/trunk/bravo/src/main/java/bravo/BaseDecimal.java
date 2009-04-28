package bravo;

/**
 * Classe concreta que implementa a interface StrategyBase.
 * Esta classe contem o metodo converterBase(Integer Valor).
 * Retorna uma String. Esta classe devolve a representacao Decimal.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (27 de abril de 2009) 
 * Esta versão trabalha com os numeros Imaginarios
 */
public class BaseDecimal implements StrategyBase {

    /**
     * Constructor for objects of class BaseDecimal.
     */
    public BaseDecimal() {
    }

    /**
     * Metodo de Entrada para Binários.
     * Entrada de valores.
     * @param valor com o numero que foi 'inputado'
     * @return o numero que foi digitado ate o momento
     */
    public Numero entraUm(Numero valor) {
        valor.setX(valor.getX() * 10 + 1);
        return valor;
    }

     /**
     * Metodo conversor para base decimal.
     * Utiliza o metodo estatico toBinaryString da classe Integer.
     * Retornar a String.
     * @param valor
     * @return String com a representacao na base binaria do valor
     */
    public String converterBase(Numero valor) {
        return valor.getX().toString();    
    }
}