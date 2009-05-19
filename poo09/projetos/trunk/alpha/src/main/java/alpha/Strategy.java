package alpha;

/**.
 * Descrição:
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
     * @return conteúdo do operador
     */
    public String entraUm(Calculadora calc);

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String limpa(Calculadora calc);

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String comandoSoma(Calculadora calc);

    /**.
     * converte um número para uma String na sua base correspondente
     * @param valor
     * @return número convertido
     */
	public String converter(int valor);
	
    /**.
     * retorna a representação da base
     * @return representação
     */
	public String getRepresentacao();
}
