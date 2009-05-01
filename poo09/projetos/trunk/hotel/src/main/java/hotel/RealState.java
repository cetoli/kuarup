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

public class RealState implements State {

	public void entraUm(int base, Numero num) {
		int valorReal = num.getValorReal();
		valorReal *= base;
		valorReal++;
		num.setValorReal(valorReal);
	}
	
	public String toString(Calculadora calc, Numero num) {
		Strategy strategy = calc.getStrategy();
		String representacaoBase = strategy.getRepresentacao();
		return representacaoBase + strategy.converter(num.getValorReal());
	}
}
