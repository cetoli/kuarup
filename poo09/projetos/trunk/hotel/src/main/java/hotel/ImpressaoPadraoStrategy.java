package hotel;

public class ImpressaoPadraoStrategy implements ImpressaoStrategy {
    public String imprimir(ValorBase valor) {
	return Integer.toString(valor.getValor());
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
	String str = impressaoValor(valor);

	str += digito;

	valor.setValor(Integer.parseInt(str));
    }

    public Object clone() throws CloneNotSupportedException {
	return new ImpressaoPadraoStrategy();
    }
}
