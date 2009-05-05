package hotel;

/**.
 * Descrição:
 * Design Pattern StateComplex
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 3     Data 30/04/2009
 */

public interface StateComplex {

	public int getPrioridade();

	public void entraUm(int base, Numero num);
	
	public void entraN(Numero num);
	
	public String toString(Calculadora calc, Numero num);
	
}
