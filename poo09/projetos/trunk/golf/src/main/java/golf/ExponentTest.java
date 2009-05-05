package golf;



/**
 * The test class ExponentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExponentTest extends junit.framework.TestCase{
    /**
     * Default constructor for test class ExponentTest
     */
    public ExponentTest(){
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
     * Testa se ao entrar um o valor Ž N1
     */
	public void testEntra1(){
		golf.Exponent exponent1 = new golf.Exponent();
		exponent1.entraUm();
		assertEquals("N1", exponent1.writeNum());
	}

    /**
     * Testa se ao entrar um duas vezes o valor em bin‡rio Ž N1011
     */
	public void testEntra11EMostraBin(){
		golf.Exponent exponent1 = new golf.Exponent();
		exponent1.entraUm();
		exponent1.entraUm();
		exponent1.modoBin();
		assertEquals("N1011", exponent1.writeNum());
	}

    /**
     * Testa se ao entrar um tres vezes o valor em hexadecimal Ž N6f
     */
	public void testEntra111EMostraHex(){
		golf.Exponent exponent1 = new golf.Exponent();
		exponent1.entraUm();
		exponent1.entraUm();
		exponent1.entraUm();
		exponent1.modoHex();
		assertEquals("N6f", exponent1.writeNum());
	}
}