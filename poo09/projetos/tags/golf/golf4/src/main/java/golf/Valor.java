package golf;


/**
 * Classe que representa o valor armazenado em decimal.
 *
 * @author  (Marcos de Castro)  $Author$
 * @author  (Rodrigo Santos Borges)  $Author$
 * @version 1.0
 */
public class Valor extends ValorBase {
    /**
     * Construtor padrao.
     */
    public Valor() {
    }

    /**
     * Construtor com o valor em decimal sendo passado como
     * parametro.
     * @param novo valor em decimal.
     */
    public Valor(int novo) {
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
    public String adicionarDigito(String digito, ImpressaoStrategy modo, ImpressaoStrategy modoImpressao) {
	impressao = modo;
	impressao.adicionarDigito(this, digito);

        return converterEmString();
    }

    /**
     * Altera o valor armazenado.
     * @param novo valor em formato String.
     */
    public void setValor(String novo) {
        valor = Integer.parseInt(novo);
    }

    /**
     * Converte em string o valor.
     */
    public String toString() {
        return String.valueOf(valor);
    }


    /**
     * Converte o valor em string.
     * @return retorna o valor convertido em String.
     */
    public String converterEmString() {
        return impressao.imprimir(this);
    }

	public void impressaoBin () {
	    impressao = impressao.modoBinario();
	}

	public void impressaoDec () {
	    impressao = impressao.modoDecimal();
	}

	public void impressaoHexa () {
	    impressao = impressao.modoHexadecimal();
	}

    public ValorBase modoHexa() {
    	impressao = new ImpressaoHexadecimalStrategy();
        return this;
    }

    public ValorBase modoDec() {
    	impressao = new ImpressaoDecimalStrategy();
    	return this;
    }

    public ValorBase modoBin() {
    	impressao = new ImpressaoBinarioStrategy();
    	return this;
    }

    /**
     * Funcao que clona o  elemento.
     * @return Retorna o objeto Valor clonado.
     */
    public Object clone() {
        Valor v = new Valor(this.valor);

        try {
	    v.impressao = (ImpressaoStrategy) this.impressao.clone();
	} catch (CloneNotSupportedException e) {
	    e.printStackTrace ();
	}

        return v;
    }

    public ValorBase copiar(Valor valor) {
    	return (Valor) clone();
    }

    public void modoInteiro() {

    }

    public void modoComplexo() {

    }

    public Complexo instanciarComplexo() {
    	return new Complexo(this);
    }

    public ValorBase instanciarEngenharia() {
    	return new Engenharia(this);
    }

    public Engenharia aceitarVisitaEngenharia(VisitorSoma soma) {
    	return null;
    }

    /**
     * O operador chama o visitor.
     * @param visitor visitor.
     * @param acumulador.
     */
    public ValorBase aceitarVisita(Visitor visitor, Valor acumulador) {

    	return visitor.visitar(acumulador, this);
    }

    /**
     * O operador chama o visitor.
     * @param visitor visitor.
     * @param acumulador.
     */
    public ValorBase aceitarVisita(Visitor visitor, Complexo acumulador) {

    	ValorBase v = acumulador.getValorInteiro();
    	v.aceitarVisita (visitor, this);

    	// ???
    	return visitor.visitar(acumulador, this);
    }

    /**
     * O operador chama o visitor.
     * @param visitor visitor.
     * @param acumulador.
     */
    public ValorBase aceitarVisita(Visitor visitor, Engenharia acumulador) {

    	return visitor.visitar(acumulador, this);
    }

    /**
     * Acumulador recebe um pedido de soma.
     *
     * @param obj operador.
     */
    public ValorBase somar (ValorBase obj)
    {
    	Visitor visitor= new VisitorSoma();
    	return obj.aceitarVisita(visitor, this);
    }

    public ImpressaoStrategy getModoImpressao() {
        return impressao;
    }

}
