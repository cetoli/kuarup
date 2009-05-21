package alpha;

/**
 * Classe que executa opera��es com numeros binarios.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 4.0
 */
public class BaseBinariaStrategy implements BaseStrategy {
    /**
     * M�todo herdado de BaseStrategy.
     */
    public String getId() {
        return "0b";
    }
    /**
     * M�todo herdado de BaseStrategy.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n, 2);
    }
    /**
     * M�todo herdado de BaseStrategy.
     */
    public String toBase(int v) {
        return Integer.toBinaryString(v);
    }
}
