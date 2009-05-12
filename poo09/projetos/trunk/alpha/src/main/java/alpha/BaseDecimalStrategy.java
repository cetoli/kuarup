package alpha;

/**
 * Classe que executa operações com numeros binarios.
 * 
 * @author Diego Mury G. de Lima 
 * @version 3.0
 */
public class BaseDecimalStrategy implements BaseStrategy {
    /**
     * Constructor for objects of class BaseDecimal.
     */
    public BaseDecimalStrategy() {
    }
    /**
     * Metodo que retorna o Id da base.
     * @return id da base decimal.
     */
    public String getId() {
        return "";   
    }
    /**
     * Metodo conversor para a base decimal.
     * @param numero na base decimal.
     * @return numero na base decimal.
     */
    public int toDecimal(String numero) {
        return Integer.parseInt(numero);
    }
    /**
     * Metodo conversor para base Decimal.
     * Utiliza o metodo estatico valueOf da classe String.
     * @param valor.
     * @return String com a representacao na base decimal do valor.
     */
    public String converterBase(int valor) {
        return String.valueOf(valor);    
    }
}
