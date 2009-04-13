package bravo;



/**
 * The test class BaseHexadecimalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BaseHexadecimalTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class BaseHexadecimalTest
     */
    public BaseHexadecimalTest()
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

	public void testePassandoUmRotornaStringUm()
	{
		bravo.BaseHexadecimal baseHexa1 = new bravo.BaseHexadecimal();
		assertEquals("1", baseHexa1.converterBase(1));
	}

	public void testPassandoOnzeRetornaStringB()
	{
		bravo.BaseHexadecimal baseHexa1 = new bravo.BaseHexadecimal();
		assertEquals("b", baseHexa1.converterBase(11));
	}

	public void testEntraDozeRetornaC()
	{
		bravo.BaseHexadecimal baseHexa1 = new bravo.BaseHexadecimal();
		assertEquals("c", baseHexa1.converterBase(12));
	}
}



