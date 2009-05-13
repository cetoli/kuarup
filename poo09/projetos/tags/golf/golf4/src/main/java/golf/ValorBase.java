package golf;

import golf.impressao.ImpressaoPadraoStrategy;
import golf.impressao.ImpressaoStrategy;

public abstract class ValorBase implements Cloneable {
	/**
	 * Variavel que armazena, em decimal, o valor do objeto.
	 */
	protected int valor;

	/**
	 * Variavel que armazena o objeto para a impressao.
	 */
	protected ImpressaoStrategy impressao;

	/**
	 * Construtor padrao.
	 */
	public ValorBase() {
		impressao = new ImpressaoPadraoStrategy();
		valor = 0;
	}

	/**
	 * Construtor com o valor em decimal sendo passado como parametro.
	 * 
	 * @param novo
	 *            valor em decimal.
	 */
	public ValorBase(int novo) {
		impressao = new ImpressaoPadraoStrategy();
		valor = novo;
	}

	public abstract ValorBase modoHexa();

	public abstract ValorBase modoDec();

	public abstract ValorBase modoBin();

	public abstract void modoInteiro();

	public abstract void modoComplexo();

	public abstract Complexo instanciarComplexo();

	// public abstract void somarTudo (ValorBase atual);
	public abstract ValorBase instanciarEngenharia();

	/**
	 * Limpa o valor.
	 */
	public abstract String limparValor();

	/**
	 * Adiciona um digito.
	 */
	public abstract String adicionarDigito(String digito,
			ImpressaoStrategy modo, ImpressaoStrategy modoImpressao);

	/**
	 * Funcao que clona o elemento.
	 * 
	 * @return Retorna o objeto Valor clonado.
	 */
	public abstract Object clone();

	/**
	 * O operador chama o visitor.
	 * 
	 * @param visitor
	 *            visitor.
	 * @param acumulador
	 *            .
	 */
	public abstract ValorBase aceitarVisita(Visitor visitor, Valor acumulador);

	/**
	 * O operador chama o visitor.
	 * 
	 * @param visitor
	 *            visitor.
	 * @param acumulador
	 *            .
	 */
	public abstract ValorBase aceitarVisita(Visitor visitor, Complexo acumulador);

	/**
	 * O operador chama o visitor.
	 * 
	 * @param visitor
	 *            visitor.
	 * @param acumulador
	 *            .
	 */
	public abstract ValorBase aceitarVisita(Visitor visitor,
			Engenharia acumulador);

	/**
	 * Converte o valor em string.
	 * 
	 * @return retorna o valor convertido em String.
	 */
	public abstract String converterEmString();

	/**
	 * Altera o valor armazenado.
	 * 
	 * @param novo
	 *            valor em formato String.
	 */
	public void setValor(String novo) {
		valor = Integer.parseInt(novo);
	}

	/**
	 * Altera o valor armazenado.
	 * 
	 * @param novo
	 *            valor em decimal.
	 */
	public void setValor(int novo) {
		valor = novo;
	}

	/**
	 * Retorna o valor.
	 * 
	 * @return retorna o valor armazenado.
	 */
	public int getValor() {
		return valor;
	}

	public void setImpressao(ImpressaoStrategy impNova) {
		impressao = impNova;
	}

	/**
	 * Soma o valor do objeto passado como parametro com o seu valor.
	 * 
	 * @param valor
	 *            a ser somado.
	 */
	public abstract ValorBase somar(ValorBase objOp2);

	public abstract void impressaoBin();

	public abstract void impressaoHexa();

	public abstract void impressaoDec();

	public abstract ImpressaoStrategy getModoImpressao();

}
