package hotel;

/**.
 * Descri��o:
 * Estado onde ainda se est� trabalhando na parte real do n�mero
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 4     Data 05/04/2009
 */

public class RealState implements StateComplex {

    /**.
     * entra o valor 1
     * @param base corrente
     * @param objeto N�mero
     */
	public void entraUm(int base, Numero num) {
		num.getParteReal().entraUm(base);
	}
	
    /**.
     * converte objeto para String
     * @param Calculadora
     * @param objeto N�mero
     */
	public String toString(Calculadora calc, Numero num) {
		return num.getParteReal().toString(calc);
	}

    /**.
     * entraN
     * @param objeto N�mero
     */
	public void entraN(Numero num) {
		num.getParteReal().entraN();
	}

    /**.
     * um estado tem prioridade sobre o outro
     * @return prioridade
     */
	public int getPrioridade() {
		return 0;
	}
}
