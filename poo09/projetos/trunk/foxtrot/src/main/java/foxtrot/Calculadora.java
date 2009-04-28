package foxtrot;
import labase.poo.ICalculadoraBase;

/**.
 * Descrição:
 * Calculadora que exerce somente as funções de soma, limpa e tecla 1
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferrão
 *
 * @version 3     Data 07/04/2009
 */


public class Calculadora implements ICalculadoraBase {
    /**. Acumulador da Caculadora. */
    private State acumulador = new Decimal(0);
    /**. Operador da Caculadora. */
    private State operador = new Decimal(0);


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
        return operador.entraUm(this);
    }

    /**.
    * Limpa o acumulador.
    * @return  conteudo do acumulador
    */
    public final String limpa() {
    	operador.limpa(this);
        return acumulador.limpa(this);
    }

    /**.
    * Entra o comando soma.
    * @return  conteudo do acumulador
    */
    public final String comandoSoma() {
        String str= acumulador.comandoSoma(this);
        operador.limpa(this);

        return str;
    }

    /**.
    * Muda pro estado Binário
    */
    public void modoBin() {
        operador = operador.modoBin();
        acumulador = acumulador.modoBin();

    }

    /**.
    * Muda pro estado Decimal
    */
    public void modoDec() {
    	operador = operador.modoDec();
    	acumulador = acumulador.modoDec();
    }

    /**.
    * Muda pro operador Hexadecimal
    */
    public void modoHex() {
    	operador = operador.modoHex();
    	acumulador = acumulador.modoHex();
    }

    /**
     * Muda pro operador Complexo.
     * @throws CloneNotSupportedException
     */
     public void modoComplexo() {
    	//comandoSoma();
        try
		{
			operador = new Complexo(0,acumulador);
			acumulador = new Complexo(0,acumulador);
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace ();
		}
     }

    /**.
    * @return acumulador
    */
    public State getAcumulador() {
        return acumulador;
    }

    /**.
    * @return operador
    */
    public State getOperador() {
        return operador;
    }

    /**.
    * setOperador
    * @param operador
    */
    public void setOperador(State op) {
        this.operador = op;
    }

    /**.
    * setAcumulador
    * @param acumulador
    */
    public void setAcumulador(State ac) {
        this.acumulador = ac;
    }

}
