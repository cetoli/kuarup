package alpha;

/**
 * Classe que executa operações com numeros decimais.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 4.0
 */
public class BaseDecimalStrategy implements BaseStrategy {
    /**
     * Método herdado de BaseStrategy.
     */
    public String getId() {
        return "";
    }
    /**
     * Método herdado de BaseStrategy.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n);
    }
    /**
     * Método herdado de BaseStrategy.
     */
    public String toBase(int v) {
        return String.valueOf(v);
    }
}
