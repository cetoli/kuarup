package bravo.bases;

/**
 * Representa a base decimal
 * 
 * @author leandrogomes
 * 
 */
public class BaseDecimalStrategy implements BaseStrategy {

	public String getPrefix() {
		return "";
	}

	/**
	 * converte para decimal
	 */
	public int toDecimal(String n) {
		return Integer.parseInt(n);
	}

	/**
	 * converte para um certa base
	 */
	public String toBase(int v) {
		return String.valueOf(v);
	}
}