package golf;



/**
 * The test class ExponentNumTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExponentNumTest extends junit.framework.TestCase{
    /**
     * Default constructor for test class ExponentNumTest
     */
    public ExponentNumTest(){
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
     * Testa se ao entrar um o valor � N1
     */
	public void testEntra1(){
		golf.ExponentNum exponent1 = new golf.ExponentNum();
		exponent1.entraUm(0);
		assertEquals("N1", exponent1.writeNum());
	}

    /**
     * Testa se ao entrar um duas vezes o valor em bin�rio � N1011
     */
	public void testEntra11EMostraBin(){
		golf.ExponentNum exponent1 = new golf.ExponentNum();
		exponent1.entraUm(0);
		exponent1.entraUm(0);
		exponent1.modoBin();
		assertEquals("N1011", exponent1.writeNum());
	}

    /**
     * Testa se ao entrar um tres vezes o valor em hexadecimal � N6f
     */
	public void testEntra111EMostraHex(){
		golf.ExponentNum exponent1 = new golf.ExponentNum();
		exponent1.entraUm(0);
		exponent1.entraUm(0);
		exponent1.entraUm(0);
		exponent1.modoHex();
		assertEquals("N6f", exponent1.writeNum());
	}
}