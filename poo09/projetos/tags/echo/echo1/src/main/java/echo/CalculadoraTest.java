package echo;



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

	public void testSomaUmApartirDoRepouso()
	{
		echo.Calculadora calculad1 = new echo.Calculadora();
		calculad1.entraUm();
		assertEquals("1", calculad1.comandoSoma());
	}

	public void testTesteOnze()
	{
		echo.Calculadora calculad1 = new echo.Calculadora();
		calculad1.entraUm();
		calculad1.entraUm();
		assertEquals("11", calculad1.comandoSoma());
	}

	public void testTest11E11()
	{
		echo.Calculadora calculad1 = new echo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("11", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("22", calculad1.comandoSoma());
	}

	public void testLimpa()
	{
		echo.Calculadora calculad1 = new echo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
		assertEquals("0", calculad1.limpa());
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
	}

	public void test11E111()
	{
		echo.Calculadora calculad1 = new echo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("11", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("111", calculad1.entraUm());
		assertEquals("122", calculad1.comandoSoma());
	}

	public void testVariasEntradas()
	{
		echo.Calculadora calculad1 = new echo.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("1", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("2", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("3", calculad1.comandoSoma());
	}
}






