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
	
	private ParteReal valorReal;
	private ParteImaginaria valorImaginario;
	private Calculadora calculadora;
	private StateComplex estado;
	
	public Numero(Calculadora calc) {
		this.calculadora = calc;
		valorReal = new ParteReal();
		valorImaginario = new ParteImaginaria();
		estado = new RealState();
	}

	public void entraUm(int base) {
		estado.entraUm(base, this);
	}
	
	public String toString() {
		return estado.toString(calculadora, this);
	}
	
	public String somar(Numero num) {
		
		if(valorReal.getExpoente() < num.getValorReal().getExpoente())
		{
			valorReal.setMantissa(num.getValorReal().getMantissa());
			valorReal.setExpoente(num.getValorReal().getExpoente());
		}
		else if (valorReal.getExpoente() == num.getValorReal().getExpoente())
		{
			valorReal.setMantissa(valorReal.getMantissa() + num.getValorReal().getMantissa());
		}

		if(valorImaginario.getExpoente() < num.getValorImaginario().getExpoente())
		{
			valorImaginario.setMantissa(num.getValorImaginario().getMantissa());
			valorImaginario.setExpoente(num.getValorImaginario().getExpoente());
		}
		else if (valorImaginario.getExpoente() == num.getValorImaginario().getExpoente())
		{
			valorImaginario.setMantissa(valorImaginario.getMantissa() + num.getValorImaginario().getMantissa());
		}

		return toString();
	}

	public Parte getValorImaginario() {
		return valorImaginario;
	}

	public Parte getValorReal() {
		return valorReal;
	}

	public void setValorReal(ParteReal novoValor) {
		valorReal = novoValor;
	}
	
	public void setValorImaginario(ParteImaginaria novoValor) {
		valorImaginario = novoValor;
	}

	public void entraI() {
		estado = new ComplexState();
	}
	
	public void entraN() {
		estado.entraN(this);
	}

	public Parte getParteReal() {
		return valorReal;
	}

	public Parte getParteImaginaria() {
		return valorImaginario;
	}

	public StateComplex getEstado() {
		return estado;
	}

	public void setEstado(StateComplex novoEstado) {
		estado = novoEstado;
	}
}
