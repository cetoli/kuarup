package alpha;

/**.
 * Descri��o:
 * Design Pattern Strategy
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Diego Mury G. de Lima
 *
 * @version 5     Data 19/05/2009
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

    /**.
     * converte um n�mero para uma String na sua base correspondente
     * @param valor
     * @return n�mero convertido
     */
	public String converter(int valor);
	
    /**.
     * retorna a representa��o da base
     * @return representa��o
     */
	public String getRepresentacao();
}
