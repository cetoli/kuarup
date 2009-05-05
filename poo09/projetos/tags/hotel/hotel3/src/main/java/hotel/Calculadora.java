package hotel;
import labase.poo.ICalculadoraBase;

/**.
 * Descri��o:
 * Calculadora que exerce somente as fun��es de soma, limpa, tecla 1, n�meros complexos e mudan�a de base
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Alexandre Neves Louzada
 *
 * @version 4     Data 05/04/2009
 */


public class Calculadora implements ICalculadoraBase {
    /**. Acumulador da Caculadora. */
    private Numero acumulador = new Numero(this);
    /**. Operador da Caculadora. */
    private Numero operador = new Numero(this);
    /**. Estado da Calculadora (Bin�rio, HexStrategy ou DecStrategy) */
    private Strategy strategy = new DecStrategy();

    /**.
    * Construtor para objetos da classe Calculadora.
    */
    public Calculadora() {
        // inicializa variaveis de inst�ncia
    }

    /**.
    * Entra a tecla um.
    * @return  conteudo do operador
    */
    public final String entraUm() {
        return strategy.entraUm(this);
    }

    /**.
    * Limpa o acumulador.
    * @return  conteudo do acumulador
    */
    public final String limpa() {
        return strategy.limpa(this);
    }

    /**.
    * Entra o comando soma.
    * @return  conteudo do acumulador
    */
    public final String comandoSoma() {
        return strategy.comandoSoma(this);
    }

    /**.
    * Muda pro strategy Bin�rio
    */
    public void modoBin() {
        strategy = new BinStrategy();
    }

    /**.
    * Muda pro strategy DecStrategy
    */
    public void modoDec() {
        strategy = new DecStrategy();
    }

    /**.
    * Muda pro strategy HexStrategy
    */
    public void modoHex() {
        strategy = new HexStrategy();
    }

    /**.
     * Indica que os pr�ximos valores entrados ser�o irreais
     */
     public void entraI() {
         operador.entraI();
         //acumulador.entraI();
     }

     /**.
      * Indica que os pr�ximos valores entrados ser�o irreais
      */
      public void entraN() {
          operador.entraN();
          //acumulador.entraN();
      }

    /**.
    * @return acumulador
    */
    public Numero getAcumulador() {
        return acumulador;
    }

    /**.
    * @return operador
    */
    public Numero getOperador() {
        return operador;
    }

    /**.
    * setOperador
    * @param operador
    */
    public void setOperador(Numero op) {
        this.operador = op;
    }

    /**.
    * setAcumulador
    * @param acumulador
    */
    public void setAcumulador(Numero ac) {
        this.acumulador = ac;
    }

	public Strategy getStrategy() {
		return strategy;
	}
}
