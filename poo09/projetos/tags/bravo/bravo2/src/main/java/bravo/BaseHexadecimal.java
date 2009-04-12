package bravo;


/**
 * Classe concreta que implementa a interface StrategyBase que contem o metodo converterBase(Integer Valor)
 * retorna uma String. Esta classe devolve a representacao na base hexadecimal do valor passado como parametro do metodo citado
 * 
 * @author (Tiago C. de Fran�a) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
 */
public class BaseHexadecimal implements StrategyBase
{
    /**
     * Constructor for objects of class BaseHexadecimal
     */
    public BaseHexadecimal()
    {
    }
    
    /**
     * Metodo conversor para base Hexadecimal,
     * utiliza o metodo estatico toHexString da classe Integer para retornar a String
     * @param Objeto do tipo inteiro valor
     * @retorno String com a representacao na base hexadecimal do valor
     */
    public String converterBase(Integer valor)
    {
        return Integer.toHexString(valor);
    }
}
