package hotel;

public class ImpressaoVetorStrategy implements ImpressaoStrategy {

    public void adicionarDigito(ValorBase valor, String digito) {
	Vetor v = (Vetor) valor;

	v.adicionarDigito(digito, v.getModoImpressao(), v.getModoImpressao());
    }

    public String imprimir(ValorBase valor) {
	Vetor v = (Vetor) valor;
	String strEscalar = v.getEscalar().impressao.imprimir(v.getEscalar());
	String strvetor = v.getVetor().impressao.imprimir(v.getVetor());

	return strEscalar + "V" + strvetor;
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

    public Object clone() throws CloneNotSupportedException {
	return new ImpressaoVetorStrategy();
    }
}
