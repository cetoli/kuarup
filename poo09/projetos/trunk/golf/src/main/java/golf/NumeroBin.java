package golf;

/**
 * Representa um nœmero na base bin‡ria
 * 
 * @author Gustavo Taveira
 * @version 2.0
 */
public class NumeroBin extends AbstractNumero {
	public final Integer binario = 2;

	/**
	 * Constructor for objects of class NumeroBin
	 * 
	 * @atribute Integer x
	 */
	public NumeroBin(Integer x) {
		this.valor = x;
		this.base = binario;
	}

	/**
	 * Converte o valor para Binario
	 */
	public String converte() {
		return Integer.toBinaryString(valor);
	}
}
