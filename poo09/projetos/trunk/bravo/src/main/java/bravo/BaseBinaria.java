package bravo;



/**
 * Classe concreta que implementa a interface StrategyBase que contem o metodo converterBase(Integer Valor)
 * retorna uma String. Esta classe devolve a representacao na base Binaria do valor passado como parametro do metodo citado
 * 
 * @author (Tiago C. de França) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
 */
public class BaseBinaria implements StrategyBase
{
    /**
     * Constructor for objects of class BaseBinaria
     */
    public BaseBinaria()
    {
    }
    /**
     * Metodo de Entrada para Binários
     * Entrada de valores
     */    
    public Integer entraUm(Integer valor)
    {
        valor = valor * 2 + 1;
        return valor;
    }
    
    /**
     * Metodo conversor para base Binaria,
     * utiliza o metodo estatico toBinaryString da classe Integer para retornar a String
     * @param Objeto do tipo inteiro valor
     * @retorno String com a representacao na base binaria do valor
     */
    public String converterBase(Integer valor)
    {
        return Integer.toBinaryString(valor);
    }

}
