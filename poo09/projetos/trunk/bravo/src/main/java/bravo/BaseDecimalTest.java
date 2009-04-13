package bravo;



/**
 * The test class BaseDecimalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BaseDecimalTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class BaseDecimalTest
     */
    public BaseDecimalTest()
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


	public void testPassandoValorUmRetornaStringUm()
	{
		bravo.BaseDecimal baseDeci1 = new bravo.BaseDecimal();
		assertEquals("1", baseDeci1.converterBase(1));
	}

	public void testPassandoValorOnzeRetornaStringOnze()
	{
		bravo.BaseDecimal baseDeci1 = new bravo.BaseDecimal();
		assertEquals("11", baseDeci1.converterBase(11));
	}

	public void testTestePassandoValorCentoeOnzeRetornaCentoeOnze()
	{
		bravo.BaseDecimal baseDeci1 = new bravo.BaseDecimal();
		assertEquals("111", baseDeci1.converterBase(111));
	}
}




