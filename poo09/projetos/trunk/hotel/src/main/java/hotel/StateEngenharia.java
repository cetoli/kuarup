package hotel;

public interface StateEngenharia {

	public String toString(Calculadora calc, Parte parte);
	
	public void entraUm(int base, Parte parte);
	
	public int getPrioridade();
	
}
