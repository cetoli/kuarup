package alpha;

/**.
 * Descrição:
 * Parte do número (tem a imaginário e a real)
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Diego Mury G. de Lima
 *
 * @version 5     Data 19/05/2009
 */

public class Parte {

	protected int mantissa;
	protected int expoente;
	protected StateEngenharia estado;
	
    /**.
     * construtor
     */
	public Parte() {
		mantissa = 0;
		expoente = 0;
		estado = new MantissaState();
	}
	
    /**.
     * entra o valor 1
     * @param base corrente
     */
	public void entraUm(int base) {
		estado.entraUm(base, this);
	}

    /**.
     * get
     * @return int mantissa
     */
	public int getMantissa() {
		return mantissa;
	}

    /**.
     * set
     * @param int mantissa
     */
	public void setMantissa(int mantissa) {
		this.mantissa = mantissa;
		
	}

    /**.
     * converte objeto para String
     * @param Calculadora
     * @return String
     */
	public String toString(Calculadora calc) {
		return estado.toString(calc, this);
	}

    /**.
     * Indica que os próximos valores entrados serão irreais
     */
	public void entraN() {
		estado = new ExpoenteState();
	}

    /**.
     * get
     * @return int mantissa
     */
	public int getExpoente() {
		return expoente;
	}
	
    /**.
     * set
     * @param int expoente
     */	public void setExpoente(int expoente) {
		this.expoente = expoente;
	}
	
    /**.
     * get
     * @return int mantissa
     */
	public StateEngenharia getEstado() {
		return estado;
	}

    /**.
     * set
     * @param novo estado 
     */	public void setEstado(StateEngenharia novoEstado) {
		estado = novoEstado;
	}

}
