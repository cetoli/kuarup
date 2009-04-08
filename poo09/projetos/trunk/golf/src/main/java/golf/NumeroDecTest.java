package golf;



/**
 * The test class NumeroDecTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumeroDecTest extends junit.framework.TestCase{
    /**
     * Default constructor for test class NumeroDecTest
     */
    public NumeroDecTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp(){
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown(){
    }

    /**
     * Converte valor = 1.
     *
     */
	public void testSaidaSeUm(){
		golf.NumeroDec numeroDe1 = new golf.NumeroDec(1);
		assertEquals("1", numeroDe1.converte());
	}

    /**
     * Converte valor = 2.
     *
     */
	public void testSaidaSeDois(){
		golf.NumeroDec numeroDe1 = new golf.NumeroDec(2);
		assertEquals("2", numeroDe1.converte());
	}

    /**
     * Converte valor = 5.
     *
     */
	public void testSaidaSeCinco(){
		golf.NumeroDec numeroDe1 = new golf.NumeroDec(5);
		assertEquals("5", numeroDe1.converte());
	}

    /**
     * Converte valor = 10.
     *
     */
	public void testSaidaSeDez(){
		golf.NumeroDec numeroDe1 = new golf.NumeroDec(10);
		assertEquals("10", numeroDe1.converte());
	}
}




