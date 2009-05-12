package bravo.bases;

/**
 * Representa a base bin‡ria.
 */
public class BaseBinariaStrategy implements BaseStrategy {

	public String getPrefix() {
		return "0b";
	}

	/**
	 * converte para decimal
	 */
	public int toDecimal(String n) {
		return Integer.parseInt(n, 2);
	}

	/**
	 * converte para uma base
	 */
	public String toBase(int v) {
		return Integer.toBinaryString(v);
	}
}