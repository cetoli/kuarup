package bravo.bases;

/**
 * Interface que define as bases que os numeros podem assumir.
 * 
 * @author leandrogomes e humberto
 */
public interface BaseStrategy {

	/**
	 * Retorna o identificador da base decimal, bin‡ria ou hexadecimal.
	 */
	public String getPrefix();

	/**
	 * Retorna o valor em decimal do nœmero dado em base decimal, bin‡ria ou
	 * hexadecimal.
	 */
	public int toDecimal(String n);

	/**
	 * Retorna um nœmero em base decimal, bin‡ria ou hexadecimal de acordo com o
	 * valor em decimal dado.
	 */
	public String toBase(int v);
}
