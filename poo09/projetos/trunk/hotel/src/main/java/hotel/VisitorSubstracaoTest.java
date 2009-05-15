package hotel;

import junit.framework.TestCase;

public class VisitorSubstracaoTest extends TestCase {
    public void testeSubtracaoBasico() {
	Valor valor1 = new Valor(10);
	Valor valor2 = new Valor(5);

	ValorBase resultado = valor1.subtrair(valor2);
	assertEquals("5", resultado.converterEmString());
    }

    public void testeSubtracaoBasicoHexa() {
	Valor valor1 = new Valor(11);
	Valor valor2 = new Valor();

	ImpressaoStrategy impressao = new ImpressaoHexadecimalStrategy();
	valor2.adicionarDigito("1", impressao, impressao);

	ValorBase resultado = valor1.subtrair(valor2);
	assertEquals("0xa", resultado.converterEmString());
    }

    public void testeSubtracaoBasicoBin() {
	Valor valor1 = new Valor(10);
	Valor valor2 = new Valor();

	ImpressaoStrategy impressao = new ImpressaoBinarioStrategy();
	valor2.adicionarDigito("1", impressao, impressao);

	ValorBase resultado = valor1.subtrair(valor2);
	assertEquals("0b1001", resultado.converterEmString());
    }

    public void testeSubtracaoComplexo() {
	// 10I11.
	Valor valor1 = new Valor(10);
	Complexo c1 = new Complexo(valor1);
	ImpressaoStrategy impressao = new ImpressaoPadraoStrategy();
	c1.adicionarDigito("1", impressao, impressao);
	c1.adicionarDigito("1", impressao, impressao);

	// 5I1.
	Valor valor2 = new Valor(5);
	Complexo c2 = new Complexo(valor2);
	c2.adicionarDigito("1", impressao, impressao);

	ValorBase resultado = c1.subtrair(c2);
	assertEquals("5I10", resultado.converterEmString());
    }

    public void testeSubtracaoEngenharia() {
	// 10N2.
	Valor valor1 = new Valor(10);
	Engenharia e1 = new Engenharia(valor1);
	ImpressaoStrategy impressao = new ImpressaoPadraoStrategy();
	e1.adicionarDigito("1", impressao, impressao);

	// 5N1.
	Valor valor2 = new Valor(5);
	Engenharia e2 = new Engenharia(valor2);
	e2.adicionarDigito("1", impressao, impressao);

	ValorBase resultado = e1.subtrair(e2);
	assertEquals("5N1", resultado.converterEmString());
    }

    /*
         * public void testeSubtracaoEngenhariaComplexo() { // 10I2. Valor
         * valor1 = new Valor(10); Complexo c1 = new Complexo(valor1);
         * ImpressaoStrategy impressao = new ImpressaoPadraoStrategy();
         * c1.adicionarDigito("1", impressao, impressao);
         * c1.adicionarDigito("1", impressao, impressao); // 5N1. Valor valor2 =
         * new Valor(5); Engenharia e2 = new Engenharia(valor2);
         * e2.adicionarDigito("1", impressao, impressao);
         * 
         * ValorBase resultado = c1.subtrair(e2); assertEquals("-4N1I10",
         * resultado.converterEmString()); }
         */

    public void testeSubtracaoVetorValor() {
	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();

	// 10I1V1.
	Valor valor = new Valor(10);
	Complexo c = new Complexo(valor);
	c.adicionarDigito("1", impressao, impressao);

	Vetor v = new Vetor(c);

	v.adicionarDigito("1", impressao, impressao);

	// 3.
	Valor vOperador = new Valor(3);

	ValorBase resultado = v.subtrair(vOperador);
	assertEquals("7I1V-2", resultado.converterEmString());
    }

    public void testeSubtracaoVetorEngenharia() {
	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();

	Valor valor = new Valor(10);
	Complexo c = new Complexo(valor);
	c.adicionarDigito("1", impressao, impressao);

	Vetor v = new Vetor(c);

	v.adicionarDigito("1", impressao, impressao);

	Valor vOperador = new Valor(3);

	ValorBase resultado = v.subtrair(vOperador);
	assertEquals("7I1V-2", resultado.converterEmString());
    }

    public void testeSubtracaoVetorComplexo() {
	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();

	Valor valor = new Valor(10);
	Complexo c = new Complexo(valor);
	c.adicionarDigito("1", impressao, impressao);

	Vetor v = new Vetor(c);

	v.adicionarDigito("1", impressao, impressao);

	Valor vOperador = new Valor(3);

	ValorBase resultado = v.subtrair(vOperador);
	assertEquals("7I1V-2", resultado.converterEmString());
    }

    /**
         * Teste: subtrair 11N1 V11N1 I1N1 de 30 -> 8N1V8N1I-2N1.
         */
    public void testeSubtracaoCompleto() {
	ImpressaoStrategy impressao = new ImpressaoDecimalStrategy();

	// 11N1 V11N1 I1N1
	ValorBase valor = new Valor(11);
	Engenharia e1 = new Engenharia(valor);
	e1.adicionarDigito("1", impressao, impressao);

	Vetor v = new Vetor(e1);

	// valor = new Valor(11);
	v.adicionarDigito("1", impressao, impressao);
	v.adicionarDigito("1", impressao, impressao);

	v.instanciarEngenharia();
	v.adicionarDigito("1", impressao, impressao);
	// Engenharia e2 = new Engenharia(valor);
	// e2.adicionarDigito("1", impressao, impressao);

	/*
         * Complexo c = new Complexo(e2); c.adicionarDigito("1", impressao,
         * impressao); valor = c.instanciarEngenharia(); c.adicionarDigito("1",
         * impressao, impressao);
         * 
         * v.setVetor(c);
         */
	v.instanciarComplexo();
	v.adicionarDigito("1", impressao, impressao);
	v.instanciarEngenharia();
	v.adicionarDigito("1", impressao, impressao);

	// 30.
	Valor vOperador = new Valor(30);

	ValorBase resultado = v.subtrair(vOperador);
	assertEquals("8N1V8N1I-2N1", resultado.converterEmString());

    }
}
