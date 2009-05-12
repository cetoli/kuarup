package alpha;

/**
 * Classe abstrata que sera extendida para operacao
 * com numeros nas diversas bases.
 * 
 * @author Diego Mury Gomes de Lima
 * @version 1.0
 */
public interface BaseStrategy {
    /**
     * Metodo abstrato.
     * Entrada de valores.
     */    
    public String getId();
    /**
     * Metodo abstrato.
     * Converte para decimal.
     */
    public int toDecimal(String numero);
    /**
     * Metodo abstrato.
     * Conversor de Base de Operacao.
     * @param valor inteiro em base decimal
     * @retorna uma string com o valor na base desejada
     */
    public String converterBase(int valor); 
}
