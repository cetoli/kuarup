package hotel;

public class Parte {

	protected int mantissa;
	protected int expoente;
	protected StateEngenharia estado;
	
	public Parte() {
		mantissa = 0;
		expoente = 0;
		estado = new MantissaState();
	}
	
	public void entraUm(int base) {
		estado.entraUm(base, this);
	}

	public int getMantissa() {
		return mantissa;
	}

	public void setMantissa(int mantissa) {
		this.mantissa = mantissa;
		
	}

	public String toString(Calculadora calc) {
		return estado.toString(calc, this);
	}

	public void entraN() {
		estado = new ExpoenteState();
	}

	public int getExpoente() {
		return expoente;
	}
	
	public void setExpoente(int expoente) {
		this.expoente = expoente;
	}
	
	public StateEngenharia getEstado() {
		return estado;
	}

	public void setEstado(StateEngenharia novoEstado) {
		estado = novoEstado;
	}

}
