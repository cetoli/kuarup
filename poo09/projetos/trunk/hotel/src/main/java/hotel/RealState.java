package hotel;

/**.
 * Descri��o:
 * Estado onde ainda se est� trabalhando na parte real do n�mero
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 3     Data 30/04/2009
 */

public class RealState implements StateComplex {

	public void entraUm(int base, Numero num) {
		num.getParteReal().entraUm(base);
	}
	
	public String toString(Calculadora calc, Numero num) {
		return num.getParteReal().toString(calc);
	}

	public void entraN(Numero num) {
		num.getParteReal().entraN();
	}

	public int getPrioridade() {
		return 0;
	}
}
