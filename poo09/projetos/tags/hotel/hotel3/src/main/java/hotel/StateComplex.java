package hotel;

/**.
 * Descrição:
 * Design Pattern State - Estados da notação de número complexo
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
     * @param objeto Número
     */
	public void entraUm(int base, Numero num);
	
    /**.
     * entraN
     * @param objeto Número
     */
	public void entraN(Numero num);
	
    /**.
     * converte objeto para String
     * @param Calculadora
     * @param objeto Número
     */
	public String toString(Calculadora calc, Numero num);
	
}
