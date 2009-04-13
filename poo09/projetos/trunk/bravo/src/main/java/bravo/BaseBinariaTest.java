package bravo;



/**
 * The test class BaseBinariaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BaseBinariaTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class BaseBinariaTest
     */
    public BaseBinariaTest()
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

	public void testPassandoUmRetornaStringUm()
	{
		bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
		assertEquals("1", baseBina1.converterBase(1));
	}

	public void testPassandoOnzeRetornaStringMileOnze()
	{
		bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
		assertEquals("1011", baseBina1.converterBase(11));
	}


	public void testPassandoCentoeOnzeRetorna1101111()
	{
		bravo.BaseBinaria baseBina1 = new bravo.BaseBinaria();
		assertEquals("1101111", baseBina1.converterBase(111));
	}
}




