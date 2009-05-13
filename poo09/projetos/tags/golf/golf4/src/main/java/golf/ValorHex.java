package golf;

/**
 * Classe que é um parser do valor em hexadecimal.
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version 1.0
 */
public class ValorHex extends Valor {
    private final int base = 16;

    /**
     * Construtor padrao.
     */
    public ValorHex() {
    	super();
    }

    /**
     * Construtor com o valor em decimal sendo passado como
     * parametro.
     * @param novo valor em decimal.
     */
    public ValorHex(int novo) {
    	super(novo);
    }

    /**
     * Limpa o valor do armazenado.
     * @return retorna o valor convertido em String.
     */
    public String limparValor() {
        valor = 0;

        return converterEmString ();
    }

    /**
     * Converte o valor de hexadecimal para decimal.
     *
     * @param  str Valor em hexadecimal.
     *
     * @return valor em decimal.
     */
    private int converterHex(final String str) {
        return Integer.parseInt(str, base);
    }

    /**
     * Converte para decimal e armazena o valor passado.
     *
     * @param novo valor em hexadecimal.
     */
    public void setValor(final String novo) {
        valor = converterHex(novo);
    }

    /**
     * Converte o valor armazenado em String hexadecimal.
     *
     * @return String hexadecimal.
     */
    public String converterEmString() {
        return impressao.imprimir(this);

    }

    /**
     * Converte em string o valor.
     */
    public String toString() {
        return "0x" + Integer.toHexString(valor);
    }

    /**
     * Adiciona um novo dígito a direita do valor armazenado.
     *
     * @param digito String com o valor do dígito a ser inserido.
     *
     * @return valor atualizado do objeto.
     */
    public String adicionarDigito(final String digito) {
	impressao.adicionarDigito(this, digito);

        return converterEmString();
    }

    /**
     * Funcao que clona o  elemento.
     * @return Retorna o objeto Valor clonado.
     */
    public Object clone () {
        return new ValorHex(this.valor);
    }

    public ValorBase copiar(ValorBase valor) {
    	return (ValorBase) clone();
    }

    public void modoInteiro() {

    }

    public void modoComplexo() {

    }

    public Complexo instanciarComplexo() {
    	return new Complexo(this);
    }

    public ValorBase instanciarEngenharia () {
    	return new Engenharia(this);
    }

}
