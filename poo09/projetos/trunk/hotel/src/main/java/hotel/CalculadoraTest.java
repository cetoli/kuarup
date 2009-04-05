package hotel;

/**
 * The test class CalculadoraTest.
 *
 * @author  (Alexandre Louzada & Marcio Reis)
 * @version (1.0)
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

    public void testLimpaDisplay()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        calculad1.entraUm();
        assertEquals("0", calculad1.limpa());
    }

    public void testeAcumulaDigitoUm()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("111", calculad1.entraUm());
        assertEquals("1111", calculad1.entraUm());
        assertEquals("11111", calculad1.entraUm());
        assertEquals("111111", calculad1.entraUm());
        assertEquals("1111111", calculad1.entraUm());
    }


    public void testSomaUmAPartirDoRepouso()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
    }

    public void testTeclaSomaAPartirDoRepouso()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("0", calculad1.comandoSoma());
    }
    
    public void testSomaVariosNumerosUm()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("2", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("3", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("4", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("5", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("6", calculad1.comandoSoma());
    }

    public void testSomaUmComDezena()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("1", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("12", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("13", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("14", calculad1.comandoSoma());
    }

    public void testSomaDezenaComDezena()
    {
        hotel.Calculadora calculad1 = new hotel.Calculadora();
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("11", calculad1.comandoSoma());
        assertEquals("1", calculad1.entraUm());
        assertEquals("11", calculad1.entraUm());
        assertEquals("22", calculad1.comandoSoma());
    }

	public void testEntraUmLimpaESoma()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("0", calculad1.limpa());
		assertEquals("0", calculad1.comandoSoma());
	}

	public void testLimpaAposEntrarOnze()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("0", calculad1.limpa());
	}

	public void testSomaDezenaConCentena()
	{
		hotel.Calculadora calculad1 = new hotel.Calculadora();
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("11", calculad1.comandoSoma());
		assertEquals("1", calculad1.entraUm());
		assertEquals("11", calculad1.entraUm());
		assertEquals("111", calculad1.entraUm());
		assertEquals("122", calculad1.comandoSoma());
	}
}












