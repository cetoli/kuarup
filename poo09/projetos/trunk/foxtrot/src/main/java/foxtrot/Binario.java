package foxtrot;


/**.
 * Descri��o:
 * Design Pattern State - Estado Bin�rio
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferr�o
 *
 * @version 3     Data 07/04/2009
 */
public class Binario extends State
{
    public Binario(int inicial) {
        //str= Integer.toString(inicial);
        valor= inicial;
    }

    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conte�do do operador
     */
    public String entraUm(Calculadora calc) {
        String operadorBin = Integer.toBinaryString(valor);
        operadorBin += "1";
        valor = Integer.parseInt(operadorBin, 2);

        return toString();
    }

    /**
     * retorna a representa��o em String.
     */
    public String toString() {
    	return "0b" + Integer.toBinaryString(intValue());
    }

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public String limpa(Calculadora calc) {
        valor= 0;
        return "0b0";
    }

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public String comandoSoma(Calculadora calc) {
        Integer operador = calc.getOperador().intValue();
        valor += operador.intValue();
        operador = 0;

        return toString();
    }
}
