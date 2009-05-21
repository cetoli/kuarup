package alpha;

/**
 * Classe que executa operações com numeros binarios.
 * 
 * @author Diego Mury G. de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 4.0
 */
public class BaseBinariaStrategy implements BaseStrategy {
    /**
     * Método herdado de BaseStrategy.
     */
    public String getId() {
        return "0b";
    }
    /**
     * Método herdado de BaseStrategy.
     */
    public int toDecimal(String n) {
        return Integer.parseInt(n, 2);
    }
    /**
     * Método herdado de BaseStrategy.
     */
    public String toBase(int v) {
        return Integer.toBinaryString(v);
    }
}
