package alpha;

/**
 * Classe que executa operações com numeros hexadecimais.
 * 
 * @author Diego Mury G. de Lima 
 * @version 3.0
 */
public class BaseHexadecimalStrategy implements BaseStrategy {
    /**
     * Constructor for objects of class BaseHexadecimal.
     */
    public BaseHexadecimalStrategy() {
    }
    /**
     * Metodo que retorna o Id da base.
     * @return id da base hexadecimal.
     */
    public String getId() {
        return "0x";   
    }
    /**
     * Metodo conversor para a base decimal.
     * @param numero na base hexadecimal.
     * @return numero na base decimal.
     */
    public int toDecimal(String numero) {
        return Integer.parseInt(numero, 16);
    }
    /**
     * Metodo conversor para base Hexadecimal.
     * Utiliza o metodo estatico toHexString da classe Integer.
     * @param valor.
     * @return String com a representacao na base hexadecimal do valor.
     */
    public String converterBase(int valor) {
        return Integer.toHexString(valor).toUpperCase();
    }
}
