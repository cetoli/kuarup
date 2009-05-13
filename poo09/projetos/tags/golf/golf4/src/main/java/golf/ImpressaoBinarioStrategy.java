package golf;

public class ImpressaoBinarioStrategy implements ImpressaoStrategy {

    public String imprimir(ValorBase valor) {
	return "0b" + Integer.toBinaryString(valor.getValor());
    }

    public ImpressaoStrategy modoBinario() {
	return this; // new ImpressaoBinarioStrategy();
    }

    public ImpressaoStrategy modoDecimal() {
	return new ImpressaoDecimalStrategy();
    }

    public ImpressaoStrategy modoHexadecimal() {
	return new ImpressaoHexadecimalStrategy();
    }

    public String impressaoValor(ValorBase valor) {
	return Integer.toBinaryString(valor.getValor());
    }

    public void adicionarDigito(ValorBase valor, String digito) {
	String str = impressaoValor(valor);

	str += digito;

	valor.setValor(Integer.parseInt(str, 2));

    }

    public Object clone() throws CloneNotSupportedException {
	return new ImpressaoBinarioStrategy();
    }
}
