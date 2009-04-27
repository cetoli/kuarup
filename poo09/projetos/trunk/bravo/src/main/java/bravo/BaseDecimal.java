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
     * Metodo de Entrada para Decimais.
     * Entrada de valores
     */    
    public Numero entraUm(Numero valor) {
        valor.setX(valor.getX() * 10 + 1);
        return valor;
    }

    /**
     * Metodo conversor para base decimal.
     * @param valor
     * @retorna uma String
     */
    public String converterBase(Numero valor) {
        return valor.getX().toString();    
    }
}