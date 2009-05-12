package charlie;

/**
 * @author  (Carlos Felippe) O papagaio
 * @author  (Helio Mendes Salmon) O pirata
 * @version (4.0) (04 de maio de 2009) 
 * Esta versão trabalha com exponencial
 */
public interface StrategyBase {

    /**
     * Metodo abstrato.
     * Entrada de valores.
     */    
    public String getId();
    
    public int toDecimal(String numero);
        
    /**
     * 
     * Metodo abstrato.
     * Conversor de Base de Operacao.
     * @param valor e um objeto intereiro em base decimal
     * @retorna uma string com o valor na base desejada
     */
    public String converterBase(int valor); 
}
