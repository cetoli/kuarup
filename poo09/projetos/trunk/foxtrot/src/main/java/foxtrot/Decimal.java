package foxtrot;

import com.sun.org.apache.xpath.internal.functions.Function;

/**.
 * Descrição:
 * Design Pattern State - Estado Decimal
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferrão
 *
 * @version 3     Data 14/04/2009
 */

public class Decimal extends State
{

    public Decimal(int inicial) {
        //str= Integer.toString(inicial);
        valor= inicial;
    }

    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conteúdo do operador
     */
    public String entraUm(Calculadora calc) {
        valor *= 10;
        valor++;

        return toString();
    }

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String limpa(Calculadora calc) {
        valor= 0;
        return "0";
    }

    /**
     * retorna a representação em String.
     */
    public String toString() {
    	return Integer.toString(valor);
    }

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String comandoSoma(Calculadora calc) {
        Integer operador = calc.getOperador().intValue();
        valor += operador.intValue();

        return toString();
    }
}
