package golf;



/**
 * The test class ComplexNumTest.
 * @author  Gustavo Taveira
 * @version 2.0 28/04/2009 Gustavo Taveira
 */
public class ComplexNumTest extends junit.framework.TestCase{
    /**
     * Default constructor for test class ComplexNumTest
     */
    public ComplexNumTest(){
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
		golf.ComplexNum complexN1 = new golf.ComplexNum();
		complexN1.entraUm();
		assertEquals("I1", complexN1.writeNum());
	}

    /**
     * Testa se ao entrar um duas vezes o valor em bin‡rio Ž I0b1011
     */
	public void testEntra11EMostraBinario(){
		golf.ComplexNum complexN1 = new golf.ComplexNum();
		complexN1.entraUm();
		complexN1.entraUm();
		complexN1.modoBin();
		assertEquals("I0b1011", complexN1.writeNum());
	}

    /**
     * Testa se ao entrar um tres vezes o valor em hexadecimal Ž I0x6f
     */
	public void testEntra111EMostraHex(){
		golf.ComplexNum complexN1 = new golf.ComplexNum();
		complexN1.entraUm();
		complexN1.entraUm();
		complexN1.entraUm();
		complexN1.modoHex();
		assertEquals("I0x6f", complexN1.writeNum());
	}
}



