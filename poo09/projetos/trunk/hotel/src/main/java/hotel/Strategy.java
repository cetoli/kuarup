package hotel;

/**.
 * Descri��o:
 * Design Pattern Strategy
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 3     Data 30/04/2009
 */

public interface Strategy
{
    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conte�do do operador
     */
    public String entraUm(Calculadora calc);

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public String limpa(Calculadora calc);

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public String comandoSoma(Calculadora calc);

	public String converter(int valor);
	
	public String getRepresentacao();
}
