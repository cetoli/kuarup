package foxtrot;

/**.
 * Descri��o:
 * Design Pattern State
 *
 * @author Carlos Henrique Pinto Rodriguez
 * @author Carlos Eduardo Ferr�o
 *
 * @version 3     Data 14/04/2009
 */

public abstract class State implements Cloneable
{
	//protected String str;
    protected int valor;

    /**.
     * entra o valor 1 no operador
     * @param calculadora
     * @return conte�do do operador
     */
    public abstract String entraUm(Calculadora calc);

    /**.
     * limpa o acumulador e o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public abstract String limpa(Calculadora calc);

    /**.
     * soma o acumulador com o operador, guarda em acumulador e limpa o operador
     * @param calculadora
     * @return conte�do do acumulador
     */
    public abstract String comandoSoma(Calculadora calc);

    public void setValor (int valorDecimal)
    {
        valor= valorDecimal;
    }

    /**
     * Obt�m o valor inteiro.
     *
     * @return retorna o objeto Integer relativo ao valor.
     */
    public Integer intValue ()
    {
        return new Integer (valor);
    }

    /**
     * Clona a inst�ncia.
     */
	protected Object clone () throws CloneNotSupportedException
	{
		return super.clone ();
	}

	public State modoHex() {
		return new Hexadecimal(valor);
	}

	public State modoBin() {
		return new Binario(valor);
	}

	public State modoDec() {
		return new Decimal(valor);
	}

}
