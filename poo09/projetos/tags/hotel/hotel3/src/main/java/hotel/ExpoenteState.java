package hotel;

/**.
 * Descri��o:
 * Design Pattern State - Expoente
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 4     Data 05/04/2009
 */

public class ExpoenteState implements StateEngenharia {

    /**.
     * converte objeto para String
     * @param Calculadora
     * @param objeto Parte
     */
	public String toString(Calculadora calc, Parte parte) {
		Strategy strategy = calc.getStrategy();
		String representacaoBase = strategy.getRepresentacao();
		return representacaoBase + strategy.converter(parte.getMantissa()) + "N" + strategy.converter(parte.getExpoente());
	}

    /**.
     * entra o valor 1
     * @param base corrente
     * @param objeto Parte
     */
	public void entraUm(int base, Parte parte) {
		int expoente = parte.getExpoente();
		expoente *= base;
		expoente++;
		parte.setExpoente(expoente);
	}
	
    /**.
     * um estado tem prioridade sobre o outro
     * @return prioridade
     */
	public int getPrioridade() {
		return 1;
	}
}
