package golf;

/**
 * The test class NumeroBinTest.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class NumeroBinTest extends junit.framework.TestCase {
	/**
	 * Default constructor for test class NumeroBinTest
	 */
	public NumeroBinTest() {
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
	 * Converte valor = 1.
	 * 
	 */
	public void testSaidaSeUm() {
		golf.NumeroBin numeroBi1 = new golf.NumeroBin(1);
		assertEquals("1", numeroBi1.converte());
	}

	/**
	 * Converte valor = 2.
	 * 
	 */
	public void testSaidaSeDois() {
		golf.NumeroBin numeroBi1 = new golf.NumeroBin(2);
		assertEquals("10", numeroBi1.converte());
	}

	/**
	 * Converte valor = 5.
	 * 
	 */
	public void testSaidaSeCinco() {
		golf.NumeroBin numeroBi1 = new golf.NumeroBin(5);
		assertEquals("101", numeroBi1.converte());
	}

	/**
	 * Converte valor = 10.
	 * 
	 */
	public void testSaidaSeDez() {
		golf.NumeroBin numeroBi1 = new golf.NumeroBin(10);
		assertEquals("1010", numeroBi1.converte());
	}
}
