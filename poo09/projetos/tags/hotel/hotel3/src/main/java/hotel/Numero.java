package hotel;

/**.
 * Descrição:
 * Representação de um número complexo
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 4     Data 05/04/2009
 */

public class Numero {
	
	private Parte valorReal;
	private Parte valorImaginario;
	private Calculadora calculadora;
	private StateComplex estado;
	
    /**.
     * construtor
     * @param Calculadora
     */
	public Numero(Calculadora calc) {
		this.calculadora = calc;
		valorReal = new Parte();
		valorImaginario = new Parte();
		estado = new RealState();
	}

    /**.
     * entra o valor 1
     * @param base corrente
     */
	public void entraUm(int base) {
		estado.entraUm(base, this);
	}
	
    /**.
     * converte objeto para String
     * @param Calculadora
     * @param objeto Parte
     */
	public String toString() {
		return estado.toString(calculadora, this);
	}
	
    /**.
     * soma levando em consideração os expoentes
     * @param Numero
     * @return String com o resultado
     */
	public String somar(Numero num) {
		
		if(valorReal.getExpoente() < num.getValorReal().getExpoente())
		{
			valorReal.setMantissa(num.getValorReal().getMantissa());
			valorReal.setExpoente(num.getValorReal().getExpoente());
		}
		else if (valorReal.getExpoente() == num.getValorReal().getExpoente())
		{
			valorReal.setMantissa(valorReal.getMantissa() + num.getValorReal().getMantissa());
		}

		if(valorImaginario.getExpoente() < num.getValorImaginario().getExpoente())
		{
			valorImaginario.setMantissa(num.getValorImaginario().getMantissa());
			valorImaginario.setExpoente(num.getValorImaginario().getExpoente());
		}
		else if (valorImaginario.getExpoente() == num.getValorImaginario().getExpoente())
		{
			valorImaginario.setMantissa(valorImaginario.getMantissa() + num.getValorImaginario().getMantissa());
		}

		return toString();
	}

    /**.
     * get
     * @return Parte
     */
	public Parte getValorImaginario() {
		return valorImaginario;
	}

    /**.
     * get
     * @return Parte
     */
	public Parte getValorReal() {
		return valorReal;
	}

    /**.
     * set
     * @param Parte
     */
	public void setValorReal(Parte novoValor) {
		valorReal = novoValor;
	}
	
    /**.
     * set
     * @param Parte
     */
	public void setValorImaginario(Parte novoValor) {
		valorImaginario = novoValor;
	}

    /**.
     * Indica que os próximos valores entrados serão irreais
     */
	public void entraI() {
		estado = new ComplexState();
	}
	
    /**.
     * Indica que os próximos valores entrados serão irreais
     */
	public void entraN() {
		estado.entraN(this);
	}

    /**.
     * get
     * @return Parte
     */
	public Parte getParteReal() {
		return valorReal;
	}

    /**.
     * get
     * @return Parte
     */
	public Parte getParteImaginaria() {
		return valorImaginario;
	}

    /**.
     * get
     * @return StateComplex
     */
	public StateComplex getEstado() {
		return estado;
	}

    /**.
     * set
     * @param StateComplex
     */
	public void setEstado(StateComplex novoEstado) {
		estado = novoEstado;
	}
}
