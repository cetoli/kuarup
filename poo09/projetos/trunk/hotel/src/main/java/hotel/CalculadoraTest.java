package hotel;



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
	}
}


