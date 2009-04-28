package foxtrot;

/**.
 * Descrição:
 * Design Pattern State - Estado Hexadecimal
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferrão
 *
 * @version 3     Data 14/04/2009
 */
public class Hexadecimal extends State
{

    public Hexadecimal(int inicial) {
        //str= Integer.toString(inicial);
        valor= inicial;

    }

    /**
     * retorna a representação em String.
     */
    public String toString() {
    	return "0x" + Integer.toHexString(intValue());
    }

    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conteúdo do operador
     */
    public String entraUm(Calculadora calc) {
        String hexadecimal = Integer.toHexString(valor);
        hexadecimal += "1";
        valor = Integer.parseInt(hexadecimal, 16);

        return toString();
    }

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String limpa(Calculadora calc) {
        valor= 0;
        return "0x0";
    }

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String comandoSoma(Calculadora calc) {
        Integer operador = calc.getOperador().intValue();
        valor += operador.intValue();
        operador = 0;

        return toString();
    }
}
