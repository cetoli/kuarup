package golf.num;




/**
 * The test class ImaginarioNumTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ImaginarioTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class ImaginarioNumTest
     */
    public ImaginarioTest()
    {
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
     * Testa se ao entrar um duas vezes o valor em bin‡rio Ž 0b1011
     */
	public void testEntra1(){
		golf.num.Imaginario imaginario1 = new golf.num.Imaginario();
		imaginario1.entraUm();
		assertEquals("I1", imaginario1.writeNum());
	}

    /**
     * Testa se ao entrar um duas vezes o valor em bin‡rio Ž I0b1011
     */
	public void testEntra11EMostraBinario(){
		golf.num.Imaginario imaginario1 = new golf.num.Imaginario();
		imaginario1.entraUm();
		imaginario1.entraUm();
		imaginario1.modoBin();
		assertEquals("I0b1011", imaginario1.writeNum());
	}

    /**
     * Testa se ao entrar um tres vezes o valor em hexadecimal Ž I0x6f
     */
	public void testEntra111EMostraHex(){
		golf.num.Imaginario imaginario1 = new golf.num.Imaginario();
		imaginario1.entraUm();
		imaginario1.entraUm();
		imaginario1.entraUm();
		imaginario1.modoHex();
		assertEquals("I0x6f", imaginario1.writeNum());
	}
}
