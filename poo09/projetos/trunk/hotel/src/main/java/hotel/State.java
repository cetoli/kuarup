package hotel;

/**.
 * Descrição:
 * Design Pattern State
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 3     Data 30/04/2009
 */

public interface State {

	public void entraUm(int base, Numero num);
	
	public String toString(Calculadora calc, Numero num);
	
}
