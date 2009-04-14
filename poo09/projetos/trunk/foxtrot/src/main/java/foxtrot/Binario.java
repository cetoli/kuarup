package foxtrot;


/**.
 * Descrição:
 * Design Pattern State - Estado Binário
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferrão
 *
 * @version 3     Data 07/04/2009
 */
public class Binario implements State
{
    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conteúdo do operador
     */
    public String entraUm(Calculadora calc) {
		Integer operador = calc.getOperador();
		String operadorBin = Integer.toBinaryString(operador.intValue());
		operadorBin += "1";
		operador = Integer.parseInt(operadorBin, 2);
		calc.setOperador(operador);
		return "0b" + Integer.toBinaryString(operador.intValue());
    }

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String limpa(Calculadora calc) {
		calc.setAcumulador(0);
		calc.setOperador(0);
		return "0b0";
    }

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String comandoSoma(Calculadora calc) {
		Integer acumulador = calc.getAcumulador();
		Integer operador = calc.getOperador();
		acumulador += operador ;
		operador = 0;
		calc.setAcumulador(acumulador);
		calc.setOperador(operador);
		return "0b" + Integer.toBinaryString(acumulador.intValue());
    }
}
