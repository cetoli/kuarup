package golf.impressao;

import golf.ValorBase;

public interface ImpressaoStrategy extends Cloneable {
	public String imprimir(ValorBase valor);

	public String impressaoValor(ValorBase valor);

	public ImpressaoStrategy modoHexadecimal();

	public ImpressaoStrategy modoBinario();

	public ImpressaoStrategy modoDecimal();

	public void adicionarDigito(ValorBase valor, String digito);

	public Object clone() throws CloneNotSupportedException;
}
