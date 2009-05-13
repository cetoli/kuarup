package golf;

public class ImpressaoHexadecimalStrategy implements ImpressaoStrategy {

    public String imprimir(ValorBase valor) {
	return "0x" + Integer.toHexString(valor.getValor());
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
	return Integer.toHexString(valor.getValor());
    }

    public void adicionarDigito(ValorBase valor, String digito) {
	String str = impressaoValor(valor);

	str += digito;

	valor.setValor(Integer.parseInt(str, 16));

    }

    public Object clone() throws CloneNotSupportedException {
	return new ImpressaoHexadecimalStrategy();
    }
}
