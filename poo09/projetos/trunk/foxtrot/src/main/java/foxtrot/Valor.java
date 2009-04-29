package foxtrot;


/**
 * Classe que representa o valor armazenado em decimal.
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version 1.0
 */
public class Valor implements Cloneable
{
    /**
     * Variavel que armazena, em decimal, o valor do
     * objeto.
     */
    protected int valor;

    /**
     * Construtor padrao.
     */
    public Valor() {

        valor = 0;
    }

    /**
     * Construtor com o valor em decimal sendo passado como
     * parametro.
     * @param novo valor em decimal.
     */
    public Valor(int novo) {

        valor = novo;
    }

    /**
     * Limpa o valor do armazenado.
     * @return retorna o valor convertido em String.
     */
    public String limparValor() {
        valor = 0;

        return converterEmString ();
    }

    public String toString() {
        return converterEmString ();
    }

    /**
     * Retorna o valor.
     * @return retorna o valor armazenado.
     */
    public final int getValor() {
        return valor;
    }

    /**
     * Adiciona um digito a direita do valor atual.
     * @param d�gito a ser acrescentado.
     * @return retorna o valor armazenado no formato String.
     */
    public String adicionarDigito(String digito) {
        String str = converterEmString () + digito;

        valor = Integer.parseInt(str);

        return converterEmString();
    }

    /**
     * Altera o valor armazenado.
     * @param novo valor em hexadecimal.
     */
    public void setValor(String novo) {
        valor = Integer.parseInt(novo);
    }

    /**
     * Converte o valor em string.
     * @return retorna o valor convertido em String.
     */
    public String converterEmString() {
        return String.valueOf(valor);
    }

    /**
     * Soma o valor do objeto passado como parametro com o seu valor.
     * @param valor a ser somado.
     */
    public void somar(Valor objOp2) {
        int op2 = objOp2.getValor();

        valor += op2;

    }

    public Valor modoHexa() {
        return new ValorHex(valor);
    }

    public Valor modoDec() {
    	return new Valor(valor);
    }

    public Valor modoBin() {
    	return new ValorBin(valor);
    }

    /**
     * Funcao que clona o  elemento.
     * @return Retorna o objeto Valor clonado.
     */
    public Object clone () {
        return new Valor(this.valor);
    }

    public Valor copiar(Valor valor) {
    	return (Valor) clone();
    }

    public void modoInteiro() {

    }

    public void modoComplexo() {

    }

    public Complexo instanciarComplexo() {
    	return new Complexo(this);
    }

	public void somarTudo (Valor atual) {
		somar (atual);
	}
}
