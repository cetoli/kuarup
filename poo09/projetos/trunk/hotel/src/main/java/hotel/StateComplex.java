package hotel;

/**.
 * Descri��o:
 * Design Pattern State - Estados da nota��o de n�mero complexo
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 4     Data 05/04/2009
 */

public interface StateComplex {

    /**.
     * um estado tem prioridade sobre o outro
     * @return prioridade
     */
	public int getPrioridade();

    /**.
     * entra o valor 1
     * @param base corrente
     * @param objeto N�mero
     */
	public void entraUm(int base, Numero num);
	
    /**.
     * entraN
     * @param objeto N�mero
     */
	public void entraN(Numero num);
	
    /**.
     * converte objeto para String
     * @param Calculadora
     * @param objeto N�mero
     */
	public String toString(Calculadora calc, Numero num);
	
}
