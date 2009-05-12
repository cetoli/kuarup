package alpha;

/**
 * Classe que executa operações com numeros binarios.
 * 
 * @author Diego Mury G. de Lima 
 * @version 3.0
 */
public class BaseBinariaStrategy implements BaseStrategy {
    /**
     * Constructor for objects of class BaseBinaria.
     */
    public BaseBinariaStrategy() {
    }
    /**
     * Metodo que retorna o Id da base.
     * @return id da base binaria.
     */
    public String getId() {
        return "0b";   
    }
    /**
     * Metodo conversor para a base decimal.
     * @param numero na base binaria.
     * @return numero na base decimal.
     */
    public int toDecimal(String numero) {
        return Integer.parseInt(numero, 2);
    }
    /**
     * Metodo conversor para base Binaria.
     * Utiliza o metodo estatico toBinaryString da classe Integer.
     * @param valor.
     * @return String com a representacao na base binaria do valor.
     */
    public String converterBase(int valor) {
        return Integer.toBinaryString(valor);
    }
}
