package hotel;

/**.
 * Descrição:
 * Estado onde ainda se está trabalhando na parte imaginária do número
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 4     Data 05/04/2009
 */

public class ComplexState implements StateComplex {
	
    /**.
     * entra o valor 1
     * @param base corrente
     * @param objeto Número
     */
	public void entraUm(int base, Numero num) {
		num.getParteImaginaria().entraUm(base);
	}
	
    /**.
     * converte objeto para String
     * @param Calculadora
     * @param objeto Número
     */
	public String toString(Calculadora calc, Numero num) {
		return num.getParteReal().toString(calc) + "I" + num.getParteImaginaria().toString(calc);
	}

    /**.
     * entraN
     * @param objeto Número
     */
	public void entraN(Numero num) {
		num.getParteImaginaria().entraN();
	}

    /**.
     * um estado tem prioridade sobre o outro
     * @return prioridade
     */
	public int getPrioridade() {
		return 1;
	}

}
