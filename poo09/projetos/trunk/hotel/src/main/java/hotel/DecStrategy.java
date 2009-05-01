package hotel;
/**.
 * Descrição:
 * Design Pattern Strategy - Decimal
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 3     Data 30/04/2009
 */

public class DecStrategy implements Strategy
{
    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conteúdo do operador
     */
    public String entraUm(Calculadora calc) {
		Numero operador = calc.getOperador();
		operador.entraUm(10);
		return operador.toString();
    }

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String limpa(Calculadora calc) {
		calc.setAcumulador(new Numero(calc));
		calc.setOperador(new Numero(calc));
		return "0";
    }

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String comandoSoma(Calculadora calc) {
		Numero acumulador = calc.getAcumulador();
		Numero operador = calc.getOperador();
		acumulador.somar(operador) ;
		calc.setOperador(new Numero(calc));
		return acumulador.toString();
    }

	public String converter(int valor) {
		return Integer.toString(valor);
	}
	
	public String getRepresentacao() {
		return "";
	}
}
