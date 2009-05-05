package hotel;
import labase.poo.ICalculadoraBase;

/**.
 * Descrição:
 * Calculadora que exerce somente as funções de soma, limpa, tecla 1, números complexos e mudança de base
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
    /**. Estado da Calculadora (Binário, HexStrategy ou DecStrategy) */
    private Strategy strategy = new DecStrategy();

    /**.
    * Construtor para objetos da classe Calculadora.
    */
    public Calculadora() {
        // inicializa variaveis de instância
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
    * Muda pro strategy Binário
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
     * Indica que os próximos valores entrados serão irreais
     */
     public void entraI() {
         operador.entraI();
         //acumulador.entraI();
     }

     /**.
      * Indica que os próximos valores entrados serão irreais
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
