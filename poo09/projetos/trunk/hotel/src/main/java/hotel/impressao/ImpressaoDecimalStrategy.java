package hotel;

public class ImpressaoDecimalStrategy implements ImpressaoStrategy {

    public String imprimir(ValorBase valor) {
	return valor.toString();
    }

    public ImpressaoStrategy modoBinario() {
	return new ImpressaoBinarioStrategy();
    }

    public ImpressaoStrategy modoDecimal() {
	return new ImpressaoDecimalStrategy();
    }

    public ImpressaoStrategy modoHexadecimal() {
	return new ImpressaoHexadecimalStrategy();
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
	return new ImpressaoDecimalStrategy();
    }
}
