package alpha;

/**
 * Classe abstrata que sera extendida para operacao
 * com numeros nas diversas bases.
 * 
 * @author Diego Mury Gomes de Lima
 * @author Carlos Henrique P. Rodriguez
 * @version 3.0
 */
public interface BaseStrategy {
    /**
     * Retorna o identificador da base decimal, bin�ria ou hexadecimal.
     * @return o identificador da respectiva base.
     */
    public String getId();
    /**
     * Retorna o valor em decimal do n�mero dado em base decimal, bin�ria ou
     * hexadecimal.
     * @param n string do n�mero dado na respectiva base.
     * @return o valor em decimal do n�mero dado.
     */
    public int toDecimal(String n);
    /**
     * Retorna um n�mero em base decimal, bin�ria ou hexadecimal de acordo com
     * o valor em decimal dado.
     * @param v valor em decimal do n�mero dado.
     * @return a string do n�mero dado na respectiva base.
     */
    public String toBase(int v);
}
