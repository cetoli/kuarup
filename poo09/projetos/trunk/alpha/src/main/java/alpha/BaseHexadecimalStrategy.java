package alpha;

/**
 * Classe que executa opera��es com numeros hexadecimais.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 4.0
 */
public class BaseHexadecimalStrategy implements BaseStrategy {
    /**
     * M�todo herdado de BaseStrategy.
     */
    public String getId() {
        return "0x";
    }
    /**
     * M�todo herdado de BaseStrategy.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n, 16);
    }
    /**
     * M�todo herdado de BaseStrategy.
     */
    public String toBase(int v) {
        return Integer.toHexString(v).toUpperCase();
    }
}
