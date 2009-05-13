package golf;

import golf.impressao.ImpressaoDecimalStrategy;

/**
 * Classe ValorTest para testar a classe Valor.
 * 
 * @author (Marcos de Castro) $Author$
 * @author (Rodrigo Santos Borges) $Author$
 * @version 1.0
 */
public class ValorTest extends junit.framework.TestCase {
	/**
	 * Default constructor for test class ValorTest.
	 */
	public ValorTest() {
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
	 * Testa a conversao de um valor decimal para o tipo do Valor. No caso, será
	 * decimal também. Suas subclasses é que terão retorno em formato diferente.
	 */
	public void testConversaoValorDecimal() {
		Valor valor1 = new Valor(40);
		assertEquals(40, valor1.getValor());
	}

	/**
	 * Testa o método de limpeza do valor.
	 */
	public void testLimparValor() {
		Valor valor1 = new Valor(21);
		assertEquals("0", valor1.limparValor());
		assertEquals(0, valor1.getValor());
	}

	/**
	 * Teste de insercao de digitos.
	 */
	public void testAdicionarDigito() {
		Valor valor1 = new Valor();
		ImpressaoDecimalStrategy imp = new ImpressaoDecimalStrategy();
		assertEquals("1", valor1.adicionarDigito("1", imp, imp));
		assertEquals("11", valor1.adicionarDigito("1", imp, imp));
		assertEquals("111", valor1.adicionarDigito("1", imp, imp));
	}

	/**
	 * testa o método setValor e a conversao que este faz para a representacao
	 * escolhida.
	 */
	public void testSetValor() {
		Valor valor1 = new Valor();
		valor1.setValor("11");
		assertEquals(11, valor1.getValor());
	}

	/**
	 * Testa a conversao para String.
	 */
	public void testConverterEmString() {
		Valor valor1 = new Valor(1234);
		assertEquals("1234", valor1.converterEmString());
	}

	/**
	 * Testa a soma de 2 valores.
	 */
	public void testSomar() {
		Valor valor1 = new Valor(13);
		Valor valor2 = new Valor(12);
		ValorBase valor = valor1.somar(valor2);
		assertEquals("25", valor.converterEmString());
	}
}
