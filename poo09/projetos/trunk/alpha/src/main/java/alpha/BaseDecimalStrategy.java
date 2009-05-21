package alpha;

/**
 * Classe que executa opera��es com numeros decimais.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 4.0
 */
public class BaseDecimalStrategy implements BaseStrategy {
    /**
     * M�todo herdado de BaseStrategy.
     */
    public String getId() {
        return "";
    }
    /**
     * M�todo herdado de BaseStrategy.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n);
    }
    /**
     * M�todo herdado de BaseStrategy.
     */
    public String toBase(int v) {
        return String.valueOf(v);
    }
}
