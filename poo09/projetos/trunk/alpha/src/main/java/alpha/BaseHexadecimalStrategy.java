package alpha;

/**
 * Classe que executa operações com numeros hexadecimais.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 4.0
 */
public class BaseHexadecimalStrategy implements BaseStrategy {
    /**
     * Método herdado de BaseStrategy.
     */
    public String getId() {
        return "0x";
    }
    /**
     * Método herdado de BaseStrategy.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n, 16);
    }
    /**
     * Método herdado de BaseStrategy.
     */
    public String toBase(int v) {
        return Integer.toHexString(v).toUpperCase();
    }
}
