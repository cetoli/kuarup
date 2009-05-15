package hotel;

/**
 * Classe que é um parser do valor em binário.
 * 
 * @author (Marcos de Castro) $Author$
 * @author (Rodrigo Santos Borges) $Author$
 * @version 1.0
 */
public class ValorBin extends Valor {
    private final int base = 2;

    /**
         * Construtor padrao.
         */
    public ValorBin() {
	super();
    }

    /**
         * Construtor com o valor em decimal sendo passado como parametro.
         * 
         * @param novo
         *                valor em decimal.
         */
    public ValorBin(int novo) {
	super(novo);
    }

    /**
         * Limpa o valor do armazenado.
         * 
         * @return retorna o valor convertido em String.
         */
    public String limparValor() {
	valor = 0;

	return converterEmString();
    }

    /**
         * Converte o valor de binário para decimal.
         * 
         * @param str
         *                Valor em binário.
         * 
         * @return valor em decimal.
         */
    private int converterBin(String str) {
	return Integer.parseInt(str, base);
    }

    /**
         * Converte para decimal e armazena o valor passado.
         * 
         * @param novo
         *                valor em binario.
         */
    public void setValor(String novo) {
	valor = converterBin(novo);
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
	return "0b" + Integer.toBinaryString(valor);
    }

    /**
         * Adiciona um novo dígito a direita do valor armazenado.
         * 
         * @param digito
         *                String com o valor do d�gito a ser inserido.
         * 
         * @return valor atualizado do objeto.
         */
    public String adicionarDigito(String digito) {
	impressao.adicionarDigito(this, digito);

	return converterEmString();
    }

    /**
         * Funcao que clona o elemento.
         * 
         * @return Retorna o objeto Valor clonado.
         */
    public Object clone() {
	return new ValorBin(this.valor);
    }

    public ValorBase copiar(ValorBase valor) {
	return (ValorBase) clone();
    }

    public void modoInteiro() {

    }

    public void modoComplexo() {

    }

    public ValorBase instanciarComplexo() {
	return new Complexo(this);
    }

    public ValorBase instanciarEngenharia() {
	return new Engenharia(this);
    }

}
