package hotel;

/**.
 * Descri��o:
 * Estado onde ainda se est� trabalhando na parte imagin�ria do n�mero
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 3     Data 30/04/2009
 */


public class ComplexState implements StateComplex {
	
	public void entraUm(int base, Numero num) {
		num.getParteImaginaria().entraUm(base);
	}
	
	public String toString(Calculadora calc, Numero num) {
		return num.getParteReal().toString(calc) + "I" + num.getParteImaginaria().toString(calc);
	}

	public void entraN(Numero num) {
		num.getParteImaginaria().entraN();
	}

	public int getPrioridade() {
		return 1;
	}

}
