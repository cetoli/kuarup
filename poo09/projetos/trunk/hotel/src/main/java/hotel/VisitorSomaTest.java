package hotel;

import junit.framework.TestCase;

public class VisitorSomaTest extends TestCase {

    public void testeBasico() {
	Valor valor1 = new Valor(10);
	Valor valor2 = new Valor(5);

	ValorBase resultado = valor1.somar(valor2);
	assertEquals("15", resultado.converterEmString());
    }

    public void testeBasicoHexa() {
	Valor valor1 = new Valor(10);
	Valor valor2 = new Valor();

	ImpressaoStrategy impressao = new ImpressaoHexadecimalStrategy();
	valor2.adicionarDigito("1", impressao, impressao);

	ValorBase resultado = valor1.somar(valor2);
	assertEquals("0xb", resultado.converterEmString());
    }

    public void testeBasicoBin() {
	Valor valor1 = new Valor(10);
	Valor valor2 = new Valor();

	ImpressaoStrategy impressao = new ImpressaoBinarioStrategy();
	valor2.adicionarDigito("1", impressao, impressao);

	ValorBase resultado = valor1.somar(valor2);
	assertEquals("0b1011", resultado.converterEmString());
    }

    public void testeSomaVetorComplexo() {
	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();

	// 10I1V1.
	Valor valor = new Valor(10);
	Complexo c = new Complexo(valor);
	c.adicionarDigito("1", impressao, impressao);

	Vetor v = new Vetor(c);
	v.adicionarDigito("1", impressao, impressao);

	// 3.
	Valor vOperador = new Valor(3);

	ValorBase resultado = v.somar(vOperador);
	assertEquals("13I1V4", resultado.converterEmString());
    }

    public void testeSomaBasicoVetor() {
	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();

	// 10V1.
	Valor valor = new Valor(10);
	Vetor v = new Vetor(valor);
	v.adicionarDigito("1", impressao, impressao);

	// 3.
	Valor vOperador = new Valor(3);

	ValorBase resultado = v.somar(vOperador);
	assertEquals("13V4", resultado.converterEmString());
    }

    public void testeSomaVetorEngenharia() {
	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();

	// 10E1V1.
	Valor valor = new Valor(10);
	Engenharia e = new Engenharia(valor);
	e.adicionarDigito("1", impressao, impressao);

	Vetor v = new Vetor(e);
	v.adicionarDigito("1", impressao, impressao);

	// 3.
	Valor vOperador = new Valor(30);

	ValorBase resultado = v.somar(vOperador);
	assertEquals("13N1V31", resultado.converterEmString());
    }

}
