package hotel;
/**.
 * Descri��o:
 * Design Pattern Strategy - Hexadecimal
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 3     Data 30/04/2009
 */

public class HexStrategy implements Strategy
{
    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conte�do do operador
     */
    public String entraUm(Calculadora calc) {
		Numero operador = calc.getOperador();
		operador.entraUm(16);
		return operador.toString();
    }

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public String limpa(Calculadora calc) {
		calc.setAcumulador(new Numero(calc));
		calc.setOperador(new Numero(calc));
		return "0x0";
    }

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public String comandoSoma(Calculadora calc) {
		Numero acumulador = calc.getAcumulador();
		Numero operador = calc.getOperador();
		acumulador.somar(operador) ;
		calc.setOperador(new Numero(calc));
		return acumulador.toString();
    }

	public String converter(int valor) {
		return Integer.toString(valor, 16);
	}
	
	public String getRepresentacao() {
		return "0x";
	}
}
