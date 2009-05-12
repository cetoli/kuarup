package bravo;

import junit.framework.TestCase;

public class VetorialTest extends TestCase {

	public void testSoma1aD1VB11I1() {
		Calculadora calculadora = new Calculadora();

		calculadora.entraUm();
		calculadora.comandoSoma();
		calculadora.entraUm();
		calculadora.entraV();
		calculadora.modoBin();
		calculadora.entraUm();
		calculadora.entraUm();
		calculadora.entraI();
		calculadora.entraUm();
		calculadora.comandoSoma();
	}

	public void testSubtrai1N1deD11N1VH11N1() {
		Calculadora calculadora = new Calculadora();

		calculadora.entraUm();
		calculadora.entraUm();
		calculadora.entraN();
		calculadora.entraUm();
		calculadora.entraV();
		calculadora.modoHex();
		calculadora.entraUm();
		calculadora.entraUm();
		calculadora.entraN();
		calculadora.comandoSubtrai();
		calculadora.entraUm();
		calculadora.entraN();
		calculadora.entraUm();

		String res = calculadora.comandoSubtrai();

		assertEquals("10N1V16N1", res);
	}

	public void testSubtrai1N1deD11N1VH11N1Correto() {
		Calculadora calculadora = new Calculadora();

		calculadora.entraUm();
		calculadora.entraUm();
		calculadora.entraN();
		calculadora.entraUm();
		calculadora.entraV();
		calculadora.modoHex();
		calculadora.entraUm();
		calculadora.entraUm();
		calculadora.entraN();
		calculadora.entraUm();
		calculadora.comandoSubtrai();
		calculadora.modoDec();
		calculadora.entraUm();
		calculadora.entraN();
		calculadora.entraUm();

		String res = calculadora.comandoSubtrai();

		assertEquals("10N1V16N1", res);
	}

	public void testSubtrai11deB11N1V11VD1V1I1() {
		Calculadora calculadora = new Calculadora();
		calculadora.modoBin();
		System.out.println(calculadora.entraUm());
		System.out.println(calculadora.entraUm());
		calculadora.entraN();
		System.out.println(calculadora.entraUm());
		calculadora.entraV();
		System.out.println(calculadora.entraUm());
		System.out.println(calculadora.entraUm());
		calculadora.modoDec();
		calculadora.entraV();
		System.out.println(calculadora.entraUm());
		calculadora.entraV();
		System.out.println(calculadora.entraUm());
		calculadora.entraI();
		System.out.println(calculadora.entraUm());
		System.out.println(calculadora.comandoSubtrai());
		System.out.println(calculadora.entraUm());
		System.out.println(calculadora.entraUm());

		String res = calculadora.comandoSoma();
		System.out.println(res);

		assertEquals("1N1V-8V-10V-10I1", res);
	}
}