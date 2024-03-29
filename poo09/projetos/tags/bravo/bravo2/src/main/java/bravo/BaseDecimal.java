package bravo;

/**
 * Classe concreta que implementa a interface StrategyBase.
 * Esta classe contem o metodo converterBase(Integer Valor).
 * Retorna uma String. Esta classe devolve a representacao Decimal.
 * @author (Tiago C. de Fran�a) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
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
    public final Integer entraUm(Integer valor) {
        valor = valor * 10 + 1;
        return valor;
    }

    /**
     * Metodo conversor para base decimal.
     * @param valor
     * @retorna uma String
     */
    public final String converterBase(Integer valor) {
        return valor.toString();    
    }
}