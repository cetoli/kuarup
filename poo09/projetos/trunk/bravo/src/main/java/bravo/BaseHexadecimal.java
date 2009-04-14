package bravo;


/**
 * Classe concreta que implementa a interface StrategyBase.
 * Esta classe contem o metodo converterBase(Integer Valor)
 * retorna uma String. Esta classe devolve a representacao na
 * base hexadecimal do valor passado como parametro do metodo citado
 * 
 * @author (Tiago C. de França) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
 */
public class BaseHexadecimal implements StrategyBase
{
    /**
     * Constructor for objects of class BaseHexadecimal.
     */
    public BaseHexadecimal()
    {
    }
    
    /**
     * Metodo de Entrada para HexaDecimal.
     * Entrada de valores
     */    
    public Integer entraUm(Integer valor)
    {
        valor = valor * 16 + 1;
        return valor;
    }
    
    /**
     * Metodo conversor para base Hexadecimal.
     * Utiliza o metodo estatico toHexString da classe 
     * Integer para retornar a String
     * @param valor
     * @retorno String com a representacao na base hexadecimal do valor
     */
    public String converterBase(Integer valor)
    {
        return "0x"+Integer.toHexString(valor);
    }
}
