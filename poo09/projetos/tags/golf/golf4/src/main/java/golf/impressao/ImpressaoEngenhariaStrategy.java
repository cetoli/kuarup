package golf.impressao;

import golf.Engenharia;
import golf.ValorBase;

public class ImpressaoEngenhariaStrategy implements ImpressaoStrategy {

	public String imprimir(ValorBase valor) {
		Engenharia e = (Engenharia) valor;

		ValorBase vMant = e.getValorMantissa();
		ValorBase vExp = e.getValorExpoente();

		String strMant = vMant.getModoImpressao()
				.imprimir(e.getValorMantissa());
		String strExp = vExp.getModoImpressao().imprimir(e.getValorExpoente());
		strExp = strExp.replaceFirst("0x", "");
		strExp = strExp.replaceFirst("0b", "");

		return strMant + "N" + strExp;
	}

	public ImpressaoStrategy modoBinario() {
		return this;
	}

	public ImpressaoStrategy modoDecimal() {
		return this;
	}

	public ImpressaoStrategy modoHexadecimal() {
		return this;
	}

	public String impressaoValor(ValorBase valor) {
		return imprimir(valor);
	}

	public void adicionarDigito(ValorBase valor, String digito) {
		Engenharia c = (Engenharia) valor;
		c.getValorExpoente().adicionarDigito(digito,
				c.getValorExpoente().getModoImpressao(),
				c.getValorExpoente().getModoImpressao());
	}

	public Object clone() throws CloneNotSupportedException {
		return new ImpressaoEngenhariaStrategy();
	}
}
