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


public class ComplexState implements State {
	
	public void entraUm(int base, Numero num) {
		int valorImaginario = num.getValorImaginario();
		valorImaginario *= base;
		valorImaginario++;
		num.setValorImaginario(valorImaginario);
	}
	
	public String toString(Calculadora calc, Numero num) {
		Strategy strategy = calc.getStrategy();
		String representacaoBase = strategy.getRepresentacao();
		String valorReal = strategy.converter(num.getValorReal());
		String valorImaginario = strategy.converter(num.getValorImaginario());
		return representacaoBase + valorReal + "I" + valorImaginario;
	}
}
