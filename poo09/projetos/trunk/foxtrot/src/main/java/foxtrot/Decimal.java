package foxtrot;

/**.
 * Descri��o:
 * Design Pattern State - Estado Decimal
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferr�o
 *
 * @version 3     Data 14/04/2009
 */

public class Decimal implements State
{
    /**.
     * entra o valor 1 no operador
     * @return conte�do do operador
     */
    public String entraUm(Calculadora calc) {
		Integer operador = calc.getOperador();
		operador *= 10;
		operador++;
		calc.setOperador(operador);
		return operador.toString();
    }

    /**.
     * limpa o acumulador e o operador
     * @return conte�do do acumulador
     */
    public String limpa(Calculadora calc) {
		calc.setAcumulador(0);
		calc.setOperador(0);
		return "0";
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
		calc.setOperador(operador);
		calc.setAcumulador(acumulador);
		return acumulador.toString();
    }
}
