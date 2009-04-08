package golf;



/**
 * The test class NumeroHexTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumeroHexTest extends junit.framework.TestCase{
    /**
     * Default constructor for test class NumeroHexTest
     */
    public NumeroHexTest(){
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
		golf.NumeroHex numeroHe1 = new golf.NumeroHex(1);
		assertEquals("1", numeroHe1.converte());
	}

    /**
     * Converte valor = 2.
     *
     */
	public void testSaidaSeDois(){
		golf.NumeroHex numeroHe1 = new golf.NumeroHex(2);
		assertEquals("2", numeroHe1.converte());
	}

    /**
     * Converte valor = 5.
     *
     */
	public void testSaidaSeCinco(){
		golf.NumeroHex numeroHe1 = new golf.NumeroHex(5);
		assertEquals("5", numeroHe1.converte());
	}

    /**
     * Converte valor = 10.
     *
     */
	public void testSaidaSeDez(){
		golf.NumeroHex numeroHe1 = new golf.NumeroHex(10);
		assertEquals("A", numeroHe1.converte());
	}
}




