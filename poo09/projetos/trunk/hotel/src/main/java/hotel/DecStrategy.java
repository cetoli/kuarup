package hotel;
/**.
 * Descri��o:
 * Design Pattern Strategy - Decimal
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 4     Data 05/04/2009
 */

public class DecStrategy implements Strategy
{
    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conte�do do operador
     */
    public String entraUm(Calculadora calc) {
		Numero operador = calc.getOperador();
		operador.entraUm(10);
		return operador.toString();
    }

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public String limpa(Calculadora calc) {
		calc.setAcumulador(new Numero(calc));
		calc.setOperador(new Numero(calc));
		return "0";
    }

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public String comandoSoma(Calculadora calc) {
		Numero acumulador = calc.getAcumulador();
		Numero operador = calc.getOperador();
		acumulador.somar(operador); 
		calc.setOperador(new Numero(calc));
		if(operador.getEstado().getPrioridade() > acumulador.getEstado().getPrioridade())
			acumulador.setEstado(operador.getEstado());
		if(operador.getParteReal().getEstado().getPrioridade() > acumulador.getParteReal().getEstado().getPrioridade())
			acumulador.getParteReal().setEstado(operador.getParteReal().getEstado());
		if(operador.getParteImaginaria().getEstado().getPrioridade() > acumulador.getParteImaginaria().getEstado().getPrioridade())
			acumulador.getParteImaginaria().setEstado(operador.getParteImaginaria().getEstado());

		return calc.getAcumulador().toString();
    }

    /**.
     * converte um n�mero para uma String na sua base correspondente
     * @param valor
     * @return n�mero convertido
     */
	public String converter(int valor) {
		return Integer.toString(valor);
	}
	
    /**.
     * retorna a representa��o da base
     * @return representa��o
     */
	public String getRepresentacao() {
		return "";
	}
}
