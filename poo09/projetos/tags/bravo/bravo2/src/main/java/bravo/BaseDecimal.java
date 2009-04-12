package bravo;


/**
 * Classe concreta que implementa a interface StrategyBase que contem o metodo converterBase(Integer Valor)
 * retorna uma String. Esta classe devolve a representacao na base decimal do valor passado como parametro do metodo citado
 * 
 * @author (Tiago C. de França) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
 */
public class BaseDecimal implements StrategyBase
{
    /**
     * Constructor for objects of class BaseDecimal
     */
    public BaseDecimal(){}
    
    /**
     * Metodo conversor para base decimal,
     * as operacoes sao feitas nesta base e necessario apenas retornar uma string com o valor
     * @param Objeto inteiro valor
     * @retorna uma String com a representacao na base decimal do valor passado
     */
    public String converterBase(Integer valor)
    {
        return valor.toString();    
    }

}
