package golf;

/**
 * Classe de teste da classe Calculadora.
 * 
 * @author (Marcos de Castro) $Author$
 * @author (Rodrigo Santos Borges) $Author$
 * @version (1.0) $Revision$ (01/04/09) $Date$
 */

public class CalculadoraTest extends junit.framework.TestCase {
	/**
	 * constructor Padrao.
	 */
	public CalculadoraTest() {
	}

	/**
	 * Sets up the test fixture.
	 * 
	 * Called before every test case method.
	 */
	protected void setUp() {
	}

	/**
	 * Tears down the test fixture.
	 * 
	 * Called after every test case method.
	 */
	protected void tearDown() {
	}

	/**
	 * Digita 1 vez o numero 1 e depois soma. Resultado= 1.
	 */
	public void testSomaUmApartirDoRepouso() {
		Calculadora calculad1 = new Calculadora();
		calculad1.entraUm();
		assertEquals("1", calculad1.comandoSoma());
	}

	/**
	 * Digita o numero 11 e depois soma. Resultado= 11.
	 */
	public void testTesteOnze() {
		Calculadora calculad1 = new Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("11", calculad1.comandoSoma());
	}

	/**
	 * Digita 11, soma, 11 e soma. Resultado= 22.
	 */
	public void testTest11E11() {
		Calculadora calculad1 = new Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("11", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("22", calculad1.comandoSoma());
	}

	/**
	 * Digita 1, soma, manda limpar, 1 e soma. Resultado= 1.
	 */
	public void testLimpa() {
		Calculadora calculad1 = new Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
		assertEquals("0", calculad1.limpa());
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
	}

	/**
	 * Digita 11, soma, 111 e soma. Resultado= 122.
	 */
	public void test11E111() {
		Calculadora calculad1 = new Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("11", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("111", calculad1.entraUm());
		assertEquals("122", calculad1.comandoSoma());
	}

	/**
	 * Digita 1, soma, 1, soma, 1 e soma. Resultado= 3.
	 */
	public void testVariasEntradas() {
		Calculadora calculad1 = new Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("2", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("3", calculad1.comandoSoma());
	}

	/* Teste do trabalho 2 */

	/**
	 * Botao de cimal: Digita 1, soma. Resultado= 1.
	 */
	public void testSomaUmApartirDoRepousoDec() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoDec();
		calculad1.entraUm();
		assertEquals("1", calculad1.comandoSoma());
	}

	/**
	 * Botao decimal: Digita 11, soma. Botao decimal: Digita 11, soma.
	 * Resultado= 22.
	 */
	public void testTest11E11Dec() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoDec();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("11", calculad1.comandoSoma());
		calculad1.modoDec();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("22", calculad1.comandoSoma());
	}

	/**
	 * Botao decimal: Digita 11, soma. Botao binario: Digita 11, soma.
	 * Resultado= 1110.
	 */
	public void test11DecE11Bin() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoDec();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("11", calculad1.comandoSoma());
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b11", calculad1.entraUm());

		assertEquals("0b1110", calculad1.comandoSoma());
	}

	/**
	 * Botao binario: Digita 11, soma. Botao decimal: Digita 11, soma.
	 * Resultado= 14.
	 */
	public void test11BinE11Dec() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b11", calculad1.entraUm());
		assertEquals("0b11", calculad1.comandoSoma());
		calculad1.modoDec();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("14", calculad1.comandoSoma());
	}

	/**
	 * Botao decimal: Digita 11, soma. Botao hexadecimal: Digita 11, soma.
	 * Resultado= 1c.
	 */
	public void test11DecE11Hex() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoDec();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("11", calculad1.comandoSoma());
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x11", calculad1.entraUm());
		assertEquals("0x1c", calculad1.comandoSoma());
	}

	/**
	 * Botao hexadecimal: Digita 11, soma. Botao decimal: Digita 11, soma.
	 * Resultado= 28.
	 */
	public void test11HexE11Dec() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x11", calculad1.entraUm());
		assertEquals("0x11", calculad1.comandoSoma());
		calculad1.modoDec();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("28", calculad1.comandoSoma());
	}

	/**
	 * Botao binario: Digita 11, soma. Botao hexadecimal: Digita 11, soma.
	 * Resultado= 14.
	 */
	public void test11BinE11Hex() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b11", calculad1.entraUm());
		assertEquals("0b11", calculad1.comandoSoma());
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x11", calculad1.entraUm());
		assertEquals("0x14", calculad1.comandoSoma());
	}

	/**
	 * Botao hexadecimal: Digita 11, soma. Botao binario: Digita 11, soma.
	 * Resultado= 10100.
	 */
	public void test11HexE11Bin() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x11", calculad1.entraUm());
		assertEquals("0x11", calculad1.comandoSoma());
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b11", calculad1.entraUm());
		assertEquals("0b10100", calculad1.comandoSoma());
	}

	/**
	 * Botao binario: Digita 11, soma. Botao binario: Digita 11, soma.
	 * Resultado= 110.
	 */
	public void test11BinE11Bin() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b11", calculad1.entraUm());
		assertEquals("0b11", calculad1.comandoSoma());
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b11", calculad1.entraUm());
		assertEquals("0b110", calculad1.comandoSoma());
	}

	/**
	 * Botao binario: Digita 11, soma, Digita 11, soma. Resultado= 110.
	 */
	public void test11BinE11() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b11", calculad1.entraUm());
		assertEquals("0b11", calculad1.comandoSoma());

		assertEquals("0b1", calculad1.entraUm());
		assertEquals("0b11", calculad1.entraUm());
		assertEquals("0b110", calculad1.comandoSoma());
	}

	/**
	 * Botao hexadecimal: Digita 11, soma. Botao hexadecimal: Digita 11, soma.
	 * Resultado= 22.
	 */
	public void test11HexE11Hex() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x11", calculad1.entraUm());
		assertEquals("0x11", calculad1.comandoSoma());
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x11", calculad1.entraUm());
		assertEquals("0x22", calculad1.comandoSoma());
	}

	/**
	 * Botao hexadecimal: Digita 11, soma, Digita 11, soma. Resultado= 22.
	 */
	public void test11HexE11() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoHex();
		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x11", calculad1.entraUm());
		assertEquals("0x11", calculad1.comandoSoma());

		assertEquals("0x1", calculad1.entraUm());
		assertEquals("0x11", calculad1.entraUm());
		assertEquals("0x22", calculad1.comandoSoma());
	}

	/**
	 * Botao hexadecimal: Digita 11, soma, Digita 11, soma. Resultado= 22.
	 */
	public void testEntraB1H1Sai0x11() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		// assertEquals("0b1", calculad1.comandoSoma());
		calculad1.modoHex();
		assertEquals("0x11", calculad1.entraUm());
		// assertEquals("0x11", calculad1.comandoSoma());
	}

	/**
	 * Botao hexadecimal: Digita 11, soma, Digita 11, soma. Resultado= 22.
	 */
	public void testEntraB1H1B1Sai0b100011() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		// assertEquals("0b1", calculad1.comandoSoma());
		calculad1.modoHex();
		assertEquals("0x11", calculad1.entraUm());
		// assertEquals("0x11", calculad1.comandoSoma());
		calculad1.modoBin();
		assertEquals("0b100011", calculad1.entraUm());
		// assertEquals("0b100011", calculad1.comandoSoma());
	}

	/**
	 * Botao hexadecimal: Digita 11, soma, Digita 11, soma. Resultado= 22.
	 */
	public void testEntraB1H1D1Sai171() {
		Calculadora calculad1 = new Calculadora();
		calculad1.modoBin();
		assertEquals("0b1", calculad1.entraUm());
		// assertEquals("0b1", calculad1.comandoSoma());
		calculad1.modoHex();
		assertEquals("0x11", calculad1.entraUm());
		// assertEquals("0x11", calculad1.comandoSoma());
		calculad1.modoDec();
		assertEquals("171", calculad1.entraUm());
		// assertEquals("171", calculad1.comandoSoma());
	}

	/**
	 * Teste: somar b11111id11+h111ib111+ -> 0b100110000I0b10010
	 */
	public void testeSoma0b11111ID11e0x111I0b111sai0b100110000I0b10010() { // 1
		Calculadora calculad2 = new Calculadora();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();

		calculad2.entraI();
		calculad2.modoDec();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();

		calculad2.entraI();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraUm();
		assertEquals("0b100110000I0b10010", calculad2.comandoSoma());
	}

	/**
	 * Teste: somar h11+Ib11+ -> 0b10001I0b11
	 */
	public void testeSoma0x11eI0b11sai0b10001I0b11() { // 2
		Calculadora calculad2 = new Calculadora();

		// h11
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraUm();

		calculad2.comandoSoma();

		// Ib11
		calculad2.entraI();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		assertEquals("0b10001I0b11", calculad2.comandoSoma());
	}

	/**
	 * Teste: somar 11id1+id1+ -> 11I2
	 */
	public void testeSomaD11ID1eID1sai11I2() {
		Calculadora calculad2 = new Calculadora();
		// 11ID1
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraI();
		calculad2.modoDec();
		calculad2.entraUm();

		calculad2.comandoSoma();
		// ID1
		calculad2.entraI();
		calculad2.modoDec();
		calculad2.entraUm();
		assertEquals("11I2", calculad2.comandoSoma());
	}

	/**
	 * Teste: somar 1i1+1+ -> 2I1
	 */
	public void testeSomaD1ID1eD1sai2I1() {
		Calculadora calculad2 = new Calculadora();
		calculad2.entraUm();

		// Modo I
		calculad2.entraI();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraUm();

		assertEquals("2I1", calculad2.comandoSoma());
	}

	/**
	 * Teste: somar Ib11+Ih11 -> 0x0I0x14
	 */
	public void testeSomaI0b11eI0x11sai0x0I0x14() { // 3
		Calculadora calculad2 = new Calculadora();
		calculad2.entraI();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.comandoSoma();
		calculad2.entraI();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraUm();
		assertEquals("0x0I0x14", calculad2.comandoSoma());
	}

	/*
	 * Teste Engenharia.
	 */

	/**
	 * Teste: entrar com o numero D1N1IB11 (1e1+0b11i) -> 0b1N1I0b11.
	 */
	public void testeEntraD1N1IB11sai0b1N1I0b11() {
		// entrar com o n�mero D1N1 IB11 (1e1+0b11i)

		Calculadora calculad2 = new Calculadora();

		// D1N1
		calculad2.modoDec();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.entraUm(); // n�o muda para binario.

		// IB11
		calculad2.entraI();
		calculad2.modoBin();
		calculad2.entraUm();
		assertEquals("0b1N1I0b11", calculad2.entraUm());

		// assertEquals("0b1N1I0b11",calculad2.comandoSoma());
	}

	/**
	 * Teste: entrar com o n�mero D1IB11N1 (1+0b11e1) -> 0b1I0b11N0b1.
	 */
	public void testeEntraD1IB11N1sai0b1I0b11N1() {
		// entrar com o n�mero D1 IB11N1 (1+0b11e1)

		Calculadora calculad2 = new Calculadora();

		// D1
		calculad2.modoDec();
		calculad2.entraUm();

		// IB11N1
		calculad2.entraI();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraN();
		assertEquals("0b1I0b11N1", calculad2.entraUm());

		// assertEquals("0b1I0b11N0b1",calculad2.comandoSoma());
	}

	/**
	 * Teste: entrar com o n�mero D1N11IH11N1 (1e11+ 0x11e1i) -> 0x1N11I0x11N1.
	 */
	public void testeEntraD1N11IH11N1sai0x1NBI0x11N1() { // 5
		// entrar com o n�mero D1N11 IH11N1 (1e11+ 0x11e1i)

		Calculadora calculad2 = new Calculadora();

		// D1N11
		calculad2.modoDec();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.entraUm(); // decimal
		calculad2.entraUm(); // decimal

		// IH11N1
		calculad2.entraI();
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraN();
		assertEquals("0x1N11I0x11N1", calculad2.entraUm()); // decimal

		// assertEquals("0x1N11I0x11N1",calculad2.comandoSoma());
	}

	/**
	 * Teste: entrar com o n�mero B1NB11IB11ND1 (0b1e0b11 + 0b11e1i) -> 1N3I3N1.
	 */
	public void testeEntraB1IB11sai1N3I3N1() {
		// entrar com o n�mero B1NB11 IB11ND1 (0b1e0b11 + 0b11e1i)

		Calculadora calculad2 = new Calculadora();

		// B1NB11
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();

		// IB11ND1
		calculad2.entraI();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.modoDec();
		assertEquals("1N3I3N1", calculad2.entraUm());

		// assertEquals("1N3I3N1",calculad2.comandoSoma());
	}

	/**
	 * Teste: Somar 1N1 mais 11N1 (1e1 + 11e1) -> 12N1.
	 */
	public void testeSoma1N1mais11N1sai12N1() {
		// Somar 1N1 mais 11N1 (1e1 + 11e1)

		Calculadora calculad2 = new Calculadora();

		// 1N1
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.entraUm();

		calculad2.comandoSoma();

		// 11N1
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.entraUm();

		assertEquals("12N1", calculad2.comandoSoma());
	}

	/**
	 * Teste: Somar 11NB11 mais B1NB11 (11e0b11 + 0b1e0b11) -> 0b1100N11.
	 */
	public void testeSoma11NB11maisB1NB11sai0b1100N11() { // 6
		// Somar 11NB11 mais B1NB11 (11e0b11 + 0b1e0b11)

		Calculadora calculad2 = new Calculadora();

		// 11NB11
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();

		calculad2.comandoSoma();

		// B1NB11
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();

		assertEquals("0b1100N11", calculad2.comandoSoma());
	}

	/**
	 * Teste: Somar 11N1 mais 1N11 (11e1 + 1e11) -> 1N11.
	 */
	public void testeSoma11N1mais1N11sai1N11() {
		// Somar 11N1 mais 1N11 (11e1 + 1e11)

		Calculadora calculad2 = new Calculadora();

		// 11N1
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.entraUm();

		calculad2.comandoSoma();

		// 1N11
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.entraUm();
		calculad2.entraUm();

		assertEquals("1N11", calculad2.comandoSoma());
	}

	/**
	 * Teste: Somar H1N1ID11N1 mais B11N11H (0x1e0x1+11e1i + 0b11e0b11) ->
	 * 0x3N3I0xBN1.
	 */
	public void testeSomaH1N1ID11N1maisB11N11Hsai0x3N3I0xBN1() { // 7
		// H1N1 ID11N1 mais B11N11H (0x1e0x1 + 11e1i + 0b11e0b11)

		Calculadora calculad2 = new Calculadora();

		// H1N1
		calculad2.modoHex();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.entraUm();
		calculad2.modoDec();
		calculad2.comandoSoma();

		// ID11N1
		calculad2.entraI();
		calculad2.modoDec();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.entraUm();

		calculad2.comandoSoma(); // calculou 0I0N1 e era 1N1 I 11N1

		// B11N11H
		calculad2.modoBin();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.entraN();
		calculad2.entraUm();
		calculad2.entraUm();
		calculad2.modoHex();

		assertEquals("0x3N3I0xbN1", calculad2.comandoSoma());
	}

	/*
	 * Testes vetoriais.
	 */

	/**
	 * Teste: entrar com o vetor D1N1VB11 (1e1,0b11i) -> 0b1N1V0b11.
	 */
	public void testeEntraD1N1VB11sai0b1N1V0b11() {
		// D1N1VB11
	}

	/**
	 * Teste: somar um ao vetor D1VB11I1 (1+[1,0b11+1i]) -> 0b10V0b100I1.
	 */
	public void testeSoma1aD1VB11I1sai0b10V0b100I1() {
		// 1

		// soma.

		// D1VB11I1
	}

	/**
	 * Teste: B11N1V11VD1V1I1 - 11 ([0b11e1,0b11,1,1+1i]-11) -> 1N1V-8V10V-10I1.
	 */
	public void testeSubtrai11deB11N1V11VD1V1I1sai1N1Vm8V10Vm10I1() {
		// B11N1V11VD1V1I1

		// subtra��o.

		// 11
	}

	/**
	 * Teste: subtrair 1N1 de D11N1VH11N1 ([11e1+ 0x11e1i]-1e1) -> 10N1V16N1.
	 */
	public void testeSubtrai1N1deD11N1VH11N1sai10N1V16N1() {
		// D11N1VH11N1

		// subtra��o.

		// 1N1
	}

}
