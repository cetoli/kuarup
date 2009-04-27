package bravo;

/**
 * Interface descritiva do metodo de conversao de base.
 * @author  (Carlos Felippe Cardoso de Resende) O papagaio
 * @author  (Humberto Ferreira Ramos Junior) O pirata
 * @version (3.0) (27 de abril de 2009) 
 * Esta versão trabalha com os numeros Imaginarios
 */
public interface StrategyBase {

    /**
     * Metodo abstrato.
     * Entrada de valores.
     */    
    public Numero entraUm(Numero valor);
        
    /**
     * Metodo abstrato.
     * Conversor de Base de Operacao.
     * @param valor e um objeto intereiro em base decimal
     * @retorna uma string com o valor na base desejada
     */
    public String converterBase(Numero valor); 
}
