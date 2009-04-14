package foxtrot;

/**.
 * Descri��o:
 * Design Pattern State - Estado Hexadecimal
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferr�o
 *
 * @version 3     Data 14/04/2009
 */
public class Hexadecimal implements State
{
    /**.
     * entra o valor 1 no operador
     * @return conte�do do operador
     */
    public String entraUm(Calculadora calc) {
		Integer operador = calc.getOperador();
		String hexadecimal = Integer.toHexString(operador);
		hexadecimal += "1";
		operador = Integer.parseInt(hexadecimal, 16);
		calc.setOperador(operador);
		return "0x" + Integer.toHexString(operador);
    }

    /**.
     * limpa o acumulador e o operador
     * @return conte�do do acumulador
     */
    public String limpa(Calculadora calc) {
		calc.setAcumulador(0);
		calc.setOperador(0);
		return "0x0";
    }

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @return conte�do do acumulador
     */
    public String comandoSoma(Calculadora calc) {
		Integer acumulador = calc.getAcumulador();
		Integer operador = calc.getOperador();
		acumulador += operador ;
		operador = 0;
		calc.setAcumulador(acumulador);
		calc.setOperador(operador);
		return "0x" + Integer.toHexString(acumulador);
    }
}
