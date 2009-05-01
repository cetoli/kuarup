package hotel;

/**.
 * Descrição:
 * Representação de um número complexo
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 3     Data 30/04/2009
 */

public class Numero {
	
	private int valorReal;
	private int valorImaginario;
	private Calculadora calculadora;
	private State estado;
	
	public Numero(Calculadora calc) {
		this.calculadora = calc;
		valorReal = 0;
		valorImaginario = 0;
		estado = new RealState();
	}

	public void entraUm(int base) {
		estado.entraUm(base, this);
	}
	
	public String toString() {
		return estado.toString(calculadora, this);
	}
	
	public String somar(Numero num) {
		valorReal += num.getValorReal();
		valorImaginario += num.getValorImaginario();
		return toString();
	}

	public int getValorImaginario() {
		return valorImaginario;
	}

	public int getValorReal() {
		return valorReal;
	}

	public void setValorReal(int novoValor) {
		valorReal = novoValor;
	}
	
	public void setValorImaginario(int novoValor) {
		valorImaginario = novoValor;
	}

	public void entraI() {
		estado = new ComplexState();
	}
}
