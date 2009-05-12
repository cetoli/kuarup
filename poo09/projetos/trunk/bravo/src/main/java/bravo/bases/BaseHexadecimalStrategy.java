package bravo.bases;

/**
 * Representa a base hexadecimal
 * 
 * @author leandrogomes e humberto
 * 
 */
public class BaseHexadecimalStrategy implements BaseStrategy {

	public String getPrefix() {
		return "0x";
	}

	/**
	 * converte para decimal
	 */
	public int toDecimal(String n) {
		return Integer.parseInt(n, 16);
	}

	/**
	 * converte para uma certa base
	 */
	public String toBase(int v) {
		return Integer.toHexString(v).toUpperCase();
	}

}
