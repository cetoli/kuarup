package golf.num;




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
     * Testa se ao entrar um o valor Ž 1
     */
	public void testEntra1(){
		golf.num.ComplexNum composit1 = new golf.num.ComplexNum();
		ComponentNum aux1 = new Real();
		composit1.addComponent(aux1);
		composit1.entraUm();
		assertEquals("1", composit1.writeNum());
	}

    /**
     * Testa se ao entrar um duas vezes o valor em bin‡rio Ž 0b1011
     */
	public void testEntra11EMostraBin(){
		golf.num.ComplexNum composit1 = new golf.num.ComplexNum();
		ComponentNum aux1 = new Real();
		composit1.addComponent(aux1);
		composit1.entraUm();
		composit1.entraUm();
		composit1.modoBin();
		assertEquals("0b1011", composit1.writeNum());
	}

    /**
     * Testa se ao entrar um tres vezes o valor em hexadecimal Ž 0x6f
     */
	public void testEntra111EMostraHex(){
		golf.num.ComplexNum composit1 = new golf.num.ComplexNum();
		ComponentNum aux1 = new Real();
		composit1.addComponent(aux1);
		composit1.entraUm();
		composit1.entraUm();
		composit1.entraUm();
		composit1.modoHex();
		assertEquals("0x6f", composit1.writeNum());
	}

    /**
     * Testa se ao entrar "1I1" o valor Ž "1I1"
     */
	public void testEntra1I1(){
		golf.num.ComplexNum composit1 = new golf.num.ComplexNum();
		ComponentNum aux1 = new Real();
		composit1.addComponent(aux1);
		composit1.entraUm();
		ComponentNum aux2 = new Imaginario();
		composit1.addComponent(aux2);
		composit1.entraUm();
		assertEquals("1I1", composit1.writeNum());
	}

    /**
     * Testa se ao entrar "11I11B" o valor Ž "0b1011I0b1011"
     */
	public void testEntra11I11EMostraBin(){
		golf.num.ComplexNum composit1 = new golf.num.ComplexNum();
		ComponentNum aux1 = new Real();
		composit1.addComponent(aux1);
		composit1.entraUm();
		composit1.entraUm();
		ComponentNum aux2 = new Imaginario();
		composit1.addComponent(aux2);
		composit1.entraUm();
		composit1.entraUm();
		composit1.modoBin();
		assertEquals("0b1011I0b1011", composit1.writeNum());
	}

    /**
     * Testa se ao entrar "111I111H" o valor Ž "0x6fI0x6f"
     */
	public void testEntra111I111EMostraHex(){
		golf.num.ComplexNum composit1 = new golf.num.ComplexNum();
		ComponentNum aux1 = new Real();
		composit1.addComponent(aux1);
		composit1.entraUm();
		composit1.entraUm();
		composit1.entraUm();
		ComponentNum aux2 = new Imaginario();
		composit1.addComponent(aux2);
		composit1.entraUm();
		composit1.entraUm();
		composit1.entraUm();
		composit1.modoHex();
		assertEquals("0x6fI0x6f", composit1.writeNum());
	}
}



