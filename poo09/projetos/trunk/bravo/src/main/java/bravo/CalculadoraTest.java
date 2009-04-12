package bravo;



/**
 * The test class CalculadoraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalculadoraTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class CalculadoraTest
     */
    public CalculadoraTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

	public void testSomaUmApatrirdoRepouso()
	{
		bravo.Calculadora c = new bravo.Calculadora();
		assertEquals("1", c.entraUm());
	}

	public void testSomaOnzeApartirDoRepouso()
	{
		bravo.Calculadora c = new bravo.Calculadora();
		c.entraUm();
		assertEquals("11", c.entraUm());
	}

	public void testLimpaRetornaZero()
	{
		bravo.Calculadora c = new bravo.Calculadora();
		assertEquals("0", c.limpa());
	}

	public void testRetornaCentoeOnzeApartirDoZero()
	{
		bravo.Calculadora c = new bravo.Calculadora();
		assertEquals("1", c.entraUm());
		assertEquals("11", c.entraUm());
		assertEquals("111", c.entraUm());
	}

	public void testUmMaisUm()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("2", calculad1.comandoSoma());
	}

	public void testUmMaisUmLimpar()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("0", calculad1.limpa());
	}

	public void testEntraUmLimpa()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("0", calculad1.limpa());
	}

	public void testSomaApartirDoRepousoRetornaZero()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("0", calculad1.comandoSoma());
	}

	public void testSomaUmMaisRetornaUm()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
	}

	public void testEntraUmComandoSomaValorAcumulador()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("11", calculad1.comandoSoma());
	}

	public void testComandoSomaDigitarUmSomar()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
	}

	public void testComandoSomaSomar11e1111()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("11", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("111", calculad1.entraUm());
		assertEquals("1111", calculad1.entraUm());
		assertEquals("1122", calculad1.comandoSoma());
	}

	public void testBaseHexadecimalUmMaisUm()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("2", calculad1.comandoSoma());
	}

	public void testBaseDecimalSomandoUmMaisUmRetornaDois()
	{
		bravo.Calculadora calculad1 = new bravo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		calculad1.modoDec();
		assertEquals("1", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("2", calculad1.comandoSoma());
	}
}















