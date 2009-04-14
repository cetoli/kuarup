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
    private Integer acumulador = new Integer(0);
    /**. Operador da Caculadora. */
    private Integer operador = new Integer(0);
    /**. Estado da Calculadora (Binário, Hexadecimal ou Decimal) */
    private State estado = new Decimal();

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
        return estado.entraUm(this);
    }

    /**.
    * Limpa o acumulador.
    * @return  conteudo do acumulador
    */
    public final String limpa() {
        return estado.limpa(this);
    }

    /**.
    * Entra o comando soma.
    * @return  conteudo do acumulador
    */
    public final String comandoSoma() {
        return estado.comandoSoma(this);
    }

    /**.
    * Muda pro estado Binário
    */
    public void modoBin() {
        estado = new Binario();
    }

    /**.
    * Muda pro estado Decimal
    */
    public void modoDec() {
        estado = new Decimal();
    }

    /**.
    * Muda pro estado Hexadecimal
    */
    public void modoHex() {
        estado = new Hexadecimal();
    }

    /**.
    * @return acumulador
    */
    public Integer getAcumulador() {
        return acumulador;
    }

    /**.
    * @return operador
    */
    public Integer getOperador() {
        return operador;
    }

    /**.
    * setOperador
    * @param operador
    */
    public void setOperador(Integer op) {
        this.operador = op;
    }

    /**.
    * setAcumulador
    * @param acumulador
    */
    public void setAcumulador(Integer ac) {
        this.acumulador = ac;
    }
}
