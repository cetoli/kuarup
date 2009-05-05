package hotel;

/**.
 * Descrição:
 * Design Pattern State - Estados da notação de Engenharia
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 4     Data 05/04/2009
 */

public interface StateEngenharia {

    /**.
     * converte objeto para String
     * @param Calculadora
     * @param objeto Parte
     */
	public String toString(Calculadora calc, Parte parte);
	
    /**.
     * entra o valor 1
     * @param base corrente
     * @param objeto Parte
     */
	public void entraUm(int base, Parte parte);
	
    /**.
     * um estado tem prioridade sobre o outro
     * @return prioridade
     */
	public int getPrioridade();
	
}
