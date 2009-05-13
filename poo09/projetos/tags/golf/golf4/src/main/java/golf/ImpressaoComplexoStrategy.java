package golf;

public class ImpressaoComplexoStrategy implements ImpressaoStrategy {

    public String imprimir(ValorBase valor) {
	Complexo c = (Complexo) valor;

	String strInt = c.getValorInteiro().impressao.imprimir(c
		.getValorInteiro());
	String strCompl = c.getValorComplexo().impressao.imprimir(c
		.getValorComplexo());

	return strInt + "I" + strCompl;
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
	Complexo c = (Complexo) valor;
	c.getValorComplexo().adicionarDigito(digito,
		c.getValorComplexo().impressao, c.getValorComplexo().impressao);

    }

    public Object clone() throws CloneNotSupportedException {
	return new ImpressaoComplexoStrategy();
    }

}
