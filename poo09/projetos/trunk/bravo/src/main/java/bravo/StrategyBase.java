package bravo;


/**
 * Interface descritiva do metodo de conversao de base.
 * 
 * @author (Tiago C. de França) - O papagaio
 * @author (Humberto Ferreira Ramos Junior) - O pirata
 * @version 2.0 em 12 de abril de 2009
 */

public interface StrategyBase
{
    /**
     * Metodo abstrato.
     * Entrada de valores
     */    
    public Integer entraUm(Integer valor);
    
    /**
     * Metodo abstrato.
     * Entrada de valores
     */    
    public Integer entraUm(Integer valor);
    
    /**
     * Metodo abstrato
     * Conversor de Base de Operacao
     * @param valor e um objeto intereiro em base decimal
     * @retorna uma string com o valor na base desejada
     */
    public String converterBase(Integer valor);
}
