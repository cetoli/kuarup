package alpha;

/**.
 * Descrição:
 * Design Pattern Strategy - Hexadecimal
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Diego Mury G. de Lima
 *
 * @version 5     Data 19/05/2009
 */

public class HexStrategy implements Strategy
{
    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conteúdo do operador
     */
    public String entraUm(Calculadora calc) {
		Numero operador = calc.getOperador();
		operador.entraUm(16);
		return operador.toString();
    }

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conteúdo do acumulador
     */
    public String limpa(Calculadora calc) {
		calc.setAcumulador(new Numero(calc));
		calc.setOperador(new Numero(calc));
		return "0x0";
    }

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conteúdo do acumulador
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
     * converte um número para uma String na sua base correspondente
     * @param valor
     * @return número convertido
     */
	public String converter(int valor) {
		return Integer.toString(valor, 16);
	}
	
    /**.
     * retorna a representação da base
     * @return representação
     */
	public String getRepresentacao() {
		return "0x";
	}
}
