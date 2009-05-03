package golf;



/**
 * The test class RealNumTest.
 * @author  Gustavo Taveira
 * @version 2.0 28/04/2009 Gustavo Taveira
 */
public class RealNumTest extends junit.framework.TestCase{

    /**
     * Default constructor for test class RealNumTest
     */
    public RealNumTest(){
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
     * Testa se ao entrar um duas vezes o valor = 11
     */
	public void testEntra11(){
		golf.RealNum realNum1 = new golf.RealNum();
		realNum1.entraUm(0);
		realNum1.entraUm(0);
		assertEquals("11", realNum1.writeNum());
	}

    /**
     * Testa se ao entrar um duas vezes o valor em bin‡rio Ž 0b1011
     */
	public void testEntra11EMostraBinario(){
		golf.RealNum realNum1 = new golf.RealNum();
		realNum1.entraUm(0);
		realNum1.entraUm(0);
		realNum1.modoBin();
		assertEquals("0b1011", realNum1.writeNum());
	}

    /**
     * Testa se ao entrar um tres vezes o valor em hexadecimal Ž 0x6f
     */
	public void testEntra111EMostraHexa(){
		golf.RealNum realNum1 = new golf.RealNum();
		realNum1.entraUm(0);
		realNum1.entraUm(0);
		realNum1.entraUm(0);
		realNum1.modoHex();
		assertEquals("0x6f", realNum1.writeNum());
	}
}



